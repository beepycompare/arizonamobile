package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* renamed from: io.appmetrica.analytics.impl.t0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0597t0 {

    /* renamed from: a  reason: collision with root package name */
    public final Ao f1207a;
    public volatile Boolean b;
    public InterfaceC0195db c;
    public InterfaceC0220eb d;

    public C0597t0() {
        this(new Ao());
    }

    public final synchronized InterfaceC0195db a(Context context, C0317i4 c0317i4) {
        if (this.c == null) {
            if (a(context)) {
                this.c = new C0701x0();
            } else {
                this.c = new C0571s0(context, c0317i4);
            }
        }
        return this.c;
    }

    public C0597t0(Ao ao) {
        this.f1207a = ao;
    }

    public final boolean a(Context context) {
        Boolean bool = this.b;
        if (bool == null) {
            synchronized (this) {
                bool = this.b;
                if (bool == null) {
                    this.f1207a.getClass();
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
