package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.ub  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0620ub implements Ia {

    /* renamed from: a  reason: collision with root package name */
    public final Ia f1245a;

    public C0620ub(Ia ia) {
        this.f1245a = ia;
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final Ia a(String str, String str2) {
        this.f1245a.a(str, str2);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void b() {
        this.f1245a.b();
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final boolean getBoolean(String str, boolean z) {
        return this.f1245a.getBoolean(str, z);
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final int getInt(String str, int i) {
        return this.f1245a.getInt(str, i);
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final long getLong(String str, long j) {
        return this.f1245a.getLong(str, j);
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final String getString(String str, String str2) {
        return this.f1245a.getString(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final Ia remove(String str) {
        this.f1245a.remove(str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final Ia a(String str, long j) {
        this.f1245a.a(str, j);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final Ia a(int i, String str) {
        this.f1245a.a(i, str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final Ia a(String str, boolean z) {
        this.f1245a.a(str, z);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final Ia a(String str, float f) {
        this.f1245a.a(str, f);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final boolean a(String str) {
        return this.f1245a.a(str);
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final Set a() {
        return this.f1245a.a();
    }
}
