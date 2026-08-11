package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankApiEndpoints;", "", "<init>", "()V", "BUSINESS_LIST", "", "HOUSE_LIST", "CURRENCY_HISTORY", "DEPOSIT_INCOME", "ACCOUNT_HISTORY", "DEPOSIT_HISTORY", "ORGANIZATION_HISTORY", "GIVEAWAY_PRIZES", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankApiEndpoints {
    public static final String ACCOUNT_HISTORY = "client/bank/getAccountHistory";
    public static final String BUSINESS_LIST = "client/properties/business/getList";
    public static final String CURRENCY_HISTORY = "client/bank/getCurrencyHistory";
    public static final String DEPOSIT_HISTORY = "client/bank/getDepositHistory";
    public static final String DEPOSIT_INCOME = "client/bank/getDepositIncome";
    public static final String GIVEAWAY_PRIZES = "client/bank/getGiveawayPrizes";
    public static final String HOUSE_LIST = "client/properties/house/getList";
    public static final BankApiEndpoints INSTANCE = new BankApiEndpoints();
    public static final String ORGANIZATION_HISTORY = "client/bank/getOrgHistory";

    private BankApiEndpoints() {
    }
}
