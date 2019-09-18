package sequentialRTS;
import java.sql.Timestamp;
import java.util.concurrent.*;
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
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			System.out.println("===Event===			No Object Detected " + timestamp);
			if(sc.getSpeed()==speedLimit) {
				System.out.println("===Action===			Maintaining Speed " + timestamp);
			}
			if(sc.getSpeed()<speedLimit) {
				System.out.println("===Action===			Increasing Speed");
				while(sc.getSpeed()<speedLimit) {
					TimeUnit.SECONDS.sleep(1);
					sc.incspeed();
				}
				Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
				System.out.println("===Action===			Target Speed Reached " + timestamp1);
				System.out.println("===Action===			Maintaining Speed");
			}
			if(sc.getSpeed()>speedLimit){
				while(sc.getSpeed()>speedLimit) {
					TimeUnit.SECONDS.sleep(1);
					sc.decspeed();
				}
				System.out.println("===Action===			Maintaining Speed");
			}
		}
		
		if(CheckCollision==true) {
			System.out.println("===Warning===			Object Detected");
			if(sc.getSpeed()!=0) {
				System.out.println("===Action===			Applying Break");
				TimeUnit.SECONDS.sleep(1);
				sc.setSpeed(30);
				System.out.println("===Action===			Evading Object");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("===Event===			Object Evaded");
			}else {
				System.out.println("===Action===			Evading Object");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("===Event===			Object Evaded");
			}
		}
		
		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
		if(e.isLight()==true) {
			System.out.println("Light Detected at "+timestamp2);
			
			System.out.println("Turning off Light");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Lights Turned Off ");
		}
		if(e.isLight()==false) {
			System.out.println("Light Detected at "+timestamp2);
			
			System.out.println("Turning on Light");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Lights Turned On");
		}
	}
}
