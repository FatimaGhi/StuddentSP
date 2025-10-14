package com.universite.student.repositories;

import com.universite.student.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {

    UserAccount findByUserName(String userName);
}
