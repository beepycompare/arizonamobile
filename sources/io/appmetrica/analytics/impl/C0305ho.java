package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ValidationException;
/* renamed from: io.appmetrica.analytics.impl.ho  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0305ho implements Vo {

    /* renamed from: a  reason: collision with root package name */
    public final Vo f1028a;

    public C0305ho(Vo vo) {
        this.f1028a = vo;
    }

    @Override // io.appmetrica.analytics.impl.Vo
    public final To a(Object obj) {
        To a2 = this.f1028a.a(obj);
        if (a2.f787a) {
            return a2;
        }
        throw new ValidationException(a2.b);
    }

    public final Vo a() {
        return this.f1028a;
    }
}
