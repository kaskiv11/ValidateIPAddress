package com.example.ValidateIPAddress.files;

import com.example.ValidateIPAddress.files.interfaces.ListBlockIpAddress;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j
@AllArgsConstructor
@NoArgsConstructor
public class FileIO implements ListBlockIpAddress {

    List<String> arrayList = new ArrayList<>();
    private static String fileName ="src/main/java/com/example/ValidateIPAddress/files/file/blacklist.txt";
    @Override
    public List<String>  listOfBlockedAddresses() throws IOException {
        log.info("Open the file");
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            log.info("Each line of the file is added to the list");
            arrayList = lines.collect(Collectors.toList());
        }
        catch (IOException s) {
            log.error("Problem reading from file");
            System.out.println("Error reading file");
        }
        log.info("A list with the data of the file added to the list is returned");
        return arrayList;
    }
}
