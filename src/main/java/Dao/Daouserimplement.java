package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.User;
import Utils.Connectjpa;

public class Daouserimplement extends Daobase<User> {

	private Connectjpa conn;
	private EntityManager entity;
	private List<User> lst;
	private EntityTransaction transaction;

	public Daouserimplement() {
		this.conn = new Connectjpa();
		this.entity=this.conn.getEntityManager();
		lst = new ArrayList<User>();
	}

	public List<User> xuatlstuser() {
		TypedQuery<User> query = conn.getEntityManager().createNamedQuery("User.findAll", User.class);
		lst = query.getResultList();
		return lst;
	}

	public User checkuser(String tk) {
		User u = new User();
		try {
		EntityManager em = conn.getEntityManager();
		String hql = "SELECT u FROM User u WHERE u.username = :user_name";
		TypedQuery<User> query = em.createQuery(hql, User.class);
		query.setParameter("user_name", tk);
		u = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return u;
	}
	
	public User login(String tk, String mk) {
		User u = new User();
		try {
		EntityManager em = conn.getEntityManager();
		String hql = "SELECT u FROM User u WHERE u.username = :user_name and pass=: pw";
		TypedQuery<User> query = em.createQuery(hql, User.class);
		query.setParameter("user_name", tk);
		query.setParameter("pw", mk);
		u = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return u;
	}
	
	public List<User> findadmin() {
		User u = new User();
		try {
		EntityManager em = conn.getEntityManager();
		String hql = "SELECT u FROM User u WHERE u.roles = :chuc_vu";
		TypedQuery<User> query = em.createQuery(hql, User.class);
		query.setParameter("chuc_vu", "admin");
		this.lst = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return lst;
	}

	public User finduser(String email, String username) {
		User u = new User();
		try {
			String hql = "SELECT u FROM User u WHERE username =:user_name and email=:email_id";
			TypedQuery<User> query = entity.createQuery(hql,User.class);
			query.setParameter("user_name", username);
			query.setParameter("email_id", email);
			u = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return u;
	}
	
	public void changepw(int id,String newpass) {
		this.entity=this.conn.getEntityManager();
		this.transaction=entity.getTransaction();
		try {
			this.transaction.begin();
			entity.flush();
			entity.clear();
			String hql="UPDATE User u SET pass =:pw WHERE userid =:id_book";
			Query query=entity.createQuery(hql);
			query.setParameter("pw", newpass);
			query.setParameter("id_book", id);
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeprofile(User u) {
		this.entity=this.conn.getEntityManager();
		this.transaction=entity.getTransaction();
		try {
			this.transaction.begin();
			entity.flush();
			entity.clear();
			String hql="UPDATE User u SET diachi =:dia_chi, email =:gmail, fullname =:name ,sdt=:sodt WHERE userid =:id_book";
			Query query=entity.createQuery(hql);
			query.setParameter("dia_chi", u.getDiachi());
			query.setParameter("gmail", u.getEmail());
			query.setParameter("name", u.getFullname());
			query.setParameter("sodt", u.getSdt());
			query.setParameter("id_book", u.getUserid());
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getdatabase() {
		return User.class.getSimpleName();
	}

	@Override
	public Class<User> getclass() {
		return User.class;
	}

}
