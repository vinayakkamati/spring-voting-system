# Architecture and design

> 1. Adding candidates

* The Client makes an HTTP Post request by entering candidate name.
* Validate candidate name, If candidate not present in data base then **add that candidate name and initialize vote with 0**.

> 2. Vote for candidate

* The Client makes an HTTP Post request by entering candidate name.
* Validate if candidate name is present in database then **increament vote count and update** it into database.
* If candidate name is not present in database, then return **Unable to find candidate** message.

> 3. Count total votes for candidate

* The Client makes an HTTP Get request by entering candidate name.
* Validate if candidate name is present in database then **return total votes for that candidate** from database.
* If candidate name is not present in database, then return **Unable to find candidate** message.

> 4. Listing all the candidates their votes

* The Client makes an HTTP Get request.
* **Return all names and votecounts**.

> 5. Find winner

* The Client makes an HTTP Get request.
* find the candidate **who got largest number of votes** from all the candidates, then **return the winning candidate name**. 
