package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.nd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0451nd {

    /* renamed from: a  reason: collision with root package name */
    public final C0737z0 f1134a;
    public final C0247fd b;
    public final C0625ud c;
    public final IHandlerExecutor d;

    public C0451nd() {
        C0737z0 d = C0135b4.l().d();
        this.f1134a = d;
        this.b = new C0247fd(d);
        this.c = new C0625ud();
        this.d = C0135b4.l().g().a();
    }

    public static final Ia a(C0451nd c0451nd) {
        c0451nd.f1134a.getClass();
        C0712y0 c0712y0 = C0712y0.e;
        Intrinsics.checkNotNull(c0712y0);
        C0349jc i = c0712y0.f().i();
        Intrinsics.checkNotNull(i);
        return i.f1062a;
    }
}
