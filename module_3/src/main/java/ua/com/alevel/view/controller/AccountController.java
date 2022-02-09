package ua.com.alevel.view.controller;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.com.alevel.facade.AccountFacade;
import ua.com.alevel.facade.TransactionFacade;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.service.AccountService;
import ua.com.alevel.view.dto.request.AccountRequestDto;
import ua.com.alevel.view.dto.response.AccountResponseDto;
import ua.com.alevel.view.dto.response.PageData;
import ua.com.alevel.view.dto.response.UserResponseDto;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Controller
@RequestMapping("/accounts")
public class AccountController extends BaseController {

    private long update_id;
    private final UserFacade userFacade;
    private final AccountFacade accountFacade;
    private final TransactionFacade transactionFacade;

    public AccountController(UserFacade userFacade, AccountFacade accountFacade, TransactionFacade transactionFacade) {
        this.userFacade = userFacade;
        this.accountFacade = accountFacade;
        this.transactionFacade = transactionFacade;
    }

    private final HeaderName[] columnNames = new HeaderName[]{
            new HeaderName("№", null, null),
            new HeaderName("Wallet", "wallet", "wallet"),
            new HeaderName("Balance, USD", "balance", "balance"),
            new HeaderName("User", "user", "user"),
            new HeaderName("details", null, null),
            new HeaderName("delete", null, null)
    };

    private final HeaderName[] transactionColumnNames = new HeaderName[]{
            new HeaderName("№", null, null),
            new HeaderName("Sender", "sender", "sender"),
            new HeaderName("Sender wallet", null, null),
            new HeaderName("USD", "amount", "amount"),
            new HeaderName("Receiver", "receiver", "receiver"),
            new HeaderName("Recipient's wallet", null, null),
            new HeaderName("DATE", "date", "date"),
    };

    @GetMapping
    public String findAll(Model model, WebRequest request) {
        initDataTable(accountFacade.findAll(request), columnNames, model);
        model.addAttribute("createUrl", "/accounts/all");
        model.addAttribute("createNew", "null");
        model.addAttribute("cardHeader", "All accounts");
        return "pages/accounts/account_all";
    }

    @PostMapping("/all")
    public ModelAndView findAllRedirect(WebRequest request, ModelMap model) {
        return findAllRedirect(request, model, "accounts");
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable @Valid @Min(value = 1, message = "invalid id") @NotNull() Long id,
                          Model model, WebRequest request) {
        AccountResponseDto dto = accountFacade.findById(id);
        initDataTable(accountFacade.findAllAccountsByUser(request,id), transactionColumnNames, model);
        model.addAttribute("createUrl", "/accounts/details/" + id);
        model.addAttribute("createNew", "accountDetails");
        model.addAttribute("cardHeader", "All Transactions");
        model.addAttribute("account", dto);
        return "pages/accounts/account_details";
    }

    @PostMapping("/details/{id}")
    public ModelAndView findAllByAccountRedirect(@PathVariable Long id,
                                                 WebRequest request,
                                                 ModelMap modelMap) {
        return findAllRedirect(request, modelMap, "accounts/details/" + id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        accountFacade.delete(id);
        return "redirect:/accounts";
    }

    @GetMapping("/update/{id}")
    public String updateAccountPage(@PathVariable @Valid @Min(value = 1, message = "invalid id") @NotNull() Long id,
                                    @ModelAttribute("account") AccountRequestDto dto, Model model, WebRequest request) {
        update_id = id;
        PageData<UserResponseDto> users = userFacade.findAll(request);
        model.addAttribute("usersList", userFacade.findAll(request));
        return "pages/accounts/account_update";
    }

    @PostMapping("/update")
    public String updateAccount(@ModelAttribute("account") AccountRequestDto dto) {
        accountFacade.update(dto, update_id);
        return "redirect:/accounts";
    }

    @GetMapping("/new/{id}")
    public String redirectToNewAccountPage(Model model, @PathVariable Long id) {
        AccountRequestDto account = new AccountRequestDto();
        account.setUserId(id);
        model.addAttribute("account", account);
        return "pages/accounts/account_new";
    }

    @PostMapping("/new")
    public String createNewAccount(@ModelAttribute("account") AccountRequestDto dto) {
        accountFacade.create(dto);
        return "redirect:/users/" + dto.getUserId() + "/account";
    }
}
