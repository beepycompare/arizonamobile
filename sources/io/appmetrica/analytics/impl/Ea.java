package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
/* loaded from: classes4.dex */
public final class Ea {
    public static final Ea d = new Ea();

    /* renamed from: a  reason: collision with root package name */
    public final Od f426a = new Od();
    public final ServiceComponentsInitializer b = AbstractC0591sk.a();
    public boolean c = false;

    public final void a(Context context) {
        Na.a(context);
        this.b.onCreate(context);
        this.f426a.getClass();
        for (String str : Na.F.s.a()) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object loadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleServiceEntryPoint.class);
            if (loadAndInstantiateClassWithDefaultConstructor != null) {
                Na.F.o().a((ModuleServiceEntryPoint) loadAndInstantiateClassWithDefaultConstructor);
            }
        }
        new Dk(Na.j().B().b()).a(context);
        Na.F.p().a();
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
