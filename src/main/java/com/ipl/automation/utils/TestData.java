package com.ipl.automation.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

public class TestData {

    static JsonObject data;

    static {
        try {
            FileReader reader = new FileReader("src/test/resources/testdata.json");
            data = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 OLD FUNCTION (now reads from JSON)
    public static String[] getTeamNames() {

        JsonArray teams = data.getAsJsonArray("teams");
        String[] teamNames = new String[teams.size()];

        for (int i = 0; i < teams.size(); i++) {
            teamNames[i] = teams.get(i).getAsString();
        }

        return teamNames;
    }

    // 🔹 NEW FUNCTIONS
    public static String getTopTeamName() {
        return data.getAsJsonObject("topTeam").get("name").getAsString();
    }

    public static int getTopTeamMatches() {
        return data.getAsJsonObject("topTeam").get("matches").getAsInt();
    }

    public static int getTopTeamPoints() {
        return data.getAsJsonObject("topTeam").get("points").getAsInt();
    }
}