package com.zoraw.cinema.model.service.impl;

import com.zoraw.cinema.model.domain.TicketType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
class TicketPriceCalculationServiceImpl implements TicketPriceCalculationService {

    private final TicketPricesService ticketPricesService;
    private final BigDecimal percent = new BigDecimal("100");

    @Value("${ticket.voucherDiscountInPercent}")
    private BigDecimal voucherDiscountInPercent;

    @Override
    public BigDecimal calculateTotalAmount(Map<TicketType, Integer> tickets, LocalDateTime screeningTime, String voucher) {
        Map<TicketType, BigDecimal> prices = ticketPricesService.getPrices(screeningTime);
        BigDecimal totalAmount = calculateTotalAmount(tickets, prices);
        if (isVoucherValid(voucher)) {
            totalAmount = getTotalAmountWithDiscount(totalAmount);
        }
        return totalAmount;
    }

    private BigDecimal calculateTotalAmount(Map<TicketType, Integer> tickets, Map<TicketType, BigDecimal> prices) {
        return tickets.entrySet()
                .stream()
                .map(entry -> prices.get(entry.getKey()).multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal getTotalAmountWithDiscount(BigDecimal totalAmount) {
        return totalAmount.multiply(voucherDiscountInPercent)
                .divide(percent, RoundingMode.HALF_UP);
    }

    private boolean isVoucherValid(String voucher) {
        return Optional.ofNullable(voucher)
                .map(v -> v.equals("valid"))
                .orElse(false);
    }
}
