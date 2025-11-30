package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.ok  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0481ok extends Kc {

    /* renamed from: a  reason: collision with root package name */
    public final xo f1053a;

    public C0481ok() {
        this(C0471oa.k().D().b());
    }

    @Override // io.appmetrica.analytics.impl.Kc
    public final void a(int i) {
        xo xoVar = this.f1053a;
        synchronized (xoVar) {
            zo zoVar = xoVar.f1206a;
            zoVar.a(zoVar.a().put("last_migration_api_level", i));
        }
    }

    @Override // io.appmetrica.analytics.impl.Kc
    public final int b() {
        int optInt;
        xo xoVar = this.f1053a;
        synchronized (xoVar) {
            optInt = xoVar.f1206a.a().optInt("last_migration_api_level", -1);
        }
        return optInt;
    }

    @Override // io.appmetrica.analytics.impl.Kc
    public final SparseArray<Jc> c() {
        SparseArray<Jc> sparseArray = new SparseArray<>(1);
        sparseArray.put(112, new C0506pk(this.f1053a));
        sparseArray.put(115, new C0531qk());
        sparseArray.put(116, new C0605tk());
        return sparseArray;
    }

    public C0481ok(xo xoVar) {
        this.f1053a = xoVar;
    }
}
