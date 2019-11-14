package com.example.payment.dao;

import com.example.payment.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("postgres")
public class PaymentDaoSarvice implements PaymentDao{
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public PaymentDaoSarvice (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public  int addPayment(UUID id, Payment payment){
        jdbcTemplate.update(
                "INSERT INTO payment ( paymentId,orderId, status,username, cardinfo) VALUES (?, ?, ?, ?, ?)",
                id,   payment.getOrderId(),payment.getStatus(),payment.getUsername(),payment.getCardInfo()
        );
        return 0;
    }

    public   List<Payment> getAllPayments(){
        final String sql ="SELECT paymentId,orderId, status,username, cardinfo FROM payment";
        return jdbcTemplate.query(sql,(resultSet ,i)-> {
            UUID paymentId =UUID.fromString(resultSet.getString("paymentId"));
            UUID orderId =UUID.fromString(resultSet.getString("orderId"));
            Integer status = resultSet.getInt("status");
            String username = resultSet.getString("username");
            Integer cardInfo =  resultSet.getInt("cardInfo");
            return new Payment (paymentId,orderId, status,username, cardInfo);
        });
    }
}
