// 객체 --> JSON 문자열 : Date 값을 yyyy-MM-dd 형식으로 출력하기
package com.eomcs.openapi.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Exam0220 {
  String jsonStr =
      "{\"no\":100,\"name\":\"홍길동\",\"email\":\"hong@test.com\",\"password\":\"1111\",\"photo\":\"hong.gif\",\"tel\":\"010-2222-1111\",\"registeredDate\":\"2023-07-03\"}";

  ObjectMapper mapper = new ObjectMapper();
  Member member = mapper.readValue(jsonStr, Member.class);

}
