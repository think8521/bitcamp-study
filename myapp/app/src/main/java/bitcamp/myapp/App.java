package bitcamp.myapp;


import bitcamp.myapp.handler.BoardHandler;
import bitcamp.myapp.handler.Handler;
import bitcamp.myapp.handler.MemberHandler;
import bitcamp.util.Prompt;


// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.

public class App {
  public static void main(String[] args) {

    // 기본 생성자를 이용해 Prompt 인스턴스를 준비한다.
    // => 기본 생성자는 Scanner를 키보드와 연결한다.
    Prompt prompt = new Prompt();

    // 모든 핸들러는 Handler 규칙에 따라 정의되었기 때문에
    // Handler 레퍼런스에 그 주소를 담을 수 있다.
    Handler memberHandler = new MemberHandler(prompt, "회원");
    Handler boardHandler = new BoardHandler(prompt, "게시글");
    Handler readingHandler = new BoardHandler(prompt, "독서록");


    printTitle();

    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("0")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        memberHandler.execute();
      } else if (menuNo.equals("2")) {
        boardHandler.execute();
      } else if (menuNo.equals("3")) {
        readingHandler.execute();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }

    // MemberHandler.printMembers();

    prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 회원");
    System.out.println("2. 게시글");
    System.out.println("3. 독서록");
    System.out.println("0. 종료");
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("-------------------------------");
  }

  // static boolean promptContinue() {
  // String response = Prompt.inputString("계속 하시겠습니까?(Y/n) ");
  // if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
  // return false;
  // }
  // return true;
  // }

}
