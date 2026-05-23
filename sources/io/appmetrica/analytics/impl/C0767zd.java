package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.zd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0767zd implements ModuleSelfReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0541qk f1313a = AbstractC0755z1.a();
    public final int b = 4;

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, Throwable th) {
        C0541qk c0541qk = this.f1313a;
        c0541qk.getClass();
        c0541qk.a(new Pj(str, th));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str) {
        C0541qk c0541qk = this.f1313a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).build();
        c0541qk.getClass();
        c0541qk.a(new C0256fk(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, String str2) {
        this.f1313a.reportError(str, str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, Map<String, ? extends Object> map) {
        C0541qk c0541qk = this.f1313a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).withAttributes(map).build();
        c0541qk.getClass();
        c0541qk.a(new C0256fk(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, String str2) {
        C0541qk c0541qk = this.f1313a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).withValue(str2).build();
        c0541qk.getClass();
        c0541qk.a(new C0256fk(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(int i, String str, String str2) {
        C0541qk c0541qk = this.f1313a;
        ModuleEvent build = ModuleEvent.newBuilder(i).withName(str).withValue(str2).build();
        c0541qk.getClass();
        c0541qk.a(new C0256fk(build));
    }
}
