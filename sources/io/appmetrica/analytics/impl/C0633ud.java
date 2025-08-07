package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ud  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0633ud implements ModuleSelfReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0189ck f1084a = AbstractC0596t1.a();
    public final int b = 4;

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, Throwable th) {
        C0189ck c0189ck = this.f1084a;
        c0189ck.getClass();
        c0189ck.a(new Cj(str, th));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str) {
        C0189ck c0189ck = this.f1084a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).build();
        c0189ck.getClass();
        c0189ck.a(new Rj(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, String str2) {
        this.f1084a.reportError(str, str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, Map<String, ? extends Object> map) {
        C0189ck c0189ck = this.f1084a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).withAttributes(map).build();
        c0189ck.getClass();
        c0189ck.a(new Rj(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, String str2) {
        C0189ck c0189ck = this.f1084a;
        ModuleEvent build = ModuleEvent.newBuilder(this.b).withName(str).withValue(str2).build();
        c0189ck.getClass();
        c0189ck.a(new Rj(build));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(int i, String str, String str2) {
        C0189ck c0189ck = this.f1084a;
        ModuleEvent build = ModuleEvent.newBuilder(i).withName(str).withValue(str2).build();
        c0189ck.getClass();
        c0189ck.a(new Rj(build));
    }
}
