package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Utils {

    public void saveResultList(String name, String releaseDate,String price) throws IOException, ParseException {
        String fileName = "./src/test/resources/information.json";
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;

        JSONObject userObject = new JSONObject();
        userObject.put("GameName", name);
//        userObject.put("gamePlatform", platform);
        userObject.put("GameReleaseDate", releaseDate);
//        userObject.put("gamereview", review);
        userObject.put("GamePrice", price);

        jsonArray.add(userObject);

        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
        System.out.println("Saved Your Data");

    }

    public static List readResultdata(String fileName) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        return jsonArray;

    }

}
