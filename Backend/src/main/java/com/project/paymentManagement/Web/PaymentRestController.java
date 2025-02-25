package com.project.paymentManagement.Web;

import com.project.paymentManagement.Repository.ClientRepository;
import com.project.paymentManagement.Repository.PaymentRepository;
import com.project.paymentManagement.Repository.ClientRepository;
import com.project.paymentManagement.entities.Payment;
import com.project.paymentManagement.entities.PaymentStatus;
import com.project.paymentManagement.entities.PaymentType;
import com.project.paymentManagement.entities.Client;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentRestController {
    private ClientRepository clientRepository;
    private PaymentRepository paymentRepository;

    public PaymentRestController(PaymentRepository paymentRepository,ClientRepository  clientRepository) {
        this.clientRepository = clientRepository;
        this.paymentRepository = paymentRepository;
    }
    @GetMapping(path ="/payments")
    public List<Payment> allPayments(){
        return paymentRepository.findAll();
    }
    @GetMapping(path ="/clients/{code}/payments")
    public List<Payment> paymentsByClient(@PathVariable String code){
        return paymentRepository.findByClientCode(code);
    }
    @GetMapping(path ="/payments/byStatus")
    public List<Payment> paymentsByStatus(@RequestParam PaymentStatus status){
        return paymentRepository.findByStatus(status);
    }
    @GetMapping(path ="/payments/byType")
    public List<Payment> paymentsByType(@RequestParam PaymentType type){
        return paymentRepository.findByType(type);
    }

    @GetMapping(path ="/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).get();
    }
    @GetMapping(path="/clients")
    public List<Client> allClients(){
        return clientRepository.findAll();
    }
    @GetMapping(path="/clients/{code}")
    public Client getClientByCode(@PathVariable String code){
        return clientRepository.findByCode(code);
    }
    @GetMapping("/clientsByProgramId")
    public List<Client> getClientsByProgramId(@RequestParam String programId){
        return clientRepository.findByProgramId(programId);
    }
    @PutMapping("/payments/{id}") //HTTP PUT requests is to modify a ressource
    public Payment updatePaymentStatus(@RequestParam PaymentStatus status, @PathVariable Long id){
        Payment payment = paymentRepository.findById(id).get();
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }

}
