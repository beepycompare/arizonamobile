package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class Ec {

    /* renamed from: a  reason: collision with root package name */
    public final Map f558a;
    public final Object b;

    public Ec(Object obj) {
        this(new HashMap(), obj);
    }

    public final void a(Object obj, Object obj2) {
        this.f558a.put(obj, obj2);
    }

    public Ec(HashMap hashMap, Object obj) {
        this.f558a = hashMap;
        this.b = obj;
    }

    public final Object a(Object obj) {
        Object obj2 = this.f558a.get(obj);
        return obj2 == null ? this.b : obj2;
    }
}
