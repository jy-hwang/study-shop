package org.example.studyshop.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

  // api 통신 시간
  private LocalDateTime transactionTime;

  // api 응답 코드
  private String resultCode;

  // api 부가 설명
  private String description;

  private T data;

  // OK
  public static <T> Header<T> OK() {
    return Header.<T>builder()
        .transactionTime(LocalDateTime.now())
        .resultCode("OK")
        .description("OK")
        .build();
  }


  public static <T> Header<T> OK(T data) {
    // DATA OK
    return Header.<T>builder()
        .transactionTime(LocalDateTime.now())
        .resultCode("OK")
        .description("OK")
        .data(data)
        .build();
  }

  // ERROR
  public static <T> Header<T> ERROR(String description) {
    return Header.<T>builder()
        .transactionTime(LocalDateTime.now())
        .resultCode("ERROR")
        .description(description)
        .build();
  }
}
