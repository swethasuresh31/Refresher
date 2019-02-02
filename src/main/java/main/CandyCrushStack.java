package main;
import java.util.Stack;


public class CandyCrushStack {
	
	public enum Power {STRIPED_CANDY, WRAPPED_CANDY, DOUGHNUT};
	
	private int powerBar;
	Stack<Power> powerUps;
	
	public CandyCrushStack() {
		powerUps = new Stack<Power>();
	}
	
	public void levelPassed() {
		if(powerBar < 3) {
			powerUps.push(Power.values()[powerBar]);
			powerBar++;
		}else {
			System.out.println("Power bar is full!");
		}
			
	}
	public void levelFailed() {
		if(powerUps.isEmpty()){
			System.out.println("Power bar is empty");
		}
		else {
			powerUps.pop();
			powerBar--;
		}
	}
	public Power getCurrentPower() {
		if(powerUps.isEmpty()) {
			return null;
		}
		return powerUps.peek();
	}
	
	public void printPowerUpsStack() {
		System.out.println("Current power up stack: "+powerUps);
	}
	
	public static void main(String[] args) {
		
		CandyCrushStack ccs = new CandyCrushStack();
		ccs.printPowerUpsStack();
		ccs.levelFailed();
		ccs.printPowerUpsStack();
		ccs.levelPassed();
		ccs.printPowerUpsStack();
		ccs.levelPassed();
		ccs.printPowerUpsStack();
		ccs.levelPassed();
		ccs.printPowerUpsStack();
		ccs.levelPassed();
		ccs.printPowerUpsStack();
		System.out.println(ccs.getCurrentPower());
		
		
	}

}
