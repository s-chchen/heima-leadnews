public class test {

    public static void main(String[] args) {
        int a = 258;
        String s = Integer.toHexString(a);
        System.out.println(s);

        System.out.println((byte) a);
        byte b = (byte) a;

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += (byte) (a >> (i * 8));
        }
        System.out.println(sum);
    }

}
