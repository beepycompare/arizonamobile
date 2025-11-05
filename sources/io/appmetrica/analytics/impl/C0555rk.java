package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.rk  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0555rk extends Qc {

    /* renamed from: a  reason: collision with root package name */
    public final yo f1099a;

    public C0555rk() {
        this(C0620ua.k().D().b());
    }

    @Override // io.appmetrica.analytics.impl.Qc
    public final void a(int i) {
        yo yoVar = this.f1099a;
        synchronized (yoVar) {
            Ao ao = yoVar.f1220a;
            ao.a(ao.a().put("last_migration_api_level", i));
        }
    }

    @Override // io.appmetrica.analytics.impl.Qc
    public final int b() {
        int optInt;
        yo yoVar = this.f1099a;
        synchronized (yoVar) {
            optInt = yoVar.f1220a.a().optInt("last_migration_api_level", -1);
        }
        return optInt;
    }

    @Override // io.appmetrica.analytics.impl.Qc
    public final SparseArray<Pc> c() {
        SparseArray<Pc> sparseArray = new SparseArray<>(1);
        sparseArray.put(112, new C0580sk(this.f1099a));
        sparseArray.put(115, new C0605tk());
        sparseArray.put(116, new C0705xk());
        return sparseArray;
    }

    public C0555rk(yo yoVar) {
        this.f1099a = yoVar;
    }
}
