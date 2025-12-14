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
/* loaded from: classes5.dex */
public final class We extends AbstractC0747zd {
    public static final Ze d = new Ze("UUID_RESULT", null);
    public static final Ze e = new Ze("DEVICE_ID_RESULT", null);
    public static final Ze f = new Ze("DEVICE_ID_HASH_RESULT", null);
    public static final Ze g = new Ze("AD_URL_GET_RESULT", null);
    public static final Ze h = new Ze("AD_URL_REPORT_RESULT", null);
    public static final Ze i = new Ze("CUSTOM_HOSTS", null);
    public static final Ze j = new Ze("SERVER_TIME_OFFSET", null);
    public static final Ze k = new Ze("RESPONSE_CLIDS_RESULT", null);
    public static final Ze l = new Ze("CUSTOM_SDK_HOSTS", null);
    public static final Ze m = new Ze("CLIENT_CLIDS", null);
    public static final Ze n = new Ze("DEFERRED_DEEP_LINK_WAS_CHECKED", null);
    public static final Ze o = new Ze("API_LEVEL", null);
    public static final Ze p = new Ze("NEXT_STARTUP_TIME", null);
    public static final Ze q = new Ze("GAID", null);
    public static final Ze r = new Ze("HOAID", null);
    public static final Ze s = new Ze("YANDEX_ADV_ID", null);
    public static final Ze t = new Ze("CLIENT_CLIDS_CHANGED_AFTER_LAST_IDENTIFIERS_UPDATE", null);
    public static final Ze u = new Ze("SCREEN_INFO", null);
    public static final Ze v = new Ze("SCREEN_SIZE_CHECKED_BY_DEPRECATED", null);
    public static final Ze w = new Ze("FEATURES", null);
    public static final Ze x = new Ze("APPMETRICA_CLIENT_CONFIG", null);

    public We(Ia ia) {
        super(ia);
    }

    public final boolean a(boolean z) {
        return this.f862a.getBoolean(t.b, z);
    }

    public final long b(long j2) {
        return this.f862a.getLong(j.f876a, j2);
    }

    public final We c(IdentifiersResult identifiersResult) {
        return a(l.b, identifiersResult);
    }

    public final IdentifiersResult d() {
        return h(g.b);
    }

    public final IdentifiersResult e() {
        return h(h.b);
    }

    public final We f(IdentifiersResult identifiersResult) {
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

    public final W9 k() {
        String string = this.f862a.getString(w.b, null);
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                return new W9(JsonUtils.optBooleanOrNull(jSONObject, "libSslEnabled"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, DownloadsDB.DownloadColumns.STATUS)), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            }
        } catch (Throwable unused) {
        }
        return new W9(null, IdentifierStatus.UNKNOWN, null);
    }

    public final IdentifiersResult l() {
        return h(q.b);
    }

    public final IdentifiersResult m() {
        return h(r.b);
    }

    public final long n() {
        return this.f862a.getLong(p.b, 0L);
    }

    public final IdentifiersResult o() {
        return h(k.b);
    }

    public final ScreenInfo p() {
        return AbstractC0293hb.e(this.f862a.getString(u.b, null));
    }

    public final IdentifiersResult q() {
        return h(d.b);
    }

    public final IdentifiersResult r() {
        return h(s.b);
    }

    public final boolean s() {
        return this.f862a.getBoolean(n.b, false);
    }

    public final boolean t() {
        return this.f862a.getBoolean(v.b, false);
    }

    public final We u() {
        return (We) b(n.b, true);
    }

    public final void v() {
        b(v.b, true);
    }

    public final List<String> g() {
        String string = this.f862a.getString(i.b, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return AbstractC0293hb.b(string);
    }

    public final long a(long j2) {
        return this.f862a.getLong(o.b, j2);
    }

    public final We b(IdentifiersResult identifiersResult) {
        return a(h.b, identifiersResult);
    }

    public final We c(long j2) {
        return (We) b(o.b, j2);
    }

    public final We d(IdentifiersResult identifiersResult) {
        return a(f.b, identifiersResult);
    }

    public final We e(IdentifiersResult identifiersResult) {
        return a(e.b, identifiersResult);
    }

    public final AppMetricaConfig.Builder f() {
        String string = this.f862a.getString(x.b, null);
        if (string == null) {
            return null;
        }
        return new H3().a(string);
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
            string = this.f862a.getString(str, null);
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

    public final We i(IdentifiersResult identifiersResult) {
        return a(d.b, identifiersResult);
    }

    public final We j(IdentifiersResult identifiersResult) {
        return a(s.b, identifiersResult);
    }

    public final We g(IdentifiersResult identifiersResult) {
        return a(r.b, identifiersResult);
    }

    public final We a(IdentifiersResult identifiersResult) {
        return a(g.b, identifiersResult);
    }

    public final We b(boolean z) {
        return (We) b(t.b, z);
    }

    public final We d(long j2) {
        return (We) b(p.b, j2);
    }

    public final We e(long j2) {
        return (We) b(j.b, j2);
    }

    public final String i(String str) {
        return this.f862a.getString(m.b, str);
    }

    public final We j(String str) {
        return (We) b(m.b, str);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0747zd
    public final String f(String str) {
        return new Ze(str, null).b;
    }

    public final We a(List<String> list) {
        return (We) b(i.b, mo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
    }

    public final We h(IdentifiersResult identifiersResult) {
        return a(k.b, identifiersResult);
    }

    public final We a(W9 w9) {
        String str = w.b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("libSslEnabled", w9.f834a).put(DownloadsDB.DownloadColumns.STATUS, w9.b.getValue()).putOpt("ERROR_EXPLANATION", w9.c);
        } catch (Throwable unused) {
        }
        return (We) b(str, jSONObject.toString());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0747zd
    /* renamed from: k */
    public final We g(String str) {
        return (We) d(new Ze(str, null).b);
    }

    public final void a(ScreenInfo screenInfo) {
        b(u.b, AbstractC0293hb.a(screenInfo));
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        b(x.b, appMetricaConfig.toJson());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final We a(String str, IdentifiersResult identifiersResult) {
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
