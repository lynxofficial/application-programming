import FirstPackage.*;

class FirstClass {
	public static void main(String[] s) {
	SecondClass o = new SecondClass(10,-10);
	int i, j;
	for (i = 1; i <= 8; i++) {
		for(j = 1; j <= 8; j++) {
			o.setDigitOne(i);
			o.setDigitTwo(j);
			System.out.print(o.add());
			System.out.print(" ");
		}
		System.out.println();
	}

		}
}
class SecondClass {
	private int digitOne;
	private int digitTwo;

	public SecondClass(int digitOne, int digitTwo) { 
		this.digitOne=digitOne;
		this.digitTwo=digitTwo;
		}
	
	public int getDigitOne() {
		return digitOne;
		}
	
	public void setDigitOne(int digitOne) {
		this.digitOne=digitOne;
		}	

	public int getDigitTwo() {
		return digitTwo;
		}
	
	public void setDigitTwo(int digitTwo) {
		this.digitTwo=digitTwo;
		}

	public int add() {
		return digitOne+digitTwo;
		}		
}