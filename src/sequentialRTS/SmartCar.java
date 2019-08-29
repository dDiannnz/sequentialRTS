package sequentialRTS;

public class SmartCar {
	static int cspeed ;
	
	public static int getSpeed() {
		return cspeed;
	}

	public  void setSpeed(int cspeed) {
		this.cspeed = cspeed;
	}
	
	public void incspeed() {
		this.cspeed+=10;
	}
	public void decspeed() {
		this.cspeed-=10;
	}
	public static void main(String[] args) throws InterruptedException {
		while(true) {
		Event e = new Event();
		e.randomEvent();
		java.util.concurrent.TimeUnit.SECONDS.sleep(2);
		EventHandler eh = new EventHandler(e.getSpeedLimit(),getSpeed());
		eh.handleEvent();
		}
	}
}
