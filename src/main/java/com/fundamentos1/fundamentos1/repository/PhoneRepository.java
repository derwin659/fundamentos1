package com.fundamentos1.fundamentos1.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import com.fundamentos1.fundamentos1.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PhoneRepository extends JpaRepository<Phone,Long> {
}
