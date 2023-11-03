import java.util.*;

public class AtmTransaction {
    static int balance;
    static ArrayList<Integer> al;

    public static void main(String args[]) {
        // Scanner s=new Scanner (System.in);
        System.out.println("$$~ WELCOME TO PUNJAB NATIONAL BANK ~$$");
        int limit = 3;
        long pass = 7421;
        al = new ArrayList<>();
        al.add(0);
        al.add(0);
        al.add(0);
        al.add(0);
        System.out.println("~~Please insert your ATM card~~");
        System.out.println("Enter your Pin.");
        password(pass, limit);
    }

    public static void password(long pass, int limit) {
        Scanner s = new Scanner(System.in);
        TransactionHistory th = new TransactionHistory();
        Withdraw w = new Withdraw();
        Deposit d = new Deposit();
        Transfer t = new Transfer();
        Quit q = new Quit();
        long pin = s.nextLong();
        if (pin != pass) {
            if (limit == 0) {
                System.out.println("Sorry your limit is exceeded try after 24 hours ");
                return;
            }
            System.out.println("!!Incorrect Pin!!\nPlease Enter your correct Pin");
            password(pass, limit - 1);
        } else {
            System.out.println("~~~What you want~~~");
            System.out.println("Press 1 for check Transaction History");
            System.out.println("Press 2 for withdraw ");
            System.out.println("Press 3 for Deposit ");
            System.out.println("Press 4 for Transfer ");
            System.out.println("Press 5 for Quit Transaction ");
            System.out.print("Select any  =");
            while (true) {
                int select = s.nextInt();
                switch (select) {
                    case 1:
                        th.transaction(balance, al);
                        break;
                    case 2:
                        balance = w.withdraw(balance, al);
                        break;
                    case 3:
                        balance = d.deposit(balance, al);
                        break;
                    case 4:
                        balance = t.transfer(balance, al);
                        break;
                    case 5:
                        q.quit(5);
                        break;
                    default:
                        System.out.println("!!!Invalid Input!!!");
                }
            }
        }
    }
}

class TransactionHistory {
    void transaction(int balance, ArrayList<Integer> al) {
        System.out.println("Available Balance = " + balance);
        for (int i = al.size() - 1; i >= al.size() - 4; i--) {
            if (al.get(i) > 0) {
                System.out.println("Recived Amount =   +" + al.get(i));
            } else if (al.get(i) < 0) {
                System.out.println("Send Amount =   " + al.get(i));
            } else {
                System.out.println("------No Trensaction------");
            }
        }
    }
}

class Withdraw {
    int withdraw(int balance, ArrayList<Integer> al) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the your amount  = ");
        int wdAmount = s.nextInt();
        if (wdAmount <= balance) {
            System.out.println("Your Debited amount is  = " + wdAmount);
            System.out.println("Your Remaining Balance is  =" + (balance - wdAmount));
            al.add(-wdAmount);
            return balance - wdAmount;
        } else {
            System.out.println("!!! Insufficiant balance !!!");
            return balance;
        }
    }
}

class Deposit {
    int deposit(int balance, ArrayList<Integer> al) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the your amount  = ");
        int depAmount = s.nextInt();
        System.out.println("Your Credited amount is  = " + depAmount);
        System.out.println("Your Current Balance is  = " + (balance + depAmount));
        al.add(depAmount);
        return balance + depAmount;
    }
}

class Transfer {
    int transfer(int balance, ArrayList<Integer> al) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter bank account number =");
        long acNo = s.nextLong();
        System.out.println("Enter amount  =");
        int transferAmount = s.nextInt();
        if (transferAmount <= balance) {
            al.add(-transferAmount);
            System.out.println("The Amount " + transferAmount + " is transfered \n in bank account number " + acNo
                    + "\n Successfully:");
            System.out.println("Your Remaining Balance is  =" + (balance - transferAmount));
            return balance - transferAmount;
        } else {
            System.out.println("!!! Insufficiant balance !!!");
            return balance;
        }
    }
}

class Quit {
    void quit(int x) {
        System.out.println("$$$ Thanks for Choosing This Bank $$$");
        System.exit(x);
    }
}
