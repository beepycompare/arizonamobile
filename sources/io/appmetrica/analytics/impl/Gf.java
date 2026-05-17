package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Gf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0576se f602a;
    public final C0702xf b;
    public final C0391l3 c;
    public final If d;
    public final C0572sa e;
    public final C0572sa f;

    public Gf() {
        this(new C0576se(), new C0702xf(), new C0391l3(), new If(), new C0572sa(100), new C0572sa(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(Hf hf) {
        Di di;
        Di di2;
        Di di3;
        Di di4;
        C0446n8 c0446n8 = new C0446n8();
        Mn a2 = this.e.a(hf.f618a);
        c0446n8.f1136a = StringUtils.getUTF8Bytes((String) a2.f704a);
        Mn a3 = this.f.a(hf.b);
        c0446n8.b = StringUtils.getUTF8Bytes((String) a3.f704a);
        List<String> list = hf.c;
        Di di5 = null;
        if (list != null) {
            di = this.c.fromModel(list);
            c0446n8.c = (C0242f8) di.f557a;
        } else {
            di = null;
        }
        Map<String, String> map = hf.d;
        if (map != null) {
            di2 = this.f602a.fromModel(map);
            c0446n8.d = (C0396l8) di2.f557a;
        } else {
            di2 = null;
        }
        C0752zf c0752zf = hf.e;
        if (c0752zf != null) {
            di3 = this.b.fromModel(c0752zf);
            c0446n8.e = (C0421m8) di3.f557a;
        } else {
            di3 = null;
        }
        C0752zf c0752zf2 = hf.f;
        if (c0752zf2 != null) {
            di4 = this.b.fromModel(c0752zf2);
            c0446n8.f = (C0421m8) di4.f557a;
        } else {
            di4 = null;
        }
        List<String> list2 = hf.g;
        if (list2 != null) {
            di5 = this.d.fromModel(list2);
            c0446n8.g = (C0471o8[]) di5.f557a;
        }
        return new Di(c0446n8, new C0108a3(C0108a3.b(a2, a3, di, di2, di3, di4, di5)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public Gf(C0576se c0576se, C0702xf c0702xf, C0391l3 c0391l3, If r4, C0572sa c0572sa, C0572sa c0572sa2) {
        this.f602a = c0576se;
        this.b = c0702xf;
        this.c = c0391l3;
        this.d = r4;
        this.e = c0572sa;
        this.f = c0572sa2;
    }

    public final Hf a(Di di) {
        throw new UnsupportedOperationException();
    }
}
