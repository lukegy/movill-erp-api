package net.movill.erp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QErpResidentEntity is a Querydsl query type for ErpResidentEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QErpResidentEntity extends EntityPathBase<ErpResidentEntity> {

    private static final long serialVersionUID = -1096790594L;

    public static final QErpResidentEntity erpResidentEntity = new QErpResidentEntity("erpResidentEntity");

    public final NumberPath<Long> aptIdx = createNumber("aptIdx", Long.class);

    public final DateTimePath<java.util.Date> birthday = createDateTime("birthday", java.util.Date.class);

    public final StringPath contact = createString("contact");

    public final DateTimePath<java.time.LocalDateTime> cretime = createDateTime("cretime", java.time.LocalDateTime.class);

    public final StringPath dong = createString("dong");

    public final StringPath ho = createString("ho");

    public final StringPath houseLiveType = createString("houseLiveType");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final StringPath relations = createString("relations");

    public QErpResidentEntity(String variable) {
        super(ErpResidentEntity.class, forVariable(variable));
    }

    public QErpResidentEntity(Path<? extends ErpResidentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QErpResidentEntity(PathMetadata metadata) {
        super(ErpResidentEntity.class, metadata);
    }

}

