package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class Kc {

    /* renamed from: a  reason: collision with root package name */
    public final Map f560a;
    public final Object b;

    public Kc(Object obj) {
        this(new HashMap(), obj);
    }

    public final void a(Object obj, Object obj2) {
        this.f560a.put(obj, obj2);
    }

    public Kc(HashMap hashMap, Object obj) {
        this.f560a = hashMap;
        this.b = obj;
    }

    public final Object a(Object obj) {
        Object obj2 = this.f560a.get(obj);
        return obj2 == null ? this.b : obj2;
    }
}
