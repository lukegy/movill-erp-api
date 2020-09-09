package net.movill.erp.repository;

import net.movill.erp.entity.ErpResidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ErpResidentRepository extends JpaRepository<ErpResidentEntity, Integer>, JpaSpecificationExecutor<ErpResidentEntity> {

    @Transactional
    int deleteByAptIdxAndDongAndHo(long aptIdx, String dong, String ho);

}