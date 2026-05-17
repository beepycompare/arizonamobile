package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.d0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0183d0 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final W f952a;
    public final C0292h6 b;

    public C0183d0() {
        this(new W(new C0710xn()), new C0292h6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final S5 fromModel(C0157c0 c0157c0) {
        S5 s5 = new S5();
        s5.f782a = this.f952a.fromModel(c0157c0.f931a);
        String str = c0157c0.b;
        if (str != null) {
            s5.b = str;
        }
        s5.c = this.b.a(c0157c0.c);
        return s5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        S5 s5 = (S5) obj;
        throw new UnsupportedOperationException();
    }

    public C0183d0(W w, C0292h6 c0292h6) {
        this.f952a = w;
        this.b = c0292h6;
    }

    public final C0157c0 a(S5 s5) {
        throw new UnsupportedOperationException();
    }
}
