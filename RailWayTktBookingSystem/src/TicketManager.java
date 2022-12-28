import java.util.Scanner;

public class TicketManager {
    DataBase TrainDB;
    TrainTable TrainInfo;
    PassengerTable PassDB;
    Scanner scan;
    int ch;
    String Decorator[] = { "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~",
            "++++++++++++++++++++++++++++++++++++++++++++" };

    void close() {
        TrainDB.Close();
    }

    int chooseDay() {
        int index = 1;
        int day = -1;
        scan = new Scanner(System.in);
        while (day == -1) {
            System.out.println("Choose Your Day of Journey :");
            index = 1;
            for (String i : TrainDB.days) {
                System.out.println((index++) + "." + i);
            }
            day = scan.nextInt();
            if (day > 0 && day < 8) {
                break;
            } else {
                System.out.println("Sorry " + day + " is a Wrong Choice Try again !");
                day = -1;
            }
        }
        return day;
    }

    TicketManager() throws Exception {
        TrainDB = new DataBase("Resources\\TrainDB.db");
        TrainInfo = new TrainTable(TrainDB);
        PassDB = new PassengerTable(TrainDB);
        boolean run = true;
        Scanner scan = new Scanner(System.in);
        while (run) {
            DisplayMenu();
            ch = scan.nextInt();
            switch (ch) {
                case 1: // Display
                    System.out.println(Decorator[0]);
                    System.out.println("Displaying available Trains");
                    System.out.println(Decorator[0]);
                    TrainInfo.DisplayAllTrain(chooseDay());
                    System.out.println(Decorator[1]);
                    break;
                case 2: // Enquire
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Enquiring Ticket");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("1.Enquire with TicketId");
                    System.out.println("2.Enquire with  Gpid");
                    System.out.println("3.Go Back to MainMenu");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    scan = new Scanner(System.in);
                    ch = scan.nextInt();
                    switch (ch) {
                        case 1: // Enquire with TktId
                            try {
                                int day = chooseDay();

                                System.out.println("Enter a valid TicketId");
                                // scan = new Scanner(System.in);
                                PassDB.DisplayPassengerWRT_TktId(day, scan.nextInt());

                            } catch (Exception e) {
                                System.out.println("Not a valid Ticket Id");
                            }
                            break;
                        case 2: // Enquire with GpId
                            try {
                                int day = chooseDay();
                                // scan = new Scanner(System.in);
                                System.out.println("Enter Your Group ID");
                                PassDB.DisplayPassengerWRT_GpId(day, scan.nextInt());

                            } catch (Exception e) {
                                System.out.println("Not a valid Group Ticket Id");
                            }
                            break;

                        case 3: // Back

                            System.out.println("ReDirecting Back to Main Menu ");
                            break;

                        default:
                            System.out.println("Wrong Choice!");
                            System.out.println("ReDirecting Back to Main Menu ");
                            break;
                    }

                    System.out.println(Decorator[0]);

                    break;
                case 3: // Printing Ticket
                    // TODO later
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Printing Ticket");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    try {
                        int day = chooseDay();
                        scan = new Scanner(System.in);
                        System.out.println("Enter Your Group ID");
                        PassDB.DisplayPassengerWRT_GpId(day, scan.nextInt());
                    } catch (Exception e) {
                        System.out.println("Not a valid Group Ticket Id");
                    }
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                    break;
                case 4: // Booking Ticket
                    System.out.println(Decorator[0]);
                    System.out.println("Booking new Ticket");
                    System.out.println(Decorator[0]);
                    BookTicket();
                    System.out.println(Decorator[1]);
                    break;
                case 5: // Cancelling Ticket
                    System.out.println(Decorator[0]);
                    System.out.println("Cancelling Ticket");
                    System.out.println(Decorator[0]);
                    CancelTicket();
                    System.out.println(Decorator[1]);
                    break;
                case 6: // Exit
                    run = false;
                    System.out.println("Quiting ...");
                    System.out.println(Decorator[1]);
                    break;
                case 777:
                    System.out.println("Dev mode ...");
                    System.out.println("1.Display All PassData");
                    System.out.println("2.Display CanceledData");
                    System.out.println("3.Display WaitingList");
                    System.out.println("4.RESET ALL DAYS");
                    System.out.println("5.Exit");
                    scan = new Scanner(System.in);
                    ch = scan.nextInt();
                    int day;
                    switch (ch) {
                        case 1:
                            day = chooseDay();
                            PassDB.DisplayAllPassenger(day);
                            break;
                        case 2:
                            PassDB.DisplayAllCanceledPassenger();
                            break;
                        case 3:
                            PassDB.DisplayAllWaitingPassenger();
                            break;
                        case 4:
                            System.out.println("Reseting all Days!");
                            for (int i = 1; i < 8; i++) {
                                TrainInfo.ResetAllDetails(i);
                            }
                        case 5:
                            System.out.println("Quiting ...");
                            break;
                        default:
                            System.out.println("Wrong Choice !");
                            break;
                    }
                default:
                    System.out.println("Wrong Choice !");
                    break;
            }
        }
        scan.close();
    }

    void CancelTicket() throws Exception {
        int ID, ch;
        System.out.println("1.Cancel using TktID\n2.Cancel using GpId\n3.Go Back");
        System.out.println(Decorator[0]);
        scan = new Scanner(System.in);
        ch = scan.nextInt();
        int day;
        switch (ch) {
            case 1:
                day = chooseDay();
                scan = new Scanner(System.in);
                System.out.print("Enter TktID    :");
                ID = scan.nextInt();
                PassDB.RemovePassengerTktID(day, ID);
                PassengerINFO pINFO = PassDB.getPassengerINFO(day, ID);
                PassDB.ConfirmEarlyPassenger(day, pINFO.TrainNumber, pINFO.CarClass);
                break;
            case 2:
                day = chooseDay();
                scan = new Scanner(System.in);
                System.out.print("Enter GpId    :");
                ID = scan.nextInt();
                PassDB.RemovePassengerGroup(day, ID);
                break;
            case 3:
                System.out.println("Going Back ...");
                return;

            default:
                System.out.println("Going Back due to Wrong option");
                break;
        }
    }

    void DisplayMenu() {
        System.out.println("\n\n" + Decorator[1]);
        System.out.println("\tRailway Reservation system");
        System.out.println(Decorator[1]);
        System.out.println(
                "1.Display Available Trains \n2.Enquire Ticket \n3.Print Ticket \n4.Book New Ticket \n5.Cancel Ticket \n6.Exit");
        System.out.println(Decorator[1]);
        System.out.print("Enter your Choice :");
    }

    void displayFare(int day, int TrainNumber, int Adult, int Baby) {
        try {
            Adult = Adult <0?-1*Adult:Adult ;
            System.out.println(Decorator[0]);
            System.out.println(
                    "Total Fare = Rs." + (Adult) * TrainInfo.GetSeatFare(day, TrainNumber, (char) (ch + 64)));
            System.out.println("Passenger count = " + (Adult) + "\n Baby Count = " + Baby);
            System.out.println(Decorator[0]);
        } catch (Exception e) {
            System.out.println("Error occured while calculating fare");
        }
    }

    void BookTicket() throws Exception {
        int TrainNumber, PassCount, Gpid, Age;
        int baby = 0;
        String passName;
        char sex;
        int day = chooseDay();

        TrainInfo.DisplayAllTrain(day);
        System.out.println("Enter Train Number  :");
        scan = new Scanner(System.in);
        TrainNumber = scan.nextInt();

        while (!TrainInfo.isTrainNumberValid(day, TrainNumber)) {
            TrainInfo.DisplayAllTrain(day);
            scan = new Scanner(System.in);
            System.out.println("Enter a Valid Train Number!");
            TrainNumber = scan.nextInt();
        }

        TrainInfo.DisplayTrainWRT_TNo(day, TrainNumber);
        try {
            TrainInfo.GetTicketInfo(day, TrainNumber);
        } catch (Exception e) {
            System.out.println("Wrong Train Number");
            return;
        }
        System.out.println("Enter Number of Passengers ");
        PassCount = scan.nextInt();
        System.out.println("Select which Class Ticket \n1.A\n2.B\n3.C\n4.Go Back");
        ch = scan.nextInt();

        if (ch > 0 && ch < 4) {
            Gpid = ++PassDB.CurrentGpid[day - 1];
            for (int i = 0; i < PassCount; i++) {
                scan = new Scanner(System.in);
                System.out.print("Enter Passenger " + (i + 1) + "'s Name   :");
                passName = scan.nextLine();
                System.out.print("Enter Age of " + passName + "   :");
                Age = scan.nextInt();
                baby += Age < 8 ? 1 : 0;
                System.out.println("Enter the Gender of " + passName);
                System.out.println("\t1.Male\n\t2.Female\n\t3.Other");
                int localCh = scan.nextInt();

                switch (localCh) {
                    case 1: // MALE
                        sex = 'M';
                        break;
                    case 2: // FEMALE
                        sex = 'F';
                        break;
                    case 3: // OTHERS
                        sex = 'O';
                        break;
                    default: // UNDEFINED
                        sex = 'U';
                        break;
                }
                PassDB.InsertNewPassenger(day, Gpid, TrainNumber, passName, Age, sex, (char) (64 + ch),
                        (Age < 8 ? -3 : 0), 0);
            }

            displayFare(day, TrainNumber, PassCount - baby, baby);
            PassDB.DisplayPassengerWRT_GpId(day, Gpid);
        } else {
            System.out.println("Quitting Due to Wrong Input");
            return;
        }

    }

}
