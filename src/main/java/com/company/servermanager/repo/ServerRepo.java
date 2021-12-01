package com.company.servermanager.repo;

import com.company.servermanager.enums.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Server, Long> {
    Server getByIpAddress(String ipAddress);

    Server getByName(String name);
}
