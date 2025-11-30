package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ValidationException;
/* loaded from: classes5.dex */
public class Fn implements to {

    /* renamed from: a  reason: collision with root package name */
    public final to f484a;

    public Fn(to toVar) {
        this.f484a = toVar;
    }

    @Override // io.appmetrica.analytics.impl.to
    public final ro a(Object obj) {
        ro a2 = this.f484a.a(obj);
        if (a2.f1107a) {
            return a2;
        }
        throw new ValidationException(a2.b);
    }

    public final to a() {
        return this.f484a;
    }
}
