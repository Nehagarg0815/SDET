package JavaActivity1;

public class Car {

	
int make;
int tyres;
int doors;
String color;
String transmission;
Car () {
	tyres=4;
	doors = 4;
}
public void displayCharacterstics() {
	System.out.println("Color of the Car: " + color);
	System.out.println("Transmission of the Car: " + transmission);
	System.out.println("Make of the Car: " + make);
	System.out.println("Number of Tyres on car: " +tyres);
	System.out.println("Number of doors on car: " +doors);
}
public void accelerate()
{
	System.out.println("The car is moving forward");
	}
public void brake()
{
  System.out.println("The car has stopped");
}

}
