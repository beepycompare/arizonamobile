package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.od  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0474od {

    /* renamed from: a  reason: collision with root package name */
    public final C0735z0 f1047a;
    public final C0270gd b;
    public final C0648vd c;
    public final IHandlerExecutor d;

    public C0474od() {
        C0735z0 d = C0158c4.l().d();
        this.f1047a = d;
        this.b = new C0270gd(d);
        this.c = new C0648vd();
        this.d = C0158c4.l().g().a();
    }

    public static final Ja a(C0474od c0474od) {
        c0474od.f1047a.getClass();
        C0710y0 c0710y0 = C0710y0.e;
        Intrinsics.checkNotNull(c0710y0);
        C0372kc i = c0710y0.f().i();
        Intrinsics.checkNotNull(i);
        return i.f975a;
    }
}
