package com.qualify.main;

import com.codeKing.file.FileHelper;
import com.qualify.algo.Algo;
import com.qualify.model.TeamAndProjects;
import com.qualify.utils.FileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, List<Integer>> skillWithIndex = new HashMap<>();
        final TeamAndProjects inputFromFile = FileReader.getInputFromFile("c.txt", skillWithIndex);
        String output = Algo.getPersonsAlignedInProject(skillWithIndex, inputFromFile);
        System.out.println(output);

    }

}
