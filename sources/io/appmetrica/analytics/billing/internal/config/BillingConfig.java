package io.appmetrica.analytics.billing.internal.config;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.billing.impl.s;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eB\t\b\u0016¢\u0006\u0004\b\r\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u0010"}, d2 = {"Lio/appmetrica/analytics/billing/internal/config/BillingConfig;", "", "", "toString", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "I", "getSendFrequencySeconds", "()I", "sendFrequencySeconds", "b", "getFirstCollectingInappMaxAgeSeconds", "firstCollectingInappMaxAgeSeconds", "<init>", "(II)V", "()V", "billing_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class BillingConfig {

    /* renamed from: a  reason: collision with root package name */
    private final int f331a;
    private final int b;

    public BillingConfig(int i, int i2) {
        this.f331a = i;
        this.b = i2;
    }

    public final int getFirstCollectingInappMaxAgeSeconds() {
        return this.b;
    }

    public final int getSendFrequencySeconds() {
        return this.f331a;
    }

    public String toString() {
        return "BillingConfig(sendFrequencySeconds=" + this.f331a + ", firstCollectingInappMaxAgeSeconds=" + this.b + ')';
    }

    public BillingConfig() {
        this(new s().f320a, new s().b);
    }
}
