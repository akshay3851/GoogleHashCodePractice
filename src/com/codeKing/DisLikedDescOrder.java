package com.codeKing;

import java.util.Comparator;

/*
 * To be ordered in decending order
* */

public class DisLikedDescOrder implements Comparator<DisLikedIngredient> {

    @Override
    public int compare(DisLikedIngredient o1, DisLikedIngredient o2) {
        return (int) (o2.ingredientTimes - o1.ingredientTimes);
    }

}
