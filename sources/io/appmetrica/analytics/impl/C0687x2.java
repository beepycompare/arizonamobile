package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.x2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0687x2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0143bf f1197a;
    public final long b;
    public final long c;
    public final SystemTimeProvider d;
    public final Map e;

    public C0687x2(X4 x4, C0143bf c0143bf) {
        this.f1197a = c0143bf;
        x4.b();
        this.b = TimeUnit.MINUTES.toMillis(1L);
        this.c = TimeUnit.DAYS.toMillis(7L);
        this.d = new SystemTimeProvider();
        Map<String, Long> f = c0143bf.f();
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
