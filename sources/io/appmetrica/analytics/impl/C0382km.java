package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.km  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0382km {
    public final Map A;
    public final C9 B;

    /* renamed from: a  reason: collision with root package name */
    public final String f981a;
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
    public final C0415m4 m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final String q;
    public final Hm r;
    public final C0724ye s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final C0208e3 x;
    public final C0438n2 y;
    public final Dm z;

    public C0382km(C0356jm c0356jm) {
        String str;
        long j;
        long j2;
        Dm dm;
        Dm dm2;
        Map map;
        Map map2;
        C9 c9;
        this.f981a = c0356jm.f961a;
        List list = c0356jm.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = c0356jm.c;
        this.d = c0356jm.d;
        this.e = c0356jm.e;
        List list2 = c0356jm.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = c0356jm.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = c0356jm.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map3 = c0356jm.i;
        this.i = map3 != null ? CollectionUtils.unmodifiableMapCopy(map3) : null;
        this.j = c0356jm.j;
        this.k = c0356jm.k;
        this.m = c0356jm.m;
        this.s = c0356jm.n;
        this.n = c0356jm.o;
        this.o = c0356jm.p;
        this.l = c0356jm.l;
        this.p = c0356jm.q;
        str = c0356jm.r;
        this.q = str;
        this.r = c0356jm.s;
        j = c0356jm.t;
        this.u = j;
        j2 = c0356jm.u;
        this.v = j2;
        this.w = c0356jm.v;
        RetryPolicyConfig retryPolicyConfig = c0356jm.w;
        if (retryPolicyConfig == null) {
            C0707xm c0707xm = new C0707xm();
            this.t = new RetryPolicyConfig(c0707xm.w, c0707xm.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = c0356jm.x;
        this.y = c0356jm.y;
        dm = c0356jm.z;
        if (dm != null) {
            dm2 = c0356jm.z;
        } else {
            dm2 = new Dm(J7.b.f1174a);
        }
        this.z = dm2;
        map = c0356jm.A;
        if (map != null) {
            map2 = c0356jm.A;
        } else {
            map2 = Collections.emptyMap();
        }
        this.A = map2;
        c9 = c0356jm.B;
        this.B = c9;
    }

    public final C0356jm a(C0415m4 c0415m4) {
        C0356jm c0356jm = new C0356jm(c0415m4);
        c0356jm.f961a = this.f981a;
        c0356jm.f = this.f;
        c0356jm.g = this.g;
        c0356jm.j = this.j;
        c0356jm.b = this.b;
        c0356jm.c = this.c;
        c0356jm.d = this.d;
        c0356jm.e = this.e;
        c0356jm.h = this.h;
        c0356jm.i = this.i;
        c0356jm.k = this.k;
        c0356jm.l = this.l;
        c0356jm.q = this.p;
        c0356jm.o = this.n;
        c0356jm.p = this.o;
        c0356jm.r = this.q;
        c0356jm.n = this.s;
        c0356jm.t = this.u;
        c0356jm.u = this.v;
        c0356jm.s = this.r;
        c0356jm.v = this.w;
        c0356jm.w = this.t;
        c0356jm.x = this.x;
        c0356jm.y = this.y;
        c0356jm.z = this.z;
        c0356jm.A = this.A;
        c0356jm.B = this.B;
        return c0356jm;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f981a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", cacheControl=" + this.x + ", attributionConfig=" + this.y + ", startupUpdateConfig=" + this.z + ", modulesRemoteConfigs=" + this.A + ", externalAttributionConfig=" + this.B + AbstractJsonLexerKt.END_OBJ;
    }
}
