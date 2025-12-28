package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.km  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0381km {
    public final Map A;
    public final C9 B;

    /* renamed from: a  reason: collision with root package name */
    public final String f1079a;
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
    public final C0414m4 m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final String q;
    public final Hm r;
    public final C0723ye s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final C0207e3 x;
    public final C0437n2 y;
    public final Dm z;

    public C0381km(C0355jm c0355jm) {
        String str;
        long j;
        long j2;
        Dm dm;
        Dm dm2;
        Map map;
        Map map2;
        C9 c9;
        this.f1079a = c0355jm.f1059a;
        List list = c0355jm.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = c0355jm.c;
        this.d = c0355jm.d;
        this.e = c0355jm.e;
        List list2 = c0355jm.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = c0355jm.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = c0355jm.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map3 = c0355jm.i;
        this.i = map3 != null ? CollectionUtils.unmodifiableMapCopy(map3) : null;
        this.j = c0355jm.j;
        this.k = c0355jm.k;
        this.m = c0355jm.m;
        this.s = c0355jm.n;
        this.n = c0355jm.o;
        this.o = c0355jm.p;
        this.l = c0355jm.l;
        this.p = c0355jm.q;
        str = c0355jm.r;
        this.q = str;
        this.r = c0355jm.s;
        j = c0355jm.t;
        this.u = j;
        j2 = c0355jm.u;
        this.v = j2;
        this.w = c0355jm.v;
        RetryPolicyConfig retryPolicyConfig = c0355jm.w;
        if (retryPolicyConfig == null) {
            C0706xm c0706xm = new C0706xm();
            this.t = new RetryPolicyConfig(c0706xm.w, c0706xm.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = c0355jm.x;
        this.y = c0355jm.y;
        dm = c0355jm.z;
        if (dm != null) {
            dm2 = c0355jm.z;
        } else {
            dm2 = new Dm(J7.b.f1272a);
        }
        this.z = dm2;
        map = c0355jm.A;
        if (map != null) {
            map2 = c0355jm.A;
        } else {
            map2 = Collections.emptyMap();
        }
        this.A = map2;
        c9 = c0355jm.B;
        this.B = c9;
    }

    public final C0355jm a(C0414m4 c0414m4) {
        C0355jm c0355jm = new C0355jm(c0414m4);
        c0355jm.f1059a = this.f1079a;
        c0355jm.f = this.f;
        c0355jm.g = this.g;
        c0355jm.j = this.j;
        c0355jm.b = this.b;
        c0355jm.c = this.c;
        c0355jm.d = this.d;
        c0355jm.e = this.e;
        c0355jm.h = this.h;
        c0355jm.i = this.i;
        c0355jm.k = this.k;
        c0355jm.l = this.l;
        c0355jm.q = this.p;
        c0355jm.o = this.n;
        c0355jm.p = this.o;
        c0355jm.r = this.q;
        c0355jm.n = this.s;
        c0355jm.t = this.u;
        c0355jm.u = this.v;
        c0355jm.s = this.r;
        c0355jm.v = this.w;
        c0355jm.w = this.t;
        c0355jm.x = this.x;
        c0355jm.y = this.y;
        c0355jm.z = this.z;
        c0355jm.A = this.A;
        c0355jm.B = this.B;
        return c0355jm;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f1079a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", cacheControl=" + this.x + ", attributionConfig=" + this.y + ", startupUpdateConfig=" + this.z + ", modulesRemoteConfigs=" + this.A + ", externalAttributionConfig=" + this.B + AbstractJsonLexerKt.END_OBJ;
    }
}
