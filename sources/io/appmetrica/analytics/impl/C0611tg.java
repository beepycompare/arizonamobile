package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.tg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0611tg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0415lj f1066a;
    public final Na b;
    public final Na c;

    public C0611tg() {
        this(new C0415lj(), new Na(100), new Na(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Qi fromModel(Kg kg) {
        Qi qi;
        J8 j8 = new J8();
        Jn a2 = this.b.a(kg.f522a);
        j8.f501a = StringUtils.getUTF8Bytes((String) a2.f511a);
        Jn a3 = this.c.a(kg.b);
        j8.b = StringUtils.getUTF8Bytes((String) a3.f511a);
        C0515pj c0515pj = kg.c;
        if (c0515pj != null) {
            qi = this.f1066a.fromModel(c0515pj);
            j8.c = (K8) qi.f612a;
        } else {
            qi = null;
        }
        return new Qi(j8, new C0673w3(C0673w3.b(a2, a3, qi)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Qi qi = (Qi) obj;
        throw new UnsupportedOperationException();
    }

    public C0611tg(C0415lj c0415lj, Na na, Na na2) {
        this.f1066a = c0415lj;
        this.b = na;
        this.c = na2;
    }

    public final Kg a(Qi qi) {
        throw new UnsupportedOperationException();
    }
}
