package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public final class Dn {

    /* renamed from: a  reason: collision with root package name */
    public final Cn f557a;
    public final BiFunction b;
    public final Cf c;

    public Dn() {
        this(new An(), new C0399la(), C0136b4.l().n());
    }

    public final ArrayList a(Thread thread, Thread thread2) {
        Map map;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new Bn());
        try {
            map = this.f557a.c();
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
                arrayList.add((C0686wn) this.b.apply(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }

    public Dn(Cn cn, C0399la c0399la, C0544r6 c0544r6) {
        this.f557a = cn;
        this.b = c0399la;
        this.c = c0544r6;
    }
}
