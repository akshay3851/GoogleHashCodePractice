package com.codeKing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
    * which ingredient is called maximum times or maximum clients disliked it.
*/
public class DisOrLikedIngredient {

    public String ingredientType;
    public long ingredientTimes;
    public List<Integer> indexes;

    DisOrLikedIngredient(){
    }

    public DisOrLikedIngredient(String ingredientType, long ingredientTimes, int size, int index) {
        this.ingredientType = ingredientType;
        this.ingredientTimes = ingredientTimes;
        this.indexes = new ArrayList<>(size);
        this.indexes.add(index);
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

    public List<Integer> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<Integer> indexes) {
        this.indexes = indexes;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientType='" + ingredientType + '\'' +
                ", ingredientTimes=" + ingredientTimes +
                ", indexes=" + indexes +
                '}';
    }
}
