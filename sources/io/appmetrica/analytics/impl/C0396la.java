package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.la  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0396la {
    public static final C0396la d = new C0396la();

    /* renamed from: a  reason: collision with root package name */
    public final C0748zd f989a = new C0748zd();
    public final ServiceComponentsInitializer b = AbstractC0277gk.a();
    public boolean c = false;

    public final void a(Context context) {
        C0322id c0322id;
        C0620ua.a(context);
        this.b.onCreate(context);
        this.f989a.getClass();
        List<String> a2 = C0620ua.H.s.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        for (String str : a2) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object loadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleServiceEntryPoint.class);
            if (loadAndInstantiateClassWithDefaultConstructor == null) {
                c0322id = new C0322id(str, false);
            } else {
                C0620ua.H.p().a((ModuleServiceEntryPoint) loadAndInstantiateClassWithDefaultConstructor);
                c0322id = new C0322id(str, true);
            }
            arrayList.add(c0322id);
        }
        new C0555rk(C0620ua.H.D().d).a(context);
        C0620ua.H.q().a();
        new C0347jd(C0620ua.H.d.a(), C0620ua.H.z(), "service_modules", new SystemTimeProvider()).a(arrayList);
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
