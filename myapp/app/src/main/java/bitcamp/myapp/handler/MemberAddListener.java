package bitcamp.myapp.handler;

import java.util.List;
import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;

// MamberHandler는 Handler 규칙에 따라 메서드를 구현했다.
// 즉 Handler 인터페이스에 선언된 메서드를 모두 정의했다.
public class MemberAddListener extends AbstractMemberListener {

  public MemberAddListener(List<Member> list) {
    super(list);
  }


  public void service(BreadcrumbPrompt prompt) {
    Member m = new Member();
    m.setName(prompt.inputString("이름? "));
    m.setEmail(prompt.inputString("이메일? "));
    m.setPassword(prompt.inputString("암호? "));
    m.setGender(inputGender((char) 0, prompt));

    this.list.add(m);

  }
}

