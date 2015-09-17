import org.json.JSONObject;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

	public class WalkScore {
		
		public WalkScore() {
			
		}
		
		private static String addressConverter(String neighborhoodName){
			StringBuffer buffer = new StringBuffer();
			buffer.append("www.google.com/maps/place/");
			//hack to get rid of ", USA" from googleAddress
			//googleAddress = googleAddress.substring(0, googleAddress.lastIndexOf(','));
			for(int i = 0; i<neighborhoodName.length(); i++){
				if(neighborhoodName.charAt(i)==','){
					continue;
				} else if(neighborhoodName.charAt(i)==' '){
					buffer.append("%20");
				} else {
					buffer.append(neighborhoodName.charAt(i));
				}
			}
			buffer.append("%20Pittsburgh,PA");
			String converted = buffer.toString();
			//System.out.println(converted);
			return converted;
		}
		
		public static int GetWalkScore(String formAddress, double latitude, double longitude) throws Exception{
			int walkScore = 0;
			
			OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.walkscore.com/score?format=json");
		    
			//Create latlng string in WalkScore format
			String wsapikey = "084e016764f5cee88979db53940f493a";
			request.addQuerystringParameter("wsapikey", wsapikey);
			
			//quick and dirty string conversion
			request.addQuerystringParameter("lat", ""+latitude);
			request.addQuerystringParameter("lon", ""+longitude);
			String walkAddress = addressConverter(formAddress);
			request.addQuerystringParameter("address",walkAddress);
			Response response = request.send();

			JSONObject json = new JSONObject(response.getBody());
			//System.out.println("request json  " + json);
			if(json.getInt("status")>1) {
				System.err.println("no walkscore data");
				walkScore = -1;
			} else {
				walkScore = json.getInt("walkscore");
			}
			//System.err.println("This is the walkscore in your neighborhood! " + walkScore);
			return walkScore;
		}
		
		/**
		 * @param args
		 * @throws Exception 
		 */
		public static void main(String[] args) throws Exception {
			String[] neighborhoodNames = {"Allegheny Center","Allegheny West","Allentown","Arlington","Arlington Heights",
					"Banksville","Bedford Dwellings","Beechview","Beltzhoover","Bloomfield","Bluff","Bon Air",
					"Brighton Heights","Brookline","California-Kirkbride","Carrick","Central Business District",
					"Central Lawrenceville","Central Northside","Central Oakland","Chartiers City","Chateau","Crafton Heights",
					"Crawford-Roberts","Duquesne Heights","East Allegheny","East Carnegie","East Hills","East Liberty",
					"Elliott","Esplen","Fairywood","Fineview","Friendship","Garfield","Glen Hazel","Greenfield","Hays",
					"Hazelwood","Highland Park","Homewood North","Homewood South","Homewood West","Knoxville","Larimer",
					"Lincoln Place","Lincoln-Lemington-Belmar","Lower Lawrenceville","Manchester","Marshall-Shadeland",
					"Middle Hill","Morningside","Mount Washington","Mt. Oliver","New Homestead","North Oakland","North Shore",
					"Northview Heights","Oakwood","Overbrook","Perry North","Perry South","Point Breeze","Point Breeze North",
					"Polish Hill","Regent Square","Ridgemont","Shadyside","Sheraden","South Oakland","South Shore",
					"South Side Flats","South Side Slopes","Spring Garden","Spring Hill-City View","Squirrel Hill North",
					"Squirrel Hill South","St. Clair","Stanton Heights","Strip District","Summer Hill","Swisshelm Park",
					"Terrace Village","Troy Hill","Upper Hill","Upper Lawrenceville","West End","West Oakland","Westwood",
					"Windgap"};
			double[] latitude = {40.4537856,40.45199330000001,40.4223031,40.4153066,40.4168523,40.4099102,40.4502925,40.4135022,
					40.4157077,40.4621606,40.4367068,40.4076513,40.4828051,40.397389,40.4600435,40.3954426,40.4418296,
					40.4732222,40.4583805,40.4388198,40.4593587,40.4559713,40.4461978,40.441507,40.4351208,40.4553337,
					40.4189995,40.4548759,40.4643479,40.4401849,40.4623818,40.4490961,40.4636276,40.4606113,40.4678497,
					40.4065897,40.4258781,40.4030972,40.4117223,40.47987020000001,40.4586299,40.4538347,40.4596151,
					40.41473430000001,40.4642571,40.3688886,40.4733543,40.4652559,40.4552434,40.4694742,40.4480961,40.4867838,
					40.4276685,40.4114802,40.3895737,40.4466296,40.4467069,40.4785087,40.4263276,40.3863198,40.4836266,
					40.4668781,40.4435972,40.4520524,40.4579373,40.4328438,40.42822779999999,40.4556477,40.4567689,40.4319875,
					40.43731,40.42930339999999,40.4208405,40.4742012,40.4665571,40.4455627,40.4317262,40.4091209,40.4818337,
					40.4541152,40.4915961,40.4197616,40.4430528,40.4619227,40.4535446,40.4828136,40.4364867,40.4393509,
					40.4347265,40.4545567};
			double[] longitude = {-80.0073768,-80.0157633,-79.9933976,-79.9710261,-79.9598383,-80.0395205,-79.974522,
					-80.02275139999999,-80.0045811,-79.94445259999999,-79.98500899999999,-79.9989895,-80.0367259,
					-80.01157010000001,-80.0213538,-79.9892034,-80.0003875,-79.9556424,-80.0094735,-79.9514464,-80.0716523,
					-80.0325338,-80.05069809999999,-79.9822126,-80.0202243,-79.9961936,-80.0716523,-79.8758835,-79.926266,
					-80.0395205,-80.05558789999999,-80.0842224,-80.0045811,-79.9339608,-79.9374582,-79.9290642,-79.9332613,
					-79.9612368,-79.94445259999999,-79.9164717,-79.8898816,-79.8926809,-79.9010784,-79.9933976,-79.9108744,
					-79.9164717,-79.8996789,-79.9654324,-80.0241489,-80.0283415,-79.9710261,-79.9234678,-80.01157010000001,
					-79.98500899999999,-79.9220686,-79.9542438,-80.01296789999999,-80.0017854,-80.06885869999999,-80.0003875,
					-80.0171609,-80.01296789999999,-79.9052768,-79.9010784,-79.96822929999999,-79.8940521,-80.0325338,
					-79.9276651,-80.05628639999999,-79.9598383,-80.0136667,-79.9724245,-79.9766195,-79.9885043,-79.9947956,
					-79.9276651,-79.9136731,-79.9724245,-79.93885709999999,-79.9822126,-80.0073768,-79.9066763,-79.9710261,
					-79.98500899999999,-79.9612368,-79.9500477,-80.03323250000001,-79.96473309999999,-80.049301,
					-80.07444579999999};
			System.out.println("neighborhoodNames length  " + neighborhoodNames.length);
			System.out.println("latitude length  " + latitude.length);
			System.out.println("longitude length  " + longitude.length);
			for(int i = 0; i < neighborhoodNames.length; i++) {
			//for(int i = 0; i < neighborhoodNames.length; i++) {
				int score = GetWalkScore(neighborhoodNames[i], latitude[i], longitude[i]);
				System.out.println(score);
			}
		}

	}

