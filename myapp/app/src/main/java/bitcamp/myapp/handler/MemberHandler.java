package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static Member[] members = new Member[MAX_SIZE];
  // static int[] no = new int[MAX_SIZE];
  // static String[] name = new String[MAX_SIZE];
  // static String[] email = new String[MAX_SIZE];
  // static String[] password = new String[MAX_SIZE];
  // static char[] gender = new char[MAX_SIZE];
  static int userId = 1;
  static int length = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void inputMember() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();
    m.setName(Prompt.inputString("이름? "));
    m.setEmail(Prompt.inputString("이메일? "));
    m.setPassword(Prompt.inputString("암호? "));
    m.setGender(inputGender((char) 0));

    m.setNo(userId++);

    // 위에서 만든 Member 인스턴스의 주소를 잃어버리지 않게
    // 레퍼런스 배열에 담는다.
    members[length++] = m;

    // length++;
  }

  public static void printMembers() {
    System.out.println("---------------------------");

    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("-------------------------------");

    for (int i = 0; i < length; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          toGenderString(m.getGender()));
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("번호? ");
    // 입력 받은 번호를 가지고 배열에서 해당 회원을 찾아야 한다.
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        // i 번째 항목에 저장된 회원 정보 출력
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("이메일: %s\n", m.getEmail());
        System.out.printf("성별: %s\n", toGenderString(m.getGender()));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static void updateMember() {
    String memberNo = Prompt.inputString("번호? ");
    // 입력 받은 번호를 가지고 배열에서 해당 회원을 찾아야 한다.
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        // i 번째 항목에 저장된 회원 정보 출력
        System.out.printf("이름(%s)? ", m.getName());
        m.setName(Prompt.inputString(""));
        System.out.printf("이메일(%s) ", m.getEmail());
        m.setEmail(Prompt.inputString(""));
        System.out.printf("새암호? ");
        m.setPassword(Prompt.inputString(""));
        m.setGender(inputGender(m.getGender()));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  private static char inputGender(char gender) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    while (true) {
      String menuNo = Prompt.inputString(label + "  1. 남자\n" + "  2. 여자\n" + "> ");

      switch (menuNo) {
        case "1":
          return MALE;
        case "2":
          return FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  public static String toGenderString(char Gen) {
    return Gen == 'M' ? "남성" : "여성";
    // if (Gen == 'M') {
    // return "남성";
    // } else {
    // return "여성";
    // }
  }

  public static void deleteMember() {

    int memberNo = Prompt.inputInt("번호? ");

    int deletedIndex = indexOf(memberNo);

    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      members[i] = members[i + 1];
      // no[i] = no[i + 1];
      // name[i] = name[i + 1];
      // email[i] = email[i + 1];
      // password[i] = password[i + 1];
      // gender[i] = gender[i + 1];
    }
    members[--length] = null;
    // no[length - 1] = 0;
    // name[length - 1] = null;
    // email[length - 1] = null;
    // password[length - 1] = null;
    // gender[length - 1] = (char) 0;

    // length--;
  }

  private static int indexOf(int memberNo) {
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}
// String memberNo = Prompt.inputString("번호? ");
// // 입력 받은 번호를 가지고 배열에서 해당 회원을 찾아야 한다.
// for (int i = 0; i < length; i++) {
// if (no[i] == Integer.parseInt(memberNo) && i == length - 1) {
// no[i] = 0;
// } else if (no[i] == Integer.parseInt(memberNo)) {
// for (i = 0; i < length; i++) {
// if (i >= Integer.parseInt(memberNo)) {
// no[i] = no[i - 1];
// }
// }
// } else {
// System.out.println("무효한 번호입니다.");
// }
// }
// length--;

// String str = Prompt.inputString("번호? ");
// int number = Integer.parseInt(str) - 1;
// if (length < number) {
// System.out.println("해당 번호의 회원이 없습니다!");
// return;
// } else {
// for (int i = 0; i < length;) {
// if (no[i] == number) {
// String oldname = name[i];
// String oldemail = email[i];
// char oldgender = gender[i];

// name[i] = Prompt.inputString("이름(" + oldname + ")? ");
// email[i] = Prompt.inputString("이메일(" + oldemail + ")? ");
// password[i] = Prompt.inputString("새암호? ");

// loop: while (true) {
// String menuNo = Prompt.inputString("성별(" + toGenderString(oldgender) + ")?\n"
// +
// " 1. 남자\n" +
// " 2. 여자\n" +
// "> ");

// switch (menuNo) {
// case "1":
// gender[i] = MALE;
// break loop;
// case "2":
// gender[i] = FEMALE;
// break loop;
// default:
// System.out.println("무효한 번호입니다.");
// }
// }
// }
// return;
// }
// }
