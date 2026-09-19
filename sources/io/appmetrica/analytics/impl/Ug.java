package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Ug implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0335io f796a;
    public final Y b;
    public final C0706x6 c;
    public final C0205dm d;
    public final Cif e;
    public final C0352jf f;

    public Ug() {
        this(new C0335io(), new Y(new C0129ao()), new C0706x6(), new C0205dm(), new Cif(), new C0352jf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0447n6 fromModel(Tg tg) {
        C0447n6 c0447n6 = new C0447n6();
        c0447n6.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(tg.f780a, c0447n6.f));
        C0620to c0620to = tg.b;
        if (c0620to != null) {
            C0361jo c0361jo = c0620to.f1223a;
            if (c0361jo != null) {
                c0447n6.f1112a = this.f796a.fromModel(c0361jo);
            }
            X x = c0620to.b;
            if (x != null) {
                c0447n6.b = this.b.fromModel(x);
            }
            List<C0256fm> list = c0620to.c;
            if (list != null) {
                c0447n6.e = this.d.fromModel(list);
            }
            c0447n6.c = (String) WrapUtils.getOrDefault(c0620to.g, c0447n6.c);
            c0447n6.d = this.c.a(c0620to.h);
            if (!TextUtils.isEmpty(c0620to.d)) {
                c0447n6.i = this.e.fromModel(c0620to.d);
            }
            if (!TextUtils.isEmpty(c0620to.e)) {
                c0447n6.j = c0620to.e.getBytes();
            }
            if (!Oo.a(c0620to.f)) {
                c0447n6.k = this.f.fromModel(c0620to.f);
            }
        }
        return c0447n6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0447n6 c0447n6 = (C0447n6) obj;
        throw new UnsupportedOperationException();
    }

    public Ug(C0335io c0335io, Y y, C0706x6 c0706x6, C0205dm c0205dm, Cif cif, C0352jf c0352jf) {
        this.f796a = c0335io;
        this.b = y;
        this.c = c0706x6;
        this.d = c0205dm;
        this.e = cif;
        this.f = c0352jf;
    }

    public final Tg a(C0447n6 c0447n6) {
        throw new UnsupportedOperationException();
    }
}
