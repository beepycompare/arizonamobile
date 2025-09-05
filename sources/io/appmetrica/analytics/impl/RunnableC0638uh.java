package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinVersion;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.uh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0638uh implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        TimePassedChecker timePassedChecker = new TimePassedChecker();
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        C0611tf x = Na.F.x();
        if (timePassedChecker.didTimePassMillis(x.f(), TimeUnit.DAYS.toMillis(1L), "[ReportKotlinVersionTask]")) {
            KotlinVersion kotlinVersion = KotlinVersion.CURRENT;
            Map mapOf = MapsKt.mapOf(TuplesKt.to("major", Integer.valueOf(kotlinVersion.getMajor())), TuplesKt.to("minor", Integer.valueOf(kotlinVersion.getMinor())), TuplesKt.to("patch", Integer.valueOf(kotlinVersion.getPatch())), TuplesKt.to(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, new StringBuilder().append(kotlinVersion.getMajor()).append('.').append(kotlinVersion.getMinor()).append('.').append(kotlinVersion.getPatch()).toString()));
            C0413lk c0413lk = Kj.f538a;
            c0413lk.getClass();
            c0413lk.a(new C0387kk("kotlin_version", mapOf));
            x.c(systemTimeProvider.currentTimeMillis()).b();
        }
    }
}
