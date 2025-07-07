package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.oe  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0490oe implements mo {

    /* renamed from: a  reason: collision with root package name */
    public final String f972a;

    public C0490oe(String str) {
        this.f972a = str;
    }

    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(Object obj) {
        if (obj == null) {
            return new ko(this, false, this.f972a + " is null.");
        }
        return new ko(this, true, "");
    }

    public final String a() {
        return this.f972a;
    }
}
