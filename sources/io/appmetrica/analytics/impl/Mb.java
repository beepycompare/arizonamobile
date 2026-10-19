package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Mb {

    /* renamed from: a  reason: collision with root package name */
    public final C0567s2 f667a = new C0567s2();
    public final A6 b = new A6();
    public C0176co c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0550rb interfaceC0550rb) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f457a, new InterfaceC0292hb[]{this.f667a.a(context, appMetricaConfig, interfaceC0550rb)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        A6 a6 = this.b;
        ArrayList arrayList = C0569s4.l().i.f696a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            a6.f457a.addAll(arrayList2);
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
        C0128b2 c0128b2 = new C0128b2(this.b);
        this.c = new C0176co(c0128b2);
        C0150bo c0150bo = new C0150bo();
        c0150bo.f918a.add(c0128b2);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            c0150bo.f918a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(c0150bo);
    }

    public final synchronized void a() {
        this.b.f457a.clear();
        this.d = false;
        this.e = false;
    }
}
