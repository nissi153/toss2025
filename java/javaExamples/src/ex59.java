import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//성적관리 프로그램
//클래스 설계
class Student {
    String name;
    int kor;
    int eng;
    int math;
    //필드가 있는 생성자
    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}

public class ex59 {
    public static List<Student> scoreList =
            new ArrayList<Student>();
    public static void main(String[] args) {

        //ArrayList 관련 함수들 : 전체지우기, 추가, 삭제, 검색(직접 코드로)
        //5. 성적 관리 프로그램
        // ArrayList 클래스 객체 배열을 사용해보자.
        //입력 및 출력 예시
        //-----------성적 관리 프로그램-------------
        //1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 : 1
        //이름 입력 : 홍길동
        //국어점수 입력 : 70
        //영어점수 입력 : 80
        //수학점수 입력 : 90
        //-----------성적 관리 프로그램-------------
        //1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 : 2
        //이름: 홍길동 국어: 70 영어: 80 수학: 90 총점: 240 평균: 80.0
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println();
            System.out.println("-----성적 관리 프로그램-----");
            System.out.print("1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 : ");
            int menu = scanner.nextInt();
            if(menu == 1){ //입력
                System.out.print("이름 입력:");
                String name = scanner.next();
                System.out.print("국어점수 :");
                int kor = scanner.nextInt();
                System.out.print("영어점수 :");
                int eng = scanner.nextInt();
                System.out.print("수학점수 :");
                int math = scanner.nextInt();
                scoreList.add(new Student(name,kor,eng,math));
            }else if(menu == 2){ //출력
                //이름: 홍길동 국어: 70 영어: 80 수학: 90 총점: 240 평균: 80.0
                for(Student student : scoreList){
                    printInfo(student);
                    System.out.println();
                }
            }else if(menu == 3){ //검색
                System.out.print("검색할 사람의 이름 :");
                String searchWord = scanner.next();
                for(Student student : scoreList){
                    if(searchWord.equals(student.name)){
                        printInfo(student);
                    }
                }

            }else if(menu == 4){ //수정
                System.out.print("수정할 사람의 이름 :");
                String name = scanner.next();
                System.out.println();
                System.out.print("수정할 내용은? 1.국어 2.영어 3.수학 :");
                int no = scanner.nextInt();
                System.out.println();
                System.out.print("수정할 점수:");
                int score = scanner.nextInt();
                //검색
                String searchWord = name;
                int index = 0;
                for(Student student : scoreList){
                    if(searchWord.equals(student.name)){
                        if(no == 1){
                            student.kor = score;
                        }
                        else if(no == 2){
                            student.eng = score;
                        }else{
                            student.math = score;
                        }
                        //데이타의 수정, remove,insert
                        scoreList.set(index, student);
                        break;
                    }
                    index++;
                }

            }else if(menu == 5){ //삭제
                System.out.print("삭제할 사람의 이름 :");
                String name = scanner.next();
                //검색
                String searchWord = name;
                int index = 0;
                for(Student student : scoreList){
                    if(searchWord.equals(student.name)){
                        scoreList.remove(index);
                        break;
                    }
                    index++;
                }
            }else if(menu == 6){ //종료
                System.out.println("종료!!");
                break;
            }
        }

        scanner.close();

    }

    static void printInfo(Student student){
        System.out.print(" 이름: "+student.name);
        System.out.print(" 국어: "+student.kor);
        System.out.print(" 영어: "+student.eng);
        System.out.print(" 수학: "+student.math);
        int sum = student.kor + student.eng + student.math;
        double avr = sum / 3.0;
        System.out.print(" 총점: "+sum);
        System.out.print(" 평균: "+avr);
    }
}

