package bitcamp.myapp.vo;

public class Member {

  // 모든 인스턴스가 공유하는 값은 스태틱 필드에 보관한다.
  private static int userId = 1;

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

  // 생성자는 인스턴스를 생성한 후 필드를 초기화시키는 일을 한다.
  // 인스턴스를 사용할 떄 문제가 없도록 유효한 값으로 초기화시킨다.
  // 기본 생성자(default constructor)는 개발자가 생성자를 정의하지 않을 때
  // 컴파일러가 추가해주는 생성자다.
  // 물론 개발자가 직접 추가할 수도 있다.
  public Member() {
    this.no = userId++;
  }

  // 같은 기능을 수행하는 생성자가 위에 있다.
  // 다만 파라미터가 다를 뿐이다.
  // => "생성자 오버로딩(overloading)"
  public Member(int no) {
    this.no = no;
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

