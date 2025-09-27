package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.we  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0685we implements yo {

    /* renamed from: a  reason: collision with root package name */
    public final String f1139a;

    public C0685we(String str) {
        this.f1139a = str;
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(Object obj) {
        if (obj == null) {
            return new wo(this, false, this.f1139a + " is null.");
        }
        return new wo(this, true, "");
    }

    public final String a() {
        return this.f1139a;
    }
}
