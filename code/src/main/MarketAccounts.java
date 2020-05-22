package main;

public class MarketAccounts {
	Discount dt = null;
	
	public MarketAccounts(String type) {
		switch (type) {
			case "normal":
				NoDiscount nd = new NoDiscount();
				dt = nd;
				break;
			case "student full 100 minus 10":
				ReductionDicount rd = new ReductionDicount("100", "10");
				dt = rd;
				break;
			case "employee discount 8":
				EmployeeDiscount ed = new EmployeeDiscount("8");
				dt = ed;
				break;
			case "VIP discount 6":
				VIPDiscount vd = new VIPDiscount("6");
				dt = vd;
				break;
			default:
				break;
		}
	}
	
	public double getPrice(double originalPrice) {
		return dt.disCountInterface(originalPrice);
	}

}
