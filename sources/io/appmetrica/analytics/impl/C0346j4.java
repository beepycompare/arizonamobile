package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleRegistry;
import io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientActivator;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientExecutorProvider;
import io.appmetrica.analytics.modulesapi.internal.client.ProcessDetector;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext;
import io.appmetrica.analytics.modulesapi.internal.common.InternalClientModuleFacade;
/* renamed from: io.appmetrica.analytics.impl.j4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0346j4 implements InterfaceC0271g6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f933a;
    public final C0348j6 b = new C0348j6(new G5());
    public final B4 c = new B4(A4.l().b(getContext()));
    public final Ab d = new Ab();
    public final C0445n e = A4.l().a();
    public final C0295h4 f = new C0295h4();
    public final C0536qd g = new C0536qd();
    public final C0321i4 h = new C0321i4();

    public C0346j4(Context context) {
        this.f933a = context;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final ActivityLifecycleRegistry getActivityLifecycleRegistry() {
        return this.e;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final ModuleClientActivator getClientActivator() {
        return this.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final ModuleClientExecutorProvider getClientExecutorProvider() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final ClientStorageProvider getClientStorageProvider() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final Context getContext() {
        return this.f933a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final InternalClientModuleFacade getInternalClientModuleFacade() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0271g6, io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final InterfaceC0323i6 getModuleAdRevenueContext() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final ProcessDetector getProcessDetector() {
        return this.h;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final ModuleAdRevenueContext getModuleAdRevenueContext() {
        return this.b;
    }
}
