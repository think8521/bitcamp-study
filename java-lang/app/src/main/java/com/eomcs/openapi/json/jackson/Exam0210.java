// 객체 --> JSON 문자열 : Date 값을 yyyy-MM-dd 형식으로 출력하기
package com.eomcs.openapi.json.jackson;

import java.sql.Date;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Exam0210 {
  public static void main(String[] args) throws Exception {

    // 1) 객체 준비
    Member m1 = new Member();
    m1.setNo(101);
    m1.setName("홍길동");
    m1.setEmail("hong@test.com");
    m1.setRegisteredDate(new Date(System.currentTimeMillis()));

    ObjectMapper mapper = new ObjectMapper();
    String jsonStr = mapper.writeValueAsString(m1);
    mapper.

        System.out.println(jsonStr);
  }
}

// 다른 객체를 목록으로 포함했을 때 JSON 형식
// {
// 프로퍼티명 : 값,
// 프로퍼티명 : {프로퍼티명:값,프로퍼티명:값,...},
// 프로퍼티명 : [{...},{...},{...},...],
// ...
// }
//
