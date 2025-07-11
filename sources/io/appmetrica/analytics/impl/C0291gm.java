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
public final class C0291gm {
    public final Am A;
    public final Map B;
    public final U9 C;

    /* renamed from: a  reason: collision with root package name */
    public final String f858a;
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
    public final C0745z3 y;
    public final C0544r2 z;

    public C0291gm(C0266fm c0266fm) {
        String str;
        long j;
        long j2;
        Am am;
        Am am2;
        Map map;
        Map map2;
        U9 u9;
        this.f858a = c0266fm.f844a;
        List list = c0266fm.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = c0266fm.c;
        this.d = c0266fm.d;
        this.e = c0266fm.e;
        List list2 = c0266fm.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = c0266fm.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = c0266fm.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map3 = c0266fm.i;
        this.i = map3 != null ? CollectionUtils.unmodifiableMapCopy(map3) : null;
        this.j = c0266fm.j;
        this.k = c0266fm.k;
        this.m = c0266fm.m;
        this.s = c0266fm.n;
        this.n = c0266fm.o;
        this.o = c0266fm.p;
        this.l = c0266fm.l;
        this.p = c0266fm.q;
        str = c0266fm.r;
        this.q = str;
        this.r = c0266fm.s;
        j = c0266fm.t;
        this.u = j;
        j2 = c0266fm.u;
        this.v = j2;
        this.w = c0266fm.v;
        RetryPolicyConfig retryPolicyConfig = c0266fm.w;
        if (retryPolicyConfig == null) {
            C0639um c0639um = new C0639um();
            this.t = new RetryPolicyConfig(c0639um.w, c0639um.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = c0266fm.x;
        this.y = c0266fm.y;
        this.z = c0266fm.z;
        am = c0266fm.A;
        if (am != null) {
            am2 = c0266fm.A;
        } else {
            am2 = new Am(Z7.b.f1049a);
        }
        this.A = am2;
        map = c0266fm.B;
        if (map != null) {
            map2 = c0266fm.B;
        } else {
            map2 = Collections.emptyMap();
        }
        this.B = map2;
        u9 = c0266fm.C;
        this.C = u9;
    }

    public final C0266fm a(G4 g4) {
        C0266fm c0266fm = new C0266fm(g4);
        c0266fm.f844a = this.f858a;
        c0266fm.f = this.f;
        c0266fm.g = this.g;
        c0266fm.j = this.j;
        c0266fm.b = this.b;
        c0266fm.c = this.c;
        c0266fm.d = this.d;
        c0266fm.e = this.e;
        c0266fm.h = this.h;
        c0266fm.i = this.i;
        c0266fm.k = this.k;
        c0266fm.l = this.l;
        c0266fm.q = this.p;
        c0266fm.o = this.n;
        c0266fm.p = this.o;
        c0266fm.r = this.q;
        c0266fm.n = this.s;
        c0266fm.t = this.u;
        c0266fm.u = this.v;
        c0266fm.s = this.r;
        c0266fm.v = this.w;
        c0266fm.w = this.t;
        c0266fm.y = this.y;
        c0266fm.x = this.x;
        c0266fm.z = this.z;
        c0266fm.A = this.A;
        c0266fm.B = this.B;
        c0266fm.C = this.C;
        return c0266fm;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f858a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", autoInappCollectingConfig=" + this.x + ", cacheControl=" + this.y + ", attributionConfig=" + this.z + ", startupUpdateConfig=" + this.A + ", modulesRemoteConfigs=" + this.B + ", externalAttributionConfig=" + this.C + AbstractJsonLexerKt.END_OBJ;
    }
}
