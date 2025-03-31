public class ex18 {
    public static void main(String[] args) {
        //2차배열
        //1.
        int[][] arrNum1 = new int[3][3]; //3행3열 정수형 2차배열
        //2.
        int[][] arrNum2 =
                new int[][]{ {10,20,30},
                             {40,50,60} }; //2행3열
        //3.
        int[][] arrNum3 = { {10,20,30},
                            {40,50,60} }; //2행3열
        //4.
        int[][] arrNum4 = new int[2][];
        arrNum4[0] = new int[3];
        arrNum4[1] = new int[3];

        //행의 길이
        System.out.println( arrNum2.length );
        //열의 길이
        System.out.println( arrNum2[0].length );
        System.out.println( arrNum2[1].length );
    }
}
