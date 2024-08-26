package hibernate_tutorial.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class for managing the SessionFactory.
 * This class provides a singleton instance of SessionFactory
 * and handles its creation, retrieval, and shutdown.
 */
public class HibernateUtil {

    // Singleton instance of SessionFactory, initialized during class loading.
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Builds and initializes the SessionFactory from the Hibernate configuration file.
     * This method tries to load the configuration and create a SessionFactory object.
     *
     * @return SessionFactory - the built SessionFactory instance.
     */
    private static SessionFactory buildSessionFactory() {
        try {
            // Load the hibernate.cfg.xml configuration and build the SessionFactory
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception if SessionFactory creation fails
            System.err.println("Initial SessionFactory creation failed." + ex);
            // Rethrow as an ExceptionInInitializerError to terminate the application
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Provides access to the singleton SessionFactory instance.
     *
     * @return SessionFactory - the singleton SessionFactory instance.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Shuts down the SessionFactory by closing the connection.
     * It is recommended to call this method when the application is shutting down
     * to release the resources associated with the SessionFactory.
     */
    public static void shutdown() {
        // Close the SessionFactory, releasing all resources
        getSessionFactory().close();
    }
}
