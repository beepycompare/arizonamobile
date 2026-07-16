package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Jf implements InterfaceC0669vj {

    /* renamed from: a  reason: collision with root package name */
    public final Context f614a;
    public final String b = NativeProtocol.CONTENT_SCHEME + a() + "/preload_info";
    public final String c = "tracking_id";
    public final String d = "additional_parameters";

    public Jf(Context context) {
        this.f614a = context;
    }

    public final String a() {
        return "com.yandex.preinstallsatellite.appmetrica.provider";
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: b */
    public final Qf invoke() {
        Cursor cursor;
        JSONObject jSONObject;
        if (!PackageManagerUtils.hasContentProvider(this.f614a, "com.yandex.preinstallsatellite.appmetrica.provider")) {
            Gj.a("Satellite content provider with preload info was not found.", new Object[0]);
            return null;
        }
        try {
            cursor = this.f614a.getContentResolver().query(Uri.parse(this.b), null, null, null, null);
            try {
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow(this.c));
                        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(this.d));
                        if (string2 != null && string2.length() != 0) {
                            jSONObject = new JSONObject(string2);
                            JSONObject jSONObject2 = jSONObject;
                            if (!TextUtils.isEmpty(string) && ParseUtils.parseLong(string) == null) {
                                Gj.a("Tracking id from Satellite is not a number.", new Object[0]);
                            }
                            Gj.a("Preload info from Satellite: {tracking id = %s, additional parameters = %s}", string, jSONObject2);
                            Qf qf = new Qf(string, jSONObject2, !TextUtils.isEmpty(string), false, EnumC0399l8.e);
                            Oo.a(cursor);
                            return qf;
                        }
                        jSONObject = new JSONObject();
                        JSONObject jSONObject22 = jSONObject;
                        if (!TextUtils.isEmpty(string)) {
                            Gj.a("Tracking id from Satellite is not a number.", new Object[0]);
                        }
                        Gj.a("Preload info from Satellite: {tracking id = %s, additional parameters = %s}", string, jSONObject22);
                        Qf qf2 = new Qf(string, jSONObject22, !TextUtils.isEmpty(string), false, EnumC0399l8.e);
                        Oo.a(cursor);
                        return qf2;
                    }
                    Gj.a("No Preload Info data in Satellite content provider", new Object[0]);
                } else {
                    Gj.a("No Satellite content provider found", new Object[0]);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        Oo.a(cursor);
        return null;
    }
}
