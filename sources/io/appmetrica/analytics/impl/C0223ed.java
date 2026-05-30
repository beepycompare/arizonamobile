package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ed  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0223ed {

    /* renamed from: a  reason: collision with root package name */
    public final Map f962a;
    public final Object b;

    public C0223ed(Object obj) {
        this(new HashMap(), obj);
    }

    public final void a(Object obj, Object obj2) {
        this.f962a.put(obj, obj2);
    }

    public C0223ed(HashMap hashMap, Object obj) {
        this.f962a = hashMap;
        this.b = obj;
    }

    public final Object a(Object obj) {
        Object obj2 = this.f962a.get(obj);
        return obj2 == null ? this.b : obj2;
    }
}
