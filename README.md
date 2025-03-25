# Tax System


## 🔹 System Flow

- Register products.
- Register states.
- Set tax rates by state and year.

## 🔹 Explanation:

- **application** → Contains the **use cases and services**.
- **domain** → Represents the **business entities**.
- **infrastructure** → Contains the concrete implementations, such as **database (JPA), repositories and adapters**.
- **port** → Defines **interfaces** for communication between layers.
- **adapter** → Implements these interfaces, connecting **infrastructure to the application**.


## 🔹 Note

Maven and Java must be installed.

To run the application

## 🔹 Build and Test

To run the application, enter the project root folder and run the command:

```bash

mvn clean install package

```

This will generate a jar file in the /target folder

poc-tax-service-0.0.1-SNAPSHOT.jar

And then to run the application:

```bash

cd /target

java -jar poc-tax-service-0.0.1-SNAPSHOT.jar

```