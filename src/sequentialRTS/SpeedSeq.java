package sequentialRTS;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class SpeedSeq {

	
	public void handleSpeed() throws InterruptedException {
		SmartCar sc = new SmartCar();
		Event e = new Event();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("===Event===					Detected Speed = " + e.getSpeedLimit() +" kmh at "+ timestamp);
		if(sc.getSpeed()==e.getSpeedLimit()) {
			System.out.println("===Action===			Maintaining Speed " );
			TimeUnit.SECONDS.sleep(1);
		}
		if(sc.getSpeed()<e.getSpeedLimit()) {
			System.out.println("===Action===			Increasing Speed");
			while(sc.getSpeed()<e.getSpeedLimit()) {
				TimeUnit.SECONDS.sleep(1);
				sc.incspeed();
			}
			System.out.println("===Action===			Target Speed Reached Speed = "+sc.getSpeed());

		}
		if(sc.getSpeed()>e.getSpeedLimit()){
			System.out.println("===Action===			Decreasing Speed");
			while(sc.getSpeed()>e.getSpeedLimit()) {
				TimeUnit.SECONDS.sleep(1);
				sc.decspeed();
			}
			System.out.println("===Action===			Target Speed Reached Speed = "+sc.getSpeed());
		}
	}
}
