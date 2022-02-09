package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.exception.EntityExistException;
import ua.com.alevel.persistence.dao.UserDao;
import ua.com.alevel.persistence.dao.AccountDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.User;
import ua.com.alevel.persistence.entity.Account;
import ua.com.alevel.service.UserService;
import ua.com.alevel.util.WebResponseUtil;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final AccountDao accountDao;

    public UserServiceImpl(UserDao userDao, AccountDao accountDao) {
        this.userDao = userDao;
        this.accountDao = accountDao;
    }

    @Override
    public void create(User entity) {
        userDao.create(entity);
    }

    @Override
    public void update(User entity) {
        checkByExist(entity.getId());
        userDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        checkByExist(id);
        List<Account> students = userDao.findListAccounts(id);
        for (Account student : students) {
            accountDao.delete(student.getId());
        }
        userDao.delete(id);
    }

    @Override
    public User findById(Long id) {
        checkByExist(id);
        return userDao.findById(id);
    }

    @Override
    public DataTableResponse<User> findAll(DataTableRequest request) {
        DataTableResponse<User> dataTableResponse = userDao.findAll(request);
        long count = userDao.count();
        WebResponseUtil.initDataTableResponse(request, dataTableResponse, count);
        return dataTableResponse;
    }

    private void checkByExist(Long id) {
        if (!userDao.existById(id)) {
            throw new EntityExistException("entity not found");
        }
    }

    @Override
    public DataTableResponse<Account> findAllAccountsByUser(DataTableRequest request, Long userId) {
        DataTableResponse<Account> dataTableResponse = userDao.findAllAccountsByUser(request, userId);
        long count = userDao.findListAccounts(userId).size();
        WebResponseUtil.initDataTableResponse(request, dataTableResponse, count);
        return dataTableResponse;
    }
}
