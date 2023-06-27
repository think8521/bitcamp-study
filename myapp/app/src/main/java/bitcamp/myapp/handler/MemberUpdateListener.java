package bitcamp.myapp.handler;

import java.util.List;
import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;

// MamberHandler는 Handler 규칙에 따라 메서드를 구현했다.
// 즉 Handler 인터페이스에 선언된 메서드를 모두 정의했다.
public class MemberUpdateListener extends AbstractMemberListener {

  public MemberUpdateListener(List<Member> list) {
    super(list);
  }

  public void service(BreadcrumbPrompt prompt) {
    int memberNo = prompt.inputInt("번호? ");

    Member m = this.findBy(memberNo);
    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    m.setName(prompt.inputString("이름(%s)? ", m.getName()));
    m.setEmail(prompt.inputString("이메일(%s) ", m.getEmail()));
    m.setPassword(prompt.inputString("새암호?"));
    m.setGender(inputGender(m.getGender(), prompt));
  }
}

