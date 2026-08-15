package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import io.appmetrica.analytics.logger.common.BaseReleaseLogger;
/* renamed from: io.appmetrica.analytics.impl.s0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0571s0 implements InterfaceC0195db {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1191a;
    public final IHandlerExecutor b;
    public final C0653v4 c = new C0653v4();
    public final Handler d = f().getHandler();
    public final C0237f2 e = new C0237f2();
    public final Mb f = new Mb();

    public C0571s0(Context context, C0317i4 c0317i4) {
        this.f1191a = context;
        this.b = c0317i4.a();
        BaseReleaseLogger.init(context);
        f().execute(new Runnable() { // from class: io.appmetrica.analytics.impl.s0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0571s0.e();
            }
        });
        a().a();
        W3.a().onCreate();
    }

    public static final void e() {
        ImportantLogger.INSTANCE.info("AppMetrica", "Initializing of AppMetrica, " + StringUtils.capitalize("release") + " type, Version 8.2.0, API Level " + AppMetrica.getLibraryApiLevel() + ", Dated 14.05.2026.", new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0195db
    public final C0653v4 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0195db
    public final Handler b() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0195db
    public final C0237f2 c() {
        return this.e;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0195db
    public final Mb d() {
        return this.f;
    }

    public final IHandlerExecutor f() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0195db
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0031 A[Catch: all -> 0x0052, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x000b, B:10:0x000f, B:13:0x0016, B:18:0x0031, B:20:0x0035, B:22:0x0039, B:25:0x0040, B:28:0x004d, B:26:0x0046, B:14:0x001c, B:16:0x0028), top: B:34:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x000b, B:10:0x000f, B:13:0x0016, B:18:0x0031, B:20:0x0035, B:22:0x0039, B:25:0x0040, B:28:0x004d, B:26:0x0046, B:14:0x001c, B:16:0x0028), top: B:34:0x0001 }] */
    @Override // io.appmetrica.analytics.impl.InterfaceC0195db
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void a(AppMetricaConfig appMetricaConfig, InterfaceC0556rb interfaceC0556rb) {
        if (!A0.g) {
            if (appMetricaConfig != null) {
                Boolean bool = appMetricaConfig.crashReporting;
                if (bool == null) {
                    bool = Boolean.TRUE;
                }
                if (bool != null && !bool.booleanValue()) {
                    this.f.a();
                    if (appMetricaConfig != null) {
                        Boolean bool2 = appMetricaConfig.appOpenTrackingEnabled;
                        if (bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        if (bool2 != null && !bool2.booleanValue()) {
                            this.e.c();
                            if (appMetricaConfig != null) {
                                A0.g = true;
                            }
                        }
                    }
                    this.e.b();
                    if (appMetricaConfig != null) {
                    }
                }
            }
            this.f.c();
            this.f.b();
            if (appMetricaConfig != null) {
                this.f.a(this.f1191a, appMetricaConfig, interfaceC0556rb);
            }
            if (appMetricaConfig != null) {
            }
            this.e.b();
            if (appMetricaConfig != null) {
            }
        }
    }
}
