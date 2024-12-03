package org.test.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
        // Read json to string
        String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src/main/test/org/test/data/Data.json"), StandardCharsets.UTF_8);

        // String to HashMap need to get the dependecy Jackson Databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        return data;
    }
}
