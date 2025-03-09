package banking_system;

import java.util.ArrayList;
import java.util.List;

//---------- Singleton Transaction Processor ----------
class TransactionProcessor {
 private static TransactionProcessor instance;
 private List<TransactionObserver> observers = new ArrayList<>();

 private TransactionProcessor() {}

 public static TransactionProcessor getInstance() {
     if (instance == null) {
         instance = new TransactionProcessor();
     }
     return instance;
 }

 public void addObserver(TransactionObserver observer) {
     observers.add(observer);
 }

 public void notifyObservers(String accountId, String message) {
     observers.forEach(observer -> observer.update(accountId, message));
 }
}

//---------- Template Method for Transaction Processing ----------
abstract class Transaction {
 protected final double amount;
 protected final String accountId;

 public Transaction(String accountId, double amount) {
     this.accountId = accountId;
     this.amount = amount;
 }

 // Template method
 public final void process() {
     if (validateTransaction()) {
         if (performTransaction()) {
             TransactionProcessor.getInstance().notifyObservers(accountId, 
                 getTransactionType() + " of $" + amount + " processed");
         }
     }
 }

 protected abstract boolean validateTransaction();
 protected abstract boolean performTransaction();
 protected abstract String getTransactionType();
}

//---------- Chain of Responsibility for Validation ----------
abstract class ValidationHandler {
 protected ValidationHandler nextHandler;
 protected Account account;

 public ValidationHandler setNext(ValidationHandler handler) {
     this.nextHandler = handler;
     return handler;
 }

 public abstract boolean validate(Transaction transaction);
}

class BalanceValidator extends ValidationHandler {
 @Override
 public boolean validate(Transaction transaction) {
     // Balance validation logic
     boolean isValid = account.getBalance() >= transaction.amount;
     if (isValid && nextHandler != null) {
         return nextHandler.validate(transaction);
     }
     return isValid;
 }
}

class FraudValidator extends ValidationHandler {
 @Override
 public boolean validate(Transaction transaction) {
     // Fraud detection logic
     boolean isValid = transaction.amount <= 1000000; // Simple example
     if (isValid && nextHandler != null) {
         return nextHandler.validate(transaction);
     }
     return isValid;
 }
}

//---------- Observer Pattern ----------
interface TransactionObserver {
 void update(String accountId, String message);
}

class AuditDepartment implements TransactionObserver {
 @Override
 public void update(String accountId, String message) {
     System.out.println("Audit Log: Account " + accountId + " - " + message);
 }
}

class AccountHolder implements TransactionObserver {
 @Override
 public void update(String accountId, String message) {
     System.out.println("Customer Notification: Account " + accountId + " - " + message);
 }
}

//---------- Account and Transaction Types ----------
class Account {
 private String accountId;
 private double balance;

 public Account(String accountId, double initialBalance) {
     this.accountId = accountId;
     this.balance = initialBalance;
 }

 public double getBalance() {
     return balance;
 }

 public void updateBalance(double amount) {
     this.balance += amount;
 }
}

class WithdrawalTransaction extends Transaction {
 private Account account;

 public WithdrawalTransaction(Account account, double amount) {
     super(account.toString(), amount);
     this.account = account;
 }

 @Override
 protected boolean validateTransaction() {
     // Set up validation chain
     ValidationHandler balanceValidator = new BalanceValidator();
     ValidationHandler fraudValidator = new FraudValidator();
     balanceValidator.setNext(fraudValidator);
     return balanceValidator.validate(this);
 }

 @Override
 protected boolean performTransaction() {
     account.updateBalance(-amount);
     return true;
 }

 @Override
 protected String getTransactionType() {
     return "Withdrawal";
 }
}