package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ad  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0122ad {

    /* renamed from: a  reason: collision with root package name */
    public final Map f776a;
    public final Object b;

    public C0122ad(Object obj) {
        this(new HashMap(), obj);
    }

    public final void a(Object obj, Object obj2) {
        this.f776a.put(obj, obj2);
    }

    public C0122ad(HashMap hashMap, Object obj) {
        this.f776a = hashMap;
        this.b = obj;
    }

    public final Object a(Object obj) {
        Object obj2 = this.f776a.get(obj);
        return obj2 == null ? this.b : obj2;
    }
}
