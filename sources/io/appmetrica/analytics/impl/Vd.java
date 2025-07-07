package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
/* loaded from: classes4.dex */
public final class Vd {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f672a;

    public Vd(C0138ae c0138ae) {
        this.f672a = c0138ae;
    }

    public final Wd a(Context context, C0219dh c0219dh) {
        return new Wd(context, c0219dh, this.f672a, new InterfaceC0241ee() { // from class: io.appmetrica.analytics.impl.Vd$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0241ee
            public final Xk a(B0 b0) {
                return Vd.a(b0);
            }
        }, EnumC0636ub.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, "actual");
    }

    public final Wd b(Context context, C0219dh c0219dh) {
        return new Wd(context, c0219dh, this.f672a, new InterfaceC0241ee() { // from class: io.appmetrica.analytics.impl.Vd$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.InterfaceC0241ee
            public final Xk a(B0 b0) {
                return Vd.b(b0);
            }
        }, EnumC0636ub.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, "prev session");
    }

    public static final Xk a(B0 b0) {
        return new Td(b0.f.d);
    }

    public static final Xk b(B0 b0) {
        return new W();
    }
}
