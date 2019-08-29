package sequentialRTS;

public class EventHandler {
	int speedLimit;
	int speed;
	public EventHandler(int speedLimit,int speed) {
		this.speedLimit=speedLimit;
		this.speed=speed;
	}
	public void handleEvent() throws InterruptedException {
		SmartCar sc = new SmartCar();
		if(sc.getSpeed()<speedLimit) {
			while(sc.getSpeed()<speedLimit) {
				java.util.concurrent.TimeUnit.SECONDS.sleep(1);
				sc.incspeed();
				System.out.println("Current Speed "+sc.getSpeed());
			}
			
		}if(sc.getSpeed()>speedLimit){
			while(sc.getSpeed()>speedLimit) {
				java.util.concurrent.TimeUnit.SECONDS.sleep(1);
				sc.decspeed();
				System.out.println("Current Speed "+sc.getSpeed());
			}
			System.out.println("Maintaining Speed");
		}else {
			System.out.println("Maintaining Speed");
		}
	}
}
