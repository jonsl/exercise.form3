package com.exercise.form3.dao;

import com.exercise.form3.api.Payment;
import com.exercise.form3.core.PaymentMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(PaymentMapper.class)
public interface PaymentDAO {

//    @SqlQuery("select * from PAYMENT")
//    List<{Payment> getAll();

    @SqlQuery("select * from PAYMENT where id = :id")
    Payment fetchById(@Bind("id") String id);

    @SqlUpdate("insert into PAYMENT (type, id, version, organisation_id, attributes) values (:type, :id, :version, :organisationId, :attributes)")
    int insert(@BindBean Payment payment, @Bind("attributes") String attributes);

    @SqlUpdate("update PAYMENT set type = :type, id = :id, version = :version, organisation_id = :organisationId, attributes = :attributes where id = :id")
    int update(@BindBean Payment payment, @Bind("attributes") String attributes);

    @SqlUpdate("delete from PAYMENT where id = :id")
    int deleteById(@Bind("id") String id);

//    @SqlUpdate("delete from PAYMENT where id = :id")
//    int fetchOffsetCount(@Bind("id") int id);

}
