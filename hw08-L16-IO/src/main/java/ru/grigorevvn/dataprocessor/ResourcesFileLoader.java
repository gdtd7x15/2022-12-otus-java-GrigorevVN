package ru.grigorevvn.dataprocessor;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import jakarta.json.Json;
import jakarta.json.JsonReader;
import ru.grigorevvn.model.Measurement;

import java.lang.reflect.Type;
import java.util.List;

public class ResourcesFileLoader implements Loader {
    private String fileName;
    public ResourcesFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Measurement> load() {
        //читает файл, парсит и возвращает результат
        try (JsonReader jsonReader = Json.createReader(ResourcesFileLoader.class.getClassLoader().getResourceAsStream(fileName))) {
            String json = jsonReader.read().toString();
            Type typeOfMeasurementList = new TypeToken<List<Measurement>>() {}.getType();
            return new Gson().fromJson(json, typeOfMeasurementList);
        }
    }
}
