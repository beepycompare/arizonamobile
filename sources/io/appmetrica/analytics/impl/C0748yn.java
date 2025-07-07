package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ValidationException;
/* renamed from: io.appmetrica.analytics.impl.yn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0748yn implements mo {

    /* renamed from: a  reason: collision with root package name */
    public final mo f1151a;

    public C0748yn(mo moVar) {
        this.f1151a = moVar;
    }

    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(Object obj) {
        ko a2 = this.f1151a.a(obj);
        if (a2.f912a) {
            return a2;
        }
        throw new ValidationException(a2.b);
    }

    public final mo a() {
        return this.f1151a;
    }
}
