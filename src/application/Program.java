package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = input.nextInt();
		
		System.out.print("Check-In Date: ");
		Date checkIn = sdf.parse(input.next());
		System.out.print("Check-Out Date: ");
		Date checkOut = sdf.parse(input.next());	
		
		if (!checkOut.after(checkIn)) {
			System.out.println("erro");
		}
		
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-In Date: ");
			checkIn = sdf.parse(input.next());
			System.out.print("Check-Out Date: ");
			checkOut = sdf.parse(input.next());
			
			Date now = new Date();
			
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("erro");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("erro");
			}
			
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println(reservation);
			}
		}
	}

}
