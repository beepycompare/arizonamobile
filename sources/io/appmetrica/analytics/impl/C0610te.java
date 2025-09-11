package io.appmetrica.analytics.impl;

import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.te  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0610te implements yo {

    /* renamed from: a  reason: collision with root package name */
    public final String f1095a;

    public C0610te(String str) {
        this.f1095a = str;
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(Collection<Object> collection) {
        if (ro.a((Collection) collection)) {
            return new wo(this, false, this.f1095a + " is null or empty.");
        }
        return new wo(this, true, "");
    }
}
