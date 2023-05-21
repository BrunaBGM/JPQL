package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.models.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager entityManager;

    public CustomerRepository(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    public void UpdateCustomer(Customer Customer)
    {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(Customer);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            entityManager.getTransaction().rollback();
        }
    }


    public List<Customer> GetAllCustomer()
    {
        var jpql = "SELECT c FROM Customer c";
        var query = entityManager.createQuery(jpql, Customer.class);
        return query.getResultList();
    }

    public Optional<Customer> GetCustomerById(int costumer_id) {
        var jpql = "SELECT c FROM Customer c WHERE costumer_id=:costumer_id";
        var query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("costumer_id", costumer_id);
        var customer = query.getSingleResult();
        return Optional.ofNullable(customer);
    }

    public void InsertCustomer(Customer customer) {
        try{
            if(customer == null)
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            entityManager.getTransaction().rollback();
        }
    }
    public void deleteCustomerById(Optional<Customer> customer_id) {
        Customer customer = entityManager.find(Customer.class, customer_id);
        entityManager.getTransaction().begin();
        try {
            if (customer != null) {
                entityManager.remove(customer);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
