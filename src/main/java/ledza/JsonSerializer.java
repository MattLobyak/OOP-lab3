package ledza;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import ledza.devices.*;
import org.w3c.dom.Node;

import java.io.*;
import java.io.Console;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JsonSerializer {

    public Map<String, Class> typesToTypeMap;
    private ObjectMapper objectMapper = new ObjectMapper();

    public String serialize(Device obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public Object deserialize(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, Object.class);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void saveInJsonFile(List<Device> devices) throws IOException {
        String json = objectMapper.writeValueAsString(devices);
        FileOutputStream file = new FileOutputStream("devices.json");
        file.write(json.getBytes(StandardCharsets.UTF_8));
        file.close();
    }

    public List<Device> loadFromJsonFile() throws IOException{

        FileInputStream file = new FileInputStream("devices.json");
        byte[] jsonBytes = file.readAllBytes();

        ArrayNode jsonNodes = (ArrayNode) objectMapper.readTree(jsonBytes);
        Iterator<JsonNode> iterator = jsonNodes.iterator();

        List<Device> devices = new ArrayList<>();

        while (iterator.hasNext()){
            JsonNode jsonNode = iterator.next();
            String type = jsonNode.get("type").asText();
            Device device = (Device) objectMapper.convertValue(jsonNode, typesToTypeMap.get(type));

            devices.add(device);
        }
        return devices;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JsonSerializer() {
        typesToTypeMap = new HashMap<>();
        typesToTypeMap.put("Computer", Computer.class);
        typesToTypeMap.put("Console", Console.class);
        typesToTypeMap.put("Electronic Book", ElectronicBook.class);
        typesToTypeMap.put("Notebook", Notebook.class);
        typesToTypeMap.put("Phone", Phone.class);
        typesToTypeMap.put("Watch", Watch.class);
    }
}
