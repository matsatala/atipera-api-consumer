package com.exercise.AtiperaApiConsumer.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoriesInfoMapper {

        public String name;
        public Owner owner;
        public boolean fork;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Owner{
        String login;
    }

    public RepositoryInfo map(){
        return new RepositoryInfo(this.getName(),this.getOwner().getLogin());
    }

}
