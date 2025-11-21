package com.example.demo.Repository;
import com.example.demo.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom method to find a user by username
     
     Optional<User> findByUsername(String username);
       

    // Optional: Add more custom queries if needed, e.g.,
    // @Query("SELECT u FROM User u WHERE u.email = :email")
    // User findByEmail(@Param("email") String email);
}
