package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if(!checkOut.after(checkIn)) {
			throw new DomainException( "ERRO NAS DATAS, O CHEKIN NÃO PODE SER DEPOIS DO CHECKOUT") ;
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	public long duration() {
		long diferenca = checkOut.getTime() - checkIn.getTime();//pega a data do checkout e a data do checkin, esse resultado será em milessegundos, por isso a variável dpo tipo LONG
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("reserva antes da data atual");
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException( "ERRO NAS DATAS, O CHEKIN NÃO PODE SER DEPOIS DO CHECKOUT") ;
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}
	@Override
	public String toString() {
		return "Room"
				+ roomNumber
				+ ", checkIn"
				+ sdf.format(checkIn)
				+ ", checkOut"
				+ sdf.format(checkOut)
				+ ","
				+ duration()
				+ "nights";
	
				
	}

}
	