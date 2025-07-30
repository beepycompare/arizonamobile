package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class L7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ae f530a;

    public L7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final K7 fromModel(N7 n7) {
        K7 k7 = new K7();
        Long l = n7.f561a;
        if (l != null) {
            k7.f518a = l.longValue();
        }
        Long l2 = n7.b;
        if (l2 != null) {
            k7.b = l2.longValue();
        }
        Boolean bool = n7.c;
        if (bool != null) {
            k7.c = this.f530a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        return k7;
    }

    public L7(Ae ae) {
        this.f530a = ae;
    }

    public /* synthetic */ L7(Ae ae, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Ae() : ae);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final N7 toModel(K7 k7) {
        K7 k72 = new K7();
        Long valueOf = Long.valueOf(k7.f518a);
        if (valueOf.longValue() == k72.f518a) {
            valueOf = null;
        }
        Long valueOf2 = Long.valueOf(k7.b);
        return new N7(valueOf, valueOf2.longValue() != k72.b ? valueOf2 : null, this.f530a.a(k7.c));
    }
}
