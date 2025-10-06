package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.m3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0423m3 implements BillingInfoStorage {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f986a;
    public C0749z2 b;

    public C0423m3(Context context) {
        this(Zm.a(C0749z2.class).a(context));
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final List<BillingInfo> getBillingInfo() {
        return this.b.f1181a;
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final boolean isFirstInappCheckOccurred() {
        return this.b.b;
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final void saveInfo(List<BillingInfo> list, boolean z) {
        for (BillingInfo billingInfo : list) {
        }
        C0749z2 c0749z2 = new C0749z2(list, z);
        this.b = c0749z2;
        this.f986a.save(c0749z2);
    }

    public C0423m3(ProtobufStateStorage protobufStateStorage) {
        this.f986a = protobufStateStorage;
        this.b = (C0749z2) protobufStateStorage.read();
    }
}
