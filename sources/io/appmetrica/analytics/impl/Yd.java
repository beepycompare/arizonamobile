package io.appmetrica.analytics.impl;

import java.util.Collection;
/* loaded from: classes5.dex */
public final class Yd implements so {

    /* renamed from: a  reason: collision with root package name */
    public final String f871a;

    public Yd(String str) {
        this.f871a = str;
    }

    @Override // io.appmetrica.analytics.impl.so
    public final qo a(Collection<Object> collection) {
        if (lo.a((Collection) collection)) {
            return new qo(this, false, this.f871a + " is null or empty.");
        }
        return new qo(this, true, "");
    }
}
