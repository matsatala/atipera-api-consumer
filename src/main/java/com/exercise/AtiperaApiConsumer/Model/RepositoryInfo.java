package com.exercise.AtiperaApiConsumer.Model;

import lombok.Data;

import java.util.ArrayList;
@Data
public class RepositoryInfo {


    private String repositoryName;

    private String ownerLogin;
    private ArrayList<BranchInfo> branches;

    public RepositoryInfo(String repositoryName, String ownerLogin) {
        this.repositoryName = repositoryName;
        this.ownerLogin = ownerLogin;
    }

}

