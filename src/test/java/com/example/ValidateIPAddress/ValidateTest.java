package com.example.ValidateIPAddress;

import com.example.ValidateIPAddress.files.FileIO;
import com.example.ValidateIPAddress.validation.ValidateIPv4;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;

@Log4j
public class ValidateTest {
    @Mock
    FileIO fileIO = new FileIO();
    @Mock
    ValidateIPv4 validateIPv4 = new ValidateIPv4();

    @Test
    public void validateIPAddressWithPatternTest(){
        log.info("Testing validate IP address wit hPattern");
        String ip = "189.192.192.128";
        boolean isValid = ValidateIPv4.validateIPAddressWithPattern(ip);
        Assertions.assertSame(isValid, true);
    }
    @Test
    public void stringContainsTheIPAddressInBlockListTest() throws IOException {
        log.info("Testing whether the IP address is in the block list");
        String ip = "201.192.3.140";
        boolean isContained = ValidateIPv4.stringContainsTheIPAddressInBlockList(ip,fileIO.listOfBlockedAddresses());
        Assertions.assertSame(isContained, true);
    }
    @Test
    public void generalValidationTest() throws IOException {
        log.info("Testing the method with providing the validation result to the user");
        String messageIP = "40.106.214.62";
        String messageResult = "Access disallowed";
        String result = validateIPv4.validateIPAddressWithBlockList(messageIP,fileIO.listOfBlockedAddresses());
        Assertions.assertSame(messageResult,result);
    }
}
