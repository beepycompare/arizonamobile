package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public final class Dn {

    /* renamed from: a  reason: collision with root package name */
    public final Cn f556a;
    public final BiFunction b;
    public final Cf c;

    public Dn() {
        this(new An(), new C0398la(), C0135b4.l().n());
    }

    public final ArrayList a(Thread thread, Thread thread2) {
        Map map;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new Bn());
        try {
            map = this.f556a.c();
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
                arrayList.add((C0685wn) this.b.apply(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }

    public Dn(Cn cn, C0398la c0398la, C0543r6 c0543r6) {
        this.f556a = cn;
        this.b = c0398la;
        this.c = c0543r6;
    }
}
