package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
/* loaded from: classes4.dex */
public final class Zd {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f757a;

    public Zd(C0226ee c0226ee) {
        this.f757a = c0226ee;
    }

    public final C0123ae a(Context context, C0384kh c0384kh) {
        return new C0123ae(context, c0384kh, this.f757a, new InterfaceC0330ie() { // from class: io.appmetrica.analytics.impl.Zd$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.InterfaceC0330ie
            public final InterfaceC0259fl a(B0 b0) {
                return Zd.a(b0);
            }
        }, EnumC0728yb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, "actual");
    }

    public final C0123ae b(Context context, C0384kh c0384kh) {
        return new C0123ae(context, c0384kh, this.f757a, new InterfaceC0330ie() { // from class: io.appmetrica.analytics.impl.Zd$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0330ie
            public final InterfaceC0259fl a(B0 b0) {
                return Zd.b(b0);
            }
        }, EnumC0728yb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, "prev session");
    }

    public static final InterfaceC0259fl a(B0 b0) {
        return new Xd(b0.f.d);
    }

    public static final InterfaceC0259fl b(B0 b0) {
        return new W();
    }
}
