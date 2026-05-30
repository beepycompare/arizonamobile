package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Lm {
    public final Map A;
    public final W9 B;

    /* renamed from: a  reason: collision with root package name */
    public final String f651a;
    public final List b;
    public final String c;
    public final String d;
    public final String e;
    public final List f;
    public final List g;
    public final List h;
    public final Map i;
    public final String j;
    public final String k;
    public final String l;
    public final C4 m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final String q;
    public final C0336in r;
    public final Ye s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final C0601t3 x;
    public final C0756z2 y;
    public final C0233en z;

    public Lm(Km km) {
        String str;
        long j;
        long j2;
        C0233en c0233en;
        C0233en c0233en2;
        Map map;
        Map map2;
        W9 w9;
        this.f651a = km.f633a;
        List list = km.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = km.c;
        this.d = km.d;
        this.e = km.e;
        List list2 = km.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = km.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = km.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map3 = km.i;
        this.i = map3 != null ? CollectionUtils.unmodifiableMapCopy(map3) : null;
        this.j = km.j;
        this.k = km.k;
        this.m = km.m;
        this.s = km.n;
        this.n = km.o;
        this.o = km.p;
        this.l = km.l;
        this.p = km.q;
        str = km.r;
        this.q = str;
        this.r = km.s;
        j = km.t;
        this.u = j;
        j2 = km.u;
        this.v = j2;
        this.w = km.v;
        RetryPolicyConfig retryPolicyConfig = km.w;
        if (retryPolicyConfig == null) {
            Ym ym = new Ym();
            this.t = new RetryPolicyConfig(ym.w, ym.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = km.x;
        this.y = km.y;
        c0233en = km.z;
        if (c0233en != null) {
            c0233en2 = km.z;
        } else {
            c0233en2 = new C0233en(AbstractC0115a8.b.f831a);
        }
        this.z = c0233en2;
        map = km.A;
        if (map != null) {
            map2 = km.A;
        } else {
            map2 = Collections.emptyMap();
        }
        this.A = map2;
        w9 = km.B;
        this.B = w9;
    }

    public final Km a(C4 c4) {
        Km km = new Km(c4);
        km.f633a = this.f651a;
        km.f = this.f;
        km.g = this.g;
        km.j = this.j;
        km.b = this.b;
        km.c = this.c;
        km.d = this.d;
        km.e = this.e;
        km.h = this.h;
        km.i = this.i;
        km.k = this.k;
        km.l = this.l;
        km.q = this.p;
        km.o = this.n;
        km.p = this.o;
        km.r = this.q;
        km.n = this.s;
        km.t = this.u;
        km.u = this.v;
        km.s = this.r;
        km.v = this.w;
        km.w = this.t;
        km.x = this.x;
        km.y = this.y;
        km.z = this.z;
        km.A = this.A;
        km.B = this.B;
        return km;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f651a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", cacheControl=" + this.x + ", attributionConfig=" + this.y + ", startupUpdateConfig=" + this.z + ", modulesRemoteConfigs=" + this.A + ", externalAttributionConfig=" + this.B + AbstractJsonLexerKt.END_OBJ;
    }
}
