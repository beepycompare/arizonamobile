package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import io.appmetrica.analytics.BuildConfig;
/* renamed from: io.appmetrica.analytics.impl.uk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0639uk extends AbstractC0232ed {

    /* renamed from: a  reason: collision with root package name */
    public final to f1088a;

    public C0639uk() {
        this(Ia.j().B().b());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0232ed
    public final void a(int i) {
        to toVar = this.f1088a;
        synchronized (toVar) {
            vo voVar = toVar.f1073a;
            voVar.a(voVar.a().put("last_migration_api_level", i));
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0232ed
    public final int b() {
        int optInt;
        to toVar = this.f1088a;
        synchronized (toVar) {
            optInt = toVar.f1073a.a().optInt("last_migration_api_level", -1);
        }
        return optInt;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0232ed
    public final SparseArray<InterfaceC0207dd> c() {
        SparseArray<InterfaceC0207dd> sparseArray = new SparseArray<>(1);
        sparseArray.put(112, new C0664vk(this.f1088a));
        sparseArray.put(BuildConfig.API_LEVEL, new C0689wk());
        return sparseArray;
    }

    public C0639uk(to toVar) {
        this.f1088a = toVar;
    }
}
