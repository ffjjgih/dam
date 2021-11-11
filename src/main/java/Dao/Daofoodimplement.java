package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Model.Food;
import Model.User;
import Utils.Connectjpa;

public class Daofoodimplement extends Daobase<Food>{

	private Connectjpa conn;
	private List<Food> lst;
	private EntityManager entity;
	private Food f;
	public Daofoodimplement() {
		this.conn=new Connectjpa();
		this.lst=new ArrayList<Food>();
			this.entity=conn.getEntityManager();
		this.f=new Food();
	}
	@Override
	public String getdatabase() {
		return Food.class.getSimpleName();
	}
	@Override
	public Class<Food> getclass() {
		return Food.class;
	}
	
	public List<Food> showfood(){
		String hql="SELECT f FROM Food f";
		TypedQuery<Food> query=entity.createQuery(hql,Food.class);
		List<Food> t=query.getResultList();
		return t;
	}

}