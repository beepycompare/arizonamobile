package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.x7  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0692x7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0574se f1199a;

    public C0692x7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0667w7 fromModel(C0742z7 c0742z7) {
        C0667w7 c0667w7 = new C0667w7();
        Long l = c0742z7.f1226a;
        if (l != null) {
            c0667w7.f1181a = l.longValue();
        }
        Long l2 = c0742z7.b;
        if (l2 != null) {
            c0667w7.b = l2.longValue();
        }
        Boolean bool = c0742z7.c;
        if (bool != null) {
            c0667w7.c = this.f1199a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        return c0667w7;
    }

    public C0692x7(C0574se c0574se) {
        this.f1199a = c0574se;
    }

    public /* synthetic */ C0692x7(C0574se c0574se, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0574se() : c0574se);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0742z7 toModel(C0667w7 c0667w7) {
        C0667w7 c0667w72 = new C0667w7();
        Long valueOf = Long.valueOf(c0667w7.f1181a);
        if (valueOf.longValue() == c0667w72.f1181a) {
            valueOf = null;
        }
        Long valueOf2 = Long.valueOf(c0667w7.b);
        return new C0742z7(valueOf, valueOf2.longValue() != c0667w72.b ? valueOf2 : null, this.f1199a.a(c0667w7.c));
    }
}
