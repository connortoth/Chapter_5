package Chapter_5;
//*******************************************************
// Account.java
//
//CONNOR TOTH && IAN LEVY
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, and get a String representation
// of the account.
//*******************************************************

public class Account
{
  private double balance;
  private String name;
  private long acctNum;
  
  private static int depositCount, withdrawCount;
  private static double depositTotal, withdrawTotal;

  //----------------------------------------------
  //Constructor -- initializes balance, owner, and account number
  //----------------------------------------------
  public Account(double initBal, String owner, long number)
  {
    balance = initBal;
    name = owner;
    acctNum = number;
  }

  //----------------------------------------------
  // Checks to see if balance is sufficient for withdrawal.
  // If so, decrements balance by amount; if not, prints message.
  //----------------------------------------------
  public void withdraw(double amount)
  {
    if (balance >= amount)
    {
       balance -= amount;
    
       //updates withdraw static variables
       withdrawCount++;
       withdrawTotal += amount;
    }
    else
       System.out.println("Insufficient funds");
  }

  //----------------------------------------------
  // Adds deposit amount to balance.
  //----------------------------------------------
  public void deposit(double amount)
  {
    balance += amount;
    
    //updates deposit static variables
    depositCount++;
    depositTotal += amount;
  }

  //----------------------------------------------
  // Returns balance.
  //----------------------------------------------
  public double getBalance()
  {
    return balance;
  }
  
  //----------------------------------------------
  // Returns total funds deposited.
  //----------------------------------------------
  public static double getDepositTotal()
  {
    return depositTotal;
  }
  
  //----------------------------------------------
  // Returns total deposit interactions.
  //----------------------------------------------
  public static int getDepositCount()
  {
    return depositCount;
  }
  
  //----------------------------------------------
  // Returns total funds withdrawn.
  //----------------------------------------------
  public static double getWithdrawTotal()
  {
    return withdrawTotal;
  }
  
  //----------------------------------------------
  // Returns total withdraw interactions.
  //----------------------------------------------
  public static int getWithdrawCount()
  {
    return withdrawCount;
  }
  
  //----------------------------------------------
  // Returns total funds withdrawn.
  //----------------------------------------------
  public long getAcctNumber()
  {
    return acctNum;
  }
  
  //----------------------------------------------
  //Resets the value of the static counter variables
  //----------------------------------------------
  public static void resetStaticVariables()
  {
	  depositTotal = 0;
	  depositCount = 0;
	  withdrawTotal = 0;
	  withdrawCount = 0;
  }
  
  //---------------------------------------------
  //prints the toString string.
  //---------------------------------------------
  public void printSummary()
  {
	  System.out.println(this.toString());
  }
  
  //----------------------------------------------
  // Returns a string containing the name, account number, and balance.
  //----------------------------------------------
  public String toString()
  {
	return ("Name:" + name + "\nAccount Number: " + acctNum + "\nBalance: " + balance);
  }
  
  //----------------------------------------------
  // Transfers funds from this account to account acct 
  //----------------------------------------------
  public void transfer(Account acct, double amount)
  {
    if (balance < amount)
    {
      System.out.println("ERROR! INSUFFICIENT FUNDS YO!");
      
    }
    else
    {
      withdraw(amount);
      acct.deposit(amount);
     
    }
   }
  
  //-------------------------------------------
  //transfers funds from acct1 to acct2
  //-------------------------------------------
  public static void transfer(Account acct1, Account acct2 , double amount )
  {
    if (acct1.getBalance() < amount)
    {
      System.out.println("ERROR! INSUFFICIENT FUNDS YO!");
      
    }
    else
    {
      acct1.withdraw(amount);
      acct2.deposit(amount);
     
    }
  }
  }