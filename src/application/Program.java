package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		System.out.print("Romm Number: ");
		int number = sc.nextInt();
		System.out.print("Data de checkin: dd/MM/yyyy");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de checout:dd/MM/yyyy");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("ERRO NAS DATAS, O CHEKIN NÃO PODE SER DEPOIS DO CHECKOUT" );
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("reservation:" + reservation);
			System.out.println();
			System.out.println("Entre com datas para atualizar");
			System.out.print("Data de checkin: dd/MM/yyyy ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de checout: dd/MM/yyyy ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("ERRO NAS DATAS, O CHEKIN NÃO PODE SER DEPOIS DO CHECKOUT");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("ERRO NAS DATAS, O CHEKIN NÃO PODE SER DEPOIS DO CHECKOUT" );
			}
			else {
			reservation.updateDates(checkIn, checkOut);
			System.out.println("reservation:" + reservation);
			}
		}
		
		
		sc.close();

	}

}
