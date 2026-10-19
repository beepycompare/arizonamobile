package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.billing.impl.b  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0091b implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final i f265a;

    public C0091b() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final d fromModel(C0090a c0090a) {
        d dVar = new d();
        List<BillingInfo> list = c0090a.f264a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (BillingInfo billingInfo : list) {
            arrayList.add(this.f265a.fromModel(billingInfo));
        }
        dVar.f267a = (c[]) arrayList.toArray(new c[0]);
        dVar.b = c0090a.b;
        return dVar;
    }

    public C0091b(i iVar) {
        this.f265a = iVar;
    }

    public /* synthetic */ C0091b(i iVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new i() : iVar);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0090a toModel(d dVar) {
        c[] cVarArr = dVar.f267a;
        ArrayList arrayList = new ArrayList(cVarArr.length);
        for (c cVar : cVarArr) {
            arrayList.add(this.f265a.toModel(cVar));
        }
        return new C0090a(arrayList, dVar.b);
    }
}
