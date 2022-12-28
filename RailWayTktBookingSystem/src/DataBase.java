import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

class PassengerINFO {
    int TktID, Gpid, TrainNumber, Age, day, State,SeatNum;
    char CarClass, Sex;
    String PassName;
    Timestamp Time;
}

class TrainINFO {
    int day;
    int Train_Number;
    String Train_Name, src, dst;
    int A, B, C, Price_A, Price_B, Price_C;
}

public class DataBase {
    String jdbcUrl = "jdbc:sqlite:/" + System.getProperty("user.dir") + "\\";
    Connection connection;

    String days[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

    DataBase(String path) {
        jdbcUrl += path;
        try {
            connection = DriverManager.getConnection(jdbcUrl);
        } catch (Exception e) {
            System.out.println("[Error] connecting to database at " + jdbcUrl);
            e.printStackTrace();
        }

    }

    void Close() {
        try {
            connection.close();
        } catch (SQLException s) {
            System.out.println("connection is Already Closed !");
        }

    }

}

class TrainTable {
    DataBase DB;
    Connection connection;
    Statement sqlStatement;
    String decoratorString = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    TrainINFO trainI;

    // CONSTRUCTOR
    TrainTable(DataBase dataBase) throws Exception {
        this.DB = dataBase;
        this.connection = this.DB.connection;
        sqlStatement = connection.createStatement();

    }
    // END (CONSTRUCTOR)

    // GETTER FUNCTION
    int[] GetTicketInfo(int day, int Train_Number) {
        int TKTCount[] = { 0, 0, 0 };
        try {
            String Query = "SELECT A,B,C FROM Train" + day + " WHERE Train_Number == " + Train_Number;
            ResultSet RS = sqlStatement.executeQuery(Query);
            TKTCount[0] = RS.getInt(1);
            TKTCount[1] = RS.getInt(2);
            TKTCount[2] = RS.getInt(3);
            return TKTCount;
        } catch (Exception e) {
            System.out.println("Error Check your TrainNumber");
        }
        return TKTCount;

    }

    int[] GetMaxTicketCount(int day, int Train_Number) throws Exception {

        String Query = "SELECT Total_Seat_A, Total_Seat_B, Total_Seat_C FROM Train" + day;
        ResultSet res = sqlStatement.executeQuery(Query);
        int max[] = { res.getInt("Total_Seat_A"), res.getInt("Total_Seat_B"), res.getInt("Total_Seat_C") };
        return max;
    }

    ResultSet GetTrainNumberResult(int day) {
        String Query = "SELECT Train_Number from Train" + day;
        try {
            ResultSet RS = sqlStatement.executeQuery(Query);
            return RS;
        } catch (Exception e) {
            System.out.println("Error Check your TrainNumber");
            return null;
        }
    }

    int GetSeatFare(int day, int TrainNumber, char Class) throws Exception {
        String Query = "SELECT Price_" + Class + " FROM Train" + day + " WHERE Train_Number ==" + TrainNumber;
        ResultSet rSet = sqlStatement.executeQuery(Query);
        return rSet.getInt("Price_" + Class);
    }

    boolean isTrainNumberValid(int day, int TrainNumber) throws Exception {
        ResultSet rSet = GetTrainNumberResult(day);
        boolean out = false;
        while (rSet.next()) {
            if (TrainNumber == rSet.getInt(1)) {
                out = true;
            }
        }
        return out;
    }
    // END (GETTER FUNCTION)

    // UPDATE FUNCTION
    void UpdateTrainSeatInfo(int day, int Train_Number, int A, int B, int C) {
        /*
         * if value is positive it will cause DECREMENT in count;
         * Else it will Cause Increment in count
         */
        try {
            String Query = "SELECT A,B,C FROM Train" + day + " WHERE Train_Number == " + Train_Number;
            ResultSet RS = sqlStatement.executeQuery(Query);
            if (RS.getInt(1) - A >= 0 && RS.getInt(2) - B >= 0 && RS.getInt(3) >= 0) {
                Query = "UPDATE Train" + day + " SET A = " + ((int) RS.getInt(1) - A) + ",B = "
                        + ((int) RS.getInt(2) - B)
                        + ",C = "
                        + ((int) RS.getInt(3) - C) + " Where Train_Number == " + Train_Number;
                sqlStatement.executeUpdate(Query);
            } else {
                System.out.println("Error Querried Tickets are not available!");
            }
        } catch (SQLException sException) {
            System.out.println("Error In Sql Query");
            System.out.println(sException.getSQLState());
        }
    }

