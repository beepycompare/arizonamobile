package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Gh extends C0425m6 {
    public boolean d;
    public boolean e;
    public int f;
    public int g;
    public boolean h;
    public int i;
    public Boolean j;
    public Dh k;
    public final Fh l;
    public String m;
    public boolean n;
    public boolean o;
    public String p;
    public List q;
    public int r;
    public long s;
    public long t;
    public boolean u;
    public long v;
    public List w;
    public Set x = new HashSet();

    public Gh(C0651v5 c0651v5) {
        this.l = c0651v5;
    }

    public final void a(int i) {
        this.r = i;
    }

    public final void b(List<String> list) {
        this.q = list;
    }

    public final String c() {
        return this.m;
    }

    public final void d(boolean z) {
        this.d = z;
    }

    public final void e(boolean z) {
        this.h = z;
    }

    public final void f(boolean z) {
        this.n = z;
    }

    public final boolean g() {
        return this.u;
    }

    public final String h() {
        return (String) WrapUtils.getOrDefault(this.p, "");
    }

    public final boolean i() {
        return this.k.a(this.j);
    }

    public final int j() {
        return this.g;
    }

    public final long k() {
        return this.v;
    }

    public final int l() {
        return this.i;
    }

    public final long m() {
        return this.s;
    }

    public final long n() {
        return this.t;
    }

    public final List<String> o() {
        return this.q;
    }

    public final int p() {
        return this.f;
    }

    public final boolean q() {
        return this.o;
    }

    public final boolean r() {
        return this.e;
    }

    public final boolean s() {
        return this.d;
    }

    public final boolean t() {
        return this.n;
    }

    @Override // io.appmetrica.analytics.impl.C0425m6, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig
    public final String toString() {
        return "ReportRequestConfig{mLocationTracking=" + this.d + ", mFirstActivationAsUpdate=" + this.e + ", mSessionTimeout=" + this.f + ", mDispatchPeriod=" + this.g + ", mLogEnabled=" + this.h + ", mMaxReportsCount=" + this.i + ", dataSendingEnabledFromArguments=" + this.j + ", dataSendingStrategy=" + this.k + ", mPreloadInfoSendingStrategy=" + this.l + ", mApiKey='" + this.m + "', mPermissionsCollectingEnabled=" + this.n + ", mFeaturesCollectingEnabled=" + this.o + ", mClidsFromStartupResponse='" + this.p + "', mReportHosts=" + this.q + ", mAttributionId=" + this.r + ", mPermissionsCollectingIntervalSeconds=" + this.s + ", mPermissionsForceSendIntervalSeconds=" + this.t + ", mClidsFromClientMatchClidsFromStartupRequest=" + this.u + ", mMaxReportsInDbCount=" + this.v + ", mCertificates=" + this.w + "} " + super.toString();
    }

    public final boolean u() {
        return isIdentifiersValid() && !ro.a((Collection) this.q) && this.u;
    }

    public final boolean v() {
        return ((C0651v5) this.l).B();
    }

    public final void a(long j) {
        this.v = j;
    }

    public final void b(long j) {
        this.s = j;
    }

    public final void c(long j) {
        this.t = j;
    }

    public final void d(int i) {
        this.f = i;
    }

    public final Set<String> e() {
        return this.x;
    }

    public final List<String> f() {
        return this.w;
    }

    public final void a(List<String> list) {
        this.w = list;
    }

    public final void b(boolean z) {
        this.o = z;
    }

    public final void c(boolean z) {
        this.e = z;
    }

    public final int d() {
        return this.r;
    }

    public final void a(Boolean bool, Dh dh) {
        this.j = bool;
        this.k = dh;
    }

    public final void b(int i) {
        this.g = i;
    }

    public final void c(int i) {
        this.i = i;
    }

    public final void a(boolean z) {
        this.u = z;
    }

    public final void a(Set<String> set) {
        this.x = set;
    }
}
