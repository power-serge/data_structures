package chapter07;

public class StockLedger {
	private QueueInterface<StockPurchase> ledger;

	public StockLedger() {
		ledger = new LinkedQueue<>();
	} // end default constructor

	/**
	 * Records a stock purchase in this ledger.
	 * 
	 * @param sharesBought  The number of shares purchased.
	 * @param pricePerShare The price per share.
	 */
	public void buy(int sharesBought, double pricePerShare) {
		while (sharesBought > 0) {
			StockPurchase purchase = new StockPurchase(pricePerShare);
			ledger.enqueue(purchase);
			sharesBought--;
		} // end while
	} // end buy

	/**
	 * Removes from this ledger any shares that were sold and computes the capital
	 * gain or loss.
	 * 
	 * @param sharesSold    The number of shares sold.
	 * @param pricePerShare The price per share.
	 * @return The capital gain (loss).
	 */
	public double sell(int sharesSold, double pricePerShare) {
		double saleAmount = sharesSold * pricePerShare;
		double totalCost = 0;
		while (sharesSold > 0) {
			StockPurchase share = ledger.dequeue();
			double shareCost = share.getCostPerShare();
			totalCost = totalCost + shareCost;
			sharesSold--;
		} // end while
		return saleAmount - totalCost; // Gain or loss
      }
//	public double sell(int sharesSold, double pricePerShare) {
//		double saleAmount = sharesSold * pricePerShare;
//		double totalCost = 0;
//		while (sharesSold > 0) {
//			StockPurchase transaction = ledger.removeFront();
//			double shareCost = transaction.getCostPerShare();
//			int numberOfShares = transaction.getNumberOfShares();
//			if (numberOfShares > sharesSold) {
//				totalCost = totalCost + sharesSold * shareCost;
//				int numberToPutBack = numberOfShares - sharesSold;
//				StockPurchase leftOver = new StockPurchase(numberToPutBack, shareCost);
//				ledger.addToFront(leftOver); // Return leftover shares
//				// Note: Loop will exit since sharesSold will be <= 0 later
//			} else
//				totalCost = totalCost + numberOfShares * shareCost;
//			sharesSold = sharesSold - numberOfShares;
//		} // end while
//		return saleAmount - totalCost; // Gain or loss
//	} // end sell
} // end StockLedger