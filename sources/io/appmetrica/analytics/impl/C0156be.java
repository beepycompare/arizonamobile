package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceModule;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceModuleDummy;
/* renamed from: io.appmetrica.analytics.impl.be  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0156be {

    /* renamed from: a  reason: collision with root package name */
    public final NativeCrashServiceModule f770a;
    public final Vd b;

    public C0156be() {
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        NativeCrashServiceModule nativeCrashServiceModule = (NativeCrashServiceModule) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.ndkcrashes.NativeCrashServiceModuleImpl", NativeCrashServiceModule.class);
        this.f770a = nativeCrashServiceModule == null ? new NativeCrashServiceModuleDummy() : nativeCrashServiceModule;
        this.b = new Vd(new C0130ae(this));
    }
}
