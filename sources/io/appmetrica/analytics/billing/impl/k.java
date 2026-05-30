package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
/* loaded from: classes5.dex */
public final class k implements BillingInfoStorage {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f265a;
    public C0097a b;

    public k(ProtobufStateStorage<C0097a> protobufStateStorage) {
        this.f265a = protobufStateStorage;
        this.b = protobufStateStorage.read();
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final List<BillingInfo> getBillingInfo() {
        return this.b.f259a;
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final boolean isFirstInappCheckOccurred() {
        return this.b.b;
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final void saveInfo(List<? extends BillingInfo> list, boolean z) {
        for (BillingInfo billingInfo : list) {
        }
        C0097a c0097a = new C0097a(list, z);
        this.b = c0097a;
        this.f265a.save(c0097a);
    }
}
