package DataStrucureTopicWise.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/web-crawler/editorial/
//design web crawler
public class WebCrawler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private String getHostname(String url) {
        // split url by slashes
        // for instance, "http://example.org/foo/bar" will be split into
        // "http:", "", "example.org", "foo", "bar"
        // the hostname is the 2-nd (0-indexed) element
        return url.split("/")[2];
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String startHostname = getHostname(startUrl);
        Queue<String> q = new LinkedList<String>(Arrays.asList(startUrl));
        HashSet<String> visited = new HashSet<String>(Arrays.asList(startUrl));
        while (!q.isEmpty()) {
            String url = q.remove();
            for (String nextUrl : htmlParser.getUrls(url)) {
                if (getHostname(nextUrl).equals(startHostname) && !visited.contains(nextUrl)) {
                    q.add(nextUrl);
                    visited.add(nextUrl);
                }
            }
        }
        return new ArrayList<>(visited);
    }

}
