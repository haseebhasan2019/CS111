public class Racecar {
	// Instance variables
	private int fuelCapacity;
	private int currentSpeed; // default is 0
	private int currentFuel;

	public static int wheels = 4;

	// Constructor
	public Racecar(int fuelCapacity) {

		this.fuelCapacity = fuelCapacity;
		this.currentSpeed = 0;
		this.currentFuel = fuelCapacity;
	}

	public Racecar(int fuelCapacity, int currentSpeed) {
		this.fuelCapacity = fuelCapacity;
		this.currentSpeed = currentSpeed;
	}

	public Racecar(int fuelCapacity, Object z) {
		this.fuelCapacity = fuelCapacity;
	}



/*
	Racecar a = new Racecar() // fc = 2, csp = 5, cf = 6
	print(Racecar.wheels) // 4
	Racecar b = new Racecar() // fc = 6, csp = 3, cf = 4
	Racecar.wheels = 10;
	print(Racecar.wheels) // 10
	b.wheels
	Racecar.getCurrentSpeed():


*/

	// Getters and setters
	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int newCapacity) {
		if (credentialsAreValid())
		this.fuelCapacity = newCapacity;
	}

	// Logic methods
	public int getRemainingCapacity() {
		return this.fuelCapacity - this.currentFuel;
	}
}