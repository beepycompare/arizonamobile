package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class Wc {

    /* renamed from: a  reason: collision with root package name */
    public final Map f687a;
    public final Object b;

    public Wc(Object obj) {
        this(new HashMap(), obj);
    }

    public final void a(Object obj, Object obj2) {
        this.f687a.put(obj, obj2);
    }

    public Wc(HashMap hashMap, Object obj) {
        this.f687a = hashMap;
        this.b = obj;
    }

    public final Object a(Object obj) {
        Object obj2 = this.f687a.get(obj);
        return obj2 == null ? this.b : obj2;
    }
}
