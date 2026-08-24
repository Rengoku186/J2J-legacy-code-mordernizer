---
original_file: "legacy_source/DemoApplication.java"
language: "Java"
chunk_id: "chunk_28"
confidence_score: 0.95
external_dependencies: ["java.util.Map", "java.util.HashMap"]
---

# Documentation for `User` and `UserService` Classes

## Overview
This code chunk defines two static classes, `User` and `UserService`, which are part of a user management and authentication system. The `User` class represents individual users, while the `UserService` class provides functionality for managing users and handling authentication.

## `User` Class
The `User` class is a simple data model that encapsulates information about a user, including their username, password, and role.

### Fields
- `private String username`: Stores the username of the user.
- `private String password`: Stores the password of the user. **Note:** In a real-world application, passwords should be hashed for security.
- `private String role`: Represents the role of the user, such as `EMPLOYEE` or `ACCOUNT_HOLDER`.

### Constructor
```java
public User(String username, String password, String role)
```
Initializes a new `User` object with the provided username, password, and role.

### Methods
- `public String getUsername()`: Returns the username of the user.
- `public String getPassword()`: Returns the password of the user.
- `public String getRole()`: Returns the role of the user.

## `UserService` Class
The `UserService` class provides methods for managing users and authenticating them. It uses a `Map` to store user data, where the key is the username and the value is a `User` object.

### Fields
- `private Map<String, User> users`: A `HashMap` that stores user data.

### Constructor
```java
public UserService()
```
The constructor initializes the `users` map and populates it with some sample users for demonstration purposes. The sample users include:
- `employee1` with password `password123` and role `EMPLOYEE`
- `account1001` with password `chequeuser` and role `ACCOUNT_HOLDER`
- `account1002` with password `securepass` and role `ACCOUNT_HOLDER`

### Methods

#### `public void registerUser(String username, String password, String role)`
Registers a new user by adding them to the `users` map.

**Parameters:**
- `username`: The username of the new user.
- `password`: The password of the new user.
- `role`: The role of the new user.

**Behavior:**
- Creates a new `User` object with the provided details.
- Adds the `User` object to the `users` map.
- Prints a message indicating that the user has been registered.

#### `public User authenticate(String username, String password)`
Authenticates a user based on their username and password.

**Parameters:**
- `username`: The username of the user attempting to authenticate.
- `password`: The password of the user attempting to authenticate.

**Returns:**
- The authenticated `User` object if the username and password match.
- `null` if authentication fails.

**Behavior:**
- Retrieves the `User` object associated with the given username from the `users` map.
- Checks if the retrieved `User` object is not `null` and if the password matches.
- Prints a success message if authentication is successful, or a failure message otherwise.

## Notes
- The `User` class currently stores passwords in plain text, which is a security risk. In a production environment, passwords should be hashed and salted.
- The `UserService` class is designed for demonstration purposes and is not thread-safe. In a multi-threaded environment, additional synchronization would be required to ensure thread safety.