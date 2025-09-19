public class Main {
    public static void main(String[] args) {
        String cell = "A10";
        String letter = String.valueOf(cell.charAt(0));
        int row = Integer.parseInt(cell.substring(1));

        System.out.println(letter + "," + row);
    }
}