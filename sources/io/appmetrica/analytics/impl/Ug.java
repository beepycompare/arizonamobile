package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Ug implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0336io f796a;
    public final Y b;
    public final C0707x6 c;
    public final C0206dm d;
    public final Cif e;
    public final C0353jf f;

    public Ug() {
        this(new C0336io(), new Y(new C0130ao()), new C0707x6(), new C0206dm(), new Cif(), new C0353jf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0448n6 fromModel(Tg tg) {
        C0448n6 c0448n6 = new C0448n6();
        c0448n6.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(tg.f780a, c0448n6.f));
        C0621to c0621to = tg.b;
        if (c0621to != null) {
            C0362jo c0362jo = c0621to.f1223a;
            if (c0362jo != null) {
                c0448n6.f1112a = this.f796a.fromModel(c0362jo);
            }
            X x = c0621to.b;
            if (x != null) {
                c0448n6.b = this.b.fromModel(x);
            }
            List<C0257fm> list = c0621to.c;
            if (list != null) {
                c0448n6.e = this.d.fromModel(list);
            }
            c0448n6.c = (String) WrapUtils.getOrDefault(c0621to.g, c0448n6.c);
            c0448n6.d = this.c.a(c0621to.h);
            if (!TextUtils.isEmpty(c0621to.d)) {
                c0448n6.i = this.e.fromModel(c0621to.d);
            }
            if (!TextUtils.isEmpty(c0621to.e)) {
                c0448n6.j = c0621to.e.getBytes();
            }
            if (!Oo.a(c0621to.f)) {
                c0448n6.k = this.f.fromModel(c0621to.f);
            }
        }
        return c0448n6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0448n6 c0448n6 = (C0448n6) obj;
        throw new UnsupportedOperationException();
    }

    public Ug(C0336io c0336io, Y y, C0707x6 c0707x6, C0206dm c0206dm, Cif cif, C0353jf c0353jf) {
        this.f796a = c0336io;
        this.b = y;
        this.c = c0707x6;
        this.d = c0206dm;
        this.e = cif;
        this.f = c0353jf;
    }

    public final Tg a(C0448n6 c0448n6) {
        throw new UnsupportedOperationException();
    }
}
