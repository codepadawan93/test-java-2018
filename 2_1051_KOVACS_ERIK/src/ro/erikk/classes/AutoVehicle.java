package ro.erikk.classes;

import ro.erikk.interfaces.Driveable;

public class AutoVehicle extends Vehicle implements Driveable{
	
	private int hp;
	
	public AutoVehicle(String make, float weight, int noOfWheels, int hp) throws Exception {
		super(make, weight, noOfWheels);
		if(weight < 0){
			throw new Exception("Weight cannot be negative");
		}
		this.hp = hp;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	@Override
	public boolean isMoving() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getSpeed() {
		// TODO Auto-generated method stub
		// this way for 100 hp we will have 250 top speed, but for 200 hp we will have 500... whatever
		return (float)(hp * 2.5);
	}
	
	@Override
	protected Object clone()
	{
		Object retval = null;
		try{
			retval = new AutoVehicle(getMake(), getWeight(), getNoOfWheels(), getHp());
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return (AutoVehicle)retval;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AutoVehicle) {
			AutoVehicle x = (AutoVehicle)obj;
			return (
					this.getMake().equals(x.getMake()) && 
					this.getWeight() == x.getWeight() &&
					this.getNoOfWheels() == x.getNoOfWheels() &&
					this.getHp() == x.getHp()
			);
		}
		return false;
	}

}
