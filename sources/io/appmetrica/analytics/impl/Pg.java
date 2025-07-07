package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Pg implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0773zn f582a;
    public final V b;
    public final A6 c;
    public final C0746yl d;
    public final Te e;
    public final Ue f;

    public Pg() {
        this(new C0773zn(), new V(new C0573rn()), new A6(), new C0746yl(), new Te(), new Ue());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0532q6 fromModel(Og og) {
        C0532q6 c0532q6 = new C0532q6();
        c0532q6.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(og.f566a, c0532q6.f));
        Kn kn = og.b;
        if (kn != null) {
            An an = kn.f509a;
            if (an != null) {
                c0532q6.f1001a = this.f582a.fromModel(an);
            }
            U u = kn.b;
            if (u != null) {
                c0532q6.b = this.b.fromModel(u);
            }
            List<Al> list = kn.c;
            if (list != null) {
                c0532q6.e = this.d.fromModel(list);
            }
            c0532q6.c = (String) WrapUtils.getOrDefault(kn.g, c0532q6.c);
            c0532q6.d = this.c.a(kn.h);
            if (!TextUtils.isEmpty(kn.d)) {
                c0532q6.i = this.e.fromModel(kn.d);
            }
            if (!TextUtils.isEmpty(kn.e)) {
                c0532q6.j = kn.e.getBytes();
            }
            if (!fo.a(kn.f)) {
                c0532q6.k = this.f.fromModel(kn.f);
            }
        }
        return c0532q6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0532q6 c0532q6 = (C0532q6) obj;
        throw new UnsupportedOperationException();
    }

    public Pg(C0773zn c0773zn, V v, A6 a6, C0746yl c0746yl, Te te, Ue ue) {
        this.f582a = c0773zn;
        this.b = v;
        this.c = a6;
        this.d = c0746yl;
        this.e = te;
        this.f = ue;
    }

    public final Og a(C0532q6 c0532q6) {
        throw new UnsupportedOperationException();
    }
}
