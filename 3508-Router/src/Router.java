import java.util.*;

public class Router {

    private static class Packet {
        int source, destination, timestamp;

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        public int[] toArray() {
            return new int[]{source, destination, timestamp};
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Packet)) return false;
            Packet p = (Packet) o;
            return source == p.source && destination == p.destination && timestamp == p.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }

    private final int memoryLimit;
    private int currentMemory = 0;

    private final Queue<Packet> fifoQueue = new ArrayDeque<>();
    private final Set<Packet> packetSet = new HashSet<>();
    private final Map<Integer, List<Integer>> destinationTimestamps = new HashMap<>();

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);

        // O(1) duplicate check
        if (!packetSet.add(packet)) return false;

        if (currentMemory == memoryLimit) forwardPacket();

        fifoQueue.add(packet);

        destinationTimestamps.putIfAbsent(destination, new ArrayList<>());
        List<Integer> list = destinationTimestamps.get(destination);

        // Insert timestamp in sorted order
        int idx = Collections.binarySearch(list, timestamp);
        if (idx < 0) idx = -idx - 1;
        list.add(idx, timestamp);

        currentMemory++;
        return true;
    }

    public int[] forwardPacket() {
        if (currentMemory == 0) return new int[]{};

        Packet packet = fifoQueue.poll();
        packetSet.remove(packet);

        List<Integer> list = destinationTimestamps.get(packet.destination);
        int idx = Collections.binarySearch(list, packet.timestamp);
        if (idx >= 0) list.remove(idx);

        currentMemory--;
        return packet.toArray();
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list = destinationTimestamps.get(destination);
        if (list == null || list.isEmpty()) return 0;

        int left = lowerBound(list, startTime);
        int right = upperBound(list, endTime);
        return right - left;
    }

    // first index >= target
    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (list.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    // first index > target
    private int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (list.get(m) > target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
