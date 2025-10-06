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
/* renamed from: io.appmetrica.analytics.impl.pf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0513pf extends Td {
    public static final C0587sf d = new C0587sf("UUID_RESULT", null);
    public static final C0587sf e = new C0587sf("DEVICE_ID_RESULT", null);
    public static final C0587sf f = new C0587sf("DEVICE_ID_HASH_RESULT", null);
    public static final C0587sf g = new C0587sf("AD_URL_GET_RESULT", null);
    public static final C0587sf h = new C0587sf("AD_URL_REPORT_RESULT", null);
    public static final C0587sf i = new C0587sf("CUSTOM_HOSTS", null);
    public static final C0587sf j = new C0587sf("SERVER_TIME_OFFSET", null);
    public static final C0587sf k = new C0587sf("RESPONSE_CLIDS_RESULT", null);
    public static final C0587sf l = new C0587sf("CUSTOM_SDK_HOSTS", null);
    public static final C0587sf m = new C0587sf("CLIENT_CLIDS", null);
    public static final C0587sf n = new C0587sf("DEFERRED_DEEP_LINK_WAS_CHECKED", null);
    public static final C0587sf o = new C0587sf("API_LEVEL", null);
    public static final C0587sf p = new C0587sf("NEXT_STARTUP_TIME", null);
    public static final C0587sf q = new C0587sf("GAID", null);
    public static final C0587sf r = new C0587sf("HOAID", null);
    public static final C0587sf s = new C0587sf("YANDEX_ADV_ID", null);
    public static final C0587sf t = new C0587sf("CLIENT_CLIDS_CHANGED_AFTER_LAST_IDENTIFIERS_UPDATE", null);
    public static final C0587sf u = new C0587sf("SCREEN_INFO", null);
    public static final C0587sf v = new C0587sf("SCREEN_SIZE_CHECKED_BY_DEPRECATED", null);
    public static final C0587sf w = new C0587sf("FEATURES", null);
    public static final C0587sf x = new C0587sf("APPMETRICA_CLIENT_CONFIG", null);

    public C0513pf(InterfaceC0302hb interfaceC0302hb) {
        super(interfaceC0302hb);
    }

    public final boolean a(boolean z) {
        return this.f1067a.getBoolean(t.b, z);
    }

    public final long b(long j2) {
        return this.f1067a.getLong(j.f1083a, j2);
    }

    public final C0513pf c(IdentifiersResult identifiersResult) {
        return a(l.b, identifiersResult);
    }

    public final IdentifiersResult d() {
        return h(g.b);
    }

    public final IdentifiersResult e() {
        return h(h.b);
    }

    public final C0513pf f(IdentifiersResult identifiersResult) {
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

    public final C0657va k() {
        String string = this.f1067a.getString(w.b, null);
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                return new C0657va(JsonUtils.optBooleanOrNull(jSONObject, "libSslEnabled"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, DownloadsDB.DownloadColumns.STATUS)), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            }
        } catch (Throwable unused) {
        }
        return new C0657va(null, IdentifierStatus.UNKNOWN, null);
    }

    public final IdentifiersResult l() {
        return h(q.b);
    }

    public final IdentifiersResult m() {
        return h(r.b);
    }

    public final long n() {
        return this.f1067a.getLong(p.b, 0L);
    }

    public final IdentifiersResult o() {
        return h(k.b);
    }

    public final ScreenInfo p() {
        return Gb.e(this.f1067a.getString(u.b, null));
    }

    public final IdentifiersResult q() {
        return h(d.b);
    }

    public final IdentifiersResult r() {
        return h(s.b);
    }

    public final boolean s() {
        return this.f1067a.getBoolean(n.b, false);
    }

    public final boolean t() {
        return this.f1067a.getBoolean(v.b, false);
    }

    public final C0513pf u() {
        return (C0513pf) b(n.b, true);
    }

    public final void v() {
        b(v.b, true);
    }

    public final List<String> g() {
        String string = this.f1067a.getString(i.b, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Gb.b(string);
    }

    public final long a(long j2) {
        return this.f1067a.getLong(o.b, j2);
    }

    public final C0513pf b(IdentifiersResult identifiersResult) {
        return a(h.b, identifiersResult);
    }

    public final C0513pf c(long j2) {
        return (C0513pf) b(o.b, j2);
    }

    public final C0513pf d(IdentifiersResult identifiersResult) {
        return a(f.b, identifiersResult);
    }

    public final C0513pf e(IdentifiersResult identifiersResult) {
        return a(e.b, identifiersResult);
    }

    public final AppMetricaConfig f() {
        String string = this.f1067a.getString(x.b, null);
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
            string = this.f1067a.getString(str, null);
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

    public final C0513pf i(IdentifiersResult identifiersResult) {
        return a(d.b, identifiersResult);
    }

    public final C0513pf j(IdentifiersResult identifiersResult) {
        return a(s.b, identifiersResult);
    }

    public final C0513pf g(IdentifiersResult identifiersResult) {
        return a(r.b, identifiersResult);
    }

    public final C0513pf a(IdentifiersResult identifiersResult) {
        return a(g.b, identifiersResult);
    }

    public final C0513pf b(boolean z) {
        return (C0513pf) b(t.b, z);
    }

    public final C0513pf d(long j2) {
        return (C0513pf) b(p.b, j2);
    }

    public final C0513pf e(long j2) {
        return (C0513pf) b(j.b, j2);
    }

    public final String i(String str) {
        return this.f1067a.getString(m.b, str);
    }

    public final C0513pf j(String str) {
        return (C0513pf) b(m.b, str);
    }

    @Override // io.appmetrica.analytics.impl.Td
    public final String f(String str) {
        return new C0587sf(str, null).b;
    }

    public final C0513pf a(List<String> list) {
        return (C0513pf) b(i.b, ro.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
    }

    public final C0513pf h(IdentifiersResult identifiersResult) {
        return a(k.b, identifiersResult);
    }

    public final C0513pf a(C0657va c0657va) {
        String str = w.b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("libSslEnabled", c0657va.f1124a).put(DownloadsDB.DownloadColumns.STATUS, c0657va.b.getValue()).putOpt("ERROR_EXPLANATION", c0657va.c);
        } catch (Throwable unused) {
        }
        return (C0513pf) b(str, jSONObject.toString());
    }

    @Override // io.appmetrica.analytics.impl.Td
    /* renamed from: k */
    public final C0513pf g(String str) {
        return (C0513pf) d(new C0587sf(str, null).b);
    }

    public final void a(ScreenInfo screenInfo) {
        b(u.b, Gb.a(screenInfo));
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        b(x.b, appMetricaConfig.toJson());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0513pf a(String str, IdentifiersResult identifiersResult) {
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
