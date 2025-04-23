package com.xpenses.transaction.service;

import com.xpenses.transaction.common.WorkBean;
import com.xpenses.transaction.enums.LogicSelector;
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

    public void execute(WorkBean workBean) {
        logger.debug("Start {}", this.getClass().getName());

        LogicSelector logicSelector = LogicSelector.of(workBean.getOperationType(), workBean.getFinancialType());
        LogicMaster logic = context.getBean(logicSelector.getLogicClass());
        logic.execute(workBean);

        logger.debug("End {}", this.getClass().getName());
    }

}
