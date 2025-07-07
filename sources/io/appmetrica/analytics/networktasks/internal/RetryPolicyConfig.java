package io.appmetrica.analytics.networktasks.internal;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public class RetryPolicyConfig {
    public final int exponentialMultiplier;
    public final int maxIntervalSeconds;

    public RetryPolicyConfig(int i, int i2) {
        this.maxIntervalSeconds = i;
        this.exponentialMultiplier = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            RetryPolicyConfig retryPolicyConfig = (RetryPolicyConfig) obj;
            if (this.maxIntervalSeconds == retryPolicyConfig.maxIntervalSeconds && this.exponentialMultiplier == retryPolicyConfig.exponentialMultiplier) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.maxIntervalSeconds * 31) + this.exponentialMultiplier;
    }

    public String toString() {
        return "RetryPolicyConfig{maxIntervalSeconds=" + this.maxIntervalSeconds + ", exponentialMultiplier=" + this.exponentialMultiplier + AbstractJsonLexerKt.END_OBJ;
    }
}
