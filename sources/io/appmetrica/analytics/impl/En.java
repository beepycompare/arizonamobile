package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ValidationException;
/* loaded from: classes5.dex */
public class En implements so {

    /* renamed from: a  reason: collision with root package name */
    public final so f577a;

    public En(so soVar) {
        this.f577a = soVar;
    }

    @Override // io.appmetrica.analytics.impl.so
    public final qo a(Object obj) {
        qo a2 = this.f577a.a(obj);
        if (a2.f1199a) {
            return a2;
        }
        throw new ValidationException(a2.b);
    }

    public final so a() {
        return this.f577a;
    }
}
