package extentions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class ApiActions extends CommonOps {

    @Step("Get Data From Server")
    public static Response get(String paramValues)
    {
        response = httpRequest.get(paramValues);
        return response;
    }

    @Step("Post Data To Server")
    public static void post(JSONObject params, String resource)
    {
        httpRequest.headers("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
    }

    @Step("Update Data In Server")
    public static void put(JSONObject params, String resource)
    {
        httpRequest.headers("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.patch(resource);
    }

    @Step("Delete Data From Server")
    public static void delete(String id)
    {
        response = httpRequest.delete(id);
    }

    @Step("Extract Data From Json Format")
    public static String extractFromJSON(Response response,String path)
    {
        jp = response.jsonPath();
        return jp.getString(path);
    }

}
