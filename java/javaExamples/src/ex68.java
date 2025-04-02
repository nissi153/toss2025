import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ex68 {
    public static void main(String[] args) {
        //스택과 큐
        //스택(Stack) : LIFO(Last In First Out)
        //           : 맨 나중에 들어간 요소가 맨 처음에 나온다.
        //           : 사용예) 함수 호출시 주로 사용하는 구조
        //큐(Queue) : FIFO(First In First Out)
        //           : 맨 처음 들어간 요소가 맨 처음에 나온다.
        //          : 사용예)버퍼(Buffer) -
        //             입력속도와 출력속도가 다른 경우에 완충역활을 한다.
        //             프린터의 버퍼를 생각하면 됨.
        Stack<Integer> stack = new Stack<>();
        stack.push( 10 );
        stack.push( 20 );
        stack.push( 30 );
        System.out.println( stack );
        stack.pop();
        System.out.println( stack );
        System.out.println( stack.peek() ); //최상단의 값을 반환
        System.out.println( stack.size() );
        System.out.println( stack.contains(10) );
        System.out.println( stack.empty() );//비어있는가?

        Queue<Integer> queue = new LinkedList<>();
        queue.add( 10 );
        queue.add( 20 );
        queue.add( 30 );
        queue.offer( 40 );
        System.out.println( queue );
        System.out.println( queue.poll() ); //제일 먼저 들어간 값을 제거, 그 값을 반환
        System.out.println( queue );
        System.out.println( queue.peek() ); //맨첫번째 값을 반환, 제거안됨.
        System.out.println( queue );
        System.out.println( queue.size() );
    }
}
