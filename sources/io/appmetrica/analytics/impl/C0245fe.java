package io.appmetrica.analytics.impl;

import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.fe  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0245fe implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final String f876a;

    public C0245fe(String str) {
        this.f876a = str;
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final so a(Collection<Object> collection) {
        if (no.a((Collection) collection)) {
            return new so(this, false, this.f876a + " is null or empty.");
        }
        return new so(this, true, "");
    }
}
