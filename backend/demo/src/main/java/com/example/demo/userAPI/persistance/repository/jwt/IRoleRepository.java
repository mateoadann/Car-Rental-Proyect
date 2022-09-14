package com.example.demo.userAPI.persistance.repository.jwt;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.userAPI.persistance.entities.jwt.RoleEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
}
