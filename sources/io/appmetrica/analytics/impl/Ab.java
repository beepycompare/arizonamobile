package io.appmetrica.analytics.impl;

import java.util.Set;
/* loaded from: classes5.dex */
public final class Ab implements Oa {

    /* renamed from: a  reason: collision with root package name */
    public final Oa f394a;

    public Ab(Oa oa) {
        this.f394a = oa;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Oa a(String str, String str2) {
        this.f394a.a(str, str2);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final void b() {
        this.f394a.b();
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final boolean getBoolean(String str, boolean z) {
        return this.f394a.getBoolean(str, z);
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final int getInt(String str, int i) {
        return this.f394a.getInt(str, i);
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final long getLong(String str, long j) {
        return this.f394a.getLong(str, j);
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final String getString(String str, String str2) {
        return this.f394a.getString(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Oa remove(String str) {
        this.f394a.remove(str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Oa a(String str, long j) {
        this.f394a.a(str, j);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Oa a(int i, String str) {
        this.f394a.a(i, str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Oa a(String str, boolean z) {
        this.f394a.a(str, z);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Oa a(String str, float f) {
        this.f394a.a(str, f);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final boolean a(String str) {
        return this.f394a.a(str);
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final Set a() {
        return this.f394a.a();
    }
}
