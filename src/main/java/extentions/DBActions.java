package extentions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {
    @Step("Get Credentials From Database")
    public static List<String> getCredentials(String query) throws SQLException {

        List<String> credentials = new ArrayList<String>();
        rs = stmt.executeQuery(query);
        rs.next();

        credentials.add(rs.getString(1));
        credentials.add(rs.getString(2));

        return credentials;
    }
}
