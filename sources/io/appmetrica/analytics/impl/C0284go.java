package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/* renamed from: io.appmetrica.analytics.impl.go  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0284go {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0258fo f1005a;
    public final BiFunction b;
    public final InterfaceC0199dg c;

    public C0284go() {
        this(new Cdo(), new Ia(), C0574s4.l().n());
    }

    public final ArrayList a(Thread thread, Thread thread2) {
        Map map;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new C0232eo());
        try {
            map = this.f1005a.c();
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
                arrayList.add((Zn) this.b.apply(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }

    public C0284go(InterfaceC0258fo interfaceC0258fo, Ia ia, J6 j6) {
        this.f1005a = interfaceC0258fo;
        this.b = ia;
        this.c = j6;
    }
}
