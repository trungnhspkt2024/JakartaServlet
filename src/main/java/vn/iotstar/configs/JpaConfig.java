package vn.iotstar.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
@PersistenceContext
public class JpaConfig {
	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springDBMySQL");
		return factory.createEntityManager();
	}
}
