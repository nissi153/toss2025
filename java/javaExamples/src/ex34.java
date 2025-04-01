//클래스->객체타입의 배열
class Snack {
    String name = "새우깡";
    int price = 1000;
    public Snack(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
public class ex34 {
    public static void main(String[] args) {
        //타입[] 배열이름 = new 타입[개수];
        int[] nums = new int[5];
        //클래스도 하나의 타입으로 생각한다.
        Snack[] snacks = new Snack[5];
        snacks[0] = new Snack("짱구", 2000);
        snacks[1] = new Snack("포카칩", 3000);
        snacks[2] = new Snack("허니버터칩", 4000);
        snacks[3] = new Snack("프링글스", 5000);
        snacks[4] = new Snack("엄마손쿠키", 6000);

        for( Snack snack : snacks ){
            System.out.println(snack.name);
            System.out.println(snack.price);
        }

    }
}
