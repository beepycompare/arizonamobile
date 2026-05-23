package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Ce implements Vo {

    /* renamed from: a  reason: collision with root package name */
    public final String f495a;

    public Ce(String str) {
        this.f495a = str;
    }

    @Override // io.appmetrica.analytics.impl.Vo
    public final To a(Object obj) {
        if (obj == null) {
            return new To(this, false, this.f495a + " is null.");
        }
        return new To(this, true, "");
    }

    public final String a() {
        return this.f495a;
    }
}
