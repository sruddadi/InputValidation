package com.assignment.phonebook.repository;

import com.assignment.phonebook.entity.Phonebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhonebookRepository extends JpaRepository<Phonebook, Integer> {

    public boolean existsByPhoneNumber(String phoneNumber);

    public boolean existsByName(String name);

    public List<Phonebook> findByPhoneNumber(String phoneNumber);

    public List<Phonebook> findByName(String name);

    @Query("select max(p.id) from Phonebook p")
    public String findMaxId();
}
