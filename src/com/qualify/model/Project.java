package com.qualify.model;

import java.util.List;

public class Project {
    public String name;
    public long days;
    public long score;
    public long bestBefore;
    public List<Role> roles;

    public Project() {
    }

    public Project(String name, long days, long score, long bestBefore, List<Role> roles) {
        this.name = name;
        this.days = days;
        this.score = score;
        this.bestBefore = bestBefore;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(long bestBefore) {
        this.bestBefore = bestBefore;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", days=" + days +
                ", score=" + score +
                ", bestBefore=" + bestBefore +
                ", roles=" + roles +
                '}';
    }
}
