package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.vf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0665vf implements InterfaceC0246ej {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1092a;
    public final String b = NativeProtocol.CONTENT_SCHEME + a() + "/preload_info";
    public final String c = "tracking_id";
    public final String d = "additional_parameters";

    public C0665vf(Context context) {
        this.f1092a = context;
    }

    public final String a() {
        return "com.yandex.preinstallsatellite.appmetrica.provider";
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: b */
    public final Cf invoke() {
        Cursor cursor;
        JSONObject jSONObject;
        if (!PackageManagerUtils.hasContentProvider(this.f1092a, "com.yandex.preinstallsatellite.appmetrica.provider")) {
            AbstractC0520pj.a("Satellite content provider with preload info was not found.", new Object[0]);
            return null;
        }
        try {
            cursor = this.f1092a.getContentResolver().query(Uri.parse(this.b), null, null, null, null);
            try {
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow(this.c));
                        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(this.d));
                        if (string2 != null && string2.length() != 0) {
                            jSONObject = new JSONObject(string2);
                            JSONObject jSONObject2 = jSONObject;
                            if (!TextUtils.isEmpty(string) && ParseUtils.parseLong(string) == null) {
                                AbstractC0520pj.a("Tracking id from Satellite is not a number.", new Object[0]);
                            }
                            AbstractC0520pj.a("Preload info from Satellite: {tracking id = %s, additional parameters = %s}", string, jSONObject2);
                            Cf cf = new Cf(string, jSONObject2, !TextUtils.isEmpty(string), false, EnumC0335i8.d);
                            fo.a(cursor);
                            return cf;
                        }
                        jSONObject = new JSONObject();
                        JSONObject jSONObject22 = jSONObject;
                        if (!TextUtils.isEmpty(string)) {
                            AbstractC0520pj.a("Tracking id from Satellite is not a number.", new Object[0]);
                        }
                        AbstractC0520pj.a("Preload info from Satellite: {tracking id = %s, additional parameters = %s}", string, jSONObject22);
                        Cf cf2 = new Cf(string, jSONObject22, !TextUtils.isEmpty(string), false, EnumC0335i8.d);
                        fo.a(cursor);
                        return cf2;
                    }
                    AbstractC0520pj.a("No Preload Info data in Satellite content provider", new Object[0]);
                } else {
                    AbstractC0520pj.a("No Satellite content provider found", new Object[0]);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        fo.a(cursor);
        return null;
    }
}
