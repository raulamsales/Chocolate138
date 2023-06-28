package apitest;

import com.google.gson.Gson;
import entity.AccountEntity;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.testng.TestRunner.PriorityWeight.priority;

public class Account {
    Gson gson = new Gson();
    String userID;
    String ct = "application/json";
    String jsonBody;
    String uri = "https://bookstore.toolsqa.com/Account/v1/";
    Response resposta;
    String token;

    @Test(priority = 0)
    public void testCreateUser(){
        AccountEntity account = new AccountEntity();
        account.userName = "John22";
        account.password = "Ite2023!";
        jsonBody = gson.toJson(account);
        resposta = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "User")
        .then()
                .log().all()
                .statusCode(201)
                .body("username", is(account.userName))
                .extract()
        ;
        userID = resposta.jsonPath().getString("userID");
        System.out.println("🐞USER ID EXTRAIDO " + userID);
    }

    @Test(priority = 1)
    public void testGenerateToken(){
        resposta = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "GenerateToken")
        .then()
                .log().all()
                .statusCode(200)
                .body("status", is ("Success"))
                .body("result", is ("User authorized successfully."))
                .extract()
                ;
        token = resposta.jsonPath().getString("token");
        System.out.println("TOKEN = " + token);
        Assert.assertTrue(token.length() != 0);

    }

}
