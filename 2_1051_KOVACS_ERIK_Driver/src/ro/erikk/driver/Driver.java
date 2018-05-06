package ro.erikk.driver;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ro.erikk.classes.AutoVehicle;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoVehicle av = null;
		try {
			av = new AutoVehicle("BMW", 1500, 4, 123);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<AutoVehicle> autoVehicles = new ArrayList<AutoVehicle>();
		
		try {
			autoVehicles.add(av);
			autoVehicles.add(new AutoVehicle("Audi", 1600, 4, 135));
			autoVehicles.add(new AutoVehicle("Mercedes", 1850, 4, 123));
			autoVehicles.add(new AutoVehicle("Jaguar", 1700, 4, 123));
			autoVehicles.add(new AutoVehicle("BMW", 2100, 4, 123));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Initial list is: ");
		for(AutoVehicle car : autoVehicles)
		{
			System.out.println(
					String.format(
							"Car make:%s\nWeight:%.2fkg\nWheels:%d\nHP:%d\n", 
							car.getMake(),
							car.getWeight(),
							car.getNoOfWheels(),
							car.getHp()
					)
				);
		}
		
		// write the data to file...
		System.out.println("Writing data to file...");
		OutputStreamWriter outFile = null;
		
		try {
			
			outFile = new OutputStreamWriter(
					new BufferedOutputStream(
							new FileOutputStream("cars.txt")
							)
					);
			
			for(AutoVehicle car : autoVehicles)
			{
				outFile.write(
						String.format(
								"%s %f %d %d\r\n", 
								car.getMake(),
								car.getWeight(),
								car.getNoOfWheels(),
								car.getHp()
								)
						);
			}
			
			if(outFile != null) { outFile.close(); }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		List<AutoVehicle> autoVehicles2 = new ArrayList<AutoVehicle>();
		// now read the data from file
		Scanner inFile = null;
		try {
			
			inFile = new Scanner(new File("cars.txt"));
			
			while(inFile.hasNextLine()){
		         String line = inFile.nextLine();
		         // ideally this should be some better separator than just space - think about when
		         // make is Roll's Royce ...
		         String[] data = line.split("\\s+");
		         
		         autoVehicles2.add( 
		        		 new AutoVehicle(
		        				 data[0], 
		        				 Float.parseFloat(data[1]), 
		        				 Integer.parseInt(data[2]), 
		        				 Integer.parseInt(data[3])
		        		)
		         );
		    }
			
			if(inFile != null) { inFile.close(); }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		// now display the recovered list
		System.out.println("Recovered list is: ");
		for(AutoVehicle car : autoVehicles2)
		{
			System.out.println(
				String.format(
						"Car make:%s\nWeight:%.2fkg\nWheels:%d\nHP:%d\n", 
						car.getMake(),
						car.getWeight(),
						car.getNoOfWheels(),
						car.getHp()
				)
			);
		}
	}

}
