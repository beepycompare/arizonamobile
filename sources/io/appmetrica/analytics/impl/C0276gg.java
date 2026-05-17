package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.gg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0276gg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Yi f1018a;
    public final C0572sa b;
    public final C0572sa c;

    public C0276gg() {
        this(new Yi(), new C0572sa(100), new C0572sa(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(C0703xg c0703xg) {
        Di di;
        C0496p8 c0496p8 = new C0496p8();
        Mn a2 = this.b.a(c0703xg.f1312a);
        c0496p8.f1176a = StringUtils.getUTF8Bytes((String) a2.f704a);
        Mn a3 = this.c.a(c0703xg.b);
        c0496p8.b = StringUtils.getUTF8Bytes((String) a3.f704a);
        C0176cj c0176cj = c0703xg.c;
        if (c0176cj != null) {
            di = this.f1018a.fromModel(c0176cj);
            c0496p8.c = (C0521q8) di.f557a;
        } else {
            di = null;
        }
        return new Di(c0496p8, new C0108a3(C0108a3.b(a2, a3, di)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public C0276gg(Yi yi, C0572sa c0572sa, C0572sa c0572sa2) {
        this.f1018a = yi;
        this.b = c0572sa;
        this.c = c0572sa2;
    }

    public final C0703xg a(Di di) {
        throw new UnsupportedOperationException();
    }
}
