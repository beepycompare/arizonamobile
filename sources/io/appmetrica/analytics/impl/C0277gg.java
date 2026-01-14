package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.gg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0277gg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Yi f1014a;
    public final C0573sa b;
    public final C0573sa c;

    public C0277gg() {
        this(new Yi(), new C0573sa(100), new C0573sa(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(C0704xg c0704xg) {
        Di di;
        C0497p8 c0497p8 = new C0497p8();
        Mn a2 = this.b.a(c0704xg.f1308a);
        c0497p8.f1172a = StringUtils.getUTF8Bytes((String) a2.f700a);
        Mn a3 = this.c.a(c0704xg.b);
        c0497p8.b = StringUtils.getUTF8Bytes((String) a3.f700a);
        C0177cj c0177cj = c0704xg.c;
        if (c0177cj != null) {
            di = this.f1014a.fromModel(c0177cj);
            c0497p8.c = (C0522q8) di.f553a;
        } else {
            di = null;
        }
        return new Di(c0497p8, new C0109a3(C0109a3.b(a2, a3, di)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public C0277gg(Yi yi, C0573sa c0573sa, C0573sa c0573sa2) {
        this.f1014a = yi;
        this.b = c0573sa;
        this.c = c0573sa2;
    }

    public final C0704xg a(Di di) {
        throw new UnsupportedOperationException();
    }
}
