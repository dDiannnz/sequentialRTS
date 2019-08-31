package sequentialRTS;

public class EventHandler {
	int speedLimit;
	int speed;
	public EventHandler(int speedLimit) {
		this.speedLimit=speedLimit;
	}
	public void handleEvent() throws InterruptedException {
		SmartCar sc = new SmartCar();
		if(sc.getSpeed()<speedLimit) {
			while(sc.getSpeed()<speedLimit) {
				java.util.concurrent.TimeUnit.SECONDS.sleep(1);
				sc.incspeed();
				System.out.println("Current Speed "+sc.getSpeed());
			}
			System.out.println("Maintaining Speed");
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
