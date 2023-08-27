package com.exercise.AtiperaApiConsumer.Controller;

import com.exercise.AtiperaApiConsumer.ApiConsumer.GitHubApiConsumer;
import com.exercise.AtiperaApiConsumer.Model.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@RestController
public class RepositoryController {

    private GitHubApiConsumer apiConsumer;

    public RepositoryController(GitHubApiConsumer apiConsumer) {
        this.apiConsumer = apiConsumer;
    }

    @GetMapping("/repositories/{username}/{format}")
    public String getListOfRepositories(@PathVariable String username, @PathVariable String format) throws JsonProcessingException {

        String encodedUsername = URLEncoder.encode(username, StandardCharsets.UTF_8);
        String encodedFormat = URLEncoder.encode(format,StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        try{

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(apiConsumer.GetListOfReposOfUser(encodedUsername,encodedFormat));

        }catch (HttpClientErrorException e){

            if(e.getStatusCode().value()==406) {

                ErrorResponse errorResponse = new ErrorResponse(
                        e.getStatusCode(), "unsupported type of file: " + encodedFormat + ", please use json");

                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorResponse);

            }else {

                ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), "couldn't find a user with username: " + encodedUsername);

                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorResponse);

            }
        }
    }

}
