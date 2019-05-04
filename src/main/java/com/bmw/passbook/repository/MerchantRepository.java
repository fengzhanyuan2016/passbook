package com.bmw.passbook.repository;

import com.bmw.passbook.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MerchantRepository extends JpaRepository<Merchant,Integer> {
}
