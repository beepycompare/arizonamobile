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
public final class C0512pf extends Td {
    public static final C0586sf d = new C0586sf("UUID_RESULT", null);
    public static final C0586sf e = new C0586sf("DEVICE_ID_RESULT", null);
    public static final C0586sf f = new C0586sf("DEVICE_ID_HASH_RESULT", null);
    public static final C0586sf g = new C0586sf("AD_URL_GET_RESULT", null);
    public static final C0586sf h = new C0586sf("AD_URL_REPORT_RESULT", null);
    public static final C0586sf i = new C0586sf("CUSTOM_HOSTS", null);
    public static final C0586sf j = new C0586sf("SERVER_TIME_OFFSET", null);
    public static final C0586sf k = new C0586sf("RESPONSE_CLIDS_RESULT", null);
    public static final C0586sf l = new C0586sf("CUSTOM_SDK_HOSTS", null);
    public static final C0586sf m = new C0586sf("CLIENT_CLIDS", null);
    public static final C0586sf n = new C0586sf("DEFERRED_DEEP_LINK_WAS_CHECKED", null);
    public static final C0586sf o = new C0586sf("API_LEVEL", null);
    public static final C0586sf p = new C0586sf("NEXT_STARTUP_TIME", null);
    public static final C0586sf q = new C0586sf("GAID", null);
    public static final C0586sf r = new C0586sf("HOAID", null);
    public static final C0586sf s = new C0586sf("YANDEX_ADV_ID", null);
    public static final C0586sf t = new C0586sf("CLIENT_CLIDS_CHANGED_AFTER_LAST_IDENTIFIERS_UPDATE", null);
    public static final C0586sf u = new C0586sf("SCREEN_INFO", null);
    public static final C0586sf v = new C0586sf("SCREEN_SIZE_CHECKED_BY_DEPRECATED", null);
    public static final C0586sf w = new C0586sf("FEATURES", null);
    public static final C0586sf x = new C0586sf("APPMETRICA_CLIENT_CONFIG", null);

    public C0512pf(InterfaceC0301hb interfaceC0301hb) {
        super(interfaceC0301hb);
    }

    public final boolean a(boolean z) {
        return this.f1062a.getBoolean(t.b, z);
    }

    public final long b(long j2) {
        return this.f1062a.getLong(j.f1078a, j2);
    }

    public final C0512pf c(IdentifiersResult identifiersResult) {
        return a(l.b, identifiersResult);
    }

    public final IdentifiersResult d() {
        return h(g.b);
    }

    public final IdentifiersResult e() {
        return h(h.b);
    }

    public final C0512pf f(IdentifiersResult identifiersResult) {
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

    public final C0656va k() {
        String string = this.f1062a.getString(w.b, null);
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                return new C0656va(JsonUtils.optBooleanOrNull(jSONObject, "libSslEnabled"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, DownloadsDB.DownloadColumns.STATUS)), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            }
        } catch (Throwable unused) {
        }
        return new C0656va(null, IdentifierStatus.UNKNOWN, null);
    }

    public final IdentifiersResult l() {
        return h(q.b);
    }

    public final IdentifiersResult m() {
        return h(r.b);
    }

    public final long n() {
        return this.f1062a.getLong(p.b, 0L);
    }

    public final IdentifiersResult o() {
        return h(k.b);
    }

    public final ScreenInfo p() {
        return Gb.e(this.f1062a.getString(u.b, null));
    }

    public final IdentifiersResult q() {
        return h(d.b);
    }

    public final IdentifiersResult r() {
        return h(s.b);
    }

    public final boolean s() {
        return this.f1062a.getBoolean(n.b, false);
    }

    public final boolean t() {
        return this.f1062a.getBoolean(v.b, false);
    }

    public final C0512pf u() {
        return (C0512pf) b(n.b, true);
    }

    public final void v() {
        b(v.b, true);
    }

    public final List<String> g() {
        String string = this.f1062a.getString(i.b, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Gb.b(string);
    }

    public final long a(long j2) {
        return this.f1062a.getLong(o.b, j2);
    }

    public final C0512pf b(IdentifiersResult identifiersResult) {
        return a(h.b, identifiersResult);
    }

    public final C0512pf c(long j2) {
        return (C0512pf) b(o.b, j2);
    }

    public final C0512pf d(IdentifiersResult identifiersResult) {
        return a(f.b, identifiersResult);
    }

    public final C0512pf e(IdentifiersResult identifiersResult) {
        return a(e.b, identifiersResult);
    }

    public final AppMetricaConfig f() {
        String string = this.f1062a.getString(x.b, null);
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
            string = this.f1062a.getString(str, null);
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

    public final C0512pf i(IdentifiersResult identifiersResult) {
        return a(d.b, identifiersResult);
    }

    public final C0512pf j(IdentifiersResult identifiersResult) {
        return a(s.b, identifiersResult);
    }

    public final C0512pf g(IdentifiersResult identifiersResult) {
        return a(r.b, identifiersResult);
    }

    public final C0512pf a(IdentifiersResult identifiersResult) {
        return a(g.b, identifiersResult);
    }

    public final C0512pf b(boolean z) {
        return (C0512pf) b(t.b, z);
    }

    public final C0512pf d(long j2) {
        return (C0512pf) b(p.b, j2);
    }

    public final C0512pf e(long j2) {
        return (C0512pf) b(j.b, j2);
    }

    public final String i(String str) {
        return this.f1062a.getString(m.b, str);
    }

    public final C0512pf j(String str) {
        return (C0512pf) b(m.b, str);
    }

    @Override // io.appmetrica.analytics.impl.Td
    public final String f(String str) {
        return new C0586sf(str, null).b;
    }

    public final C0512pf a(List<String> list) {
        return (C0512pf) b(i.b, ro.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
    }

    public final C0512pf h(IdentifiersResult identifiersResult) {
        return a(k.b, identifiersResult);
    }

    public final C0512pf a(C0656va c0656va) {
        String str = w.b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("libSslEnabled", c0656va.f1119a).put(DownloadsDB.DownloadColumns.STATUS, c0656va.b.getValue()).putOpt("ERROR_EXPLANATION", c0656va.c);
        } catch (Throwable unused) {
        }
        return (C0512pf) b(str, jSONObject.toString());
    }

    @Override // io.appmetrica.analytics.impl.Td
    /* renamed from: k */
    public final C0512pf g(String str) {
        return (C0512pf) d(new C0586sf(str, null).b);
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
    public final C0512pf a(String str, IdentifiersResult identifiersResult) {
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
