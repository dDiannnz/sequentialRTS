package sequentialRTS;

public class SmartCar {
	 static int cspeed ;
	
	public static int getSpeed() {
		return cspeed;
	}

	public void setSpeed(int cspeed) {
		this.cspeed = cspeed;
	}
	
	public void incspeed() {
		this.cspeed+=10;
	}
	public void decspeed() {
		this.cspeed-=10;
	}
	public static void main(String[] args) throws InterruptedException {
		System.out.println("===Event===			Starting Engine");
		while(true) {
			Event e = new Event();
			e.randomEvent();
			CollisionSeq cs = new CollisionSeq();
			cs.handleEvent();
			SpeedSeq ss = new SpeedSeq();
			ss.handleSpeed();
			LightSeq ls = new LightSeq();
			ls.handleLight();
		}
	}
}
