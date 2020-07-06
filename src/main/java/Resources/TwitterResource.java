package Resources;

public class TwitterResource {
	public static String addTweetRsc() {
		String addTweetRsc = "1.1/statuses/update.json";
		return addTweetRsc;
	}
	
	public static String getTweetRsc() {
		String getTweetRsc = "1.1/statuses/home_timeline.json";
		return getTweetRsc;
	}
	
	
}
