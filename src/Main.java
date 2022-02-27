
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	
	Vector<General> data= new Vector<>();
	Vector<Car> dataCar= new Vector<>();
	Vector<Motor> dataMotor= new Vector<>();
	
	int banyakData = 0;
	
	//MENU UTAMA
		void menu() {
			System.out.println("1. Input");
			System.out.println("2. Show");
			System.out.println("3. Exit");
			int a;
			
			do {
			System.out.print(">> ");
			a = scan.nextInt();
			scan.nextLine();
			} while (a>3|| a<1);
			
			switch(a) {
				case 1:
					input();
					break;
				case 2:
					show();
					break;
				case 3:
					break;
			}
		}
		//MENU UTAMA DONE
		
		//INPUT
		void input() {
			
			String type, brand, name, license, typeSpec;
			int topSpeed, gasCap, wheel, ex;
			
			do {
				System.out.print("Input type [Car | Motorcyle]: ");
				type = scan.nextLine();
			} while ( !type.equals("Car") && !type.equals("Motorcycle"));	
			
			do {
				System.out.print("Input brand [>= 5]: ");
				brand = scan.nextLine();
			} while (brand.length() < 5);			
			
			do {
				System.out.print("Input name [>= 5]: ");
				name = scan.nextLine();
			} while (name.length() < 5);
			
			System.out.print("Input license: ");
			license = scan.nextLine();
		
			do {
				System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
				topSpeed = scan.nextInt();
				scan.nextLine();
			} while (topSpeed < 100 || topSpeed > 250);
			
			do {
				System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
				gasCap = scan.nextInt();
				scan.nextLine();
			} while (gasCap < 30 || gasCap > 60);
			
			if(type.equals("Car")) {
				do {
					System.out.print("Input wheel [4 <= wheel <= 6]: ");
					wheel = scan.nextInt();
					scan.nextLine();
				} while (wheel < 4 || wheel > 6);
			}
			else {
				do {
					System.out.print("Input wheel [2 <= wheel <= 3]: ");
					wheel = scan.nextInt();
					scan.nextLine();
				} while (wheel < 2 || wheel > 3);
			}
			
			if(type.equals("Car")) {
				do {
					System.out.print("Input type [SUV | Supercar | Minivan]: ");
					typeSpec = scan.nextLine();
				} while (!typeSpec.equals("SUV") && !typeSpec.equals("Supercar") && !typeSpec.equals("Minivan"));
			}
			else {
				do {
					System.out.print("Input type [Automatic | Manual]: ");
					typeSpec = scan.nextLine();
				} while (!typeSpec.equals("Automatic") && !typeSpec.equals("Manual"));
			}
			
			if(type.equals("Car")) {
				do {
					System.out.print("Input entertainment system amount [>= 1]: ");
					ex = scan.nextInt();
					scan.nextLine();
				} while (ex < 1);
			}
			else {
				do {
					System.out.print("Input amount of helmet [>= 1]: ");
					ex = scan.nextInt();
					scan.nextLine();
				} while (ex < 1);
			}
			
			data.add(new General(type, brand, name, license, topSpeed, gasCap, wheel, typeSpec, ex));
			
			if(type.equals("Car")) {
				dataCar.add(new Car(type, brand, name, license, topSpeed, gasCap, wheel, typeSpec, ex));
				dataMotor.add(new Motor("-", "-", "-", "-", -1, -1, -1, "-", -1));
			}
			else {
				dataCar.add(new Car("-", "-", "-", "-", -1, -1, -1, "-", -1));
				dataMotor.add(new Motor(type, brand, name, license, topSpeed, gasCap, wheel, typeSpec, ex));
			}
			banyakData++;
			
			System.out.println("ENTER to return");
			scan.nextLine();

			System.out.println("\n");
			menu();
		}
		//INPUT DONE
	
		
		//SHOW
		void show() {
			System.out.println("|=======|=========================|=========================|");
			System.out.println("|No     |Type                     |Name                     |");
			System.out.println("|=======|=========================|=========================|");
			
			if(banyakData > 0) {
				for(int i=0; i<banyakData; i++) {
					System.out.printf("|%-7s|%-25s|%-25s|\n", i+1, data.get(i).type, data.get(i).name);
					System.out.println("|=======|=========================|=========================|");
				}
				
				int a;
				do {
					System.out.print("Pick a vehicle number to test drive[Enter'0' to exit]: ");
					a = scan.nextInt();
				} while (a > banyakData || a < 0);
				
				if(a == 0) {
					System.out.println("\n");
					menu();
				}
				else {
					if(data.get(a-1).type.equals("Car")) {
						dataCar.get(a-1).display();
						if(dataCar.get(a-1).typeSpec.equals("Supercar")) {
							dataCar.get(a-1).entSystemSuper();
						}
						else {
							dataCar.get(a-1).entSystem();
						}
					}
					else {
						dataMotor.get(a-1).display();
						int helmetPrice;
						System.out.print("Input helmet price: ");
						helmetPrice = scan.nextInt();
						dataMotor.get(a-1).setHelmetPrice(helmetPrice);
						int price = dataMotor.get(a-1).getHelmetPrice();
						System.out.println("Price: " + price);
					}
				}
			}
			else {
				System.out.println("|-      |-                        |-                        |");
				System.out.println("|=======|=========================|=========================|");
			}

			System.out.println("\n");
			menu();
		}
		//SHOW DONE
		
	public Main() {
		// TODO Auto-generated constructor stub
		System.out.println("Welcome to PT Meiying Management App:");
		menu();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
