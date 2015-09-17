package Others_implementsOfSome_useful_Functions;

	import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

	public class LanAndLong {
	 

	
	    public static void main(String[] args) {
	    	String[] list = {
	    			"Allegheny Center","Allegheny West","Allentown","Arlington",
	    			"Arlington Heights","Banksville","Bedford Dwellings","Beechview",
	    			"Beltzhoover","Bloomfield","Bluff","Bon Air","Brighton Heights",
	    			"Brookline","California-Kirkbride","Carrick","Central Business District",
	    			"Central Lawrenceville","Central Northside","Central Oakland","Chartiers City","Chateau",
	    			"Crafton Heights","Crawford-Roberts","Duquesne Heights","East Allegheny","East Carnegie",
	    			"East Hills","East Liberty","Elliott","Esplen","Fairywood","Fineview","Friendship","Garfield",
	    			"Glen Hazel","Greenfield","Hays","Hazelwood","Highland Park","Homewood North","Homewood South",
	    			"Homewood West","Knoxville","Larimer","Lincoln Place","Lincoln-Lemington-Belmar","Lower Lawrenceville",
	    			"Manchester","Marshall-Shadeland","Middle Hill","Morningside","Mount Washington","Mt. Oliver","New Homestead",
	    			"North Oakland","North Shore","Northview Heights","Oakwood","Overbrook","Perry North","Perry South",
	    			"Point Breeze","Point Breeze North","Polish Hill","Regent Square","Ridgemont","Shadyside","Sheraden",
	    			"South Oakland","South Shore","South Side Flats","South Side Slopes","Spring Garden","Spring Hill-City View",
	    			"Squirrel Hill North","Squirrel Hill South","St. Clair","Stanton Heights","Strip District","Summer Hill",
	    			"Swisshelm Park","Terrace Village","Troy Hill","Upper Hill","Upper Lawrenceville","West End","West Oakland",
	    			"Westwood","Windgap"};
	    	System.out.println(list.length);
	    	for(int i = 0; i < 12; i++) {
	    		double[] res = getLongAndLat(list[i]+ ",Pittsburgh");
	    		System.out.println(list[i] + " " + res[0]);
	    		//System.out.println(res[1]);
	       	}
	     }
	    
	 
	    private static double[] getLongAndLat(String address) {
			double[] res = new double[2];
			try{
			String locationAddres = address.replaceAll(" ", "%20");
			URL url = new URL(
					"http://maps.googleapis.com/maps/api/geocode/json?address="
			                + locationAddres + "&sensor=true");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			String output = "", full = "";
			StringBuilder sb = new StringBuilder();
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				sb.append(output);
			}
			JSONObject response = new JSONObject(sb.toString());
			JSONArray result = response.getJSONArray("results");
			JSONObject components = result.getJSONObject(0).getJSONObject(
					"geometry");
			JSONObject longAndLat = components.getJSONObject("location");	    
		    res[0] = longAndLat.getDouble("lat");
		    res[1] = longAndLat.getDouble("lng");
		    //System.out.println("target latitude " + res[0]);
			//System.out.println("target longitude " + res[1]);
		} catch (Exception e) {
			System.out.print("get geolocation: " + e.toString());
		}
			return res;
	   }
	    
//		String[] list = new String[neighborhoods.length];
//		ArrayList<String> res = new ArrayList<String>();
//		int i= 0;
//		for(Neighborhood neighborhood : neighborhoods) {
//			list[i] = neighborhood.getName();				
//			System.out.print("\"" + list[i] + "\",");
//			i++;
//		}		
	

}
