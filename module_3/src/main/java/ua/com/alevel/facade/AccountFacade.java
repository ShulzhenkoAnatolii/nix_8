package ua.com.alevel.facade;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.persistence.entity.Transaction;
import ua.com.alevel.view.dto.request.AccountRequestDto;
import ua.com.alevel.view.dto.response.AccountResponseDto;
import ua.com.alevel.view.dto.response.PageData;
import ua.com.alevel.view.dto.response.TransactionResponseDto;

public interface AccountFacade extends BaseFacade<AccountRequestDto, AccountResponseDto> {
    PageData<TransactionResponseDto> findAllAccountsByUser(WebRequest request, Long accountId);
}
