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
/* renamed from: io.appmetrica.analytics.impl.af  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0117af extends Fd {
    public static final C0195df d = new C0195df("UUID_RESULT", null);
    public static final C0195df e = new C0195df("DEVICE_ID_RESULT", null);
    public static final C0195df f = new C0195df("DEVICE_ID_HASH_RESULT", null);
    public static final C0195df g = new C0195df("AD_URL_GET_RESULT", null);
    public static final C0195df h = new C0195df("AD_URL_REPORT_RESULT", null);
    public static final C0195df i = new C0195df("CUSTOM_HOSTS", null);
    public static final C0195df j = new C0195df("SERVER_TIME_OFFSET", null);
    public static final C0195df k = new C0195df("RESPONSE_CLIDS_RESULT", null);
    public static final C0195df l = new C0195df("CUSTOM_SDK_HOSTS", null);
    public static final C0195df m = new C0195df("CLIENT_CLIDS", null);
    public static final C0195df n = new C0195df("DEFERRED_DEEP_LINK_WAS_CHECKED", null);
    public static final C0195df o = new C0195df("API_LEVEL", null);
    public static final C0195df p = new C0195df("NEXT_STARTUP_TIME", null);
    public static final C0195df q = new C0195df("GAID", null);
    public static final C0195df r = new C0195df("HOAID", null);
    public static final C0195df s = new C0195df("YANDEX_ADV_ID", null);
    public static final C0195df t = new C0195df("CLIENT_CLIDS_CHANGED_AFTER_LAST_IDENTIFIERS_UPDATE", null);
    public static final C0195df u = new C0195df("SCREEN_INFO", null);
    public static final C0195df v = new C0195df("SCREEN_SIZE_CHECKED_BY_DEPRECATED", null);
    public static final C0195df w = new C0195df("FEATURES", null);
    public static final C0195df x = new C0195df("APPMETRICA_CLIENT_CONFIG", null);

    public C0117af(Oa oa) {
        super(oa);
    }

    public final boolean a(boolean z) {
        return this.f830a.getBoolean(t.b, z);
    }

    public final long b(long j2) {
        return this.f830a.getLong(j.f846a, j2);
    }

    public final C0117af c(IdentifiersResult identifiersResult) {
        return a(l.b, identifiersResult);
    }

    public final IdentifiersResult d() {
        return h(g.b);
    }

    public final IdentifiersResult e() {
        return h(h.b);
    }

    public final C0117af f(IdentifiersResult identifiersResult) {
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

    public final C0164ca k() {
        String string = this.f830a.getString(w.b, null);
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                return new C0164ca(JsonUtils.optBooleanOrNull(jSONObject, "libSslEnabled"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, DownloadsDB.DownloadColumns.STATUS)), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            }
        } catch (Throwable unused) {
        }
        return new C0164ca(null, IdentifierStatus.UNKNOWN, null);
    }

    public final IdentifiersResult l() {
        return h(q.b);
    }

    public final IdentifiersResult m() {
        return h(r.b);
    }

    public final long n() {
        return this.f830a.getLong(p.b, 0L);
    }

    public final IdentifiersResult o() {
        return h(k.b);
    }

    public final ScreenInfo p() {
        return AbstractC0447nb.e(this.f830a.getString(u.b, null));
    }

    public final IdentifiersResult q() {
        return h(d.b);
    }

    public final IdentifiersResult r() {
        return h(s.b);
    }

    public final boolean s() {
        return this.f830a.getBoolean(n.b, false);
    }

    public final boolean t() {
        return this.f830a.getBoolean(v.b, false);
    }

    public final C0117af u() {
        return (C0117af) b(n.b, true);
    }

    public final void v() {
        b(v.b, true);
    }

    public final List<String> g() {
        String string = this.f830a.getString(i.b, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return AbstractC0447nb.b(string);
    }

    public final long a(long j2) {
        return this.f830a.getLong(o.b, j2);
    }

    public final C0117af b(IdentifiersResult identifiersResult) {
        return a(h.b, identifiersResult);
    }

    public final C0117af c(long j2) {
        return (C0117af) b(o.b, j2);
    }

    public final C0117af d(IdentifiersResult identifiersResult) {
        return a(f.b, identifiersResult);
    }

    public final C0117af e(IdentifiersResult identifiersResult) {
        return a(e.b, identifiersResult);
    }

    public final AppMetricaConfig.Builder f() {
        String string = this.f830a.getString(x.b, null);
        if (string == null) {
            return null;
        }
        return new O3().a(string);
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
            string = this.f830a.getString(str, null);
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

    public final C0117af i(IdentifiersResult identifiersResult) {
        return a(d.b, identifiersResult);
    }

    public final C0117af j(IdentifiersResult identifiersResult) {
        return a(s.b, identifiersResult);
    }

    public final C0117af g(IdentifiersResult identifiersResult) {
        return a(r.b, identifiersResult);
    }

    public final C0117af a(IdentifiersResult identifiersResult) {
        return a(g.b, identifiersResult);
    }

    public final C0117af b(boolean z) {
        return (C0117af) b(t.b, z);
    }

    public final C0117af d(long j2) {
        return (C0117af) b(p.b, j2);
    }

    public final C0117af e(long j2) {
        return (C0117af) b(j.b, j2);
    }

    public final String i(String str) {
        return this.f830a.getString(m.b, str);
    }

    public final C0117af j(String str) {
        return (C0117af) b(m.b, str);
    }

    @Override // io.appmetrica.analytics.impl.Fd
    public final String f(String str) {
        return new C0195df(str, null).b;
    }

    public final C0117af a(List<String> list) {
        return (C0117af) b(i.b, no.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
    }

    public final C0117af h(IdentifiersResult identifiersResult) {
        return a(k.b, identifiersResult);
    }

    public final C0117af a(C0164ca c0164ca) {
        String str = w.b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("libSslEnabled", c0164ca.f827a).put(DownloadsDB.DownloadColumns.STATUS, c0164ca.b.getValue()).putOpt("ERROR_EXPLANATION", c0164ca.c);
        } catch (Throwable unused) {
        }
        return (C0117af) b(str, jSONObject.toString());
    }

    @Override // io.appmetrica.analytics.impl.Fd
    /* renamed from: k */
    public final C0117af g(String str) {
        return (C0117af) d(new C0195df(str, null).b);
    }

    public final void a(ScreenInfo screenInfo) {
        b(u.b, AbstractC0447nb.a(screenInfo));
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        b(x.b, appMetricaConfig.toJson());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0117af a(String str, IdentifiersResult identifiersResult) {
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
