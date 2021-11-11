package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Model.Cart;
import Model.User;
import Utils.Connectjpa;

public class Daocartimplement extends Daobase<Cart>{

	private Cart c;
	private Connectjpa conn;
	private EntityManager entity;
	private List<Cart> lst;
	public Daocartimplement() {
		this.c=new Cart();
		this.conn=new Connectjpa();
		this.entity=conn.getEntityManager();
		this.lst=new ArrayList<Cart>();
	}
	
	public List<Cart> showcartbyid(int userid) {
		String hql="SELECT c FROM Cart c WHERE userid=: user_id";
		TypedQuery<Cart> query=entity.createQuery(hql,Cart.class);
		query.setParameter("user_id",userid);
		this.lst=query.getResultList();
		return this.lst;
	}

	public Double getallpricebyid(int userid) {
		this.entity = this.conn.getEntityManager();
		Double gia=null;
		try {
			this.entity.getTransaction().begin();
			entity.flush(); entity.clear();
			String hql="SELECT SUM(gia) FROM Cart c WHERE userid=:user_id";
			Query query=entity.createQuery(hql);
			gia=(Double) query.getSingleResult();
			this.entity.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return gia;
				
	}

	@Override
	public String getdatabase() {
		return Cart.class.getSimpleName();
	}
	@Override
	public Class<Cart> getclass() {
		// TODO Auto-generated method stub
		return Cart.class;
	}

}
