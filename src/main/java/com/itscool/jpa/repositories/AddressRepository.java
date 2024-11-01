package com.itscool.jpa.repositories;

import com.itscool.jpa.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
