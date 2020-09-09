package net.movill.erp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMasterHouseEntity is a Querydsl query type for MasterHouseEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMasterHouseEntity extends EntityPathBase<MasterHouseEntity> {

    private static final long serialVersionUID = -831452279L;

    public static final QMasterHouseEntity masterHouseEntity = new QMasterHouseEntity("masterHouseEntity");

    public final net.movill.common.entity.QBaseEntity _super = new net.movill.common.entity.QBaseEntity(this);

    public final NumberPath<Long> aptIdx = createNumber("aptIdx", Long.class);

    public final StringPath codeDong = createString("codeDong");

    public final StringPath codeHo = createString("codeHo");

    public final StringPath distributionArea = createString("distributionArea");

    public final StringPath dong = createString("dong");

    public final StringPath exclusiveArea = createString("exclusiveArea");

    public final StringPath ho = createString("ho");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QMasterHouseEntity(String variable) {
        super(MasterHouseEntity.class, forVariable(variable));
    }

    public QMasterHouseEntity(Path<? extends MasterHouseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMasterHouseEntity(PathMetadata metadata) {
        super(MasterHouseEntity.class, metadata);
    }

}

