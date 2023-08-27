package com.exercise.AtiperaApiConsumer.Model;

import lombok.Data;

import java.util.ArrayList;
@Data
public class RepositoryInfo {


    private String name;
    private String ownerName;
    private ArrayList<BranchInfo> branches;

    public RepositoryInfo(String name, String ownerName) {
        this.name = name;
        this.ownerName = ownerName;
    }

}
