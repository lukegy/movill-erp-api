package net.movill.erp.repository;

import net.movill.erp.entity.MasterHouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterHouseRepository extends JpaRepository<MasterHouseEntity, Long>, JpaSpecificationExecutor<MasterHouseEntity> {

    boolean existsByAptIdxAndDongAndHo(Long aptIdx, String dong, String ho);

}