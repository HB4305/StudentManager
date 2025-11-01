package service.business;

import models.Objectbase;
import java.util.HashMap;
import java.util.Map;

public class Factory extends Objectbase {
    // singleton instance
    private static Factory _instance = null;
    private static Map<String, Objectbase> _servicesForType = new HashMap<>();

    private Factory() {
        config();
    }

    private static void config() {
        // register services here
        // e.g., _servicesForType.put("StudentService", new StudentService());
        _servicesForType.put("StudentParser", new studentParser());
    }

    public static Factory getInstance() {
        if (_instance == null) {
            _instance = new Factory();
        }
        return _instance;
    }

    public void registerServiceForType(String type, Objectbase service) {
        _servicesForType.put(type, service);
    }

    public Objectbase getServiceForType(String type) {
        return _servicesForType.get(type);
    }

    @Override
    public String toString() {
        return "Factory";
    }
}
