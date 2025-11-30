package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
/* renamed from: io.appmetrica.analytics.impl.r0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0535r0 {

    /* renamed from: a  reason: collision with root package name */
    public final Zn f1095a;
    public volatile Boolean b;
    public Ca c;
    public Da d;

    public C0535r0() {
        this(new Zn());
    }

    public final synchronized Ca a(Context context, S3 s3) {
        if (this.c == null) {
            if (a(context)) {
                this.c = new C0635v0();
            } else {
                this.c = new C0511q0(context, s3);
            }
        }
        return this.c;
    }

    public C0535r0(Zn zn) {
        this.f1095a = zn;
    }

    public final boolean a(Context context) {
        Boolean bool = this.b;
        if (bool == null) {
            synchronized (this) {
                bool = this.b;
                if (bool == null) {
                    this.f1095a.getClass();
                    Boolean valueOf = Boolean.valueOf(!Zn.a(context));
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
