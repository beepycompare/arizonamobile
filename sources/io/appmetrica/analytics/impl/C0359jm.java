package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.jm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0359jm {
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
    public final C0392l4 m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final String q;
    public final Gm r;
    public final C0701xe s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final C0186d3 x;
    public final C0415m2 y;
    public final Cm z;

    public C0359jm(C0333im c0333im) {
        String str;
        long j;
        long j2;
        Cm cm;
        Cm cm2;
        Map map;
        Map map2;
        B9 b9;
        this.f1068a = c0333im.f1049a;
        List list = c0333im.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = c0333im.c;
        this.d = c0333im.d;
        this.e = c0333im.e;
        List list2 = c0333im.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = c0333im.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = c0333im.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map3 = c0333im.i;
        this.i = map3 != null ? CollectionUtils.unmodifiableMapCopy(map3) : null;
        this.j = c0333im.j;
        this.k = c0333im.k;
        this.m = c0333im.m;
        this.s = c0333im.n;
        this.n = c0333im.o;
        this.o = c0333im.p;
        this.l = c0333im.l;
        this.p = c0333im.q;
        str = c0333im.r;
        this.q = str;
        this.r = c0333im.s;
        j = c0333im.t;
        this.u = j;
        j2 = c0333im.u;
        this.v = j2;
        this.w = c0333im.v;
        RetryPolicyConfig retryPolicyConfig = c0333im.w;
        if (retryPolicyConfig == null) {
            C0684wm c0684wm = new C0684wm();
            this.t = new RetryPolicyConfig(c0684wm.w, c0684wm.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = c0333im.x;
        this.y = c0333im.y;
        cm = c0333im.z;
        if (cm != null) {
            cm2 = c0333im.z;
        } else {
            cm2 = new Cm(I7.b.f1261a);
        }
        this.z = cm2;
        map = c0333im.A;
        if (map != null) {
            map2 = c0333im.A;
        } else {
            map2 = Collections.emptyMap();
        }
        this.A = map2;
        b9 = c0333im.B;
        this.B = b9;
    }

    public final C0333im a(C0392l4 c0392l4) {
        C0333im c0333im = new C0333im(c0392l4);
        c0333im.f1049a = this.f1068a;
        c0333im.f = this.f;
        c0333im.g = this.g;
        c0333im.j = this.j;
        c0333im.b = this.b;
        c0333im.c = this.c;
        c0333im.d = this.d;
        c0333im.e = this.e;
        c0333im.h = this.h;
        c0333im.i = this.i;
        c0333im.k = this.k;
        c0333im.l = this.l;
        c0333im.q = this.p;
        c0333im.o = this.n;
        c0333im.p = this.o;
        c0333im.r = this.q;
        c0333im.n = this.s;
        c0333im.t = this.u;
        c0333im.u = this.v;
        c0333im.s = this.r;
        c0333im.v = this.w;
        c0333im.w = this.t;
        c0333im.x = this.x;
        c0333im.y = this.y;
        c0333im.z = this.z;
        c0333im.A = this.A;
        c0333im.B = this.B;
        return c0333im;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f1068a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", cacheControl=" + this.x + ", attributionConfig=" + this.y + ", startupUpdateConfig=" + this.z + ", modulesRemoteConfigs=" + this.A + ", externalAttributionConfig=" + this.B + AbstractJsonLexerKt.END_OBJ;
    }
}
