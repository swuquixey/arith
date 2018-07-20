import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicInteger;


public class UriTest {

	public static void main(String[] args) {
//		URI uri;
//		String str = "http://search-mt-app-0vc9ni013.quixey.be:8779/app_search?q=%E5%A4%A9%E5%A4%A9&napps=40&include_extra_metadata=false&locale=zh_CN&facets={\"spu_features\":[\"2727176\",\"2788616\"]}&edition_limit=3&fix_spelling=true";
//		try {
//			uri = new URI(URLEncoder.encode(str));
//			String queryString = uri.getQuery();
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		AtomicInteger index = new AtomicInteger(0);
		 int thisIndex = Math.abs(index.getAndIncrement());
		 System.out.println(thisIndex);
		 System.out.println(index.get());
        

	}

}
