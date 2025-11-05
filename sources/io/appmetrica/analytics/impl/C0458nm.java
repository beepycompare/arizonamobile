package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.nm  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0458nm {
    public final Map A;
    public final I9 B;

    /* renamed from: a  reason: collision with root package name */
    public final String f1028a;
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
    public final C0564s4 m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final String q;
    public final Km r;
    public final De s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final C0389l3 x;
    public final C0612u2 y;
    public final Gm z;

    public C0458nm(C0433mm c0433mm) {
        String str;
        long j;
        long j2;
        Gm gm;
        Gm gm2;
        Map map;
        Map map2;
        I9 i9;
        this.f1028a = c0433mm.f1014a;
        List list = c0433mm.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = c0433mm.c;
        this.d = c0433mm.d;
        this.e = c0433mm.e;
        List list2 = c0433mm.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = c0433mm.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = c0433mm.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map3 = c0433mm.i;
        this.i = map3 != null ? CollectionUtils.unmodifiableMapCopy(map3) : null;
        this.j = c0433mm.j;
        this.k = c0433mm.k;
        this.m = c0433mm.m;
        this.s = c0433mm.n;
        this.n = c0433mm.o;
        this.o = c0433mm.p;
        this.l = c0433mm.l;
        this.p = c0433mm.q;
        str = c0433mm.r;
        this.q = str;
        this.r = c0433mm.s;
        j = c0433mm.t;
        this.u = j;
        j2 = c0433mm.u;
        this.v = j2;
        this.w = c0433mm.v;
        RetryPolicyConfig retryPolicyConfig = c0433mm.w;
        if (retryPolicyConfig == null) {
            Am am = new Am();
            this.t = new RetryPolicyConfig(am.w, am.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = c0433mm.x;
        this.y = c0433mm.y;
        gm = c0433mm.z;
        if (gm != null) {
            gm2 = c0433mm.z;
        } else {
            gm2 = new Gm(O7.b.f1218a);
        }
        this.z = gm2;
        map = c0433mm.A;
        if (map != null) {
            map2 = c0433mm.A;
        } else {
            map2 = Collections.emptyMap();
        }
        this.A = map2;
        i9 = c0433mm.B;
        this.B = i9;
    }

    public final C0433mm a(C0564s4 c0564s4) {
        C0433mm c0433mm = new C0433mm(c0564s4);
        c0433mm.f1014a = this.f1028a;
        c0433mm.f = this.f;
        c0433mm.g = this.g;
        c0433mm.j = this.j;
        c0433mm.b = this.b;
        c0433mm.c = this.c;
        c0433mm.d = this.d;
        c0433mm.e = this.e;
        c0433mm.h = this.h;
        c0433mm.i = this.i;
        c0433mm.k = this.k;
        c0433mm.l = this.l;
        c0433mm.q = this.p;
        c0433mm.o = this.n;
        c0433mm.p = this.o;
        c0433mm.r = this.q;
        c0433mm.n = this.s;
        c0433mm.t = this.u;
        c0433mm.u = this.v;
        c0433mm.s = this.r;
        c0433mm.v = this.w;
        c0433mm.w = this.t;
        c0433mm.x = this.x;
        c0433mm.y = this.y;
        c0433mm.z = this.z;
        c0433mm.A = this.A;
        c0433mm.B = this.B;
        return c0433mm;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f1028a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", cacheControl=" + this.x + ", attributionConfig=" + this.y + ", startupUpdateConfig=" + this.z + ", modulesRemoteConfigs=" + this.A + ", externalAttributionConfig=" + this.B + AbstractJsonLexerKt.END_OBJ;
    }
}
