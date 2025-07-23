package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* renamed from: io.appmetrica.analytics.impl.o0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0470o0 {

    /* renamed from: a  reason: collision with root package name */
    public final Vn f977a;
    public volatile Boolean b;
    public Wa c;
    public Xa d;

    public C0470o0() {
        this(new Vn());
    }

    public final synchronized Wa a(Context context, C0449n4 c0449n4) {
        if (this.c == null) {
            if (a(context)) {
                this.c = new C0520q0();
            } else {
                this.c = new C0445n0(context, c0449n4);
            }
        }
        return this.c;
    }

    public C0470o0(Vn vn) {
        this.f977a = vn;
    }

    public final boolean a(Context context) {
        Boolean bool = this.b;
        if (bool == null) {
            synchronized (this) {
                bool = this.b;
                if (bool == null) {
                    this.f977a.getClass();
                    Boolean valueOf = Boolean.valueOf(!Vn.a(context));
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
