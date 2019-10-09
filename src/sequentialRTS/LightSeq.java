package sequentialRTS;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class LightSeq {
	private static boolean Lamp;
	
	public static boolean isLamp() {
		return Lamp;
	}



	public void setLamp(boolean lamp) {
		this.Lamp = lamp;
	}


	public void handleLight() throws InterruptedException {

		Timestamp lightTime = new Timestamp(System.currentTimeMillis());
		Event e = new Event();
		long detectTime = lightTime.getTime()-e.getEventGenerate();
		if(e.isLight()==true) {
			if(isLamp()==true) {
				System.out.println("===Event===						Light Detected at "+lightTime);
				
				System.out.println("===Action===			Turning off Light");
				TimeUnit.SECONDS.sleep(1);
				setLamp(false);
				Timestamp onTime = new Timestamp(System.currentTimeMillis());
				System.out.println("===Action===			Lights Turned Off " + onTime);
				long executionTime = onTime.getTime()-lightTime.getTime();
				System.out.println("Detection Time : "+detectTime+" || Execution Time : "+executionTime+" milliseconds");
			}
		}
		if(e.isLight()==false) {
			if(isLamp()==false) {
				System.out.println("===Action===					Light not detected at "+lightTime);
				
				System.out.println("===Action===			Turning on Lamps");
				TimeUnit.SECONDS.sleep(1);
				setLamp(true);
				Timestamp offTime = new Timestamp(System.currentTimeMillis());
				System.out.println("===Action===			Lamps Turned On "+ offTime);
				
				long executionTime = offTime.getTime()-lightTime.getTime();
				System.out.println("Detection Time : "+detectTime+ " || Execution Time : "+executionTime+" milliseconds");
			}
		}
	}
}
