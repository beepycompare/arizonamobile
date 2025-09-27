package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class Kb {

    /* renamed from: a  reason: collision with root package name */
    public final C0447n2 f538a = new C0447n2();
    public final J6 b = new J6();
    public Fn c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0607tb interfaceC0607tb) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f512a, new InterfaceC0249fb[]{this.f538a.a(context, appMetricaConfig, interfaceC0607tb)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        J6 j6 = this.b;
        ArrayList arrayList = A4.l().i.f1100a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            j6.f512a.addAll(arrayList2);
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
        W1 w1 = new W1(this.b);
        this.c = new Fn(w1);
        En en = new En();
        en.f433a.add(w1);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            en.f433a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(en);
    }

    public final synchronized void a() {
        this.b.f512a.clear();
        this.d = false;
        this.e = false;
    }
}
