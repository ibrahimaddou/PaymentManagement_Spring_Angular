package com.project.paymentManagement;

import com.project.paymentManagement.Repository.PaymentRepository;
import com.project.paymentManagement.Repository.UserRepository;
import com.project.paymentManagement.entities.Payment;
import com.project.paymentManagement.entities.PaymentType;
import com.project.paymentManagement.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class PaymentManagementApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(PaymentManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, PaymentRepository paymentRepository){
		return args -> {
			userRepository.save(User.builder().id(UUID.randomUUID().toString())
					.firstName("coco").code("123").programId("CAI")
					.build());
			userRepository.save(User.builder().id(UUID.randomUUID().toString())
					.firstName("soso").code("124").programId("TOO")
					.build());
			PaymentType[] paymentTypes = PaymentType.values();//une liste des types enum
			Random random =new Random();
			userRepository.findAll().forEach(us->{
				for (int i = 0 ; i<10;i++){
					int j =random.nextInt(paymentTypes.length);
					Payment payment = Payment.builder()
							.amount(100+(int)(Math.random()+2000))
							.type(paymentTypes[j])
							.date(LocalDate.now())
							.user(us)
							.build();
					paymentRepository.save(payment);
				}
			});
		};
	}
}
