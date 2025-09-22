import java.util.*;

public class RouterTEE {
    private class Packet {
        int source;
        int destination;
        int timestamp;

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        public int[] packetToArray (Packet packet) {
            return new int[]{packet.source, packet.destination, packet.timestamp};
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Packet packet = (Packet) o;
            return timestamp == packet.timestamp &&
                    source == packet.source &&
                    destination == packet.destination;
        }
    }

    int memoryLimit;
    int currentMemory;
    // Stack of all Packets (sorted by FIFO)
    Queue<Packet> packets = new ArrayDeque<>();

    // Map destination to Packet (sorted by timestamp)
    Map<Integer, TreeSet<Packet>> destinationToPackets = new HashMap<>();

    // Comparator for the TreeSet
    private Comparator<Packet> comp = Comparator
            .comparingInt((Packet p) -> p.timestamp)
            .thenComparingInt(p -> p.source)
            .thenComparingInt(p -> p.destination); // lower timestamp

    public RouterTEE(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        currentMemory = 0;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);

        if(packets.contains(packet)) {
            return false;
        } else {
            if(memoryLimit == currentMemory) {
                forwardPacket();
            }

            destinationToPackets.putIfAbsent(destination, new TreeSet<>(comp));
            destinationToPackets.get(destination).add(packet);
            packets.add(packet);

            currentMemory++;
            return true;
        }
    }

    public int[] forwardPacket() {
        if(currentMemory == 0) return new int[]{};
        else {
            Packet packet = packets.poll();
            destinationToPackets.get(packet.destination).remove(packet);
            currentMemory--;
            return packet.packetToArray(packet);
        }
    }

    public int getCount(int destination, int startTime, int endTime) {
        TreeSet<Packet> packetInDestination = destinationToPackets.get(destination);
        int count = 0;
        for (Packet p: packetInDestination) {
            if(p.timestamp >= startTime && p.timestamp <=endTime) count++;
            if(p.timestamp > endTime) break;
        }
        return count;
    }
}