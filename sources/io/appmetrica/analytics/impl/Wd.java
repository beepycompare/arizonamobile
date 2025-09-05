package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashClientModule;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashClientModuleDummy;
/* loaded from: classes4.dex */
public final class Wd {

    /* renamed from: a  reason: collision with root package name */
    public final Vf f723a;
    public final NativeCrashClientModule b;
    public final F0 c;
    public E0 d;

    public Wd(Vf vf) {
        this.f723a = vf;
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        NativeCrashClientModule nativeCrashClientModule = (NativeCrashClientModule) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.ndkcrashes.NativeCrashClientModuleImpl", NativeCrashClientModule.class);
        this.b = nativeCrashClientModule == null ? new NativeCrashClientModuleDummy() : nativeCrashClientModule;
        this.c = new F0();
    }
}
