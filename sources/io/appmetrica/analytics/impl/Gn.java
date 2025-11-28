package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ValidationException;
/* loaded from: classes5.dex */
public class Gn implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final uo f497a;

    public Gn(uo uoVar) {
        this.f497a = uoVar;
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final so a(Object obj) {
        so a2 = this.f497a.a(obj);
        if (a2.f1120a) {
            return a2;
        }
        throw new ValidationException(a2.b);
    }

    public final uo a() {
        return this.f497a;
    }
}
