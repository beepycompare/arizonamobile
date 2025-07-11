package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Bk {

    /* renamed from: a  reason: collision with root package name */
    public final C0572s5 f360a;
    public final Sk b;
    public final Ek c;
    public long d;
    public long e;
    public AtomicLong f;
    public boolean g;
    public volatile Qk h;
    public long i;
    public long j;
    public final SystemTimeProvider k;

    public Bk(C0572s5 c0572s5, Sk sk, Ek ek, SystemTimeProvider systemTimeProvider) {
        this.f360a = c0572s5;
        this.b = sk;
        this.c = ek;
        this.k = systemTimeProvider;
        a();
    }

    public final void a() {
        Ek ek = this.c;
        long elapsedRealtime = this.k.elapsedRealtime();
        Long l = ek.c;
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
        Ek ek2 = this.c;
        long j = longValue - this.e;
        Long l5 = ek2.h;
        if (l5 != null) {
            j = l5.longValue();
        }
        this.j = j;
    }

    public final String toString() {
        return "Session{id=" + this.d + ", creationTime=" + this.e + ", currentReportId=" + this.f + ", sessionRequestParams=" + this.h + ", sleepStart=" + this.i + AbstractJsonLexerKt.END_OBJ;
    }
}
