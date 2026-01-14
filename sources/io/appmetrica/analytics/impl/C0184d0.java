package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.d0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0184d0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final W f948a;
    public final C0293h6 b;

    public C0184d0() {
        this(new W(new C0711xn()), new C0293h6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final S5 fromModel(C0158c0 c0158c0) {
        S5 s5 = new S5();
        s5.f778a = this.f948a.fromModel(c0158c0.f927a);
        String str = c0158c0.b;
        if (str != null) {
            s5.b = str;
        }
        s5.c = this.b.a(c0158c0.c);
        return s5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        S5 s5 = (S5) obj;
        throw new UnsupportedOperationException();
    }

    public C0184d0(W w, C0293h6 c0293h6) {
        this.f948a = w;
        this.b = c0293h6;
    }

    public final C0158c0 a(S5 s5) {
        throw new UnsupportedOperationException();
    }
}
