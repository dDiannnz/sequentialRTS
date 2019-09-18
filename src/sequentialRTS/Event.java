package sequentialRTS;

import java.util.Random;

public class Event {
	private static int speedLimit;
	private static boolean Collision;
	private static  boolean Light;
	
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
		
		int collisionRNG = r.nextInt(2);
		if (collisionRNG==0) {
			setCollision(true);
		}
		if (collisionRNG==1) {
			setCollision(false);
		}
		
		int lightRNG = r.nextInt(2);
		if (collisionRNG==0) {
			setLight(true);
		}
		if (collisionRNG==1) {
			setLight(false);
		}
	}


}
