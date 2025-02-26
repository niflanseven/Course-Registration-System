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

    @SuppressWarnings("unchecked")
    public <T> T getDAO(DAOType daoType) {
        switch (daoType) {
            case COURSE:
                return (T) new CourseDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            case ENROLLMENT:
                return (T) new EnrollmentDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOType {
        COURSE, STUDENT, ENROLLMENT
    }
}