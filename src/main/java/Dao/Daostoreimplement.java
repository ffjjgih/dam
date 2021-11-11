package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Model.Store;
import Utils.Connectjpa;

public class Daostoreimplement extends Daobase<Store>{

	private Store st;
	private List<Store> lststore;
	private Connectjpa conn;
	private EntityManager entity;
	public Daostoreimplement() {
		this.st=new Store();
		this.lststore=new ArrayList<Store>();
		this.conn=new Connectjpa();
		entity=conn.getEntityManager();
	}
	
	@Override
	public String getdatabase() {
		return Store.class.getSimpleName();
	}

	@Override
	public Class<Store> getclass() {
		return Store.class;
	}

}
