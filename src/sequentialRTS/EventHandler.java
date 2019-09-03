package sequentialRTS;

public class EventHandler {
	int speedLimit;
	int speed;
	boolean CheckCollision;
	public EventHandler(int speedLimit,boolean CheckCollision) {
		this.speedLimit=speedLimit;
		this.CheckCollision=CheckCollision;
	}
	public void handleEvent() throws InterruptedException {
		SmartCar sc = new SmartCar();
		Event e = new Event();
		System.out.println("===Event===			Checking Surrounding");
		if (CheckCollision==false) {
			System.out.println("===Event===			No Object Detected");
			if(sc.getSpeed()==speedLimit) {
				System.out.println("===Action===			Maintaining Speed");
			}
			if(sc.getSpeed()<speedLimit) {
				System.out.println("===Action===			Increasing Speed");
				while(sc.getSpeed()<speedLimit) {
					java.util.concurrent.TimeUnit.SECONDS.sleep(1);
					sc.incspeed();
				}
				System.out.println("===Action===			Target Speed Reached");
				System.out.println("===Action===			Maintaining Speed");
			}
			if(sc.getSpeed()>speedLimit){
				while(sc.getSpeed()>speedLimit) {
					java.util.concurrent.TimeUnit.SECONDS.sleep(1);
					sc.decspeed();
				}
				System.out.println("===Action===			Maintaining Speed");
			}
		}
		
		if(CheckCollision==true) {
			System.out.println("===Warning===			Object Detected");
			if(sc.getSpeed()!=0) {
				System.out.println("===Action===			Applying Break");
				java.util.concurrent.TimeUnit.SECONDS.sleep(1);
				sc.setSpeed(30);
				System.out.println("===Action===			Evading Object");
				java.util.concurrent.TimeUnit.SECONDS.sleep(2);
				System.out.println("===Event===			Object Evaded");
			}else {
				System.out.println("===Action===			Evading Object");
				java.util.concurrent.TimeUnit.SECONDS.sleep(2);
				System.out.println("===Event===			Object Evaded");
			}
		}
	}
}
