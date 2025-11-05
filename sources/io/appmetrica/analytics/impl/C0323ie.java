package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ie  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0323ie implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final String f934a;

    public C0323ie(String str) {
        this.f934a = str;
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final so a(Object obj) {
        if (obj == null) {
            return new so(this, false, this.f934a + " is null.");
        }
        return new so(this, true, "");
    }

    public final String a() {
        return this.f934a;
    }
}
