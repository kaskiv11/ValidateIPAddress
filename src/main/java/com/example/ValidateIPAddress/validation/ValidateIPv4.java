package com.example.ValidateIPAddress.validation;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import com.example.ValidateIPAddress.validation.interfaces.ValidateIP;
import org.apache.log4j.Logger;
public class ValidateIPv4 implements ValidateIP {
    private static final Pattern PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    private static final String  INVALID_MASSAGE = "Invalid IP address";
    private static final String  DISALLOWED_MASSAGE = "Access disallowed";
    private static final String  ALLOWED_MASSAGE = "Access allowed";
    static final Logger logger = Logger.getLogger(ValidateIPv4.class);

    public static boolean validateIPAddressWithPattern(final String ip) {
        logger.info("Validate with Pattern");
        return PATTERN.matcher(ip).matches();
    }
    public static boolean stringContainsTheIPAddressInBlockList(String ip, List<String> blockList) {
        logger.info("Checking whether the IP address is in the blocked file");
        return blockList.stream().anyMatch(ip::contains);
    }
    @Override
    public String validateIPAddressWithBlockList(String ip, List<String> blockList) throws IOException {
        logger.info("General validation");
        if(!validateIPAddressWithPattern(ip)){
            logger.info("The IP address is not valid");
            return INVALID_MASSAGE;
        }
        else if (stringContainsTheIPAddressInBlockList(ip, blockList)){
            logger.info("IP address found in blocked");
            return DISALLOWED_MASSAGE;
        }
        else {
            logger.info("IP address not found in blocked");
            return ALLOWED_MASSAGE;
        }
    }
}
