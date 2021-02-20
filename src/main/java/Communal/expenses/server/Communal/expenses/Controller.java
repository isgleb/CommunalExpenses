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

//    @Autowired
//    ExpenseRepository expenseRepository;

    @GetMapping("/payments-row-dtos")
    public ResponseEntity getPaymentRows() {

        return new ResponseEntity(paymentRepository.getPaymentRowDtos(), HttpStatus.OK);
    }


    @GetMapping("/payments/{id}")
    public ResponseEntity getPayments(@PathVariable Long id) {

        Optional<Payment> payment = paymentRepository.findById(id);

        return new ResponseEntity(payment, HttpStatus.BAD_REQUEST);
    }


//new
    @PostMapping("/payments")
    public ResponseEntity saveExpenses(@RequestBody PaymentDto payment) {

        System.out.println(payment);
//        paymentRepository.save(payment);

        return new ResponseEntity(HttpStatus.OK);
    }
}

//{"id":1,"clientId":23,
// "ownerName":"Victor",
// "address":"Arbat",
// "expenses":[
// {"id":2,
// "name":"cold water",
// "amount":1200,
// "paymentId":1}
//
// ,{"id":3,
// "name":"hot water",
// "amount":1200,
// "paymentId":1},
//
// {"id":5,"name":"repairment","amount":1200,"paymentId":1},{"id":4,"name":"electricity","amount":1200,"paymentId":1}]}





//
//{"id":1,"clientId":23,
//        "ownerName":"Victor",
//        "address":"Arbat",
//        "period":1613782759801,
//        "expenses":[{"id":2,"name":"cold water","amount":100000,"paymentId":1},{"id":3,"name":"hot water","amount":100000,"paymentId":1},{"id":5,"name":"repairment","amount":100000,"paymentId":1},{"id":4,"name":"electricity","amount":100000,"paymentId":1}]}