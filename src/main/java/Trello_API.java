import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class Trello_API {

    //https://api.trello.com/1/members/me/boards?key=50635cb80fd74026eda63453dcbc4914&token=78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a

    //Ключ разработчика Trello: 50635cb80fd74026eda63453dcbc4914
    //Токен Trello: 78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a

    public void getInfo() {
        RestAssured.baseURI = "https://api.trello.com";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "1/members/me/boards?key=50635cb80fd74026eda63453dcbc4914&token=78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a");

        String responseBody = response.getBody().asString();
        System.out.println("Response body is" + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status code is" + statusCode);

        String statusLine = response.statusLine();
        System.out.println(("Status Line is" + statusLine));
    }

    public void crtCardForAPI() {
        RestAssured.baseURI = "https://api.trello.com";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        httpRequest.queryParam("key", "50635cb80fd74026eda63453dcbc4914");
        httpRequest.queryParam("token", "78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a");
        httpRequest.queryParam("idList", "5fba8f98fde1cf0ad5142487");
        httpRequest.queryParam("name", "CardForAPI");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.request(Method.POST, "/1/cards");
        String responceBody = response.getBody().asString();
        System.out.println("Response body is" + responceBody);

    }

    public void crtCardForDelete() {
        RestAssured.baseURI = "https://api.trello.com";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        httpRequest.queryParam("key", "50635cb80fd74026eda63453dcbc4914");
        httpRequest.queryParam("token", "78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a");
        httpRequest.queryParam("idList", "5fba8f98fde1cf0ad5142487");
        httpRequest.queryParam("name", "CardForDelete");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.request(Method.POST, "/1/cards");
        String responceBody = response.getBody().asString();
        System.out.println("Response body is" + responceBody);

    }

    public void renewCardForApi() {
        RestAssured.baseURI = "https://api.trello.com";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        httpRequest.queryParam("key", "50635cb80fd74026eda63453dcbc4914");
        httpRequest.queryParam("token", "78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a");
        httpRequest.queryParam("desc", "Ланит Экспертиза");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.PUT, "/1/cards/5fbc40bae6f6a92ca4523a91");

        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);
    }

    public void rowApiList() {
        RestAssured.baseURI = "https://api.trello.com";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        httpRequest.queryParam("key", "50635cb80fd74026eda63453dcbc4914");
        httpRequest.queryParam("token", "78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a");
        httpRequest.queryParam("idBoard", "5fba8f98fde1cf0ad5142486");
        httpRequest.queryParam("name", "ApiList");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST, "/1/lists/");

        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);
    }

    public void replaceCardToApiList ()
    {
        RestAssured.baseURI = "https://api.trello.com";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        httpRequest.queryParam("key", "50635cb80fd74026eda63453dcbc4914");
        httpRequest.queryParam("token", "78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a");
        httpRequest.queryParam("idBoard", "5fba8f98fde1cf0ad5142486");
        httpRequest.queryParam("idList", "5fbc475b75e4b211b4d44237");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST,"/1/lists/5fba8f98fde1cf0ad5142487/moveAllCards");

        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);
    }

    public void eraseCardForDelete()
    {
        RestAssured.baseURI = "https://api.trello.com";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        httpRequest.queryParam("key", "50635cb80fd74026eda63453dcbc4914");
        httpRequest.queryParam("token", "78018ba960967c716e5e0a26fcce65ea3e97b8052bf72c0d6ae0aa9216333d2a");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.DELETE,"/1/cards/5fbc4128e605e119c626e33a");

        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);
    }






}
