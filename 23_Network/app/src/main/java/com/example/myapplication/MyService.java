package com.example.myapplication;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

// retrofit에서 baseUrl의 뒷부분에 오는 페이지마다 변경되는 부분인 Service를 작성하기 위해
// interface 로 Service를 생성함
public interface MyService {

    // https://api.github.com/ 뒤의 붙는 users/{user}/repos 를 생성하는 어노테이션이다
    // { } 내부에 있는 것은 다른 내용으로 대체될 것을 의미함
    @GET("users/{user}/repos")

    // GET 요청 했을 때 Response의 타입을 결정하는 부분
    // Call<타입>에서 타입을 정한다
    // https://api.github.com/ 주소의 요청결과로 JsonArray를 받는다는 의미
    // (어떤 타입이 오는지 몰라도 서버-클라간 데이터는 JSON으로 이루지기 때문에 이렇게 설정함)

    // Path는 GET의 대체되는 공간인 {user}를 매개변수로 넘어온 String userName 로 설정한다는 의미
    // 따라서 userName = "ABC"라면 실제 요청 주소는 https://api.github.com/users/ABC/repos가 됨
    Call<JsonArray> getUserRepositories(@Path("user") String userName);

    // ## 서버에게 데이터를 전송할 때 POST를 사용해 싣어 보낼 Body를 아래 방식으로 보낼 수 있다
    // ## username 과 age 라는 키(Field) 값에 변수들을 받아 전송한다
    // ##  @FormUrlEncoded 는 Body로 받는 데이터 타입을 결정한다
    @FormUrlEncoded
    @POST("users/repos")
    Call<JsonArray> postUser(@Field("username")String name, @Field("age") int age);

}
