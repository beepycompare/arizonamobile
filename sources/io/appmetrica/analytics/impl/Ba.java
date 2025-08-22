package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
/* loaded from: classes4.dex */
public final class Ba {
    public static final Ba d = new Ba();

    /* renamed from: a  reason: collision with root package name */
    public final Kd f361a = new Kd();
    public final ServiceComponentsInitializer b = AbstractC0488ok.a();
    public boolean c = false;

    public final void a(Context context) {
        Ka.a(context);
        this.b.onCreate(context);
        this.f361a.getClass();
        for (String str : Ka.F.s.a()) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object loadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleServiceEntryPoint.class);
            if (loadAndInstantiateClassWithDefaultConstructor != null) {
                Ka.F.o().a((ModuleServiceEntryPoint) loadAndInstantiateClassWithDefaultConstructor);
            }
        }
        new C0762zk(Ka.j().B().b()).a(context);
        Ka.F.p().a();
    }

    public final void b(Context context) {
        if (this.c) {
            return;
        }
        synchronized (this) {
            if (!this.c) {
                a(context);
                this.c = true;
            }
        }
    }
}
