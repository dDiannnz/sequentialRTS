package sequentialRTS;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class SpeedSeq {

	
	public void handleSpeed() throws InterruptedException {
		Timestamp speedTime = new Timestamp(System.currentTimeMillis());
		SmartCar sc = new SmartCar();
		Event e = new Event();
		
		System.out.println("===Event===					Detected Speed = " + e.getSpeedLimit() +" kmh at "+ speedTime);
		long detectTime = speedTime.getTime()-e.getEventGenerate();
//		if(sc.getSpeed()==e.getSpeedLimit()) {
//			System.out.println("===Action===			Maintaining Speed " );
//			TimeUnit.SECONDS.sleep(1);
//		}
		
		if(sc.getSpeed()<e.getSpeedLimit()) {
			System.out.println("===Action===			Increasing Speed");
			while(sc.getSpeed()<e.getSpeedLimit()) {
				TimeUnit.SECONDS.sleep(1);
				sc.incspeed();
			}
			Timestamp upSpeed = new Timestamp(System.currentTimeMillis());
			System.out.println("===Action===			Target Speed Reached Speed = "+sc.getSpeed()+ " at " +upSpeed);
			long executionTime = upSpeed.getTime()-speedTime.getTime();
			System.out.println("Detection Time : "+detectTime+" || Execution Time : "+executionTime+" milliseconds");

		}
		
		if(sc.getSpeed()>e.getSpeedLimit()){
			System.out.println("===Action===			Decreasing Speed");
			while(sc.getSpeed()>e.getSpeedLimit()) {
				TimeUnit.SECONDS.sleep(1);
				sc.decspeed();
			}
			Timestamp downSpeed = new Timestamp(System.currentTimeMillis());
			System.out.println("===Action===			Target Speed Reached Speed = "+sc.getSpeed()+ " at " +downSpeed);
			long executionTime = downSpeed.getTime()-speedTime.getTime();
			System.out.println("Detection Time : "+detectTime+" || Execution Time : "+executionTime+" milliseconds");
		}
		
		
	}
}
