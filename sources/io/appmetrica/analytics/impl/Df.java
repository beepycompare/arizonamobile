package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Df implements InterfaceC0541qj {

    /* renamed from: a  reason: collision with root package name */
    public final Context f410a;
    public final String b = NativeProtocol.CONTENT_SCHEME + a() + "/preload_info";
    public final String c = "tracking_id";
    public final String d = "additional_parameters";

    public Df(Context context) {
        this.f410a = context;
    }

    public final String a() {
        return "com.yandex.preinstallsatellite.appmetrica.provider";
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: b */
    public final Kf invoke() {
        Cursor cursor;
        JSONObject jSONObject;
        if (!PackageManagerUtils.hasContentProvider(this.f410a, "com.yandex.preinstallsatellite.appmetrica.provider")) {
            Bj.a("Satellite content provider with preload info was not found.", new Object[0]);
            return null;
        }
        try {
            cursor = this.f410a.getContentResolver().query(Uri.parse(this.b), null, null, null, null);
            try {
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow(this.c));
                        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(this.d));
                        if (string2 != null && string2.length() != 0) {
                            jSONObject = new JSONObject(string2);
                            JSONObject jSONObject2 = jSONObject;
                            if (!TextUtils.isEmpty(string) && ParseUtils.parseLong(string) == null) {
                                Bj.a("Tracking id from Satellite is not a number.", new Object[0]);
                            }
                            Bj.a("Preload info from Satellite: {tracking id = %s, additional parameters = %s}", string, jSONObject2);
                            Kf kf = new Kf(string, jSONObject2, !TextUtils.isEmpty(string), false, EnumC0530q8.d);
                            ro.a(cursor);
                            return kf;
                        }
                        jSONObject = new JSONObject();
                        JSONObject jSONObject22 = jSONObject;
                        if (!TextUtils.isEmpty(string)) {
                            Bj.a("Tracking id from Satellite is not a number.", new Object[0]);
                        }
                        Bj.a("Preload info from Satellite: {tracking id = %s, additional parameters = %s}", string, jSONObject22);
                        Kf kf2 = new Kf(string, jSONObject22, !TextUtils.isEmpty(string), false, EnumC0530q8.d);
                        ro.a(cursor);
                        return kf2;
                    }
                    Bj.a("No Preload Info data in Satellite content provider", new Object[0]);
                } else {
                    Bj.a("No Satellite content provider found", new Object[0]);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        ro.a(cursor);
        return null;
    }
}
