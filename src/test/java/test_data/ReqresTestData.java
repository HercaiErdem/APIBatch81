package test_data;

import java.util.*;

public class ReqresTestData {

    public Map<String, String> expectedDataMap(String name, String job) {

        Map<String, String> createdDataMap = new HashMap<>();
        createdDataMap.put("name", name);
        createdDataMap.put("job", job);


        return createdDataMap;
    }
}

