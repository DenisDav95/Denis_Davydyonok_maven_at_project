package homework.webservice.tests;

import homework.webservice.objects.Response;
import homework.webservice.objects.SearchBody;
import org.junit.Assert;
import org.junit.Test;


public class SearchTests extends Preconditions {

    @Test
    public void searchByFullUserName () {
        compareResponses("src/test/resources/homework/fullUserNameSearchBody.json");
    }

    @Test
    public void searchByPartialUserName () {
        compareResponses("src/test/resources/homework/partialUserNameSearchBody.json");
    }

    @Test
    public void searchAllUsers() {
        Response responseBody = getResponse(new SearchBody("", false));
        Assert.assertTrue(responseBody.getData().size() == 6);
    }
}
