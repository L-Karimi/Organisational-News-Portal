# NEWS-PORTAL API

## Author
* Lucy  Karimi

### Description
* This is an Organizational Rest API that queries and retrieves scoped news and information within an organization.

## Features
A user visiting the news portal Api site will be able to:

1. Add New Departments & and also view local departments present.
2. Add new User/s' to andy department desired.
3. Add news in a particular department and view the news under the directed department.

## Prerequisites & Application Setup
- Use of version control. ie. Git
- Java SDK & Environment.
- Java IntelliJIDEA Community.
- Gradle.
- PostgreSQL
- Postman
### Clone Repository

- Depending on your preferable method of acquiring the Application to your local machine, you might as well try:
1. Forking the repository to your repositories.
2. Cloning the forked repository or cloning directly from my repository.
3. Finally run the project on your IntelliJIDEA `$ gradle build`, `$ gradle run` in your projects terminal.

## How to use (Behavior)
## User Guide
####View Landing page
* Method: GET
* Route: /
#### Create general News: 
* Method: POST:
* Route: /news/new
#### Create department News: 
* Method: POST:
* Route: /news/new
#### View all news: 
* Method: GET:
* Route: /news
#### View individual news: 
* Method: GET:
* Route: /news/:id
* where :id is a number 1,2,3 onwards
#### Create New Department: 
* Method: POST:
* Route: /department/new
#### View all departments: 
* Method: GET:
* Route: /departments
#### View individual department: 
* Method: GET:
* Route: /department/:id
* where :id is a number 1,2,3 onwards
#### View news of a particular department: 
* Method: GET:
* Route: /department/:id/news
* where :id is a number 1,2,3 onwards
#### View users of a particular department: 
* Method: GET:
* Route: /department/:id/users
* where :id is a number 1,2,3 onwards
#### Create New User: 
* Method: POST:
* Route: /user/new
#### View all users:
* Method: GET: 
* Route: /users
#### View individual user: 
* Method: GET:
* Route: /user/:id
* where :id is a number 1,2,3 onwards


## Technologies Used
- Java
- Java Spark*
- PostgreSQL
- Postman

## Bugs
~ At the moment there are no known bugs, but that is as if you come across any bug or functionality that fails, please feel free to reach out.

## Contact Information
~ For any inquiries or future git collaborative projects, reach out to:

Email: <a href="mailto:">luciahkei101@gmail.com</a>

## LICENSE
* Copyright 2020 Lucy Karimi
  
  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
  
  The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
  
  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

* licensed under MIT license