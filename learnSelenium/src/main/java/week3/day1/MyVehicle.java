package week3.day1;

public class MyVehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Suzuki suz = new Suzuki();
		suz.isGear();
		suz.topSpeed();
		
		AshokLeyland ash = new AshokLeyland();
		ash.fualType();
		ash.multiAxel(22);
		
		//Over loading
		
		Vehicle ve=new Vehicle();
		ve.milage(200);
		ve.milage(200, 2.2);
		
		//Over Riding
		Truck tr = new Truck();
		tr.multiAxel(22);
		ash.multiAxel(4);

	}

}
