import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class Main {

    //Ключ разработчика Trello: 50635cb80fd74026eda63453dcbc4914
    //Токен Trello: 78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a

    public static void main(String[] args) {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest
                .baseUri("https://api.trello.com")
                .basePath("/1/members/me/boards")
                .header("Accept", "application/json") // или ("Accept", ContentType.JSON) // или .accept(ContentType.JSON)
                .header("key", "50635cb80fd74026eda63453dcbc4914")
                .header("token", "78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a")
                //.body(
                //        ) может тело надо добавить, но сервер тело в гет запросах не обрабатывает
                .when().get();

        ResponseBody body = response.getBody();
        System.out.println("Response Body: " + body.asString());


    /*

        RestAssured.baseURI = "https://api.trello.com/1/actions";
        RestAssured.port = 443;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/1/actions");
        //actions/{id}
        //actions/{id}/{field}
        Headers allHeaders = response.headers();
        for (Header header : allHeaders) {
        System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        */
    }
}
