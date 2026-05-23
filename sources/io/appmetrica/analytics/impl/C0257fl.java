package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.fl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0257fl {

    /* renamed from: a  reason: collision with root package name */
    public final C0448n5 f983a;
    public final C0775zl b;
    public final C0334il c;
    public long d;
    public long e;
    public long f;
    public AtomicLong g;
    public boolean h;
    public long i;
    public long j;
    public boolean k;
    public final SystemTimeProvider l;

    public C0257fl(C0448n5 c0448n5, C0775zl c0775zl, C0334il c0334il, SystemTimeProvider systemTimeProvider) {
        this.f983a = c0448n5;
        this.b = c0775zl;
        this.c = c0334il;
        this.l = systemTimeProvider;
        a();
    }

    public final void a() {
        C0334il c0334il = this.c;
        long elapsedRealtime = this.l.elapsedRealtime();
        Long l = c0334il.c;
        if (l != null) {
            elapsedRealtime = l.longValue();
        }
        this.e = elapsedRealtime;
        C0334il c0334il2 = this.c;
        long currentTimeMillis = this.l.currentTimeMillis();
        Long l2 = c0334il2.d;
        if (l2 != null) {
            currentTimeMillis = l2.longValue();
        }
        this.f = currentTimeMillis;
        Long l3 = this.c.b;
        this.d = l3 == null ? -1L : l3.longValue();
        Long l4 = this.c.f;
        this.g = new AtomicLong(l4 == null ? 0L : l4.longValue());
        Boolean bool = this.c.g;
        this.h = bool == null ? true : bool.booleanValue();
        Long l5 = this.c.h;
        long longValue = l5 != null ? l5.longValue() : 0L;
        this.i = longValue;
        C0334il c0334il3 = this.c;
        long j = longValue - this.e;
        Long l6 = c0334il3.i;
        if (l6 != null) {
            j = l6.longValue();
        }
        this.j = j;
        Boolean bool2 = this.c.j;
        this.k = bool2 == null ? false : bool2.booleanValue();
    }

    public final synchronized void b() {
        this.k = true;
        C0775zl c0775zl = this.b;
        c0775zl.a(C0775zl.k, Boolean.TRUE);
        c0775zl.a();
    }

    public final String toString() {
        return "Session{id=" + this.d + ", creationTime=" + this.e + ", sessionCreationCurrentTimeMillis=" + this.f + ", currentReportId=" + this.g + ", sessionRequestParams=null, sleepStart=" + this.i + ", aliveNeeded=" + this.h + ", crashedSession=" + this.k + AbstractJsonLexerKt.END_OBJ;
    }
}
