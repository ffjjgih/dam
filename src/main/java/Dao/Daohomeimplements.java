package Dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;

import Model.Home;
import Utils.Connectjpa;

public class Daohomeimplements extends Daobase<Home>{

	private ArrayList<Home> lsthome;
	private Connectjpa conn;
	private EntityManager manager;
	private EntityTransaction transaction;
	private Home home;
	public Daohomeimplements() {
		this.lsthome=new ArrayList<Home>();
		this.conn=new Connectjpa();
		this.home=new Home();
	}
	public Home findbyidhome(int id) {
		this.manager=this.conn.getEntityManager();
	this.home=manager.find(Home.class, id);
		return this.home;
	}
	public void deletehome(int id) {
		this.manager=this.conn.getEntityManager();
		this.transaction=this.manager.getTransaction();
		try {
			this.transaction.begin();
			this.manager.flush(); this.manager.clear();
			String hql="DELETE Home h WHERE h.idhome =:id_home";
			Query query =this.manager.createQuery(hql); 
			query.setParameter("id_home", id);
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
			throw e;
		}finally {
			this.manager.close();
		}
	}

	public Home findbanner(int id) {
		this.manager=this.conn.getEntityManager();
		this.home=this.manager.find(Home.class, id);
		return home;
	}
	@Override
	public String getdatabase() {
		return Home.class.getSimpleName();
	}
	@Override
	public Class<Home> getclass() {
		return Home.class;
	}
	public ArrayList<Home> gethomeall(){
		this.manager=this.conn.getEntityManager();
		String hql="SELECT h FROM Home h";
		TypedQuery<Home> query=manager.createQuery(hql,Home.class);
		this.lsthome=(ArrayList<Home>) query.getResultList();
		return this.lsthome;
	}
}
