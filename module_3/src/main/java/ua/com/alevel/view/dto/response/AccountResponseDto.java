package ua.com.alevel.view.dto.response;

import ua.com.alevel.persistence.entity.User;
import ua.com.alevel.persistence.entity.Account;
import ua.com.alevel.persistence.util.covertor.MoneyConvertorUtil;

public class AccountResponseDto extends ResponseDto {

    private Double balance;
    private String wallet;
    private User user;

    public AccountResponseDto() {
    }

    public AccountResponseDto(Account account) {
        this.balance = MoneyConvertorUtil.moneyConversionInDouble(account.getBalance());
        this.wallet = account.getWallet();
        if (account.getUser() != null) {
            this.user = account.getUser();
        }
        super.setId(account.getId());
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
