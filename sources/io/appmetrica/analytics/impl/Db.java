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
    public final C0403l2 f388a = new C0403l2();
    public final D6 b = new D6();
    public C0623tn c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0437mb interfaceC0437mb) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f384a, new Ya[]{this.f388a.a(context, appMetricaConfig, interfaceC0437mb)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        D6 d6 = this.b;
        ArrayList arrayList = C0704x4.l().i.f869a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            d6.f384a.addAll(arrayList2);
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
        this.c = new C0623tn(u1);
        C0598sn c0598sn = new C0598sn();
        c0598sn.f1049a.add(u1);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            c0598sn.f1049a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(c0598sn);
    }

    public final synchronized void a() {
        this.b.f384a.clear();
        this.d = false;
        this.e = false;
    }
}
