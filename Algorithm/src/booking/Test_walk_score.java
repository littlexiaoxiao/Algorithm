package booking;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Test_walk_score extends HttpServlet{
	final String key = "f44260dc37f448b4a56179dda5abd00b";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public  String getStopInfo(String stpid) throws JSONException, IOException, ParseException {
		StringBuilder query = new StringBuilder();
		query.append("http://api.walkscore.com/score?format=json"
				+ stpid);
		query.append("&key=" + key);

		String response = run(query.toString());
	    JSONObject jobject = new JSONObject(response);
	    JSONObject jresponse = jobject.getJSONObject("bustime-response");
	    JSONArray jarray = jresponse.getJSONArray("prd");
	    
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HH:mm");
	    String currentTime = sdf.format(new Date());
	    Date now = sdf.parse(currentTime);
	    
	    for (int i = 0; i < jarray.length(); i++) {
	    	String prdtm = (String) jarray.getJSONObject(i).get("prdtm");
	        Date dt = sdf.parse(prdtm);
	        long gap = (dt.getTime()-now.getTime())/60000;
	        String prdtime = "";
	        if (gap >= 0) {
	        	prdtime += "in " + gap + " minutes";
	        } else {
	        	prdtime += "left " + -gap + " minutes ago";
	        }
	        jarray.getJSONObject(i).remove("tmstmp");
	        jarray.getJSONObject(i).remove("zone");
	        jarray.getJSONObject(i).remove("tablockid");
	        jarray.getJSONObject(i).remove("tatripid");
	        jarray.getJSONObject(i).remove("dstp");
	        jarray.getJSONObject(i).remove("prdtm");
	        jarray.getJSONObject(i).put("prdtm", prdtime);
	    }
	    
	    JSONObject result = new JSONObject();
	    result.put("BusInfo", jarray);
	    System.out.println(result);
	    return result.toString();
	}

	public String run(String url) throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}
