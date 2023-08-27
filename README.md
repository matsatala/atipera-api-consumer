# Atipera-Api-Consumer

This is project which is my solution of a recruitment task,<br>
this application using GitHub Rest API as backing API.

## Tech stack

### Java 17
### Spring Boot
### Maven


## How to use it ? 

If you want to use my project you can use the fact that application<br>
is deployed on railway link to the application is:


atipera-api-consumer.up.railway.app


or clone the repository using command:

git clone https://github.com/matsatala/atipera-api-consumer.git

and start the application on your local enviroment


## Action 

/repositories/{username}/{format}

there is only one endpoint which return all public and not fork repositories of user<br> 
with provided username and a list of branches for each repository

### username
url parameter which should represtents existing user e.g. "octocat" 
### format 
paramter which allows to change an header "Accept"(for now the only format available is "json" typing<br>
other format will result the apperance of an error message


## Json structure

### When we are passing a correct URL we should recive a json with following structure:
[<br>
&emsp;{"repositoryName": "repository_1",<br>
&emsp;"ownerLogin: "login_1",<br>
&emsp;"branches: [<br>
&emsp;&emsp;{"branchName": "branch_1.1",<br>
&emsp;&emsp;"branchSha": branch_sha_1.1"},<br>
&emsp;&emsp;{"branchName": "branch_1.2",<br>
&emsp;&emsp;"branchSha": "branch_sha_1.2}]<br>
&emsp;},<br>
&emsp;{"repositoryName": "repository_2",<br>
&emsp;"ownerLogin: "login_2",<br>
&emsp;"branches: [<br>
&emsp;&emsp;{"branchName": "branch_2.1",<br>
&emsp;&emsp;"branchSha": branch_sha_2.1"}]<br>
&emsp;}<br>
]

### If we pass incorrect parameters we will get an error message in the form:

{<br>
&emsp;"status": "${status}",<br>
&emsp;"message: "${message}"<br>
}

### Application returns two types of error message:

#### 1. Unsupported type of file (httpStatusCode = 406, Not Acceptable)
#### 2. Couldn't find user with provided username (httpStatusCode = 404, Not Found)
## Example usage

### atipera-api-consumer.up.railway.app/repositories/octocat/json

Above is a correct example url which give us access to response below:<br>

[<br>
&emsp;{<br>
&emsp;&emsp;  "repositoryName" : "git-consortium",<br>
&emsp;&emsp;  "ownerLogin" : "octocat",<br>
&emsp;&emsp;  "branches" : [ {<br>
&emsp;&emsp;&emsp;    "branchName" : "master",<br>
&emsp;&emsp;&emsp;    "branchSha" : "b33a9c7c02ad93f621fa38f0e9fc9e867e12fa0e"<br>
&emsp;&emsp;  } ]<br>
&emsp;},<br>
&emsp;{<br>
&emsp;&emsp;  "repositoryName" : "hello-worId",<br>
&emsp;&emsp;  "ownerLogin" : "octocat",<br>
&emsp;&emsp;  "branches" : [ {<br>
&emsp;&emsp;&emsp;    "branchName" : "master",<br>
&emsp;&emsp;&emsp;    "branchSha" : "7e068727fdb347b685b658d2981f8c85f7bf0585"<br>
&emsp;&emsp;  } ]<br>
&emsp;},<br> 
&emsp;{<br>
&emsp;&emsp;  "repositoryName" : "Hello-World",<br>
&emsp;&emsp;  "ownerLogin" : "octocat",<br>
&emsp;&emsp;  "branches" : [ {<br>
&emsp;&emsp;&emsp;    "branchName" : "master",<br>
&emsp;&emsp;&emsp;    "branchSha" : "7fd1a60b01f91b314f59955a4e4d4e80d8edf11d"<br>
&emsp;&emsp;&emsp;  }, {<br>
&emsp;&emsp;&emsp;    "branchName" : "octocat-patch-1<br>
&emsp;&emsp;&emsp;    "branchSha" : "b1b3f9723831141a31a1a7252a213e216ea76e56"<br>
&emsp;&emsp;&emsp;  }, {<br>
&emsp;&emsp;&emsp;    "branchName" : "test",<br>
&emsp;&emsp;&emsp;    "branchSha" : "b3cbd5bbd7e81436d2eee04537ea2b4c0cad4cdf"<br>
&emsp;&emsp;  } ]<br>
&emsp;},<br>
&emsp;{<br>
&emsp;&emsp;  "repositoryName" : "octocat.github.io",<br>
&emsp;&emsp;  "ownerLogin" : "octocat",<br>
&emsp;&emsp;  "branches" : [ {<br>
&emsp;&emsp;&emsp;    "branchName" : "gh-pages",<br>
&emsp;&emsp;&emsp;    "branchSha" : "c0e4a095428f36b81f0bd4239d353f71918cbef3"<br>
&emsp;&emsp;&emsp;  }, {<br>
&emsp;&emsp;&emsp;    "branchName" : "master",<br>
&emsp;&emsp;&emsp;    "branchSha" : "3a9796cf19902af0f7e677391b340f1ae4128433"<br>
&emsp;&emsp;  } ]<br>
&emsp;},<br>
&emsp;{<br>
&emsp;&emsp;  "repositoryName" : "Spoon-Knife",<br>
&emsp;&emsp;  "ownerLogin" : "octocat",<br>
&emsp;&emsp;  "branches" : [ {<br>
&emsp;&emsp;&emsp;    "branchName" : "change-the-title",<br>
&emsp;&emsp;&emsp;    "branchSha" : "f439fc5710cd87a4025247e8f75901cdadf5333d"<br>
&emsp;&emsp;&emsp;  }, {<br>
&emsp;&emsp;&emsp;    "branchName" : "main",<br>
&emsp;&emsp;&emsp;    "branchSha" : "d0dd1f61b33d64e29d8bc1372a94ef6a2fee76a9"<br>
&emsp;&emsp;&emsp;  }, {<br>
&emsp;&emsp;&emsp;    "branchName" : "test-branch",<br>
&emsp;&emsp;&emsp;    "branchSha" : "58060701b538587e8b4ab127253e6ed6fbdc53d1"<br>
&emsp;&emsp;  } ]<br>
&emsp;&emsp;&emsp;}, {<br>
&emsp;&emsp;  "repositoryName" : "test-repo1",<br>
&emsp;&emsp;  "ownerLogin" : "octocat",<br>
&emsp;&emsp;  "branches" : [ {<br>
&emsp;&emsp;&emsp;    "branchName" : "gh-pages",<br>
&emsp;&emsp;&emsp;    "branchSha" : "57523742631876181d95bc268e09fb3fd1a4d85e"<br>
&emsp;&emsp;  } ]<br>
&emsp;} <br> 
]

