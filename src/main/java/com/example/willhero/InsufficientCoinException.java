package com.example.willhero;

public class InsufficientCoinException extends Exception{
    public InsufficientCoinException(String message){
        super(message);
    }
}
