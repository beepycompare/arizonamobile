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
    public final C0572s2 f664a = new C0572s2();
    public final A6 b = new A6();
    public C0181co c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC0555rb interfaceC0555rb) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f454a, new InterfaceC0297hb[]{this.f664a.a(context, appMetricaConfig, interfaceC0555rb)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        A6 a6 = this.b;
        ArrayList arrayList = C0574s4.l().i.f693a;
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
        C0133b2 c0133b2 = new C0133b2(this.b);
        this.c = new C0181co(c0133b2);
        C0155bo c0155bo = new C0155bo();
        c0155bo.f915a.add(c0133b2);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            c0155bo.f915a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(c0155bo);
    }

    public final synchronized void a() {
        this.b.f454a.clear();
        this.d = false;
        this.e = false;
    }
}
