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
/* renamed from: io.appmetrica.analytics.impl.vf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0663vf extends Yd {
    public static final C0741yf d = new C0741yf("UUID_RESULT", null);
    public static final C0741yf e = new C0741yf("DEVICE_ID_RESULT", null);
    public static final C0741yf f = new C0741yf("DEVICE_ID_HASH_RESULT", null);
    public static final C0741yf g = new C0741yf("AD_URL_GET_RESULT", null);
    public static final C0741yf h = new C0741yf("AD_URL_REPORT_RESULT", null);
    public static final C0741yf i = new C0741yf("CUSTOM_HOSTS", null);
    public static final C0741yf j = new C0741yf("SERVER_TIME_OFFSET", null);
    public static final C0741yf k = new C0741yf("RESPONSE_CLIDS_RESULT", null);
    public static final C0741yf l = new C0741yf("CUSTOM_SDK_HOSTS", null);
    public static final C0741yf m = new C0741yf("CLIENT_CLIDS", null);
    public static final C0741yf n = new C0741yf("DEFERRED_DEEP_LINK_WAS_CHECKED", null);
    public static final C0741yf o = new C0741yf("API_LEVEL", null);
    public static final C0741yf p = new C0741yf("NEXT_STARTUP_TIME", null);
    public static final C0741yf q = new C0741yf("GAID", null);
    public static final C0741yf r = new C0741yf("HOAID", null);
    public static final C0741yf s = new C0741yf("YANDEX_ADV_ID", null);
    public static final C0741yf t = new C0741yf("CLIENT_CLIDS_CHANGED_AFTER_LAST_IDENTIFIERS_UPDATE", null);
    public static final C0741yf u = new C0741yf("SCREEN_INFO", null);
    public static final C0741yf v = new C0741yf("SCREEN_SIZE_CHECKED_BY_DEPRECATED", null);
    public static final C0741yf w = new C0741yf("FEATURES", null);
    public static final C0741yf x = new C0741yf("APPMETRICA_CLIENT_CONFIG", null);

    public C0663vf(InterfaceC0348jb interfaceC0348jb) {
        super(interfaceC0348jb);
    }

    public final boolean a(boolean z) {
        return this.f1281a.getBoolean(t.b, z);
    }

    public final long b(long j2) {
        return this.f1281a.getLong(j.f1298a, j2);
    }

    public final C0663vf c(IdentifiersResult identifiersResult) {
        return a(l.b, identifiersResult);
    }

    public final IdentifiersResult d() {
        return h(g.b);
    }

    public final C0663vf f(IdentifiersResult identifiersResult) {
        return a(q.b, identifiersResult);
    }

    public final List<String> g() {
        String string = this.f1281a.getString(i.b, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Ib.b(string);
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

    public final C0529qa k() {
        String string = this.f1281a.getString(w.b, null);
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                return new C0529qa(JsonUtils.optBooleanOrNull(jSONObject, "libSslEnabled"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, DownloadsDB.DownloadColumns.STATUS)), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            }
        } catch (Throwable unused) {
        }
        return new C0529qa(null, IdentifierStatus.UNKNOWN, null);
    }

    public final IdentifiersResult l() {
        return h(q.b);
    }

    public final IdentifiersResult m() {
        return h(r.b);
    }

    public final long n() {
        return this.f1281a.getLong(p.b, 0L);
    }

    public final IdentifiersResult o() {
        return h(k.b);
    }

    public final ScreenInfo p() {
        return Ib.e(this.f1281a.getString(u.b, null));
    }

    public final IdentifiersResult q() {
        return h(d.b);
    }

    public final IdentifiersResult r() {
        return h(s.b);
    }

    public final boolean s() {
        return this.f1281a.getBoolean(n.b, false);
    }

    public final boolean t() {
        return this.f1281a.getBoolean(v.b, false);
    }

    public final C0663vf u() {
        return (C0663vf) d(n.b, true);
    }

    public final void v() {
        d(v.b, true);
    }

    public final IdentifiersResult e() {
        return h(h.b);
    }

    public final long a(long j2) {
        return this.f1281a.getLong(o.b, j2);
    }

    public final C0663vf b(IdentifiersResult identifiersResult) {
        return a(h.b, identifiersResult);
    }

    public final C0663vf c(long j2) {
        return (C0663vf) d(o.b, j2);
    }

    public final C0663vf d(IdentifiersResult identifiersResult) {
        return a(f.b, identifiersResult);
    }

    public final AppMetricaConfig.Builder f() {
        String string = this.f1281a.getString(x.b, null);
        if (string == null) {
            return null;
        }
        return new X3().a(string);
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
            string = this.f1281a.getString(str, null);
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

    public final C0663vf i(IdentifiersResult identifiersResult) {
        return a(d.b, identifiersResult);
    }

    public final C0663vf j(IdentifiersResult identifiersResult) {
        return a(s.b, identifiersResult);
    }

    public final C0663vf e(IdentifiersResult identifiersResult) {
        return a(e.b, identifiersResult);
    }

    public final C0663vf g(IdentifiersResult identifiersResult) {
        return a(r.b, identifiersResult);
    }

    public final C0663vf a(IdentifiersResult identifiersResult) {
        return a(g.b, identifiersResult);
    }

    public final C0663vf b(boolean z) {
        return (C0663vf) d(t.b, z);
    }

    public final C0663vf d(long j2) {
        return (C0663vf) d(p.b, j2);
    }

    public final String i(String str) {
        return this.f1281a.getString(m.b, str);
    }

    public final C0663vf j(String str) {
        return (C0663vf) d(m.b, str);
    }

    public final C0663vf e(long j2) {
        return (C0663vf) d(j.b, j2);
    }

    @Override // io.appmetrica.analytics.impl.Yd
    public final String g(String str) {
        return new C0741yf(str, null).b;
    }

    public final C0663vf a(List<String> list) {
        return (C0663vf) d(i.b, Oo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
    }

    public final C0663vf h(IdentifiersResult identifiersResult) {
        return a(k.b, identifiersResult);
    }

    public final C0663vf a(C0529qa c0529qa) {
        String str = w.b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("libSslEnabled", c0529qa.f1165a).put(DownloadsDB.DownloadColumns.STATUS, c0529qa.b.getValue()).putOpt("ERROR_EXPLANATION", c0529qa.c);
        } catch (Throwable unused) {
        }
        return (C0663vf) d(str, jSONObject.toString());
    }

    @Override // io.appmetrica.analytics.impl.Yd, io.appmetrica.analytics.impl.AbstractC0715xf
    /* renamed from: k */
    public final C0663vf e(String str) {
        return (C0663vf) f(new C0741yf(str, null).b);
    }

    public final void a(ScreenInfo screenInfo) {
        d(u.b, Ib.a(screenInfo));
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        d(x.b, appMetricaConfig.toJson());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0663vf a(String str, IdentifiersResult identifiersResult) {
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
                d(str, jSONObject);
            }
            return this;
        }
        jSONObject = null;
        if (jSONObject != null) {
        }
        return this;
    }
}
