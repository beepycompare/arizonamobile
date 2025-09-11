package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class P7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ge f621a;

    public P7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final O7 fromModel(R7 r7) {
        O7 o7 = new O7();
        Long l = r7.f651a;
        if (l != null) {
            o7.f604a = l.longValue();
        }
        Long l2 = r7.b;
        if (l2 != null) {
            o7.b = l2.longValue();
        }
        Boolean bool = r7.c;
        if (bool != null) {
            o7.c = this.f621a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        return o7;
    }

    public P7(Ge ge) {
        this.f621a = ge;
    }

    public /* synthetic */ P7(Ge ge, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Ge() : ge);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final R7 toModel(O7 o7) {
        O7 o72 = new O7();
        Long valueOf = Long.valueOf(o7.f604a);
        if (valueOf.longValue() == o72.f604a) {
            valueOf = null;
        }
        Long valueOf2 = Long.valueOf(o7.b);
        return new R7(valueOf, valueOf2.longValue() != o72.b ? valueOf2 : null, this.f621a.a(o7.c));
    }
}
