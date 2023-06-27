package bitcamp.myapp.handler;

import java.util.Iterator;
import java.util.List;
import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;

// MamberHandler는 Handler 규칙에 따라 메서드를 구현했다.
// 즉 Handler 인터페이스에 선언된 메서드를 모두 정의했다.
public class MemberListListener extends AbstractMemberListener {

  public MemberListListener(List<Member> list) {
    super(list);
  }

  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------");

    // 목록에서 데이터를 대신 꺼내주는 객체를 얻는다.
    Iterator<Member> iterator = list.iterator();
    while (iterator.hasNext()) {
      Member m = iterator.next();
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          toGenderString(m.getGender()));
    }
  }
}

