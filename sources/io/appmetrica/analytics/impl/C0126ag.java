package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ag  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0126ag implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Me f795a;
    public final Rf b;
    public final K3 c;
    public final C0229eg d;
    public final Sa e;
    public final Sa f;

    public C0126ag() {
        this(new Me(), new Rf(), new K3(), new C0229eg(), new Sa(100), new Sa(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Zi fromModel(C0204dg c0204dg) {
        Zi zi;
        Zi zi2;
        Zi zi3;
        Zi zi4;
        M8 m8 = new M8();
        Sn a2 = this.e.a(c0204dg.f846a);
        m8.f575a = StringUtils.getUTF8Bytes((String) a2.f676a);
        Sn a3 = this.f.a(c0204dg.b);
        m8.b = StringUtils.getUTF8Bytes((String) a3.f676a);
        List<String> list = c0204dg.c;
        Zi zi5 = null;
        if (list != null) {
            zi = this.c.fromModel(list);
            m8.c = (E8) zi.f777a;
        } else {
            zi = null;
        }
        Map<String, String> map = c0204dg.d;
        if (map != null) {
            zi2 = this.f795a.fromModel(map);
            m8.d = (K8) zi2.f777a;
        } else {
            zi2 = null;
        }
        Tf tf = c0204dg.e;
        if (tf != null) {
            zi3 = this.b.fromModel(tf);
            m8.e = (L8) zi3.f777a;
        } else {
            zi3 = null;
        }
        Tf tf2 = c0204dg.f;
        if (tf2 != null) {
            zi4 = this.b.fromModel(tf2);
            m8.f = (L8) zi4.f777a;
        } else {
            zi4 = null;
        }
        List<String> list2 = c0204dg.g;
        if (list2 != null) {
            zi5 = this.d.fromModel(list2);
            m8.g = (N8[]) zi5.f777a;
        }
        return new Zi(m8, new C0750z3(C0750z3.b(a2, a3, zi, zi2, zi3, zi4, zi5)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Zi zi = (Zi) obj;
        throw new UnsupportedOperationException();
    }

    public C0126ag(Me me2, Rf rf, K3 k3, C0229eg c0229eg, Sa sa, Sa sa2) {
        this.f795a = me2;
        this.b = rf;
        this.c = k3;
        this.d = c0229eg;
        this.e = sa;
        this.f = sa2;
    }

    public final C0204dg a(Zi zi) {
        throw new UnsupportedOperationException();
    }
}
