package com.codeKing.file;

import com.codeKing.DisOrLikedIngredient;
import com.codeKing.dto.Client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileHelper {

    public static List<Client> getInputFromFile(String fileName, HashMap<String, DisOrLikedIngredient> disLikesMap, HashMap<String, DisOrLikedIngredient> LikeMap, HashSet<String> likeSet) throws FileNotFoundException, IOException {
        List<Client> clients = new ArrayList<>();
        int noOfClients = 0;
        try {
            BufferedReader fr = new BufferedReader(new FileReader("input/" + fileName));
            String line;
            noOfClients = Integer.parseInt(fr.readLine());
            int clientIndex = 0;
            while ((line = fr.readLine()) != null) {
                // reading liked array
                List<String> likes = Arrays.asList(line.split(" "));
                // reading disliked array
                line = fr.readLine();
                List<String> dislikes = Arrays.asList(line.split(" "));
                Client client = new Client();
                setDataOfClient(client, likes, dislikes);
                clients.add(client);
                setDataInMap(disLikesMap, LikeMap, client, clientIndex);
                likeSet.addAll(client.getLikes());
                clientIndex++;
            }
            fr.close();
        } catch (IOException ex) {
            System.out.println("ex " + ex.getMessage());
            ex.printStackTrace();
        }
        return clients;
    }

    public static void setDataOfClient(Client client, List<String> likes, List<String> disLike) {
        int likeSize = likes.size();
        int disLikeSize = disLike.size();
        if(likes.size() > 1) {
            client.setLikes(likes.subList(1, likeSize));
        } else{
            client.setLikes(new ArrayList<>());
        }
        if(disLikeSize > 1) {
            client.setDisLikes(disLike.subList(1,disLikeSize));
        } else {
            client.setDisLikes(new ArrayList<>());
        }
    }


    public static void setDataInMap(HashMap<String, DisOrLikedIngredient> disLikesMap,
                                    HashMap<String, DisOrLikedIngredient> likeMap, Client client,
                                    int clientIndex) {
        // settng data in client Map
        client.getLikes().stream().forEach((s) -> {
            if(likeMap.containsKey(s)) {
                DisOrLikedIngredient data = likeMap.get(s);
                data.setIngredientTimes(data.getIngredientTimes() + 1);
                data.getIndexes().add(clientIndex);
                likeMap.put(s, data);
            } else {
                DisOrLikedIngredient data = new DisOrLikedIngredient(s, 1l, 5, clientIndex);
                likeMap.put(s,data);
            }
        });
        // setting Data in dislike Map
        client.getDisLikes().stream().forEach((s) -> {
            if(disLikesMap.containsKey(s)) {
                DisOrLikedIngredient data = disLikesMap.get(s);
                data.setIngredientTimes(data.getIngredientTimes() + 1);
                data.getIndexes().add(clientIndex);
                disLikesMap.put(s, data);
            } else {
                DisOrLikedIngredient data = new DisOrLikedIngredient(s, 1l, 5, clientIndex);
                disLikesMap.put(s,data);
            }
        });
    }

}
