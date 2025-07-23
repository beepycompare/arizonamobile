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
    public final C0397l2 f435a = new C0397l2();
    public final G6 b = new G6();
    public C0692wn c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0481ob interfaceC0481ob) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f448a, new InterfaceC0127ab[]{this.f435a.a(context, appMetricaConfig, interfaceC0481ob)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        G6 g6 = this.b;
        ArrayList arrayList = C0698x4.l().i.f929a;
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
        this.c = new C0692wn(u1);
        C0667vn c0667vn = new C0667vn();
        c0667vn.f1106a.add(u1);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            c0667vn.f1106a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(c0667vn);
    }

    public final synchronized void a() {
        this.b.f448a.clear();
        this.d = false;
        this.e = false;
    }
}
