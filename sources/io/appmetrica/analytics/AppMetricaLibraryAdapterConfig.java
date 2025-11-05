package io.appmetrica.analytics;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes.dex */
public class AppMetricaLibraryAdapterConfig {
    public final Boolean advIdentifiersTracking;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Boolean f180a;

        public AppMetricaLibraryAdapterConfig build() {
            return new AppMetricaLibraryAdapterConfig(this, 0);
        }

        public Builder withAdvIdentifiersTracking(boolean z) {
            this.f180a = Boolean.valueOf(z);
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
        this.advIdentifiersTracking = builder.f180a;
    }
}
