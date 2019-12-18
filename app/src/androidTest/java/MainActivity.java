import com.example.schoolapp.adapter.FeedListAdapter;
import com.example.schoolapp.app.AppController;
import com.example.schoolapp.data.FeedItem;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {
	private static final String TAG = MainActivity.class.getSimpleName();
	private ListView listView;
	private FeedListAdapter listAdapter;
	private List<FeedItem> feedItems;
	private String URL_FEED = "http://192.168.43.164:5000/getQuotes";

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.list);

		feedItems = new ArrayList<FeedItem>();

		listAdapter = new FeedListAdapter(this, feedItems);
		listView.setAdapter(listAdapter);

		// These two lines not needed,
		// just to get the look of facebook (changing background color & hiding the icon)
		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3b5998")));
		getActionBar().setIcon(
				new ColorDrawable(getResources().getColor(android.R.color.transparent)));
		String myStringJsonData = MyJsonToStringConverter.convert(Filter.levelAL,"http://192.168.43.164:5000/getQuotes");

		Toast.makeText(getApplicationContext(), myStringJsonData, Toast.LENGTH_LONG).show();














		try {
			JSONObject json = new JSONObject(myStringJsonData);
			Toast.makeText(getApplicationContext(), myStringJsonData, Toast.LENGTH_LONG).show();
			JSONArray jsonarray = json.getJSONArray("feed");
			for (int i = 0; i < jsonarray.length(); i++) {
				JSONObject job = jsonarray.getJSONObject(i);

				//	School actor2 = new School();

				//	actor2.setName(job.getString("name"));
				//		actor2.setDescription(job.getString("description"));
				//		actor2.setRating(job.getString("school_rating"));
				//		actor2.setImage(job.getString("image_url"));
				//		id2[i] = job.getInt("id");
				//		actor2.setId(job.getInt("id"));

				//		MainActivity.actorList.add(actor2);

			}


		} catch (Exception e) {
			Toast.makeText(getApplication(), "Unable To Fetch Data", Toast.LENGTH_LONG);
			Log.e("log_tag", e.toString());
		}

	/*	JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
				URL_FEED, null, new Response.Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject response) {
				VolleyLog.d(TAG, "Response: " + response.toString());
				if (response != null) {
					parseJsonFeed(response);
				}
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				VolleyLog.d(TAG, "Error: " + error.getMessage());
			}
		});

		// Adding request to volley request queue
		AppController.getInstance().addToRequestQueue(jsonReq);
		// We first check for cached request
		Cache cache = AppController.getInstance().getRequestQueue().getCache();
		Entry entry = cache.get(URL_FEED);
		if (entry != null) {
			// fetch the data from cache
			try {
				String data = new String(entry.data, "UTF-8");
				try {
					parseJsonFeed(new JSONObject(data));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();

			}

			//} //else {
		/*	JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.POST,
					URL_FEED, null,
					new Response.Listener<JSONObject>() {

						@Override
						public void onResponse(JSONObject response) {
							Toast.makeText(getApplicationContext(),"Second response"+response,Toast.LENGTH_LONG).show();
							VolleyLog.d(TAG, "Response: " + response.toString());
							if (response != null) {
								parseJsonFeed(response);
							}


							Log.d(TAG, response.toString());
							//pDialog.hide();
						}
					}, new Response.ErrorListener() {

				@Override
				public void onErrorResponse(VolleyError error) {
					VolleyLog.d(TAG, "Error: " + error.getMessage());
					//pDialog.hide();
				}
			}) {

				@Override
				protected Map<String, String> getParams() {
			 		Map<String, String> params = new HashMap<String, String>();
					params.put("id","1");
					return params;
				}

			};

// Adding request to request queue
			AppController.getInstance().addToRequestQueue(jsonObjReq);
			// making fresh volley request and getting json
		//}
*/

	}

	/**
	 * Parsing json reponse and passing the data to feed view list adapter
	 * */
	private void parseJsonFeed(JSONObject response) {
		try {
			//Toast.makeText(getApplicationContext(),"Second response"+response,Toast.LENGTH_LONG).show();
			JSONArray feedArray = response.getJSONArray("quote_list");

			for (int i = 0; i < feedArray.length(); i++) {
				JSONObject feedObj = (JSONObject) feedArray.get(i);

				FeedItem item = new FeedItem();
//				item.setId(feedObj.getInt("id"));
				item.setName(feedObj.getString("author"));

				// Image might be null sometimes
				String image = feedObj.isNull("image") ? null : feedObj
						.getString("image");
						item.setImge(image);
				item.setStatus(feedObj.getString("quotes"));
		//		item.setProfilePic(feedObj.getString("profilePic"));
		//		item.setTimeStamp(feedObj.getString("timeStamp"));

				// url might be null sometimes
				String feedUrl = feedObj.isNull("url") ? null : feedObj
						.getString("url");
				item.setUrl(feedUrl);

				feedItems.add(item);
			}

			// notify data changes to list adapater
			listAdapter.notifyDataSetChanged();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
