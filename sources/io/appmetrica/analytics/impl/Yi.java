package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Yi implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0576se f870a;
    public final C0391l3 b;
    public final C0572sa c;
    public final C0572sa d;

    public Yi() {
        this(new C0576se(), new C0391l3(), new C0572sa(100), new C0572sa(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(C0176cj c0176cj) {
        Di di;
        C0521q8 c0521q8 = new C0521q8();
        Mn a2 = this.c.a(c0176cj.f941a);
        c0521q8.f1186a = StringUtils.getUTF8Bytes((String) a2.f699a);
        List<String> list = c0176cj.b;
        Di di2 = null;
        if (list != null) {
            di = this.b.fromModel(list);
            c0521q8.b = (C0242f8) di.f552a;
        } else {
            di = null;
        }
        Mn a3 = this.d.a(c0176cj.c);
        c0521q8.c = StringUtils.getUTF8Bytes((String) a3.f699a);
        Map<String, String> map = c0176cj.d;
        if (map != null) {
            di2 = this.f870a.fromModel(map);
            c0521q8.d = (C0396l8) di2.f552a;
        }
        return new Di(c0521q8, new C0108a3(C0108a3.b(a2, di, a3, di2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public Yi(C0576se c0576se, C0391l3 c0391l3, C0572sa c0572sa, C0572sa c0572sa2) {
        this.f870a = c0576se;
        this.b = c0391l3;
        this.c = c0572sa;
        this.d = c0572sa2;
    }

    public final C0176cj a(Di di) {
        throw new UnsupportedOperationException();
    }
}