    void InsertNewTrain(int day, int Train_Number, String Train_Name, String src, String dst, int A, int B, int C)
            throws Exception {
        String Query = "INSERT INTO Train" + day + " VALUES (" + Train_Number + "," + "'" + Train_Name + "','" + src
                + "','" + dst
                + "'," + A + "," + B + "," + C + ")";
        System.out.println(Query);
        sqlStatement.executeUpdate(Query);
    }
    // END (UPDATE FUNCTION)

    // DISPLAY FUNCTION
    void DisplayAllTrain(int day) throws Exception {
        ResultSet res = sqlStatement.executeQuery(
                "SELECT Train_Number, Train_Name, src, dst, A, B, C, Price_A, Price_B, Price_C FROM Train" + day);
        DisplayByResultSet(day, res);
    }

    void DisplayTrainWRT_SRC(int day, String SRC) throws Exception {
        ResultSet res = sqlStatement.executeQuery("SELECT * FROM Train" + day + " WHERE src == '" + SRC + "'");
        DisplayByResultSet(day, res);
    }

    void DisplayTrainWRT_DST(int day, String DST) throws Exception {
        ResultSet res = sqlStatement.executeQuery("SELECT * FROM Train" + day + "  WHERE src == '" + DST + "'");
        DisplayByResultSet(day, res);
    }

    void DisplayTrainWRT_TNo(int day, int TNo) throws Exception {
        ResultSet res = sqlStatement.executeQuery("SELECT * FROM Train" + day + "  WHERE Train_Number == " + TNo);
        DisplayByResultSet(day, res);
    }
    // END (DISPLAY FUNCTION)

    // UTILITIES
    private void DisplayByResultSet(int day, ResultSet res) throws Exception {
        System.out.println("Day Of Journey is [" + DB.days[day - 1] + "]");
        System.out.println(decoratorString);
        System.out.println(
                "Index\tTNo\tTName\tSRC\tDST\tClass A\t:Price in Rs\tClass B\t:Price in Rs\tClass C\t:Price in Rs");
        System.out.println(decoratorString);
        int Index = 1;
        while (res.next()) {
            System.out.println(Index + "\t" + res.getInt("Train_Number") + "\t" + res.getString("Train_Name") + "\t"
                    + res.getString("src") + "\t"
                    + res.getString("dst") + "\t" + res.getInt("A") + "\t: Rs." + res.getInt("Price_A") + "\t"
                    + res.getInt("B") + "\t: Rs." + res.getInt("Price_B") + "\t" + res.getInt("C") + "\t: Rs."
                    + res.getInt("Price_C")
                    + "\t");
            Index++;
        }
        System.out.println(decoratorString);
    }

    void ResetAllDetails(int day) throws Exception {
        System.out.println(" [WARNING] DELETING AND RESETING ALL DATA  of DAY ["+DB.days[day-1]+"] !");
        String Query = "UPDATE Train" + day + "  SET A = 100 , B = 200 , C = 300";
        sqlStatement.executeUpdate(Query);
        Query = "DELETE FROM Passenger"+day;
        sqlStatement.executeUpdate(Query);

    }
    // END (UTILITIES)
}

class PassengerTable {
    DataBase DB;
    TrainTable TDB;
    Connection connection;
    Statement sqlStatement;
    int CurrentGpid[] = { 0, 0, 0, 0, 0, 0, 0 };
    String decoratorString = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

    // CONSTRUCTOR
    PassengerTable(DataBase dataBase) throws Exception {
        this.DB = dataBase;
        this.TDB = new TrainTable(this.DB);
        this.connection = this.DB.connection;
        sqlStatement = connection.createStatement();
        updateCurrentGpid();
    }

    // END (CONSTRUCTOR)
    // TODO convert all function suitable for seat and state:
    // UPDATE FUNCTION
    void InsertNewPassenger(int day, int GpId, int Train_Number, String PassName, int Age, char Sex, char Class,
            int SeatNum, int state)
            throws Exception {
        ConfirmEarlyPassenger(day, Train_Number, Class);
        int prevTicketCount[] = TDB.GetTicketInfo(day, Train_Number);
        int MaxCount[] = TDB.GetMaxTicketCount(day, Train_Number);
        int ClassIndex = (int) Class - 65;
        String Query1, Query2;
        if (state == 0) {
            SeatNum = MaxCount[ClassIndex] - prevTicketCount[ClassIndex] + 1;
            state = 1;
            if (SeatNum > MaxCount[ClassIndex]) {
                SeatNum = 0;
                state = -1;

            }
            if (SeatNum > 0) {
                Query2 = "UPDATE Train" + day + "  SET " + Class + " = " + (prevTicketCount[ClassIndex] - 1)
                        + " WHERE Train_Number == " + Train_Number;
                sqlStatement.executeUpdate(Query2);
            }
        }

        Query1 = "INSERT into Passenger" + day + "  (GpId,Train_Number ,PassName,Age,Sex,Class,SeatNum,State) VALUES("
                + GpId + ","
                + Train_Number + ",'" + PassName + "'," + Age + ",'" + Sex + "','" + Class + "'," + SeatNum + " , "
                + state + ")";

        sqlStatement.executeUpdate(Query1);
    }

