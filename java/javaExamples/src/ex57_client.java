import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

//인터넷 통신
//1. TCP/IP(Socket통신) : 게임,채팅에 사용됨.
//      : 속도가 빠르다.
//      : 연결지향(한번 접속하면, 계속 연결이 지속됨.)
//      : 비공개 포트방식(Port : 컴퓨터에서 응용프로그램마다 가지는 통신창구)
//      : 공식포트 80 HTTP, 21 FTP, 443 HTTPS
//2. HTTP통신 : 대부분의 웹앱에서 사용됨.
//      : 공식포트 80이나 443포트만 이용, 내부망에서 8080,8090포트들이 사용됨.
//      : 웹브라우저 서버스 대응 용도에 사용됨.

//클라이언트(서비스를 제공받으면 클라) <--> 서버(서비스를 제공하면 서버)

public class ex57_client {
    public static void main(String[] args) {
        Socket socket = null;
        socket = new Socket();
        try {
            socket.connect(
                    //127.0.0.1 : 접속하려는 컴퓨터의 주소를 말함. localhost와 같은 말.
                    new InetSocketAddress("localhost", 5001)
            );
            System.out.println("서버 접속 성공!");

            //서버에 문자열형으로 데이타를 보내보자.
            byte[] bytes = null;
            String message = null;

            OutputStream os = socket.getOutputStream();
            message = "Hi! This is Client~";
            //UTF-8 : 문자인코딩(부호화,암호화) 타입
            //문자인코딩타입 : ASCII(영문), EUC-KR(완성형한글), UTF-8(유니코드-전세계문자)
            //             : cp949(ms949) 윈도우즈 한글 인코딩
            bytes = message.getBytes("UTF-8");
            os.write(bytes);
            os.flush(); //버퍼에 데이타를 다 내보낸다.
            System.out.println("데이타보내기 성공!");

            //서버로부터 데이터 받기
            InputStream is = socket.getInputStream();
            bytes = new byte[1024];
            int readByteCount = is.read(bytes);
            message = new String(bytes, 0, readByteCount, "UTF-8");
            System.out.println("데이타받기 성공:"+message);

            os.close();
            is.close();
        } catch (Exception e) {
            System.out.println("서버 접속 오류!");
        }
    }
}
