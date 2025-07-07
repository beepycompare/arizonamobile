package com.google.firebase.remoteconfig;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class CustomSignals {
    final Map<String, String> customSignals;

    /* loaded from: classes4.dex */
    public static class Builder {
        private Map<String, String> customSignals = new HashMap();

        public Builder put(String str, String str2) {
            this.customSignals.put(str, str2);
            return this;
        }

        public Builder put(String str, long j) {
            this.customSignals.put(str, Long.toString(j));
            return this;
        }

        public Builder put(String str, double d) {
            this.customSignals.put(str, Double.toString(d));
            return this;
        }

        public CustomSignals build() {
            return new CustomSignals(this);
        }
    }

    CustomSignals(Builder builder) {
        this.customSignals = builder.customSignals;
    }
}
