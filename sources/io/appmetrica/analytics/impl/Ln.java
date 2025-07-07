package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.List;
/* loaded from: classes4.dex */
public final class Ln implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0773zn f523a;
    public final V b;
    public final A6 c;
    public final C0746yl d;
    public final Te e;
    public final Ue f;

    public Ln() {
        this(new C0773zn(), new V(new C0573rn()), new A6(), new C0746yl(), new Te(), new Ue());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0482o6 fromModel(Kn kn) {
        C0482o6 c0482o6 = new C0482o6();
        An an = kn.f509a;
        if (an != null) {
            c0482o6.f968a = this.f523a.fromModel(an);
        }
        U u = kn.b;
        if (u != null) {
            c0482o6.b = this.b.fromModel(u);
        }
        List<Al> list = kn.c;
        if (list != null) {
            c0482o6.e = this.d.fromModel(list);
        }
        String str = kn.g;
        if (str != null) {
            c0482o6.c = str;
        }
        c0482o6.d = this.c.a(kn.h);
        if (!TextUtils.isEmpty(kn.d)) {
            c0482o6.h = this.e.fromModel(kn.d);
        }
        if (!TextUtils.isEmpty(kn.e)) {
            c0482o6.i = kn.e.getBytes();
        }
        if (!fo.a(kn.f)) {
            c0482o6.j = this.f.fromModel(kn.f);
        }
        return c0482o6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0482o6 c0482o6 = (C0482o6) obj;
        throw new UnsupportedOperationException();
    }

    public Ln(C0773zn c0773zn, V v, A6 a6, C0746yl c0746yl, Te te, Ue ue) {
        this.b = v;
        this.f523a = c0773zn;
        this.c = a6;
        this.d = c0746yl;
        this.e = te;
        this.f = ue;
    }

    public final Kn a(C0482o6 c0482o6) {
        throw new UnsupportedOperationException();
    }
}
