package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.zd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0760zd implements ModuleSelfReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0414lk f1191a = AbstractC0648v1.a();
    public final int b = 4;

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, Throwable th) {
        C0414lk c0414lk = this.f1191a;
        c0414lk.getClass();
        c0414lk.a(new Lj(str, th));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str) {
        C0414lk c0414lk = this.f1191a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).build();
        c0414lk.getClass();
        c0414lk.a(new C0130ak(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, String str2) {
        this.f1191a.reportError(str, str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, Map<String, ? extends Object> map) {
        C0414lk c0414lk = this.f1191a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).withAttributes(map).build();
        c0414lk.getClass();
        c0414lk.a(new C0130ak(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, String str2) {
        C0414lk c0414lk = this.f1191a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).withValue(str2).build();
        c0414lk.getClass();
        c0414lk.a(new C0130ak(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(int i, String str, String str2) {
        C0414lk c0414lk = this.f1191a;
        ModuleEvent build = ModuleEvent.newBuilder(i).withName(str).withValue(str2).build();
        c0414lk.getClass();
        c0414lk.a(new C0130ak(build));
    }
}
