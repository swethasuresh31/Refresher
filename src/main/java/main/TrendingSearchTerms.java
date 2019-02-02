package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.Entry;

public class TrendingSearchTerms {

	Map<String, Integer> trendingSearch;

	public TrendingSearchTerms() {
		trendingSearch = new HashMap<String, Integer>();
	}

	public void search(String query) {
		Integer countSearch = trendingSearch.get(query);
		if (countSearch == null) {
			countSearch = 0;
		}
		trendingSearch.put(query, ++countSearch);
	}

	public List<String> getTopSearches() {
		List<String> topSearches = new ArrayList<String>();
		List<Entry<String, Integer> > countSearchList = 
	               new ArrayList<Entry<String, Integer> >(trendingSearch.entrySet()); 
	  
	    Collections.sort(countSearchList, new Comparator<Entry<String, Integer> >() { 
	            public int compare(Entry<String, Integer> o1,  
	                               Entry<String, Integer> o2) { 
	                return (o2.getValue()).compareTo(o1.getValue()); 
	            } 
	        }); 
		for(Entry<String, Integer> topSearchEntry : countSearchList) {
			topSearches.add(topSearchEntry.getKey());
		}
		return topSearches;
	}

	public static void main(String[] args) {
		TrendingSearchTerms trending = new TrendingSearchTerms();
		trending.search("google");
		trending.search("facebook");
		trending.search("twitter");
		trending.search("google");
		trending.search("facebook");
		trending.search("google");
		System.out.println(trending.getTopSearches());
	}

}
