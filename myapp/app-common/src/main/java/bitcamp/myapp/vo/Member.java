package bitcamp.myapp.vo;

import java.io.Serializable;

public class Member implements Serializable, CsvObject, AutoIncrement {
  private static final long serialVersionUID = 1L;

  // 모든 인스턴스가 공유하는 값은 스태틱 필드에 보관한다.
  public static int userId = 1;

  // 상수는 스태틱 필드로 정의한다.
  // 정보를 다룰 떄는 그 정보를 갖고 있는 클래스에 그 기능을 둔다.
  // 필드도 마찬가지다.
  // => GRASP 패턴: Information Expert
  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  // 인스턴스 필드는 각각 개별적으로 유지해야 하는 값을 저장할 때 사용한다.
  // new 명령을 통해 변수를 Heap 영역에 생성한다.
  private int no;
  private String name;
  private String email;
  private String password;
  private char gender;

  public Member() {};

  public Member(int no) {
    this.no = no;
  }

  public static Member fromCsv(String csv) {
    String[] values = csv.split(",");

    Member member = new Member(Integer.parseInt(values[0]));
    member.setName(values[1]);
    member.setEmail(values[2]);
    member.setName(values[3]);
    member.setGender(values[4].charAt(0));

    if (Member.userId <= member.getNo()) {
      Member.userId = member.getNo() + 1;
    }

    return member;
  }

  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%c", this.getNo(), this.getName(), this.getEmail(),
        this.getPassword(), this.getGender());
  }

  @Override
  public void updateKey() {
    if (Member.userId <= this.no) {
      Member.userId = this.no + 1;
    }
  }


  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    // 위 조건에서 this가 가리키는 인스턴스의 클래스와
    // 파라미터 obj가 가리키는 인스턴스의 클래스가
    // 같다고 결론이 났기 때문에 다음과 같이
    // obj를 Member 타입으로 형변환한다.
    Member m = (Member) obj;

    if (this.getNo() != m.getNo()) {
      return false;
    }

    // if (this.getName() != null && !this.getName().equals(m.getName())) {
    // return false;
    // }
    //
    // if (this.getEmail() != null && !this.getEmail().equals(m.getEmail())) {
    // return false;
    // }
    //
    // if (this.getPassword() != null && !this.getPassword().equals(m.getPassword())) {
    // return false;
    // }
    //
    // if (this.getGender() != m.getGender()) {
    // return false;
    // }

    return true;
  }

  // 겟터/셋터는 인스턴스 필드의 값을 설정하고 꺼내는 메서드다.
  // 보통 외부에서 직접 필드에 접근하는 것을 막았을 때 사용한다.
  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }



}

