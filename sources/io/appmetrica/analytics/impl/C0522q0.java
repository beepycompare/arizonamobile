package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* renamed from: io.appmetrica.analytics.impl.q0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0522q0 {

    /* renamed from: a  reason: collision with root package name */
    public final C0236eo f1043a;
    public volatile Boolean b;
    public InterfaceC0146bb c;
    public InterfaceC0172cb d;

    public C0522q0() {
        this(new C0236eo());
    }

    public final synchronized InterfaceC0146bb a(Context context, C0526q4 c0526q4) {
        if (this.c == null) {
            if (a(context)) {
                this.c = new C0571s0();
            } else {
                this.c = new C0497p0(context, c0526q4);
            }
        }
        return this.c;
    }

    public C0522q0(C0236eo c0236eo) {
        this.f1043a = c0236eo;
    }

    public final boolean a(Context context) {
        Boolean bool = this.b;
        if (bool == null) {
            synchronized (this) {
                bool = this.b;
                if (bool == null) {
                    this.f1043a.getClass();
                    Boolean valueOf = Boolean.valueOf(!C0236eo.a(context));
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
