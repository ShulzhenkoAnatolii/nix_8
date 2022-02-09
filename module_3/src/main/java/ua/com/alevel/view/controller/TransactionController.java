package ua.com.alevel.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.com.alevel.exception.MethodArgumentNotValidException;
import ua.com.alevel.facade.AccountFacade;
import ua.com.alevel.facade.TransactionFacade;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.view.dto.request.TransactionRequestDto;

@Controller
@RequestMapping("/transactions")
public class TransactionController extends BaseController {

    private final TransactionFacade transactionFacade;
    private final AccountFacade accountFacade;
    private final HeaderName[] transactionColumnNames = new HeaderName[]{
            new HeaderName("№", null, null),
            new HeaderName("Sender", "sender", "sender"),
            new HeaderName("Sender wallet", null, null),
            new HeaderName("USD", "amount", "amount"),
            new HeaderName("Receiver", "receiver", "receiver"),
            new HeaderName("Recipient's wallet", null, null),
            new HeaderName("DATE", "date", "date"),
    };

    public TransactionController(TransactionFacade transactionFacade, UserFacade userFacade, AccountFacade accountFacade) {
        this.transactionFacade = transactionFacade;
        this.accountFacade = accountFacade;
    }

    @GetMapping
    public String findAll(Model model, WebRequest request) {
        initDataTable(transactionFacade.findAll(request), transactionColumnNames, model);
        model.addAttribute("createUrl", "/transactions/all");
        model.addAttribute("createNew", "transaction");
        model.addAttribute("cardHeader", "All Transactions");
        return "pages/transactions/transaction_all";
    }

    @PostMapping("/all")
    public ModelAndView findAllRedirect(WebRequest request, ModelMap model) {
        return findAllRedirect(request, model, "transactions");
    }

    @GetMapping("/new")
    public String redirectToNewTransactionPage(Model model, WebRequest request) {
        model.addAttribute("transaction", new TransactionRequestDto());
        model.addAttribute("accountsList", accountFacade.findAll(request));
        return "pages/transactions/transaction_new";
    }

    @PostMapping("/new")
    public String createNewTransaction(@ModelAttribute("transaction") TransactionRequestDto dto) {
        if (dto.getAmount() > accountFacade.findById(dto.getSenderId()).getBalance()){
            throw new MethodArgumentNotValidException("not enough money");
        }
        if (dto.getAmount() <= 0){
            throw new MethodArgumentNotValidException("invalid amount");
        }
        if (dto.getSenderId().equals(dto.getReceiverId())){
            throw new MethodArgumentNotValidException("sender account match receiver account");
        }
        transactionFacade.create(dto);
        return "redirect:/transactions";
    }
}
