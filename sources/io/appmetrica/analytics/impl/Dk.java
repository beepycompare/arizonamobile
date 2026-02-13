package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Dk {

    /* renamed from: a  reason: collision with root package name */
    public final X4 f554a;
    public final Uk b;
    public final Gk c;
    public long d;
    public long e;
    public AtomicLong f;
    public boolean g;
    public volatile Sk h;
    public long i;
    public long j;
    public final SystemTimeProvider k;

    public Dk(X4 x4, Uk uk, Gk gk, SystemTimeProvider systemTimeProvider) {
        this.f554a = x4;
        this.b = uk;
        this.c = gk;
        this.k = systemTimeProvider;
        a();
    }

    public final void a() {
        Gk gk = this.c;
        long elapsedRealtime = this.k.elapsedRealtime();
        Long l = gk.c;
        if (l != null) {
            elapsedRealtime = l.longValue();
        }
        this.e = elapsedRealtime;
        Long l2 = this.c.b;
        this.d = l2 == null ? -1L : l2.longValue();
        Long l3 = this.c.e;
        this.f = new AtomicLong(l3 == null ? 0L : l3.longValue());
        Boolean bool = this.c.f;
        this.g = bool == null ? true : bool.booleanValue();
        Long l4 = this.c.g;
        long longValue = l4 != null ? l4.longValue() : 0L;
        this.i = longValue;
        Gk gk2 = this.c;
        long j = longValue - this.e;
        Long l5 = gk2.h;
        if (l5 != null) {
            j = l5.longValue();
        }
        this.j = j;
    }

    public final String toString() {
        return "Session{id=" + this.d + ", creationTime=" + this.e + ", currentReportId=" + this.f + ", sessionRequestParams=" + this.h + ", sleepStart=" + this.i + AbstractJsonLexerKt.END_OBJ;
    }
}
