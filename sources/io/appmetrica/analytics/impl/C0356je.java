package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceModule;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceModuleDummy;
/* renamed from: io.appmetrica.analytics.impl.je  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0356je {

    /* renamed from: a  reason: collision with root package name */
    public final NativeCrashServiceModule f940a;
    public final C0202de b;

    public C0356je() {
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        NativeCrashServiceModule nativeCrashServiceModule = (NativeCrashServiceModule) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.ndkcrashes.NativeCrashServiceModuleImpl", NativeCrashServiceModule.class);
        this.f940a = nativeCrashServiceModule == null ? new NativeCrashServiceModuleDummy() : nativeCrashServiceModule;
        this.b = new C0202de(new C0331ie(this));
    }
}
