package com.xpenses.transaction.util;

import com.xpenses.transaction.dto.request.ApiRequest;
import com.xpenses.transaction.dto.response.ApiResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {

    private static final Logger logger = LogManager.getLogger(LogUtil.class);

    public static void outputRequestLog(ApiRequest request) {
        logger.debug("Request: {}", request.toString());
    }

    public static void outputResponseLog(ApiResponse response) {
        logger.debug("Response: {}", response.toString());
    }
}
