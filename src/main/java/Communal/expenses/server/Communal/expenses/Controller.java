package Communal.expenses.server.Communal.expenses;

import Communal.expenses.server.Communal.expenses.Repositories.PaymentRepository;
import Communal.expenses.server.Communal.expenses.Repositories.PaymentRowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping("/payments2")
    public void getCosts() {

//        List<PaymentRowDto> paymentRowDtos = paymentRepository.method2();

//
//        List<Payment> payments = paymentRepository.method();
//        List<PaymentRowDto> paymentRowDtos = new ArrayList<>();
//
//        for (Payment aPayment: payments) {
//            PaymentRowDto paymentRowDto = new PaymentRowDto();
//            paymentRowDto.setId(aPayment.getId());
//            paymentRowDto.setName(aPayment.getClientName());
//            paymentRowDto.setAddress(aPayment.getAddress());
//
//            int paymentSum = 0;
//            List<Expense> expenses = aPayment.getExpenses();
//            for(Expense expense : expenses) {
//                paymentSum += expense.getAmount();
//            }
//            paymentRowDto.setAmount(paymentSum);
//            paymentRowDto.setPeriod(aPayment.getPeriod());
//
//
//            paymentRowDtos.add(paymentRowDto);
//
//        }

//        return new ResponseEntity(paymentRowDtos, HttpStatus.OK);
        List<PaymentRowDto> payments = paymentRepository.method2();
        for (PaymentRowDto payment: payments) {
            System.out.println(payments);
        }

//        return new ResponseEntity(HttpStatus.OK);
    }
}
