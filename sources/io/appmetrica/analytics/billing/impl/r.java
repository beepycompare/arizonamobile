package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billing.internal.config.BillingConfig;
import io.appmetrica.analytics.billing.internal.config.RemoteBillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes3.dex */
public final class r implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final g f319a;

    public r() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final t fromModel(RemoteBillingConfig remoteBillingConfig) {
        t tVar = new t();
        tVar.f321a = remoteBillingConfig.getEnabled();
        BillingConfig config = remoteBillingConfig.getConfig();
        tVar.b = config != null ? this.f319a.fromModel(config) : null;
        return tVar;
    }

    public r(g gVar) {
        this.f319a = gVar;
    }

    public /* synthetic */ r(g gVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new g() : gVar);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final RemoteBillingConfig toModel(t tVar) {
        boolean z = tVar.f321a;
        g gVar = this.f319a;
        s sVar = tVar.b;
        gVar.getClass();
        return new RemoteBillingConfig(z, new BillingConfig(sVar.f320a, sVar.b));
    }
}
