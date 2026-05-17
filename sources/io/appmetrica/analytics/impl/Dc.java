package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class Dc {

    /* renamed from: a  reason: collision with root package name */
    public final Map f554a;
    public final Object b;

    public Dc(Object obj) {
        this(new HashMap(), obj);
    }

    public final void a(Object obj, Object obj2) {
        this.f554a.put(obj, obj2);
    }

    public Dc(HashMap hashMap, Object obj) {
        this.f554a = hashMap;
        this.b = obj;
    }

    public final Object a(Object obj) {
        Object obj2 = this.f554a.get(obj);
        return obj2 == null ? this.b : obj2;
    }
}
