package Communal.expenses.server.Communal.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
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

        if (payment.isPresent()) {
            System.out.println(payment.get().getId());
            PaymentDto paymentDto = new PaymentDto();
            paymentDto.setId(payment.get().getId());
            paymentDto.setClientId(payment.get().getClientId());
            paymentDto.setOwnerName(payment.get().getOwnerName());
            paymentDto.setAddress(payment.get().getAddress());
            paymentDto.setPeriod(payment.get().getPeriod());

            Map<String, Integer> expensesMap = new HashMap<>();

            for (Expense expense: payment.get().getExpenses()) {
                expensesMap.put(expense.getName(), expense.getAmount());
            }

            paymentDto.setExpenses(expensesMap);

            return new ResponseEntity(paymentDto, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/expenses")
    public ResponseEntity saveExpenses(@RequestBody PaymentDto paymentDto, @RequestParam Long paymentId) {

        Payment payment = new Payment(paymentDto.getId(),
                paymentDto.getClientId(),
                paymentDto.getOwnerName(),
                paymentDto.getAddress(),
                paymentDto.getPeriod());

        List<Expense> expenseList = new ArrayList<>();

        for (Map.Entry<String, Integer> pair : paymentDto.getExpenses().entrySet()) {
            expenseList.add(new Expense(pair.getKey(), pair.getValue(), paymentId));
        }

        paymentRepository.save(payment);
        expenseRepository.saveAll(expenseList);

        return new ResponseEntity(HttpStatus.OK);
    }
}
