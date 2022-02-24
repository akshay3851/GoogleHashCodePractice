package com.qualify.algo;

import com.qualify.comparators.DaysComparator;
import com.qualify.model.Contributor;
import com.qualify.model.Project;
import com.qualify.model.Role;
import com.qualify.model.TeamAndProjects;

import java.util.*;

public class Algo {

    public static String getPersonsAlignedInProject(HashMap<String, List<Integer>> skillWithIndex,
                                                    TeamAndProjects inputFromFile) {
        String output = "";
        List<Project> projects = inputFromFile.getProjectsInPipeLine();
        List<Contributor> teamMembers = inputFromFile.getTeamMembers();
        HashMap<String, Set<String>> ProjectsWithMembers = new HashMap<>();
        Collections.sort(projects, new DaysComparator());
        for(Project proj: projects) {
            List<Role> roles = proj.getRoles();
            if(!roles.isEmpty()) {
                int daysAligned = 0;
                Set<String> memberNames = new HashSet<>();
                HashMap<String, Set<String>> nameWithSkills = new HashMap<>();
                for(Role r : roles) {
                    if(skillWithIndex.containsKey(r.getSkill())) {
                        List<Integer> userIndexes = skillWithIndex.get(r.getSkill());
                        if(userIndexes.size() > 1) {
                            for(int indx: userIndexes) {
                                Contributor c = teamMembers.get(indx);
                              //  System.out.println(c);
                                int level = c.getSkill().get(r.getSkill());
                                //System.out.println("level" + level + " " + r.getLevel());
                                if(level >= r.getLevel() && !memberNames.contains(c.getPersonName())) {
                                    memberNames.add(c.getPersonName());
                                    nameWithSkills.put(c.getPersonName(), c.getSkill().keySet());
                                    break;
                                } else if(level == r.getLevel() -1 && !memberNames.contains(c.getPersonName())) {
                                   // nameWithSkills.containsKey()
                                    memberNames.add(c.getPersonName());
                                    break;
                                }
                            }
                        } else {
                            Contributor c = teamMembers.get(userIndexes.get(0));
                            if(!memberNames.contains(c.getPersonName()))
                                memberNames.add(c.getPersonName());
                        }
                    } else {
                        if(r.getLevel() == 1 || r.getLevel() == 0) {
                            // we can assign anyone available

                        }
                    }
                }
               // System.out.println(proj.getName());
               // System.out.println(memberNames);
                if(memberNames.size() == roles.size()) {
                    ProjectsWithMembers.put(proj.getName(), memberNames);
                }
            }
        }
        output = "" + projects.size() + "/n" +"";

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println(projects.size());

        for(String p: ProjectsWithMembers.keySet()) {
            Set<String> members = ProjectsWithMembers.get(p);
//            List<String> out = new ArrayList<>();
//            out.addAll(members);
            System.out.println(p);
            System.out.println(String.join(" ", members));
        }


        return "";
    }


}
