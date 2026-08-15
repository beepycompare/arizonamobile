package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.fl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0256fl {

    /* renamed from: a  reason: collision with root package name */
    public final C0447n5 f986a;
    public final C0774zl b;
    public final C0333il c;
    public long d;
    public long e;
    public long f;
    public AtomicLong g;
    public boolean h;
    public long i;
    public long j;
    public boolean k;
    public final SystemTimeProvider l;

    public C0256fl(C0447n5 c0447n5, C0774zl c0774zl, C0333il c0333il, SystemTimeProvider systemTimeProvider) {
        this.f986a = c0447n5;
        this.b = c0774zl;
        this.c = c0333il;
        this.l = systemTimeProvider;
        a();
    }

    public final void a() {
        C0333il c0333il = this.c;
        long elapsedRealtime = this.l.elapsedRealtime();
        Long l = c0333il.c;
        if (l != null) {
            elapsedRealtime = l.longValue();
        }
        this.e = elapsedRealtime;
        C0333il c0333il2 = this.c;
        long currentTimeMillis = this.l.currentTimeMillis();
        Long l2 = c0333il2.d;
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
        C0333il c0333il3 = this.c;
        long j = longValue - this.e;
        Long l6 = c0333il3.i;
        if (l6 != null) {
            j = l6.longValue();
        }
        this.j = j;
        Boolean bool2 = this.c.j;
        this.k = bool2 == null ? false : bool2.booleanValue();
    }

    public final synchronized void b() {
        this.k = true;
        C0774zl c0774zl = this.b;
        c0774zl.a(C0774zl.k, Boolean.TRUE);
        c0774zl.a();
    }

    public final String toString() {
        return "Session{id=" + this.d + ", creationTime=" + this.e + ", sessionCreationCurrentTimeMillis=" + this.f + ", currentReportId=" + this.g + ", sessionRequestParams=null, sleepStart=" + this.i + ", aliveNeeded=" + this.h + ", crashedSession=" + this.k + AbstractJsonLexerKt.END_OBJ;
    }
}
