package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "ERRO NAS DATAS, O CHEKIN NÃO PODE SER DEPOIS DO CHECKOUT";
		}
		if(!checkOut.after(checkIn)) {
			return "ERRO NAS DATAS, O CHEKIN NÃO PODE SER DEPOIS DO CHECKOUT" ;
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
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
	