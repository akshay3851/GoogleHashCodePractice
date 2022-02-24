package com.qualify.comparators;

import com.qualify.model.Project;

import java.util.Comparator;

public class PointsComparator implements Comparator<Project> {
    @Override
    public int compare(Project o1, Project o2) {
        return (int) (o2.getScore() - o1.getScore());
    }
}
