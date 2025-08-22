package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class M7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ce f556a;

    public M7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final L7 fromModel(O7 o7) {
        L7 l7 = new L7();
        Long l = o7.f587a;
        if (l != null) {
            l7.f538a = l.longValue();
        }
        Long l2 = o7.b;
        if (l2 != null) {
            l7.b = l2.longValue();
        }
        Boolean bool = o7.c;
        if (bool != null) {
            l7.c = this.f556a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        return l7;
    }

    public M7(Ce ce) {
        this.f556a = ce;
    }

    public /* synthetic */ M7(Ce ce, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Ce() : ce);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final O7 toModel(L7 l7) {
        L7 l72 = new L7();
        Long valueOf = Long.valueOf(l7.f538a);
        if (valueOf.longValue() == l72.f538a) {
            valueOf = null;
        }
        Long valueOf2 = Long.valueOf(l7.b);
        return new O7(valueOf, valueOf2.longValue() != l72.b ? valueOf2 : null, this.f556a.a(l7.c));
    }
}
