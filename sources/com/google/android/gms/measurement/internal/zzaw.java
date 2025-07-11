package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzaw {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r0 == false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void zza(zzgt zzgtVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        Throwable th;
        Cursor cursor;
        String[] split;
        if (zzgtVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursor2 = null;
        try {
            try {
                cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = cursor.moveToFirst();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzgtVar.zze().zzc("Error querying for table", str, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    sQLiteDatabase.execSQL(str2);
                    try {
                        HashSet hashSet = new HashSet();
                        StringBuilder sb = new StringBuilder(str.length() + 22);
                        sb.append("SELECT * FROM ");
                        sb.append(str);
                        sb.append(" LIMIT 0");
                        Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
                        Collections.addAll(hashSet, rawQuery.getColumnNames());
                        rawQuery.close();
                        for (String str4 : str3.split(StringUtils.COMMA)) {
                            if (!hashSet.remove(str4)) {
                                StringBuilder sb2 = new StringBuilder(str.length() + 35 + String.valueOf(str4).length());
                                sb2.append("Table ");
                                sb2.append(str);
                                sb2.append(" is missing required column: ");
                                sb2.append(str4);
                                throw new SQLiteException(sb2.toString());
                            }
                        }
                        if (strArr != null) {
                            for (int i = 0; i < strArr.length; i += 2) {
                                if (!hashSet.remove(strArr[i])) {
                                    sQLiteDatabase.execSQL(strArr[i + 1]);
                                }
                            }
                        }
                        if (hashSet.isEmpty()) {
                            return;
                        }
                        zzgtVar.zze().zzc("Table has extra columns. table, columns", str, TextUtils.join(", ", hashSet));
                    } catch (SQLiteException e2) {
                        zzgtVar.zzb().zzb("Failed to verify columns on table that was just created", str);
                        throw e2;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(zzgt zzgtVar, SQLiteDatabase sQLiteDatabase) {
        if (zzgtVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        com.google.android.gms.internal.measurement.zzbv.zza();
        String path = sQLiteDatabase.getPath();
        int i = com.google.android.gms.internal.measurement.zzca.zzb;
        File file = new File(path);
        if (!file.setReadable(false, false)) {
            zzgtVar.zze().zza("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzgtVar.zze().zza("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzgtVar.zze().zza("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzgtVar.zze().zza("Failed to turn on database write permission for owner");
    }
}
