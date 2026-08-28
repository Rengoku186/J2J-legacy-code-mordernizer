---
original_file: "legacy_source\DemoApplication.java"
language: "Java"
chunk_id: "chunk_28"
confidence_score: 0.95
external_dependencies: ["java.util.HashMap", "java.util.Map"]
---

# Documentation for `User` and `UserService` Classes

## Overview
This code defines two static classes, `User` and `UserService`, which are part of a user management and authentication system. The `User` class represents individual users, while the `UserService` class provides functionality to manage users and handle authentication.

---

## `User` Class
The `User` class is a simple data model that encapsulates the details of a user.

### Fields
- `private String username`: Stores the username of the user.
- `private String password`: Stores the password of the user. **Note:** In a real-world application, passwords should be hashed and not stored in plain text.
- `private String role`: Represents the role of the user, such as `EMPLOYEE` or `ACCOUNT_HOLDER`.

### Constructor
```java
public User(String username, String password, String role)
```
Initializes a new `User` object with the provided `username`, `password`, and `role`.

#### Parameters
- `username`: The username of the user.
- `password`: The password of the user.
- `role`: The role of the user.

### Methods
- `public String getUsername()`: Returns the username of the user.
- `public String getPassword()`: Returns the password of the user.
- `public String getRole()`: Returns the role of the user.

---

## `UserService` Class
The `UserService` class provides methods to manage users and handle authentication.

### Fields
- `private Map<String, User> users`: A map that stores users, where the key is the username and the value is the corresponding `User` object.

### Constructor
```java
public UserService()
```
Initializes a new `UserService` object and pre-populates it with some sample users for demonstration purposes.

#### Sample Users
- `employee1` with password `password123` and role `EMPLOYEE`.
- `account1001` with password `chequeuser` and role `ACCOUNT_HOLDER`.
- `account1002` with password `securepass` and role `ACCOUNT_HOLDER`.

### Methods

#### `registerUser`
```java
public void registerUser(String username, String password, String role)
```
Registers a new user by adding them to the `users` map.

##### Parameters
- `username`: The username of the new user.
- `password`: The password of the new user.
- `role`: The role of the new user.

##### Behavior
- Creates a new `User` object with the provided details.
- Adds the `User` object to the `users` map.
- Prints a confirmation message to the console.

#### `authenticate`
```java
public User authenticate(String username, String password)
```
Authenticates a user by verifying their username and password.

##### Parameters
- `username`: The username of the user attempting to authenticate.
- `password`: The password provided by the user.

##### Returns
- The `User` object if authentication is successful.
- `null` if authentication fails.

##### Behavior
- Retrieves the `User` object associated with the given `username` from the `users` map.
- Compares the provided `password` with the stored password.
- Prints a success or failure message to the console based on the result of the authentication.

---

## Notes
- The `password` field in the `User` class is stored in plain text, which is a security risk. It is recommended to use a secure hashing algorithm to store passwords.
- The `UserService` class is initialized with some hardcoded sample users, which is suitable for demonstration purposes but not for production use.
- The `UserService` class uses a `HashMap` to store user data, which provides efficient lookups by username.

---

## External Dependencies
- `java.util.HashMap`: Used to store user data in the `users` map.
- `java.util.Map`: Interface implemented by `HashMap` for the `users` map.