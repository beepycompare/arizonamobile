package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.p7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0495p7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0402le f1175a;

    public C0495p7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0470o7 fromModel(C0544r7 c0544r7) {
        C0470o7 c0470o7 = new C0470o7();
        Long l = c0544r7.f1208a;
        if (l != null) {
            c0470o7.f1153a = l.longValue();
        }
        Long l2 = c0544r7.b;
        if (l2 != null) {
            c0470o7.b = l2.longValue();
        }
        Boolean bool = c0544r7.c;
        if (bool != null) {
            c0470o7.c = this.f1175a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        return c0470o7;
    }

    public C0495p7(C0402le c0402le) {
        this.f1175a = c0402le;
    }

    public /* synthetic */ C0495p7(C0402le c0402le, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0402le() : c0402le);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0544r7 toModel(C0470o7 c0470o7) {
        C0470o7 c0470o72 = new C0470o7();
        Long valueOf = Long.valueOf(c0470o7.f1153a);
        if (valueOf.longValue() == c0470o72.f1153a) {
            valueOf = null;
        }
        Long valueOf2 = Long.valueOf(c0470o7.b);
        return new C0544r7(valueOf, valueOf2.longValue() != c0470o72.b ? valueOf2 : null, this.f1175a.a(c0470o7.c));
    }
}
