package com.xpenses.transaction.service;

import com.xpenses.transaction.enums.LogicType;
import com.xpenses.transaction.enums.OperationType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceRegistry {

    private final Map<OperationType, CommonService> serviceRegistry = new HashMap<>();

    public ServiceRegistry(List<CommonService> serviceList) {
        for (CommonService service : serviceList)
            serviceRegistry.put(service.getOperationType(), service);
    }

    @SuppressWarnings("unchecked")
    public <T extends CommonService> T getService(LogicType logicType) {
        Class<T> serviceClass = (Class<T>) logicType.getServiceClass();
        CommonService service = serviceRegistry.get(logicType.getOperationType());
        if (serviceClass.isInstance(service))
            return serviceClass.cast(service);
        return null;
    }

}
