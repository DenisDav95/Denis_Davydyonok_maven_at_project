package classwork.webService;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import gherkin.deps.com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MyParser {

    private static final String JSON = "src/test/resources/classwork/recipe.json";

    public void parseGSON() throws FileNotFoundException {

        Gson gson = new Gson();

        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);

        System.out.println(recipe.getIngredlist());
        System.out.println(recipe.getPreptime());
        System.out.println(recipe.getRecipename());
    }

    public void toGSON() {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Ingredient> ingredlist = new ArrayList<>();
        ingredlist.add(new Ingredient("Картошка", 3));
        ingredlist.add(new Ingredient("Огурец", 5));
        Recipe recipe = new Recipe("Салат", ingredlist, 120);
        System.out.println(gson.toJson(recipe));
    }
}
