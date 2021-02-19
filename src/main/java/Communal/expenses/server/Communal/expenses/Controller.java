package Communal.expenses.server.Communal.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        return new ResponseEntity(paymentRepository.findById(id), HttpStatus.OK);
    }


    @GetMapping("/expenses")
    public ResponseEntity getExpenses(@RequestParam Long paymentId) {
        List<Expense> expenseList = expenseRepository.getByPayment_id(paymentId);
        Map<String, Integer> expenseMap = new HashMap<>();
        expenseList.forEach(expense -> expenseMap.put(expense.name, expense.amount));

        return new ResponseEntity(expenseMap, HttpStatus.OK);
    }

    @PostMapping("/expenses")
    public ResponseEntity saveExpenses(@RequestBody Map<String, Integer> theMap, @RequestParam Long paymentId) {

        List<Expense> expenseList = new ArrayList<>();

        for (Map.Entry<String, Integer> pair : theMap.entrySet()) {
            expenseList.add(new Expense(pair.getKey(), pair.getValue(), paymentId));
        }

        expenseRepository.saveAll(expenseList);

        return new ResponseEntity(HttpStatus.OK);
    }
}
