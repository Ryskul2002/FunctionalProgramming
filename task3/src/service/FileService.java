package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Movie;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileService {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Paths.get("task3/data/movies.json");

    public List<Movie> readFile() {
        Type itemsMapType = new TypeToken<Map<String, List<Movie>>>() {}.getType();
        String json = "";
        try {
            json = Files.readString(PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, List<Movie>> map = GSON.fromJson(json, itemsMapType);
        return map.get("movies");
    }
}
