package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.lb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0396lb {

    /* renamed from: a  reason: collision with root package name */
    public final C0258g2 f1089a = new C0258g2();
    public final C0391l6 b = new C0391l6();
    public An c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, Ua ua) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f1085a, new Ga[]{this.f1089a.a(context, appMetricaConfig, ua)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        C0391l6 c0391l6 = this.b;
        ArrayList arrayList = C0157c4.l().i.f1134a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            c0391l6.f1085a.addAll(arrayList2);
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
        P1 p1 = new P1(this.b);
        this.c = new An(p1);
        C0757zn c0757zn = new C0757zn();
        c0757zn.f1334a.add(p1);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            c0757zn.f1334a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(c0757zn);
    }

    public final synchronized void a() {
        this.b.f1085a.clear();
        this.d = false;
        this.e = false;
    }
}
