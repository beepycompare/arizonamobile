package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.q7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0517q7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0424me f1180a;

    public C0517q7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0492p7 fromModel(C0566s7 c0566s7) {
        C0492p7 c0492p7 = new C0492p7();
        Long l = c0566s7.f1212a;
        if (l != null) {
            c0492p7.f1158a = l.longValue();
        }
        Long l2 = c0566s7.b;
        if (l2 != null) {
            c0492p7.b = l2.longValue();
        }
        Boolean bool = c0566s7.c;
        if (bool != null) {
            c0492p7.c = this.f1180a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        return c0492p7;
    }

    public C0517q7(C0424me c0424me) {
        this.f1180a = c0424me;
    }

    public /* synthetic */ C0517q7(C0424me c0424me, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0424me() : c0424me);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0566s7 toModel(C0492p7 c0492p7) {
        C0492p7 c0492p72 = new C0492p7();
        Long valueOf = Long.valueOf(c0492p7.f1158a);
        if (valueOf.longValue() == c0492p72.f1158a) {
            valueOf = null;
        }
        Long valueOf2 = Long.valueOf(c0492p7.b);
        return new C0566s7(valueOf, valueOf2.longValue() != c0492p72.b ? valueOf2 : null, this.f1180a.a(c0492p7.c));
    }
}
