package com.arizonagames.feature.arizona.bank;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0007\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0007\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0007¢\u0006\u0004\b*\u0010+J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010W\u001a\u00020\u0014HÆ\u0003J\u000f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007HÆ\u0003J\u000f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007HÆ\u0003J\u000f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0007HÆ\u0003J\u000f\u0010^\u001a\b\u0012\u0004\u0012\u00020!0\u0007HÆ\u0003J\u000f\u0010_\u001a\b\u0012\u0004\u0012\u00020!0\u0007HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010$HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010$HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010'HÆ\u0003J\u000f\u0010c\u001a\b\u0012\u0004\u0012\u00020)0\u0007HÆ\u0003J¯\u0002\u0010d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00072\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00072\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00072\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0007HÆ\u0001J\u0014\u0010e\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010h\u001a\u00020!HÖ\u0081\u0004J\n\u0010i\u001a\u00020jHÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u00101R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u00101R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u00101R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0007¢\u0006\b\n\u0000\u001a\u0004\bE\u00101R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0007¢\u0006\b\n\u0000\u001a\u0004\bF\u00101R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0007¢\u0006\b\n\u0000\u001a\u0004\bG\u00101R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010%\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010IR\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0007¢\u0006\b\n\u0000\u001a\u0004\bM\u00101¨\u0006k"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankScreenPayload;", "", "name", "Lcom/arizonagames/feature/arizona/bank/BankSubtitleField;", "years", "birth", "bankAccounts", "", "Lcom/arizonagames/feature/arizona/bank/BankAccountInfo;", "organization", "Lcom/arizonagames/feature/arizona/bank/BankOrganizationInfo;", "retirement", "Lcom/arizonagames/feature/arizona/bank/BankRetirementInfo;", "taxes", "Lcom/arizonagames/feature/arizona/bank/BankTaxesInfo;", "bankDeposit", "Lcom/arizonagames/feature/arizona/bank/BankDepositInfo;", "income", "Lcom/arizonagames/feature/arizona/bank/BankIncomeInfo;", "money", "", "own", "currencies", "Lcom/arizonagames/feature/arizona/bank/BankCurrencyInfo;", "currencyHistory", "Lcom/arizonagames/feature/arizona/bank/BankCurrencyHistoryInfo;", "vipCard", "Lcom/arizonagames/feature/arizona/bank/BankVipCardInfo;", "mobile", "Lcom/arizonagames/feature/arizona/bank/BankMobileInfo;", "vehicles", "Lcom/arizonagames/feature/arizona/bank/BankVehicleInfo;", "businesses", "", "electric", "selectedBusiness", "Lcom/arizonagames/feature/arizona/bank/BankPropertyBalanceInfo;", "selectedElectric", "lottery", "Lcom/arizonagames/feature/arizona/bank/BankLotteryInfo;", "chests", "Lcom/arizonagames/feature/arizona/bank/BankChestInfo;", "<init>", "(Lcom/arizonagames/feature/arizona/bank/BankSubtitleField;Lcom/arizonagames/feature/arizona/bank/BankSubtitleField;Lcom/arizonagames/feature/arizona/bank/BankSubtitleField;Ljava/util/List;Lcom/arizonagames/feature/arizona/bank/BankOrganizationInfo;Lcom/arizonagames/feature/arizona/bank/BankRetirementInfo;Lcom/arizonagames/feature/arizona/bank/BankTaxesInfo;Lcom/arizonagames/feature/arizona/bank/BankDepositInfo;Lcom/arizonagames/feature/arizona/bank/BankIncomeInfo;JLjava/util/List;Ljava/util/List;Ljava/util/List;Lcom/arizonagames/feature/arizona/bank/BankVipCardInfo;Lcom/arizonagames/feature/arizona/bank/BankMobileInfo;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/arizonagames/feature/arizona/bank/BankPropertyBalanceInfo;Lcom/arizonagames/feature/arizona/bank/BankPropertyBalanceInfo;Lcom/arizonagames/feature/arizona/bank/BankLotteryInfo;Ljava/util/List;)V", "getName", "()Lcom/arizonagames/feature/arizona/bank/BankSubtitleField;", "getYears", "getBirth", "getBankAccounts", "()Ljava/util/List;", "getOrganization", "()Lcom/arizonagames/feature/arizona/bank/BankOrganizationInfo;", "getRetirement", "()Lcom/arizonagames/feature/arizona/bank/BankRetirementInfo;", "getTaxes", "()Lcom/arizonagames/feature/arizona/bank/BankTaxesInfo;", "getBankDeposit", "()Lcom/arizonagames/feature/arizona/bank/BankDepositInfo;", "getIncome", "()Lcom/arizonagames/feature/arizona/bank/BankIncomeInfo;", "getMoney", "()J", "getOwn", "getCurrencies", "getCurrencyHistory", "getVipCard", "()Lcom/arizonagames/feature/arizona/bank/BankVipCardInfo;", "getMobile", "()Lcom/arizonagames/feature/arizona/bank/BankMobileInfo;", "getVehicles", "getBusinesses", "getElectric", "getSelectedBusiness", "()Lcom/arizonagames/feature/arizona/bank/BankPropertyBalanceInfo;", "getSelectedElectric", "getLottery", "()Lcom/arizonagames/feature/arizona/bank/BankLotteryInfo;", "getChests", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "equals", "", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankScreenPayload {
    private final List<BankAccountInfo> bankAccounts;
    private final BankDepositInfo bankDeposit;
    private final BankSubtitleField birth;
    private final List<Integer> businesses;
    private final List<BankChestInfo> chests;
    private final List<BankCurrencyInfo> currencies;
    private final List<BankCurrencyHistoryInfo> currencyHistory;
    private final List<Integer> electric;
    private final BankIncomeInfo income;
    private final BankLotteryInfo lottery;
    private final BankMobileInfo mobile;
    private final long money;
    private final BankSubtitleField name;
    private final BankOrganizationInfo organization;
    private final List<Long> own;
    private final BankRetirementInfo retirement;
    private final BankPropertyBalanceInfo selectedBusiness;
    private final BankPropertyBalanceInfo selectedElectric;
    private final BankTaxesInfo taxes;
    private final List<BankVehicleInfo> vehicles;
    private final BankVipCardInfo vipCard;
    private final BankSubtitleField years;

    public BankScreenPayload() {
        this(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BankScreenPayload copy$default(BankScreenPayload bankScreenPayload, BankSubtitleField bankSubtitleField, BankSubtitleField bankSubtitleField2, BankSubtitleField bankSubtitleField3, List list, BankOrganizationInfo bankOrganizationInfo, BankRetirementInfo bankRetirementInfo, BankTaxesInfo bankTaxesInfo, BankDepositInfo bankDepositInfo, BankIncomeInfo bankIncomeInfo, long j, List list2, List list3, List list4, BankVipCardInfo bankVipCardInfo, BankMobileInfo bankMobileInfo, List list5, List list6, List list7, BankPropertyBalanceInfo bankPropertyBalanceInfo, BankPropertyBalanceInfo bankPropertyBalanceInfo2, BankLotteryInfo bankLotteryInfo, List list8, int i, Object obj) {
        List<BankChestInfo> list9;
        BankLotteryInfo bankLotteryInfo2;
        BankSubtitleField bankSubtitleField4 = (i & 1) != 0 ? bankScreenPayload.name : bankSubtitleField;
        BankSubtitleField bankSubtitleField5 = (i & 2) != 0 ? bankScreenPayload.years : bankSubtitleField2;
        BankSubtitleField bankSubtitleField6 = (i & 4) != 0 ? bankScreenPayload.birth : bankSubtitleField3;
        List<BankAccountInfo> list10 = (i & 8) != 0 ? bankScreenPayload.bankAccounts : list;
        BankOrganizationInfo bankOrganizationInfo2 = (i & 16) != 0 ? bankScreenPayload.organization : bankOrganizationInfo;
        BankRetirementInfo bankRetirementInfo2 = (i & 32) != 0 ? bankScreenPayload.retirement : bankRetirementInfo;
        BankTaxesInfo bankTaxesInfo2 = (i & 64) != 0 ? bankScreenPayload.taxes : bankTaxesInfo;
        BankDepositInfo bankDepositInfo2 = (i & 128) != 0 ? bankScreenPayload.bankDeposit : bankDepositInfo;
        BankIncomeInfo bankIncomeInfo2 = (i & 256) != 0 ? bankScreenPayload.income : bankIncomeInfo;
        long j2 = (i & 512) != 0 ? bankScreenPayload.money : j;
        List<Long> list11 = (i & 1024) != 0 ? bankScreenPayload.own : list2;
        List<BankCurrencyInfo> list12 = (i & 2048) != 0 ? bankScreenPayload.currencies : list3;
        List<BankCurrencyHistoryInfo> list13 = (i & 4096) != 0 ? bankScreenPayload.currencyHistory : list4;
        BankSubtitleField bankSubtitleField7 = bankSubtitleField4;
        BankVipCardInfo bankVipCardInfo2 = (i & 8192) != 0 ? bankScreenPayload.vipCard : bankVipCardInfo;
        BankMobileInfo bankMobileInfo2 = (i & 16384) != 0 ? bankScreenPayload.mobile : bankMobileInfo;
        List<BankVehicleInfo> list14 = (i & 32768) != 0 ? bankScreenPayload.vehicles : list5;
        List<Integer> list15 = (i & 65536) != 0 ? bankScreenPayload.businesses : list6;
        List<Integer> list16 = (i & 131072) != 0 ? bankScreenPayload.electric : list7;
        BankPropertyBalanceInfo bankPropertyBalanceInfo3 = (i & 262144) != 0 ? bankScreenPayload.selectedBusiness : bankPropertyBalanceInfo;
        BankPropertyBalanceInfo bankPropertyBalanceInfo4 = (i & 524288) != 0 ? bankScreenPayload.selectedElectric : bankPropertyBalanceInfo2;
        BankLotteryInfo bankLotteryInfo3 = (i & 1048576) != 0 ? bankScreenPayload.lottery : bankLotteryInfo;
        if ((i & 2097152) != 0) {
            bankLotteryInfo2 = bankLotteryInfo3;
            list9 = bankScreenPayload.chests;
        } else {
            list9 = list8;
            bankLotteryInfo2 = bankLotteryInfo3;
        }
        return bankScreenPayload.copy(bankSubtitleField7, bankSubtitleField5, bankSubtitleField6, list10, bankOrganizationInfo2, bankRetirementInfo2, bankTaxesInfo2, bankDepositInfo2, bankIncomeInfo2, j2, list11, list12, list13, bankVipCardInfo2, bankMobileInfo2, list14, list15, list16, bankPropertyBalanceInfo3, bankPropertyBalanceInfo4, bankLotteryInfo2, list9);
    }

    public final BankSubtitleField component1() {
        return this.name;
    }

    public final long component10() {
        return this.money;
    }

    public final List<Long> component11() {
        return this.own;
    }

    public final List<BankCurrencyInfo> component12() {
        return this.currencies;
    }

    public final List<BankCurrencyHistoryInfo> component13() {
        return this.currencyHistory;
    }

    public final BankVipCardInfo component14() {
        return this.vipCard;
    }

    public final BankMobileInfo component15() {
        return this.mobile;
    }

    public final List<BankVehicleInfo> component16() {
        return this.vehicles;
    }

    public final List<Integer> component17() {
        return this.businesses;
    }

    public final List<Integer> component18() {
        return this.electric;
    }

    public final BankPropertyBalanceInfo component19() {
        return this.selectedBusiness;
    }

    public final BankSubtitleField component2() {
        return this.years;
    }

    public final BankPropertyBalanceInfo component20() {
        return this.selectedElectric;
    }

    public final BankLotteryInfo component21() {
        return this.lottery;
    }

    public final List<BankChestInfo> component22() {
        return this.chests;
    }

    public final BankSubtitleField component3() {
        return this.birth;
    }

    public final List<BankAccountInfo> component4() {
        return this.bankAccounts;
    }

    public final BankOrganizationInfo component5() {
        return this.organization;
    }

    public final BankRetirementInfo component6() {
        return this.retirement;
    }

    public final BankTaxesInfo component7() {
        return this.taxes;
    }

    public final BankDepositInfo component8() {
        return this.bankDeposit;
    }

    public final BankIncomeInfo component9() {
        return this.income;
    }

    public final BankScreenPayload copy(BankSubtitleField bankSubtitleField, BankSubtitleField bankSubtitleField2, BankSubtitleField bankSubtitleField3, List<BankAccountInfo> bankAccounts, BankOrganizationInfo bankOrganizationInfo, BankRetirementInfo bankRetirementInfo, BankTaxesInfo bankTaxesInfo, BankDepositInfo bankDepositInfo, BankIncomeInfo bankIncomeInfo, long j, List<Long> own, List<BankCurrencyInfo> currencies, List<BankCurrencyHistoryInfo> currencyHistory, BankVipCardInfo bankVipCardInfo, BankMobileInfo bankMobileInfo, List<BankVehicleInfo> vehicles, List<Integer> businesses, List<Integer> electric, BankPropertyBalanceInfo bankPropertyBalanceInfo, BankPropertyBalanceInfo bankPropertyBalanceInfo2, BankLotteryInfo bankLotteryInfo, List<BankChestInfo> chests) {
        Intrinsics.checkNotNullParameter(bankAccounts, "bankAccounts");
        Intrinsics.checkNotNullParameter(own, "own");
        Intrinsics.checkNotNullParameter(currencies, "currencies");
        Intrinsics.checkNotNullParameter(currencyHistory, "currencyHistory");
        Intrinsics.checkNotNullParameter(vehicles, "vehicles");
        Intrinsics.checkNotNullParameter(businesses, "businesses");
        Intrinsics.checkNotNullParameter(electric, "electric");
        Intrinsics.checkNotNullParameter(chests, "chests");
        return new BankScreenPayload(bankSubtitleField, bankSubtitleField2, bankSubtitleField3, bankAccounts, bankOrganizationInfo, bankRetirementInfo, bankTaxesInfo, bankDepositInfo, bankIncomeInfo, j, own, currencies, currencyHistory, bankVipCardInfo, bankMobileInfo, vehicles, businesses, electric, bankPropertyBalanceInfo, bankPropertyBalanceInfo2, bankLotteryInfo, chests);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankScreenPayload) {
            BankScreenPayload bankScreenPayload = (BankScreenPayload) obj;
            return Intrinsics.areEqual(this.name, bankScreenPayload.name) && Intrinsics.areEqual(this.years, bankScreenPayload.years) && Intrinsics.areEqual(this.birth, bankScreenPayload.birth) && Intrinsics.areEqual(this.bankAccounts, bankScreenPayload.bankAccounts) && Intrinsics.areEqual(this.organization, bankScreenPayload.organization) && Intrinsics.areEqual(this.retirement, bankScreenPayload.retirement) && Intrinsics.areEqual(this.taxes, bankScreenPayload.taxes) && Intrinsics.areEqual(this.bankDeposit, bankScreenPayload.bankDeposit) && Intrinsics.areEqual(this.income, bankScreenPayload.income) && this.money == bankScreenPayload.money && Intrinsics.areEqual(this.own, bankScreenPayload.own) && Intrinsics.areEqual(this.currencies, bankScreenPayload.currencies) && Intrinsics.areEqual(this.currencyHistory, bankScreenPayload.currencyHistory) && Intrinsics.areEqual(this.vipCard, bankScreenPayload.vipCard) && Intrinsics.areEqual(this.mobile, bankScreenPayload.mobile) && Intrinsics.areEqual(this.vehicles, bankScreenPayload.vehicles) && Intrinsics.areEqual(this.businesses, bankScreenPayload.businesses) && Intrinsics.areEqual(this.electric, bankScreenPayload.electric) && Intrinsics.areEqual(this.selectedBusiness, bankScreenPayload.selectedBusiness) && Intrinsics.areEqual(this.selectedElectric, bankScreenPayload.selectedElectric) && Intrinsics.areEqual(this.lottery, bankScreenPayload.lottery) && Intrinsics.areEqual(this.chests, bankScreenPayload.chests);
        }
        return false;
    }

    public int hashCode() {
        BankSubtitleField bankSubtitleField = this.name;
        int hashCode = (bankSubtitleField == null ? 0 : bankSubtitleField.hashCode()) * 31;
        BankSubtitleField bankSubtitleField2 = this.years;
        int hashCode2 = (hashCode + (bankSubtitleField2 == null ? 0 : bankSubtitleField2.hashCode())) * 31;
        BankSubtitleField bankSubtitleField3 = this.birth;
        int hashCode3 = (((hashCode2 + (bankSubtitleField3 == null ? 0 : bankSubtitleField3.hashCode())) * 31) + this.bankAccounts.hashCode()) * 31;
        BankOrganizationInfo bankOrganizationInfo = this.organization;
        int hashCode4 = (hashCode3 + (bankOrganizationInfo == null ? 0 : bankOrganizationInfo.hashCode())) * 31;
        BankRetirementInfo bankRetirementInfo = this.retirement;
        int hashCode5 = (hashCode4 + (bankRetirementInfo == null ? 0 : bankRetirementInfo.hashCode())) * 31;
        BankTaxesInfo bankTaxesInfo = this.taxes;
        int hashCode6 = (hashCode5 + (bankTaxesInfo == null ? 0 : bankTaxesInfo.hashCode())) * 31;
        BankDepositInfo bankDepositInfo = this.bankDeposit;
        int hashCode7 = (hashCode6 + (bankDepositInfo == null ? 0 : bankDepositInfo.hashCode())) * 31;
        BankIncomeInfo bankIncomeInfo = this.income;
        int hashCode8 = (((((((((hashCode7 + (bankIncomeInfo == null ? 0 : bankIncomeInfo.hashCode())) * 31) + Long.hashCode(this.money)) * 31) + this.own.hashCode()) * 31) + this.currencies.hashCode()) * 31) + this.currencyHistory.hashCode()) * 31;
        BankVipCardInfo bankVipCardInfo = this.vipCard;
        int hashCode9 = (hashCode8 + (bankVipCardInfo == null ? 0 : bankVipCardInfo.hashCode())) * 31;
        BankMobileInfo bankMobileInfo = this.mobile;
        int hashCode10 = (((((((hashCode9 + (bankMobileInfo == null ? 0 : bankMobileInfo.hashCode())) * 31) + this.vehicles.hashCode()) * 31) + this.businesses.hashCode()) * 31) + this.electric.hashCode()) * 31;
        BankPropertyBalanceInfo bankPropertyBalanceInfo = this.selectedBusiness;
        int hashCode11 = (hashCode10 + (bankPropertyBalanceInfo == null ? 0 : bankPropertyBalanceInfo.hashCode())) * 31;
        BankPropertyBalanceInfo bankPropertyBalanceInfo2 = this.selectedElectric;
        int hashCode12 = (hashCode11 + (bankPropertyBalanceInfo2 == null ? 0 : bankPropertyBalanceInfo2.hashCode())) * 31;
        BankLotteryInfo bankLotteryInfo = this.lottery;
        return ((hashCode12 + (bankLotteryInfo != null ? bankLotteryInfo.hashCode() : 0)) * 31) + this.chests.hashCode();
    }

    public String toString() {
        BankSubtitleField bankSubtitleField = this.name;
        BankSubtitleField bankSubtitleField2 = this.years;
        BankSubtitleField bankSubtitleField3 = this.birth;
        List<BankAccountInfo> list = this.bankAccounts;
        BankOrganizationInfo bankOrganizationInfo = this.organization;
        BankRetirementInfo bankRetirementInfo = this.retirement;
        BankTaxesInfo bankTaxesInfo = this.taxes;
        BankDepositInfo bankDepositInfo = this.bankDeposit;
        BankIncomeInfo bankIncomeInfo = this.income;
        long j = this.money;
        List<Long> list2 = this.own;
        List<BankCurrencyInfo> list3 = this.currencies;
        List<BankCurrencyHistoryInfo> list4 = this.currencyHistory;
        BankVipCardInfo bankVipCardInfo = this.vipCard;
        BankMobileInfo bankMobileInfo = this.mobile;
        List<BankVehicleInfo> list5 = this.vehicles;
        List<Integer> list6 = this.businesses;
        List<Integer> list7 = this.electric;
        BankPropertyBalanceInfo bankPropertyBalanceInfo = this.selectedBusiness;
        BankPropertyBalanceInfo bankPropertyBalanceInfo2 = this.selectedElectric;
        BankLotteryInfo bankLotteryInfo = this.lottery;
        return "BankScreenPayload(name=" + bankSubtitleField + ", years=" + bankSubtitleField2 + ", birth=" + bankSubtitleField3 + ", bankAccounts=" + list + ", organization=" + bankOrganizationInfo + ", retirement=" + bankRetirementInfo + ", taxes=" + bankTaxesInfo + ", bankDeposit=" + bankDepositInfo + ", income=" + bankIncomeInfo + ", money=" + j + ", own=" + list2 + ", currencies=" + list3 + ", currencyHistory=" + list4 + ", vipCard=" + bankVipCardInfo + ", mobile=" + bankMobileInfo + ", vehicles=" + list5 + ", businesses=" + list6 + ", electric=" + list7 + ", selectedBusiness=" + bankPropertyBalanceInfo + ", selectedElectric=" + bankPropertyBalanceInfo2 + ", lottery=" + bankLotteryInfo + ", chests=" + this.chests + ")";
    }

    public BankScreenPayload(BankSubtitleField bankSubtitleField, BankSubtitleField bankSubtitleField2, BankSubtitleField bankSubtitleField3, List<BankAccountInfo> bankAccounts, BankOrganizationInfo bankOrganizationInfo, BankRetirementInfo bankRetirementInfo, BankTaxesInfo bankTaxesInfo, BankDepositInfo bankDepositInfo, BankIncomeInfo bankIncomeInfo, long j, List<Long> own, List<BankCurrencyInfo> currencies, List<BankCurrencyHistoryInfo> currencyHistory, BankVipCardInfo bankVipCardInfo, BankMobileInfo bankMobileInfo, List<BankVehicleInfo> vehicles, List<Integer> businesses, List<Integer> electric, BankPropertyBalanceInfo bankPropertyBalanceInfo, BankPropertyBalanceInfo bankPropertyBalanceInfo2, BankLotteryInfo bankLotteryInfo, List<BankChestInfo> chests) {
        Intrinsics.checkNotNullParameter(bankAccounts, "bankAccounts");
        Intrinsics.checkNotNullParameter(own, "own");
        Intrinsics.checkNotNullParameter(currencies, "currencies");
        Intrinsics.checkNotNullParameter(currencyHistory, "currencyHistory");
        Intrinsics.checkNotNullParameter(vehicles, "vehicles");
        Intrinsics.checkNotNullParameter(businesses, "businesses");
        Intrinsics.checkNotNullParameter(electric, "electric");
        Intrinsics.checkNotNullParameter(chests, "chests");
        this.name = bankSubtitleField;
        this.years = bankSubtitleField2;
        this.birth = bankSubtitleField3;
        this.bankAccounts = bankAccounts;
        this.organization = bankOrganizationInfo;
        this.retirement = bankRetirementInfo;
        this.taxes = bankTaxesInfo;
        this.bankDeposit = bankDepositInfo;
        this.income = bankIncomeInfo;
        this.money = j;
        this.own = own;
        this.currencies = currencies;
        this.currencyHistory = currencyHistory;
        this.vipCard = bankVipCardInfo;
        this.mobile = bankMobileInfo;
        this.vehicles = vehicles;
        this.businesses = businesses;
        this.electric = electric;
        this.selectedBusiness = bankPropertyBalanceInfo;
        this.selectedElectric = bankPropertyBalanceInfo2;
        this.lottery = bankLotteryInfo;
        this.chests = chests;
    }

    public final BankSubtitleField getName() {
        return this.name;
    }

    public final BankSubtitleField getYears() {
        return this.years;
    }

    public final BankSubtitleField getBirth() {
        return this.birth;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ BankScreenPayload(BankSubtitleField bankSubtitleField, BankSubtitleField bankSubtitleField2, BankSubtitleField bankSubtitleField3, List list, BankOrganizationInfo bankOrganizationInfo, BankRetirementInfo bankRetirementInfo, BankTaxesInfo bankTaxesInfo, BankDepositInfo bankDepositInfo, BankIncomeInfo bankIncomeInfo, long j, List list2, List list3, List list4, BankVipCardInfo bankVipCardInfo, BankMobileInfo bankMobileInfo, List list5, List list6, List list7, BankPropertyBalanceInfo bankPropertyBalanceInfo, BankPropertyBalanceInfo bankPropertyBalanceInfo2, BankLotteryInfo bankLotteryInfo, List list8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r2, (i & 16384) != 0 ? null : bankMobileInfo, (i & 32768) != 0 ? CollectionsKt.emptyList() : list5, (i & 65536) != 0 ? CollectionsKt.emptyList() : list6, (i & 131072) != 0 ? CollectionsKt.emptyList() : list7, (i & 262144) != 0 ? null : bankPropertyBalanceInfo, (i & 524288) != 0 ? null : bankPropertyBalanceInfo2, (i & 1048576) != 0 ? null : bankLotteryInfo, (i & 2097152) != 0 ? CollectionsKt.emptyList() : list8);
        BankSubtitleField bankSubtitleField4 = (i & 1) != 0 ? null : bankSubtitleField;
        BankSubtitleField bankSubtitleField5 = (i & 2) != 0 ? null : bankSubtitleField2;
        BankSubtitleField bankSubtitleField6 = (i & 4) != 0 ? null : bankSubtitleField3;
        List emptyList = (i & 8) != 0 ? CollectionsKt.emptyList() : list;
        BankOrganizationInfo bankOrganizationInfo2 = (i & 16) != 0 ? null : bankOrganizationInfo;
        BankRetirementInfo bankRetirementInfo2 = (i & 32) != 0 ? null : bankRetirementInfo;
        BankTaxesInfo bankTaxesInfo2 = (i & 64) != 0 ? null : bankTaxesInfo;
        BankDepositInfo bankDepositInfo2 = (i & 128) != 0 ? null : bankDepositInfo;
        BankIncomeInfo bankIncomeInfo2 = (i & 256) != 0 ? null : bankIncomeInfo;
        long j2 = (i & 512) != 0 ? 0L : j;
        List emptyList2 = (i & 1024) != 0 ? CollectionsKt.emptyList() : list2;
        List emptyList3 = (i & 2048) != 0 ? CollectionsKt.emptyList() : list3;
        List emptyList4 = (i & 4096) != 0 ? CollectionsKt.emptyList() : list4;
        BankVipCardInfo bankVipCardInfo2 = (i & 8192) != 0 ? null : bankVipCardInfo;
    }

    public final List<BankAccountInfo> getBankAccounts() {
        return this.bankAccounts;
    }

    public final BankOrganizationInfo getOrganization() {
        return this.organization;
    }

    public final BankRetirementInfo getRetirement() {
        return this.retirement;
    }

    public final BankTaxesInfo getTaxes() {
        return this.taxes;
    }

    public final BankDepositInfo getBankDeposit() {
        return this.bankDeposit;
    }

    public final BankIncomeInfo getIncome() {
        return this.income;
    }

    public final long getMoney() {
        return this.money;
    }

    public final List<Long> getOwn() {
        return this.own;
    }

    public final List<BankCurrencyInfo> getCurrencies() {
        return this.currencies;
    }

    public final List<BankCurrencyHistoryInfo> getCurrencyHistory() {
        return this.currencyHistory;
    }

    public final BankVipCardInfo getVipCard() {
        return this.vipCard;
    }

    public final BankMobileInfo getMobile() {
        return this.mobile;
    }

    public final List<BankVehicleInfo> getVehicles() {
        return this.vehicles;
    }

    public final List<Integer> getBusinesses() {
        return this.businesses;
    }

    public final List<Integer> getElectric() {
        return this.electric;
    }

    public final BankPropertyBalanceInfo getSelectedBusiness() {
        return this.selectedBusiness;
    }

    public final BankPropertyBalanceInfo getSelectedElectric() {
        return this.selectedElectric;
    }

    public final BankLotteryInfo getLottery() {
        return this.lottery;
    }

    public final List<BankChestInfo> getChests() {
        return this.chests;
    }
}
