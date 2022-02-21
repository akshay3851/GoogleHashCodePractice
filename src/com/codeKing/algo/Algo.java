package com.codeKing.algo;

import com.codeKing.DisOrLikedIngredient;
import com.codeKing.dto.Client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Algo {
    public static String logic(List<DisOrLikedIngredient> likeDescending,
                                List<DisOrLikedIngredient> disLikeDescending,
                                HashSet<String> likeSet,
                                HashMap<String, DisOrLikedIngredient> likesMap,
                                HashMap<String, DisOrLikedIngredient> disLikesMap,
                                List<Client> clientsData) {
        String output = "";
        // To:Do => logic for data
        for(int i = 0; i < disLikeDescending.size();i++) {
            Set<String> dataRemove = new HashSet<>();
            DisOrLikedIngredient likeData = null;
            DisOrLikedIngredient disLikeData = null;
            if(likesMap.containsKey(disLikeDescending.get(i).getIngredientType())) {
                likeData = likesMap.get(disLikeDescending.get(i).getIngredientType());
            }
            if(disLikesMap.containsKey(disLikeDescending.get(i).getIngredientType())) {
                disLikeData = disLikesMap.get(disLikeDescending.get(i).getIngredientType());
            }
            if(null != disLikeData) {
                if(null != likeData) {
                    // now dislike ingredient also exists
                    // in liked ingredient
                    long likeSized = likeData.getIngredientTimes();
                    long disLikeSized = disLikeData.getIngredientTimes();
                    if(disLikeSized > likeSized) {
                        likeSet.remove(disLikeData.getIngredientType());
                    }
                } else {
                    // if value is disLiked
                    // and not in any of likes
                    // remove  from set
                    likeSet.remove(disLikeData.getIngredientType());
                }
            }
        }
        output = "" + likeSet.size() + " " + String.join(" ", likeSet);
        return output;
    }

    public static String logic1(List<DisOrLikedIngredient> likeDescending,
                               List<DisOrLikedIngredient> disLikeDescending,
                               HashSet<String> likeSet,
                               HashMap<String, DisOrLikedIngredient> likesMap,
                               HashMap<String, DisOrLikedIngredient> disLikesMap,
                               List<Client> clientsData) {
        String output = "";
        Set<String> likedSetD = new HashSet<>();
        int sizeOfLikedIngredients = disLikeDescending.size();
        int indexTrack = 0;
        if(sizeOfLikedIngredients > 0) {
            for(int i=0; i < sizeOfLikedIngredients; i++) {
                DisOrLikedIngredient likeData = null;
                DisOrLikedIngredient disLikeData = null;
                if(likesMap.containsKey(disLikeDescending.get(i).getIngredientType())) {
                    likeData = likesMap.get(disLikeDescending.get(i).getIngredientType());
                }
                if(disLikesMap.containsKey(disLikeDescending.get(i).getIngredientType())) {
                    disLikeData = disLikesMap.get(disLikeDescending.get(i).getIngredientType());
                }

//                if(null != disLikeData) {
//                    if(disLikeData.getIngredientTimes() < likeData.getIngredientTimes())
//                        likedSetD.add(likeData.getIngredientType());
//                } else {
//                    likedSetD.add(likeData.getIngredientType());
//                }
                likeSet.remove(disLikeDescending.get(i).getIngredientType());

            }
        }
        output = "" + likeSet.size() + " " + String.join(" ", likeSet);
        return output;
    }


}
