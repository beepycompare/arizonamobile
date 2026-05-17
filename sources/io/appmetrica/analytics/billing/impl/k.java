package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
/* loaded from: classes5.dex */
public final class k implements BillingInfoStorage {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f318a;
    public C0095a b;

    public k(ProtobufStateStorage<C0095a> protobufStateStorage) {
        this.f318a = protobufStateStorage;
        this.b = protobufStateStorage.read();
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final List<BillingInfo> getBillingInfo() {
        return this.b.f312a;
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final boolean isFirstInappCheckOccurred() {
        return this.b.b;
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final void saveInfo(List<? extends BillingInfo> list, boolean z) {
        for (BillingInfo billingInfo : list) {
        }
        C0095a c0095a = new C0095a(list, z);
        this.b = c0095a;
        this.f318a.save(c0095a);
    }
}
