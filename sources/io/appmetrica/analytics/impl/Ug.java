package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Ug implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0330io f799a;
    public final Y b;
    public final C0701x6 c;
    public final C0200dm d;
    public final Cif e;
    public final C0347jf f;

    public Ug() {
        this(new C0330io(), new Y(new C0124ao()), new C0701x6(), new C0200dm(), new Cif(), new C0347jf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0442n6 fromModel(Tg tg) {
        C0442n6 c0442n6 = new C0442n6();
        c0442n6.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(tg.f783a, c0442n6.f));
        C0615to c0615to = tg.b;
        if (c0615to != null) {
            C0356jo c0356jo = c0615to.f1226a;
            if (c0356jo != null) {
                c0442n6.f1115a = this.f799a.fromModel(c0356jo);
            }
            X x = c0615to.b;
            if (x != null) {
                c0442n6.b = this.b.fromModel(x);
            }
            List<C0251fm> list = c0615to.c;
            if (list != null) {
                c0442n6.e = this.d.fromModel(list);
            }
            c0442n6.c = (String) WrapUtils.getOrDefault(c0615to.g, c0442n6.c);
            c0442n6.d = this.c.a(c0615to.h);
            if (!TextUtils.isEmpty(c0615to.d)) {
                c0442n6.i = this.e.fromModel(c0615to.d);
            }
            if (!TextUtils.isEmpty(c0615to.e)) {
                c0442n6.j = c0615to.e.getBytes();
            }
            if (!Oo.a(c0615to.f)) {
                c0442n6.k = this.f.fromModel(c0615to.f);
            }
        }
        return c0442n6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0442n6 c0442n6 = (C0442n6) obj;
        throw new UnsupportedOperationException();
    }

    public Ug(C0330io c0330io, Y y, C0701x6 c0701x6, C0200dm c0200dm, Cif cif, C0347jf c0347jf) {
        this.f799a = c0330io;
        this.b = y;
        this.c = c0701x6;
        this.d = c0200dm;
        this.e = cif;
        this.f = c0347jf;
    }

    public final Tg a(C0442n6 c0442n6) {
        throw new UnsupportedOperationException();
    }
}
