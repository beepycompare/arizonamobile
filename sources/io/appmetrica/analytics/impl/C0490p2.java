package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.p2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0490p2 {

    /* renamed from: a  reason: collision with root package name */
    public final We f1171a;
    public final long b;
    public final long c;
    public final SystemTimeProvider d;
    public final Map e;

    public C0490p2(Q4 q4, We we) {
        this.f1171a = we;
        q4.b();
        this.b = TimeUnit.MINUTES.toMillis(1L);
        this.c = TimeUnit.DAYS.toMillis(7L);
        this.d = new SystemTimeProvider();
        Map<String, Long> f = we.f();
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
