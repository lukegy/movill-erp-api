package net.movill.erp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QErpEventEntity is a Querydsl query type for ErpEventEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QErpEventEntity extends EntityPathBase<ErpEventEntity> {

    private static final long serialVersionUID = -1454880110L;

    public static final QErpEventEntity erpEventEntity = new QErpEventEntity("erpEventEntity");

    public final NumberPath<Long> aptIdx = createNumber("aptIdx", Long.class);

    public final DateTimePath<java.time.LocalDateTime> cretime = createDateTime("cretime", java.time.LocalDateTime.class);

    public final StringPath dong = createString("dong");

    public final EnumPath<net.movill.erp.enums.EventType> event = createEnum("event", net.movill.erp.enums.EventType.class);

    public final StringPath ho = createString("ho");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final NumberPath<Long> siteIdx = createNumber("siteIdx", Long.class);

    public final StringPath type = createString("type");

    public QErpEventEntity(String variable) {
        super(ErpEventEntity.class, forVariable(variable));
    }

    public QErpEventEntity(Path<? extends ErpEventEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QErpEventEntity(PathMetadata metadata) {
        super(ErpEventEntity.class, metadata);
    }

}

