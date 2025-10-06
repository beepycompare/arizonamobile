package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.dd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0201dd {

    /* renamed from: a  reason: collision with root package name */
    public final Map f843a;
    public final Object b;

    public C0201dd(Object obj) {
        this(new HashMap(), obj);
    }

    public final void a(Object obj, Object obj2) {
        this.f843a.put(obj, obj2);
    }

    public C0201dd(HashMap hashMap, Object obj) {
        this.f843a = hashMap;
        this.b = obj;
    }

    public final Object a(Object obj) {
        Object obj2 = this.f843a.get(obj);
        return obj2 == null ? this.b : obj2;
    }
}
