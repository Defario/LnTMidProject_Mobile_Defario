
public abstract class Vehicle {
	String type, brand, name, license, typeSpec;
	int topSpeed, gasCap, wheel, ex, helmetPrice;
}

class General extends Vehicle{
	public General (String type, String brand, String name, String license, int topSpeed, int gasCap, 
			int wheel, String typeSpec, int ex) {
		this.type = type;
		this.brand = brand;
		this.name = name;
		this.license = license;
		this.topSpeed = topSpeed;
		this.gasCap = gasCap;
		this.wheel = wheel;
		this.typeSpec = typeSpec;
		this.ex = ex;
	}
}

class Car extends Vehicle{
	
	public Car (String type, String brand, String name, String license, int topSpeed, int gasCap, 
			int wheel, String typeSpec, int ex) {
		this.type = type;
		this.brand = brand;
		this.name = name;
		this.license = license;
		this.topSpeed = topSpeed;
		this.gasCap = gasCap;
		this.wheel = wheel;
		this.typeSpec = typeSpec;
		this.ex = ex;
	}
	
	public void display(){
		System.out.println("Brand : " + this.brand);
		System.out.println("Name : " + this.name);
		System.out.println("License Plate : " + this.license);
		System.out.println("Type : " + this.typeSpec);
		System.out.println("Gas Capacity : " + this.gasCap);
		System.out.println("Top Speed : " + this.topSpeed);
		System.out.println("Wheel(s) : " + this.wheel);
		System.out.println("Entertainment System : " + this.ex);
		
	}
	
	public void entSystem(){
		System.out.println("Turning on entertainment system...");
	}
	
	public void entSystemSuper(){
		System.out.println("Turning on entertainment system...");
		System.out.println("Boosting!");
	}
	
}

class Motor extends Vehicle{
	
	public Motor (String type, String brand, String name, String license, int topSpeed, int gasCap, 
			int wheel, String typeSpec, int ex) {
		this.type = type;
		this.brand = brand;
		this.name = name;
		this.license = license;
		this.topSpeed = topSpeed;
		this.gasCap = gasCap;
		this.wheel = wheel;
		this.typeSpec = typeSpec;
		this.ex = ex;
	}
	
	public void display(){
		System.out.println("Brand : " + this.brand);
		System.out.println("Name : " + this.name);
		System.out.println("License Plate : " + this.license);
		System.out.println("Type : " + this.typeSpec);
		System.out.println("Gas Capacity : " + this.gasCap);
		System.out.println("Top Speed : " + this.topSpeed);
		System.out.println("Wheel(s) : " + this.wheel);
		System.out.println("Helmet : " + this.ex);
		extend();
	}
	
	public void extend() {
		System.out.println(this.name + " is standing!");
	}
	
	public void setHelmetPrice(int helmetPrice) {
		this.helmetPrice = helmetPrice;
	}
	
	public int getHelmetPrice() {
		return this.helmetPrice;
	}
	
}