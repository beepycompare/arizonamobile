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
    public final C0573s2 f664a = new C0573s2();
    public final A6 b = new A6();
    public C0182co c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0556rb interfaceC0556rb) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f454a, new InterfaceC0298hb[]{this.f664a.a(context, appMetricaConfig, interfaceC0556rb)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        A6 a6 = this.b;
        ArrayList arrayList = C0575s4.l().i.f693a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            a6.f454a.addAll(arrayList2);
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
        C0134b2 c0134b2 = new C0134b2(this.b);
        this.c = new C0182co(c0134b2);
        C0156bo c0156bo = new C0156bo();
        c0156bo.f915a.add(c0134b2);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            c0156bo.f915a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(c0156bo);
    }

    public final synchronized void a() {
        this.b.f454a.clear();
        this.d = false;
        this.e = false;
    }
}
