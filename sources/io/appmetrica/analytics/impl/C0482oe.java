package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.oe  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0482oe implements mo {

    /* renamed from: a  reason: collision with root package name */
    public final String f973a;

    public C0482oe(String str) {
        this.f973a = str;
    }

    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(Object obj) {
        if (obj == null) {
            return new ko(this, false, this.f973a + " is null.");
        }
        return new ko(this, true, "");
    }

    public final String a() {
        return this.f973a;
    }
}
