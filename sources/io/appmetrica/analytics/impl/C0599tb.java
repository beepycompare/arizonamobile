package io.appmetrica.analytics.impl;

import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.tb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0599tb implements Ha {

    /* renamed from: a  reason: collision with root package name */
    public final Ha f1235a;

    public C0599tb(Ha ha) {
        this.f1235a = ha;
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final Ha a(String str, String str2) {
        this.f1235a.a(str, str2);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final void b() {
        this.f1235a.b();
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final boolean getBoolean(String str, boolean z) {
        return this.f1235a.getBoolean(str, z);
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final int getInt(String str, int i) {
        return this.f1235a.getInt(str, i);
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final long getLong(String str, long j) {
        return this.f1235a.getLong(str, j);
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final String getString(String str, String str2) {
        return this.f1235a.getString(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final Ha remove(String str) {
        this.f1235a.remove(str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final Ha a(String str, long j) {
        this.f1235a.a(str, j);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final Ha a(int i, String str) {
        this.f1235a.a(i, str);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final Ha a(String str, boolean z) {
        this.f1235a.a(str, z);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final Ha a(String str, float f) {
        this.f1235a.a(str, f);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final boolean a(String str) {
        return this.f1235a.a(str);
    }

    @Override // io.appmetrica.analytics.impl.Ha
    public final Set a() {
        return this.f1235a.a();
    }
}
