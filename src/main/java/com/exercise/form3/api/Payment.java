package com.exercise.form3.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * PaymentAttribute domain object representation
 */

public class Payment {

    @NotNull
    @JsonProperty("type")
    private String type;
    @NotNull
    @JsonProperty("id")
    private String id;
    @JsonProperty("version")
    private int version;
    @NotNull
    @JsonProperty("organisation_id")
    private String organisationId;
    @NotNull
    @JsonProperty("attributes")
    private PaymentAttribute attributes;

    public Payment() {
        // Jackson deserialization
    }

    @JsonCreator
    public Payment(@JsonProperty("type") String type,
                   @JsonProperty("id") String id,
                   @JsonProperty("version") int version,
                   @JsonProperty("organisation_id") String organisationId,
                   @JsonProperty("attributes") PaymentAttribute attributes) {
        this.type = type;
        this.id = id;
        this.version = version;
        this.organisationId = organisationId;
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getOrganisationId() {
        return organisationId;
    }

    public PaymentAttribute getAttributes() {
        return attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;

        Payment that = (Payment) o;

        if (!getType().equals(that.getType())) return false;
        if (!getId().equals(that.getId())) return false;
        if (getVersion() != that.getVersion()) return false;
        if (!getOrganisationId().equals(that.getOrganisationId())) return false;
        if (!getAttributes().equals(that.getAttributes())) return false;

        return true;
    }

    static public class PaymentAttribute {

        @NotNull
        @JsonProperty("amount")
        private String amount;
        @NotNull
        @JsonProperty("beneficiary_party")
        private BeneficiaryParty beneficiaryParty;
        @NotNull
        @JsonProperty("charges_information")
        private ChargesInformation chargesInformation;
        @NotNull
        @JsonProperty("currency")
        private String currency;
        @NotNull
        @JsonProperty("debtor_party")
        private DebtorParty debtorParty;
        @NotNull
        @JsonProperty("end_to_end_reference")
        private String endToEndReference;
        @NotNull
        @JsonProperty("fx")
        private Fx fx;
        @NotNull
        @JsonProperty("numeric_reference")
        private String numericReference;
        @NotNull
        @JsonProperty("payment_id")
        private String paymentId;
        @NotNull
        @JsonProperty("payment_purpose")
        private String paymentPurpose;
        @NotNull
        @JsonProperty("payment_scheme")
        private String paymentScheme;
        @NotNull
        @JsonProperty("payment_type")
        private String paymentType;
        @NotNull
        @JsonProperty("processing_date")
        private String processingDate;
        @NotNull
        @JsonProperty("reference")
        private String reference;
        @NotNull
        @JsonProperty("scheme_payment_sub_type")
        private String schemePaymentSubType;
        @NotNull
        @JsonProperty("scheme_payment_type")
        private String schemePaymentType;
        @NotNull
        @JsonProperty("sponsor_party")
        private SponsorParty sponsorParty;

        @JsonCreator
        public PaymentAttribute(@JsonProperty("amount") String amount,
                                @JsonProperty("beneficiary_party") BeneficiaryParty beneficiaryParty,
                                @JsonProperty("charges_information") ChargesInformation chargesInformation,
                                @JsonProperty("currency") String currency,
                                @JsonProperty("debtor_party") DebtorParty debtorParty,
                                @JsonProperty("end_to_end_reference") String endToEndReference,
                                @JsonProperty("fx") Fx fx,
                                @JsonProperty("numeric_reference") String numericReference,
                                @JsonProperty("payment_id") String paymentId,
                                @JsonProperty("payment_purpose") String paymentPurpose,
                                @JsonProperty("payment_scheme") String paymentScheme,
                                @JsonProperty("payment_type") String paymentType,
                                @JsonProperty("processing_date") String processingDate,
                                @JsonProperty("reference") String reference,
                                @JsonProperty("scheme_payment_sub_type") String schemePaymentSubType,
                                @JsonProperty("scheme_payment_type") String schemePaymentType,
                                @JsonProperty("sponsor_party") SponsorParty sponsorParty) {
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

        public String getAmount() {
            return amount;
        }

        public BeneficiaryParty getBeneficiaryParty() {
            return beneficiaryParty;
        }

        public ChargesInformation getChargesInformation() {
            return chargesInformation;
        }

        public String getCurrency() {
            return currency;
        }

        public DebtorParty getDebtorParty() {
            return debtorParty;
        }

        public String getEndToEndReference() {
            return endToEndReference;
        }

        public Fx getFx() {
            return fx;
        }

        public String getNumericReference() {
            return numericReference;
        }

        public String getPaymentId() {
            return paymentId;
        }

        public String getPaymentPurpose() {
            return paymentPurpose;
        }

        public String getPaymentScheme() {
            return paymentScheme;
        }

        public String getPaymentType() {
            return paymentType;
        }

        public String getProcessingDate() {
            return processingDate;
        }

        public String getReference() {
            return reference;
        }

        public String getSchemePaymentSubType() {
            return schemePaymentSubType;
        }

        public String getSchemePaymentType() {
            return schemePaymentType;
        }

        public SponsorParty getSponsorParty() {
            return sponsorParty;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PaymentAttribute)) return false;

            PaymentAttribute that = (PaymentAttribute) o;

            if (!getAmount().equals(that.getAmount())) return false;
            if (!getBeneficiaryParty().equals(that.getBeneficiaryParty())) return false;
            if (!getChargesInformation().equals(that.getChargesInformation())) return false;
            if (!getCurrency().equals(that.getCurrency())) return false;
            if (!getDebtorParty().equals(that.getDebtorParty())) return false;
            if (!getEndToEndReference().equals(that.getEndToEndReference())) return false;
            if (!getFx().equals(that.getFx())) return false;
            if (!getNumericReference().equals(that.getNumericReference())) return false;
            if (!getPaymentId().equals(that.getPaymentId())) return false;
            if (!getPaymentPurpose().equals(that.getPaymentPurpose())) return false;
            if (!getPaymentScheme().equals(that.getPaymentScheme())) return false;
            if (!getPaymentType().equals(that.getPaymentType())) return false;
            if (!getProcessingDate().equals(that.getProcessingDate())) return false;
            if (!getReference().equals(that.getReference())) return false;
            if (!getSchemePaymentSubType().equals(that.getSchemePaymentSubType())) return false;
            if (!getSchemePaymentType().equals(that.getSchemePaymentType())) return false;
            if (!getSponsorParty().equals(that.getSponsorParty())) return false;

            return true;
        }

        public static class BeneficiaryParty {

            @NotNull
            @JsonProperty("account_name")
            private String accountName;
            @NotNull
            @JsonProperty("account_number")
            private String accountNumber;
            @NotNull
            @JsonProperty("account_number_code")
            private String accountNumberCode;
            @NotNull
            @JsonProperty("account_type")
            private int accountType;
            @NotNull
            @JsonProperty("address")
            private String address;
            @NotNull
            @JsonProperty("bank_id")
            private String bankId;
            @NotNull
            @JsonProperty("bank_id_code")
            private String bankIdCode;
            @NotNull
            @JsonProperty("name")
            private String name;

            @JsonCreator
            public BeneficiaryParty(@JsonProperty("account_name") String accountName,
                                    @JsonProperty("account_number") String accountNumber,
                                    @JsonProperty("account_number_code") String accountNumberCode,
                                    @JsonProperty("account_type") int accountType,
                                    @JsonProperty("address") String address,
                                    @JsonProperty("bank_id") String bankId,
                                    @JsonProperty("bank_id_code") String bankIdCode,
                                    @JsonProperty("name") String name) {
                this.accountName = accountName;
                this.accountNumber = accountNumber;
                this.accountNumberCode = accountNumberCode;
                this.accountType = accountType;
                this.address = address;
                this.bankId = bankId;
                this.bankIdCode = bankIdCode;
                this.name = name;
            }

            public String getAccountName() {
                return accountName;
            }

            public String getAccountNumber() {
                return accountNumber;
            }

            public String getAccountNumberCode() {
                return accountNumberCode;
            }

            public int getAccountType() {
                return accountType;
            }

            public String getAddress() {
                return address;
            }

            public String getBankId() {
                return bankId;
            }

            public String getBankIdCode() {
                return bankIdCode;
            }

            public String getName() {
                return name;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof BeneficiaryParty)) return false;

                BeneficiaryParty that = (BeneficiaryParty) o;

                if (!getAccountName().equals(that.getAccountName())) return false;
                if (!getAccountNumber().equals(that.getAccountNumber())) return false;
                if (!getAccountNumberCode().equals(that.getAccountNumberCode())) return false;
                if (getAccountType() != that.getAccountType()) return false;
                if (!getAddress().equals(that.getAddress())) return false;
                if (!getBankId().equals(that.getBankId())) return false;
                if (!getBankIdCode().equals(that.getBankIdCode())) return false;
                if (!getName().equals(that.getName())) return false;

                return true;
            }
        }

        public static class ChargesInformation {

            @NotNull
            @JsonProperty("bearer_code")
            private String bearerCode;
            @NotNull
            @JsonProperty("sender_charges")
            private List<SenderCharges> senderCharges;
            @NotNull
            @JsonProperty("receiver_charges_amount")
            private String receiverChargesAmount;
            @NotNull
            @JsonProperty("receiver_charges_currency")
            private String receiverChargesCurrency;

            @JsonCreator
            public ChargesInformation(@JsonProperty("bearer_code") String bearerCode,
                                      @JsonProperty("sender_charges") List<SenderCharges> senderCharges,
                                      @JsonProperty("receiver_charges_amount") String receiverChargesAmount,
                                      @JsonProperty("receiver_charges_currency") String receiverChargesCurrency) {
                this.bearerCode = bearerCode;
                this.senderCharges = senderCharges;
                this.receiverChargesAmount = receiverChargesAmount;
                this.receiverChargesCurrency = receiverChargesCurrency;
            }

            public String getBearerCode() {
                return bearerCode;
            }

            public List<SenderCharges> getSenderCharges() {
                return senderCharges;
            }

            public String getReceiverChargesAmount() {
                return receiverChargesAmount;
            }

            public String getReceiverChargesCurrency() {
                return receiverChargesCurrency;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof ChargesInformation)) return false;

                ChargesInformation that = (ChargesInformation) o;

                if (!getBearerCode().equals(that.getBearerCode())) return false;
                if (!getSenderCharges().equals(that.getSenderCharges())) return false;
                if (!getReceiverChargesAmount().equals(that.getReceiverChargesAmount())) return false;
                if (!getReceiverChargesCurrency().equals(that.getReceiverChargesCurrency())) return false;

                return true;
            }
        }
    }

    public static class SenderCharges {

        @NotNull
        @JsonProperty("amount")
        private String amount;
        @NotNull
        @JsonProperty("currency")
        private String currency;

        @JsonCreator
        public SenderCharges(@JsonProperty("amount") String amount,
                             @JsonProperty("currency") String currency) {
            this.amount = amount;
            this.currency = currency;
        }

        public String getAmount() {
            return amount;
        }

        public String getCurrency() {
            return currency;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SenderCharges)) return false;

            SenderCharges that = (SenderCharges) o;

            if (!getAmount().equals(that.getAmount())) return false;
            if (!getCurrency().equals(that.getCurrency())) return false;

            return true;
        }
    }

    public static class DebtorParty {

        @NotNull
        @JsonProperty("account_name")
        private String accountName;
        @NotNull
        @JsonProperty("account_number")
        private String accountNumber;
        @NotNull
        @JsonProperty("account_number_code")
        private String accountNumberCode;
        @NotNull
        @JsonProperty("address")
        private String address;
        @NotNull
        @JsonProperty("bank_id")
        private String bankId;
        @NotNull
        @JsonProperty("bank_id_code")
        private String bankIdCode;
        @NotNull
        @JsonProperty("name")
        private String name;

        @JsonCreator
        public DebtorParty(@JsonProperty("account_name") String accountName,
                           @JsonProperty("account_number") String accountNumber,
                           @JsonProperty("account_number_code") String accountNumberCode,
                           @JsonProperty("address") String address,
                           @JsonProperty("bank_id") String bankId,
                           @JsonProperty("bank_id_code") String bankIdCode,
                           @JsonProperty("name") String name) {
            this.accountName = accountName;
            this.accountNumber = accountNumber;
            this.accountNumberCode = accountNumberCode;
            this.address = address;
            this.bankId = bankId;
            this.bankIdCode = bankIdCode;
            this.name = name;
        }

        public String getAccountName() {
            return accountName;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountNumberCode() {
            return accountNumberCode;
        }

        public String getAddress() {
            return address;
        }

        public String getBankId() {
            return bankId;
        }

        public String getBankIdCode() {
            return bankIdCode;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DebtorParty)) return false;

            DebtorParty that = (DebtorParty) o;

            if (!getAccountName().equals(that.getAccountName())) return false;
            if (!getAccountNumber().equals(that.getAccountNumber())) return false;
            if (!getAccountNumberCode().equals(that.getAccountNumberCode())) return false;
            if (!getAddress().equals(that.getAddress())) return false;
            if (!getBankId().equals(that.getBankId())) return false;
            if (!getBankIdCode().equals(that.getBankIdCode())) return false;
            if (!getName().equals(that.getName())) return false;

            return true;
        }
    }

    public static class Fx {

        @NotNull
        @JsonProperty("contract_reference")
        private String contractReference;
        @NotNull
        @JsonProperty("exchange_rate")
        private String exchangeRate;
        @NotNull
        @JsonProperty("original_amount")
        private String originalAmount;
        @NotNull
        @JsonProperty("original_currency")
        private String originalCurrency;

        @JsonCreator
        public Fx(@JsonProperty("contract_reference") String contractReference,
                  @JsonProperty("exchange_rate") String exchangeRate,
                  @JsonProperty("original_amount") String originalAmount,
                  @JsonProperty("original_currency") String originalCurrency) {
            this.contractReference = contractReference;
            this.exchangeRate = exchangeRate;
            this.originalAmount = originalAmount;
            this.originalCurrency = originalCurrency;
        }

        public String getContractReference() {
            return contractReference;
        }

        public String getExchangeRate() {
            return exchangeRate;
        }

        public String getOriginalAmount() {
            return originalAmount;
        }

        public String getOriginalCurrency() {
            return originalCurrency;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Fx)) return false;

            Fx that = (Fx) o;

            if (!getContractReference().equals(that.getContractReference())) return false;
            if (!getExchangeRate().equals(that.getExchangeRate())) return false;
            if (!getOriginalAmount().equals(that.getOriginalAmount())) return false;
            if (!getOriginalCurrency().equals(that.getOriginalCurrency())) return false;

            return true;
        }
    }

    public static class SponsorParty {

        @NotNull
        @JsonProperty("account_number")
        private String accountNumber;
        @NotNull
        @JsonProperty("bank_id")
        private String bankId;
        @NotNull
        @JsonProperty("bank_id_code")
        private String bankIdCode;

        @JsonCreator
        public SponsorParty(@JsonProperty("account_number") String accountNumber,
                            @JsonProperty("bank_id") String bankId,
                            @JsonProperty("bank_id_code") String bankIdCode) {
            this.accountNumber = accountNumber;
            this.bankId = bankId;
            this.bankIdCode = bankIdCode;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getBankId() {
            return bankId;
        }

        public String getBankIdCode() {
            return bankIdCode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SponsorParty)) return false;

            SponsorParty that = (SponsorParty) o;

            if (!getAccountNumber().equals(that.getAccountNumber())) return false;
            if (!getBankId().equals(that.getBankId())) return false;
            if (!getBankIdCode().equals(that.getBankIdCode())) return false;

            return true;
        }
    }
}
