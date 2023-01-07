package classwork.day20;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class MyHttpClient {

    public void httpGet() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("https://api.chucknorris.io/jokes/random");
        HttpGet request = new HttpGet(builder.build());
        HttpResponse httpResponse = client.execute(request);
        System.out.println(EntityUtils.toString(httpResponse.getEntity()));
    }

//    public void search(Serch serch) throws URISyntaxException, IOException {
//        HttpClient client = HttpClientBuilder.create().build();
//        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/ws/");
//        HttpPost request = new HttpPost(builder.build());
//        request.setEntity(new StringEntity(new MyParser().fromGSON(search)));
//        HttpResponse httpResponse = client.execute(request);
//        System.out.println(EntityUtils.toString(httpResponse.getEntity()));
//    }
}

