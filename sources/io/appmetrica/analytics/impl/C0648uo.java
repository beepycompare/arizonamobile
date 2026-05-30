package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.uo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0648uo implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0337io f1238a;
    public final Y b;
    public final C0708x6 c;
    public final C0207dm d;
    public final Cif e;
    public final C0354jf f;

    public C0648uo() {
        this(new C0337io(), new Y(new C0131ao()), new C0708x6(), new C0207dm(), new Cif(), new C0354jf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0397l6 fromModel(C0622to c0622to) {
        C0397l6 c0397l6 = new C0397l6();
        C0363jo c0363jo = c0622to.f1221a;
        if (c0363jo != null) {
            c0397l6.f1075a = this.f1238a.fromModel(c0363jo);
        }
        X x = c0622to.b;
        if (x != null) {
            c0397l6.b = this.b.fromModel(x);
        }
        List<C0258fm> list = c0622to.c;
        if (list != null) {
            c0397l6.e = this.d.fromModel(list);
        }
        String str = c0622to.g;
        if (str != null) {
            c0397l6.c = str;
        }
        c0397l6.d = this.c.a(c0622to.h);
        if (!StringUtils.isNullOrEmpty(c0622to.d)) {
            c0397l6.h = this.e.fromModel(c0622to.d);
        }
        if (!StringUtils.isNullOrEmpty(c0622to.e)) {
            c0397l6.i = c0622to.e.getBytes();
        }
        if (!Oo.a(c0622to.f)) {
            c0397l6.j = this.f.fromModel(c0622to.f);
        }
        return c0397l6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0397l6 c0397l6 = (C0397l6) obj;
        throw new UnsupportedOperationException();
    }

    public C0648uo(C0337io c0337io, Y y, C0708x6 c0708x6, C0207dm c0207dm, Cif cif, C0354jf c0354jf) {
        this.b = y;
        this.f1238a = c0337io;
        this.c = c0708x6;
        this.d = c0207dm;
        this.e = cif;
        this.f = c0354jf;
    }

    public final C0622to a(C0397l6 c0397l6) {
        throw new UnsupportedOperationException();
    }
}
