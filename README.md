# spring-voting-system

A very basic voting system application created with Java Spring.

## Features Implemented:

1. Adding candidates into database.
2. Vote for candidate.
3. Counting vote for particular candidate.
4. Listing all the candidates and their votes.
5. Finding the winner who got largest number of votes. 

## Usage Guide

> *Importing and Running The Project Through IntelliJ IDEA*

**Step 1:** Click On File > Code > Copy Https URL > Open terminal > change directory where you want save > Paste The Repository Url as: https://github.com/vinayakkamati/spring-voting-system.git > Enter.

**Step 2:** Open IntelliJ IDEA. [Install, if not already installed]

**Step 3:** Click on file > open > select file > Ok.

**Step 4:** Right click on SpringVotingSystemApplication file > Run.

**Step 5:** Check the Application is running At http://localhost:8080/

**Step 6:** Open postman, and please find the below URL's.

> ### POST

***Adding candidate:*** ```localhost:8080/vote/enterCandidate?name=Ajay```

***Cast vote:*** ```localhost:8080/vote/castVote?name=Ajay```

> ### GET 

***Count vote for candidate:*** ```localhost:8080/vote/countVote?name=Ajay```

***List all the candidates and their votes:*** ```localhost:8080/vote/listVote```

***Find the winner:*** ```localhost:8080/vote/getWinner```
