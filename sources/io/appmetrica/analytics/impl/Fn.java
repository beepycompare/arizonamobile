package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public final class Fn {

    /* renamed from: a  reason: collision with root package name */
    public final En f480a;
    public final BiFunction b;
    public final Hf c;

    public Fn() {
        this(new Cn(), new C0570sa(), C0338j4.l().n());
    }

    public final ArrayList a(Thread thread, Thread thread2) {
        Map map;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new Dn());
        try {
            map = this.f480a.c();
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
                arrayList.add((C0733yn) this.b.apply(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }

    public Fn(En en, C0570sa c0570sa, C0716y6 c0716y6) {
        this.f480a = en;
        this.b = c0570sa;
        this.c = c0716y6;
    }
}
