package ro.erikk.classes;

public abstract class Vehicle {
	private String make;
	private float weight; 
	private int noOfWheels;
	
	public Vehicle(String make, float weight, int noOfWheels)
	{
		this.make = make;
		this.weight = weight; 
		this.noOfWheels = noOfWheels;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getNoOfWheels() {
		return noOfWheels;
	}
	public void setNoOfWheels(int noOfWheels) {
		this.noOfWheels = noOfWheels;
	}
	public abstract float getSpeed();
}
