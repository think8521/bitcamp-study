package coding.ex001;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

public class Test2 {

  public static void main(String[] args) {

    Map<Character, Integer> result = new HashMap<>();


    // BiFunction<T,U,R> 인터페이스
    // => R apply(T, U);
    //
    // Map.put(키, 값)
    // => 키: Character
    // => 값: Integer
    // => 예) put('x', 100);
    //
    // Map.compute(키, 값을 리턴할 객체);
    // => 키 : K
    // => 값을 리턴할 객체 : BiFunction<? super K, ? super V, ? extends V>
    // => 예) compute('x', BiFunctuion 구현 객체);
    //

    class MyValue implements BiFunction<Character, Integer, Integer> {
      @Override
      public Integer apply(Character key, Integer value) {
        // 이 메서드는 Map.compute()가 호출한다.
        // 파라미터로 넘어오는 것은 기존에 저장된 key와 value이다.
        // 해당 key의 값이 없다면 null이 넘어온다.
        return (value == null) ? 1 : value + 1;
      }
    }

    MyValue 값생성기 = new MyValue();

    String str = "Be strong, be fearless, be beautiful. "
        + "And believe that anything is possible when you have the right "
        + "people there to support you. ";

    for (char ch : str.toCharArray()) {
      result.compute(ch, 값생성기);

      // result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);}
    }

    for (Entry<Character, Integer> entry : result.entrySet()) {
      System.out.printf("%c: %d\n", entry.getKey(), entry.getValue());
    }



  }
}
