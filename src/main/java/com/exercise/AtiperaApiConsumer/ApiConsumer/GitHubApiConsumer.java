package com.exercise.AtiperaApiConsumer.ApiConsumer;

import com.exercise.AtiperaApiConsumer.Model.BranchInfo;
import com.exercise.AtiperaApiConsumer.Model.BranchesInfoMapper;
import com.exercise.AtiperaApiConsumer.Model.RepositoriesInfoMapper;
import com.exercise.AtiperaApiConsumer.Model.RepositoryInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class GitHubApiConsumer {


    public ArrayList<RepositoryInfo> GetListOfReposOfUser(String username, String format) throws JsonProcessingException {

        String apiUrl = "https://api.github.com/users/{username}/repos";

        RestTemplate template = new RestTemplate();

        HttpHeaders header = new HttpHeaders();
        header.add("Accept","application/"+format);
        HttpEntity<HttpHeaders> entity = new HttpEntity<>(header);

        ResponseEntity<String> responseEntity;

        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("username",username);

        try{

            responseEntity = template.exchange(apiUrl, HttpMethod.GET,entity, String.class,queryParams);

        }catch (HttpClientErrorException.UnsupportedMediaType exception){

            throw new HttpClientErrorException(HttpStatus.NOT_ACCEPTABLE);

        }

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<RepositoriesInfoMapper> repositories = mapper.readValue(responseEntity.getBody(), new TypeReference<>() {
        });

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            ArrayList<RepositoryInfo> repositoriesList = new ArrayList<>();

            for (RepositoriesInfoMapper infoMapper : repositories){

                if (infoMapper.fork){
                    continue;
                }

                RepositoryInfo repo = infoMapper.map();

                repo.setBranches(getBranchesOfProject(repo.getOwnerName(),repo.getName(),entity));
                repositoriesList.add(repo);

            }

            return repositoriesList;

        }





        return new ArrayList<>();
    }

    private static ArrayList<BranchInfo> getBranchesOfProject(String ownerName, String repoName, HttpEntity<HttpHeaders> entity) throws JsonProcessingException {

        String apiUrl = "https://api.github.com/repos/{ownerName}/{repoName}/branches";

        RestTemplate template = new RestTemplate();

        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("ownerName", ownerName);
        queryParams.put("repoName", repoName);

        ResponseEntity<String> responseEntity = template.exchange(apiUrl,HttpMethod.GET,entity,String.class,queryParams);

        ObjectMapper mapper = new ObjectMapper();

        ArrayList<BranchesInfoMapper> branches = mapper.readValue(responseEntity.getBody(), new TypeReference<>() {
        });

        ArrayList<BranchInfo> branchesInfo = new ArrayList<>();

        for (BranchesInfoMapper branchesInfoMapper: branches){

            branchesInfo.add(branchesInfoMapper.map());
        }

        return branchesInfo;
    }


}
