package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Gf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0577se f598a;
    public final C0703xf b;
    public final C0392l3 c;
    public final If d;
    public final C0573sa e;
    public final C0573sa f;

    public Gf() {
        this(new C0577se(), new C0703xf(), new C0392l3(), new If(), new C0573sa(100), new C0573sa(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(Hf hf) {
        Di di;
        Di di2;
        Di di3;
        Di di4;
        C0447n8 c0447n8 = new C0447n8();
        Mn a2 = this.e.a(hf.f614a);
        c0447n8.f1132a = StringUtils.getUTF8Bytes((String) a2.f700a);
        Mn a3 = this.f.a(hf.b);
        c0447n8.b = StringUtils.getUTF8Bytes((String) a3.f700a);
        List<String> list = hf.c;
        Di di5 = null;
        if (list != null) {
            di = this.c.fromModel(list);
            c0447n8.c = (C0243f8) di.f553a;
        } else {
            di = null;
        }
        Map<String, String> map = hf.d;
        if (map != null) {
            di2 = this.f598a.fromModel(map);
            c0447n8.d = (C0397l8) di2.f553a;
        } else {
            di2 = null;
        }
        C0753zf c0753zf = hf.e;
        if (c0753zf != null) {
            di3 = this.b.fromModel(c0753zf);
            c0447n8.e = (C0422m8) di3.f553a;
        } else {
            di3 = null;
        }
        C0753zf c0753zf2 = hf.f;
        if (c0753zf2 != null) {
            di4 = this.b.fromModel(c0753zf2);
            c0447n8.f = (C0422m8) di4.f553a;
        } else {
            di4 = null;
        }
        List<String> list2 = hf.g;
        if (list2 != null) {
            di5 = this.d.fromModel(list2);
            c0447n8.g = (C0472o8[]) di5.f553a;
        }
        return new Di(c0447n8, new C0109a3(C0109a3.b(a2, a3, di, di2, di3, di4, di5)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public Gf(C0577se c0577se, C0703xf c0703xf, C0392l3 c0392l3, If r4, C0573sa c0573sa, C0573sa c0573sa2) {
        this.f598a = c0577se;
        this.b = c0703xf;
        this.c = c0392l3;
        this.d = r4;
        this.e = c0573sa;
        this.f = c0573sa2;
    }

    public final Hf a(Di di) {
        throw new UnsupportedOperationException();
    }
}
