package io.appmetrica.analytics.impl;

import java.util.Collection;
/* loaded from: classes5.dex */
public final class Zd implements to {

    /* renamed from: a  reason: collision with root package name */
    public final String f778a;

    public Zd(String str) {
        this.f778a = str;
    }

    @Override // io.appmetrica.analytics.impl.to
    public final ro a(Collection<Object> collection) {
        if (mo.a((Collection) collection)) {
            return new ro(this, false, this.f778a + " is null or empty.");
        }
        return new ro(this, true, "");
    }
}
