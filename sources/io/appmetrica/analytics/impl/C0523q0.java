package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* renamed from: io.appmetrica.analytics.impl.q0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0523q0 {

    /* renamed from: a  reason: collision with root package name */
    public final C0237eo f1043a;
    public volatile Boolean b;
    public InterfaceC0147bb c;
    public InterfaceC0173cb d;

    public C0523q0() {
        this(new C0237eo());
    }

    public final synchronized InterfaceC0147bb a(Context context, C0527q4 c0527q4) {
        if (this.c == null) {
            if (a(context)) {
                this.c = new C0572s0();
            } else {
                this.c = new C0498p0(context, c0527q4);
            }
        }
        return this.c;
    }

    public C0523q0(C0237eo c0237eo) {
        this.f1043a = c0237eo;
    }

    public final boolean a(Context context) {
        Boolean bool = this.b;
        if (bool == null) {
            synchronized (this) {
                bool = this.b;
                if (bool == null) {
                    this.f1043a.getClass();
                    Boolean valueOf = Boolean.valueOf(!C0237eo.a(context));
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
