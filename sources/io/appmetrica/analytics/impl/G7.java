package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class G7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Me f559a;

    public G7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final F7 fromModel(I7 i7) {
        F7 f7 = new F7();
        Long l = i7.f589a;
        if (l != null) {
            f7.f539a = l.longValue();
        }
        Long l2 = i7.b;
        if (l2 != null) {
            f7.b = l2.longValue();
        }
        Boolean bool = i7.c;
        if (bool != null) {
            f7.c = this.f559a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        return f7;
    }

    public G7(Me me2) {
        this.f559a = me2;
    }

    public /* synthetic */ G7(Me me2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Me() : me2);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final I7 toModel(F7 f7) {
        F7 f72 = new F7();
        Long valueOf = Long.valueOf(f7.f539a);
        if (valueOf.longValue() == f72.f539a) {
            valueOf = null;
        }
        Long valueOf2 = Long.valueOf(f7.b);
        return new I7(valueOf, valueOf2.longValue() != f72.b ? valueOf2 : null, this.f559a.a(f7.c));
    }
}
