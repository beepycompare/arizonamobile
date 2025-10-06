package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Nk {

    /* renamed from: a  reason: collision with root package name */
    public final C0652v5 f600a;
    public final C0234el b;
    public final Qk c;
    public long d;
    public long e;
    public AtomicLong f;
    public boolean g;
    public volatile C0183cl h;
    public long i;
    public long j;
    public final SystemTimeProvider k;

    public Nk(C0652v5 c0652v5, C0234el c0234el, Qk qk, SystemTimeProvider systemTimeProvider) {
        this.f600a = c0652v5;
        this.b = c0234el;
        this.c = qk;
        this.k = systemTimeProvider;
        a();
    }

    public final void a() {
        Qk qk = this.c;
        long elapsedRealtime = this.k.elapsedRealtime();
        Long l = qk.c;
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
        Qk qk2 = this.c;
        long j = longValue - this.e;
        Long l5 = qk2.h;
        if (l5 != null) {
            j = l5.longValue();
        }
        this.j = j;
    }

    public final String toString() {
        return "Session{id=" + this.d + ", creationTime=" + this.e + ", currentReportId=" + this.f + ", sessionRequestParams=" + this.h + ", sleepStart=" + this.i + AbstractJsonLexerKt.END_OBJ;
    }
}
