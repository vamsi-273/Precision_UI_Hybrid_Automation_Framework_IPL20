package com.ipl.automation.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.core.util.JsonUtils;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JsonDataProvider {

    static JsonObject data;

    static {
        try {
            FileReader reader = new FileReader("src/test/resources/testdata.json");
            data = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] getTeamNames() {

        JsonArray teams = data.getAsJsonArray("teams");
        String[] teamNames = new String[teams.size()];

        for (int i = 0; i < teams.size(); i++) {
            teamNames[i] = teams.get(i).getAsString();
        }

        return teamNames;
    }

    public static String getTopTeamName() {
        return data.getAsJsonObject("topTeam").get("name").getAsString();
    }

    public static int getTopTeamMatches() {
        return data.getAsJsonObject("topTeam").get("matches").getAsInt();
    }

    public static int getTopTeamPoints() {
        return data.getAsJsonObject("topTeam").get("points").getAsInt();
    }

    public static List<String> getVenuesFromJson() {

        List<String> venues = new ArrayList<>();

        try {
            InputStreamReader reader = new InputStreamReader(
                    JsonUtils.class.getClassLoader()
                            .getResourceAsStream("venues.json"));

            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray jsonArray = jsonObject.getAsJsonArray("venues");

            for (JsonElement element : jsonArray) {
                venues.add(element.getAsString().trim());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return venues;
    }
}