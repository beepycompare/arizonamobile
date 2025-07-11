package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.List;
/* loaded from: classes4.dex */
public final class Ln implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0765zn f524a;
    public final V b;
    public final A6 c;
    public final C0738yl d;
    public final Te e;
    public final Ue f;

    public Ln() {
        this(new C0765zn(), new V(new C0565rn()), new A6(), new C0738yl(), new Te(), new Ue());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0474o6 fromModel(Kn kn) {
        C0474o6 c0474o6 = new C0474o6();
        An an = kn.f510a;
        if (an != null) {
            c0474o6.f969a = this.f524a.fromModel(an);
        }
        U u = kn.b;
        if (u != null) {
            c0474o6.b = this.b.fromModel(u);
        }
        List<Al> list = kn.c;
        if (list != null) {
            c0474o6.e = this.d.fromModel(list);
        }
        String str = kn.g;
        if (str != null) {
            c0474o6.c = str;
        }
        c0474o6.d = this.c.a(kn.h);
        if (!TextUtils.isEmpty(kn.d)) {
            c0474o6.h = this.e.fromModel(kn.d);
        }
        if (!TextUtils.isEmpty(kn.e)) {
            c0474o6.i = kn.e.getBytes();
        }
        if (!fo.a(kn.f)) {
            c0474o6.j = this.f.fromModel(kn.f);
        }
        return c0474o6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0474o6 c0474o6 = (C0474o6) obj;
        throw new UnsupportedOperationException();
    }

    public Ln(C0765zn c0765zn, V v, A6 a6, C0738yl c0738yl, Te te, Ue ue) {
        this.b = v;
        this.f524a = c0765zn;
        this.c = a6;
        this.d = c0738yl;
        this.e = te;
        this.f = ue;
    }

    public final Kn a(C0474o6 c0474o6) {
        throw new UnsupportedOperationException();
    }
}
