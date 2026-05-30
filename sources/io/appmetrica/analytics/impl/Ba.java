package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Ba {
    public static final Ba d = new Ba();

    /* renamed from: a  reason: collision with root package name */
    public final Sd f473a = new Sd();
    public final ServiceComponentsInitializer b = Dk.a();
    public boolean c = false;

    public final void a(Context context) {
        Bd bd;
        Na.a(context);
        this.b.onCreate(context);
        this.f473a.getClass();
        List<String> a2 = Na.I.s.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        for (String str : a2) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object loadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleServiceEntryPoint.class);
            if (loadAndInstantiateClassWithDefaultConstructor == null) {
                bd = new Bd(str, false);
            } else {
                Na.I.p().a((ModuleServiceEntryPoint) loadAndInstantiateClassWithDefaultConstructor);
                bd = new Bd(str, true);
            }
            arrayList.add(bd);
        }
        new Pk(Na.I.D().d).a(context);
        Zo zo = Na.I.D().c;
        synchronized (zo) {
            zo.f876a.a();
        }
        Na.I.q().a();
        new Cd(Na.I.d.b(), Na.I.y(), "service_modules", new SystemTimeProvider()).a(arrayList);
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
