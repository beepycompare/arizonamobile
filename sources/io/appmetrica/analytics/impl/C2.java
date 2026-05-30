package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class C2 {

    /* renamed from: a  reason: collision with root package name */
    public final C0691wf f485a;
    public final long b;
    public final long c;
    public final SystemTimeProvider d;
    public final Map e;

    public C2(C0267g5 c0267g5, C0691wf c0691wf) {
        this.f485a = c0691wf;
        c0267g5.b();
        this.b = TimeUnit.MINUTES.toMillis(1L);
        this.c = TimeUnit.DAYS.toMillis(7L);
        this.d = new SystemTimeProvider();
        Map<String, Long> f = c0691wf.f();
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
