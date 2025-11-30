package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public final class En {

    /* renamed from: a  reason: collision with root package name */
    public final Dn f467a;
    public final BiFunction b;
    public final Df c;

    public En() {
        this(new Bn(), new C0421ma(), C0158c4.l().n());
    }

    public final ArrayList a(Thread thread, Thread thread2) {
        Map map;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new Cn());
        try {
            map = this.f467a.c();
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
                arrayList.add((C0708xn) this.b.apply(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }

    public En(Dn dn, C0421ma c0421ma, C0566s6 c0566s6) {
        this.f467a = dn;
        this.b = c0421ma;
        this.c = c0566s6;
    }
}
