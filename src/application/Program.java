package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			try {
			System.out.print("Romm Number: ");
			int number = sc.nextInt();
			System.out.print("Data de checkin: dd/MM/yyyy");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de checout:dd/MM/yyyy");
			Date checkOut = sdf.parse(sc.next());
			
			
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("reservation:" + reservation);
			System.out.println();
			System.out.println("Entre com datas para atualizar");
			System.out.print("Data de checkin: dd/MM/yyyy ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de checout: dd/MM/yyyy ");
			checkOut = sdf.parse(sc.next());
			
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("reservation:" + reservation);
		}
		catch(ParseException e) {
			System.out.println("Data invalida");
		}
		catch(DomainException e) {
			System.out.println("erro in reservation:" + e.getMessage());
		}
		sc.close();

	}

}
