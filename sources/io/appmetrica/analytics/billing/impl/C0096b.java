package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.billing.impl.b  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0096b implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final i f308a;

    public C0096b() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final d fromModel(C0095a c0095a) {
        d dVar = new d();
        List<BillingInfo> list = c0095a.f307a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (BillingInfo billingInfo : list) {
            arrayList.add(this.f308a.fromModel(billingInfo));
        }
        Object[] array = arrayList.toArray(new c[0]);
        if (array != null) {
            dVar.f310a = (c[]) array;
            dVar.b = c0095a.b;
            return dVar;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public C0096b(i iVar) {
        this.f308a = iVar;
    }

    public /* synthetic */ C0096b(i iVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new i() : iVar);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0095a toModel(d dVar) {
        c[] cVarArr = dVar.f310a;
        ArrayList arrayList = new ArrayList(cVarArr.length);
        for (c cVar : cVarArr) {
            arrayList.add(this.f308a.toModel(cVar));
        }
        return new C0095a(arrayList, dVar.b);
    }
}
