package sequentialRTS;

import java.util.Random;

public class Event {
	private  int speedLimit;
	
	
	public int getSpeedLimit() {
		return speedLimit;
	}
	
	public  void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}
	
	public void randomEvent(){
		Random r = new Random();
		int ranSpeed=r.nextInt(3);
		
		if(ranSpeed==0) {
			setSpeedLimit(30);
		}
		if(ranSpeed==1) {
			setSpeedLimit(90);
		}
		if(ranSpeed==2) {
			setSpeedLimit(60);
		}
		if(ranSpeed==3) {
			setSpeedLimit(110);
		}
		System.out.println("Speed Limit " +getSpeedLimit() +"kmH");
	}


}
