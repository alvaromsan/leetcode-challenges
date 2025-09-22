import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int memoryLimit = 4;

        Router router = new Router(memoryLimit);

        boolean p1 = router.addPacket(4,2,1);
        boolean p2 = router.addPacket(3,2,1);

        int p3 = router.getCount(2,1,1);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        /*
        boolean p1 = router.addPacket(1, 4, 90); // Packet is added. Return True.
        boolean p2 = router.addPacket(2, 5, 90); // Packet is added. Return True.
        boolean p3 = router.addPacket(1, 4, 90); // This is a duplicate packet. Return False.
        boolean p4 = router.addPacket(3, 5, 95); // Packet is added. Return True
        boolean p5 = router.addPacket(4, 5, 105); // Packet is added, [1, 4, 90] is removed as number of packets exceeds memoryLimit. Return True.

        int[] p6 = router.forwardPacket(); // Return [2, 5, 90] and remove it from router.
        boolean p7 = router.addPacket(5, 2, 110); // Packet is added. Return True.
        int p8 = router.getCount(5, 100, 110); // The only packet with destination 5 and timestamp in the inclusive range [100, 110] is [4, 5, 105]. Return 1.


        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(Arrays.toString(p6));
        System.out.println(p7);
        System.out.println(p8);
         */
    }
}