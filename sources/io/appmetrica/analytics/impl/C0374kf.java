package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.kf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0374kf implements Vi {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1075a;
    public final String b = NativeProtocol.CONTENT_SCHEME + a() + "/preload_info";
    public final String c = "tracking_id";
    public final String d = "additional_parameters";

    public C0374kf(Context context) {
        this.f1075a = context;
    }

    public final String a() {
        return "com.yandex.preinstallsatellite.appmetrica.provider";
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: b */
    public final C0549rf invoke() {
        Cursor cursor;
        JSONObject jSONObject;
        if (!PackageManagerUtils.hasContentProvider(this.f1075a, "com.yandex.preinstallsatellite.appmetrica.provider")) {
            AbstractC0275gj.a("Satellite content provider with preload info was not found.", new Object[0]);
            return null;
        }
        try {
            cursor = this.f1075a.getContentResolver().query(Uri.parse(this.b), null, null, null, null);
            try {
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow(this.c));
                        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(this.d));
                        if (string2 != null && string2.length() != 0) {
                            jSONObject = new JSONObject(string2);
                            JSONObject jSONObject2 = jSONObject;
                            if (!TextUtils.isEmpty(string) && ParseUtils.parseLong(string) == null) {
                                AbstractC0275gj.a("Tracking id from Satellite is not a number.", new Object[0]);
                            }
                            AbstractC0275gj.a("Preload info from Satellite: {tracking id = %s, additional parameters = %s}", string, jSONObject2);
                            C0549rf c0549rf = new C0549rf(string, jSONObject2, !TextUtils.isEmpty(string), false, T7.d);
                            mo.a(cursor);
                            return c0549rf;
                        }
                        jSONObject = new JSONObject();
                        JSONObject jSONObject22 = jSONObject;
                        if (!TextUtils.isEmpty(string)) {
                            AbstractC0275gj.a("Tracking id from Satellite is not a number.", new Object[0]);
                        }
                        AbstractC0275gj.a("Preload info from Satellite: {tracking id = %s, additional parameters = %s}", string, jSONObject22);
                        C0549rf c0549rf2 = new C0549rf(string, jSONObject22, !TextUtils.isEmpty(string), false, T7.d);
                        mo.a(cursor);
                        return c0549rf2;
                    }
                    AbstractC0275gj.a("No Preload Info data in Satellite content provider", new Object[0]);
                } else {
                    AbstractC0275gj.a("No Satellite content provider found", new Object[0]);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        mo.a(cursor);
        return null;
    }
}
