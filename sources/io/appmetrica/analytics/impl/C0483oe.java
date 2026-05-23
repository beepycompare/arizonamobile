package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceModule;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceModuleDummy;
/* renamed from: io.appmetrica.analytics.impl.oe  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0483oe {

    /* renamed from: a  reason: collision with root package name */
    public final NativeCrashServiceModule f1130a;
    public final C0328ie b;

    public C0483oe() {
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        NativeCrashServiceModule nativeCrashServiceModule = (NativeCrashServiceModule) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.ndkcrashes.NativeCrashServiceModuleImpl", NativeCrashServiceModule.class);
        this.f1130a = nativeCrashServiceModule == null ? new NativeCrashServiceModuleDummy() : nativeCrashServiceModule;
        this.b = new C0328ie(new C0457ne(this));
    }
}
