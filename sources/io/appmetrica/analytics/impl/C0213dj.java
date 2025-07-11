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
/* renamed from: io.appmetrica.analytics.impl.dj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0213dj implements InterfaceC0238ej {

    /* renamed from: a  reason: collision with root package name */
    public final Context f808a;
    public final String b = NativeProtocol.CONTENT_SCHEME + a() + "/clids";
    public final String c = "clid_key";
    public final String d = "clid_value";

    public C0213dj(Context context) {
        this.f808a = context;
    }

    public final String a() {
        return "com.yandex.preinstallsatellite.appmetrica.provider";
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: b */
    public final N3 invoke() {
        Cursor cursor;
        if (!PackageManagerUtils.hasContentProvider(this.f808a, "com.yandex.preinstallsatellite.appmetrica.provider")) {
            AbstractC0512pj.a("Satellite content provider with clids was not found.", new Object[0]);
            return null;
        }
        try {
            cursor = this.f808a.getContentResolver().query(Uri.parse(this.b), null, null, null, null);
            try {
            } catch (Throwable th) {
                th = th;
                try {
                    ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Error while getting satellite clids", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
                    return null;
                } finally {
                    fo.a(cursor);
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
                        AbstractC0512pj.a("Invalid clid {%s : %s}", string, string2);
                    }
                } catch (Throwable unused) {
                }
            }
            AbstractC0512pj.a("Clids from satellite: %s", linkedHashMap);
            return new N3(linkedHashMap, EnumC0327i8.d);
        }
        AbstractC0512pj.a("No Satellite content provider found", new Object[0]);
        return null;
    }
}
