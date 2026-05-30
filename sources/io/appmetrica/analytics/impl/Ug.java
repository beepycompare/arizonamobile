package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Ug implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0337io f794a;
    public final Y b;
    public final C0708x6 c;
    public final C0207dm d;
    public final Cif e;
    public final C0354jf f;

    public Ug() {
        this(new C0337io(), new Y(new C0131ao()), new C0708x6(), new C0207dm(), new Cif(), new C0354jf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0449n6 fromModel(Tg tg) {
        C0449n6 c0449n6 = new C0449n6();
        c0449n6.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(tg.f778a, c0449n6.f));
        C0622to c0622to = tg.b;
        if (c0622to != null) {
            C0363jo c0363jo = c0622to.f1221a;
            if (c0363jo != null) {
                c0449n6.f1110a = this.f794a.fromModel(c0363jo);
            }
            X x = c0622to.b;
            if (x != null) {
                c0449n6.b = this.b.fromModel(x);
            }
            List<C0258fm> list = c0622to.c;
            if (list != null) {
                c0449n6.e = this.d.fromModel(list);
            }
            c0449n6.c = (String) WrapUtils.getOrDefault(c0622to.g, c0449n6.c);
            c0449n6.d = this.c.a(c0622to.h);
            if (!TextUtils.isEmpty(c0622to.d)) {
                c0449n6.i = this.e.fromModel(c0622to.d);
            }
            if (!TextUtils.isEmpty(c0622to.e)) {
                c0449n6.j = c0622to.e.getBytes();
            }
            if (!Oo.a(c0622to.f)) {
                c0449n6.k = this.f.fromModel(c0622to.f);
            }
        }
        return c0449n6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0449n6 c0449n6 = (C0449n6) obj;
        throw new UnsupportedOperationException();
    }

    public Ug(C0337io c0337io, Y y, C0708x6 c0708x6, C0207dm c0207dm, Cif cif, C0354jf c0354jf) {
        this.f794a = c0337io;
        this.b = y;
        this.c = c0708x6;
        this.d = c0207dm;
        this.e = cif;
        this.f = c0354jf;
    }

    public final Tg a(C0449n6 c0449n6) {
        throw new UnsupportedOperationException();
    }
}
