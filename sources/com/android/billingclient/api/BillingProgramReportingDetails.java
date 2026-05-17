package com.android.billingclient.api;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
public final class BillingProgramReportingDetails {
    private final int billingProgram;
    private final String externalTransactionToken;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingProgramReportingDetails(String str, int i) {
        this.externalTransactionToken = str;
        this.billingProgram = i;
    }

    public int getBillingProgram() {
        return this.billingProgram;
    }

    public String getExternalTransactionToken() {
        return this.externalTransactionToken;
    }
}
