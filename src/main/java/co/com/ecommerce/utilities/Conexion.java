package co.com.ecommerce.utilities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {
	private static final String PERSISTENCE_UNIT_NAME = "Ecommerce";
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return factory;
	}

	public static void disconnect() {
		if (factory != null) {
			factory.close();
		}
	}
}
