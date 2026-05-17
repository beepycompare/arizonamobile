package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.nk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0458nk extends Jc {

    /* renamed from: a  reason: collision with root package name */
    public final wo f1145a;

    public C0458nk() {
        this(C0448na.k().D().b());
    }

    @Override // io.appmetrica.analytics.impl.Jc
    public final void a(int i) {
        wo woVar = this.f1145a;
        synchronized (woVar) {
            yo yoVar = woVar.f1298a;
            yoVar.a(yoVar.a().put("last_migration_api_level", i));
        }
    }

    @Override // io.appmetrica.analytics.impl.Jc
    public final int b() {
        int optInt;
        wo woVar = this.f1145a;
        synchronized (woVar) {
            optInt = woVar.f1298a.a().optInt("last_migration_api_level", -1);
        }
        return optInt;
    }

    @Override // io.appmetrica.analytics.impl.Jc
    public final SparseArray<Ic> c() {
        SparseArray<Ic> sparseArray = new SparseArray<>(1);
        sparseArray.put(112, new C0483ok(this.f1145a));
        sparseArray.put(115, new C0508pk());
        sparseArray.put(116, new C0582sk());
        return sparseArray;
    }

    public C0458nk(wo woVar) {
        this.f1145a = woVar;
    }
}
