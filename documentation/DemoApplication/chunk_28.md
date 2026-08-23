---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_28"
confidence_score: 0.95
external_dependencies: ["java.util.Map", "java.util.HashMap"]
---

# Documentation for `User` and `UserService` Classes

## Overview
This code defines two static classes, `User` and `UserService`, which are part of a user management and authentication system. The `User` class represents individual users with attributes such as username, password, and role. The `UserService` class provides functionality to manage users, including registering new users and authenticating existing ones.

## `User` Class
The `User` class is a simple data model that encapsulates the following attributes:

### Fields
- `username` (String): The username of the user.
- `password` (String): The password of the user. **Note:** In a real-world application, passwords should be hashed and not stored in plain text.
- `role` (String): The role of the user, such as `EMPLOYEE` or `ACCOUNT_HOLDER`.

### Constructor
```java
public User(String username, String password, String role)
```
Initializes a new `User` object with the provided `username`, `password`, and `role`.

### Methods
- `getUsername()`: Returns the username of the user.
- `getPassword()`: Returns the password of the user.
- `getRole()`: Returns the role of the user.

## `UserService` Class
The `UserService` class provides methods to manage users and handle authentication.

### Fields
- `users` (Map<String, User>): A map that stores `User` objects, with the username as the key.

### Constructor
```java
public UserService()
```
Initializes the `UserService` and populates it with some sample users for demonstration purposes:
- `employee1` with password `password123` and role `EMPLOYEE`
- `account1001` with password `chequeuser` and role `ACCOUNT_HOLDER`
- `account1002` with password `securepass` and role `ACCOUNT_HOLDER`

### Methods

#### `registerUser`
```java
public void registerUser(String username, String password, String role)
```
Registers a new user by adding them to the `users` map.

**Parameters:**
- `username` (String): The username of the new user.
- `password` (String): The password of the new user.
- `role` (String): The role of the new user.

**Behavior:**
- Creates a new `User` object and stores it in the `users` map.
- Prints a message indicating the user has been registered.

#### `authenticate`
```java
public User authenticate(String username, String password)
```
Authenticates a user based on their username and password.

**Parameters:**
- `username` (String): The username of the user attempting to authenticate.
- `password` (String): The password of the user attempting to authenticate.

**Returns:**
- The authenticated `User` object if the username and password match.
- `null` if authentication fails.

**Behavior:**
- Retrieves the `User` object from the `users` map using the provided username.
- Compares the provided password with the stored password.
- Prints a message indicating whether authentication was successful or failed.

## Notes
- The `password` field in the `User` class is stored in plain text, which is a security risk. In a production environment, passwords should be hashed and salted.
- The `UserService` class is initialized with hardcoded sample users, which is suitable for demonstration purposes but not for production use.

## External Dependencies
- `java.util.Map`: Used to store the mapping between usernames and `User` objects.
- `java.util.HashMap`: Implementation of the `Map` interface used to store user data.