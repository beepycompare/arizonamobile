package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/* renamed from: io.appmetrica.analytics.impl.xn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0715xn {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0690wn f1133a;
    public final BiFunction b;
    public final J6 c;

    public C0715xn() {
        this(new C0640un(), new Ea(), C0696x4.l().n());
    }

    public final ArrayList a(Thread thread, Thread thread2) {
        Map map;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new C0665vn());
        try {
            map = this.f1133a.c();
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
                arrayList.add((C0541qn) this.b.apply(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }

    public C0715xn(InterfaceC0690wn interfaceC0690wn, Ea ea, J6 j6) {
        this.f1133a = interfaceC0690wn;
        this.b = ea;
        this.c = j6;
    }
}
