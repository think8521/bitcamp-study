package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

// MamberHandler는 Handler 규칙에 따라 메서드를 구현했다.
// 즉 Handler 인터페이스에 선언된 메서드를 모두 정의했다.
public class MemberListListener extends AbstractMemberListener {

  public MemberListListener(List list) {
    super(list);
  }

  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------");

    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          toGenderString(m.getGender()));
    }
  }
}

