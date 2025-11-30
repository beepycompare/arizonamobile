package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.q7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0518q7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0425me f1083a;

    public C0518q7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0493p7 fromModel(C0567s7 c0567s7) {
        C0493p7 c0493p7 = new C0493p7();
        Long l = c0567s7.f1115a;
        if (l != null) {
            c0493p7.f1061a = l.longValue();
        }
        Long l2 = c0567s7.b;
        if (l2 != null) {
            c0493p7.b = l2.longValue();
        }
        Boolean bool = c0567s7.c;
        if (bool != null) {
            c0493p7.c = this.f1083a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        return c0493p7;
    }

    public C0518q7(C0425me c0425me) {
        this.f1083a = c0425me;
    }

    public /* synthetic */ C0518q7(C0425me c0425me, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0425me() : c0425me);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0567s7 toModel(C0493p7 c0493p7) {
        C0493p7 c0493p72 = new C0493p7();
        Long valueOf = Long.valueOf(c0493p7.f1061a);
        if (valueOf.longValue() == c0493p72.f1061a) {
            valueOf = null;
        }
        Long valueOf2 = Long.valueOf(c0493p7.b);
        return new C0567s7(valueOf, valueOf2.longValue() != c0493p72.b ? valueOf2 : null, this.f1083a.a(c0493p7.c));
    }
}
