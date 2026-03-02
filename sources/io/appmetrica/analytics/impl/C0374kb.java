package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.kb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0374kb {

    /* renamed from: a  reason: collision with root package name */
    public final C0236f2 f1080a = new C0236f2();
    public final C0369k6 b = new C0369k6();
    public C0760zn c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, Ta ta) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f1076a, new Fa[]{this.f1080a.a(context, appMetricaConfig, ta)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        C0369k6 c0369k6 = this.b;
        ArrayList arrayList = C0135b4.l().i.f1124a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            c0369k6.f1076a.addAll(arrayList2);
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
        O1 o1 = new O1(this.b);
        this.c = new C0760zn(o1);
        C0735yn c0735yn = new C0735yn();
        c0735yn.f1325a.add(o1);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            c0735yn.f1325a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(c0735yn);
    }

    public final synchronized void a() {
        this.b.f1076a.clear();
        this.d = false;
        this.e = false;
    }
}
