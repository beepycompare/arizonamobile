package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ValidationException;
/* loaded from: classes5.dex */
public class En implements so {

    /* renamed from: a  reason: collision with root package name */
    public final so f573a;

    public En(so soVar) {
        this.f573a = soVar;
    }

    @Override // io.appmetrica.analytics.impl.so
    public final qo a(Object obj) {
        qo a2 = this.f573a.a(obj);
        if (a2.f1195a) {
            return a2;
        }
        throw new ValidationException(a2.b);
    }

    public final so a() {
        return this.f573a;
    }
}
