package com.codeKing;

import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

public class Pizzeria {

    public static String maximumIngredients(long testCases, List<List<String>> likes,
                                            List<List<String>> disLikes, HashMap<String, DisOrLikedIngredient> disLikesMap,
                                            List<DisOrLikedIngredient> descendingOrderDisOrLikedIngredients) {
        // testCases => no of testCases
        // likes => likes per User Wise
        // disLikes => disLikes per User Wise
        // disLikesMap => disLiked String as key and their indexes in the list of integer
        // descendingOrderDisLikedIngredients => custom data type for descendingOrderDisLikedIngredients

        return "";
    }

    static void setDataInVariable(boolean isLike, List<List<String>> arrayPopulate, HashMap<String, DisOrLikedIngredient> disLikesMap,
                                  List<DisOrLikedIngredient> descendingOrderDisOrLikedIngredients, int index, String input) {
        try{
            List<String> listToAdd = Arrays.asList(input.split(" "));
            int size = listToAdd.size();
            if(size > 1) {
                arrayPopulate.add(listToAdd.subList(1, size));
                if(!isLike) {
                    for(int i = 1; i < size; i++) {
                        if(disLikesMap.containsKey(listToAdd.get(i))) {
                            DisOrLikedIngredient disLikedIng = disLikesMap.get(listToAdd.get(i));
                            disLikedIng.setIngredientTimes(disLikedIng.getIngredientTimes() + 1);
                            disLikedIng.getIndexes().add(index);
                            disLikesMap.put(listToAdd.get(i), disLikedIng);
                        } else {
                            DisOrLikedIngredient disLikedIng = new DisOrLikedIngredient(listToAdd.get(i), 1l, size,i);
                            disLikesMap.put(listToAdd.get(i), disLikedIng);
                        }
                    }
                }
            }
        } catch(Exception e) {
            System.out.println("Exception in setting data in var " + e.getMessage());
            e.printStackTrace();
        }
    }

    static long testCasesPassed(long testCases, List<List<String>> likes
            , List<List<String>> disLikes, HashMap<String, DisOrLikedIngredient> disLikesMap,
                                List<DisOrLikedIngredient> descendingOrderDisOrLikedIngredients) {

        return 0l;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        List<List<String>> likes = new ArrayList<>(testCases);
        List<List<String>> disLikes = new ArrayList<>(testCases);
        HashMap<String, DisOrLikedIngredient> disLikesMap = new HashMap<>();
        List<DisOrLikedIngredient> descendingOrderDisOrLikedIngredients = new ArrayList<>(testCases);
        Time T1 = Time.valueOf(LocalTime.now());
        System.out.println();
        // j identifies person index which can be retrieved
        for(int j=0; j < testCases;j++) {
            for (int i = 0; i < 2; i++) {
                System.out.println("j " + j +" i " + i );
                String likeOrDisLike = scan.nextLine();
                System.out.println(likeOrDisLike);
                if (i == 0) {
                    // in Likes
                    setDataInVariable(Boolean.TRUE, likes, disLikesMap, descendingOrderDisOrLikedIngredients, j, likeOrDisLike);
                } else {
                    // in DisLikes
                    setDataInVariable(Boolean.FALSE, disLikes, disLikesMap, descendingOrderDisOrLikedIngredients, j, likeOrDisLike);
                }
            }
        }
        System.out.println("likes " +likes);
        System.out.println("disLikes " + disLikes);
        System.out.println("disMap " + disLikesMap);

        // The above loop generates complexity O(2j)
        // where j is no of person
        // 2 is person likes or dislikes
        Time T2 = Time.valueOf(LocalTime.now());
        System.out.println("Time taken for ingestion of input into DS " + (T2.getTime() - T1.getTime()));
        T1 = Time.valueOf(LocalTime.now());
        String output = maximumIngredients(testCases, likes, disLikes, disLikesMap, descendingOrderDisOrLikedIngredients);
        T2 = Time.valueOf(LocalTime.now());
        System.out.println("output:");
        System.out.println(output);
        System.out.println();
        System.out.println("Time taken for calculating the maximun output " + (T2.getTime() - T1.getTime()));
        T1 = Time.valueOf(LocalTime.now());
        long pointsReceived = testCasesPassed(testCases, likes, disLikes, disLikesMap, descendingOrderDisOrLikedIngredients);
        T2 = Time.valueOf(LocalTime.now());
        System.out.println("points: " + pointsReceived);
        System.out.println("Time taken for calculating the points " + (T2.getTime() - T1.getTime()));
    }

}