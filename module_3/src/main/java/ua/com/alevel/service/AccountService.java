package ua.com.alevel.service;

import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Account;
import ua.com.alevel.persistence.entity.Transaction;

public interface AccountService extends BaseService<Account> {

    DataTableResponse<Transaction> findAllTransactionByAccountId(DataTableRequest request, Long accountId);
}
