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
            // Add other service types here (e.g., STUDENT, ENROLLMENT)
            default:
                return null;
        }
    }

    public enum ServiceType {
        COURSE
        // Add other service types here (e.g., STUDENT, ENROLLMENT)
    }
}
