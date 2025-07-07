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
public final class C0317hf extends Ld {
    public static final C0391kf d = new C0391kf("UUID_RESULT", null);
    public static final C0391kf e = new C0391kf("DEVICE_ID_RESULT", null);
    public static final C0391kf f = new C0391kf("DEVICE_ID_HASH_RESULT", null);
    public static final C0391kf g = new C0391kf("AD_URL_GET_RESULT", null);
    public static final C0391kf h = new C0391kf("AD_URL_REPORT_RESULT", null);
    public static final C0391kf i = new C0391kf("CUSTOM_HOSTS", null);
    public static final C0391kf j = new C0391kf("SERVER_TIME_OFFSET", null);
    public static final C0391kf k = new C0391kf("RESPONSE_CLIDS_RESULT", null);
    public static final C0391kf l = new C0391kf("CUSTOM_SDK_HOSTS", null);
    public static final C0391kf m = new C0391kf("CLIENT_CLIDS", null);
    public static final C0391kf n = new C0391kf("DEFERRED_DEEP_LINK_WAS_CHECKED", null);
    public static final C0391kf o = new C0391kf("API_LEVEL", null);
    public static final C0391kf p = new C0391kf("NEXT_STARTUP_TIME", null);
    public static final C0391kf q = new C0391kf("GAID", null);
    public static final C0391kf r = new C0391kf("HOAID", null);
    public static final C0391kf s = new C0391kf("YANDEX_ADV_ID", null);
    public static final C0391kf t = new C0391kf("CLIENT_CLIDS_CHANGED_AFTER_LAST_IDENTIFIERS_UPDATE", null);
    public static final C0391kf u = new C0391kf("SCREEN_INFO", null);
    public static final C0391kf v = new C0391kf("SCREEN_SIZE_CHECKED_BY_DEPRECATED", null);
    public static final C0391kf w = new C0391kf("FEATURES", null);
    public static final C0391kf x = new C0391kf("APPMETRICA_CLIENT_CONFIG", null);

    public C0317hf(InterfaceC0135ab interfaceC0135ab) {
        super(interfaceC0135ab);
    }

    public final boolean a(boolean z) {
        return this.f891a.getBoolean(t.b, z);
    }

    public final long b(long j2) {
        return this.f891a.getLong(j.f905a, j2);
    }

    public final C0317hf c(IdentifiersResult identifiersResult) {
        return a(l.b, identifiersResult);
    }

    public final IdentifiersResult d() {
        return h(g.b);
    }

    public final IdentifiersResult e() {
        return h(h.b);
    }

    public final C0317hf f(IdentifiersResult identifiersResult) {
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

    public final C0486oa k() {
        String string = this.f891a.getString(w.b, null);
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                return new C0486oa(JsonUtils.optBooleanOrNull(jSONObject, "libSslEnabled"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, DownloadsDB.DownloadColumns.STATUS)), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            }
        } catch (Throwable unused) {
        }
        return new C0486oa(null, IdentifierStatus.UNKNOWN, null);
    }

    public final IdentifiersResult l() {
        return h(q.b);
    }

    public final IdentifiersResult m() {
        return h(r.b);
    }

    public final long n() {
        return this.f891a.getLong(p.b, 0L);
    }

    public final IdentifiersResult o() {
        return h(k.b);
    }

    public final ScreenInfo p() {
        return AbstractC0761zb.e(this.f891a.getString(u.b, null));
    }

    public final IdentifiersResult q() {
        return h(d.b);
    }

    public final IdentifiersResult r() {
        return h(s.b);
    }

    public final boolean s() {
        return this.f891a.getBoolean(n.b, false);
    }

    public final boolean t() {
        return this.f891a.getBoolean(v.b, false);
    }

    public final C0317hf u() {
        return (C0317hf) b(n.b, true);
    }

    public final void v() {
        b(v.b, true);
    }

    public final List<String> g() {
        String string = this.f891a.getString(i.b, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return AbstractC0761zb.b(string);
    }

    public final long a(long j2) {
        return this.f891a.getLong(o.b, j2);
    }

    public final C0317hf b(IdentifiersResult identifiersResult) {
        return a(h.b, identifiersResult);
    }

    public final C0317hf c(long j2) {
        return (C0317hf) b(o.b, j2);
    }

    public final C0317hf d(IdentifiersResult identifiersResult) {
        return a(f.b, identifiersResult);
    }

    public final C0317hf e(IdentifiersResult identifiersResult) {
        return a(e.b, identifiersResult);
    }

    public final AppMetricaConfig f() {
        String string = this.f891a.getString(x.b, null);
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
            string = this.f891a.getString(str, null);
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

    public final C0317hf i(IdentifiersResult identifiersResult) {
        return a(d.b, identifiersResult);
    }

    public final C0317hf j(IdentifiersResult identifiersResult) {
        return a(s.b, identifiersResult);
    }

    public final C0317hf g(IdentifiersResult identifiersResult) {
        return a(r.b, identifiersResult);
    }

    public final C0317hf a(IdentifiersResult identifiersResult) {
        return a(g.b, identifiersResult);
    }

    public final C0317hf b(boolean z) {
        return (C0317hf) b(t.b, z);
    }

    public final C0317hf d(long j2) {
        return (C0317hf) b(p.b, j2);
    }

    public final C0317hf e(long j2) {
        return (C0317hf) b(j.b, j2);
    }

    public final String i(String str) {
        return this.f891a.getString(m.b, str);
    }

    public final C0317hf j(String str) {
        return (C0317hf) b(m.b, str);
    }

    @Override // io.appmetrica.analytics.impl.Ld
    public final String f(String str) {
        return new C0391kf(str, null).b;
    }

    public final C0317hf a(List<String> list) {
        return (C0317hf) b(i.b, fo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
    }

    public final C0317hf h(IdentifiersResult identifiersResult) {
        return a(k.b, identifiersResult);
    }

    public final C0317hf a(C0486oa c0486oa) {
        String str = w.b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("libSslEnabled", c0486oa.f970a).put(DownloadsDB.DownloadColumns.STATUS, c0486oa.b.getValue()).putOpt("ERROR_EXPLANATION", c0486oa.c);
        } catch (Throwable unused) {
        }
        return (C0317hf) b(str, jSONObject.toString());
    }

    @Override // io.appmetrica.analytics.impl.Ld
    /* renamed from: k */
    public final C0317hf g(String str) {
        return (C0317hf) d(new C0391kf(str, null).b);
    }

    public final void a(ScreenInfo screenInfo) {
        b(u.b, AbstractC0761zb.a(screenInfo));
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        b(x.b, appMetricaConfig.toJson());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0317hf a(String str, IdentifiersResult identifiersResult) {
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
