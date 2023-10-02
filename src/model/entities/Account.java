package model.entities;

import model.exceptions.BusinessException;

public class Account {
    private Integer number;
    private String holer;
    private Double balance;
    private Double withDrawLimit;

    public Account(Integer number, String holer, Double balance, Double withDrawLimit) {
        this.number = number;
        this.holer = holer;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHoler() {
        return holer;
    }

    public void setHoler(String holer) {
        this.holer = holer;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithDrawLimit() {
        return withDrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void withDraw(Double amount){
        validateWithDraw(amount);
        balance -= amount;
    }

    public void validateWithDraw(Double amount){
        if(amount > getWithDrawLimit()){
            throw new BusinessException("Withdraw error: The amount exceeds withdraw limit");
        }
        if(amount > getBalance()){
            throw new BusinessException("Withdraw error: Not enough balance");
        }
    }
}
