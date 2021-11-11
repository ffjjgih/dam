package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Model.Hoadon;
import Model.User;
import Utils.Connectjpa;

public class Daohoadon extends Daobase<Hoadon>{
	private Connectjpa conn;
	private EntityManager entity;
	private EntityTransaction transaction;
	private List<Hoadon> lst;
	public Daohoadon() {
		this.conn=new Connectjpa();
		this.lst=new ArrayList<Hoadon>();
	}
	
	public List<Hoadon> getallappointment(){
		this.entity=this.conn.getEntityManager();
		String hql="SELECT h FROM Hoadon h WHERE trangthai=:trang_thai ORDER BY idhoadon DESC";
		TypedQuery<Hoadon> query=entity.createQuery(hql,Hoadon.class);
		query.setParameter("trang_thai", "waiting line");
		this.lst=query.getResultList();
		return lst;
	}
	
	public List<Hoadon> getallpail(){
		this.entity=this.conn.getEntityManager();
		String hql="SELECT h FROM Hoadon h WHERE trangthai=:trang_thai ORDER BY idhoadon";
		TypedQuery<Hoadon> query=entity.createQuery(hql,Hoadon.class);
		query.setParameter("trang_thai", "Order");
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
			String hql = "UPDATE Hoadon h SET h.trangthai =:trang_thai WHERE h.idhoadon =:id_book";
			Query query=entity.createQuery(hql);
			query.setParameter("trang_thai", "Order");
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
			String hql="UPDATE Hoadon h SET trangthai =:trang_thai WHERE idhoadon =:id_book";
			Query query=entity.createQuery(hql);
			query.setParameter("trang_thai", "Cancel Order");
			query.setParameter("id_book", id);
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Hoadon> findbyuser(User u){
		this.entity=this.conn.getEntityManager();
			String hql="SELECT h FROM Hoadon h WHERE user =:id_user";
			TypedQuery<Hoadon> query=entity.createQuery(hql,Hoadon.class);
			query.setParameter("id_user", u);
			this.lst=query.getResultList();
		return this.lst;
	}
	@Override
	public String getdatabase() {
		return Hoadon.class.getSimpleName();
	}

	@Override
	public Class<Hoadon> getclass() {
		return Hoadon.class;
	}

}
