package net.movill.erp.repository;

import net.movill.erp.entity.ErpOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ErpOwnerRepository extends JpaRepository<ErpOwnerEntity, Long>, JpaSpecificationExecutor<ErpOwnerEntity> {

    @Transactional
    int deleteByAptIdxAndDongAndHo(Long aptIdx, String dong, String ho);

}