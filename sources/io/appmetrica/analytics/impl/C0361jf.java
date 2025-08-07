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
/* renamed from: io.appmetrica.analytics.impl.jf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0361jf extends Nd {
    public static final C0436mf d = new C0436mf("UUID_RESULT", null);
    public static final C0436mf e = new C0436mf("DEVICE_ID_RESULT", null);
    public static final C0436mf f = new C0436mf("DEVICE_ID_HASH_RESULT", null);
    public static final C0436mf g = new C0436mf("AD_URL_GET_RESULT", null);
    public static final C0436mf h = new C0436mf("AD_URL_REPORT_RESULT", null);
    public static final C0436mf i = new C0436mf("CUSTOM_HOSTS", null);
    public static final C0436mf j = new C0436mf("SERVER_TIME_OFFSET", null);
    public static final C0436mf k = new C0436mf("RESPONSE_CLIDS_RESULT", null);
    public static final C0436mf l = new C0436mf("CUSTOM_SDK_HOSTS", null);
    public static final C0436mf m = new C0436mf("CLIENT_CLIDS", null);
    public static final C0436mf n = new C0436mf("DEFERRED_DEEP_LINK_WAS_CHECKED", null);
    public static final C0436mf o = new C0436mf("API_LEVEL", null);
    public static final C0436mf p = new C0436mf("NEXT_STARTUP_TIME", null);
    public static final C0436mf q = new C0436mf("GAID", null);
    public static final C0436mf r = new C0436mf("HOAID", null);
    public static final C0436mf s = new C0436mf("YANDEX_ADV_ID", null);
    public static final C0436mf t = new C0436mf("CLIENT_CLIDS_CHANGED_AFTER_LAST_IDENTIFIERS_UPDATE", null);
    public static final C0436mf u = new C0436mf("SCREEN_INFO", null);
    public static final C0436mf v = new C0436mf("SCREEN_SIZE_CHECKED_BY_DEPRECATED", null);
    public static final C0436mf w = new C0436mf("FEATURES", null);
    public static final C0436mf x = new C0436mf("APPMETRICA_CLIENT_CONFIG", null);

    public C0361jf(InterfaceC0180cb interfaceC0180cb) {
        super(interfaceC0180cb);
    }

    public final boolean a(boolean z) {
        return this.f938a.getBoolean(t.b, z);
    }

    public final long b(long j2) {
        return this.f938a.getLong(j.f953a, j2);
    }

    public final C0361jf c(IdentifiersResult identifiersResult) {
        return a(l.b, identifiersResult);
    }

    public final IdentifiersResult d() {
        return h(g.b);
    }

    public final IdentifiersResult e() {
        return h(h.b);
    }

    public final C0361jf f(IdentifiersResult identifiersResult) {
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

    public final C0531qa k() {
        String string = this.f938a.getString(w.b, null);
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                return new C0531qa(JsonUtils.optBooleanOrNull(jSONObject, "libSslEnabled"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, DownloadsDB.DownloadColumns.STATUS)), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            }
        } catch (Throwable unused) {
        }
        return new C0531qa(null, IdentifierStatus.UNKNOWN, null);
    }

    public final IdentifiersResult l() {
        return h(q.b);
    }

    public final IdentifiersResult m() {
        return h(r.b);
    }

    public final long n() {
        return this.f938a.getLong(p.b, 0L);
    }

    public final IdentifiersResult o() {
        return h(k.b);
    }

    public final ScreenInfo p() {
        return Bb.e(this.f938a.getString(u.b, null));
    }

    public final IdentifiersResult q() {
        return h(d.b);
    }

    public final IdentifiersResult r() {
        return h(s.b);
    }

    public final boolean s() {
        return this.f938a.getBoolean(n.b, false);
    }

    public final boolean t() {
        return this.f938a.getBoolean(v.b, false);
    }

    public final C0361jf u() {
        return (C0361jf) b(n.b, true);
    }

    public final void v() {
        b(v.b, true);
    }

    public final List<String> g() {
        String string = this.f938a.getString(i.b, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Bb.b(string);
    }

    public final long a(long j2) {
        return this.f938a.getLong(o.b, j2);
    }

    public final C0361jf b(IdentifiersResult identifiersResult) {
        return a(h.b, identifiersResult);
    }

    public final C0361jf c(long j2) {
        return (C0361jf) b(o.b, j2);
    }

    public final C0361jf d(IdentifiersResult identifiersResult) {
        return a(f.b, identifiersResult);
    }

    public final C0361jf e(IdentifiersResult identifiersResult) {
        return a(e.b, identifiersResult);
    }

    public final AppMetricaConfig f() {
        String string = this.f938a.getString(x.b, null);
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
            string = this.f938a.getString(str, null);
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

    public final C0361jf i(IdentifiersResult identifiersResult) {
        return a(d.b, identifiersResult);
    }

    public final C0361jf j(IdentifiersResult identifiersResult) {
        return a(s.b, identifiersResult);
    }

    public final C0361jf g(IdentifiersResult identifiersResult) {
        return a(r.b, identifiersResult);
    }

    public final C0361jf a(IdentifiersResult identifiersResult) {
        return a(g.b, identifiersResult);
    }

    public final C0361jf b(boolean z) {
        return (C0361jf) b(t.b, z);
    }

    public final C0361jf d(long j2) {
        return (C0361jf) b(p.b, j2);
    }

    public final C0361jf e(long j2) {
        return (C0361jf) b(j.b, j2);
    }

    public final String i(String str) {
        return this.f938a.getString(m.b, str);
    }

    public final C0361jf j(String str) {
        return (C0361jf) b(m.b, str);
    }

    @Override // io.appmetrica.analytics.impl.Nd
    public final String f(String str) {
        return new C0436mf(str, null).b;
    }

    public final C0361jf a(List<String> list) {
        return (C0361jf) b(i.b, io.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
    }

    public final C0361jf h(IdentifiersResult identifiersResult) {
        return a(k.b, identifiersResult);
    }

    public final C0361jf a(C0531qa c0531qa) {
        String str = w.b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("libSslEnabled", c0531qa.f1016a).put(DownloadsDB.DownloadColumns.STATUS, c0531qa.b.getValue()).putOpt("ERROR_EXPLANATION", c0531qa.c);
        } catch (Throwable unused) {
        }
        return (C0361jf) b(str, jSONObject.toString());
    }

    @Override // io.appmetrica.analytics.impl.Nd
    /* renamed from: k */
    public final C0361jf g(String str) {
        return (C0361jf) d(new C0436mf(str, null).b);
    }

    public final void a(ScreenInfo screenInfo) {
        b(u.b, Bb.a(screenInfo));
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        b(x.b, appMetricaConfig.toJson());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0361jf a(String str, IdentifiersResult identifiersResult) {
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
