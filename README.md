# Bank Management System

This project implements a RESTful API for managing users, accounts, and transfers in a banking system. It provides endpoints to perform CRUD operations on these entities. The project is built using Spring Boot and utilizes a MySQL database.

## Endpoints

### User Endpoints

#### Get All Users

- **URL:** `/api/users`
- **Method:** `GET`
- **Description:** Retrieves a list of all users.
- **Response:** Returns a JSON array containing user objects.

#### Get User by ID

- **URL:** `/api/users/{id}`
- **Method:** `GET`
- **Description:** Retrieves a user by their ID.
- **Response:** Returns a JSON object representing the user.

#### Create User

- **URL:** `/api/users`
- **Method:** `POST`
- **Description:** Creates a new user.
- **Request Body:** Expects a JSON object representing the user to be created.
- **Response:** Returns a JSON object representing the created user.

#### Update User

- **URL:** `/api/users/{id}`
- **Method:** `PUT`
- **Description:** Updates an existing user.
- **Request Body:** Expects a JSON object representing the updated user.
- **Response:** Returns a JSON object representing the updated user.

#### Delete User

- **URL:** `/api/users/{id}`
- **Method:** `DELETE`
- **Description:** Deletes a user by their ID.
- **Response:** Returns a string indicating the success or failure of the deletion.

### Account Endpoints

#### Get All Accounts

- **URL:** `/api/accounts`
- **Method:** `GET`
- **Description:** Retrieves a list of all accounts.
- **Response:** Returns a JSON array containing account objects.

#### Get Account by ID

- **URL:** `/api/accounts/{id}`
- **Method:** `GET`
- **Description:** Retrieves an account by its ID.
- **Response:** Returns a JSON object representing the account.

#### Create Account

- **URL:** `/api/accounts`
- **Method:** `POST`
- **Description:** Creates a new account.
- **Request Body:** Expects a JSON object representing the account to be created.
- **Response:** Returns a JSON object representing the created account.

#### Update Account

- **URL:** `/api/accounts/{id}`
- **Method:** `PUT`
- **Description:** Updates an existing account.
- **Request Body:** Expects a JSON object representing the updated account.
- **Response:** Returns a JSON object representing the updated account.

#### Delete Account

- **URL:** `/api/accounts/{id}`
- **Method:** `DELETE`
- **Description:** Deletes an account by its ID.
- **Response:** Returns a string indicating the success or failure of the deletion.

### Transfer Endpoints

#### Get All Transfers

- **URL:** `/api/transfers`
- **Method:** `GET`
- **Description:** Retrieves a list of all transfers.
- **Response:** Returns a JSON array containing transfer objects.

#### Get Transfer by ID

- **URL:** `/api/transfers/{id}`
- **Method:** `GET`
- **Description:** Retrieves a transfer by its ID.
- **Response:** Returns a JSON object representing the transfer.

#### Create Transfer

- **URL:** `/api/transfers`
- **Method:** `POST`
- **Description:** Creates a new transfer.
- **Request Body:** Expects a JSON object representing the transfer to be created.
- **Response:** Returns a JSON object representing the created transfer.

#### Update Transfer

- **URL:** `/api/transfers/{id}`
- **Method:** `PUT`
- **Description:** Updates an existing transfer.
- **Request Body:** Expects a JSON object representing the updated transfer.
- **Response:** Returns a JSON object representing the updated transfer.

#### Delete Transfer

- **URL:** `/api/transfers/{id}`
- **Method:** `DELETE`
- **Description:** Deletes a transfer by its ID.
- **Response:** Returns a string indicating the success or failure of the deletion.

## Data Models

### User

Represents a user in the banking system.

- `id` (Long): The unique identifier of the user.
- `username` (String): The username of the user.
- `password` (String): The password of the user.
- `idAccounts` (List<Long>): A list of account IDs associated with the user.

### Account

Represents a bank account.

- `id` (Long): The unique identifier of the account.
- `amount` (BigDecimal): The balance amount of the account.
- `owner` (UserDto): The user who owns the account.

### Transfer

Represents a transfer between two accounts.

- `id` (Long): The unique identifier of the transfer.
- `origin` (Long): The ID of the origin account.
- `target` (Long): The ID of the target account.
- `date` (Date): The date of the transfer.
- `amount` (BigDecimal): The amount transferred.

## Exception Classes

### AccountNotFoundException

Thrown when an account is not found.

### TransferNotFoundException

Thrown when a transfer is not found.

## Data Transfer Objects (DTOs)

### UserDto

Represents a user DTO (Data Transfer Object).

- `id` (Long): The unique identifier of the user.
- `username` (String): The username of the user.
- `password` (String): The password of the user.
- `idAccounts` (List<Long>): A list of account IDs associated with the user.

### AccountDto

Represents an account DTO (Data Transfer Object).

- `id` (Long): The unique identifier of the account.
- `amount` (BigDecimal): The balance amount of the account.
- `owner` (UserDto): The user who owns the account.

### TransferDto

Represents a transfer DTO (Data Transfer Object).

- `id` (Long): The unique identifier of the transfer.
- `origin` (Long): The ID of the origin account.
- `target` (Long): The ID of the target account.
- `date` (Date): The date of the transfer.
- `amount` (BigDecimal): The amount transferred.

## Mapper Classes

### AccountMapper

Provides mapping methods between Account and AccountDto.

### TransferMapper

Provides mapping methods between Transfer and TransferDto.

### UserMapper

Provides mapping methods between User and UserDto.

## Repository Classes

### AccountRepository

Repository interface for managing Account entities.

### TransfersRepository

Repository interface for managing Transfer entities.

### UserRepository

Repository interface for managing User entities.

## Exception Classes

### AccountNotFoundException

Exception class for handling account not found errors.

### TransferNotFoundException

Exception class for handling transfer not found errors.

## Dependencies

- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL Driver

## Setup

To run the project, make sure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- MySQL database

1. Clone the repository.
2. Configure the MySQL database connection in the `application.properties` file.
3. Build the project using your preferred IDE or build tool.
4. Run the application.
5. The API will be accessible at `http://localhost:8080/api`.

Feel free to explore and test the provided endpoints using a REST client of your choice.

## Postman Collection
A Postman collection containing the endpoints for testing the API is available here in this repository.

You can import the collection into Postman to easily execute requests and test the functionality of the API.

## Contributors

- [Federico Mamoris]