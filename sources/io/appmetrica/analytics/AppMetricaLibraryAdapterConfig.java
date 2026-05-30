package io.appmetrica.analytics;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public class AppMetricaLibraryAdapterConfig {
    public final Boolean advIdentifiersTracking;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Boolean f210a;

        public AppMetricaLibraryAdapterConfig build() {
            return new AppMetricaLibraryAdapterConfig(this, 0);
        }

        public Builder withAdvIdentifiersTracking(boolean z) {
            this.f210a = Boolean.valueOf(z);
            return this;
        }
    }

    /* synthetic */ AppMetricaLibraryAdapterConfig(Builder builder, int i) {
        this(builder);
    }

    public static Builder newConfigBuilder() {
        return new Builder();
    }

    public String toString() {
        return "AppMetricaLibraryAdapterConfig{advIdentifiersTracking=" + this.advIdentifiersTracking + AbstractJsonLexerKt.END_OBJ;
    }

    private AppMetricaLibraryAdapterConfig(Builder builder) {
        this.advIdentifiersTracking = builder.f210a;
    }
}
