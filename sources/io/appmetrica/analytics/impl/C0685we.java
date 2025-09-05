package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.we  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0685we implements yo {

    /* renamed from: a  reason: collision with root package name */
    public final String f1134a;

    public C0685we(String str) {
        this.f1134a = str;
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(Object obj) {
        if (obj == null) {
            return new wo(this, false, this.f1134a + " is null.");
        }
        return new wo(this, true, "");
    }

    public final String a() {
        return this.f1134a;
    }
}
