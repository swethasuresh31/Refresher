package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.CandyCrushStack;
import main.TrendingSearchTerms;
import main.CandyCrushStack.Power;

public class TrendingSearchTermsTest {

	@Test
	public void testEmptySearches() {

		// checking empty searches
		TrendingSearchTerms trending = new TrendingSearchTerms();
		assertTrue(trending.getTopSearches().isEmpty());
	}

	@Test
	public void testSearchTermAggregation() {
		
		TrendingSearchTerms trending = new TrendingSearchTerms();
		trending.search("google");
		trending.search("facebook");
		trending.search("google");
		trending.search("facebook");
		trending.search("twitter");	
		trending.search("twitter");
		//check if search terms are aggregated
		assertEquals(3, trending.getTopSearches().size());
	}

	@Test
	public void testNormalTrendingSearch() {

		TrendingSearchTerms trending = new TrendingSearchTerms();
		trending.search("google");
		trending.search("facebook");
		trending.search("google");
		trending.search("google");
		trending.search("twitter");	
		trending.search("twitter");
		trending.search("facebook");
		trending.search("facebook");
		trending.search("facebook");
		List<String> topSearches = trending.getTopSearches();
		
		//checking if trending search is properly sorted and returned
		assertEquals("facebook", topSearches.get(0));
		assertEquals("google", topSearches.get(1));
		assertEquals("twitter", topSearches.get(2));
		
	}
}
