package ua.com.alevel.persistence.dao;

import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Account;
import ua.com.alevel.persistence.entity.Transaction;

import java.util.List;

public interface AccountDao extends BaseDao<Account>{

    DataTableResponse<Transaction> findAllTransactionByAccountId(DataTableRequest request, Long accountId);

    List<Transaction> findListTransaction(Long accountId);
}
