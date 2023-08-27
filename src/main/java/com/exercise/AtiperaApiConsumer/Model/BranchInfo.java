package com.exercise.AtiperaApiConsumer.Model;

import lombok.Data;

@Data
public class BranchInfo {

    private String branchName;
    private String sha;

    public BranchInfo(String branchName, String sha) {
        this.branchName = branchName;
        this.sha = sha;
    }

}
