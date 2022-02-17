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