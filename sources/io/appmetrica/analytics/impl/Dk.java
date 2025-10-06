package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import io.appmetrica.analytics.BuildConfig;
/* loaded from: classes4.dex */
public final class Dk extends AbstractC0355jd {

    /* renamed from: a  reason: collision with root package name */
    public final Co f415a;

    public Dk() {
        this(Na.j().B().b());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0355jd
    public final void a(int i) {
        Co co = this.f415a;
        synchronized (co) {
            Eo eo = co.f398a;
            eo.a(eo.a().put("last_migration_api_level", i));
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0355jd
    public final int b() {
        int optInt;
        Co co = this.f415a;
        synchronized (co) {
            optInt = co.f398a.a().optInt("last_migration_api_level", -1);
        }
        return optInt;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0355jd
    public final SparseArray<InterfaceC0330id> c() {
        SparseArray<InterfaceC0330id> sparseArray = new SparseArray<>(1);
        sparseArray.put(112, new Ek(this.f415a));
        sparseArray.put(BuildConfig.API_LEVEL, new Fk());
        return sparseArray;
    }

    public Dk(Co co) {
        this.f415a = co;
    }
}
