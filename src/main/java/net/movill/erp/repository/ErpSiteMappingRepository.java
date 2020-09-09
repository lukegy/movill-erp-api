package net.movill.erp.repository;

import net.movill.erp.entity.ErpSiteMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ErpSiteMappingRepository extends JpaRepository<ErpSiteMappingEntity, Long>, JpaSpecificationExecutor<ErpSiteMappingEntity> {

    ErpSiteMappingEntity findBySiteIdxAndType(Long siteIdx, String type);

}