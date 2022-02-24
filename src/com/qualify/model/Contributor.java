package com.qualify.model;

import java.util.HashMap;

public class Contributor {
    public String personName;
    public long totalSkills;
    HashMap<String, Integer> skill = new HashMap<>();

    public Contributor() {
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public long getTotalSkills() {
        return totalSkills;
    }

    public void setTotalSkills(long totalSkills) {
        this.totalSkills = totalSkills;
    }

    public HashMap<String, Integer> getSkill() {
        return skill;
    }

    public void setSkill(HashMap<String, Integer> skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Contributor{" +
                "personName='" + personName + '\'' +
                ", totalSkills=" + totalSkills +
                ", skill=" + skill +
                '}';
    }
}
