package com.example.payment.dao;

import com.example.payment.dto.PaymentDto;
import com.example.payment.dto.UserDetailsDto;
import com.example.payment.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("postgres")
public class PaymentDaoService implements PaymentDao{

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public PaymentDaoService (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public PaymentDto initPayment(UUID id, UUID orderId, UserDetailsDto userDetails){
        Payment payment = new Payment(
                UUID.randomUUID(),
                orderId,
                userDetails.getCardInfo(),
                userDetails.getName()
        );

      /*  jdbcTemplate.update(
                "INSERT INTO payment ( paymentId,orderId,status,username) VALUES (?,?, ?, ? )",
                  payment.getPaymentId(), payment.getOrderId(),payment.getStatus(),payment.getUsername()
        );*/
        return PaymentDto.fromPayment(payment);
    }




    @Override
    public PaymentDto getPaymentStatus(UUID orderId) {
        String sql ="SELECT * FROM payment WHERE orderId = ?";
        PaymentDto paymentDto = jdbcTemplate.queryForObject(sql, new Object[]{orderId}, (resultSet, i) -> {
            UUID orderId1 =UUID.fromString(resultSet.getString("orderId"));
            String status = resultSet.getString("status");
            return new PaymentDto (orderId1, status);
            });

    return paymentDto;
    }
}
