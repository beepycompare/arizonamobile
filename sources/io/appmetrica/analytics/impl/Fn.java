package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ValidationException;
/* loaded from: classes5.dex */
public class Fn implements to {

    /* renamed from: a  reason: collision with root package name */
    public final to f567a;

    public Fn(to toVar) {
        this.f567a = toVar;
    }

    @Override // io.appmetrica.analytics.impl.to
    public final ro a(Object obj) {
        ro a2 = this.f567a.a(obj);
        if (a2.f1190a) {
            return a2;
        }
        throw new ValidationException(a2.b);
    }

    public final to a() {
        return this.f567a;
    }
}
