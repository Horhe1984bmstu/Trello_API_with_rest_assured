import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;


public class Main {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://api.trello.com";
        RestAssured.port = 443;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/1/members/me/boards?key={50635cb80fd74026eda63453dcbc4914}&token={78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a}");
        System.out.println(response.getBody().toString());

/*
        RestAssured.baseURI = "\"https://api.trello.com/1/actions";
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