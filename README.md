# 📖 Minimalist Book Manager API

## Introduction
This is the starter repository for the Further APIs session. It provides a start to creating a Minimalist Book Manager API
using a Test-Driven Development approach.

### Pre-Requisites
- Java SE Development Kit 17
- Maven

### Technologies & Dependencies
- Spring Boot
- Spring Web
- H2 Database
- Lombok
- Spring Data JPA

### How to Get Started
- Fork this repo to your Github and then clone the forked version of this repo

### Main Entry Point
- The Main Entry Point for the application is: [BookmanagerApplication.java](src/main/java/com/techreturners/bookmanager/BookmanagerApplication.java)

### Running the Unit Tests
- You can run the unit tests in IntelliJ, or you can go to your terminal and inside the root of this directory, run:

`mvn test`

### Tasks

Here are some tasks for you to work on:

📘 Discussion Task

Explore the code and make notes on the following features and how it is being implemented in the code. We'd like you to note down what classes and methods are used and how the objects interact.

The features are:
- Get All Books :     controller::getAllBooks -> BookManagerService::getAllBooks -> BookManagerRepository::BookManagerRepository
- Get a Book by ID :  controller::getBookById -> BookManagerService::getBookById -> BookManagerRepository::findById
- Add a Book :        controller::addBook -> BookManagerService::insertBook -> BookManagerRepository::save
- Update a Book :     controller::updateBookById -> BookManagerService::deleteBookById -> BookManagerRepository::findById/save



📘 Task 1: Implement the following User Story with tests.

`User Story: As a user, I want to use the Book Manager API to delete a book using its ID`
 controller::deleteBookById -> BookManagerService::updateBookById -> BookManagerRepository::deleteById 



📘 Extension Task: Oh no! 😭 We've only covered the happy paths in the solution, can you figure out a way
to add in exception handling to the project? 
>> some error / exception hamdling added (most notably - changing some operations to return error if operation not successful)

- Clue 1: What if someone wants to add a book with an ID for a book that already exists? How do we handle this gracefully?
- Clue 2: What if someone wants to find a book by an ID that doesn't yet exist? 

>> add in a "getBookById" check prior : 
On add by with existing id : if a book is returned - don't add book & send back Can't process add error.

On find book with id that doesn't exist - : if a book is not returned & send back Can't process add error.
(this would need to catch any "book not found" exception first)

  How can we improve the API by handling errors gracefully and show a helpful message to the client?
  Add in ResponseEntity processing (looks like this is used to add information that's sent back to the user)


  
