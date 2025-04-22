package com.xpenses.transaction.controller;

import com.xpenses.transaction.common.WorkBean;
import com.xpenses.transaction.dto.IncomeDTO;
import com.xpenses.transaction.service.AcquirerService;
import com.xpenses.transaction.service.InserterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IncomeController {

    private static final Logger logger = LogManager.getLogger(IncomeController.class);

    @Autowired
    @Qualifier("incomeAcquirer")
    private AcquirerService acquirerService;

    @Autowired
    @Qualifier("incomeInserter")
    private InserterService inserterService;

    @PostMapping("/get-income")
    public ResponseEntity<IncomeDTO> getIncome(@RequestBody IncomeDTO request) {
        logger.debug(request.toString());
        WorkBean workBean = new WorkBean();
        workBean.setRequestIncome(request);
        workBean.setResponseIncome(new IncomeDTO());

        acquirerService.execute(workBean);

        return ResponseEntity.ok(workBean.getResponseIncome());
    }

    @PostMapping("/put-income")
    public ResponseEntity<String> putIncome(@RequestBody IncomeDTO request) {
        logger.debug(request.toString());
        WorkBean workBean = new WorkBean();
        workBean.setRequestIncome(request);

        inserterService.execute(workBean);

        return ResponseEntity.ok("Success");
    }

}
