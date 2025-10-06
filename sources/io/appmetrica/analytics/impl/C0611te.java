package io.appmetrica.analytics.impl;

import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.te  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0611te implements yo {

    /* renamed from: a  reason: collision with root package name */
    public final String f1096a;

    public C0611te(String str) {
        this.f1096a = str;
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(Collection<Object> collection) {
        if (ro.a((Collection) collection)) {
            return new wo(this, false, this.f1096a + " is null or empty.");
        }
        return new wo(this, true, "");
    }
}
