package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qe  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0534qe implements po {

    /* renamed from: a  reason: collision with root package name */
    public final String f1018a;

    public C0534qe(String str) {
        this.f1018a = str;
    }

    @Override // io.appmetrica.analytics.impl.po
    public final no a(Object obj) {
        if (obj == null) {
            return new no(this, false, this.f1018a + " is null.");
        }
        return new no(this, true, "");
    }

    public final String a() {
        return this.f1018a;
    }
}
