package com.exercise.form3.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Payment domain object representation
 */

public class Payment {

    private String amount;
    private BeneficiaryParty beneficiaryParty;
    private ChargesInformation chargesInformation;
    private String currency;
    private DebtorParty debtorParty;
    private String endToEndReference;
    private Fx fx;
    private String numericReference;
    private String paymentId;
    private String paymentPurpose;
    private String paymentScheme;
    private String paymentType;
    private String processingDate;
    private String reference;
    private String schemePaymentSubType;
    private String schemePaymentType;
    private SponsorParty sponsorParty;

    @JsonCreator
    public Payment(String amount, BeneficiaryParty beneficiaryParty, ChargesInformation chargesInformation, String currency, DebtorParty debtorParty, String endToEndReference, Fx fx, String numericReference, String paymentId, String paymentPurpose, String paymentScheme, String paymentType, String processingDate, String reference, String schemePaymentSubType, String schemePaymentType, SponsorParty sponsorParty) {
        this.amount = amount;
        this.beneficiaryParty = beneficiaryParty;
        this.chargesInformation = chargesInformation;
        this.currency = currency;
        this.debtorParty = debtorParty;
        this.endToEndReference = endToEndReference;
        this.fx = fx;
        this.numericReference = numericReference;
        this.paymentId = paymentId;
        this.paymentPurpose = paymentPurpose;
        this.paymentScheme = paymentScheme;
        this.paymentType = paymentType;
        this.processingDate = processingDate;
        this.reference = reference;
        this.schemePaymentSubType = schemePaymentSubType;
        this.schemePaymentType = schemePaymentType;
        this.sponsorParty = sponsorParty;
    }

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("beneficiary_party")
    public BeneficiaryParty getBeneficiaryParty() {
        return beneficiaryParty;
    }

