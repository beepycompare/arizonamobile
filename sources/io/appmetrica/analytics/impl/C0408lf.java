package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import com.google.android.vending.expansion.downloader.impl.DownloadsDB;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.lf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0408lf extends Pd {
    public static final C0483of d = new C0483of("UUID_RESULT", null);
    public static final C0483of e = new C0483of("DEVICE_ID_RESULT", null);
    public static final C0483of f = new C0483of("DEVICE_ID_HASH_RESULT", null);
    public static final C0483of g = new C0483of("AD_URL_GET_RESULT", null);
    public static final C0483of h = new C0483of("AD_URL_REPORT_RESULT", null);
    public static final C0483of i = new C0483of("CUSTOM_HOSTS", null);
    public static final C0483of j = new C0483of("SERVER_TIME_OFFSET", null);
    public static final C0483of k = new C0483of("RESPONSE_CLIDS_RESULT", null);
    public static final C0483of l = new C0483of("CUSTOM_SDK_HOSTS", null);
    public static final C0483of m = new C0483of("CLIENT_CLIDS", null);
    public static final C0483of n = new C0483of("DEFERRED_DEEP_LINK_WAS_CHECKED", null);
    public static final C0483of o = new C0483of("API_LEVEL", null);
    public static final C0483of p = new C0483of("NEXT_STARTUP_TIME", null);
    public static final C0483of q = new C0483of("GAID", null);
    public static final C0483of r = new C0483of("HOAID", null);
    public static final C0483of s = new C0483of("YANDEX_ADV_ID", null);
    public static final C0483of t = new C0483of("CLIENT_CLIDS_CHANGED_AFTER_LAST_IDENTIFIERS_UPDATE", null);
    public static final C0483of u = new C0483of("SCREEN_INFO", null);
    public static final C0483of v = new C0483of("SCREEN_SIZE_CHECKED_BY_DEPRECATED", null);
    public static final C0483of w = new C0483of("FEATURES", null);
    public static final C0483of x = new C0483of("APPMETRICA_CLIENT_CONFIG", null);

    public C0408lf(InterfaceC0223eb interfaceC0223eb) {
        super(interfaceC0223eb);
    }

    public final boolean a(boolean z) {
        return this.f983a.getBoolean(t.b, z);
    }

    public final long b(long j2) {
        return this.f983a.getLong(j.f1000a, j2);
    }

    public final C0408lf c(IdentifiersResult identifiersResult) {
        return a(l.b, identifiersResult);
    }

    public final IdentifiersResult d() {
        return h(g.b);
    }

    public final IdentifiersResult e() {
        return h(h.b);
    }

    public final C0408lf f(IdentifiersResult identifiersResult) {
        return a(q.b, identifiersResult);
    }

    public final IdentifiersResult h() {
        return h(l.b);
    }

    public final IdentifiersResult i() {
        return h(f.b);
    }

    public final IdentifiersResult j() {
        return h(e.b);
    }

    public final C0577sa k() {
        String string = this.f983a.getString(w.b, null);
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                return new C0577sa(JsonUtils.optBooleanOrNull(jSONObject, "libSslEnabled"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, DownloadsDB.DownloadColumns.STATUS)), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            }
        } catch (Throwable unused) {
        }
        return new C0577sa(null, IdentifierStatus.UNKNOWN, null);
    }

    public final IdentifiersResult l() {
        return h(q.b);
    }

    public final IdentifiersResult m() {
        return h(r.b);
    }

    public final long n() {
        return this.f983a.getLong(p.b, 0L);
    }

    public final IdentifiersResult o() {
        return h(k.b);
    }

    public final ScreenInfo p() {
        return Db.e(this.f983a.getString(u.b, null));
    }

    public final IdentifiersResult q() {
        return h(d.b);
    }

    public final IdentifiersResult r() {
        return h(s.b);
    }

    public final boolean s() {
        return this.f983a.getBoolean(n.b, false);
    }

    public final boolean t() {
        return this.f983a.getBoolean(v.b, false);
    }

    public final C0408lf u() {
        return (C0408lf) b(n.b, true);
    }

    public final void v() {
        b(v.b, true);
    }

    public final List<String> g() {
        String string = this.f983a.getString(i.b, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Db.b(string);
    }

    public final long a(long j2) {
        return this.f983a.getLong(o.b, j2);
    }

    public final C0408lf b(IdentifiersResult identifiersResult) {
        return a(h.b, identifiersResult);
    }

    public final C0408lf c(long j2) {
        return (C0408lf) b(o.b, j2);
    }

    public final C0408lf d(IdentifiersResult identifiersResult) {
        return a(f.b, identifiersResult);
    }

    public final C0408lf e(IdentifiersResult identifiersResult) {
        return a(e.b, identifiersResult);
    }

    public final AppMetricaConfig f() {
        String string = this.f983a.getString(x.b, null);
        if (string == null) {
            return null;
        }
        return AppMetricaConfig.fromJson(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final IdentifiersResult h(String str) {
        IdentifiersResult identifiersResult;
        String string;
        try {
            string = this.f983a.getString(str, null);
        } catch (Throwable unused) {
        }
        if (string != null) {
            JSONObject jSONObject = new JSONObject(string);
            identifiersResult = new IdentifiersResult(JsonUtils.optStringOrNull(jSONObject, "ID"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, DownloadsDB.DownloadColumns.STATUS)), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            return identifiersResult != null ? new IdentifiersResult(null, IdentifierStatus.UNKNOWN, "no identifier in preferences") : identifiersResult;
        }
        identifiersResult = null;
        if (identifiersResult != null) {
        }
    }

    public final C0408lf i(IdentifiersResult identifiersResult) {
        return a(d.b, identifiersResult);
    }

    public final C0408lf j(IdentifiersResult identifiersResult) {
        return a(s.b, identifiersResult);
    }

    public final C0408lf g(IdentifiersResult identifiersResult) {
        return a(r.b, identifiersResult);
    }

    public final C0408lf a(IdentifiersResult identifiersResult) {
        return a(g.b, identifiersResult);
    }

    public final C0408lf b(boolean z) {
        return (C0408lf) b(t.b, z);
    }

    public final C0408lf d(long j2) {
        return (C0408lf) b(p.b, j2);
    }

    public final C0408lf e(long j2) {
        return (C0408lf) b(j.b, j2);
    }

    public final String i(String str) {
        return this.f983a.getString(m.b, str);
    }

    public final C0408lf j(String str) {
        return (C0408lf) b(m.b, str);
    }

    @Override // io.appmetrica.analytics.impl.Pd
    public final String f(String str) {
        return new C0483of(str, null).b;
    }

    public final C0408lf a(List<String> list) {
        return (C0408lf) b(i.b, no.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
    }

    public final C0408lf h(IdentifiersResult identifiersResult) {
        return a(k.b, identifiersResult);
    }

    public final C0408lf a(C0577sa c0577sa) {
        String str = w.b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("libSslEnabled", c0577sa.f1058a).put(DownloadsDB.DownloadColumns.STATUS, c0577sa.b.getValue()).putOpt("ERROR_EXPLANATION", c0577sa.c);
        } catch (Throwable unused) {
        }
        return (C0408lf) b(str, jSONObject.toString());
    }

    @Override // io.appmetrica.analytics.impl.Pd
    /* renamed from: k */
    public final C0408lf g(String str) {
        return (C0408lf) d(new C0483of(str, null).b);
    }

    public final void a(ScreenInfo screenInfo) {
        b(u.b, Db.a(screenInfo));
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        b(x.b, appMetricaConfig.toJson());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0408lf a(String str, IdentifiersResult identifiersResult) {
        String jSONObject;
        if (identifiersResult != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ID", identifiersResult.id).put(DownloadsDB.DownloadColumns.STATUS, identifiersResult.status.getValue()).put("ERROR_EXPLANATION", identifiersResult.errorExplanation);
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject2.toString();
            } catch (Throwable unused2) {
            }
            if (jSONObject != null) {
                b(str, jSONObject);
            }
            return this;
        }
        jSONObject = null;
        if (jSONObject != null) {
        }
        return this;
    }
}
