package com.qualify.model;

public class Role {
    public String skill;
    public int level;

    public Role() {

    }

    public Role(String skill, int level) {
        this.skill = skill;
        this.level = level;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Role{" +
                "skill='" + skill + '\'' +
                ", level=" + level +
                '}';
    }
}
