package com.example.demo.userAPI.persistance.repository.jwt;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.userAPI.persistance.entities.jwt.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByEmail(String email);
}
