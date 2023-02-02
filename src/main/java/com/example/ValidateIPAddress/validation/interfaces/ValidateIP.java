package com.example.ValidateIPAddress.validation.interfaces;

import java.io.IOException;
import java.util.List;

public interface ValidateIP {
    String validateIPAddressWithBlockList(String ip, List<String> blockList) throws IOException;
}
