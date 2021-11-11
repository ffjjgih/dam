package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Model.Booking;
import Model.User;
import Utils.Connectjpa;

public class Daobookimplement extends Daobase<Booking>{

	private Booking b;
	private Connectjpa conn;
	private EntityManager entity;
	private EntityTransaction transaction;
	private List<Booking> lst;
	public Daobookimplement() {
		this.b=new Booking();
		this.conn=new Connectjpa();
		this.lst=new ArrayList<Booking>();
	}
	
	public Booking getappointment(int u) {
		this.entity=this.conn.getEntityManager();
		try {
		String hql="SELECT b FROM Booking b WHERE userid =: user_id AND trangthai=:trang_thai";
		TypedQuery<Booking> query=entity.createQuery(hql,Booking.class);
		query.setParameter("user_id", u);
		query.setParameter("trang_thai", "waiting line");
		this.b=query.getSingleResult();
		} catch (NoResultException  e) {
			return null;
		}
		return this.b;
	}
	
	public List<Booking> getallappointment(){
		this.entity=this.conn.getEntityManager();
		String hql="SELECT b FROM Booking b WHERE trangthai=:trang_thai ORDER BY bookingid DESC";
		TypedQuery<Booking> query=entity.createQuery(hql,Booking.class);
		query.setParameter("trang_thai", "waiting line");
		this.lst=query.getResultList();
		return lst;
	}
	
	public List<Booking> getallpaid(){
		this.entity=this.conn.getEntityManager();
		String hql="SELECT b FROM Booking b WHERE trangthai=:trang_thai ORDER BY bookingid ";
		TypedQuery<Booking> query=entity.createQuery(hql,Booking.class);
		query.setParameter("trang_thai", "paid");
		this.lst=query.getResultList();
		return lst;
	}

	public void paid(int id){
		this.entity=this.conn.getEntityManager();
		this.transaction=entity.getTransaction();
		try {
			this.entity.getTransaction().begin();
			entity.flush(); 
			entity.clear();
			String hql = "UPDATE Booking b SET b.trangthai =:trang_thai WHERE b.bookingid =:id_book";
			Query query=entity.createQuery(hql);
			query.setParameter("trang_thai", "paid");
			query.setParameter("id_book", id);
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cancel(int id){
		this.entity=this.conn.getEntityManager();
		this.transaction=entity.getTransaction();
		try {
			this.transaction.begin();
			entity.flush();
			entity.clear();
			String hql="UPDATE Booking b SET trangthai =:trang_thai WHERE bookingid =:id_book";
			Query query=entity.createQuery(hql);
			query.setParameter("trang_thai", "Cancel");
			query.setParameter("id_book", id);
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Booking> findbyuser(User u){
		this.entity=this.conn.getEntityManager();
			String hql="SELECT b FROM Booking b WHERE user =:id_user";
			TypedQuery<Booking> query=entity.createQuery(hql,Booking.class);
			query.setParameter("id_user", u);
			this.lst=query.getResultList();
		return this.lst;
	}
	@Override
	public String getdatabase() {
		return Booking.class.getSimpleName();
	}

	@Override
	public Class<Booking> getclass() {
		return Booking.class;
	}

}