    int ConfirmEarlyPassenger(int day, int TrainNumber, char Class) throws Exception {
        freeUnAllocatedCancelledPasseger(day, TrainNumber, Class);
        int operation = 0;
        PassengerINFO PasInfo = new PassengerINFO();
        int cancelledTktId;
        int NewTktId, count = GetNoCanceledPassenger(day, TrainNumber, Class,1);
        String Query;
        while (count > 0 && (NewTktId = getOneWaitingTktID(day, TrainNumber, Class)) != -1) {
            cancelledTktId = getOneCanceledTktID(day, TrainNumber, Class,1);
            PasInfo = getPassengerINFO(day, cancelledTktId);
            Query = "UPDATE Passenger" + day + "  Set SeatNum = " + PasInfo.SeatNum +" , State = 1"+ " WHERE TktID == "
                    + NewTktId;
            sqlStatement.executeUpdate(Query);
            DeleteTktIDFromPassenger(day, cancelledTktId);
            operation++;
            count--;
        }
        return operation;
    }

    void freeUnAllocatedCancelledPasseger(int day, int TrainNumber, char Class) throws Exception{
        int WasteTktId;
        while((WasteTktId = getOneCanceledTktID(day, TrainNumber, Class, 0))!= -1){
            DeleteTktIDFromPassenger(day,WasteTktId);
        }
    }
    void updateCurrentGpid() throws Exception {
        for (int i = 1; i < 8; i++) {
            ResultSet res = sqlStatement.executeQuery("SELECT GpId FROM Passenger" + i);
            int gpid = 0;
            while (res.next()) {
                gpid = res.getInt("GpId");
            }
            CurrentGpid[i - 1] = gpid;
        }
    }

    void RemovePassengerTktID(int day, int TktID) throws Exception {
        String Query2 = "UPDATE Passenger" + day + "  SET State = -2 WHERE TktID ==" + TktID;
        sqlStatement.executeUpdate(Query2);
    }

    void RemovePassengerGroup(int day, int GpId) throws Exception {
        String Query2 = "UPDATE Passenger" + day + "  SET State = -2 WHERE GpId == " + GpId;
        sqlStatement.executeUpdate(Query2);
    }

    void DeleteTktIDFromPassenger(int day, int TktID) throws Exception {
        String Query = "DELETE FROM Passenger" + day + "  WHERE TktID == " + TktID + " AND State = -2";
        sqlStatement.executeUpdate(Query);
    }
    // END (UPDATE FUNCTION)

    // GETTER FUNCTION
    PassengerINFO getPassengerINFO(int day, int TktID) throws Exception {
        PassengerINFO passInfo = new PassengerINFO();
        ResultSet res = sqlStatement.executeQuery("SELECT * FROM Passenger" + day + "  WHERE TktId ==" + TktID);
        if (res.next()) {
            passInfo.day = day;
            passInfo.Age = res.getInt("Age");
            passInfo.CarClass = res.getString("Class").charAt(0);
            passInfo.Gpid = res.getInt("GpId");
            passInfo.Time = res.getTimestamp("Time");
            passInfo.PassName = res.getString("PassName");
            passInfo.Sex = res.getString("Sex").charAt(0);
            passInfo.TktID = res.getInt("TktID");
            passInfo.TrainNumber = res.getInt("Train_Number");
            passInfo.State = res.getInt("State");
            passInfo.SeatNum = res.getInt("SeatNum");
        }

        return passInfo;
    }

    int getPassCountInGroup(int day, int groupId) throws Exception {
        int pCount = 0;
        String Query = "SELECT GpId from Passenger" + day + "  WHERE Gpid == " + groupId + " AND State != -2";
        ResultSet rSet = sqlStatement.executeQuery(Query);

        while (rSet.next()) {
            pCount++;
        }
        if (pCount == 0) {
            return -1;
        } else {
            return pCount;
        }

    }

    int GetNoCanceledPassenger(int day, int Train_Number, char Class,int Automatic) throws Exception {
        String Query;
        if(Automatic == 1){
            Query = "SELECT TktID FROM Passenger" + day + "  WHERE Train_Number == " + Train_Number
                    + " AND Class == '" + Class
                    + "' AND State == -2 AND SeatNum != 0";
            }else{
                Query = "SELECT TktID FROM Passenger" + day + "  WHERE Train_Number == " + Train_Number
                + " AND Class == '" + Class
                + "' AND State == -2 AND SeatNum == 0";            
            }
        ResultSet rSet = sqlStatement.executeQuery(Query);
        int count = 0;
        while (rSet.next()) {
            count++;
        }
        return count == 0 ? -1 : count;
    }

