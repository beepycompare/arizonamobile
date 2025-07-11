package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class Db {

    /* renamed from: a  reason: collision with root package name */
    public final C0395l2 f389a = new C0395l2();
    public final D6 b = new D6();
    public C0615tn c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0429mb interfaceC0429mb) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f385a, new Ya[]{this.f389a.a(context, appMetricaConfig, interfaceC0429mb)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        D6 d6 = this.b;
        ArrayList arrayList = C0696x4.l().i.f870a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            d6.f385a.addAll(arrayList2);
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
        this.c = new C0615tn(u1);
        C0590sn c0590sn = new C0590sn();
        c0590sn.f1050a.add(u1);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            c0590sn.f1050a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(c0590sn);
    }

    public final synchronized void a() {
        this.b.f385a.clear();
        this.d = false;
        this.e = false;
    }
}
