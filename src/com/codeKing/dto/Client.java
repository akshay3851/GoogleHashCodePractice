package com.codeKing.dto;

import java.util.List;

public class Client {
    List<String> likes;
    List<String> disLikes;

    public Client() {
    }

    public Client(List<String> likes, List<String> disLikes) {
        this.likes = likes;
        this.disLikes = disLikes;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public List<String> getDisLikes() {
        return disLikes;
    }

    public void setDisLikes(List<String> disLikes) {
        this.disLikes = disLikes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "likes=" + likes +
                ", disLikes=" + disLikes +
                '}';
    }
}
