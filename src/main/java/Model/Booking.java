package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the booking database table.
 * 
 */
@Entity
@Table(name="booking")
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingid;

	private String loaiban;

	private String ngaydatban;

	private int soluong;

	private Time thoigiandatban;

	private String trangthai;

	//bi-directional many-to-one association to Store
	@ManyToOne
	@JoinColumn(name="idstore")
	private Store store;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;

	public Booking() {
	}

	public int getBookingid() {
		return this.bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public String getLoaiban() {
		return this.loaiban;
	}

	public void setLoaiban(String loaiban) {
		this.loaiban = loaiban;
	}

	public String getNgaydatban() {
		return this.ngaydatban;
	}

	public void setNgaydatban(String ngaydatban) {
		this.ngaydatban = ngaydatban;
	}

	public int getSoluong() {
		return this.soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public Time getThoigiandatban() {
		return this.thoigiandatban;
	}

	public void setThoigiandatban(Time thoigiandatban) {
		this.thoigiandatban = thoigiandatban;
	}

	public String getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}