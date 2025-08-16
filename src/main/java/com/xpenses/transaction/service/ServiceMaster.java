package com.xpenses.transaction.service;

import com.xpenses.transaction.dto.IncomeParamsBean;
import com.xpenses.transaction.dto.IncomeResponseBean;
import com.xpenses.transaction.enums.LogicType;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ServiceMaster {

    private static final Logger logger = LogManager.getLogger(ServiceMaster.class);
    private final ApplicationContext context;

    public void execute(IncomeParamsBean paramsBean, IncomeResponseBean responseBean) {
        logger.debug("Start {}", this.getClass().getName());

        LogicType logicType = LogicType.of(paramsBean.getOperationType());
        LogicMaster logic = context.getBean(logicType.getLogicClass());
        logic.execute(paramsBean, responseBean);

        logger.debug("End {}", this.getClass().getName());
    }

}
