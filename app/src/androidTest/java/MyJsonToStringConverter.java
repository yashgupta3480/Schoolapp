import android.annotation.SuppressLint;
import android.os.StrictMode;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
////POST REQUEST SENDING ID, and getting all the details of the selected school
// in new activity fragement like hostel , faculty , transport,course , and other 3 things
@SuppressLint("NewApi")
public class MyJsonToStringConverter
{
	public static String convert(String s[],String url)
	{
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		String result = null;
		StringBuilder sb=null;
		JSONObject json = new JSONObject();
		/*JSONArray jsonArray = new JSONArray();
		if(s[0]!=null) {
			jsonArray.put(s[0]);
		}
		if(s[1]!=null) {
			jsonArray.put(s[1]);
		}
		if(s[2]!=null) {
			jsonArray.put(s[2]);
		}*/
		try
		{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(url);
            json.put("motivational",true);
			//if(jsonArray.length()!=0)
			//	json.put("author", jsonArray);
			//json.put("id",s);


			StringEntity se = new StringEntity(json.toString());
			se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,"application/json"));
			httppost.setEntity(se);
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			InputStream is=entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			sb= new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				sb.append(line+"\n");
			}
			is.close();
			result=sb.toString();
		}
		catch(Exception e)
		{}
		return result;
	}
}

