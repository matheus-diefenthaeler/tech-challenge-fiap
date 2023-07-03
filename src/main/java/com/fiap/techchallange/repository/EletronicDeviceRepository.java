package com.fiap.techchallange.repository;

import com.fiap.techchallange.entity.EletroniceDevice;
import com.fiap.techchallange.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EletronicDeviceRepository extends JpaRepository<EletroniceDevice, Long> {
}
