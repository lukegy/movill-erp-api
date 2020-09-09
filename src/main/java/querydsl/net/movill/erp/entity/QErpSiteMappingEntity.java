package net.movill.erp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QErpSiteMappingEntity is a Querydsl query type for ErpSiteMappingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QErpSiteMappingEntity extends EntityPathBase<ErpSiteMappingEntity> {

    private static final long serialVersionUID = -1035015681L;

    public static final QErpSiteMappingEntity erpSiteMappingEntity = new QErpSiteMappingEntity("erpSiteMappingEntity");

    public final NumberPath<Long> aptIdx = createNumber("aptIdx", Long.class);

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final NumberPath<Long> siteIdx = createNumber("siteIdx", Long.class);

    public final StringPath type = createString("type");

    public QErpSiteMappingEntity(String variable) {
        super(ErpSiteMappingEntity.class, forVariable(variable));
    }

    public QErpSiteMappingEntity(Path<? extends ErpSiteMappingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QErpSiteMappingEntity(PathMetadata metadata) {
        super(ErpSiteMappingEntity.class, metadata);
    }

}

