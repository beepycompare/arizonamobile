package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Ek {

    /* renamed from: a  reason: collision with root package name */
    public final Y4 f465a;
    public final Vk b;
    public final Hk c;
    public long d;
    public long e;
    public AtomicLong f;
    public boolean g;
    public volatile Tk h;
    public long i;
    public long j;
    public final SystemTimeProvider k;

    public Ek(Y4 y4, Vk vk, Hk hk, SystemTimeProvider systemTimeProvider) {
        this.f465a = y4;
        this.b = vk;
        this.c = hk;
        this.k = systemTimeProvider;
        a();
    }

    public final void a() {
        Hk hk = this.c;
        long elapsedRealtime = this.k.elapsedRealtime();
        Long l = hk.c;
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
        Hk hk2 = this.c;
        long j = longValue - this.e;
        Long l5 = hk2.h;
        if (l5 != null) {
            j = l5.longValue();
        }
        this.j = j;
    }

    public final String toString() {
        return "Session{id=" + this.d + ", creationTime=" + this.e + ", currentReportId=" + this.f + ", sessionRequestParams=" + this.h + ", sleepStart=" + this.i + AbstractJsonLexerKt.END_OBJ;
    }
}
