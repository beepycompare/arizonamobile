package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.gm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0299gm {
    public final Am A;
    public final Map B;
    public final U9 C;

    /* renamed from: a  reason: collision with root package name */
    public final String f857a;
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
    public final Em r;
    public final Je s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final BillingConfig x;
    public final C0753z3 y;
    public final C0552r2 z;

    public C0299gm(C0274fm c0274fm) {
        String str;
        long j;
        long j2;
        Am am;
        Am am2;
        Map map;
        Map map2;
        U9 u9;
        this.f857a = c0274fm.f843a;
        List list = c0274fm.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = c0274fm.c;
        this.d = c0274fm.d;
        this.e = c0274fm.e;
        List list2 = c0274fm.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = c0274fm.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = c0274fm.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map3 = c0274fm.i;
        this.i = map3 != null ? CollectionUtils.unmodifiableMapCopy(map3) : null;
        this.j = c0274fm.j;
        this.k = c0274fm.k;
        this.m = c0274fm.m;
        this.s = c0274fm.n;
        this.n = c0274fm.o;
        this.o = c0274fm.p;
        this.l = c0274fm.l;
        this.p = c0274fm.q;
        str = c0274fm.r;
        this.q = str;
        this.r = c0274fm.s;
        j = c0274fm.t;
        this.u = j;
        j2 = c0274fm.u;
        this.v = j2;
        this.w = c0274fm.v;
        RetryPolicyConfig retryPolicyConfig = c0274fm.w;
        if (retryPolicyConfig == null) {
            C0647um c0647um = new C0647um();
            this.t = new RetryPolicyConfig(c0647um.w, c0647um.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = c0274fm.x;
        this.y = c0274fm.y;
        this.z = c0274fm.z;
        am = c0274fm.A;
        if (am != null) {
            am2 = c0274fm.A;
        } else {
            am2 = new Am(Z7.b.f1048a);
        }
        this.A = am2;
        map = c0274fm.B;
        if (map != null) {
            map2 = c0274fm.B;
        } else {
            map2 = Collections.emptyMap();
        }
        this.B = map2;
        u9 = c0274fm.C;
        this.C = u9;
    }

    public final C0274fm a(G4 g4) {
        C0274fm c0274fm = new C0274fm(g4);
        c0274fm.f843a = this.f857a;
        c0274fm.f = this.f;
        c0274fm.g = this.g;
        c0274fm.j = this.j;
        c0274fm.b = this.b;
        c0274fm.c = this.c;
        c0274fm.d = this.d;
        c0274fm.e = this.e;
        c0274fm.h = this.h;
        c0274fm.i = this.i;
        c0274fm.k = this.k;
        c0274fm.l = this.l;
        c0274fm.q = this.p;
        c0274fm.o = this.n;
        c0274fm.p = this.o;
        c0274fm.r = this.q;
        c0274fm.n = this.s;
        c0274fm.t = this.u;
        c0274fm.u = this.v;
        c0274fm.s = this.r;
        c0274fm.v = this.w;
        c0274fm.w = this.t;
        c0274fm.y = this.y;
        c0274fm.x = this.x;
        c0274fm.z = this.z;
        c0274fm.A = this.A;
        c0274fm.B = this.B;
        c0274fm.C = this.C;
        return c0274fm;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f857a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", autoInappCollectingConfig=" + this.x + ", cacheControl=" + this.y + ", attributionConfig=" + this.z + ", startupUpdateConfig=" + this.A + ", modulesRemoteConfigs=" + this.B + ", externalAttributionConfig=" + this.C + AbstractJsonLexerKt.END_OBJ;
    }
}
