package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* renamed from: io.appmetrica.analytics.impl.t0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0598t0 {

    /* renamed from: a  reason: collision with root package name */
    public final Ao f1205a;
    public volatile Boolean b;
    public InterfaceC0196db c;
    public InterfaceC0221eb d;

    public C0598t0() {
        this(new Ao());
    }

    public final synchronized InterfaceC0196db a(Context context, C0318i4 c0318i4) {
        if (this.c == null) {
            if (a(context)) {
                this.c = new C0702x0();
            } else {
                this.c = new C0572s0(context, c0318i4);
            }
        }
        return this.c;
    }

    public C0598t0(Ao ao) {
        this.f1205a = ao;
    }

    public final boolean a(Context context) {
        Boolean bool = this.b;
        if (bool == null) {
            synchronized (this) {
                bool = this.b;
                if (bool == null) {
                    this.f1205a.getClass();
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
