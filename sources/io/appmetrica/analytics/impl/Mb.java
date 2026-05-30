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
    public final C0574s2 f662a = new C0574s2();
    public final A6 b = new A6();
    public C0183co c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0557rb interfaceC0557rb) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f452a, new InterfaceC0299hb[]{this.f662a.a(context, appMetricaConfig, interfaceC0557rb)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        A6 a6 = this.b;
        ArrayList arrayList = C0576s4.l().i.f691a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            a6.f452a.addAll(arrayList2);
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
        C0135b2 c0135b2 = new C0135b2(this.b);
        this.c = new C0183co(c0135b2);
        C0157bo c0157bo = new C0157bo();
        c0157bo.f913a.add(c0135b2);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            c0157bo.f913a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(c0157bo);
    }

    public final synchronized void a() {
        this.b.f452a.clear();
        this.d = false;
        this.e = false;
    }
}
