package net.movill.erp.repository;

import net.movill.erp.entity.ErpCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarErpRepository extends JpaRepository<ErpCarEntity, Long>, JpaSpecificationExecutor<ErpCarEntity> {

}