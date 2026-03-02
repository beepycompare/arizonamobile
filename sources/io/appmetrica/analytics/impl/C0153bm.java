package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.bm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0153bm extends N5 {
    public List d;
    public List e;
    public String f;
    public String g;
    public Map h;
    public C0540r3 i;
    public List j;
    public boolean k;
    public boolean l;
    public String m;
    public long n;
    public final C0404lg o;
    public final H7 p;

    public C0153bm() {
        this(C0448na.k().u(), new H7());
    }

    public final long a(long j) {
        if (this.n == 0) {
            this.n = j;
        }
        return this.n;
    }

    public final C0540r3 c() {
        return this.i;
    }

    public final Map<String, String> d() {
        return this.h;
    }

    public final String e() {
        return this.m;
    }

    public final String f() {
        return this.f;
    }

    public final long g() {
        return this.n;
    }

    public final String h() {
        return this.g;
    }

    public final List<String> i() {
        return this.j;
    }

    public final C0404lg j() {
        return this.o;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
        if (r4 != null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<String> k() {
        ArrayList arrayList;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!lo.a((Collection) this.d)) {
            linkedHashSet.addAll(this.d);
        }
        if (!lo.a((Collection) this.e)) {
            linkedHashSet.addAll(this.e);
        }
        String[] strArr = (String[]) this.p.f610a.a();
        if (strArr != null) {
            arrayList = new ArrayList();
            for (String str : strArr) {
                str = (str == null || StringsKt.isBlank(str)) ? null : null;
                if (str != null) {
                    arrayList.add(str);
                }
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
        }
        String[] strArr2 = BuildConfig.DEFAULT_HOSTS;
        arrayList = new ArrayList();
        for (String str2 : strArr2) {
            str2 = (str2 == null || StringsKt.isBlank(str2)) ? null : null;
            if (str2 != null) {
                arrayList.add(str2);
            }
        }
        linkedHashSet.addAll(arrayList);
        return new ArrayList(linkedHashSet);
    }

    public final List<String> l() {
        return this.e;
    }

    public final List<String> m() {
        return this.d;
    }

    public final boolean n() {
        return this.k;
    }

    public final boolean o() {
        return this.l;
    }

    @Override // io.appmetrica.analytics.impl.N5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig
    public final String toString() {
        return "StartupRequestConfig{mStartupHostsFromStartup=" + this.d + ", mStartupHostsFromClient=" + this.e + ", mDistributionReferrer='" + this.f + "', mInstallReferrerSource='" + this.g + "', mClidsFromClient=" + this.h + ", mNewCustomHosts=" + this.j + ", mHasNewCustomHosts=" + this.k + ", mSuccessfulStartup=" + this.l + ", mCountryInit='" + this.m + "', mFirstStartupTime=" + this.n + "} " + super.toString();
    }

    public C0153bm(C0404lg c0404lg, H7 h7) {
        this.i = new C0540r3(null, S7.c);
        this.n = 0L;
        this.o = c0404lg;
        this.p = h7;
    }

    public final void a(List<String> list) {
        this.j = list;
    }

    public final void a(boolean z) {
        this.k = z;
    }

    public final void a(String str) {
        this.m = str;
    }
}
