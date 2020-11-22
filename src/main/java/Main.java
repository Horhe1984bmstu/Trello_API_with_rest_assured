import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;


public class Main {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://api.trello.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/1/members/me/boards?key={50635cb80fd74026eda63453dcbc4914}&token={78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a}");
      //Response response = given().spec(setLogging()).spec(addHeader("key","value")).when().get();
        ResponseBody body = response.getBody();
        System.out.println("Response Body: " + body.asString());
        //Может хэдер надо добавить,который бы определял тип формата возвращаемой информации,
        //вроде .header("Accept", "application/json"). Тело-то точно не надо, сервер тело в гет запросах не обрабатывает
        //Ключ разработчика Trello: 50635cb80fd74026eda63453dcbc4914
        //Токен Trello: 78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a


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
