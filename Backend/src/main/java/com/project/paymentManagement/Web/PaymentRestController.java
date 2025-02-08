package com.project.paymentManagement.Web;

import com.project.paymentManagement.Repository.PaymentRepository;
import com.project.paymentManagement.Repository.UserRepository;
import com.project.paymentManagement.entities.Payment;
import com.project.paymentManagement.entities.PaymentStatus;
import com.project.paymentManagement.entities.PaymentType;
import com.project.paymentManagement.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentRestController {
    private UserRepository userRepository;
    private PaymentRepository paymentRepository;

    public PaymentRestController(PaymentRepository paymentRepository) {
        this.userRepository = userRepository;
        this.paymentRepository = paymentRepository;
    }
    @GetMapping(path ="/payments")
    public List<Payment> allPayments(){
        return paymentRepository.findAll();
    }
    @GetMapping(path ="/users/{code}/payments")
    public List<Payment> paymentsByUser(@PathVariable String code){
        return paymentRepository.findByUserCode(code);
    }
    @GetMapping(path ="/payments")
    public List<Payment> paymentsByStatus(@RequestParam PaymentStatus status){
        return paymentRepository.findByStatus(status);
    }
    @GetMapping(path ="/payments")
    public List<Payment> paymentsByType(@RequestParam PaymentType type){
        return paymentRepository.findByType(type);
    }

    @GetMapping(path ="/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).get();
    }
    @GetMapping(path="/users")
    public List<User> allUsers(){
        return userRepository.findAll();
    }
    @GetMapping(path="/users/{code}")
    public User getUserByCode(@PathVariable String code){
        return userRepository.findByCode(code);
    }
    @GetMapping("/usersByProgramId")
    public List<User> getUsersByProgramId(@RequestParam String programId){
        return userRepository.findByProgramId(programId);
    }

}
