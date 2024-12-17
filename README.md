
# Expense Management API

## API Endpoints

### 1. Get All Expenses
- **API:** `GET /api/expense`
- **Description:** Fetch all expenses.
- **Sample Response:**
  ```json
  [
    {
      "id": 1,
      "amount": 1000.0,
      "type": "Cash In",
      "date": "2024-12-17",
      "purpose": "Salary",
      "paymentMode": "Bank Transfer"
    },
    {
      "id": 2,
      "amount": 500.0,
      "type": "Cash Out",
      "date": "2024-12-15",
      "purpose": "Groceries",
      "paymentMode": "Cash"
    }
  ]
  ```

### 2. Get Expense by ID
- **API:** `GET /api/expense/{id}`
- **Description:** Fetch a specific expense by its ID.
- **Sample Response:**
  ```json
  {
    "id": 1,
    "amount": 1000.0,
    "type": "Cash In",
    "date": "2024-12-17",
    "purpose": "Salary",
    "paymentMode": "Bank Transfer"
  }
  ```

### 3. Add a Cash-In Expense
- **API:** `POST /api/expense/cash-in`
- **Description:** Add a new cash-in expense.
- **Sample Request:**
  ```json
  {
    "amount": 1200.0,
    "date": "2024-12-16",
    "purpose": "Freelance Work",
    "paymentMode": "UPI"
  }
  ```
- **Sample Response:**
  ```json
  {
    "id": 3,
    "amount": 1200.0,
    "type": "Cash In",
    "date": "2024-12-16",
    "purpose": "Freelance Work",
    "paymentMode": "UPI"
  }
  ```

### 4. Add a Cash-Out Expense
- **API:** `POST /api/expense/cash-out`
- **Description:** Add a new cash-out expense.
- **Sample Request:**
  ```json
  {
    "amount": 300.0,
    "date": "2024-12-15",
    "purpose": "Utility Bill",
    "paymentMode": "Credit Card"
  }
  ```
- **Sample Response:**
  ```json
  {
    "id": 4,
    "amount": 300.0,
    "type": "Cash Out",
    "date": "2024-12-15",
    "purpose": "Utility Bill",
    "paymentMode": "Credit Card"
  }
  ```

### 5. Delete an Expense
- **API:** `DELETE /api/expense/delete/{id}`
- **Description:** Delete an expense by its ID.
- **Sample Response:** 
  ```json
  {
    "message": "Expense with ID {id} deleted successfully."
  }
  ```

### 6. Update an Expense
- **API:** `PUT /api/expense/put/{id}`
- **Description:** Update an existing expense.
- **Sample Request:**
  ```json
  {
    "amount": 200.0,
    "purpose": "Updated Purpose"
  }
  ```
- **Sample Response:**
  ```json
  {
    "id": 1,
    "amount": 200.0,
    "type": "Cash In",
    "date": "2024-12-17",
    "purpose": "Updated Purpose",
    "paymentMode": "Bank Transfer"
  }
  ```
