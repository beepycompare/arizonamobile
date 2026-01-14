package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.ea  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0219ea {
    public static final C0219ea d = new C0219ea();

    /* renamed from: a  reason: collision with root package name */
    public final C0576sd f977a = new C0576sd();
    public final ServiceComponentsInitializer b = AbstractC0152bk.a();
    public boolean c = false;

    public final void a(Context context) {
        C0145bd c0145bd;
        C0449na.a(context);
        this.b.onCreate(context);
        this.f977a.getClass();
        List<String> a2 = C0449na.I.s.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        for (String str : a2) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object loadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleServiceEntryPoint.class);
            if (loadAndInstantiateClassWithDefaultConstructor == null) {
                c0145bd = new C0145bd(str, false);
            } else {
                C0449na.I.p().a((ModuleServiceEntryPoint) loadAndInstantiateClassWithDefaultConstructor);
                c0145bd = new C0145bd(str, true);
            }
            arrayList.add(c0145bd);
        }
        new C0459nk(C0449na.I.D().d).a(context);
        wo woVar = C0449na.I.D().c;
        synchronized (woVar) {
            woVar.f1294a.a();
        }
        C0449na.I.q().a();
        a().a(arrayList);
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

    public static C0171cd a() {
        C0384kk c0384kk = C0449na.I.d;
        if (c0384kk.b == null) {
            synchronized (c0384kk) {
                if (c0384kk.b == null) {
                    c0384kk.f1085a.getClass();
                    HandlerThreadC0169cb a2 = C0747z9.a("IAA-SC");
                    c0384kk.b = new C0747z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return new C0171cd(c0384kk.b, C0449na.I.y(), "service_modules", new SystemTimeProvider());
    }
}
