import java.util.Random;

public class ex12 {
    public static void main(String[] args) {
        //조건문
        // * 자바스크립트 문법과 거의 동일
        //1. 단일 if문
        //패턴
        // if ( 조건절-비교,논리 연산자 ) {
        //    true일때 수행문
        // }
        if (10 < 20) {
            System.out.println("10이 20보다 작음");
        }
        if (10 < 20) //실행문이 한줄일때 중괄호 생략가능
            System.out.println("10이 20보다 작음");
        //2. if else문
        if (10 > 20) {
            System.out.println("10>20");
        } else {
            System.out.println("10<=20");
        }
        if (10 > 20)
            System.out.println("10>20");
        else
            System.out.println("10<=20");
        //3. if else if문
        int score = 90;
        if (score == 90) {
            System.out.println("90");
        } else if (score == 80) {
            System.out.println("80");
        } else {
            System.out.println("그외의 수");
        }
        //4. 중첩 if문
        if (true) { //조건1
            if (false) { //조건2
                //조건1이고(AND) 조건2이다.
            } else if (true) { //조건3
                //조건1이고 조건2는 아니고, 조건 3이다.
            }
        }
        //자바에서 랜덤수 발생
        //1. Math.random()  0.0 ~ 0.99999...
        //2. Random 클래스
        //   rand.netxInt(6) 0 ~ 5 까지의 랜덤 정수 발생

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                System.out.println("i,j:" + i + "," + j);
            }
        }


        //연습문제
        //1.
        //철수와 영희가 주사위 놀이를 하고 있다.
        // 주사위 2개를 던져서,
        // 두개 다 짝수가 나오면 철수 승!
        // 두개 다 홀수가 나오면, 영희 승!
        // 그외의 경우는 무승부! 이다.
        // 게임의 결과를 출력하시오.
        Random rand = new Random();
        int dice1 = rand.nextInt(6) + 1;
        int dice2 = rand.nextInt(6) + 1;
        System.out.println(dice1);
        System.out.println(dice2);
        if (dice1 % 2 == 0 && dice2 % 2 == 0) {
            System.out.println("철수 승!");
        } else if (dice1 % 2 == 1 && dice2 % 2 == 1) {
            System.out.println("영희 승!");
        } else {
            System.out.println("무승부!");
        }
        System.out.println();
        //2.
        //철수와 영희을 주사위게임을 하고 있다.
        //주사위 2개를 철수가 던지고,
        //주사위 2개를 영희도 던진다.
        //게임룰 : 첫번째 주사위는 십의 자릿수로하고,
        //        두번째 주사위는 일의 자릿수로 해서,
        // 더 높은 점수를 가진 사람이 승리한다.
        //출력값 예시 :
        //        철수 주사위1 수 : 1
        //        철수 주사위2 수 : 3
        //        철수의 점수는 13
        //        영희 주사위1 수 : 3
        //        영희 주사위2 수 : 4
        //        영희의 점수는 34
        //        영희 승!
        int dice3 = rand.nextInt(6) + 1;
        int dice4 = rand.nextInt(6) + 1;
        System.out.println(dice3 + "," + dice4);
        int score1 = dice3 * 10 + dice4;
        int dice5 = rand.nextInt(6) + 1;
        int dice6 = rand.nextInt(6) + 1;
        System.out.println(dice5 + "," + dice6);
        int score2 = dice5 * 10 + dice6;
        if( score1 > score2 ) {
            System.out.println("철수 승");
        }
        else if( score1 < score2 ) {
            System.out.println("영희 승");
        }
        else {
            System.out.println("무승부");
        }

    } //main함수
} //클래스
