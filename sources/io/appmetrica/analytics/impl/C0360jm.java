package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.jm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0360jm {
    public final Map A;
    public final B9 B;

    /* renamed from: a  reason: collision with root package name */
    public final String f1068a;
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
    public final C0393l4 m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final String q;
    public final Gm r;
    public final C0702xe s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final C0187d3 x;
    public final C0416m2 y;
    public final Cm z;

    public C0360jm(C0334im c0334im) {
        String str;
        long j;
        long j2;
        Cm cm;
        Cm cm2;
        Map map;
        Map map2;
        B9 b9;
        this.f1068a = c0334im.f1049a;
        List list = c0334im.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = c0334im.c;
        this.d = c0334im.d;
        this.e = c0334im.e;
        List list2 = c0334im.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = c0334im.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = c0334im.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map3 = c0334im.i;
        this.i = map3 != null ? CollectionUtils.unmodifiableMapCopy(map3) : null;
        this.j = c0334im.j;
        this.k = c0334im.k;
        this.m = c0334im.m;
        this.s = c0334im.n;
        this.n = c0334im.o;
        this.o = c0334im.p;
        this.l = c0334im.l;
        this.p = c0334im.q;
        str = c0334im.r;
        this.q = str;
        this.r = c0334im.s;
        j = c0334im.t;
        this.u = j;
        j2 = c0334im.u;
        this.v = j2;
        this.w = c0334im.v;
        RetryPolicyConfig retryPolicyConfig = c0334im.w;
        if (retryPolicyConfig == null) {
            C0685wm c0685wm = new C0685wm();
            this.t = new RetryPolicyConfig(c0685wm.w, c0685wm.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = c0334im.x;
        this.y = c0334im.y;
        cm = c0334im.z;
        if (cm != null) {
            cm2 = c0334im.z;
        } else {
            cm2 = new Cm(I7.b.f1261a);
        }
        this.z = cm2;
        map = c0334im.A;
        if (map != null) {
            map2 = c0334im.A;
        } else {
            map2 = Collections.emptyMap();
        }
        this.A = map2;
        b9 = c0334im.B;
        this.B = b9;
    }

    public final C0334im a(C0393l4 c0393l4) {
        C0334im c0334im = new C0334im(c0393l4);
        c0334im.f1049a = this.f1068a;
        c0334im.f = this.f;
        c0334im.g = this.g;
        c0334im.j = this.j;
        c0334im.b = this.b;
        c0334im.c = this.c;
        c0334im.d = this.d;
        c0334im.e = this.e;
        c0334im.h = this.h;
        c0334im.i = this.i;
        c0334im.k = this.k;
        c0334im.l = this.l;
        c0334im.q = this.p;
        c0334im.o = this.n;
        c0334im.p = this.o;
        c0334im.r = this.q;
        c0334im.n = this.s;
        c0334im.t = this.u;
        c0334im.u = this.v;
        c0334im.s = this.r;
        c0334im.v = this.w;
        c0334im.w = this.t;
        c0334im.x = this.x;
        c0334im.y = this.y;
        c0334im.z = this.z;
        c0334im.A = this.A;
        c0334im.B = this.B;
        return c0334im;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f1068a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", cacheControl=" + this.x + ", attributionConfig=" + this.y + ", startupUpdateConfig=" + this.z + ", modulesRemoteConfigs=" + this.A + ", externalAttributionConfig=" + this.B + AbstractJsonLexerKt.END_OBJ;
    }
}
