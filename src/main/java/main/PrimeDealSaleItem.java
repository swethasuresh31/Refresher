package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrimeDealSaleItem {
	String itemName;
	int availableStock;
	Queue<String> purchaseQueue;

	public PrimeDealSaleItem(String itemName, int availableStock) {
		this.itemName = itemName;
		this.availableStock = availableStock;
		purchaseQueue = new LinkedList<String>();
	}

	public String getItemName() {
		return itemName;
	}

	public int getAvailableStock() {
		return availableStock;
	}

	public void enterPurchaseQueue(String userName) {
		purchaseQueue.add(userName);
	}

	public int getPurchaseQueueSize() {
		return purchaseQueue.size();
	}

	public List<String> startSale() {
		List<String> successfulPurchase = new ArrayList<String>();
		while (availableStock > 0 && !purchaseQueue.isEmpty()) {
			successfulPurchase.add(purchaseQueue.remove());
			availableStock--;
		}

		if (!purchaseQueue.isEmpty()) {
			System.out.println("Sorry we are out of stock on " + itemName);
			purchaseQueue.clear();
		}
		return successfulPurchase;
	}

	public void printStoreState() {
		System.out.println("The number of " + itemName + " available is " + availableStock);
		System.out.println("The number of purchasers in the queue are " + getPurchaseQueueSize());
	}

	public static void main(String[] args) {
		PrimeDealSaleItem television = new PrimeDealSaleItem("tv", 3);
		television.enterPurchaseQueue("d");
		television.enterPurchaseQueue("c");
		television.enterPurchaseQueue("b");
		television.enterPurchaseQueue("a");

		PrimeDealSaleItem refrigerator = new PrimeDealSaleItem("refrigerator", 4);
		refrigerator.enterPurchaseQueue("h");
		refrigerator.enterPurchaseQueue("g");
		refrigerator.enterPurchaseQueue("f");

		television.printStoreState();
		List<String> televisionCust = television.startSale();
		System.out.println("Tv purchasers are: " + televisionCust);
		refrigerator.printStoreState();
		List<String> refrigeratorCust = refrigerator.startSale();
		System.out.println("Tv purchasers are: " + refrigeratorCust);

	}

}
