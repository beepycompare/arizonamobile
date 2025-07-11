package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* renamed from: io.appmetrica.analytics.impl.o0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0468o0 {

    /* renamed from: a  reason: collision with root package name */
    public final Sn f964a;
    public volatile Boolean b;
    public Ua c;
    public Va d;

    public C0468o0() {
        this(new Sn());
    }

    public final synchronized Ua a(Context context, C0447n4 c0447n4) {
        if (this.c == null) {
            if (a(context)) {
                this.c = new C0518q0();
            } else {
                this.c = new C0443n0(context, c0447n4);
            }
        }
        return this.c;
    }

    public C0468o0(Sn sn) {
        this.f964a = sn;
    }

    public final boolean a(Context context) {
        Boolean bool = this.b;
        if (bool == null) {
            synchronized (this) {
                bool = this.b;
                if (bool == null) {
                    this.f964a.getClass();
                    Boolean valueOf = Boolean.valueOf(!Sn.a(context));
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
