package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
/* renamed from: io.appmetrica.analytics.impl.de  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0202de {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f844a;

    public C0202de(C0331ie c0331ie) {
        this.f844a = c0331ie;
    }

    public final C0227ee a(Context context, C0489oh c0489oh) {
        return new C0227ee(context, c0489oh, this.f844a, new InterfaceC0434me() { // from class: io.appmetrica.analytics.impl.de$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC0434me
            public final InterfaceC0363jl a(D0 d0) {
                return C0202de.a(d0);
            }
        }, Bb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, "actual");
    }

    public final C0227ee b(Context context, C0489oh c0489oh) {
        return new C0227ee(context, c0489oh, this.f844a, new InterfaceC0434me() { // from class: io.appmetrica.analytics.impl.de$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.InterfaceC0434me
            public final InterfaceC0363jl a(D0 d0) {
                return C0202de.b(d0);
            }
        }, Bb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, "prev session");
    }

    public static final InterfaceC0363jl a(D0 d0) {
        return new C0150be(d0.f.d);
    }

    public static final InterfaceC0363jl b(D0 d0) {
        return new W();
    }
}
