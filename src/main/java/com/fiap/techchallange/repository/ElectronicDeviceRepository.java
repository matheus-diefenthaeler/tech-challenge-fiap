package com.fiap.techchallange.repository;

import com.fiap.techchallange.entity.ElectronicDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicDeviceRepository extends JpaRepository<ElectronicDevice, Long> {
}
