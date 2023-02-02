package com.example.ValidateIPAddress.files.interfaces;

import java.io.IOException;
import java.util.List;

public interface ListBlockIpAddress {
    List<String> listOfBlockedAddresses() throws IOException;
}
