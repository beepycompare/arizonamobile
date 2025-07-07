package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import io.appmetrica.analytics.BuildConfig;
/* renamed from: io.appmetrica.analytics.impl.rk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0570rk extends AbstractC0189cd {

    /* renamed from: a  reason: collision with root package name */
    public final qo f1030a;

    public C0570rk() {
        this(Ga.j().B().b());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0189cd
    public final void a(int i) {
        qo qoVar = this.f1030a;
        synchronized (qoVar) {
            so soVar = qoVar.f1012a;
            soVar.a(soVar.a().put("last_migration_api_level", i));
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0189cd
    public final int b() {
        int optInt;
        qo qoVar = this.f1030a;
        synchronized (qoVar) {
            optInt = qoVar.f1012a.a().optInt("last_migration_api_level", -1);
        }
        return optInt;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0189cd
    public final SparseArray<InterfaceC0163bd> c() {
        SparseArray<InterfaceC0163bd> sparseArray = new SparseArray<>(1);
        sparseArray.put(112, new C0595sk(this.f1030a));
        sparseArray.put(BuildConfig.API_LEVEL, new C0620tk());
        return sparseArray;
    }

    public C0570rk(qo qoVar) {
        this.f1030a = qoVar;
    }
}
