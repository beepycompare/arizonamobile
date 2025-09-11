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
public final class C0593sm {
    public final Mm A;
    public final Map B;
    public final C0145ba C;

    /* renamed from: a  reason: collision with root package name */
    public final String f1084a;
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
    public final C0598t2 z;

    public C0593sm(C0568rm c0568rm) {
        String str;
        long j;
        long j2;
        Mm mm;
        Mm mm2;
        Map map;
        Map map2;
        C0145ba c0145ba;
        this.f1084a = c0568rm.f1071a;
        List list = c0568rm.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = c0568rm.c;
        this.d = c0568rm.d;
        this.e = c0568rm.e;
        List list2 = c0568rm.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = c0568rm.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = c0568rm.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map3 = c0568rm.i;
        this.i = map3 != null ? CollectionUtils.unmodifiableMapCopy(map3) : null;
        this.j = c0568rm.j;
        this.k = c0568rm.k;
        this.m = c0568rm.m;
        this.s = c0568rm.n;
        this.n = c0568rm.o;
        this.o = c0568rm.p;
        this.l = c0568rm.l;
        this.p = c0568rm.q;
        str = c0568rm.r;
        this.q = str;
        this.r = c0568rm.s;
        j = c0568rm.t;
        this.u = j;
        j2 = c0568rm.u;
        this.v = j2;
        this.w = c0568rm.v;
        RetryPolicyConfig retryPolicyConfig = c0568rm.w;
        if (retryPolicyConfig == null) {
            Gm gm = new Gm();
            this.t = new RetryPolicyConfig(gm.w, gm.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = c0568rm.x;
        this.y = c0568rm.y;
        this.z = c0568rm.z;
        mm = c0568rm.A;
        if (mm != null) {
            mm2 = c0568rm.A;
        } else {
            mm2 = new Mm(AbstractC0272g8.b.f431a);
        }
        this.A = mm2;
        map = c0568rm.B;
        if (map != null) {
            map2 = c0568rm.B;
        } else {
            map2 = Collections.emptyMap();
        }
        this.B = map2;
        c0145ba = c0568rm.C;
        this.C = c0145ba;
    }

    public final C0568rm a(J4 j4) {
        C0568rm c0568rm = new C0568rm(j4);
        c0568rm.f1071a = this.f1084a;
        c0568rm.f = this.f;
        c0568rm.g = this.g;
        c0568rm.j = this.j;
        c0568rm.b = this.b;
        c0568rm.c = this.c;
        c0568rm.d = this.d;
        c0568rm.e = this.e;
        c0568rm.h = this.h;
        c0568rm.i = this.i;
        c0568rm.k = this.k;
        c0568rm.l = this.l;
        c0568rm.q = this.p;
        c0568rm.o = this.n;
        c0568rm.p = this.o;
        c0568rm.r = this.q;
        c0568rm.n = this.s;
        c0568rm.t = this.u;
        c0568rm.u = this.v;
        c0568rm.s = this.r;
        c0568rm.v = this.w;
        c0568rm.w = this.t;
        c0568rm.y = this.y;
        c0568rm.x = this.x;
        c0568rm.z = this.z;
        c0568rm.A = this.A;
        c0568rm.B = this.B;
        c0568rm.C = this.C;
        return c0568rm;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f1084a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", autoInappCollectingConfig=" + this.x + ", cacheControl=" + this.y + ", attributionConfig=" + this.z + ", startupUpdateConfig=" + this.A + ", modulesRemoteConfigs=" + this.B + ", externalAttributionConfig=" + this.C + AbstractJsonLexerKt.END_OBJ;
    }
}
