package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        if (json.isEmpty()) return null;

        try {
            JSONObject root = new JSONObject(json);
            JSONObject name = root.getJSONObject("name");
            String mainName = name.getString("mainName");
            List<String> alsoKnownAs = jsonArrayToArrayList(name.getJSONArray("alsoKnownAs"));
            String placeOfOrigin = root.getString("placeOfOrigin");
            String description = root.getString("description");
            String image = root.getString("image");
            List<String> ingredients = jsonArrayToArrayList(root.getJSONArray("ingredients"));
            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static ArrayList<String> jsonArrayToArrayList(JSONArray jsonArray) throws JSONException{

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++){
            String element = jsonArray.getString(i);
            result.add(element);
        }

        return result;

    }
}
