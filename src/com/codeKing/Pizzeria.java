package com.codeKing;

import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

public class Pizzeria {

    public static String maximumIngredients(long testCases, List<List<String>> likes,
                                            List<List<String>> disLikes, HashMap<String, DisLikedIngredient> disLikesMap,
                                            List<DisLikedIngredient> descendingOrderDisLikedIngredients) {
        // testCases => no of testCases
        // likes => likes per User Wise
        // disLikes => disLikes per User Wise
        // disLikesMap => disLiked String as key and their indexes in the list of integer
        // descendingOrderDisLikedIngredients => custom data type for descendingOrderDisLikedIngredients

        return "";
    }

    static void setDataInVariable(boolean isLike, List<List<String>> arrayPopulate, HashMap<String, DisLikedIngredient> disLikesMap,
                                  List<DisLikedIngredient> descendingOrderDisLikedIngredients, int index,String input) {
        try{
            String[] arr = input.split(" ");
            List<String> listToAdd = new ArrayList<>();
        } catch(Exception e) {
            System.out.println("Exception in setting data in var " + e.getMessage());
            e.printStackTrace();
        }
    }

    static long testCasesPassed(long testCases, List<List<String>> likes
            , List<List<String>> disLikes, HashMap<String, DisLikedIngredient> disLikesMap,
                                List<DisLikedIngredient> descendingOrderDisLikedIngredients) {

        return 0l;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        List<List<String>> likes = new ArrayList<>(testCases);
        List<List<String>> disLikes = new ArrayList<>(testCases);
        HashMap<String, DisLikedIngredient> disLikesMap = new HashMap<>();
        List<DisLikedIngredient> descendingOrderDisLikedIngredients = new ArrayList<>(testCases);
        Time T1 = Time.valueOf(LocalTime.now());
        // j identifies person index which can be retrieved
        for(int j=0; j < testCases;j++) {
            for (int i = 0; i < 2; i++) {
                String likeOrDisLike = scan.nextLine();
                if (i == 0) {
                    // in Likes
                    setDataInVariable(Boolean.TRUE, likes, disLikesMap, descendingOrderDisLikedIngredients, j, likeOrDisLike);
                } else {
                    // in DisLikes
                    setDataInVariable(Boolean.FALSE, disLikes, disLikesMap, descendingOrderDisLikedIngredients, j, likeOrDisLike);
                }
            }
        }
        // The above loop generates complexity O(2j)
        // where j is no of person
        // 2 is person likes or dislikes
        Time T2 = Time.valueOf(LocalTime.now());
        System.out.println("Time taken for ingestion of input into DS " + (T2.getTime() - T1.getTime()));
        T1 = Time.valueOf(LocalTime.now());
        String output = maximumIngredients(testCases, likes, disLikes, disLikesMap, descendingOrderDisLikedIngredients);
        T2 = Time.valueOf(LocalTime.now());
        System.out.println("output:");
        System.out.println(output);
        System.out.println();
        System.out.println("Time taken for calculating the maximun output " + (T2.getTime() - T1.getTime()));
        T1 = Time.valueOf(LocalTime.now());
        long pointsReceived = testCasesPassed(testCases, likes, disLikes, disLikesMap, descendingOrderDisLikedIngredients);
        T2 = Time.valueOf(LocalTime.now());
        System.out.println("points: " + pointsReceived);
        System.out.println("Time taken for calculating the points " + (T2.getTime() - T1.getTime()));
    }

}