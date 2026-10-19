package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* renamed from: io.appmetrica.analytics.impl.t0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0591t0 {

    /* renamed from: a  reason: collision with root package name */
    public final Ao f1210a;
    public volatile Boolean b;
    public InterfaceC0189db c;
    public InterfaceC0214eb d;

    public C0591t0() {
        this(new Ao());
    }

    public final synchronized InterfaceC0189db a(Context context, C0311i4 c0311i4) {
        if (this.c == null) {
            if (a(context)) {
                this.c = new C0695x0();
            } else {
                this.c = new C0565s0(context, c0311i4);
            }
        }
        return this.c;
    }

    public C0591t0(Ao ao) {
        this.f1210a = ao;
    }

    public final boolean a(Context context) {
        Boolean bool = this.b;
        if (bool == null) {
            synchronized (this) {
                bool = this.b;
                if (bool == null) {
                    this.f1210a.getClass();
                    Boolean valueOf = Boolean.valueOf(AndroidUtils.isApiAchieved(24) && !Ao.a(context));
                    this.b = valueOf;
                    if (valueOf.booleanValue()) {
                        ImportantLogger.INSTANCE.info("AppMetrica", "User is locked. So use stubs. Events will not be sent.", new Object[0]);
                    }
                    bool = valueOf;
                }
            }
        }
        return bool.booleanValue();
    }
}
