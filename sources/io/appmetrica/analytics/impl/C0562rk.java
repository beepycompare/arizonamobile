package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import io.appmetrica.analytics.BuildConfig;
/* renamed from: io.appmetrica.analytics.impl.rk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0562rk extends AbstractC0181cd {

    /* renamed from: a  reason: collision with root package name */
    public final qo f1031a;

    public C0562rk() {
        this(Ga.j().B().b());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0181cd
    public final void a(int i) {
        qo qoVar = this.f1031a;
        synchronized (qoVar) {
            so soVar = qoVar.f1013a;
            soVar.a(soVar.a().put("last_migration_api_level", i));
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0181cd
    public final int b() {
        int optInt;
        qo qoVar = this.f1031a;
        synchronized (qoVar) {
            optInt = qoVar.f1013a.a().optInt("last_migration_api_level", -1);
        }
        return optInt;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0181cd
    public final SparseArray<InterfaceC0155bd> c() {
        SparseArray<InterfaceC0155bd> sparseArray = new SparseArray<>(1);
        sparseArray.put(112, new C0587sk(this.f1031a));
        sparseArray.put(BuildConfig.API_LEVEL, new C0612tk());
        return sparseArray;
    }

    public C0562rk(qo qoVar) {
        this.f1031a = qoVar;
    }
}
