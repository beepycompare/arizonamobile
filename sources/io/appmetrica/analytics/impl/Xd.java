package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
/* loaded from: classes4.dex */
public final class Xd {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f717a;

    public Xd(C0182ce c0182ce) {
        this.f717a = c0182ce;
    }

    public final Yd a(Context context, C0262fh c0262fh) {
        return new Yd(context, c0262fh, this.f717a, new InterfaceC0285ge() { // from class: io.appmetrica.analytics.impl.Xd$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0285ge
            public final InterfaceC0137al a(B0 b0) {
                return Xd.a(b0);
            }
        }, EnumC0680wb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, "actual");
    }

    public final Yd b(Context context, C0262fh c0262fh) {
        return new Yd(context, c0262fh, this.f717a, new InterfaceC0285ge() { // from class: io.appmetrica.analytics.impl.Xd$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.InterfaceC0285ge
            public final InterfaceC0137al a(B0 b0) {
                return Xd.b(b0);
            }
        }, EnumC0680wb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, "prev session");
    }

    public static final InterfaceC0137al a(B0 b0) {
        return new Vd(b0.f.d);
    }

    public static final InterfaceC0137al b(B0 b0) {
        return new W();
    }
}
