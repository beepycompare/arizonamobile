package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Pg implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0765zn f583a;
    public final V b;
    public final A6 c;
    public final C0738yl d;
    public final Te e;
    public final Ue f;

    public Pg() {
        this(new C0765zn(), new V(new C0565rn()), new A6(), new C0738yl(), new Te(), new Ue());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0524q6 fromModel(Og og) {
        C0524q6 c0524q6 = new C0524q6();
        c0524q6.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(og.f567a, c0524q6.f));
        Kn kn = og.b;
        if (kn != null) {
            An an = kn.f510a;
            if (an != null) {
                c0524q6.f1002a = this.f583a.fromModel(an);
            }
            U u = kn.b;
            if (u != null) {
                c0524q6.b = this.b.fromModel(u);
            }
            List<Al> list = kn.c;
            if (list != null) {
                c0524q6.e = this.d.fromModel(list);
            }
            c0524q6.c = (String) WrapUtils.getOrDefault(kn.g, c0524q6.c);
            c0524q6.d = this.c.a(kn.h);
            if (!TextUtils.isEmpty(kn.d)) {
                c0524q6.i = this.e.fromModel(kn.d);
            }
            if (!TextUtils.isEmpty(kn.e)) {
                c0524q6.j = kn.e.getBytes();
            }
            if (!fo.a(kn.f)) {
                c0524q6.k = this.f.fromModel(kn.f);
            }
        }
        return c0524q6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0524q6 c0524q6 = (C0524q6) obj;
        throw new UnsupportedOperationException();
    }

    public Pg(C0765zn c0765zn, V v, A6 a6, C0738yl c0738yl, Te te, Ue ue) {
        this.f583a = c0765zn;
        this.b = v;
        this.c = a6;
        this.d = c0738yl;
        this.e = te;
        this.f = ue;
    }

    public final Og a(C0524q6 c0524q6) {
        throw new UnsupportedOperationException();
    }
}
