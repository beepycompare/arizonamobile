package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ag  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0125ag implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Me f790a;
    public final Rf b;
    public final K3 c;
    public final C0228eg d;
    public final Sa e;
    public final Sa f;

    public C0125ag() {
        this(new Me(), new Rf(), new K3(), new C0228eg(), new Sa(100), new Sa(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Zi fromModel(C0203dg c0203dg) {
        Zi zi;
        Zi zi2;
        Zi zi3;
        Zi zi4;
        M8 m8 = new M8();
        Sn a2 = this.e.a(c0203dg.f841a);
        m8.f570a = StringUtils.getUTF8Bytes((String) a2.f671a);
        Sn a3 = this.f.a(c0203dg.b);
        m8.b = StringUtils.getUTF8Bytes((String) a3.f671a);
        List<String> list = c0203dg.c;
        Zi zi5 = null;
        if (list != null) {
            zi = this.c.fromModel(list);
            m8.c = (E8) zi.f772a;
        } else {
            zi = null;
        }
        Map<String, String> map = c0203dg.d;
        if (map != null) {
            zi2 = this.f790a.fromModel(map);
            m8.d = (K8) zi2.f772a;
        } else {
            zi2 = null;
        }
        Tf tf = c0203dg.e;
        if (tf != null) {
            zi3 = this.b.fromModel(tf);
            m8.e = (L8) zi3.f772a;
        } else {
            zi3 = null;
        }
        Tf tf2 = c0203dg.f;
        if (tf2 != null) {
            zi4 = this.b.fromModel(tf2);
            m8.f = (L8) zi4.f772a;
        } else {
            zi4 = null;
        }
        List<String> list2 = c0203dg.g;
        if (list2 != null) {
            zi5 = this.d.fromModel(list2);
            m8.g = (N8[]) zi5.f772a;
        }
        return new Zi(m8, new C0749z3(C0749z3.b(a2, a3, zi, zi2, zi3, zi4, zi5)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Zi zi = (Zi) obj;
        throw new UnsupportedOperationException();
    }

    public C0125ag(Me me2, Rf rf, K3 k3, C0228eg c0228eg, Sa sa, Sa sa2) {
        this.f790a = me2;
        this.b = rf;
        this.c = k3;
        this.d = c0228eg;
        this.e = sa;
        this.f = sa2;
    }

    public final C0203dg a(Zi zi) {
        throw new UnsupportedOperationException();
    }
}
