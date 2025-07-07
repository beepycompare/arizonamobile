package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzgv extends zzg {
    private static final String[] zza = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};
    private final zzgt zzb;
    private boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgv(zzio zzioVar) {
        super(zzioVar);
        Context zzaT = this.zzu.zzaT();
        this.zzu.zzf();
        this.zzb = new zzgt(this, zzaT, "google_app_measurement_local.db");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzs(int i, byte[] bArr) {
        SQLiteDatabase sQLiteDatabase;
        boolean z;
        Cursor cursor;
        zzg();
        boolean z2 = false;
        z2 = false;
        if (!this.zzc) {
            zzio zzioVar = this.zzu;
            Cursor cursor2 = null;
            zzr zzk = zzioVar.zzf().zzx(null, zzgi.zzbl) ? this.zzu.zzh().zzk(null) : null;
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", Integer.valueOf(i));
            contentValues.put("entry", bArr);
            if (zzioVar.zzf().zzx(null, zzgi.zzbl) && zzk != null) {
                contentValues.put("app_version", zzk.zzc);
                contentValues.put("app_version_int", Long.valueOf(zzk.zzj));
            }
            zzioVar.zzf();
            int i2 = 0;
            int i3 = 5;
            for (int i4 = 5; i2 < i4; i4 = 5) {
                try {
                    sQLiteDatabase = zzh();
                    if (sQLiteDatabase == null) {
                        this.zzc = true;
                    } else {
                        try {
                            sQLiteDatabase.beginTransaction();
                            cursor = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                            long j = 0;
                            if (cursor != null) {
                                try {
                                    if (cursor.moveToFirst()) {
                                        j = cursor.getLong(z2 ? 1 : 0);
                                    }
                                } catch (SQLiteDatabaseLockedException unused) {
                                    z = z2 ? 1 : 0;
                                    SystemClock.sleep(i3);
                                    i3 += 20;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabase == null) {
                                        i2++;
                                        z2 = z;
                                    }
                                    sQLiteDatabase.close();
                                    i2++;
                                    z2 = z;
                                } catch (SQLiteFullException e) {
                                    e = e;
                                    z = z2 ? 1 : 0;
                                    this.zzu.zzaW().zze().zzb("Error writing entry; local database full", e);
                                    this.zzc = true;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabase == null) {
                                        i2++;
                                        z2 = z;
                                    }
                                    sQLiteDatabase.close();
                                    i2++;
                                    z2 = z;
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    z = z2 ? 1 : 0;
                                    if (sQLiteDatabase != null) {
                                        try {
                                            if (sQLiteDatabase.inTransaction()) {
                                                sQLiteDatabase.endTransaction();
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor2 = cursor;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            if (sQLiteDatabase != null) {
                                                sQLiteDatabase.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    this.zzu.zzaW().zze().zzb("Error writing entry to local database", e);
                                    this.zzc = true;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabase == null) {
                                        i2++;
                                        z2 = z;
                                    }
                                    sQLiteDatabase.close();
                                    i2++;
                                    z2 = z;
                                }
                            }
                            if (j >= SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
                                zzioVar.zzaW().zze().zza("Data loss, local db full");
                                String[] strArr = new String[1];
                                long j2 = 100001 - j;
                                strArr[z2 ? 1 : 0] = Long.toString(j2);
                                long delete = sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                                if (delete != j2) {
                                    zzhc zze = zzioVar.zzaW().zze();
                                    z = z2 ? 1 : 0;
                                    try {
                                        zze.zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(delete), Long.valueOf(j2 - delete));
                                        sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                                        sQLiteDatabase.setTransactionSuccessful();
                                        sQLiteDatabase.endTransaction();
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        sQLiteDatabase.close();
                                        return true;
                                    } catch (SQLiteDatabaseLockedException unused2) {
                                        SystemClock.sleep(i3);
                                        i3 += 20;
                                        if (cursor != null) {
                                        }
                                        if (sQLiteDatabase == null) {
                                        }
                                        sQLiteDatabase.close();
                                        i2++;
                                        z2 = z;
                                    } catch (SQLiteFullException e3) {
                                        e = e3;
                                        this.zzu.zzaW().zze().zzb("Error writing entry; local database full", e);
                                        this.zzc = true;
                                        if (cursor != null) {
                                        }
                                        if (sQLiteDatabase == null) {
                                        }
                                        sQLiteDatabase.close();
                                        i2++;
                                        z2 = z;
                                    } catch (SQLiteException e4) {
                                        e = e4;
                                        if (sQLiteDatabase != null) {
                                        }
                                        this.zzu.zzaW().zze().zzb("Error writing entry to local database", e);
                                        this.zzc = true;
                                        if (cursor != null) {
                                        }
                                        if (sQLiteDatabase == null) {
                                        }
                                        sQLiteDatabase.close();
                                        i2++;
                                        z2 = z;
                                    }
                                }
                            }
                            z = z2 ? 1 : 0;
                            sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                            sQLiteDatabase.setTransactionSuccessful();
                            sQLiteDatabase.endTransaction();
                            if (cursor != null) {
                            }
                            sQLiteDatabase.close();
                            return true;
                        } catch (SQLiteDatabaseLockedException unused3) {
                            z = z2 ? 1 : 0;
                            cursor = null;
                        } catch (SQLiteFullException e5) {
                            e = e5;
                            z = z2 ? 1 : 0;
                            cursor = null;
                        } catch (SQLiteException e6) {
                            e = e6;
                            z = z2 ? 1 : 0;
                            cursor = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused4) {
                    z = z2 ? 1 : 0;
                    sQLiteDatabase = null;
                    cursor = null;
                } catch (SQLiteFullException e7) {
                    e = e7;
                    z = z2 ? 1 : 0;
                    sQLiteDatabase = null;
                    cursor = null;
                } catch (SQLiteException e8) {
                    e = e8;
                    z = z2 ? 1 : 0;
                    sQLiteDatabase = null;
                    cursor = null;
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabase = null;
                }
            }
            boolean z3 = z2 ? 1 : 0;
            this.zzu.zzaW().zzj().zza("Failed to write entry to local database");
            return z3;
        }
        return z2;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzf() {
        return false;
    }

    final SQLiteDatabase zzh() throws SQLiteException {
        if (this.zzc) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzb.getWritableDatabase();
        if (writableDatabase == null) {
            this.zzc = true;
            return null;
        }
        return writableDatabase;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01dd A[Catch: SQLiteException -> 0x02b4, SQLiteDatabaseLockedException -> 0x02b9, SQLiteFullException -> 0x02bd, all -> 0x0395, TryCatch #38 {all -> 0x0395, blocks: (B:33:0x00ca, B:35:0x00d0, B:37:0x00e9, B:42:0x00fe, B:47:0x0116, B:49:0x011b, B:190:0x0356, B:179:0x032b, B:181:0x0331, B:182:0x0334, B:199:0x0370, B:60:0x0144, B:61:0x0147, B:57:0x013b, B:72:0x0163, B:74:0x0177, B:81:0x0192, B:82:0x019b, B:83:0x019e, B:79:0x018c, B:90:0x01a6, B:94:0x01bc, B:104:0x01dd, B:105:0x01e7, B:106:0x01ea, B:102:0x01d7, B:109:0x01f0, B:111:0x0204, B:118:0x021f, B:119:0x0229, B:120:0x022c, B:116:0x0219, B:123:0x0230, B:124:0x0240, B:131:0x0272, B:133:0x0284, B:135:0x0290, B:136:0x029f), top: B:232:0x0356 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x032b A[Catch: all -> 0x0395, TRY_ENTER, TryCatch #38 {all -> 0x0395, blocks: (B:33:0x00ca, B:35:0x00d0, B:37:0x00e9, B:42:0x00fe, B:47:0x0116, B:49:0x011b, B:190:0x0356, B:179:0x032b, B:181:0x0331, B:182:0x0334, B:199:0x0370, B:60:0x0144, B:61:0x0147, B:57:0x013b, B:72:0x0163, B:74:0x0177, B:81:0x0192, B:82:0x019b, B:83:0x019e, B:79:0x018c, B:90:0x01a6, B:94:0x01bc, B:104:0x01dd, B:105:0x01e7, B:106:0x01ea, B:102:0x01d7, B:109:0x01f0, B:111:0x0204, B:118:0x021f, B:119:0x0229, B:120:0x022c, B:116:0x0219, B:123:0x0230, B:124:0x0240, B:131:0x0272, B:133:0x0284, B:135:0x0290, B:136:0x029f), top: B:232:0x0356 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0388 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0388 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0388 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzi(int i) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        String str;
        String str2;
        int i2;
        String str3;
        Cursor cursor2;
        Cursor cursor3;
        long j;
        String str4;
        String[] strArr;
        long j2;
        String str5;
        Parcel obtain;
        zzio zzioVar;
        int i3;
        int i4;
        zzbf zzbfVar;
        zzai zzaiVar;
        zzqb zzqbVar;
        String str6 = "entry";
        String str7 = "type";
        String str8 = "rowid";
        zzg();
        ?? r6 = 0;
        if (this.zzc) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (zzl()) {
            int i5 = 0;
            int i6 = 5;
            int i7 = 0;
            for (int i8 = 5; i7 < i8; i8 = 5) {
                int i9 = 1;
                try {
                    sQLiteDatabase = zzh();
                    try {
                        if (sQLiteDatabase == null) {
                            this.zzc = true;
                            return r6;
                        }
                        try {
                            sQLiteDatabase.beginTransaction();
                            try {
                                String[] strArr2 = new String[1];
                                strArr2[i5] = str8;
                                String[] strArr3 = new String[1];
                                strArr3[i5] = ExifInterface.GPS_MEASUREMENT_3D;
                                cursor3 = sQLiteDatabase.query("messages", strArr2, "type=?", strArr3, null, null, "rowid desc", "1");
                            } catch (Throwable th) {
                                th = th;
                                str = str6;
                                str2 = str8;
                                i2 = i5;
                                str3 = str7;
                                cursor3 = null;
                            }
                            try {
                                long j3 = -1;
                                if (cursor3.moveToFirst()) {
                                    j = cursor3.getLong(i5);
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                } else {
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    j = -1;
                                }
                                if (j != -1) {
                                    String[] strArr4 = new String[1];
                                    strArr4[i5] = String.valueOf(j);
                                    str4 = "rowid<?";
                                    strArr = strArr4;
                                } else {
                                    str4 = r6;
                                    strArr = str4;
                                }
                                String[] strArr5 = new String[3];
                                strArr5[i5] = str8;
                                strArr5[1] = str7;
                                strArr5[2] = str6;
                                zzio zzioVar2 = this.zzu;
                                int i10 = 3;
                                if (zzioVar2.zzf().zzx(r6, zzgi.zzbl)) {
                                    strArr5 = new String[5];
                                    strArr5[i5] = str8;
                                    strArr5[1] = str7;
                                    strArr5[2] = str6;
                                    strArr5[3] = "app_version";
                                    strArr5[4] = "app_version_int";
                                }
                                zzio zzioVar3 = zzioVar2;
                                int i11 = 2;
                                cursor2 = sQLiteDatabase.query("messages", strArr5, str4, strArr, null, null, "rowid asc", Integer.toString(100));
                                while (cursor2.moveToNext()) {
                                    try {
                                        try {
                                            j3 = cursor2.getLong(i5);
                                            int i12 = cursor2.getInt(i9);
                                            byte[] blob = cursor2.getBlob(i11);
                                            if (zzioVar3.zzf().zzx(null, zzgi.zzbl)) {
                                                str5 = cursor2.getString(i10);
                                                j2 = cursor2.getLong(4);
                                            } else {
                                                j2 = 0;
                                                str5 = null;
                                            }
                                            String str9 = str6;
                                            str3 = str7;
                                            long j4 = j2;
                                            if (i12 == 0) {
                                                try {
                                                    obtain = Parcel.obtain();
                                                    zzioVar = zzioVar3;
                                                    try {
                                                        str2 = str8;
                                                        try {
                                                            try {
                                                                obtain.unmarshall(blob, 0, blob.length);
                                                                obtain.setDataPosition(0);
                                                                zzbh createFromParcel = zzbh.CREATOR.createFromParcel(obtain);
                                                                try {
                                                                    if (createFromParcel != null) {
                                                                        arrayList.add(new zzgu(createFromParcel, str5, j4));
                                                                    }
                                                                } catch (SQLiteDatabaseLockedException unused) {
                                                                    str = str9;
                                                                    i2 = 0;
                                                                    try {
                                                                        SystemClock.sleep(i6);
                                                                        i6 += 20;
                                                                        if (cursor2 != null) {
                                                                            cursor2.close();
                                                                        }
                                                                        if (sQLiteDatabase == null) {
                                                                            i7++;
                                                                            str7 = str3;
                                                                            i5 = i2;
                                                                            str6 = str;
                                                                            str8 = str2;
                                                                            r6 = 0;
                                                                        }
                                                                        sQLiteDatabase.close();
                                                                        i7++;
                                                                        str7 = str3;
                                                                        i5 = i2;
                                                                        str6 = str;
                                                                        str8 = str2;
                                                                        r6 = 0;
                                                                    } catch (Throwable th2) {
                                                                        th = th2;
                                                                        cursor = cursor2;
                                                                        if (cursor != null) {
                                                                        }
                                                                        if (sQLiteDatabase != null) {
                                                                        }
                                                                        throw th;
                                                                    }
                                                                } catch (SQLiteFullException e) {
                                                                    e = e;
                                                                    str = str9;
                                                                    i2 = 0;
                                                                    this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                                                    this.zzc = true;
                                                                    if (cursor2 != null) {
                                                                        cursor2.close();
                                                                    }
                                                                    if (sQLiteDatabase == null) {
                                                                        i7++;
                                                                        str7 = str3;
                                                                        i5 = i2;
                                                                        str6 = str;
                                                                        str8 = str2;
                                                                        r6 = 0;
                                                                    }
                                                                    sQLiteDatabase.close();
                                                                    i7++;
                                                                    str7 = str3;
                                                                    i5 = i2;
                                                                    str6 = str;
                                                                    str8 = str2;
                                                                    r6 = 0;
                                                                } catch (SQLiteException e2) {
                                                                    e = e2;
                                                                    str = str9;
                                                                    i2 = 0;
                                                                    if (sQLiteDatabase != null && sQLiteDatabase.inTransaction()) {
                                                                        sQLiteDatabase.endTransaction();
                                                                    }
                                                                    this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                                                    this.zzc = true;
                                                                    if (cursor2 != null) {
                                                                        cursor2.close();
                                                                    }
                                                                    if (sQLiteDatabase == null) {
                                                                        i7++;
                                                                        str7 = str3;
                                                                        i5 = i2;
                                                                        str6 = str;
                                                                        str8 = str2;
                                                                        r6 = 0;
                                                                    }
                                                                    sQLiteDatabase.close();
                                                                    i7++;
                                                                    str7 = str3;
                                                                    i5 = i2;
                                                                    str6 = str;
                                                                    str8 = str2;
                                                                    r6 = 0;
                                                                }
                                                            } catch (Throwable th3) {
                                                                th = th3;
                                                                throw th;
                                                            }
                                                        } catch (SafeParcelReader.ParseException unused2) {
                                                            this.zzu.zzaW().zze().zza("Failed to load event from local database");
                                                            str = str9;
                                                            i4 = 2;
                                                            i3 = 3;
                                                            i10 = i3;
                                                            str7 = str3;
                                                            str6 = str;
                                                            str8 = str2;
                                                            i5 = 0;
                                                            i9 = 1;
                                                            i11 = i4;
                                                            zzioVar3 = zzioVar;
                                                        }
                                                    } catch (SafeParcelReader.ParseException unused3) {
                                                        str2 = str8;
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                    }
                                                } catch (SQLiteDatabaseLockedException unused4) {
                                                    str2 = str8;
                                                } catch (SQLiteFullException e3) {
                                                    e = e3;
                                                    str2 = str8;
                                                } catch (SQLiteException e4) {
                                                    e = e4;
                                                    str2 = str8;
                                                }
                                            } else {
                                                zzioVar = zzioVar3;
                                                str2 = str8;
                                                if (i12 == 1) {
                                                    obtain = Parcel.obtain();
                                                    try {
                                                        try {
                                                            obtain.unmarshall(blob, 0, blob.length);
                                                            obtain.setDataPosition(0);
                                                            zzqbVar = zzqb.CREATOR.createFromParcel(obtain);
                                                        } finally {
                                                        }
                                                    } catch (SafeParcelReader.ParseException unused5) {
                                                        this.zzu.zzaW().zze().zza("Failed to load user property from local database");
                                                        obtain.recycle();
                                                        zzqbVar = null;
                                                    }
                                                    if (zzqbVar != null) {
                                                        arrayList.add(new zzgu(zzqbVar, str5, j4));
                                                    }
                                                } else {
                                                    i4 = 2;
                                                    if (i12 == 2) {
                                                        obtain = Parcel.obtain();
                                                        try {
                                                            str = str9;
                                                            try {
                                                                try {
                                                                    obtain.unmarshall(blob, 0, blob.length);
                                                                    obtain.setDataPosition(0);
                                                                    zzaiVar = zzai.CREATOR.createFromParcel(obtain);
                                                                } catch (SafeParcelReader.ParseException unused6) {
                                                                    this.zzu.zzaW().zze().zza("Failed to load conditional user property from local database");
                                                                    obtain.recycle();
                                                                    zzaiVar = null;
                                                                    if (zzaiVar != null) {
                                                                    }
                                                                    i3 = 3;
                                                                    i10 = i3;
                                                                    str7 = str3;
                                                                    str6 = str;
                                                                    str8 = str2;
                                                                    i5 = 0;
                                                                    i9 = 1;
                                                                    i11 = i4;
                                                                    zzioVar3 = zzioVar;
                                                                }
                                                            } catch (Throwable th5) {
                                                                th = th5;
                                                                throw th;
                                                            }
                                                        } catch (SafeParcelReader.ParseException unused7) {
                                                            str = str9;
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                        }
                                                        try {
                                                            if (zzaiVar != null) {
                                                                arrayList.add(new zzgu(zzaiVar, str5, j4));
                                                            }
                                                        } catch (SQLiteDatabaseLockedException unused8) {
                                                            i2 = 0;
                                                            SystemClock.sleep(i6);
                                                            i6 += 20;
                                                            if (cursor2 != null) {
                                                            }
                                                            if (sQLiteDatabase == null) {
                                                            }
                                                            sQLiteDatabase.close();
                                                            i7++;
                                                            str7 = str3;
                                                            i5 = i2;
                                                            str6 = str;
                                                            str8 = str2;
                                                            r6 = 0;
                                                        } catch (SQLiteFullException e5) {
                                                            e = e5;
                                                            i2 = 0;
                                                            this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                                            this.zzc = true;
                                                            if (cursor2 != null) {
                                                            }
                                                            if (sQLiteDatabase == null) {
                                                            }
                                                            sQLiteDatabase.close();
                                                            i7++;
                                                            str7 = str3;
                                                            i5 = i2;
                                                            str6 = str;
                                                            str8 = str2;
                                                            r6 = 0;
                                                        } catch (SQLiteException e6) {
                                                            e = e6;
                                                            i2 = 0;
                                                            if (sQLiteDatabase != null) {
                                                            }
                                                            this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                                            this.zzc = true;
                                                            if (cursor2 != null) {
                                                            }
                                                            if (sQLiteDatabase == null) {
                                                            }
                                                            sQLiteDatabase.close();
                                                            i7++;
                                                            str7 = str3;
                                                            i5 = i2;
                                                            str6 = str;
                                                            str8 = str2;
                                                            r6 = 0;
                                                        }
                                                    } else {
                                                        str = str9;
                                                        if (i12 == 4) {
                                                            obtain = Parcel.obtain();
                                                            try {
                                                                try {
                                                                    obtain.unmarshall(blob, 0, blob.length);
                                                                    obtain.setDataPosition(0);
                                                                    zzbfVar = zzbf.CREATOR.createFromParcel(obtain);
                                                                } catch (SafeParcelReader.ParseException unused9) {
                                                                    this.zzu.zzaW().zze().zza("Failed to load default event parameters from local database");
                                                                    obtain.recycle();
                                                                    zzbfVar = null;
                                                                }
                                                                if (zzbfVar != null) {
                                                                    arrayList.add(new zzgu(zzbfVar, str5, j4));
                                                                }
                                                            } finally {
                                                            }
                                                        } else {
                                                            i3 = 3;
                                                            if (i12 == 3) {
                                                                this.zzu.zzaW().zzk().zza("Skipping app launch break");
                                                            } else {
                                                                this.zzu.zzaW().zze().zza("Unknown record type in local database");
                                                            }
                                                            i10 = i3;
                                                            str7 = str3;
                                                            str6 = str;
                                                            str8 = str2;
                                                            i5 = 0;
                                                            i9 = 1;
                                                            i11 = i4;
                                                            zzioVar3 = zzioVar;
                                                        }
                                                    }
                                                    i3 = 3;
                                                    i10 = i3;
                                                    str7 = str3;
                                                    str6 = str;
                                                    str8 = str2;
                                                    i5 = 0;
                                                    i9 = 1;
                                                    i11 = i4;
                                                    zzioVar3 = zzioVar;
                                                }
                                            }
                                            str = str9;
                                            i4 = 2;
                                            i3 = 3;
                                            i10 = i3;
                                            str7 = str3;
                                            str6 = str;
                                            str8 = str2;
                                            i5 = 0;
                                            i9 = 1;
                                            i11 = i4;
                                            zzioVar3 = zzioVar;
                                        } catch (SQLiteDatabaseLockedException unused10) {
                                            str = str6;
                                            str3 = str7;
                                            str2 = str8;
                                        } catch (SQLiteFullException e7) {
                                            e = e7;
                                            str = str6;
                                            str3 = str7;
                                            str2 = str8;
                                        } catch (SQLiteException e8) {
                                            e = e8;
                                            str = str6;
                                            str3 = str7;
                                            str2 = str8;
                                        }
                                    } catch (SQLiteDatabaseLockedException unused11) {
                                        str = str6;
                                        str2 = str8;
                                        i2 = i5;
                                        str3 = str7;
                                    } catch (SQLiteFullException e9) {
                                        e = e9;
                                        str = str6;
                                        str2 = str8;
                                        i2 = i5;
                                        str3 = str7;
                                    } catch (SQLiteException e10) {
                                        e = e10;
                                        str = str6;
                                        str2 = str8;
                                        i2 = i5;
                                        str3 = str7;
                                    }
                                }
                                str = str6;
                                str3 = str7;
                                str2 = str8;
                                String[] strArr6 = new String[1];
                                i2 = 0;
                                try {
                                    strArr6[0] = Long.toString(j3);
                                    if (sQLiteDatabase.delete("messages", "rowid <= ?", strArr6) < arrayList.size()) {
                                        this.zzu.zzaW().zze().zza("Fewer entries removed from local database than expected");
                                    }
                                    sQLiteDatabase.setTransactionSuccessful();
                                    sQLiteDatabase.endTransaction();
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    sQLiteDatabase.close();
                                    return arrayList;
                                } catch (SQLiteDatabaseLockedException unused12) {
                                    SystemClock.sleep(i6);
                                    i6 += 20;
                                    if (cursor2 != null) {
                                    }
                                    if (sQLiteDatabase == null) {
                                    }
                                    sQLiteDatabase.close();
                                    i7++;
                                    str7 = str3;
                                    i5 = i2;
                                    str6 = str;
                                    str8 = str2;
                                    r6 = 0;
                                } catch (SQLiteFullException e11) {
                                    e = e11;
                                    this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                    this.zzc = true;
                                    if (cursor2 != null) {
                                    }
                                    if (sQLiteDatabase == null) {
                                    }
                                    sQLiteDatabase.close();
                                    i7++;
                                    str7 = str3;
                                    i5 = i2;
                                    str6 = str;
                                    str8 = str2;
                                    r6 = 0;
                                } catch (SQLiteException e12) {
                                    e = e12;
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                    this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                    this.zzc = true;
                                    if (cursor2 != null) {
                                    }
                                    if (sQLiteDatabase == null) {
                                    }
                                    sQLiteDatabase.close();
                                    i7++;
                                    str7 = str3;
                                    i5 = i2;
                                    str6 = str;
                                    str8 = str2;
                                    r6 = 0;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                str = str6;
                                str2 = str8;
                                i2 = i5;
                                str3 = str7;
                                if (cursor3 != null) {
                                    try {
                                        cursor3.close();
                                    } catch (SQLiteDatabaseLockedException unused13) {
                                        cursor2 = null;
                                        SystemClock.sleep(i6);
                                        i6 += 20;
                                        if (cursor2 != null) {
                                        }
                                        if (sQLiteDatabase == null) {
                                        }
                                        sQLiteDatabase.close();
                                        i7++;
                                        str7 = str3;
                                        i5 = i2;
                                        str6 = str;
                                        str8 = str2;
                                        r6 = 0;
                                    } catch (SQLiteFullException e13) {
                                        e = e13;
                                        cursor2 = null;
                                        this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                        this.zzc = true;
                                        if (cursor2 != null) {
                                        }
                                        if (sQLiteDatabase == null) {
                                        }
                                        sQLiteDatabase.close();
                                        i7++;
                                        str7 = str3;
                                        i5 = i2;
                                        str6 = str;
                                        str8 = str2;
                                        r6 = 0;
                                    } catch (SQLiteException e14) {
                                        e = e14;
                                        cursor2 = null;
                                        if (sQLiteDatabase != null) {
                                        }
                                        this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                        this.zzc = true;
                                        if (cursor2 != null) {
                                        }
                                        if (sQLiteDatabase == null) {
                                        }
                                        sQLiteDatabase.close();
                                        i7++;
                                        str7 = str3;
                                        i5 = i2;
                                        str6 = str;
                                        str8 = str2;
                                        r6 = 0;
                                    }
                                }
                                throw th;
                                break;
                            }
                        } catch (SQLiteDatabaseLockedException unused14) {
                            str = str6;
                            str2 = str8;
                            i2 = i5;
                            str3 = str7;
                        } catch (SQLiteFullException e15) {
                            e = e15;
                            str = str6;
                            str2 = str8;
                            i2 = i5;
                            str3 = str7;
                        } catch (SQLiteException e16) {
                            e = e16;
                            str = str6;
                            str2 = str8;
                            i2 = i5;
                            str3 = str7;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (SQLiteDatabaseLockedException unused15) {
                    str = str6;
                    str2 = str8;
                    i2 = i5;
                    str3 = str7;
                    sQLiteDatabase = null;
                } catch (SQLiteFullException e17) {
                    e = e17;
                    str = str6;
                    str2 = str8;
                    i2 = i5;
                    str3 = str7;
                    sQLiteDatabase = null;
                } catch (SQLiteException e18) {
                    e = e18;
                    str = str6;
                    str2 = str8;
                    i2 = i5;
                    str3 = str7;
                    sQLiteDatabase = null;
                } catch (Throwable th9) {
                    th = th9;
                    cursor = null;
                    sQLiteDatabase = null;
                }
            }
            this.zzu.zzaW().zzk().zza("Failed to read events from database in reasonable time");
            return null;
        }
        return arrayList;
    }

    public final void zzj() {
        int delete;
        zzg();
        try {
            SQLiteDatabase zzh = zzh();
            if (zzh == null || (delete = zzh.delete("messages", null, null)) <= 0) {
                return;
            }
            this.zzu.zzaW().zzj().zzb("Reset local analytics data. records", Integer.valueOf(delete));
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzb("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzk() {
        return zzs(3, new byte[0]);
    }

    final boolean zzl() {
        zzio zzioVar = this.zzu;
        Context zzaT = zzioVar.zzaT();
        zzioVar.zzf();
        return zzaT.getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final boolean zzm() {
        zzg();
        if (!this.zzc && zzl()) {
            int i = 5;
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    this.zzu.zzaW().zzk().zza("Error deleting app launch break from local database in reasonable time");
                    break;
                }
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        try {
                            SQLiteDatabase zzh = zzh();
                            if (zzh != null) {
                                zzh.beginTransaction();
                                zzh.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                                zzh.setTransactionSuccessful();
                                zzh.endTransaction();
                                zzh.close();
                                return true;
                            }
                            this.zzc = true;
                        } catch (SQLiteDatabaseLockedException unused) {
                            SystemClock.sleep(i);
                            i += 20;
                            if (0 == 0) {
                            }
                            sQLiteDatabase.close();
                        }
                    } catch (SQLiteException e) {
                        if (0 != 0) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Throwable th) {
                                if (0 != 0) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        }
                        this.zzu.zzaW().zze().zzb("Error deleting app launch break from local database", e);
                        this.zzc = true;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                    }
                } catch (SQLiteFullException e2) {
                    this.zzu.zzaW().zze().zzb("Error deleting app launch break from local database", e2);
                    this.zzc = true;
                    if (0 == 0) {
                    }
                    sQLiteDatabase.close();
                }
                i2++;
            }
        }
        return false;
    }

    public final boolean zzn(zzai zzaiVar) {
        zzio zzioVar = this.zzu;
        byte[] zzay = zzioVar.zzw().zzay(zzaiVar);
        if (zzay.length > 131072) {
            zzioVar.zzaW().zzh().zza("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return zzs(2, zzay);
    }

    public final boolean zzo(zzbf zzbfVar) {
        zzio zzioVar = this.zzu;
        byte[] zzay = zzioVar.zzw().zzay(zzbfVar);
        if (zzay == null) {
            zzioVar.zzaW().zzh().zza("Null default event parameters; not writing to database");
            return false;
        } else if (zzay.length > 131072) {
            zzioVar.zzaW().zzh().zza("Default event parameters too long for local database. Sending directly to service");
            return false;
        } else {
            return zzs(4, zzay);
        }
    }

    public final boolean zzp(zzbh zzbhVar) {
        Parcel obtain = Parcel.obtain();
        zzbi.zza(zzbhVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.zzu.zzaW().zzh().zza("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return zzs(0, marshall);
    }

    public final boolean zzq(zzqb zzqbVar) {
        Parcel obtain = Parcel.obtain();
        zzqc.zza(zzqbVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.zzu.zzaW().zzh().zza("User property too long for local database. Sending directly to service");
            return false;
        }
        return zzs(1, marshall);
    }
}
