package main.java.com.crs.service;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    @SuppressWarnings("unchecked")
    public <T> T getService(ServiceType serviceType) {
        switch (serviceType) {
            case COURSE:
                return (T) new CourseServiceImpl();
            case STUDENT:
                return (T) new StudentServiceImpl();
            case ENROLLMENT:
                return (T) new EnrollmentServiceImpl();
            default:
                return null;
        }
    }

    public enum ServiceType {
        COURSE, STUDENT, ENROLLMENT
    }
}
