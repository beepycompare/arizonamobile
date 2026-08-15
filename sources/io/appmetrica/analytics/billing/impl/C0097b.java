package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.billing.impl.b  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0097b implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final i f262a;

    public C0097b() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final d fromModel(C0096a c0096a) {
        d dVar = new d();
        List<BillingInfo> list = c0096a.f261a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (BillingInfo billingInfo : list) {
            arrayList.add(this.f262a.fromModel(billingInfo));
        }
        dVar.f264a = (c[]) arrayList.toArray(new c[0]);
        dVar.b = c0096a.b;
        return dVar;
    }

    public C0097b(i iVar) {
        this.f262a = iVar;
    }

    public /* synthetic */ C0097b(i iVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new i() : iVar);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0096a toModel(d dVar) {
        c[] cVarArr = dVar.f264a;
        ArrayList arrayList = new ArrayList(cVarArr.length);
        for (c cVar : cVarArr) {
            arrayList.add(this.f262a.toModel(cVar));
        }
        return new C0096a(arrayList, dVar.b);
    }
}
