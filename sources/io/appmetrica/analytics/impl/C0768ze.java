package io.appmetrica.analytics.impl;

import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.ze  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0768ze implements Vo {

    /* renamed from: a  reason: collision with root package name */
    public final String f1315a;

    public C0768ze(String str) {
        this.f1315a = str;
    }

    @Override // io.appmetrica.analytics.impl.Vo
    public final To a(Collection<Object> collection) {
        if (Oo.a((Collection) collection)) {
            return new To(this, false, this.f1315a + " is null or empty.");
        }
        return new To(this, true, "");
    }
}
