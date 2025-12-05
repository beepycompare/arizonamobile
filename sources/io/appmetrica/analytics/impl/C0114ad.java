package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ad  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0114ad implements ModuleSelfReporter {

    /* renamed from: a  reason: collision with root package name */
    public final Rj f881a = AbstractC0710y1.a();
    public final int b = 4;

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, Throwable th) {
        Rj rj = this.f881a;
        rj.getClass();
        rj.a(new C0529qj(str, th));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str) {
        Rj rj = this.f881a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).build();
        rj.getClass();
        rj.a(new Gj(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, String str2) {
        this.f881a.reportError(str, str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, Map<String, ? extends Object> map) {
        Rj rj = this.f881a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).withAttributes(map).build();
        rj.getClass();
        rj.a(new Gj(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, String str2) {
        Rj rj = this.f881a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).withValue(str2).build();
        rj.getClass();
        rj.a(new Gj(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(int i, String str, String str2) {
        Rj rj = this.f881a;
        ModuleEvent build = ModuleEvent.newBuilder(i).withName(str).withValue(str2).build();
        rj.getClass();
        rj.a(new Gj(build));
    }
}
