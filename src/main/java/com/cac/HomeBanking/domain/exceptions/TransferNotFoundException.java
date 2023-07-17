package com.cac.HomeBanking.domain.exceptions;

public class TransferNotFoundException extends RuntimeException {

    public TransferNotFoundException(String message) {
        super(message);
    }

}
