# Train Ticketing System

**Overview**

This is a Java-based train ticketing system that allows users to:

* **View available trains**
* **Enquire about tickets**
* **Book tickets**
* **Cancel tickets**

**Database Structure**

The system utilizes an SQLite database with the following tables:

**Train Tables:**
* `Train_Number` (Primary Key)
* `Train_Name`
* `src` (Source station)
* `dst` (Destination station)
* `A`, `B`, `C` (Available seats in each class)
* `Total_Seat_A`, `Total_Seat_B`, `Total_Seat_C` (Total seats in each class)
* `Price_A`, `Price_B`, `Price_C` (Price for each class)

**Passenger Tables:**
* `TktID` (Primary Key, auto-incremented)
* `GpId` (Group ID)
* `Train_Number`
* `PassName` (Passenger name)
* `Age`
* `Sex`
* `Class` (Class of ticket)
* `SeatNum` (Seat number, -1 for waiting list)
* `State` (Ticket status: 0 for confirmed, -1 for waiting, -2 for canceled)
* `Time` (Booking time)

**How to Use:**

1. **Set up the database:** Create the database and tables using the provided SQL script.
2. **Run the `TicketManager` class:** This will start the application and display a menu.
3. **Follow the on-screen instructions** to perform various operations like booking tickets, canceling tickets, etc.

**Future Enhancements:**

- Implement a user authentication system.
- Integrate with a payment gateway for online payments.
- Add features like seat selection and dynamic pricing.
- Improve the user interface for a better user experience.

This implementation that can be improved to satisfy certain needs. For large-scale applications, think about utilizing a more reliable database system like PostgreSQL or MySQL.
