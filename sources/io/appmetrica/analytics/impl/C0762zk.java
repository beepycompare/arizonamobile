package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import io.appmetrica.analytics.BuildConfig;
/* renamed from: io.appmetrica.analytics.impl.zk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0762zk extends AbstractC0277gd {

    /* renamed from: a  reason: collision with root package name */
    public final yo f1184a;

    public C0762zk() {
        this(Ka.j().B().b());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0277gd
    public final void a(int i) {
        yo yoVar = this.f1184a;
        synchronized (yoVar) {
            Ao ao = yoVar.f1167a;
            ao.a(ao.a().put("last_migration_api_level", i));
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0277gd
    public final int b() {
        int optInt;
        yo yoVar = this.f1184a;
        synchronized (yoVar) {
            optInt = yoVar.f1167a.a().optInt("last_migration_api_level", -1);
        }
        return optInt;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0277gd
    public final SparseArray<InterfaceC0251fd> c() {
        SparseArray<InterfaceC0251fd> sparseArray = new SparseArray<>(1);
        sparseArray.put(112, new Ak(this.f1184a));
        sparseArray.put(BuildConfig.API_LEVEL, new Bk());
        return sparseArray;
    }

    public C0762zk(yo yoVar) {
        this.f1184a = yoVar;
    }
}
