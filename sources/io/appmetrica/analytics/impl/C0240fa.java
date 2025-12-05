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
public final class C0240fa {
    public static final C0240fa d = new C0240fa();

    /* renamed from: a  reason: collision with root package name */
    public final C0597td f972a = new C0597td();
    public final ServiceComponentsInitializer b = AbstractC0173ck.a();
    public boolean c = false;

    public final void a(Context context) {
        C0166cd c0166cd;
        C0470oa.a(context);
        this.b.onCreate(context);
        this.f972a.getClass();
        List<String> a2 = C0470oa.I.s.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        for (String str : a2) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object loadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleServiceEntryPoint.class);
            if (loadAndInstantiateClassWithDefaultConstructor == null) {
                c0166cd = new C0166cd(str, false);
            } else {
                C0470oa.I.p().a((ModuleServiceEntryPoint) loadAndInstantiateClassWithDefaultConstructor);
                c0166cd = new C0166cd(str, true);
            }
            arrayList.add(c0166cd);
        }
        new C0480ok(C0470oa.I.D().d).a(context);
        xo xoVar = C0470oa.I.D().c;
        synchronized (xoVar) {
            xoVar.f1289a.a();
        }
        C0470oa.I.q().a();
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

    public static C0192dd a() {
        C0405lk c0405lk = C0470oa.I.d;
        if (c0405lk.b == null) {
            synchronized (c0405lk) {
                if (c0405lk.b == null) {
                    c0405lk.f1079a.getClass();
                    HandlerThreadC0190db a2 = A9.a("IAA-SC");
                    c0405lk.b = new A9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return new C0192dd(c0405lk.b, C0470oa.I.y(), "service_modules", new SystemTimeProvider());
    }
}
