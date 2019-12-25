package com.example.payment.service;

import com.example.payment.dao.PaymentDao;
import com.example.payment.dto.PaymentDto;
import com.example.payment.dto.UserDetailsDto;
import com.example.payment.model.Payment;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {
    private final PaymentDao paymentDao;
    @Autowired
    public PaymentService(@Qualifier("postgres") PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }
    public PaymentDto initPayment(UUID orderId, UserDetailsDto userDetails) {
        changeOrderStatus(orderId,userDetails);
        return paymentDao.initPayment(orderId, userDetails);
    }


    public PaymentDto getPaymentStatus(UUID orderId) {
        return paymentDao.getPaymentStatus(orderId);
    }

    private void changeOrderStatus(UUID orderId, UserDetailsDto userDetailsDto) {
        String orderStatus = "";
        if (userDetailsDto.getCardInfo().equals("AUTHORIZED")) {
            orderStatus = "PAID";
        } else if (userDetailsDto.getCardInfo().equals("UNAUTHORIZED")) {
            orderStatus = "FAILED";
        }

        if (!orderStatus.equals("")) {
            URL url = null;
            try {
                url = new URL(String.format("http://localhost:8011/orders/%s/status/%s", orderId, orderStatus));
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("PUT");
                con.setDoOutput(true);
                con.setDoInput(true);
                int responseCode = con.getResponseCode();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpURLConnection con = null;
        }
    }
}
