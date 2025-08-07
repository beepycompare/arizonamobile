package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
/* renamed from: io.appmetrica.analytics.impl.za  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0755za {
    public static final C0755za d = new C0755za();

    /* renamed from: a  reason: collision with root package name */
    public final Id f1168a = new Id();
    public final ServiceComponentsInitializer b = AbstractC0366jk.a();
    public boolean c = false;

    public final void a(Context context) {
        Ia.a(context);
        this.b.onCreate(context);
        this.f1168a.getClass();
        for (String str : Ia.F.s.a()) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object loadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleServiceEntryPoint.class);
            if (loadAndInstantiateClassWithDefaultConstructor != null) {
                Ia.F.o().a((ModuleServiceEntryPoint) loadAndInstantiateClassWithDefaultConstructor);
            }
        }
        new C0640uk(Ia.j().B().b()).a(context);
        Ia.F.p().a();
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
