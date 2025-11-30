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
/* renamed from: io.appmetrica.analytics.impl.fa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0241fa {
    public static final C0241fa d = new C0241fa();

    /* renamed from: a  reason: collision with root package name */
    public final C0598td f889a = new C0598td();
    public final ServiceComponentsInitializer b = AbstractC0174ck.a();
    public boolean c = false;

    public final void a(Context context) {
        C0167cd c0167cd;
        C0471oa.a(context);
        this.b.onCreate(context);
        this.f889a.getClass();
        List<String> a2 = C0471oa.I.s.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        for (String str : a2) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object loadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleServiceEntryPoint.class);
            if (loadAndInstantiateClassWithDefaultConstructor == null) {
                c0167cd = new C0167cd(str, false);
            } else {
                C0471oa.I.p().a((ModuleServiceEntryPoint) loadAndInstantiateClassWithDefaultConstructor);
                c0167cd = new C0167cd(str, true);
            }
            arrayList.add(c0167cd);
        }
        new C0481ok(C0471oa.I.D().d).a(context);
        xo xoVar = C0471oa.I.D().c;
        synchronized (xoVar) {
            xoVar.f1206a.a();
        }
        C0471oa.I.q().a();
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

    public static C0193dd a() {
        C0406lk c0406lk = C0471oa.I.d;
        if (c0406lk.b == null) {
            synchronized (c0406lk) {
                if (c0406lk.b == null) {
                    c0406lk.f996a.getClass();
                    HandlerThreadC0191db a2 = A9.a("IAA-SC");
                    c0406lk.b = new A9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return new C0193dd(c0406lk.b, C0471oa.I.y(), "service_modules", new SystemTimeProvider());
    }
}
