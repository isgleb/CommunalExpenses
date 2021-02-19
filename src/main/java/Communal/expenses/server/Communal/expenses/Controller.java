package Communal.expenses.server.Communal.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

        return new ResponseEntity(expenseRepository.getByPayment_id(paymentId), HttpStatus.OK);
    }


}
