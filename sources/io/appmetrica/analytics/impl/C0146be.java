package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.be  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0146be implements so {

    /* renamed from: a  reason: collision with root package name */
    public final String f921a;

    public C0146be(String str) {
        this.f921a = str;
    }

    @Override // io.appmetrica.analytics.impl.so
    public final qo a(Object obj) {
        if (obj == null) {
            return new qo(this, false, this.f921a + " is null.");
        }
        return new qo(this, true, "");
    }

    public final String a() {
        return this.f921a;
    }
}
