package com.exercise.AtiperaApiConsumer.Model;

import lombok.Data;

@Data
public class BranchInfo {

    private String branchName;
    private String branchSha;

    public BranchInfo(String branchName, String sha) {
        this.branchName = branchName;
        this.branchSha = sha;
    }

}
