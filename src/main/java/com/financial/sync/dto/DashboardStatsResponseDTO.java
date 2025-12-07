package com.financial.sync.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardStatsResponseDTO {
    // Stats
    private Long totalInvoices;
    private Long totalAccounts;
    private Long totalTransactions;
    private BigDecimal totalInvoiceAmount;
    private BigDecimal totalOutstandingAmount;
    private Boolean xeroConnected;
    private String username;
    
    // Data Lists
    private List<XeroInvoiceDTO> invoices;
    private List<XeroAccountDTO> accounts;
    private List<XeroTransactionDTO> transactions;
}