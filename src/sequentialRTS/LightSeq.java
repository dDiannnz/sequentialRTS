package sequentialRTS;

import java.sql.Timestamp;

public class LightSeq {
	private static boolean Lamp;

	public static boolean isLamp() {
		return Lamp;
	}



	public void setLamp(boolean lamp) {
		this.Lamp = lamp;
	}


	public void handleLight() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Event e = new Event();
		if(e.isLight()==true) {
			if(isLamp()==true) {
				System.out.println("===Event===						Light Detected at "+timestamp);
				
				System.out.println("===Action===			Turning off Light");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				setLamp(false);
				System.out.println("===Action===			Lights Turned Off ");
			}
		}
		if(e.isLight()==false) {
			if(isLamp()==false) {
				System.out.println("===Action===					Light not detected at "+timestamp);
				
				System.out.println("===Action===			Turning on Lamps");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
				setLamp(true);
				System.out.println("===Action===			Lamps Turned On");
			}
		}
	}
}
