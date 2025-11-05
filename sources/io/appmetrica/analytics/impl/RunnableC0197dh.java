package io.appmetrica.analytics.impl;

import com.facebook.internal.NativeProtocol;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinVersion;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.dh  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0197dh implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        TimePassedChecker timePassedChecker = new TimePassedChecker();
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        C0220ef z = C0620ua.H.z();
        if (timePassedChecker.didTimePassMillis(z.f(), TimeUnit.DAYS.toMillis(1L), "[ReportKotlinVersionTask]")) {
            KotlinVersion kotlinVersion = KotlinVersion.CURRENT;
            Map mapOf = MapsKt.mapOf(TuplesKt.to("major", Integer.valueOf(kotlinVersion.getMajor())), TuplesKt.to("minor", Integer.valueOf(kotlinVersion.getMinor())), TuplesKt.to("patch", Integer.valueOf(kotlinVersion.getPatch())), TuplesKt.to(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, new StringBuilder().append(kotlinVersion.getMajor()).append('.').append(kotlinVersion.getMinor()).append('.').append(kotlinVersion.getPatch()).toString()));
            Vj vj = AbstractC0604tj.f1136a;
            vj.getClass();
            vj.a(new Uj("kotlin_version", mapOf));
            z.c(systemTimeProvider.currentTimeMillis()).b();
        }
    }
}
