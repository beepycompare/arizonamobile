package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
/* renamed from: io.appmetrica.analytics.impl.xa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0702xa {
    public static final C0702xa d = new C0702xa();

    /* renamed from: a  reason: collision with root package name */
    public final Gd f1123a = new Gd();
    public final ServiceComponentsInitializer b = AbstractC0289gk.a();
    public boolean c = false;

    public final void a(Context context) {
        Ga.a(context);
        this.b.onCreate(context);
        this.f1123a.getClass();
        for (String str : Ga.F.s.a()) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object loadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleServiceEntryPoint.class);
            if (loadAndInstantiateClassWithDefaultConstructor != null) {
                Ga.F.o().a((ModuleServiceEntryPoint) loadAndInstantiateClassWithDefaultConstructor);
            }
        }
        new C0562rk(Ga.j().B().b()).a(context);
        Ga.F.p().a();
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
