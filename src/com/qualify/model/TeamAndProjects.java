package com.qualify.model;

import java.util.ArrayList;
import java.util.List;

public class TeamAndProjects {

    List<Project> projectsInPipeLine = new ArrayList<>();
    List<Contributor> teamMembers = new ArrayList<>();

    public TeamAndProjects() {
    }

    public TeamAndProjects(List<Project> projectsInPipeLine, List<Contributor> teamMembers) {
        this.projectsInPipeLine = projectsInPipeLine;
        this.teamMembers = teamMembers;
    }

    public List<Project> getProjectsInPipeLine() {
        return projectsInPipeLine;
    }

    public void setProjectsInPipeLine(List<Project> projectsInPipeLine) {
        this.projectsInPipeLine = projectsInPipeLine;
    }

    public List<Contributor> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Contributor> teamMembers) {
        this.teamMembers = teamMembers;
    }

    @Override
    public String toString() {
        return "TeamAndProjects{" +
                "projectsInPipeLine=" + projectsInPipeLine +
                ", teamMembers=" + teamMembers +
                '}';
    }
}
