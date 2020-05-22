package main;

public abstract class Discount {
	public abstract double disCountInterface(double originalPrice);
}

/**
 * ${No discount}
 */
class NoDiscount extends Discount {
	NoDiscount() {}
	
	@Override
	public double disCountInterface(double originalPrice) {
		return originalPrice;
	}
}

/**
 * ${With x minus y}
 */
class ReductionDicount extends Discount {
	private double full;
	private double reduction;
	ReductionDicount(String full, String reduction) {
		this.full = Double.parseDouble(full);
		this.reduction = Double.parseDouble(reduction);
	}
	
	@Override
	public double disCountInterface(double originalPrice) {
		int k = (int)(originalPrice / full);
		double ret = originalPrice - k * reduction;
		return ret;
	}
}

/**
 * ${Employees get discounts with their work permits}
 */
class EmployeeDiscount extends Discount {
	private double ds;
	
	EmployeeDiscount(String ds) {
		this.ds = Double.parseDouble(ds);
		this.ds *= 0.1;
	}
	
	@Override
	public double disCountInterface(double originalPrice) {
		double ret = originalPrice * ds;
		return ret;
	}
}

/**
 * ${VIP users enjoy discounts and points}
 * @note: The amount of money is equal to the number of scores
 */
class VIPDiscount extends Discount {
	private double ds;
	
	VIPDiscount(String ds) {
		this.ds = Double.parseDouble(ds);
		this.ds *= 0.1;
	}
	
	@Override
	public double disCountInterface(double originalPrice) {
		double ret = originalPrice * ds;
		return ret;
	}
}