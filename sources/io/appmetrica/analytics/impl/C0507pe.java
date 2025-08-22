package io.appmetrica.analytics.impl;

import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.pe  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0507pe implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final String f1012a;

    public C0507pe(String str) {
        this.f1012a = str;
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final so a(Collection<Object> collection) {
        if (no.a((Collection) collection)) {
            return new so(this, false, this.f1012a + " is null or empty.");
        }
        return new so(this, true, "");
    }
}
