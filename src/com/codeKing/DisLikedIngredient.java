package com.codeKing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
    * which ingredient is called maximum times or maximum clients disliked it.
*/
public class DisLikedIngredient {

    public String ingredientType;
    public long ingredientTimes;
    public List<Integer> indexes;

    DisLikedIngredient(){
    }

    public DisLikedIngredient(String ingredientType, long ingredientTimes, int size) {
        this.ingredientType = ingredientType;
        this.ingredientTimes = ingredientTimes;
        this.indexes = new ArrayList<>(size);
    }

    public String getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    public long getIngredientTimes() {
        return ingredientTimes;
    }

    public void setIngredientTimes(long ingredientTimes) {
        this.ingredientTimes = ingredientTimes;
    }
}
