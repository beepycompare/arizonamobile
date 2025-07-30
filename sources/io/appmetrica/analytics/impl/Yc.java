package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class Yc {

    /* renamed from: a  reason: collision with root package name */
    public final Map f734a;
    public final Object b;

    public Yc(Object obj) {
        this(new HashMap(), obj);
    }

    public final void a(Object obj, Object obj2) {
        this.f734a.put(obj, obj2);
    }

    public Yc(HashMap hashMap, Object obj) {
        this.f734a = hashMap;
        this.b = obj;
    }

    public final Object a(Object obj) {
        Object obj2 = this.f734a.get(obj);
        return obj2 == null ? this.b : obj2;
    }
}
