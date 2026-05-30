package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashClientModule;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashClientModuleDummy;
/* renamed from: io.appmetrica.analytics.impl.be  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0147be {

    /* renamed from: a  reason: collision with root package name */
    public final C0175cg f907a;
    public final NativeCrashClientModule b;
    public final K0 c;
    public J0 d;

    public C0147be(C0175cg c0175cg) {
        this.f907a = c0175cg;
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        NativeCrashClientModule nativeCrashClientModule = (NativeCrashClientModule) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.ndkcrashes.NativeCrashClientModuleImpl", NativeCrashClientModule.class);
        this.b = nativeCrashClientModule == null ? new NativeCrashClientModuleDummy() : nativeCrashClientModule;
        this.c = new K0();
    }
}
