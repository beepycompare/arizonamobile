package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
/* loaded from: classes4.dex */
public final class Vd {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f673a;

    public Vd(C0130ae c0130ae) {
        this.f673a = c0130ae;
    }

    public final Wd a(Context context, C0211dh c0211dh) {
        return new Wd(context, c0211dh, this.f673a, new InterfaceC0233ee() { // from class: io.appmetrica.analytics.impl.Vd$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0233ee
            public final Xk a(B0 b0) {
                return Vd.a(b0);
            }
        }, EnumC0628ub.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, "actual");
    }

    public final Wd b(Context context, C0211dh c0211dh) {
        return new Wd(context, c0211dh, this.f673a, new InterfaceC0233ee() { // from class: io.appmetrica.analytics.impl.Vd$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.InterfaceC0233ee
            public final Xk a(B0 b0) {
                return Vd.b(b0);
            }
        }, EnumC0628ub.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, "prev session");
    }

    public static final Xk a(B0 b0) {
        return new Td(b0.f.d);
    }

    public static final Xk b(B0 b0) {
        return new W();
    }
}
