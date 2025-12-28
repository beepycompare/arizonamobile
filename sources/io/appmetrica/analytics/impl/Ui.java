package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public final class Ui implements Vi {

    /* renamed from: a  reason: collision with root package name */
    public final Context f811a;
    public final String b = NativeProtocol.CONTENT_SCHEME + a() + "/clids";
    public final String c = "clid_key";
    public final String d = "clid_value";

    public Ui(Context context) {
        this.f811a = context;
    }

    public final String a() {
        return "com.yandex.preinstallsatellite.appmetrica.provider";
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: b */
    public final C0562s3 invoke() {
        Cursor cursor;
        if (!PackageManagerUtils.hasContentProvider(this.f811a, "com.yandex.preinstallsatellite.appmetrica.provider")) {
            AbstractC0275gj.a("Satellite content provider with clids was not found.", new Object[0]);
            return null;
        }
        try {
            cursor = this.f811a.getContentResolver().query(Uri.parse(this.b), null, null, null, null);
            try {
            } catch (Throwable th) {
                th = th;
                try {
                    ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Error while getting satellite clids", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
                    return null;
                } finally {
                    mo.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        if (cursor != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (cursor.moveToNext()) {
                try {
                    String string = cursor.getString(cursor.getColumnIndexOrThrow(this.c));
                    String string2 = cursor.getString(cursor.getColumnIndexOrThrow(this.d));
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        linkedHashMap.put(string, string2);
                    } else {
                        AbstractC0275gj.a("Invalid clid {%s : %s}", string, string2);
                    }
                } catch (Throwable unused) {
                }
            }
            AbstractC0275gj.a("Clids from satellite: %s", linkedHashMap);
            return new C0562s3(linkedHashMap, T7.d);
        }
        AbstractC0275gj.a("No Satellite content provider found", new Object[0]);
        return null;
    }
}
