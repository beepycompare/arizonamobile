package io.appmetrica.analytics.impl;

import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.le  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0415le implements mo {

    /* renamed from: a  reason: collision with root package name */
    public final String f922a;

    public C0415le(String str) {
        this.f922a = str;
    }

    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(Collection<Object> collection) {
        if (fo.a((Collection) collection)) {
            return new ko(this, false, this.f922a + " is null or empty.");
        }
        return new ko(this, true, "");
    }
}
