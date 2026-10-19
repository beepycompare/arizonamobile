package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Ce implements Vo {

    /* renamed from: a  reason: collision with root package name */
    public final String f501a;

    public Ce(String str) {
        this.f501a = str;
    }

    @Override // io.appmetrica.analytics.impl.Vo
    public final To a(Object obj) {
        if (obj == null) {
            return new To(this, false, this.f501a + " is null.");
        }
        return new To(this, true, "");
    }

    public final String a() {
        return this.f501a;
    }
}
