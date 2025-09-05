package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.w2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0673w2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0537qf f1130a;
    public final long b;
    public final long c;
    public final SystemTimeProvider d;
    public final Map e;

    public C0673w2(C0476o5 c0476o5, C0537qf c0537qf) {
        this.f1130a = c0537qf;
        c0476o5.b();
        this.b = TimeUnit.MINUTES.toMillis(1L);
        this.c = TimeUnit.DAYS.toMillis(7L);
        this.d = new SystemTimeProvider();
        Map<String, Long> f = c0537qf.f();
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
