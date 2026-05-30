package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.billing.impl.b  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0098b implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final i f260a;

    public C0098b() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final d fromModel(C0097a c0097a) {
        d dVar = new d();
        List<BillingInfo> list = c0097a.f259a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (BillingInfo billingInfo : list) {
            arrayList.add(this.f260a.fromModel(billingInfo));
        }
        dVar.f262a = (c[]) arrayList.toArray(new c[0]);
        dVar.b = c0097a.b;
        return dVar;
    }

    public C0098b(i iVar) {
        this.f260a = iVar;
    }

    public /* synthetic */ C0098b(i iVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new i() : iVar);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0097a toModel(d dVar) {
        c[] cVarArr = dVar.f262a;
        ArrayList arrayList = new ArrayList(cVarArr.length);
        for (c cVar : cVarArr) {
            arrayList.add(this.f260a.toModel(cVar));
        }
        return new C0097a(arrayList, dVar.b);
    }
}
