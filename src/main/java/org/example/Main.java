package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.models.Bank;
import org.example.models.Customer;
import org.example.models.Teller;
import org.example.models.account.Account;
import org.example.repositories.BankRepository;
import org.example.repositories.CustomerRepository;
import org.example.valueobjects.Location;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        var bankRepository = new BankRepository(entityManager);

        var customerRepository = new CustomerRepository(entityManager);

        var bank = bankRepository.GetBankById(1);
        bankRepository.deleteBankById(bank);

        var newBank = new Bank();
        bankRepository.InsertBank(newBank);

        newBank.setName("Itau");
        bankRepository.UpdateBank(newBank);

        var customer = customerRepository.GetCustomerById(1);
        customerRepository.deleteCustomerById(customer);

        var newCustomer = new Customer();
        customerRepository.InsertCustomer(newCustomer);

        newCustomer.setName("Maria");
        customerRepository.UpdateCustomer(newCustomer);

        entityManager.close();
        entityManagerFactory.close();
    }
}