package com.codeKing;

import java.util.Comparator;

/*
 * To be ordered in decending order
* */

public class DisLikedDescOrder implements Comparator<DisOrLikedIngredient> {

    @Override
    public int compare(DisOrLikedIngredient o1, DisOrLikedIngredient o2) {
        return (int) (o2.ingredientTimes - o1.ingredientTimes);
    }

}
