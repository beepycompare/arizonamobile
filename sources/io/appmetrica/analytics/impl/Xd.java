package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
/* loaded from: classes4.dex */
public final class Xd {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f717a;

    public Xd(C0183ce c0183ce) {
        this.f717a = c0183ce;
    }

    public final Yd a(Context context, C0263fh c0263fh) {
        return new Yd(context, c0263fh, this.f717a, new InterfaceC0286ge() { // from class: io.appmetrica.analytics.impl.Xd$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0286ge
            public final InterfaceC0138al a(B0 b0) {
                return Xd.a(b0);
            }
        }, EnumC0681wb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, "actual");
    }

    public final Yd b(Context context, C0263fh c0263fh) {
        return new Yd(context, c0263fh, this.f717a, new InterfaceC0286ge() { // from class: io.appmetrica.analytics.impl.Xd$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.InterfaceC0286ge
            public final InterfaceC0138al a(B0 b0) {
                return Xd.b(b0);
            }
        }, EnumC0681wb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, "prev session");
    }

    public static final InterfaceC0138al a(B0 b0) {
        return new Vd(b0.f.d);
    }

    public static final InterfaceC0138al b(B0 b0) {
        return new W();
    }
}
