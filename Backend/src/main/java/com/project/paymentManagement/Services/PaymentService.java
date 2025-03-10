package com.project.paymentManagement.Services;

import com.project.paymentManagement.Repository.ClientRepository;
import com.project.paymentManagement.Repository.PaymentRepository;
import com.project.paymentManagement.entities.Client;
import com.project.paymentManagement.entities.Payment;
import com.project.paymentManagement.entities.PaymentStatus;
import com.project.paymentManagement.entities.PaymentType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
public class PaymentService {
    private ClientRepository clientRepository;
    private PaymentRepository paymentRepository;

    public PaymentService(ClientRepository clientRepository, PaymentRepository paymentRepository){
        this.clientRepository = clientRepository;
        this.paymentRepository = paymentRepository;
    }
    public Payment savePayment( MultipartFile file, LocalDate date, double amount, PaymentType type, String clientCode)throws IOException {
        Path folderPath = Paths.get(System.getProperty("user.home"),"pay-data","payments");
        if(!Files.exists(folderPath)){
            Files.createDirectories(folderPath);
        }
        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get(System.getProperty("user.home"),"pay-data","payments",fileName+".pdf");
        Files.copy(file.getInputStream(),filePath);
        Client client = clientRepository.findByCode(clientCode);
        Payment payment = Payment.builder()
                .date(date).type(type).client(client)
                .amount(amount)
                .file(filePath.toUri().toString())
                .status(PaymentStatus.CREATED)
                .build();
        return paymentRepository.save(payment);
    }
    public Payment updatePaymentStatus( PaymentStatus status,  Long id){
        Payment payment = paymentRepository.findById(id).get();
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }
    public byte[] getPaymentFile( Long paymentId) throws IOException {
        Payment payment = paymentRepository.findById(paymentId).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }
}
