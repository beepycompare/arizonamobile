package io.appmetrica.analytics.billing.internal.config;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.billing.impl.t;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011B\t\b\u0016¢\u0006\u0004\b\u0010\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lio/appmetrica/analytics/billing/internal/config/RemoteBillingConfig;", "", "", "toString", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Z", "getEnabled", "()Z", "enabled", "Lio/appmetrica/analytics/billing/internal/config/BillingConfig;", "b", "Lio/appmetrica/analytics/billing/internal/config/BillingConfig;", "getConfig", "()Lio/appmetrica/analytics/billing/internal/config/BillingConfig;", "config", "<init>", "(ZLio/appmetrica/analytics/billing/internal/config/BillingConfig;)V", "()V", "billing_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class RemoteBillingConfig {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f333a;
    private final BillingConfig b;

    public RemoteBillingConfig(boolean z, BillingConfig billingConfig) {
        this.f333a = z;
        this.b = billingConfig;
    }

    public final BillingConfig getConfig() {
        return this.b;
    }

    public final boolean getEnabled() {
        return this.f333a;
    }

    public String toString() {
        return "RemoteBillingConfig(enabled=" + this.f333a + ", config=" + this.b + ')';
    }

    public RemoteBillingConfig() {
        this(new t().f322a, new BillingConfig());
    }
}
