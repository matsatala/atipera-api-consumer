package com.exercise.AtiperaApiConsumer.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchesInfoMapper {

    public String name;
    @JsonProperty("commit")
    public Commit commit;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Commit{
        String sha;
    }

    public BranchInfo map(){
        return new BranchInfo(this.getName(),this.getCommit().getSha());
    }
}
