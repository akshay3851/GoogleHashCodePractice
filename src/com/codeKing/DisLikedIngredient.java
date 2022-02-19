package com.codeKing;

import java.util.Comparator;

/*
    * ordered in decending order
    * which ingredient is called maximum times or maximum clients disliked it.
*/
public class DisLikedIngredient implements Comparator<DisLikedIngredient> {

    public String ingredientType;
    public long ingredientTimes;

    @Override
    public int compare(DisLikedIngredient o1, DisLikedIngredient o2) {
        return (int) (o2.ingredientTimes - o1.ingredientTimes);
    }
}
