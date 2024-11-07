package com.example.repository;

import com.example.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query(
            nativeQuery = true,
            value
                    = "SELECT ea.id,ea.city,ea.state FROM address_tbl ea join employee_tbl e " +
                    "on e.id = ea.id where ea.id=:id")
    Optional<Address> findAddressByEmployeeId(@Param("id") int id);

}
