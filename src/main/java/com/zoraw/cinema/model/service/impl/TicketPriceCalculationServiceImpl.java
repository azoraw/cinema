package com.zoraw.cinema.model.service.impl;

import com.zoraw.cinema.model.domain.TicketType;
import com.zoraw.cinema.model.service.TicketPriceCalculationService;
import com.zoraw.cinema.model.service.TicketPricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class TicketPriceCalculationServiceImpl implements TicketPriceCalculationService {

    private final TicketPricesService ticketPricesService;
    private final BigDecimal percent = new BigDecimal("100");

    @Value("${ticket.voucherDiscountInPercent}")
    private BigDecimal voucherDiscountInPercent;

    @Override
    public BigDecimal calculateTotalAmount(Map<TicketType, Integer> tickets, LocalDateTime screeningTime, String voucher) {
        Map<TicketType, BigDecimal> prices = ticketPricesService.getPrices(screeningTime);
        BigDecimal totalAmount = tickets.entrySet()
                .stream()
                .map(entry -> prices.get(entry.getKey()).multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (isVoucherValid(voucher)) {
            totalAmount = totalAmount.multiply(voucherDiscountInPercent)
                    .divide(percent, RoundingMode.HALF_UP);
        }
        return totalAmount;
    }

    private boolean isVoucherValid(String voucher) {
        return voucher.equals("valid");
    }
}
