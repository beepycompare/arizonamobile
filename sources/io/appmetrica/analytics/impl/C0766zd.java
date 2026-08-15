package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.zd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0766zd implements ModuleSelfReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0540qk f1316a = AbstractC0754z1.a();
    public final int b = 4;

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, Throwable th) {
        C0540qk c0540qk = this.f1316a;
        c0540qk.getClass();
        c0540qk.a(new Pj(str, th));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str) {
        C0540qk c0540qk = this.f1316a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).build();
        c0540qk.getClass();
        c0540qk.a(new C0255fk(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, String str2) {
        this.f1316a.reportError(str, str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, Map<String, ? extends Object> map) {
        C0540qk c0540qk = this.f1316a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).withAttributes(map).build();
        c0540qk.getClass();
        c0540qk.a(new C0255fk(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, String str2) {
        C0540qk c0540qk = this.f1316a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).withValue(str2).build();
        c0540qk.getClass();
        c0540qk.a(new C0255fk(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(int i, String str, String str2) {
        C0540qk c0540qk = this.f1316a;
        ModuleEvent build = ModuleEvent.newBuilder(i).withName(str).withValue(str2).build();
        c0540qk.getClass();
        c0540qk.a(new C0255fk(build));
    }
}
