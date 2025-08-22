package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.se  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0581se implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final String f1060a;

    public C0581se(String str) {
        this.f1060a = str;
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final so a(Object obj) {
        if (obj == null) {
            return new so(this, false, this.f1060a + " is null.");
        }
        return new so(this, true, "");
    }

    public final String a() {
        return this.f1060a;
    }
}
