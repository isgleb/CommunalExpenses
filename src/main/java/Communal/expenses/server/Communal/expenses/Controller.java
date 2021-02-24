package Communal.expenses.server.Communal.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Controller {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    ExpenseRepository expenseRepository;

    @GetMapping("/payments-row-dtos")
    public ResponseEntity getPaymentRows() {

        return new ResponseEntity(paymentRepository.getPaymentRowDtos(), HttpStatus.OK);
    }


    @GetMapping("/payments/{id}")
    public ResponseEntity getPayments(@PathVariable Long id) {

        Optional<Payment> payment = paymentRepository.findById(id);

        return new ResponseEntity(payment, HttpStatus.OK);
    }

    @DeleteMapping("/payments/{id}")
    public ResponseEntity deletePayment(@PathVariable Long id) {

        paymentRepository.deleteById(id);

        return new ResponseEntity(HttpStatus.OK);
    }


//new
    @PostMapping("/payments")
    public ResponseEntity savePayment(@RequestBody Payment paymentDto) {

        Payment payment = new Payment();
        payment.setAddress(paymentDto.getAddress());
        payment.setClientId(paymentDto.getClientId());
        payment.setOwnerName(paymentDto.getOwnerName());
        payment.setPeriod(paymentDto.getPeriod());
        paymentRepository.save(payment);

        List<Expense> expenses = new ArrayList<>();

        for (Expense expense : paymentDto.getExpenses()) {
            Expense aNewExpense = new Expense(expense.getName(), expense.getAmount(), payment);
            expenses.add(aNewExpense);
        }
        expenseRepository.saveAll(expenses);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/payments")
    public ResponseEntity editPayment(@RequestBody Payment paymentDto) {

        Payment payment = paymentRepository.getOne(paymentDto.getId());
        payment.setClientId(paymentDto.getClientId());
        payment.setOwnerName(paymentDto.getOwnerName());
        payment.setAddress(paymentDto.getAddress());
        payment.setPeriod(paymentDto.getPeriod());
        paymentRepository.save(payment);

        List<Expense> expenses = new ArrayList<>();

        for (Expense expense : paymentDto.getExpenses()) {
            Expense anExpense = expenseRepository.getOne(expense.getId());
            anExpense.setAmount(expense.getAmount());
            expenses.add(anExpense);
        }

        expenseRepository.saveAll(expenses);

        return new ResponseEntity(HttpStatus.OK);
    }
}
