package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.exception.EntityExistException;
import ua.com.alevel.persistence.dao.AccountDao;
import ua.com.alevel.persistence.dao.TransactionDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Account;
import ua.com.alevel.persistence.entity.Transaction;
import ua.com.alevel.service.AccountService;
import ua.com.alevel.service.TransactionService;
import ua.com.alevel.util.WebResponseUtil;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionDao transactionDao;
    private final AccountDao accountDao;

    public TransactionServiceImpl(TransactionDao transactionDao, AccountService accountService, AccountDao accountDao) {
        this.transactionDao = transactionDao;
        this.accountDao = accountDao;
    }

    @Override
    public void create(Transaction entity) {
        Account sender = entity.getSender();
        Account receiver = entity.getReceiver();
        sender.setBalance(sender.getBalance() - entity.getAmount());
        receiver.setBalance(receiver.getBalance() + entity.getAmount());
        accountDao.update(sender);
        accountDao.update(receiver);
        transactionDao.create(entity);
    }

    @Override
    public void update(Transaction entity) {
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public Transaction findById(Long id) {
        checkByExist(id);
        return transactionDao.findById(id);
    }

    @Override
    public DataTableResponse<Transaction> findAll(DataTableRequest request) {
        DataTableResponse<Transaction> dataTableResponse = transactionDao.findAll(request);
        long count = transactionDao.count();
        WebResponseUtil.initDataTableResponse(request, dataTableResponse, count);
        return dataTableResponse;
    }

    private void checkByExist(Long id) {
        if (!transactionDao.existById(id)) {
            throw new EntityExistException("entity not found");
        }
    }
}
