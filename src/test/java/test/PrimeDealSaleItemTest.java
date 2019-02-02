package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import main.PrimeDealSaleItem;

public class PrimeDealSaleItemTest {

	@Test
	public void testEmptyPurchaseQueue() {

		PrimeDealSaleItem television = new PrimeDealSaleItem("tv", 3);
		assertEquals(0, television.getPurchaseQueueSize());
		List<String> televisionCust = television.startSale();
		assertTrue(televisionCust.isEmpty());

	}

	@Test
	public void testFullPurchaseQueue() {

		PrimeDealSaleItem television = new PrimeDealSaleItem("tv", 3);
		television.enterPurchaseQueue("d");
		television.enterPurchaseQueue("c");
		television.enterPurchaseQueue("b");
		television.enterPurchaseQueue("a");

		// checking purchase queue size
		assertEquals(4, television.getPurchaseQueueSize());
		List<String> televisionCust = television.startSale();

		// checking if only available stocks are purchased
		assertEquals(3, televisionCust.size());

	}

	@Test
	public void testNormalSale() {

		// checking normal use case
		PrimeDealSaleItem television = new PrimeDealSaleItem("tv", 4);
		television.enterPurchaseQueue("d");
		television.enterPurchaseQueue("c");
		television.enterPurchaseQueue("b");
		television.enterPurchaseQueue("a");

		// checking purchase queue size
		assertEquals(4, television.getPurchaseQueueSize());
		List<String> televisionCust = television.startSale();

		// checking if only available stocks are purchased
		assertEquals(4, televisionCust.size());
	}
}
