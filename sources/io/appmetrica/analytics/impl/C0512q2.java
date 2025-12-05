package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.q2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0512q2 {

    /* renamed from: a  reason: collision with root package name */
    public final Xe f1162a;
    public final long b;
    public final long c;
    public final SystemTimeProvider d;
    public final Map e;

    public C0512q2(R4 r4, Xe xe) {
        this.f1162a = xe;
        r4.b();
        this.b = TimeUnit.MINUTES.toMillis(1L);
        this.c = TimeUnit.DAYS.toMillis(7L);
        this.d = new SystemTimeProvider();
        Map<String, Long> f = xe.f();
        a(f);
        this.e = f;
    }

    public final void a(Map map) {
        long currentTimeMillis = this.d.currentTimeMillis();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (((Number) entry.getValue()).longValue() < currentTimeMillis - this.c) {
                linkedHashSet.add(str);
            }
        }
        for (String str2 : linkedHashSet) {
            map.remove(str2);
        }
    }
}
