package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.rb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0546rb {

    /* renamed from: a  reason: collision with root package name */
    public final C0463o2 f1092a = new C0463o2();
    public final C0541r6 b = new C0541r6();
    public Bn c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0113ab interfaceC0113ab) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f1088a, new Ma[]{this.f1092a.a(context, appMetricaConfig, interfaceC0113ab)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        C0541r6 c0541r6 = this.b;
        ArrayList arrayList = C0338j4.l().i.f1060a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            c0541r6.f1088a.addAll(arrayList2);
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
        X1 x1 = new X1(this.b);
        this.c = new Bn(x1);
        An an = new An();
        an.f401a.add(x1);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            an.f401a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(an);
    }

    public final synchronized void a() {
        this.b.f1088a.clear();
        this.d = false;
        this.e = false;
    }
}
