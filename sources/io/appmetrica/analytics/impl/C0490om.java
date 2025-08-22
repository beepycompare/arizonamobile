package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.om  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0490om {
    public final Im A;
    public final Map B;
    public final Y9 C;

    /* renamed from: a  reason: collision with root package name */
    public final String f1002a;
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
    public final Mm r;
    public final Ne s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final BillingConfig x;
    public final C0745z3 y;
    public final C0544r2 z;

    public C0490om(C0465nm c0465nm) {
        String str;
        long j;
        long j2;
        Im im;
        Im im2;
        Map map;
        Map map2;
        Y9 y9;
        this.f1002a = c0465nm.f988a;
        List list = c0465nm.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = c0465nm.c;
        this.d = c0465nm.d;
        this.e = c0465nm.e;
        List list2 = c0465nm.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = c0465nm.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = c0465nm.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map3 = c0465nm.i;
        this.i = map3 != null ? CollectionUtils.unmodifiableMapCopy(map3) : null;
        this.j = c0465nm.j;
        this.k = c0465nm.k;
        this.m = c0465nm.m;
        this.s = c0465nm.n;
        this.n = c0465nm.o;
        this.o = c0465nm.p;
        this.l = c0465nm.l;
        this.p = c0465nm.q;
        str = c0465nm.r;
        this.q = str;
        this.r = c0465nm.s;
        j = c0465nm.t;
        this.u = j;
        j2 = c0465nm.u;
        this.v = j2;
        this.w = c0465nm.v;
        RetryPolicyConfig retryPolicyConfig = c0465nm.w;
        if (retryPolicyConfig == null) {
            Cm cm = new Cm();
            this.t = new RetryPolicyConfig(cm.w, cm.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = c0465nm.x;
        this.y = c0465nm.y;
        this.z = c0465nm.z;
        im = c0465nm.A;
        if (im != null) {
            im2 = c0465nm.A;
        } else {
            im2 = new Im(AbstractC0195d8.b.f350a);
        }
        this.A = im2;
        map = c0465nm.B;
        if (map != null) {
            map2 = c0465nm.B;
        } else {
            map2 = Collections.emptyMap();
        }
        this.B = map2;
        y9 = c0465nm.C;
        this.C = y9;
    }

    public final C0465nm a(G4 g4) {
        C0465nm c0465nm = new C0465nm(g4);
        c0465nm.f988a = this.f1002a;
        c0465nm.f = this.f;
        c0465nm.g = this.g;
        c0465nm.j = this.j;
        c0465nm.b = this.b;
        c0465nm.c = this.c;
        c0465nm.d = this.d;
        c0465nm.e = this.e;
        c0465nm.h = this.h;
        c0465nm.i = this.i;
        c0465nm.k = this.k;
        c0465nm.l = this.l;
        c0465nm.q = this.p;
        c0465nm.o = this.n;
        c0465nm.p = this.o;
        c0465nm.r = this.q;
        c0465nm.n = this.s;
        c0465nm.t = this.u;
        c0465nm.u = this.v;
        c0465nm.s = this.r;
        c0465nm.v = this.w;
        c0465nm.w = this.t;
        c0465nm.y = this.y;
        c0465nm.x = this.x;
        c0465nm.z = this.z;
        c0465nm.A = this.A;
        c0465nm.B = this.B;
        c0465nm.C = this.C;
        return c0465nm;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f1002a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", autoInappCollectingConfig=" + this.x + ", cacheControl=" + this.y + ", attributionConfig=" + this.z + ", startupUpdateConfig=" + this.A + ", modulesRemoteConfigs=" + this.B + ", externalAttributionConfig=" + this.C + AbstractJsonLexerKt.END_OBJ;
    }
}
