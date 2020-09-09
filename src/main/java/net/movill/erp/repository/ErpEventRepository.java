package net.movill.erp.repository;

import net.movill.erp.entity.ErpEventEntity;
import net.movill.erp.enums.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ErpEventRepository extends JpaRepository<ErpEventEntity, Long>, JpaSpecificationExecutor<ErpEventEntity> {

    boolean existsBySiteIdxAndTypeAndDongAndHoAndEvent(Long siteIdx, String type, String dong, String ho, EventType event);

}