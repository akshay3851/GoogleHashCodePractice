package com.qualify.utils;

import com.codeKing.DisOrLikedIngredient;
import com.codeKing.dto.Client;
import com.qualify.model.Contributor;
import com.qualify.model.Project;
import com.qualify.model.Role;
import com.qualify.model.TeamAndProjects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class FileReader {

    public static TeamAndProjects getInputFromFile(String fileName, HashMap<String, List<Integer>> skillWithIndex) throws FileNotFoundException, IOException {
        TeamAndProjects inputData = new TeamAndProjects();
        List<Contributor> members = new ArrayList<>();
        List<Project> project = new ArrayList<>();
        try {
            BufferedReader fr = new BufferedReader(new java.io.FileReader("input1/" + fileName));
            String line = fr.readLine();
            int projects = 0;
            int contributors = 0;
            if(null != line) {
                String arr[] = line.split(" ");
                contributors = Integer.parseInt(arr[0]);
                projects = Integer.parseInt(arr[1]);
            }
            for(int i =0; i < contributors; i++) {
                // i is index of contributor
               line = fr.readLine();
               String arr[] = line.split(" ");
               Contributor person = new Contributor();
               person.setPersonName(arr[0]);
               person.setTotalSkills(Long.parseLong(arr[1]));
                HashMap<String, Integer> skill = new HashMap<>();
               for(long j=0; j < person.getTotalSkills();j++) {
                   String skills = fr.readLine();
                   String skillArray[] = skills.split(" ");
                   skill.put(skillArray[0], Integer.parseInt(skillArray[1]));
                   populateSkillMap(skillWithIndex,i, skillArray[0]);
                   person.setSkill(skill);
               }
               members.add(person);
            }
            for(int i=0; i<projects;i++){
                line = fr.readLine();
                String projectSplit[] = line.split(" ");
                Project proj = new Project();
                proj.setName(projectSplit[0]);
                proj.setDays(Long.parseLong(projectSplit[1]));
                proj.setScore(Long.parseLong(projectSplit[2]));
                proj.setBestBefore(Long.parseLong(projectSplit[3]));
                List<Role> projectRoles = new ArrayList<>();
                for(int j=0; j< Integer.parseInt(projectSplit[4]);j++) {
                    String role = fr.readLine();
                    String roleSplit[] = role.split(" ");
                    Role roleReq = new Role();
                    roleReq.setSkill(roleSplit[0]);
                    roleReq.setLevel(Integer.parseInt(roleSplit[1]));
                    projectRoles.add(roleReq);
                }
                proj.setRoles(projectRoles);
                project.add(proj);
            }
            inputData.setProjectsInPipeLine(project);
            inputData.setTeamMembers(members);
            fr.close();
        } catch (IOException ex) {
            System.out.println("ex " + ex.getMessage());
            ex.printStackTrace();
        }
        return inputData;
    }

    public static void populateSkillMap(HashMap<String, List<Integer>> skillWithIndex,int i, String skill) {
        if(skillWithIndex.containsKey(skill)) {
            List<Integer> indexes = skillWithIndex.get(skill);
            indexes.add(i);
            skillWithIndex.put(skill, indexes);
        } else {
            List<Integer> indexes = new ArrayList<>();
            indexes.add(i);
            skillWithIndex.put(skill, indexes);
        }
    }


}
