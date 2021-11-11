package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Model.User;
import Utils.Connectjpa;

abstract public class Daobase<T> {
	abstract public String getdatabase();
	abstract public Class<T> getclass();
	private Connectjpa conn;
	private EntityManager entity;
	private EntityTransaction transaction;
	public Daobase(){
		this.conn=new Connectjpa();
	}
	 public T create(T t){
		Connectjpa conn=new Connectjpa();
		this.entity=this.conn.getEntityManager();
		this.transaction=this.entity.getTransaction();
		try {
			transaction.begin();
			entity.persist(t);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return t;
	}
	 public void delete(T t){
			this.entity=this.conn.getEntityManager();
			this.transaction=this.entity.getTransaction();
		try {
			transaction.begin();
			entity.remove(t);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	 public void update(T t) throws Exception{
			this.entity=this.conn.getEntityManager();
			this.transaction=this.entity.getTransaction();
		try {
			transaction.begin();
			entity.merge(t);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	 public T findbyid(int id) {
			this.entity=this.conn.getEntityManager();
			this.transaction=this.entity.getTransaction();
		Connectjpa conn=new Connectjpa();
		EntityManager manager=conn.getEntityManager();
		T t=manager.find(getclass(), id);
		return t;
	}
	 
	public List<T> getall() {
		this.entity=this.conn.getEntityManager();
		this.transaction=this.entity.getTransaction();
		String hql="From"+getdatabase();
		TypedQuery<T> query=entity.createQuery(hql,getclass());
		List<T> t=query.getResultList();
		return t;
	}
}
	

