package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public final class An {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0767zn f346a;
    public final BiFunction b;
    public final M6 c;

    public An() {
        this(new C0717xn(), new Ga(), C0698x4.l().n());
    }

    public final ArrayList a(Thread thread, Thread thread2) {
        Map map;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new C0742yn());
        try {
            map = this.f346a.c();
        } catch (SecurityException unused) {
            map = null;
        }
        if (map != null) {
            treeMap.putAll(map);
        }
        if (thread2 != null) {
            treeMap.remove(thread2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread3 = (Thread) entry.getKey();
            if (thread3 != thread && thread3 != thread2) {
                arrayList.add((C0617tn) this.b.apply(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }

    public An(InterfaceC0767zn interfaceC0767zn, Ga ga, M6 m6) {
        this.f346a = interfaceC0767zn;
        this.b = ga;
        this.c = m6;
    }
}
