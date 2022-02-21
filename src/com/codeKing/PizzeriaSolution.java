package com.codeKing;

import com.codeKing.algo.Algo;
import com.codeKing.dto.Client;
import com.codeKing.file.FileHelper;

import java.io.IOException;
import java.util.*;

public class PizzeriaSolution {


    public static void main(String[] args) throws IOException {
        HashMap<String, DisOrLikedIngredient> disLikesMap = new HashMap<>();
        HashMap<String, DisOrLikedIngredient> likesMap = new HashMap<>();
        HashSet<String> likeSet = new HashSet<>();
        List<Client> clientsData = FileHelper.getInputFromFile("e.txt", disLikesMap, likesMap, likeSet);
        List<DisOrLikedIngredient> likeDescending = new ArrayList<>(clientsData.size());
        List<DisOrLikedIngredient> disLikeDescending = new ArrayList<>(clientsData.size());
        disLikeDescending.addAll(disLikesMap.values());
        Collections.sort(disLikeDescending, new DisLikedDescOrder());
        likeDescending.addAll(likesMap.values());
        Collections.sort(likeDescending, new DisLikedDescOrder());
        String output = Algo.logic1(likeDescending, disLikeDescending, likeSet, likesMap, disLikesMap, clientsData);
        System.out.println(output);
    }
}