    int getOneCanceledTktID(int day, int Train_Number, char Class,int Automatic) throws Exception {
        String Query;
        if(Automatic == 1){
        Query = "SELECT TktID FROM Passenger" + day + "  WHERE Train_Number == " + Train_Number
                + " AND Class == '" + Class
                + "' AND State == -2 AND SeatNum != 0";
        }else{
            Query = "SELECT TktID FROM Passenger" + day + "  WHERE Train_Number == " + Train_Number
            + " AND Class == '" + Class
            + "' AND State == -2 AND SeatNum == 0";            
        }
        ResultSet rSet = sqlStatement.executeQuery(Query);

        int out = -1;
        if (rSet.next()) {
            out = rSet.getInt("TktID");
        }
        return out;
    }

    int GetNoWaitingPassenger(int day, int Train_Number, char Class) throws Exception {
        String Query = "SELECT TktID FROM Passenger" + day + "  WHERE Train_Number == " + Train_Number
                + " AND Class == '" + Class
                + "' AND State == -1";
        ResultSet rSet = sqlStatement.executeQuery(Query);
        int count = 0;
        while (rSet.next()) {
            count++;
        }
        return count == 0 ? -1 : count;
    }

    int getOneWaitingTktID(int day, int Train_Number, char Class) throws Exception {
        String Query = "SELECT TktID FROM Passenger" + day + "  WHERE Train_Number == " + Train_Number
                + " AND Class == '" + Class
                + "' AND State == -1";
        ResultSet rSet = sqlStatement.executeQuery(Query);

        int out = -1;
        if (rSet.next()) {
            out = rSet.getInt("TktID");
        }
        return out;
    }
    // END (GETTER FUNCTION)

    // DISPLAY FUNCTION (GOD MODE)
    void DisplayAllCanceledPassenger() throws Exception {
        for (int i = 1; i < 8; i++) {
            ResultSet res = sqlStatement.executeQuery("SELECT * FROM Passenger" + i + "  WHERE State == -2");
            DisplayByResultSet(i, res);
        }
    }

    void DisplayAllWaitingPassenger() throws Exception {
        for (int i = 1; i < 8; i++) {
            ResultSet res = sqlStatement.executeQuery("SELECT * FROM Passenger" + i + "  WHERE State == -1");
            DisplayByResultSet(i, res);
        }
    }

    // DISPLAY FUNCTION (REGULAR MODE)
    void DisplayAllPassenger(int day) throws Exception {
        ResultSet res = sqlStatement.executeQuery("SELECT * FROM Passenger" + day);
        DisplayByResultSet(day, res);
    }

    void DisplayPassengerWRT_TrainNo(int day, int tNo) throws Exception {
        ResultSet res = sqlStatement
                .executeQuery("SELECT * FROM Passenger" + day + "  WHERE Train_Number ==" + tNo + " AND State != -2");
        DisplayByResultSet(day, res);
    }

    void DisplayPassengerWRT_GpId(int day, int GpId) throws Exception {
        ResultSet res = sqlStatement
                .executeQuery("SELECT * FROM Passenger" + day + "  WHERE GpId ==" + GpId + " AND State != -2");
        DisplayByResultSet(day, res);
    }

    void DisplayPassengerWRT_TktId(int day, int TktId) throws Exception {
        ResultSet res = sqlStatement
                .executeQuery("SELECT * FROM Passenger" + day + "  WHERE TktId ==" + TktId + " AND State != -2");
        DisplayByResultSet(day, res);
    }
    // END (DISPLAY FUNCTION)

    // UTILITIES
    private void DisplayByResultSet(int day, ResultSet res) throws Exception {
        System.out.println("Day of journey [" + DB.days[day - 1] + "]");
        System.out.println(decoratorString);
        System.out.println("TktID\tGpId\tTrain_Number\tClass\tSeatNum\tState\tTimeStamp\t\tAge\tSex\tPassenger_Name");
        System.out.println(decoratorString);
        while (res.next()) {
            System.out.println(res.getInt("TktID") + "\t" + res.getInt("GpId") + "\t" + res.getInt("Train_Number")
                    + "\t\t"
                    + res.getString("Class") + "\t" + res.getInt("SeatNum") + "\t" + res.getInt("State") + "\t"
                    + res.getTimestamp("Time") + "\t"
                    + res.getInt("Age") + "\t" + res.getString("Sex") + "\t" + res.getString("PassName"));
        }
        System.out.println(decoratorString);
    };
    // END (UTILITIES)
}