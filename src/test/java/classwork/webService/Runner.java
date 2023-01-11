package classwork.webService;

import java.io.IOException;
import java.net.URISyntaxException;

public class Runner {

    public static void main(String[] args) throws IOException, URISyntaxException {

        MyParser parser = new MyParser();

//        parser.parseGSON();
//        parser.toGSON();

        MyHttpClient httpClient = new MyHttpClient();

        httpClient.httpGet();

    }
}
