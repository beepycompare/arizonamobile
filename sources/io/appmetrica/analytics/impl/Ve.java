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
public final class Ve extends AbstractC0726yd {
    public static final Ye d = new Ye("UUID_RESULT", null);
    public static final Ye e = new Ye("DEVICE_ID_RESULT", null);
    public static final Ye f = new Ye("DEVICE_ID_HASH_RESULT", null);
    public static final Ye g = new Ye("AD_URL_GET_RESULT", null);
    public static final Ye h = new Ye("AD_URL_REPORT_RESULT", null);
    public static final Ye i = new Ye("CUSTOM_HOSTS", null);
    public static final Ye j = new Ye("SERVER_TIME_OFFSET", null);
    public static final Ye k = new Ye("RESPONSE_CLIDS_RESULT", null);
    public static final Ye l = new Ye("CUSTOM_SDK_HOSTS", null);
    public static final Ye m = new Ye("CLIENT_CLIDS", null);
    public static final Ye n = new Ye("DEFERRED_DEEP_LINK_WAS_CHECKED", null);
    public static final Ye o = new Ye("API_LEVEL", null);
    public static final Ye p = new Ye("NEXT_STARTUP_TIME", null);
    public static final Ye q = new Ye("GAID", null);
    public static final Ye r = new Ye("HOAID", null);
    public static final Ye s = new Ye("YANDEX_ADV_ID", null);
    public static final Ye t = new Ye("CLIENT_CLIDS_CHANGED_AFTER_LAST_IDENTIFIERS_UPDATE", null);
    public static final Ye u = new Ye("SCREEN_INFO", null);
    public static final Ye v = new Ye("SCREEN_SIZE_CHECKED_BY_DEPRECATED", null);
    public static final Ye w = new Ye("FEATURES", null);
    public static final Ye x = new Ye("APPMETRICA_CLIENT_CONFIG", null);

    public Ve(Ha ha) {
        super(ha);
    }

    public final boolean a(boolean z) {
        return this.f854a.getBoolean(t.b, z);
    }

    public final long b(long j2) {
        return this.f854a.getLong(j.f868a, j2);
    }

    public final Ve c(IdentifiersResult identifiersResult) {
        return a(l.b, identifiersResult);
    }

    public final IdentifiersResult d() {
        return h(g.b);
    }

    public final IdentifiersResult e() {
        return h(h.b);
    }

    public final Ve f(IdentifiersResult identifiersResult) {
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

    public final V9 k() {
        String string = this.f854a.getString(w.b, null);
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                return new V9(JsonUtils.optBooleanOrNull(jSONObject, "libSslEnabled"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, DownloadsDB.DownloadColumns.STATUS)), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            }
        } catch (Throwable unused) {
        }
        return new V9(null, IdentifierStatus.UNKNOWN, null);
    }

    public final IdentifiersResult l() {
        return h(q.b);
    }

    public final IdentifiersResult m() {
        return h(r.b);
    }

    public final long n() {
        return this.f854a.getLong(p.b, 0L);
    }

    public final IdentifiersResult o() {
        return h(k.b);
    }

    public final ScreenInfo p() {
        return AbstractC0272gb.e(this.f854a.getString(u.b, null));
    }

    public final IdentifiersResult q() {
        return h(d.b);
    }

    public final IdentifiersResult r() {
        return h(s.b);
    }

    public final boolean s() {
        return this.f854a.getBoolean(n.b, false);
    }

    public final boolean t() {
        return this.f854a.getBoolean(v.b, false);
    }

    public final Ve u() {
        return (Ve) b(n.b, true);
    }

    public final void v() {
        b(v.b, true);
    }

    public final List<String> g() {
        String string = this.f854a.getString(i.b, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return AbstractC0272gb.b(string);
    }

    public final long a(long j2) {
        return this.f854a.getLong(o.b, j2);
    }

    public final Ve b(IdentifiersResult identifiersResult) {
        return a(h.b, identifiersResult);
    }

    public final Ve c(long j2) {
        return (Ve) b(o.b, j2);
    }

    public final Ve d(IdentifiersResult identifiersResult) {
        return a(f.b, identifiersResult);
    }

    public final Ve e(IdentifiersResult identifiersResult) {
        return a(e.b, identifiersResult);
    }

    public final AppMetricaConfig.Builder f() {
        String string = this.f854a.getString(x.b, null);
        if (string == null) {
            return null;
        }
        return new G3().a(string);
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
            string = this.f854a.getString(str, null);
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

    public final Ve i(IdentifiersResult identifiersResult) {
        return a(d.b, identifiersResult);
    }

    public final Ve j(IdentifiersResult identifiersResult) {
        return a(s.b, identifiersResult);
    }

    public final Ve g(IdentifiersResult identifiersResult) {
        return a(r.b, identifiersResult);
    }

    public final Ve a(IdentifiersResult identifiersResult) {
        return a(g.b, identifiersResult);
    }

    public final Ve b(boolean z) {
        return (Ve) b(t.b, z);
    }

    public final Ve d(long j2) {
        return (Ve) b(p.b, j2);
    }

    public final Ve e(long j2) {
        return (Ve) b(j.b, j2);
    }

    public final String i(String str) {
        return this.f854a.getString(m.b, str);
    }

    public final Ve j(String str) {
        return (Ve) b(m.b, str);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0726yd
    public final String f(String str) {
        return new Ye(str, null).b;
    }

    public final Ve a(List<String> list) {
        return (Ve) b(i.b, lo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
    }

    public final Ve h(IdentifiersResult identifiersResult) {
        return a(k.b, identifiersResult);
    }

    public final Ve a(V9 v9) {
        String str = w.b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("libSslEnabled", v9.f826a).put(DownloadsDB.DownloadColumns.STATUS, v9.b.getValue()).putOpt("ERROR_EXPLANATION", v9.c);
        } catch (Throwable unused) {
        }
        return (Ve) b(str, jSONObject.toString());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0726yd
    /* renamed from: k */
    public final Ve g(String str) {
        return (Ve) d(new Ye(str, null).b);
    }

    public final void a(ScreenInfo screenInfo) {
        b(u.b, AbstractC0272gb.a(screenInfo));
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        b(x.b, appMetricaConfig.toJson());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Ve a(String str, IdentifiersResult identifiersResult) {
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
