package classwork.webService;

import java.util.List;
import java.util.Objects;

public class Recipe {

    private String recipename;
    private List<Ingredient> ingredlist;
    private int preptime;

    public Recipe(String recipename, List<Ingredient> ingredlist, int preptime) {
        this.recipename = recipename;
        this.ingredlist = ingredlist;
        this.preptime = preptime;
    }

    public String getRecipename() {
        return recipename;
    }

    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }

    public List<Ingredient> getIngredlist() {
        return ingredlist;
    }

    public void setIngredlist(List<Ingredient> ingredlist) {
        this.ingredlist = ingredlist;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return preptime == recipe.preptime && Objects.equals(recipename, recipe.recipename) && Objects.equals(ingredlist, recipe.ingredlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipename, ingredlist, preptime);
    }
}
