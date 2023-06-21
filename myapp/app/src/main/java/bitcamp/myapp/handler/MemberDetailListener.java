package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

// MamberHandler는 Handler 규칙에 따라 메서드를 구현했다.
// 즉 Handler 인터페이스에 선언된 메서드를 모두 정의했다.
public class MemberDetailListener extends AbstractMemberListener {

  public MemberDetailListener(List list) {
    super(list);
  }


  public void service(BreadcrumbPrompt prompt) {
    int memberNo = prompt.inputInt("번호? ");

    Member m = this.findBy(memberNo);
    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    System.out.printf("이름: %s\n", m.getName());
    System.out.printf("이메일: %s\n", m.getEmail());
    System.out.printf("성별: %s\n", toGenderString(m.getGender()));
  }
}

