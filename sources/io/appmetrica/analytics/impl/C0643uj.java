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
/* renamed from: io.appmetrica.analytics.impl.uj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0643uj implements InterfaceC0669vj {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1234a;
    public final String b = NativeProtocol.CONTENT_SCHEME + a() + "/clids";
    public final String c = "clid_key";
    public final String d = "clid_value";

    public C0643uj(Context context) {
        this.f1234a = context;
    }

    public final String a() {
        return "com.yandex.preinstallsatellite.appmetrica.provider";
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: b */
    public final I3 invoke() {
        Throwable th;
        Cursor cursor;
        if (!PackageManagerUtils.hasContentProvider(this.f1234a, "com.yandex.preinstallsatellite.appmetrica.provider")) {
            Gj.a("Satellite content provider with clids was not found.", new Object[0]);
            return null;
        }
        try {
            cursor = this.f1234a.getContentResolver().query(Uri.parse(this.b), null, null, null, null);
            try {
            } catch (Throwable th2) {
                th = th2;
                try {
                    ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Error while getting satellite clids", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
                    return null;
                } finally {
                    Oo.a(cursor);
                }
            }
        } catch (Throwable th3) {
            th = th3;
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
                        Gj.a("Invalid clid {%s : %s}", string, string2);
                    }
                } catch (Throwable unused) {
                }
            }
            Gj.a("Clids from satellite: %s", linkedHashMap);
            return new I3(linkedHashMap, EnumC0399l8.e);
        }
        Gj.a("No Satellite content provider found", new Object[0]);
        return null;
    }
}
