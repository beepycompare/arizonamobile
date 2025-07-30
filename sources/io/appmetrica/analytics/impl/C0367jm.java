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
public final class C0367jm {
    public final Dm A;
    public final Map B;
    public final W9 C;

    /* renamed from: a  reason: collision with root package name */
    public final String f918a;
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
    public final C0747z3 y;
    public final C0546r2 z;

    public C0367jm(C0342im c0342im) {
        String str;
        long j;
        long j2;
        Dm dm;
        Dm dm2;
        Map map;
        Map map2;
        W9 w9;
        this.f918a = c0342im.f906a;
        List list = c0342im.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = c0342im.c;
        this.d = c0342im.d;
        this.e = c0342im.e;
        List list2 = c0342im.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = c0342im.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = c0342im.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map3 = c0342im.i;
        this.i = map3 != null ? CollectionUtils.unmodifiableMapCopy(map3) : null;
        this.j = c0342im.j;
        this.k = c0342im.k;
        this.m = c0342im.m;
        this.s = c0342im.n;
        this.n = c0342im.o;
        this.o = c0342im.p;
        this.l = c0342im.l;
        this.p = c0342im.q;
        str = c0342im.r;
        this.q = str;
        this.r = c0342im.s;
        j = c0342im.t;
        this.u = j;
        j2 = c0342im.u;
        this.v = j2;
        this.w = c0342im.v;
        RetryPolicyConfig retryPolicyConfig = c0342im.w;
        if (retryPolicyConfig == null) {
            C0716xm c0716xm = new C0716xm();
            this.t = new RetryPolicyConfig(c0716xm.w, c0716xm.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = c0342im.x;
        this.y = c0342im.y;
        this.z = c0342im.z;
        dm = c0342im.A;
        if (dm != null) {
            dm2 = c0342im.A;
        } else {
            dm2 = new Dm(AbstractC0176c8.b.f1106a);
        }
        this.A = dm2;
        map = c0342im.B;
        if (map != null) {
            map2 = c0342im.B;
        } else {
            map2 = Collections.emptyMap();
        }
        this.B = map2;
        w9 = c0342im.C;
        this.C = w9;
    }

    public final C0342im a(G4 g4) {
        C0342im c0342im = new C0342im(g4);
        c0342im.f906a = this.f918a;
        c0342im.f = this.f;
        c0342im.g = this.g;
        c0342im.j = this.j;
        c0342im.b = this.b;
        c0342im.c = this.c;
        c0342im.d = this.d;
        c0342im.e = this.e;
        c0342im.h = this.h;
        c0342im.i = this.i;
        c0342im.k = this.k;
        c0342im.l = this.l;
        c0342im.q = this.p;
        c0342im.o = this.n;
        c0342im.p = this.o;
        c0342im.r = this.q;
        c0342im.n = this.s;
        c0342im.t = this.u;
        c0342im.u = this.v;
        c0342im.s = this.r;
        c0342im.v = this.w;
        c0342im.w = this.t;
        c0342im.y = this.y;
        c0342im.x = this.x;
        c0342im.z = this.z;
        c0342im.A = this.A;
        c0342im.B = this.B;
        c0342im.C = this.C;
        return c0342im;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f918a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", autoInappCollectingConfig=" + this.x + ", cacheControl=" + this.y + ", attributionConfig=" + this.z + ", startupUpdateConfig=" + this.A + ", modulesRemoteConfigs=" + this.B + ", externalAttributionConfig=" + this.C + AbstractJsonLexerKt.END_OBJ;
    }
}
