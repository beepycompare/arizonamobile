package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinVersion;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.ph  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0512ph implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        TimePassedChecker timePassedChecker = new TimePassedChecker();
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        C0769zf y = Na.I.y();
        if (timePassedChecker.didTimePassMillis(y.f(), TimeUnit.DAYS.toMillis(1L), "[ReportKotlinVersionTask]")) {
            KotlinVersion kotlinVersion = KotlinVersion.CURRENT;
            Map mapOf = MapsKt.mapOf(TuplesKt.to("major", Integer.valueOf(kotlinVersion.getMajor())), TuplesKt.to("minor", Integer.valueOf(kotlinVersion.getMinor())), TuplesKt.to("patch", Integer.valueOf(kotlinVersion.getPatch())), TuplesKt.to(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, new StringBuilder().append(kotlinVersion.getMajor()).append('.').append(kotlinVersion.getMinor()).append('.').append(kotlinVersion.getPatch()).toString()));
            C0541qk c0541qk = Oj.f706a;
            c0541qk.getClass();
            c0541qk.a(new C0515pk("kotlin_version", mapOf));
            y.a(systemTimeProvider.currentTimeMillis());
        }
    }
}
