package workflows;

import extentions.ApiActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: Get Team Property")
    public static String getTeamProperty(String jPath)
    {
        response = ApiActions.get("/user/repos");
        return ApiActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Create New Repository")
    public static void postNewRepo(String name, String des)
    {
        params.put("name", name);
        params.put("description", des);
        ApiActions.post(params,"/user/repos");
    }

    @Step("Business Flow: Update Existing Repository Data")
    public static void updateRepoData(String newName,String repoNameToUpdate)
    {
        params.put("name", newName);
        ApiActions.put(params,"/repos/EsterYIT/" + repoNameToUpdate);
    }


    @Step("Business Flow: Delete Repository")
    public static void deleteRepo()
    {
        ApiActions.delete("/repos/EsterYIT/Hello-World-Updated");
    }
}
