package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Yi implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0577se f870a;
    public final C0392l3 b;
    public final C0573sa c;
    public final C0573sa d;

    public Yi() {
        this(new C0577se(), new C0392l3(), new C0573sa(100), new C0573sa(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(C0177cj c0177cj) {
        Di di;
        C0522q8 c0522q8 = new C0522q8();
        Mn a2 = this.c.a(c0177cj.f941a);
        c0522q8.f1186a = StringUtils.getUTF8Bytes((String) a2.f699a);
        List<String> list = c0177cj.b;
        Di di2 = null;
        if (list != null) {
            di = this.b.fromModel(list);
            c0522q8.b = (C0243f8) di.f552a;
        } else {
            di = null;
        }
        Mn a3 = this.d.a(c0177cj.c);
        c0522q8.c = StringUtils.getUTF8Bytes((String) a3.f699a);
        Map<String, String> map = c0177cj.d;
        if (map != null) {
            di2 = this.f870a.fromModel(map);
            c0522q8.d = (C0397l8) di2.f552a;
        }
        return new Di(c0522q8, new C0109a3(C0109a3.b(a2, di, a3, di2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public Yi(C0577se c0577se, C0392l3 c0392l3, C0573sa c0573sa, C0573sa c0573sa2) {
        this.f870a = c0577se;
        this.b = c0392l3;
        this.c = c0573sa;
        this.d = c0573sa2;
    }

    public final C0177cj a(Di di) {
        throw new UnsupportedOperationException();
    }
}
