package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.j3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0346j3 implements BillingInfoStorage {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f887a;
    public C0669w2 b;

    public C0346j3(Context context) {
        this(Nm.a(C0669w2.class).a(context));
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final List<BillingInfo> getBillingInfo() {
        return this.b.f1097a;
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final boolean isFirstInappCheckOccurred() {
        return this.b.b;
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final void saveInfo(List<BillingInfo> list, boolean z) {
        for (BillingInfo billingInfo : list) {
        }
        C0669w2 c0669w2 = new C0669w2(list, z);
        this.b = c0669w2;
        this.f887a.save(c0669w2);
    }

    public C0346j3(ProtobufStateStorage protobufStateStorage) {
        this.f887a = protobufStateStorage;
        this.b = (C0669w2) protobufStateStorage.read();
    }
}
