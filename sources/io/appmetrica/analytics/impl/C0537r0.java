package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* renamed from: io.appmetrica.analytics.impl.r0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0537r0 {

    /* renamed from: a  reason: collision with root package name */
    public final Yn f1201a;
    public volatile Boolean b;
    public Ba c;
    public Ca d;

    public C0537r0() {
        this(new Yn());
    }

    public final synchronized Ba a(Context context, R3 r3) {
        if (this.c == null) {
            if (a(context)) {
                this.c = new C0637v0();
            } else {
                this.c = new C0513q0(context, r3);
            }
        }
        return this.c;
    }

    public C0537r0(Yn yn) {
        this.f1201a = yn;
    }

    public final boolean a(Context context) {
        Boolean bool = this.b;
        if (bool == null) {
            synchronized (this) {
                bool = this.b;
                if (bool == null) {
                    this.f1201a.getClass();
                    Boolean valueOf = Boolean.valueOf(!Yn.a(context));
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
