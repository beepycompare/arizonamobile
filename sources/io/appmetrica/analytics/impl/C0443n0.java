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
/* renamed from: io.appmetrica.analytics.impl.n0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0443n0 implements Ua {

    /* renamed from: a  reason: collision with root package name */
    public final Context f949a;
    public final IHandlerExecutor b;
    public final C0746z4 c = new C0746z4();
    public final Handler d = f().getHandler();
    public final Y1 e = new Y1();
    public final Db f = new Db();

    public C0443n0(Context context, C0447n4 c0447n4) {
        this.f949a = context;
        this.b = c0447n4.a();
        BaseReleaseLogger.init(context);
        f().execute(new Runnable() { // from class: io.appmetrica.analytics.impl.n0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0443n0.e();
            }
        });
        a().a();
        AbstractC0146b4.a().onCreate();
    }

    public static final void e() {
        ImportantLogger.INSTANCE.info("AppMetrica", "Initializing of AppMetrica, " + StringUtils.capitalize("release") + " type, Version 7.9.0, API Level " + AppMetrica.getLibraryApiLevel() + ", Dated 08.05.2025.", new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final C0746z4 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final Handler b() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final Y1 c() {
        return this.e;
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final Db d() {
        return this.f;
    }

    public final IHandlerExecutor f() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0031 A[Catch: all -> 0x0052, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x000b, B:10:0x000f, B:13:0x0016, B:18:0x0031, B:20:0x0035, B:22:0x0039, B:25:0x0040, B:28:0x004d, B:26:0x0046, B:14:0x001c, B:16:0x0028), top: B:34:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x000b, B:10:0x000f, B:13:0x0016, B:18:0x0031, B:20:0x0035, B:22:0x0039, B:25:0x0040, B:28:0x004d, B:26:0x0046, B:14:0x001c, B:16:0x0028), top: B:34:0x0001 }] */
    @Override // io.appmetrica.analytics.impl.Ua
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void a(AppMetricaConfig appMetricaConfig, InterfaceC0429mb interfaceC0429mb) {
        if (!C0592t0.g) {
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
                                C0592t0.g = true;
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
                this.f.a(this.f949a, appMetricaConfig, interfaceC0429mb);
            }
            if (appMetricaConfig != null) {
            }
            this.e.b();
            if (appMetricaConfig != null) {
            }
        }
    }
}