    @JsonProperty("charges_information")
    public ChargesInformation getChargesInformation() {
        return chargesInformation;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("debtor_party")
    public DebtorParty getDebtorParty() {
        return debtorParty;
    }

    @JsonProperty("end_to_end_reference")
    public String getEndToEndReference() {
        return endToEndReference;
    }

    @JsonProperty("fx")
    public Fx getFx() {
        return fx;
    }

    @JsonProperty("numeric_reference")
    public String getNumericReference() {
        return numericReference;
    }

    @JsonProperty("payment_id")
    public String getPaymentId() {
        return paymentId;
    }

    @JsonProperty("payment_purpose")
    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    @JsonProperty("payment_scheme")
    public String getPaymentScheme() {
        return paymentScheme;
    }

    @JsonProperty("payment_type")
    public String getPaymentType() {
        return paymentType;
    }

    @JsonProperty("processing_date")
    public String getProcessingDate() {
        return processingDate;
    }

    @JsonProperty("reference")
    public String getReference() {
        return reference;
    }

    @JsonProperty("scheme_payment_sub_type")
    public String getSchemePaymentSubType() {
        return schemePaymentSubType;
    }

    @JsonProperty("scheme_payment_type")
    public String getSchemePaymentType() {
        return schemePaymentType;
    }

    @JsonProperty("sponsor_party")
    public SponsorParty getSponsorParty() {
        return sponsorParty;
    }

    private class BeneficiaryParty {

        private String accountName;
        private String accountNumber;
        private String accountNumberCode;
        private int accountType;
        private String address;
        private String bankId;
        private String bankIdCode;
        private String name;

        @JsonCreator
        public BeneficiaryParty(String accountName, String accountNumber, String accountNumberCode, int accountType, String address, String bankId, String bankIdCode, String name) {
            this.accountName = accountName;
            this.accountNumber = accountNumber;
            this.accountNumberCode = accountNumberCode;
            this.accountType = accountType;
            this.address = address;
            this.bankId = bankId;
            this.bankIdCode = bankIdCode;
            this.name = name;
        }

        @JsonProperty("account_name")
        public String getAccountName() {
            return accountName;
        }

        @JsonProperty("account_number")
        public String getAccountNumber() {
            return accountNumber;
        }

        @JsonProperty("account_number_code")
        public String getAccountNumberCode() {
            return accountNumberCode;
        }

        @JsonProperty("account_type")
        public int getAccountType() {
            return accountType;
        }

        @JsonProperty("address")
        public String getAddress() {
            return address;
        }

        @JsonProperty("bank_id")
        public String getBankId() {
            return bankId;
        }

        @JsonProperty("bank_id_code")
        public String getBankIdCode() {
            return bankIdCode;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }
    }

    private class ChargesInformation {

        private String bearerCode;
        private List<SenderCharges> senderCharges;
        private String receiverChargesAmount;
        private String receiverChargesCurrency;

        @JsonCreator
        public ChargesInformation(String bearerCode, List<SenderCharges> senderCharges, String receiverChargesAmount, String receiverChargesCurrency) {
            this.bearerCode = bearerCode;
            this.senderCharges = senderCharges;
            this.receiverChargesAmount = receiverChargesAmount;
            this.receiverChargesCurrency = receiverChargesCurrency;
        }

        @JsonProperty("bearer_code")
        public String getBearerCode() {
            return bearerCode;
        }

        @JsonProperty("sender_charges")
        public List<SenderCharges> getSenderCharges() {
            return senderCharges;
        }

        @JsonProperty("receiver_charges_amount")
        public String getReceiverChargesAmount() {
            return receiverChargesAmount;
        }

        @JsonProperty("receiver_charges_currency")
        public String getReceiverChargesCurrency() {
            return receiverChargesCurrency;
        }
    }

    private class SenderCharges {

        private String amount;
        private String currency;

        @JsonCreator
        public SenderCharges(String amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }

        @JsonProperty("amount")
        public String getAmount() {
            return amount;
        }

        @JsonProperty("currency")
        public String getCurrency() {
            return currency;
        }
    }

    private class DebtorParty {

        private String accountName;
        private String accountNumber;
        private String accountNumberCode;
        private String address;
        private String bankId;
        private String bankIdCode;
        private String name;

        @JsonCreator
        public DebtorParty(String accountName, String accountNumber, String accountNumberCode, String address, String bankId, String bankIdCode, String name) {
            this.accountName = accountName;
            this.accountNumber = accountNumber;
            this.accountNumberCode = accountNumberCode;
            this.address = address;
            this.bankId = bankId;
            this.bankIdCode = bankIdCode;
            this.name = name;
        }

        @JsonProperty("account_name")
        public String getAccountName() {
            return accountName;
        }

        @JsonProperty("account_number")
        public String getAccountNumber() {
            return accountNumber;
        }

        @JsonProperty("account_number_code")
        public String getAccountNumberCode() {
            return accountNumberCode;
        }

        @JsonProperty("address")
        public String getAddress() {
            return address;
        }

        @JsonProperty("bank_id")
        public String getBankId() {
            return bankId;
        }

        @JsonProperty("bank_id_code")
        public String getBankIdCode() {
            return bankIdCode;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }
    }

    private class Fx {

        private String contractReference;
        private String exchangeRate;
        private String originalAmount;
        private String originalCurrency;

        @JsonCreator
        public Fx(String contractReference, String exchangeRate, String originalAmount, String originalCurrency) {
            this.contractReference = contractReference;
            this.exchangeRate = exchangeRate;
            this.originalAmount = originalAmount;
            this.originalCurrency = originalCurrency;
        }

        @JsonProperty("contract_reference")
        public String getContractReference() {
            return contractReference;
        }

        @JsonProperty("exchange_rate")
        public String getExchangeRate() {
            return exchangeRate;
        }

        @JsonProperty("original_amount")
        public String getOriginalAmount() {
            return originalAmount;
        }

        @JsonProperty("original_currency")
        public String getOriginalCurrency() {
            return originalCurrency;
        }
    }

    private class SponsorParty {

        private String accountNumber;
        private String bankId;
        private String bankIdCode;

        @JsonCreator
        public SponsorParty(String accountNumber, String bankId, String bankIdCode) {
            this.accountNumber = accountNumber;
            this.bankId = bankId;
            this.bankIdCode = bankIdCode;
        }

        @JsonProperty("account_number")
        public String getAccountNumber() {
            return accountNumber;
        }

        @JsonProperty("bank_id")
        public String getBankId() {
            return bankId;
        }

        @JsonProperty("bank_id_code")
        public String getBankIdCode() {
            return bankIdCode;
        }
    }
}
