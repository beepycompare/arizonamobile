package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/* renamed from: io.appmetrica.analytics.impl.xn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0723xn {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0698wn f1132a;
    public final BiFunction b;
    public final J6 c;

    public C0723xn() {
        this(new C0648un(), new Ea(), C0704x4.l().n());
    }

    public final ArrayList a(Thread thread, Thread thread2) {
        Map map;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new C0673vn());
        try {
            map = this.f1132a.c();
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
                arrayList.add((C0549qn) this.b.apply(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }

    public C0723xn(InterfaceC0698wn interfaceC0698wn, Ea ea, J6 j6) {
        this.f1132a = interfaceC0698wn;
        this.b = ea;
        this.c = j6;
    }
}
