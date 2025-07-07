package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class I7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0739ye f471a;

    public I7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final H7 fromModel(K7 k7) {
        H7 h7 = new H7();
        Long l = k7.f502a;
        if (l != null) {
            h7.f456a = l.longValue();
        }
        Long l2 = k7.b;
        if (l2 != null) {
            h7.b = l2.longValue();
        }
        Boolean bool = k7.c;
        if (bool != null) {
            h7.c = this.f471a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        return h7;
    }

    public I7(C0739ye c0739ye) {
        this.f471a = c0739ye;
    }

    public /* synthetic */ I7(C0739ye c0739ye, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0739ye() : c0739ye);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final K7 toModel(H7 h7) {
        H7 h72 = new H7();
        Long valueOf = Long.valueOf(h7.f456a);
        if (valueOf.longValue() == h72.f456a) {
            valueOf = null;
        }
        Long valueOf2 = Long.valueOf(h7.b);
        return new K7(valueOf, valueOf2.longValue() != h72.b ? valueOf2 : null, this.f471a.a(h7.c));
    }
}
