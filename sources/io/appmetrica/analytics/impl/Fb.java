package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class Fb {

    /* renamed from: a  reason: collision with root package name */
    public final C0398l2 f435a = new C0398l2();
    public final G6 b = new G6();
    public C0693wn c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0482ob interfaceC0482ob) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f448a, new InterfaceC0128ab[]{this.f435a.a(context, appMetricaConfig, interfaceC0482ob)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        G6 g6 = this.b;
        ArrayList arrayList = C0699x4.l().i.f929a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            g6.f448a.addAll(arrayList2);
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
        this.c = new C0693wn(u1);
        C0668vn c0668vn = new C0668vn();
        c0668vn.f1106a.add(u1);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            c0668vn.f1106a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(c0668vn);
    }

    public final synchronized void a() {
        this.b.f448a.clear();
        this.d = false;
        this.e = false;
    }
}
