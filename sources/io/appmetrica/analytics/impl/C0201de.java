package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
/* renamed from: io.appmetrica.analytics.impl.de  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0201de {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f839a;

    public C0201de(C0330ie c0330ie) {
        this.f839a = c0330ie;
    }

    public final C0226ee a(Context context, C0488oh c0488oh) {
        return new C0226ee(context, c0488oh, this.f839a, new InterfaceC0433me() { // from class: io.appmetrica.analytics.impl.de$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0433me
            public final InterfaceC0362jl a(D0 d0) {
                return C0201de.a(d0);
            }
        }, Bb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, "actual");
    }

    public final C0226ee b(Context context, C0488oh c0488oh) {
        return new C0226ee(context, c0488oh, this.f839a, new InterfaceC0433me() { // from class: io.appmetrica.analytics.impl.de$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.InterfaceC0433me
            public final InterfaceC0362jl a(D0 d0) {
                return C0201de.b(d0);
            }
        }, Bb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, "prev session");
    }

    public static final InterfaceC0362jl a(D0 d0) {
        return new C0149be(d0.f.d);
    }

    public static final InterfaceC0362jl b(D0 d0) {
        return new W();
    }
}
