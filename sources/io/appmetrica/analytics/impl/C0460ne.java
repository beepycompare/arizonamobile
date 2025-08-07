package io.appmetrica.analytics.impl;

import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.ne  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0460ne implements po {

    /* renamed from: a  reason: collision with root package name */
    public final String f969a;

    public C0460ne(String str) {
        this.f969a = str;
    }

    @Override // io.appmetrica.analytics.impl.po
    public final no a(Collection<Object> collection) {
        if (io.a((Collection) collection)) {
            return new no(this, false, this.f969a + " is null or empty.");
        }
        return new no(this, true, "");
    }
}
