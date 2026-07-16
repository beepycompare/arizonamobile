package io.appmetrica.analytics.networkokhttp.impl;

import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
/* loaded from: classes6.dex */
public final class d extends EventListener {

    /* renamed from: a  reason: collision with root package name */
    public final TimeProvider f1383a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public String k;
    public boolean l;

    public d(TimeProvider timeProvider) {
        this.f1383a = timeProvider;
    }

    public static Long a(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return null;
        }
        return Long.valueOf(j2 - j);
    }

    @Override // okhttp3.EventListener
    public final void callFailed(Call call, IOException iOException) {
        long currentTimeMillis = this.f1383a.currentTimeMillis();
        if (this.b > 0 && this.c == 0) {
            this.c = currentTimeMillis;
        }
        if (this.d > 0 && this.e == 0) {
            this.e = currentTimeMillis;
        }
        if (this.f > 0 && this.g == 0) {
            this.g = currentTimeMillis;
        }
        if (this.i <= 0 || this.j != 0) {
            return;
        }
        this.j = currentTimeMillis;
    }

    @Override // okhttp3.EventListener
    public final void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        this.e = this.f1383a.currentTimeMillis();
    }

    @Override // okhttp3.EventListener
    public final void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        this.d = this.f1383a.currentTimeMillis();
    }

    @Override // okhttp3.EventListener
    public final void connectionAcquired(Call call, Connection connection) {
        this.l = this.d == 0;
        this.k = connection.protocol().toString();
    }

    @Override // okhttp3.EventListener
    public final void dnsEnd(Call call, String str, List list) {
        this.c = this.f1383a.currentTimeMillis();
    }

    @Override // okhttp3.EventListener
    public final void dnsStart(Call call, String str) {
        this.b = this.f1383a.currentTimeMillis();
    }

    @Override // okhttp3.EventListener
    public final void requestHeadersEnd(Call call, Request request) {
        this.h = this.f1383a.currentTimeMillis();
    }

    @Override // okhttp3.EventListener
    public final void responseBodyEnd(Call call, long j) {
        this.j = this.f1383a.currentTimeMillis();
    }

    @Override // okhttp3.EventListener
    public final void responseHeadersStart(Call call) {
        this.i = this.f1383a.currentTimeMillis();
    }

    @Override // okhttp3.EventListener
    public final void secureConnectEnd(Call call, Handshake handshake) {
        this.g = this.f1383a.currentTimeMillis();
    }

    @Override // okhttp3.EventListener
    public final void secureConnectStart(Call call) {
        this.f = this.f1383a.currentTimeMillis();
    }
}
