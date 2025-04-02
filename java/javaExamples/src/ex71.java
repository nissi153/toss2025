public class ex71 {
    public static void main(String[] args) {
        //재귀함수 (Recursive Function)
        //   : 자기가 자기를 호출하는 함수
        System.out.println("메인함수 시작");
        myFunc();
        System.out.println("메인함수 종료");
        return;
    }//main
    static int count = 0;
    static void myFunc(){
        System.out.println("MyFunc 시작:"+count);
        count++;
        //탈출조건
        if(count > 2){
            count--;
            System.out.println("탈출1:count="+count);
            return;
        }
        myFunc();
        count--;
        System.out.println("탈출2:count="+count);
        return;
    }
}//class