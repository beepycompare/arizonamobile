package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* renamed from: io.appmetrica.analytics.impl.t0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0596t0 {

    /* renamed from: a  reason: collision with root package name */
    public final Ao f1207a;
    public volatile Boolean b;
    public InterfaceC0194db c;
    public InterfaceC0219eb d;

    public C0596t0() {
        this(new Ao());
    }

    public final synchronized InterfaceC0194db a(Context context, C0316i4 c0316i4) {
        if (this.c == null) {
            if (a(context)) {
                this.c = new C0700x0();
            } else {
                this.c = new C0570s0(context, c0316i4);
            }
        }
        return this.c;
    }

    public C0596t0(Ao ao) {
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
