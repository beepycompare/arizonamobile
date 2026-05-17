package com.android.billingclient.api;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
public final class BillingProgramReportingDetailsParams {
    private final int billingProgram;

    /* compiled from: com.android.billingclient:billing@@8.3.0 */
    /* loaded from: classes3.dex */
    public static final class Builder {
        private int billingProgram;

        private Builder() {
            this.billingProgram = 0;
        }

        public BillingProgramReportingDetailsParams build() {
            if (this.billingProgram == 0) {
                throw new IllegalArgumentException("Billing program is not specified.");
            }
            return new BillingProgramReportingDetailsParams(this);
        }

        public Builder setBillingProgram(int i) {
            this.billingProgram = i;
            return this;
        }
    }

    private BillingProgramReportingDetailsParams(Builder builder) {
        this.billingProgram = builder.billingProgram;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getBillingProgram() {
        return this.billingProgram;
    }
}
