public class ex10 {
    public static void main(String[] args) {

        System.out.println("sout");
        int i = 10;
        System.out.println("i = " + i);

        myFunc( 20 );

        for ( i =  0; i < 5; i++) {
            System.out.println(i);
        }

        int[] array = { };
        if (array == null) {

        }

    }
    static void myFunc(int p) {
        System.out.println("ex10.myFunc");
        System.out.println("p = " + p);

    }
}
