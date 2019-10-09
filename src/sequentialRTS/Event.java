package sequentialRTS;

import java.sql.Timestamp;
import java.util.Random;

public class Event {
	private static int speedLimit;
	private static boolean Collision;
	private static  boolean Light;
	public static long eventGenerate;
	
	public boolean isLight() {
		return Light;
	}

	public void setLight(boolean light) {
		this.Light = light;
	}

	public boolean isCollision() {
		return Collision;
	}

	public static void setCollision(boolean collision) {
		Collision = collision;
	}

	public int getSpeedLimit() {
		return speedLimit;
	}
	
	public  void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}
	
	
	public long getEventGenerate() {
		return eventGenerate;
	}

	public static void setEventGenerate(long eventGenerate) {
		Event.eventGenerate = eventGenerate;
	}

	public void randomEvent(){
		Random r = new Random();
		int ranSpeed=r.nextInt(3);
		
		if(ranSpeed==0) {
			setSpeedLimit(30);
		}
		if(ranSpeed==1) {
			setSpeedLimit(90);
		}
		if(ranSpeed==2) {
			setSpeedLimit(60);
		}
		if(ranSpeed==3) {
			setSpeedLimit(110);
		}
		Timestamp eventTime = new Timestamp(System.currentTimeMillis());
		eventGenerate=eventTime.getTime();
		System.out.println("===Environment===			Speed Limit = "+getSpeedLimit() + " at "+eventTime);
		
		int collisionRNG = r.nextInt(2);
		if (collisionRNG==0) {
			setCollision(true);
			System.out.println("===Environment===			Collision = TRUE at "+eventTime);
		}
		if (collisionRNG==1) {
			setCollision(false);
			System.out.println("===Environment===			Collision = FALSE at "+eventTime);
		}
		
		int lightRNG = r.nextInt(2);
		if (collisionRNG==0) {
			setLight(true);
			System.out.println("===Environment===			LIGHT = TRUE at "+eventTime);
		}
		if (collisionRNG==1) {
			setLight(false);
			System.out.println("===Environment===			LIGHT = FALSE at "+eventTime);
		}
		
		eventGenerate=eventTime.getTime();

	}


}
