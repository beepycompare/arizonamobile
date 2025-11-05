package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* renamed from: io.appmetrica.analytics.impl.r0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0535r0 {

    /* renamed from: a  reason: collision with root package name */
    public final C0126ao f1083a;
    public volatile Boolean b;
    public Ia c;
    public Ja d;

    public C0535r0() {
        this(new C0126ao());
    }

    public final synchronized Ia a(Context context, Z3 z3) {
        if (this.c == null) {
            if (a(context)) {
                this.c = new C0585t0();
            } else {
                this.c = new C0511q0(context, z3);
            }
        }
        return this.c;
    }

    public C0535r0(C0126ao c0126ao) {
        this.f1083a = c0126ao;
    }

    public final boolean a(Context context) {
        Boolean bool = this.b;
        if (bool == null) {
            synchronized (this) {
                bool = this.b;
                if (bool == null) {
                    this.f1083a.getClass();
                    Boolean valueOf = Boolean.valueOf(!C0126ao.a(context));
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
