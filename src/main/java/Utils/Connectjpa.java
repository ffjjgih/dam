package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class Connectjpa {
	private static EntityManager em;
	private static EntityManagerFactory factory;
	
	public Connectjpa() {
		
	}
	public static EntityManagerFactory getEntityManagerFactory() {
		if(factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("finaldam");
		}
		return factory;
	}
	public static EntityManager getEntityManager() {		
		if(em == null || !em.isOpen()) {
			getEntityManagerFactory();
			em = factory.createEntityManager();
		}
		return em;
	}
	

}
