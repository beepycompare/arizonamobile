package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.zf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0757zf implements InterfaceC0437mj {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1180a;
    public final String b = NativeProtocol.CONTENT_SCHEME + a() + "/preload_info";
    public final String c = "tracking_id";
    public final String d = "additional_parameters";

    public C0757zf(Context context) {
        this.f1180a = context;
    }

    public final String a() {
        return "com.yandex.preinstallsatellite.appmetrica.provider";
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: b */
    public final Gf invoke() {
        Cursor cursor;
        JSONObject jSONObject;
        if (!PackageManagerUtils.hasContentProvider(this.f1180a, "com.yandex.preinstallsatellite.appmetrica.provider")) {
            AbstractC0711xj.a("Satellite content provider with preload info was not found.", new Object[0]);
            return null;
        }
        try {
            cursor = this.f1180a.getContentResolver().query(Uri.parse(this.b), null, null, null, null);
            try {
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow(this.c));
                        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(this.d));
                        if (string2 != null && string2.length() != 0) {
                            jSONObject = new JSONObject(string2);
                            JSONObject jSONObject2 = jSONObject;
                            if (!TextUtils.isEmpty(string) && ParseUtils.parseLong(string) == null) {
                                AbstractC0711xj.a("Tracking id from Satellite is not a number.", new Object[0]);
                            }
                            AbstractC0711xj.a("Preload info from Satellite: {tracking id = %s, additional parameters = %s}", string, jSONObject2);
                            Gf gf = new Gf(string, jSONObject2, !TextUtils.isEmpty(string), false, EnumC0451n8.d);
                            no.a(cursor);
                            return gf;
                        }
                        jSONObject = new JSONObject();
                        JSONObject jSONObject22 = jSONObject;
                        if (!TextUtils.isEmpty(string)) {
                            AbstractC0711xj.a("Tracking id from Satellite is not a number.", new Object[0]);
                        }
                        AbstractC0711xj.a("Preload info from Satellite: {tracking id = %s, additional parameters = %s}", string, jSONObject22);
                        Gf gf2 = new Gf(string, jSONObject22, !TextUtils.isEmpty(string), false, EnumC0451n8.d);
                        no.a(cursor);
                        return gf2;
                    }
                    AbstractC0711xj.a("No Preload Info data in Satellite content provider", new Object[0]);
                } else {
                    AbstractC0711xj.a("No Satellite content provider found", new Object[0]);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        no.a(cursor);
        return null;
    }
}
