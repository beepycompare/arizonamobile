package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class Hb {

    /* renamed from: a  reason: collision with root package name */
    public final C0395l2 f475a = new C0395l2();
    public final G6 b = new G6();
    public Bn c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0529qb interfaceC0529qb) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f450a, new InterfaceC0172cb[]{this.f475a.a(context, appMetricaConfig, interfaceC0529qb)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        G6 g6 = this.b;
        ArrayList arrayList = C0696x4.l().i.f1016a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            g6.f450a.addAll(arrayList2);
            this.d = true;
            return;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    public final synchronized void c() {
        if (this.c != null) {
            return;
        }
        U1 u1 = new U1(this.b);
        this.c = new Bn(u1);
        An an = new An();
        an.f351a.add(u1);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            an.f351a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(an);
    }

    public final synchronized void a() {
        this.b.f450a.clear();
        this.d = false;
        this.e = false;
    }
}
