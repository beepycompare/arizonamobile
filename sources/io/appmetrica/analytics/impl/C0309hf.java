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
/* renamed from: io.appmetrica.analytics.impl.hf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0309hf extends Ld {
    public static final C0383kf d = new C0383kf("UUID_RESULT", null);
    public static final C0383kf e = new C0383kf("DEVICE_ID_RESULT", null);
    public static final C0383kf f = new C0383kf("DEVICE_ID_HASH_RESULT", null);
    public static final C0383kf g = new C0383kf("AD_URL_GET_RESULT", null);
    public static final C0383kf h = new C0383kf("AD_URL_REPORT_RESULT", null);
    public static final C0383kf i = new C0383kf("CUSTOM_HOSTS", null);
    public static final C0383kf j = new C0383kf("SERVER_TIME_OFFSET", null);
    public static final C0383kf k = new C0383kf("RESPONSE_CLIDS_RESULT", null);
    public static final C0383kf l = new C0383kf("CUSTOM_SDK_HOSTS", null);
    public static final C0383kf m = new C0383kf("CLIENT_CLIDS", null);
    public static final C0383kf n = new C0383kf("DEFERRED_DEEP_LINK_WAS_CHECKED", null);
    public static final C0383kf o = new C0383kf("API_LEVEL", null);
    public static final C0383kf p = new C0383kf("NEXT_STARTUP_TIME", null);
    public static final C0383kf q = new C0383kf("GAID", null);
    public static final C0383kf r = new C0383kf("HOAID", null);
    public static final C0383kf s = new C0383kf("YANDEX_ADV_ID", null);
    public static final C0383kf t = new C0383kf("CLIENT_CLIDS_CHANGED_AFTER_LAST_IDENTIFIERS_UPDATE", null);
    public static final C0383kf u = new C0383kf("SCREEN_INFO", null);
    public static final C0383kf v = new C0383kf("SCREEN_SIZE_CHECKED_BY_DEPRECATED", null);
    public static final C0383kf w = new C0383kf("FEATURES", null);
    public static final C0383kf x = new C0383kf("APPMETRICA_CLIENT_CONFIG", null);

    public C0309hf(InterfaceC0127ab interfaceC0127ab) {
        super(interfaceC0127ab);
    }

    public final boolean a(boolean z) {
        return this.f892a.getBoolean(t.b, z);
    }

    public final long b(long j2) {
        return this.f892a.getLong(j.f906a, j2);
    }

    public final C0309hf c(IdentifiersResult identifiersResult) {
        return a(l.b, identifiersResult);
    }

    public final IdentifiersResult d() {
        return h(g.b);
    }

    public final IdentifiersResult e() {
        return h(h.b);
    }

    public final C0309hf f(IdentifiersResult identifiersResult) {
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

    public final C0478oa k() {
        String string = this.f892a.getString(w.b, null);
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                return new C0478oa(JsonUtils.optBooleanOrNull(jSONObject, "libSslEnabled"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, DownloadsDB.DownloadColumns.STATUS)), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            }
        } catch (Throwable unused) {
        }
        return new C0478oa(null, IdentifierStatus.UNKNOWN, null);
    }

    public final IdentifiersResult l() {
        return h(q.b);
    }

    public final IdentifiersResult m() {
        return h(r.b);
    }

    public final long n() {
        return this.f892a.getLong(p.b, 0L);
    }

    public final IdentifiersResult o() {
        return h(k.b);
    }

    public final ScreenInfo p() {
        return AbstractC0753zb.e(this.f892a.getString(u.b, null));
    }

    public final IdentifiersResult q() {
        return h(d.b);
    }

    public final IdentifiersResult r() {
        return h(s.b);
    }

    public final boolean s() {
        return this.f892a.getBoolean(n.b, false);
    }

    public final boolean t() {
        return this.f892a.getBoolean(v.b, false);
    }

    public final C0309hf u() {
        return (C0309hf) b(n.b, true);
    }

    public final void v() {
        b(v.b, true);
    }

    public final List<String> g() {
        String string = this.f892a.getString(i.b, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return AbstractC0753zb.b(string);
    }

    public final long a(long j2) {
        return this.f892a.getLong(o.b, j2);
    }

    public final C0309hf b(IdentifiersResult identifiersResult) {
        return a(h.b, identifiersResult);
    }

    public final C0309hf c(long j2) {
        return (C0309hf) b(o.b, j2);
    }

    public final C0309hf d(IdentifiersResult identifiersResult) {
        return a(f.b, identifiersResult);
    }

    public final C0309hf e(IdentifiersResult identifiersResult) {
        return a(e.b, identifiersResult);
    }

    public final AppMetricaConfig f() {
        String string = this.f892a.getString(x.b, null);
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
            string = this.f892a.getString(str, null);
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

    public final C0309hf i(IdentifiersResult identifiersResult) {
        return a(d.b, identifiersResult);
    }

    public final C0309hf j(IdentifiersResult identifiersResult) {
        return a(s.b, identifiersResult);
    }

    public final C0309hf g(IdentifiersResult identifiersResult) {
        return a(r.b, identifiersResult);
    }

    public final C0309hf a(IdentifiersResult identifiersResult) {
        return a(g.b, identifiersResult);
    }

    public final C0309hf b(boolean z) {
        return (C0309hf) b(t.b, z);
    }

    public final C0309hf d(long j2) {
        return (C0309hf) b(p.b, j2);
    }

    public final C0309hf e(long j2) {
        return (C0309hf) b(j.b, j2);
    }

    public final String i(String str) {
        return this.f892a.getString(m.b, str);
    }

    public final C0309hf j(String str) {
        return (C0309hf) b(m.b, str);
    }

    @Override // io.appmetrica.analytics.impl.Ld
    public final String f(String str) {
        return new C0383kf(str, null).b;
    }

    public final C0309hf a(List<String> list) {
        return (C0309hf) b(i.b, fo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
    }

    public final C0309hf h(IdentifiersResult identifiersResult) {
        return a(k.b, identifiersResult);
    }

    public final C0309hf a(C0478oa c0478oa) {
        String str = w.b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("libSslEnabled", c0478oa.f971a).put(DownloadsDB.DownloadColumns.STATUS, c0478oa.b.getValue()).putOpt("ERROR_EXPLANATION", c0478oa.c);
        } catch (Throwable unused) {
        }
        return (C0309hf) b(str, jSONObject.toString());
    }

    @Override // io.appmetrica.analytics.impl.Ld
    /* renamed from: k */
    public final C0309hf g(String str) {
        return (C0309hf) d(new C0383kf(str, null).b);
    }

    public final void a(ScreenInfo screenInfo) {
        b(u.b, AbstractC0753zb.a(screenInfo));
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        b(x.b, appMetricaConfig.toJson());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0309hf a(String str, IdentifiersResult identifiersResult) {
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
