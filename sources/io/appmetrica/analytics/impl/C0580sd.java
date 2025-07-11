package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.sd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0580sd implements ModuleSelfReporter {

    /* renamed from: a  reason: collision with root package name */
    public final Zj f1045a = AbstractC0593t1.a();
    public final int b = 4;

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, Throwable th) {
        Zj zj = this.f1045a;
        zj.getClass();
        zj.a(new C0761zj(str, th));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str) {
        Zj zj = this.f1045a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).build();
        zj.getClass();
        zj.a(new Oj(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, String str2) {
        this.f1045a.reportError(str, str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, Map<String, ? extends Object> map) {
        Zj zj = this.f1045a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).withAttributes(map).build();
        zj.getClass();
        zj.a(new Oj(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, String str2) {
        Zj zj = this.f1045a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).withValue(str2).build();
        zj.getClass();
        zj.a(new Oj(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(int i, String str, String str2) {
        Zj zj = this.f1045a;
        ModuleEvent build = ModuleEvent.newBuilder(i).withName(str).withValue(str2).build();
        zj.getClass();
        zj.a(new Oj(build));
    }
}
