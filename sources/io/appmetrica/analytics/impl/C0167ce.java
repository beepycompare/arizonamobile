package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ce  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0167ce implements to {

    /* renamed from: a  reason: collision with root package name */
    public final String f929a;

    public C0167ce(String str) {
        this.f929a = str;
    }

    @Override // io.appmetrica.analytics.impl.to
    public final ro a(Object obj) {
        if (obj == null) {
            return new ro(this, false, this.f929a + " is null.");
        }
        return new ro(this, true, "");
    }

    public final String a() {
        return this.f929a;
    }
}
