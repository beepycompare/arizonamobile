package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.ResultReceiver;
import android.text.TextUtils;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.AppMetricaConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public final class Nf implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public final ContentValues f554a;
    public final ResultReceiver b;
    public static final String c = UUID.randomUUID().toString();
    public static final Parcelable.Creator<Nf> CREATOR = new Mf();

    public Nf(Context context, ResultReceiver resultReceiver) {
        ContentValues contentValues = new ContentValues();
        this.f554a = contentValues;
        contentValues.put("PROCESS_CFG_PROCESS_ID", Integer.valueOf(Process.myPid()));
        contentValues.put("PROCESS_CFG_PROCESS_SESSION_ID", c);
        contentValues.put("PROCESS_CFG_SDK_API_LEVEL", Integer.valueOf(AppMetrica.getLibraryApiLevel()));
        contentValues.put("PROCESS_CFG_PACKAGE_NAME", context.getPackageName());
        this.b = resultReceiver;
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        Object obj = appMetricaConfig.additionalConfig.get("YMM_clids");
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map != null) {
            HashMap b = Dm.b(map);
            synchronized (this) {
                this.f554a.put("PROCESS_CFG_CLIDS", AbstractC0753zb.b(b));
            }
        }
    }

    public final void b(AppMetricaConfig appMetricaConfig) {
        List<String> list = appMetricaConfig.customHosts;
        if (list != null) {
            synchronized (this) {
                this.f554a.put("PROCESS_CFG_CUSTOM_HOSTS", fo.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
            }
        }
    }

    public final void c(AppMetricaConfig appMetricaConfig) {
        String str = (String) appMetricaConfig.additionalConfig.get("YMM_distributionReferrer");
        if (str != null) {
            synchronized (this) {
                this.f554a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
            }
            i();
        }
    }

    public final void d(AppMetricaConfig appMetricaConfig) {
        if (appMetricaConfig != null) {
            synchronized (this) {
                b(appMetricaConfig);
                a(appMetricaConfig);
                c(appMetricaConfig);
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f554a.getAsString("PROCESS_CFG_PACKAGE_NAME");
    }

    public final Integer f() {
        return this.f554a.getAsInteger("PROCESS_CFG_PROCESS_ID");
    }

    public final String g() {
        return this.f554a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
    }

    public final boolean h() {
        return this.f554a.containsKey("PROCESS_CFG_CUSTOM_HOSTS");
    }

    public final synchronized void i() {
        this.f554a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", "api");
    }

    public final String toString() {
        return "ProcessConfiguration{mParamsMapping=" + this.f554a + ", mDataResultReceiver=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("CFG_KEY_PROCESS_ENVIRONMENT", this.f554a);
        bundle.putParcelable("CFG_KEY_PROCESS_ENVIRONMENT_RECEIVER", this.b);
        parcel.writeBundle(bundle);
    }

    public final HashMap a() {
        return AbstractC0753zb.c(this.f554a.getAsString("PROCESS_CFG_CLIDS"));
    }

    public final String c() {
        return this.f554a.getAsString("PROCESS_CFG_DISTRIBUTION_REFERRER");
    }

    public final String d() {
        return this.f554a.getAsString("PROCESS_CFG_INSTALL_REFERRER_SOURCE");
    }

    public Nf(Nf nf) {
        synchronized (nf) {
            this.f554a = new ContentValues(nf.f554a);
            this.b = nf.b;
        }
    }

    public final ArrayList b() {
        String asString = this.f554a.getAsString("PROCESS_CFG_CUSTOM_HOSTS");
        if (TextUtils.isEmpty(asString)) {
            return null;
        }
        return AbstractC0753zb.b(asString);
    }

    public Nf(ContentValues contentValues, ResultReceiver resultReceiver) {
        this.f554a = contentValues == null ? new ContentValues() : contentValues;
        this.b = resultReceiver;
    }
}
