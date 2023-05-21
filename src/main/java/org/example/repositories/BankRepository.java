package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.models.Bank;

import java.util.List;
import java.util.Optional;

public class BankRepository {

    protected  EntityManager entityManager;

    public BankRepository(EntityManager entityManager ){
        this.entityManager= entityManager;
    }

    public void UpdateBank(Bank Bank)
    {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(Bank);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            entityManager.getTransaction().rollback();
        }
    }

    public List<Bank> GetAllBanks()
    {
        var jpql = "SELECT b FROM Bank b";
        var query = entityManager.createQuery(jpql, Bank.class);
        return query.getResultList();
    }

    public Optional<Bank> GetBankById(int bank_id) {
        var jpql = "SELECT b FROM Bank b WHERE bank_id=:bank_id";
        var query = entityManager.createQuery(jpql, Bank.class);
        query.setParameter("bank_id", bank_id);
        var bank = query.getSingleResult();
        return Optional.ofNullable(bank);
    }

    public void InsertBank(Bank bank) {
        try {
            if(bank == null)
            entityManager.getTransaction().begin();
            entityManager.persist(bank);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
        public void deleteBankById (Optional<Bank> bank_id){
            Bank bank = entityManager.find(Bank.class, bank_id);
            entityManager.getTransaction().begin();
            try {
                if (bank != null) {
                    entityManager.remove(bank);
                }
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                throw e;
            }
    }

}
