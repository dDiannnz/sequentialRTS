package sequentialRTS;
import java.sql.Timestamp;
import java.util.concurrent.*;
public class CollisionSeq {


	public void handleEvent() throws InterruptedException {
		SmartCar sc = new SmartCar();
		Event e = new Event();
		Timestamp colliTime = new Timestamp(System.currentTimeMillis());
		long detectTime = colliTime.getTime()-e.getEventGenerate();
		if(e.isCollision()==true) {
			System.out.println("===Warning===					Object Detected at "+colliTime);
			if(sc.getSpeed()!=0) {
				System.out.println("===Action===			Applying Break");
				TimeUnit.SECONDS.sleep(1);
				sc.setSpeed(30);
				System.out.println("===Action===			Evading Object");
				TimeUnit.SECONDS.sleep(2);
				e.setCollision(false);
				Timestamp evaTime = new Timestamp(System.currentTimeMillis());
				System.out.println("===Event===			Object Evaded at "+evaTime );
				long executionTime = evaTime.getTime()-colliTime.getTime();
				System.out.println("Detection Time : "+detectTime+" || Execution Time : "+executionTime+" milliseconds");
			}else {
				System.out.println("===Action===			Evading Object");
				TimeUnit.SECONDS.sleep(2);
				e.setCollision(false);
				Timestamp evaTime1 = new Timestamp(System.currentTimeMillis());
				System.out.println("===Event===			Object Evaded at "+evaTime1);
				long executionTime = evaTime1.getTime()-colliTime.getTime();
				System.out.println("Detection Time : "+detectTime+" || Execution Time : "+executionTime+" milliseconds");
			}
			
		}
		
		if(e.isCollision()==false) {
			System.out.println("===Warning===					Object Not Detected at "+colliTime);
		}
		
	}
}
