# TAx System


##🔹 System Flow

- Register products.
- Register states.
- Set tax rates by state and year.
- When registering a sale, search for the corresponding tax rate and calculate the amount of tax applied


### 🔹 Explanation:

- **application** → Contains the **use cases and services**.
- **domain** → Represents the **business entities**.
- **infrastructure** → Contains the concrete implementations, such as **database (JPA), repositories and adapters**.
- **port** → Defines **interfaces** for communication between layers.
- **adapter** → Implements these interfaces, connecting **infrastructure to the application**.