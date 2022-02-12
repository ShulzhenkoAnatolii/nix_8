package ua.com.alevel.view.dto.response;

import ua.com.alevel.persistence.entity.Account;
import ua.com.alevel.persistence.entity.Transaction;
import ua.com.alevel.persistence.util.covertor.MoneyConvertorUtil;

import java.time.LocalDateTime;
import java.util.Date;

public class TransactionResponseDto extends ResponseDto{

    private LocalDateTime date;
    private Double amount;
    private Account sender;
    private Account receiver;

    public TransactionResponseDto() {
    }

    public TransactionResponseDto(Transaction transaction) {
        this.date = transaction.getDate();
        this.amount = MoneyConvertorUtil.moneyConversionInDouble(transaction.getAmount());
        if (transaction.getSender() != null) {
            this.sender = transaction.getSender();
        }
        if (transaction.getReceiver() != null) {
            this.receiver = transaction.getReceiver();
        }
        super.setId(transaction.getId());
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }
}
