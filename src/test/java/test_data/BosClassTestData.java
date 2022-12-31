package test_data;

import java.util.*;

public class BosClassTestData {

    public Map<String, String> innerMapOlusturMethodu(String name, String email, String gender, String status) {

        Map<String, String> olusturulanInnerMap = new HashMap<>();

        olusturulanInnerMap.put("name", name);
        olusturulanInnerMap.put("email", email);
        olusturulanInnerMap.put("gender", gender);
        olusturulanInnerMap.put("status", status);

        return olusturulanInnerMap;
    }

    public Map<String, Object> outerMapOlusturMethodu(Object meta, Map<String, String> data) {

        Map<String, Object> olusturulanOuterMap = new HashMap<>();

        olusturulanOuterMap.put("meta", meta);
        olusturulanOuterMap.put("data", data);

        return olusturulanOuterMap;
    }
}