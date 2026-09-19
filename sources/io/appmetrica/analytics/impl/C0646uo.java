package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.uo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0646uo implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0335io f1240a;
    public final Y b;
    public final C0706x6 c;
    public final C0205dm d;
    public final Cif e;
    public final C0352jf f;

    public C0646uo() {
        this(new C0335io(), new Y(new C0129ao()), new C0706x6(), new C0205dm(), new Cif(), new C0352jf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0395l6 fromModel(C0620to c0620to) {
        C0395l6 c0395l6 = new C0395l6();
        C0361jo c0361jo = c0620to.f1223a;
        if (c0361jo != null) {
            c0395l6.f1077a = this.f1240a.fromModel(c0361jo);
        }
        X x = c0620to.b;
        if (x != null) {
            c0395l6.b = this.b.fromModel(x);
        }
        List<C0256fm> list = c0620to.c;
        if (list != null) {
            c0395l6.e = this.d.fromModel(list);
        }
        String str = c0620to.g;
        if (str != null) {
            c0395l6.c = str;
        }
        c0395l6.d = this.c.a(c0620to.h);
        if (!StringUtils.isNullOrEmpty(c0620to.d)) {
            c0395l6.h = this.e.fromModel(c0620to.d);
        }
        if (!StringUtils.isNullOrEmpty(c0620to.e)) {
            c0395l6.i = c0620to.e.getBytes();
        }
        if (!Oo.a(c0620to.f)) {
            c0395l6.j = this.f.fromModel(c0620to.f);
        }
        return c0395l6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0395l6 c0395l6 = (C0395l6) obj;
        throw new UnsupportedOperationException();
    }

    public C0646uo(C0335io c0335io, Y y, C0706x6 c0706x6, C0205dm c0205dm, Cif cif, C0352jf c0352jf) {
        this.b = y;
        this.f1240a = c0335io;
        this.c = c0706x6;
        this.d = c0205dm;
        this.e = cif;
        this.f = c0352jf;
    }

    public final C0620to a(C0395l6 c0395l6) {
        throw new UnsupportedOperationException();
    }
}
