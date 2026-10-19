package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.uo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0641uo implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0330io f1243a;
    public final Y b;
    public final C0701x6 c;
    public final C0200dm d;
    public final Cif e;
    public final C0347jf f;

    public C0641uo() {
        this(new C0330io(), new Y(new C0124ao()), new C0701x6(), new C0200dm(), new Cif(), new C0347jf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0390l6 fromModel(C0615to c0615to) {
        C0390l6 c0390l6 = new C0390l6();
        C0356jo c0356jo = c0615to.f1226a;
        if (c0356jo != null) {
            c0390l6.f1080a = this.f1243a.fromModel(c0356jo);
        }
        X x = c0615to.b;
        if (x != null) {
            c0390l6.b = this.b.fromModel(x);
        }
        List<C0251fm> list = c0615to.c;
        if (list != null) {
            c0390l6.e = this.d.fromModel(list);
        }
        String str = c0615to.g;
        if (str != null) {
            c0390l6.c = str;
        }
        c0390l6.d = this.c.a(c0615to.h);
        if (!StringUtils.isNullOrEmpty(c0615to.d)) {
            c0390l6.h = this.e.fromModel(c0615to.d);
        }
        if (!StringUtils.isNullOrEmpty(c0615to.e)) {
            c0390l6.i = c0615to.e.getBytes();
        }
        if (!Oo.a(c0615to.f)) {
            c0390l6.j = this.f.fromModel(c0615to.f);
        }
        return c0390l6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0390l6 c0390l6 = (C0390l6) obj;
        throw new UnsupportedOperationException();
    }

    public C0641uo(C0330io c0330io, Y y, C0701x6 c0701x6, C0200dm c0200dm, Cif cif, C0347jf c0347jf) {
        this.b = y;
        this.f1243a = c0330io;
        this.c = c0701x6;
        this.d = c0200dm;
        this.e = cif;
        this.f = c0347jf;
    }

    public final C0615to a(C0390l6 c0390l6) {
        throw new UnsupportedOperationException();
    }
}
