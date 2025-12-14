package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public final class En {

    /* renamed from: a  reason: collision with root package name */
    public final Dn f564a;
    public final BiFunction b;
    public final Df c;

    public En() {
        this(new Bn(), new C0420ma(), C0157c4.l().n());
    }

    public final ArrayList a(Thread thread, Thread thread2) {
        Map map;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new Cn());
        try {
            map = this.f564a.c();
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
                arrayList.add((C0707xn) this.b.apply(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }

    public En(Dn dn, C0420ma c0420ma, C0565s6 c0565s6) {
        this.f564a = dn;
        this.b = c0420ma;
        this.c = c0565s6;
    }
}
