package apitest;

import com.google.gson.Gson;
import entity.AccountEntity;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Account {
    Gson gson = new Gson();
    String userID;

    @Test
    public void testCreateUser(){
        AccountEntity account = new AccountEntity();
        account.userName = "John12";
        account.password = "Ite2023!";
        String jsonBody = gson.toJson(account);
        Response resposta = (Response) given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post("https://bookstore.toolsqa.com/Account/v1/User")
        .then()
                .log().all()
                .statusCode(201)
                .body("username", is(account.userName))
                .extract()
        ;
        userID = resposta.jsonPath().getString("userID");
        System.out.println("🐞USER ID EXTRAIDO " + userID);

    }
}
