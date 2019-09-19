package sequentialRTS;
import java.sql.Timestamp;
import java.util.concurrent.*;
public class CollisionSeq {


	public void handleEvent() throws InterruptedException {
		SmartCar sc = new SmartCar();
		Event e = new Event();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if(e.isCollision()==true) {
			System.out.println("===Warning===					Object Detected at "+timestamp);
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
		
	}
}
