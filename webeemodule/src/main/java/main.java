import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

public class main {
    static public void main(String args[]){

        try {
            HttpClient client = HttpClientFactory.getHttpsClient();

            HttpPost request = new HttpPost("https://www.webeelife.com/api/users/user/login");
            StringEntity params = new StringEntity("{\"username\":\"martinrevert\",\"password\":\"cambiar01\"}");
            request.addHeader("content-type", "application/json");
            request.setEntity(params);

            HttpResponse result = client.execute(request);

            String json = EntityUtils.toString(result.getEntity(), "UTF-8");

            System.out.println(result.getStatusLine().getStatusCode());
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
