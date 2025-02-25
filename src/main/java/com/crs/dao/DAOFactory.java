package main.java.com.crs.dao;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public <T> T getDAO(DAOType daoType) {
        switch (daoType) {
            case COURSE:
                return (T) new CourseDAOImpl();
            // Add other DAO types here (e.g., STUDENT, ENROLLMENT)
            default:
                return null;
        }
    }

    public enum DAOType {
        COURSE
        // Add other DAO types here (e.g., STUDENT, ENROLLMENT)
    }
}