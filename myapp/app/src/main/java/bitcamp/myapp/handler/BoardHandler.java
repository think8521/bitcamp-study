package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardHandler {

  static final int MAX_SIZE = 100;
  static Board[] boards = new Board[MAX_SIZE];


  static int length = 0;



  public static void inputBoard() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Board board = new Board();
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setPassword(Prompt.inputString("암호? "));

    boards[length++] = board;
  }

  public static void printBoards() {
    System.out.println("------------------------------------");

    System.out.println("번호, 제목, 작성자, 조회수, 등록일");
    System.out.println("------------------------------------");


    for (int i = 0; i < length; i++) {
      Board board = boards[i];

      // 게시글의 등록일 값을 가져와서 Date 인스턴스에 저장한다.
      // Date date = new Date(board.getCreatedDate());

      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td\n", board.getNo(), board.getTitle(),
          board.getWriter(), board.getViewCount(), board.getCreatedDate());
    }
  }

  public static void viewBoard() {
    String BoardNo = Prompt.inputString("번호? ");
    // 입력 받은 번호를 가지고 배열에서 해당 회원을 찾아야 한다.
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == Integer.parseInt(BoardNo)) {
        // i 번째 항목에 저장된 회원 정보 출력
        int view = board.getViewCount();
        view++;
        board.setViewCount(view);
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("작성자: %s\n", board.getWriter());
        System.out.printf("조회수: %s\n", board.getViewCount());
        System.out.printf("등록일: %tY-%1$tm-%1$td\n", board.getCreatedDate());
        return;
      }
    }
    System.out.println("해당 번호의 게시글이 없습니다!");
  }

  public static void updateBoard() {
    String BoardNo = Prompt.inputString("번호? ");
    // 입력 받은 번호를 가지고 배열에서 해당 회원을 찾아야 한다.
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == Integer.parseInt(BoardNo)) {
        // i 번째 항목에 저장된 회원 정보 출력
        String BoardPassword = Prompt.inputString("암호? ");
        if (board.getPassword().equals(BoardPassword)) {
          System.out.printf("제목(%s)? ", board.getTitle());
          board.setTitle(Prompt.inputString(""));
          System.out.printf("내용(%s)? ", board.getContent());
          board.setContent(Prompt.inputString(""));
          return;
        } else {
          System.out.println("비밀번호가 틀렸습니다!");
          return;
        }
      }
    }
    System.out.println("해당 번호의 게시글이 없습니다!");
  }



  public static void deleteBoard() {

    int boardNo = Prompt.inputInt("번호? ");

    int deletedIndex = indexOf(boardNo);

    if (deletedIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      boards[i] = boards[i + 1];
      // no[i] = no[i + 1];
      // name[i] = name[i + 1];
      // email[i] = email[i + 1];
      // password[i] = password[i + 1];
      // gender[i] = gender[i + 1];
    }
    boards[--length] = null;
    // no[length - 1] = 0;
    // name[length - 1] = null;
    // email[length - 1] = null;
    // password[length - 1] = null;
    // gender[length - 1] = (char) 0;

    // length--;
  }

  private static int indexOf(int boardNo) {
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == boardNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}


