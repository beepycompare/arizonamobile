package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ValidationException;
/* loaded from: classes4.dex */
public class Kn implements yo {

    /* renamed from: a  reason: collision with root package name */
    public final yo f541a;

    public Kn(yo yoVar) {
        this.f541a = yoVar;
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(Object obj) {
        wo a2 = this.f541a.a(obj);
        if (a2.f1141a) {
            return a2;
        }
        throw new ValidationException(a2.b);
    }

    public final yo a() {
        return this.f541a;
    }
}
