package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.jm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0368jm {
    public final Dm A;
    public final Map B;
    public final W9 C;

    /* renamed from: a  reason: collision with root package name */
    public final String f917a;
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
    public final G4 m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final String q;
    public final Hm r;
    public final Le s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final BillingConfig x;
    public final C0748z3 y;
    public final C0547r2 z;

    public C0368jm(C0343im c0343im) {
        String str;
        long j;
        long j2;
        Dm dm;
        Dm dm2;
        Map map;
        Map map2;
        W9 w9;
        this.f917a = c0343im.f905a;
        List list = c0343im.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = c0343im.c;
        this.d = c0343im.d;
        this.e = c0343im.e;
        List list2 = c0343im.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = c0343im.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = c0343im.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map3 = c0343im.i;
        this.i = map3 != null ? CollectionUtils.unmodifiableMapCopy(map3) : null;
        this.j = c0343im.j;
        this.k = c0343im.k;
        this.m = c0343im.m;
        this.s = c0343im.n;
        this.n = c0343im.o;
        this.o = c0343im.p;
        this.l = c0343im.l;
        this.p = c0343im.q;
        str = c0343im.r;
        this.q = str;
        this.r = c0343im.s;
        j = c0343im.t;
        this.u = j;
        j2 = c0343im.u;
        this.v = j2;
        this.w = c0343im.v;
        RetryPolicyConfig retryPolicyConfig = c0343im.w;
        if (retryPolicyConfig == null) {
            C0717xm c0717xm = new C0717xm();
            this.t = new RetryPolicyConfig(c0717xm.w, c0717xm.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = c0343im.x;
        this.y = c0343im.y;
        this.z = c0343im.z;
        dm = c0343im.A;
        if (dm != null) {
            dm2 = c0343im.A;
        } else {
            dm2 = new Dm(AbstractC0177c8.b.f1105a);
        }
        this.A = dm2;
        map = c0343im.B;
        if (map != null) {
            map2 = c0343im.B;
        } else {
            map2 = Collections.emptyMap();
        }
        this.B = map2;
        w9 = c0343im.C;
        this.C = w9;
    }

    public final C0343im a(G4 g4) {
        C0343im c0343im = new C0343im(g4);
        c0343im.f905a = this.f917a;
        c0343im.f = this.f;
        c0343im.g = this.g;
        c0343im.j = this.j;
        c0343im.b = this.b;
        c0343im.c = this.c;
        c0343im.d = this.d;
        c0343im.e = this.e;
        c0343im.h = this.h;
        c0343im.i = this.i;
        c0343im.k = this.k;
        c0343im.l = this.l;
        c0343im.q = this.p;
        c0343im.o = this.n;
        c0343im.p = this.o;
        c0343im.r = this.q;
        c0343im.n = this.s;
        c0343im.t = this.u;
        c0343im.u = this.v;
        c0343im.s = this.r;
        c0343im.v = this.w;
        c0343im.w = this.t;
        c0343im.y = this.y;
        c0343im.x = this.x;
        c0343im.z = this.z;
        c0343im.A = this.A;
        c0343im.B = this.B;
        c0343im.C = this.C;
        return c0343im;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f917a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", autoInappCollectingConfig=" + this.x + ", cacheControl=" + this.y + ", attributionConfig=" + this.z + ", startupUpdateConfig=" + this.A + ", modulesRemoteConfigs=" + this.B + ", externalAttributionConfig=" + this.C + AbstractJsonLexerKt.END_OBJ;
    }
}
