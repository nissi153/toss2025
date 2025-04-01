import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//테스트 방법
//1. 서버 소켓을 먼저 실행함.
//2. 클라 소켓을 나중에 실행함.

public class ex58_server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket();
            serverSocket.bind(
                    new InetSocketAddress("localhost", 5001) );
            while( true ){
                System.out.println("서버가 연결을 기다리는 중...");
                Socket socket = serverSocket.accept(); //Blocking..대기중..
                InetSocketAddress isa =
                        (InetSocketAddress)socket.getRemoteSocketAddress();
                System.out.println("서버가 연결을 수락함:"+isa.getHostName());

                //클라이언트 데이타를 수신한다.
                byte[] bytes = null;
                String message = null;
                InputStream is = socket.getInputStream();
                bytes = new byte[1024]; //1024바이트만큼 버퍼메모리 생성
                int readByteCount = is.read(bytes);
                message = new String(bytes, 0, readByteCount, "UTF-8");
                System.out.println("서버가 데이타받기 성공함.");
                System.out.println("서버가 받은 데이타:"+message);

                //서버에서 클라로 데이타 보내기
                OutputStream os = socket.getOutputStream();
                message = "Hi~ This is Server~";
                bytes = message.getBytes("UTF-8");
                os.write(bytes);
                os.flush(); //버퍼에 있는 데이타 밀어내기
                System.out.println("서버가 클라에게 데이타보내기 성공");

                is.close();
                os.close();
                socket.close();
                if(message.equals("exit")){ //"exit"문자열이면 서버 종료!
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("서버 초기화 에러!");
        }
    }
}
