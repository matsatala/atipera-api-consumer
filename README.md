# Atipera-Api-Consumer

This is project which is my solution of a recruitment task,<br>
this application using GitHub Rest API as backing API.

## How to use it ? 

If you want to use my project you can use the fact that application<br>
is deployed on railway and link to the application is:


atipera-api-consumer.up.railway.app


or clone the repository using command:

git clone https://github.com/matsatala/atipera-api-consumer.git

and start the application on your local enviroment

## Tech stack

### Java 17
### Spring Boot
### Maven
### Jackson library

## Action 

/repositories/{username}/{format}

there is only one endpoint which return all public and not fork repositories of user<br> 
with provided username and a list of branches for each repository

### username
url parameter which should represtents existing user e.g. "octocat" 
### format 
paramter which allows to change an header "Accept"(for now the only format available is "json" typing<br>
other format will result the apperance of an error message

## Example usage

### atipera-api-consumer.up.railway.app/repositories/octocat/json

Above is a correct example url which give us access to response below:<br>

[ {<br>
  "name" : "git-consortium",<br>
  "ownerName" : "octocat",<br>
  "branches" : [ {<br>
  &emsp;  "branchName" : "master",<br>
  &emsp;  "sha" : "b33a9c7c02ad93f621fa38f0e9fc9e867e12fa0e"<br>
&emsp;  } ]<br>
}, {<br>
  "name" : "hello-worId",<br>
  "ownerName" : "octocat",<br>
  "branches" : [ {<br>
  &emsp;"branchName" : "master",<br>
  &emsp;"sha" : "7e068727fdb347b685b658d2981f8c85f7bf0585"<br>
&emsp;  } ]<br>
}, {<br>
  "name" : "Hello-World",<br>
  "ownerName" : "octocat",<br>
  "branches" : [ {<br>
    &emsp;"branchName" : "master",<br>
    &emsp;"sha" : "7fd1a60b01f91b314f59955a4e4d4e80d8edf11d"<br>
 &emsp; }, {<br>
   &emsp; "branchName" : "octocat-patch-1",<br>
    &emsp;"sha" : "b1b3f9723831141a31a1a7252a213e216ea76e56"<br>
 &emsp; }, {<br>
    &emsp;"branchName" : "test",<br>
    &emsp;"sha" : "b3cbd5bbd7e81436d2eee04537ea2b4c0cad4cdf"<br>
 &emsp; } ]<br>
}, {<br>
  "name" : "octocat.github.io",<br>
  "ownerName" : "octocat",<br>
  "branches" : [ {<br>
   &emsp; "branchName" : "gh-pages",<br>
   &emsp; "sha" : "c0e4a095428f36b81f0bd4239d353f71918cbef3"<br>
  &emsp;}, {<br>
   &emsp; "branchName" : "master",<br>
   &emsp; "sha" : "3a9796cf19902af0f7e677391b340f1ae4128433"<br>
 &emsp; } ]<br>
}, {<br>
  "name" : "Spoon-Knife",<br>
  "ownerName" : "octocat",<br>
  "branches" : [ {<br>
  &emsp;  "branchName" : "change-the-title",<br>
   &emsp; "sha" : "f439fc5710cd87a4025247e8f75901cdadf5333d"<br>
 &emsp; }, {<br>
  &emsp;  "branchName" : "main",<br>
  &emsp;  "sha" : "d0dd1f61b33d64e29d8bc1372a94ef6a2fee76a9"<br>
  &emsp;}, {<br>
   &emsp; "branchName" : "test-branch",<br>
  &emsp;  "sha" : "58060701b538587e8b4ab127253e6ed6fbdc53d1"<br>
&emsp;  } ]<br>
}, {<br>
  "name" : "test-repo1",<br>
  "ownerName" : "octocat",<br>
  "branches" : [ {<br>
  &emsp;  "branchName" : "gh-pages",<br>
   &emsp; "sha" : "57523742631876181d95bc268e09fb3fd1a4d85e"<br>
&emsp;  } ]<br>
} ]<br>

## Json structure

When we are pass a correct URL we should recive a json with following structure:<br>
[<br>
&emsp;{"repositoryName": "repository_1",<br>
&emsp;"ownerLogin: "login_1",<br>
&emsp;"branches: [<br>
&emsp;&emsp;{"branchName": "branch_1.1",<br>
&emsp;&emsp;"sha": branch_sha_1.1"},<br>
&emsp;&emsp;{
                                                                                                                        
