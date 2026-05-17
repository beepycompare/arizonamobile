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
public final class C0218ea {
    public static final C0218ea d = new C0218ea();

    /* renamed from: a  reason: collision with root package name */
    public final C0575sd f981a = new C0575sd();
    public final ServiceComponentsInitializer b = AbstractC0151bk.a();
    public boolean c = false;

    public final void a(Context context) {
        C0144bd c0144bd;
        C0448na.a(context);
        this.b.onCreate(context);
        this.f981a.getClass();
        List<String> a2 = C0448na.I.s.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        for (String str : a2) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object loadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleServiceEntryPoint.class);
            if (loadAndInstantiateClassWithDefaultConstructor == null) {
                c0144bd = new C0144bd(str, false);
            } else {
                C0448na.I.p().a((ModuleServiceEntryPoint) loadAndInstantiateClassWithDefaultConstructor);
                c0144bd = new C0144bd(str, true);
            }
            arrayList.add(c0144bd);
        }
        new C0458nk(C0448na.I.D().d).a(context);
        wo woVar = C0448na.I.D().c;
        synchronized (woVar) {
            woVar.f1298a.a();
        }
        C0448na.I.q().a();
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

    public static C0170cd a() {
        C0383kk c0383kk = C0448na.I.d;
        if (c0383kk.b == null) {
            synchronized (c0383kk) {
                if (c0383kk.b == null) {
                    c0383kk.f1089a.getClass();
                    HandlerThreadC0168cb a2 = C0746z9.a("IAA-SC");
                    c0383kk.b = new C0746z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return new C0170cd(c0383kk.b, C0448na.I.y(), "service_modules", new SystemTimeProvider());
    }
}
