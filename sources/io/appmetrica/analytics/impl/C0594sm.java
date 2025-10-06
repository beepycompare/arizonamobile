package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.sm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0594sm {
    public final Mm A;
    public final Map B;
    public final C0146ba C;

    /* renamed from: a  reason: collision with root package name */
    public final String f1085a;
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
    public final J4 m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final String q;
    public final Qm r;
    public final Re s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final BillingConfig x;
    public final C3 y;
    public final C0599t2 z;

    public C0594sm(C0569rm c0569rm) {
        String str;
        long j;
        long j2;
        Mm mm;
        Mm mm2;
        Map map;
        Map map2;
        C0146ba c0146ba;
        this.f1085a = c0569rm.f1072a;
        List list = c0569rm.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = c0569rm.c;
        this.d = c0569rm.d;
        this.e = c0569rm.e;
        List list2 = c0569rm.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = c0569rm.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = c0569rm.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map3 = c0569rm.i;
        this.i = map3 != null ? CollectionUtils.unmodifiableMapCopy(map3) : null;
        this.j = c0569rm.j;
        this.k = c0569rm.k;
        this.m = c0569rm.m;
        this.s = c0569rm.n;
        this.n = c0569rm.o;
        this.o = c0569rm.p;
        this.l = c0569rm.l;
        this.p = c0569rm.q;
        str = c0569rm.r;
        this.q = str;
        this.r = c0569rm.s;
        j = c0569rm.t;
        this.u = j;
        j2 = c0569rm.u;
        this.v = j2;
        this.w = c0569rm.v;
        RetryPolicyConfig retryPolicyConfig = c0569rm.w;
        if (retryPolicyConfig == null) {
            Gm gm = new Gm();
            this.t = new RetryPolicyConfig(gm.w, gm.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = c0569rm.x;
        this.y = c0569rm.y;
        this.z = c0569rm.z;
        mm = c0569rm.A;
        if (mm != null) {
            mm2 = c0569rm.A;
        } else {
            mm2 = new Mm(AbstractC0273g8.b.f432a);
        }
        this.A = mm2;
        map = c0569rm.B;
        if (map != null) {
            map2 = c0569rm.B;
        } else {
            map2 = Collections.emptyMap();
        }
        this.B = map2;
        c0146ba = c0569rm.C;
        this.C = c0146ba;
    }

    public final C0569rm a(J4 j4) {
        C0569rm c0569rm = new C0569rm(j4);
        c0569rm.f1072a = this.f1085a;
        c0569rm.f = this.f;
        c0569rm.g = this.g;
        c0569rm.j = this.j;
        c0569rm.b = this.b;
        c0569rm.c = this.c;
        c0569rm.d = this.d;
        c0569rm.e = this.e;
        c0569rm.h = this.h;
        c0569rm.i = this.i;
        c0569rm.k = this.k;
        c0569rm.l = this.l;
        c0569rm.q = this.p;
        c0569rm.o = this.n;
        c0569rm.p = this.o;
        c0569rm.r = this.q;
        c0569rm.n = this.s;
        c0569rm.t = this.u;
        c0569rm.u = this.v;
        c0569rm.s = this.r;
        c0569rm.v = this.w;
        c0569rm.w = this.t;
        c0569rm.y = this.y;
        c0569rm.x = this.x;
        c0569rm.z = this.z;
        c0569rm.A = this.A;
        c0569rm.B = this.B;
        c0569rm.C = this.C;
        return c0569rm;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f1085a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", autoInappCollectingConfig=" + this.x + ", cacheControl=" + this.y + ", attributionConfig=" + this.z + ", startupUpdateConfig=" + this.A + ", modulesRemoteConfigs=" + this.B + ", externalAttributionConfig=" + this.C + AbstractJsonLexerKt.END_OBJ;
    }
}
