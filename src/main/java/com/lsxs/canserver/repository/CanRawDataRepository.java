package com.lsxs.canserver.repository;

import com.lsxs.canserver.entity.CanRawData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanRawDataRepository extends JpaRepository<CanRawData, String> {

}
