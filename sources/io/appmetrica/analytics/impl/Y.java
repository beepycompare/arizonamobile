package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Y implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0667w7 f757a;
    public final C0595ta b;

    public Y() {
        this(new C0667w7(), new C0595ta(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(Z z) {
        C0188d8 c0188d8 = new C0188d8();
        c0188d8.b = this.f757a.fromModel(z.f770a);
        Nn a2 = this.b.a(z.b);
        c0188d8.f845a = StringUtils.getUTF8Bytes((String) a2.f611a);
        return new Ei(c0188d8, new C0131b3(C0131b3.b(a2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public Y(C0667w7 c0667w7, C0595ta c0595ta) {
        this.f757a = c0667w7;
        this.b = c0595ta;
    }

    public final Z a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
