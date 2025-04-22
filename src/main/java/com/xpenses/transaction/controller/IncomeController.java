package com.xpenses.transaction.controller;

import com.xpenses.transaction.common.WorkBean;
import com.xpenses.transaction.dto.IncomeDTO;
import com.xpenses.transaction.service.AcquirerService;
import com.xpenses.transaction.service.InserterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncomeController {

    //private static final Logger logger = LoggerFactory.getLogger(IncomeController.class);

    @Autowired
    @Qualifier("incomeAcquirer")
    private AcquirerService acquirerService;

    @Autowired
    @Qualifier("incomeInserter")
    private InserterService inserterService;

    @PostMapping("/getIncome")
    public ResponseEntity<IncomeDTO> getIncome(@RequestBody IncomeDTO request) {
        //logger.debug(request.toString());
        WorkBean workBean = new WorkBean();
        workBean.setRequestIncome(request);
        workBean.setResponseIncome(new IncomeDTO());

        acquirerService.execute(workBean);

        return ResponseEntity.ok(workBean.getResponseIncome());
    }

    @PostMapping("/putIncome")
    public ResponseEntity<String> putIncome(@RequestBody IncomeDTO request) {
        //logger.debug(request.toString());
        WorkBean workBean = new WorkBean();
        workBean.setRequestIncome(request);

        inserterService.execute(workBean);

        return ResponseEntity.ok("Success");
    }

}
