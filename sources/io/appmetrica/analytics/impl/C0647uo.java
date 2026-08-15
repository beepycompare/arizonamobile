package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.uo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0647uo implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0336io f1240a;
    public final Y b;
    public final C0707x6 c;
    public final C0206dm d;
    public final Cif e;
    public final C0353jf f;

    public C0647uo() {
        this(new C0336io(), new Y(new C0130ao()), new C0707x6(), new C0206dm(), new Cif(), new C0353jf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0396l6 fromModel(C0621to c0621to) {
        C0396l6 c0396l6 = new C0396l6();
        C0362jo c0362jo = c0621to.f1223a;
        if (c0362jo != null) {
            c0396l6.f1077a = this.f1240a.fromModel(c0362jo);
        }
        X x = c0621to.b;
        if (x != null) {
            c0396l6.b = this.b.fromModel(x);
        }
        List<C0257fm> list = c0621to.c;
        if (list != null) {
            c0396l6.e = this.d.fromModel(list);
        }
        String str = c0621to.g;
        if (str != null) {
            c0396l6.c = str;
        }
        c0396l6.d = this.c.a(c0621to.h);
        if (!StringUtils.isNullOrEmpty(c0621to.d)) {
            c0396l6.h = this.e.fromModel(c0621to.d);
        }
        if (!StringUtils.isNullOrEmpty(c0621to.e)) {
            c0396l6.i = c0621to.e.getBytes();
        }
        if (!Oo.a(c0621to.f)) {
            c0396l6.j = this.f.fromModel(c0621to.f);
        }
        return c0396l6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0396l6 c0396l6 = (C0396l6) obj;
        throw new UnsupportedOperationException();
    }

    public C0647uo(C0336io c0336io, Y y, C0707x6 c0707x6, C0206dm c0206dm, Cif cif, C0353jf c0353jf) {
        this.b = y;
        this.f1240a = c0336io;
        this.c = c0707x6;
        this.d = c0206dm;
        this.e = cif;
        this.f = c0353jf;
    }

    public final C0621to a(C0396l6 c0396l6) {
        throw new UnsupportedOperationException();
    }
}
