package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ValidationException;
/* loaded from: classes4.dex */
public class Bn implements po {

    /* renamed from: a  reason: collision with root package name */
    public final po f365a;

    public Bn(po poVar) {
        this.f365a = poVar;
    }

    @Override // io.appmetrica.analytics.impl.po
    public final no a(Object obj) {
        no a2 = this.f365a.a(obj);
        if (a2.f976a) {
            return a2;
        }
        throw new ValidationException(a2.b);
    }

    public final po a() {
        return this.f365a;
    }
}
