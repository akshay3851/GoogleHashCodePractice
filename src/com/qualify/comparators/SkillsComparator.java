package com.qualify.comparators;

import com.qualify.model.Project;

import java.util.Comparator;

public class SkillsComparator implements Comparator<Project> {
    @Override
    public int compare(Project o1, Project o2) {
        return o2.getRoles().size() - o1.getRoles().size();
    }
}
