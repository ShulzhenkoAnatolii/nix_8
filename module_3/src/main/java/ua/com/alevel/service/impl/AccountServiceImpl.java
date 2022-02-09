package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.exception.EntityExistException;
import ua.com.alevel.persistence.dao.AccountDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Account;
import ua.com.alevel.persistence.entity.Transaction;
import ua.com.alevel.service.AccountService;
import ua.com.alevel.util.WebResponseUtil;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void create(Account entity) {
        accountDao.create(entity);
    }

    @Override
    public void update(Account entity) {
        checkByExist(entity.getId());
        accountDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        checkByExist(id);
        accountDao.delete(id);
    }

    @Override
    public Account findById(Long id) {
        checkByExist(id);
        return accountDao.findById(id);
    }

    @Override
    public DataTableResponse<Account> findAll(DataTableRequest request) {
        DataTableResponse<Account> dataTableResponse = accountDao.findAll(request);
        long count = accountDao.count();
        WebResponseUtil.initDataTableResponse(request, dataTableResponse, count);
        return dataTableResponse;
    }

    private void checkByExist(Long id) {
        if (!accountDao.existById(id)) {
            throw new EntityExistException("entity not found");
        }
    }

    @Override
    public DataTableResponse<Transaction> findAllTransactionByAccountId(DataTableRequest request, Long accountId) {
        DataTableResponse<Transaction> dataTableResponse = accountDao.findAllTransactionByAccountId(request, accountId);
        long count = accountDao.findListTransaction(accountId).size();
        WebResponseUtil.initDataTableResponse(request, dataTableResponse, count);
        return dataTableResponse;
    }

}
