package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.p7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0496p7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0403le f1170a;

    public C0496p7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0471o7 fromModel(C0545r7 c0545r7) {
        C0471o7 c0471o7 = new C0471o7();
        Long l = c0545r7.f1203a;
        if (l != null) {
            c0471o7.f1148a = l.longValue();
        }
        Long l2 = c0545r7.b;
        if (l2 != null) {
            c0471o7.b = l2.longValue();
        }
        Boolean bool = c0545r7.c;
        if (bool != null) {
            c0471o7.c = this.f1170a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        return c0471o7;
    }

    public C0496p7(C0403le c0403le) {
        this.f1170a = c0403le;
    }

    public /* synthetic */ C0496p7(C0403le c0403le, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0403le() : c0403le);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0545r7 toModel(C0471o7 c0471o7) {
        C0471o7 c0471o72 = new C0471o7();
        Long valueOf = Long.valueOf(c0471o7.f1148a);
        if (valueOf.longValue() == c0471o72.f1148a) {
            valueOf = null;
        }
        Long valueOf2 = Long.valueOf(c0471o7.b);
        return new C0545r7(valueOf, valueOf2.longValue() != c0471o72.b ? valueOf2 : null, this.f1170a.a(c0471o7.c));
    }
}
