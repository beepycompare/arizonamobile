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
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzgk extends zzg {
    private static final String[] zza = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};
    private final zzgi zzb;
    private boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgk(zzib zzibVar) {
        super(zzibVar);
        Context zzaY = this.zzu.zzaY();
        this.zzu.zzc();
        this.zzb = new zzgi(this, zzaY, "google_app_measurement_local.db");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            zzib zzibVar = this.zzu;
            zzal zzc = zzibVar.zzc();
            zzfw zzfwVar = zzfx.zzbc;
            Cursor cursor2 = null;
            zzr zzh = zzc.zzp(null, zzfwVar) ? this.zzu.zzv().zzh(null) : null;
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", Integer.valueOf(i));
            contentValues.put("entry", bArr);
            if (zzibVar.zzc().zzp(null, zzfwVar) && zzh != null) {
                contentValues.put("app_version", zzh.zzc);
                contentValues.put("app_version_int", Long.valueOf(zzh.zzj));
            }
            zzibVar.zzc();
            int i2 = 0;
            int i3 = 5;
            for (int i4 = 5; i2 < i4; i4 = 5) {
                try {
                    sQLiteDatabase = zzp();
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
                                    this.zzu.zzaV().zzb().zzb("Error writing entry; local database full", e);
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
                                    this.zzu.zzaV().zzb().zzb("Error writing entry to local database", e);
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
                                zzibVar.zzaV().zzb().zza("Data loss, local db full");
                                String[] strArr = new String[1];
                                long j2 = 100001 - j;
                                strArr[z2 ? 1 : 0] = Long.toString(j2);
                                long delete = sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                                if (delete != j2) {
                                    zzgr zzb = zzibVar.zzaV().zzb();
                                    z = z2 ? 1 : 0;
                                    try {
                                        zzb.zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(delete), Long.valueOf(j2 - delete));
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
                                        this.zzu.zzaV().zzb().zzb("Error writing entry; local database full", e);
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
                                        this.zzu.zzaV().zzb().zzb("Error writing entry to local database", e);
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
            this.zzu.zzaV().zzk().zza("Failed to write entry to local database");
            return z3;
        }
        return z2;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final void zzh() {
        int delete;
        zzg();
        try {
            SQLiteDatabase zzp = zzp();
            if (zzp == null || (delete = zzp.delete("messages", null, null)) <= 0) {
                return;
            }
            this.zzu.zzaV().zzk().zzb("Reset local analytics data. records", Integer.valueOf(delete));
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzb("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzi(zzbg zzbgVar) {
        Parcel obtain = Parcel.obtain();
        zzbh.zza(zzbgVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.zzu.zzaV().zzc().zza("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return zzs(0, marshall);
    }

    public final boolean zzj(zzpk zzpkVar) {
        Parcel obtain = Parcel.obtain();
        zzpl.zza(zzpkVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.zzu.zzaV().zzc().zza("User property too long for local database. Sending directly to service");
            return false;
        }
        return zzs(1, marshall);
    }

    public final boolean zzk(zzah zzahVar) {
        zzib zzibVar = this.zzu;
        byte[] zzae = zzibVar.zzk().zzae(zzahVar);
        if (zzae.length > 131072) {
            zzibVar.zzaV().zzc().zza("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return zzs(2, zzae);
    }

    public final boolean zzl(zzbe zzbeVar) {
        zzib zzibVar = this.zzu;
        byte[] zzae = zzibVar.zzk().zzae(zzbeVar);
        if (zzae == null) {
            zzibVar.zzaV().zzc().zza("Null default event parameters; not writing to database");
            return false;
        } else if (zzae.length > 131072) {
            zzibVar.zzaV().zzc().zza("Default event parameters too long for local database. Sending directly to service");
            return false;
        } else {
            return zzs(4, zzae);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x022c A[Catch: SQLiteException -> 0x0307, SQLiteDatabaseLockedException -> 0x030c, SQLiteFullException -> 0x0310, all -> 0x041d, TryCatch #56 {all -> 0x041d, blocks: (B:49:0x0118, B:51:0x011e, B:53:0x012f, B:55:0x0135, B:60:0x014d, B:65:0x0165, B:67:0x016a, B:224:0x040d, B:213:0x03df, B:215:0x03e5, B:216:0x03e8, B:235:0x042c, B:78:0x0193, B:79:0x0196, B:75:0x018a, B:90:0x01b2, B:92:0x01c6, B:99:0x01e1, B:100:0x01ea, B:101:0x01ed, B:97:0x01db, B:108:0x01f5, B:112:0x020b, B:122:0x022c, B:123:0x0236, B:124:0x0239, B:120:0x0226, B:127:0x023f, B:129:0x0253, B:136:0x026e, B:137:0x0278, B:138:0x027b, B:134:0x0268, B:141:0x027f, B:142:0x028f, B:149:0x02c4, B:151:0x02d7, B:153:0x02e3, B:154:0x02f2), top: B:259:0x0118 }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03df A[Catch: all -> 0x041d, TRY_ENTER, TryCatch #56 {all -> 0x041d, blocks: (B:49:0x0118, B:51:0x011e, B:53:0x012f, B:55:0x0135, B:60:0x014d, B:65:0x0165, B:67:0x016a, B:224:0x040d, B:213:0x03df, B:215:0x03e5, B:216:0x03e8, B:235:0x042c, B:78:0x0193, B:79:0x0196, B:75:0x018a, B:90:0x01b2, B:92:0x01c6, B:99:0x01e1, B:100:0x01ea, B:101:0x01ed, B:97:0x01db, B:108:0x01f5, B:112:0x020b, B:122:0x022c, B:123:0x0236, B:124:0x0239, B:120:0x0226, B:127:0x023f, B:129:0x0253, B:136:0x026e, B:137:0x0278, B:138:0x027b, B:134:0x0268, B:141:0x027f, B:142:0x028f, B:149:0x02c4, B:151:0x02d7, B:153:0x02e3, B:154:0x02f2), top: B:259:0x0118 }] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x039b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0444 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0444 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0444 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzm(int i) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        String str;
        String str2;
        String str3;
        int i2;
        int i3;
        Cursor cursor2;
        Cursor cursor3;
        long j;
        long j2;
        String str4;
        String[] strArr;
        String[] strArr2;
        zzib zzibVar;
        int i4;
        zzfw zzfwVar;
        int i5;
        long j3;
        String str5;
        Parcel obtain;
        zzfw zzfwVar2;
        int i6;
        int i7;
        zzbe zzbeVar;
        zzah zzahVar;
        zzpk zzpkVar;
        String str6 = "entry";
        String str7 = "type";
        String str8 = "rowid";
        zzg();
        ?? r6 = 0;
        if (this.zzc) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (zzq()) {
            int i8 = 5;
            int i9 = 0;
            int i10 = 5;
            int i11 = 0;
            while (i11 < i8) {
                int i12 = 1;
                try {
                    sQLiteDatabase = zzp();
                    if (sQLiteDatabase == null) {
                        this.zzc = true;
                        return r6;
                    }
                    try {
                        try {
                            sQLiteDatabase.beginTransaction();
                            try {
                                String[] strArr3 = new String[1];
                                strArr3[i9] = str8;
                                try {
                                    String[] strArr4 = new String[1];
                                    strArr4[i9] = ExifInterface.GPS_MEASUREMENT_3D;
                                    cursor3 = sQLiteDatabase.query("messages", strArr3, "type=?", strArr4, null, null, "rowid desc", "1");
                                    try {
                                        j = -1;
                                        if (cursor3.moveToFirst()) {
                                            j2 = cursor3.getLong(i9);
                                            if (cursor3 != null) {
                                                try {
                                                    cursor3.close();
                                                } catch (SQLiteDatabaseLockedException unused) {
                                                    str = str6;
                                                    str2 = str7;
                                                    str3 = str8;
                                                    i3 = i9;
                                                    i2 = 5;
                                                    cursor2 = null;
                                                    SystemClock.sleep(i10);
                                                    i10 += 20;
                                                    if (cursor2 != null) {
                                                    }
                                                    if (sQLiteDatabase == null) {
                                                    }
                                                    sQLiteDatabase.close();
                                                    i11++;
                                                    i9 = i3;
                                                    str6 = str;
                                                    str7 = str2;
                                                    str8 = str3;
                                                    i8 = i2;
                                                    r6 = 0;
                                                } catch (SQLiteFullException e) {
                                                    e = e;
                                                    str = str6;
                                                    str2 = str7;
                                                    str3 = str8;
                                                    i3 = i9;
                                                    i2 = 5;
                                                    cursor2 = null;
                                                    this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                                    this.zzc = true;
                                                    if (cursor2 != null) {
                                                    }
                                                    if (sQLiteDatabase == null) {
                                                    }
                                                    sQLiteDatabase.close();
                                                    i11++;
                                                    i9 = i3;
                                                    str6 = str;
                                                    str7 = str2;
                                                    str8 = str3;
                                                    i8 = i2;
                                                    r6 = 0;
                                                } catch (SQLiteException e2) {
                                                    e = e2;
                                                    str = str6;
                                                    str2 = str7;
                                                    str3 = str8;
                                                    i3 = i9;
                                                    i2 = 5;
                                                    cursor2 = null;
                                                    if (sQLiteDatabase != null) {
                                                    }
                                                    this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                                    this.zzc = true;
                                                    if (cursor2 != null) {
                                                    }
                                                    if (sQLiteDatabase == null) {
                                                    }
                                                    sQLiteDatabase.close();
                                                    i11++;
                                                    i9 = i3;
                                                    str6 = str;
                                                    str7 = str2;
                                                    str8 = str3;
                                                    i8 = i2;
                                                    r6 = 0;
                                                }
                                            }
                                        } else {
                                            if (cursor3 != null) {
                                                cursor3.close();
                                            }
                                            j2 = -1;
                                        }
                                        if (j2 != -1) {
                                            String[] strArr5 = new String[1];
                                            strArr5[i9] = String.valueOf(j2);
                                            str4 = "rowid<?";
                                            strArr = strArr5;
                                        } else {
                                            str4 = r6;
                                            strArr = str4;
                                        }
                                        strArr2 = new String[3];
                                        strArr2[i9] = str8;
                                        strArr2[1] = str7;
                                        strArr2[2] = str6;
                                        zzibVar = this.zzu;
                                        zzal zzc = zzibVar.zzc();
                                        i4 = 3;
                                        zzfwVar = zzfx.zzbc;
                                        if (zzc.zzp(r6, zzfwVar)) {
                                            try {
                                                strArr2 = new String[5];
                                                strArr2[i9] = str8;
                                                strArr2[1] = str7;
                                                strArr2[2] = str6;
                                                strArr2[3] = "app_version";
                                                strArr2[4] = "app_version_int";
                                                i5 = 5;
                                            } catch (SQLiteDatabaseLockedException unused2) {
                                                str = str6;
                                                str2 = str7;
                                                str3 = str8;
                                                i3 = i9;
                                                i2 = 5;
                                                cursor2 = null;
                                                SystemClock.sleep(i10);
                                                i10 += 20;
                                                if (cursor2 != null) {
                                                }
                                                if (sQLiteDatabase == null) {
                                                }
                                                sQLiteDatabase.close();
                                                i11++;
                                                i9 = i3;
                                                str6 = str;
                                                str7 = str2;
                                                str8 = str3;
                                                i8 = i2;
                                                r6 = 0;
                                            } catch (SQLiteFullException e3) {
                                                e = e3;
                                                str = str6;
                                                str2 = str7;
                                                str3 = str8;
                                                i3 = i9;
                                                i2 = 5;
                                                cursor2 = null;
                                                this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                                this.zzc = true;
                                                if (cursor2 != null) {
                                                }
                                                if (sQLiteDatabase == null) {
                                                }
                                                sQLiteDatabase.close();
                                                i11++;
                                                i9 = i3;
                                                str6 = str;
                                                str7 = str2;
                                                str8 = str3;
                                                i8 = i2;
                                                r6 = 0;
                                            } catch (SQLiteException e4) {
                                                e = e4;
                                                str = str6;
                                                str2 = str7;
                                                str3 = str8;
                                                i3 = i9;
                                                i2 = 5;
                                                cursor2 = null;
                                                if (sQLiteDatabase != null) {
                                                    sQLiteDatabase.endTransaction();
                                                }
                                                this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                                this.zzc = true;
                                                if (cursor2 != null) {
                                                }
                                                if (sQLiteDatabase == null) {
                                                }
                                                sQLiteDatabase.close();
                                                i11++;
                                                i9 = i3;
                                                str6 = str;
                                                str7 = str2;
                                                str8 = str3;
                                                i8 = i2;
                                                r6 = 0;
                                            }
                                        } else {
                                            i5 = 5;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        str = str6;
                                        str2 = str7;
                                        str3 = str8;
                                        i3 = i9;
                                        i2 = 5;
                                        if (cursor3 != null) {
                                            try {
                                                cursor3.close();
                                            } catch (SQLiteDatabaseLockedException unused3) {
                                                cursor2 = null;
                                                SystemClock.sleep(i10);
                                                i10 += 20;
                                                if (cursor2 != null) {
                                                }
                                                if (sQLiteDatabase == null) {
                                                }
                                                sQLiteDatabase.close();
                                                i11++;
                                                i9 = i3;
                                                str6 = str;
                                                str7 = str2;
                                                str8 = str3;
                                                i8 = i2;
                                                r6 = 0;
                                            } catch (SQLiteFullException e5) {
                                                e = e5;
                                                cursor2 = null;
                                                this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                                this.zzc = true;
                                                if (cursor2 != null) {
                                                }
                                                if (sQLiteDatabase == null) {
                                                }
                                                sQLiteDatabase.close();
                                                i11++;
                                                i9 = i3;
                                                str6 = str;
                                                str7 = str2;
                                                str8 = str3;
                                                i8 = i2;
                                                r6 = 0;
                                            } catch (SQLiteException e6) {
                                                e = e6;
                                                cursor2 = null;
                                                if (sQLiteDatabase != null) {
                                                }
                                                this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                                this.zzc = true;
                                                if (cursor2 != null) {
                                                }
                                                if (sQLiteDatabase == null) {
                                                }
                                                sQLiteDatabase.close();
                                                i11++;
                                                i9 = i3;
                                                str6 = str;
                                                str7 = str2;
                                                str8 = str3;
                                                i8 = i2;
                                                r6 = 0;
                                            }
                                        }
                                        throw th;
                                        break;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    str = str6;
                                    str2 = str7;
                                    str3 = str8;
                                    i3 = i9;
                                    i2 = 5;
                                    cursor3 = null;
                                    if (cursor3 != null) {
                                    }
                                    throw th;
                                    break;
                                    break;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                str = str6;
                                str2 = str7;
                                str3 = str8;
                                i2 = i8;
                                i3 = i9;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            cursor = null;
                        }
                    } catch (SQLiteDatabaseLockedException unused4) {
                        str = str6;
                        str2 = str7;
                        str3 = str8;
                        i2 = i8;
                    } catch (SQLiteFullException e7) {
                        e = e7;
                        str = str6;
                        str2 = str7;
                        str3 = str8;
                        i2 = i8;
                    } catch (SQLiteException e8) {
                        e = e8;
                        str = str6;
                        str2 = str7;
                        str3 = str8;
                        i2 = i8;
                    }
                    try {
                        i2 = i5;
                        int i13 = 2;
                        try {
                            cursor2 = sQLiteDatabase.query("messages", strArr2, str4, strArr, null, null, "rowid asc", Integer.toString(100));
                            while (cursor2.moveToNext()) {
                                try {
                                    try {
                                        try {
                                            try {
                                                j = cursor2.getLong(i9);
                                                int i14 = cursor2.getInt(i12);
                                                byte[] blob = cursor2.getBlob(i13);
                                                try {
                                                    if (zzibVar.zzc().zzp(null, zzfwVar)) {
                                                        str5 = cursor2.getString(i4);
                                                        j3 = cursor2.getLong(4);
                                                    } else {
                                                        j3 = 0;
                                                        str5 = null;
                                                    }
                                                    String str9 = str6;
                                                    long j4 = j3;
                                                    str2 = str7;
                                                    if (i14 == 0) {
                                                        try {
                                                            obtain = Parcel.obtain();
                                                            zzfwVar2 = zzfwVar;
                                                            try {
                                                                str3 = str8;
                                                                try {
                                                                    try {
                                                                        obtain.unmarshall(blob, 0, blob.length);
                                                                        obtain.setDataPosition(0);
                                                                        zzbg createFromParcel = zzbg.CREATOR.createFromParcel(obtain);
                                                                        try {
                                                                            if (createFromParcel != null) {
                                                                                arrayList.add(new zzgj(createFromParcel, str5, j4));
                                                                            }
                                                                        } catch (SQLiteDatabaseLockedException unused5) {
                                                                            str = str9;
                                                                            i3 = 0;
                                                                            SystemClock.sleep(i10);
                                                                            i10 += 20;
                                                                            if (cursor2 != null) {
                                                                                cursor2.close();
                                                                            }
                                                                            if (sQLiteDatabase == null) {
                                                                                i11++;
                                                                                i9 = i3;
                                                                                str6 = str;
                                                                                str7 = str2;
                                                                                str8 = str3;
                                                                                i8 = i2;
                                                                                r6 = 0;
                                                                            }
                                                                            sQLiteDatabase.close();
                                                                            i11++;
                                                                            i9 = i3;
                                                                            str6 = str;
                                                                            str7 = str2;
                                                                            str8 = str3;
                                                                            i8 = i2;
                                                                            r6 = 0;
                                                                        } catch (SQLiteFullException e9) {
                                                                            e = e9;
                                                                            str = str9;
                                                                            i3 = 0;
                                                                            this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                                                            this.zzc = true;
                                                                            if (cursor2 != null) {
                                                                                cursor2.close();
                                                                            }
                                                                            if (sQLiteDatabase == null) {
                                                                                i11++;
                                                                                i9 = i3;
                                                                                str6 = str;
                                                                                str7 = str2;
                                                                                str8 = str3;
                                                                                i8 = i2;
                                                                                r6 = 0;
                                                                            }
                                                                            sQLiteDatabase.close();
                                                                            i11++;
                                                                            i9 = i3;
                                                                            str6 = str;
                                                                            str7 = str2;
                                                                            str8 = str3;
                                                                            i8 = i2;
                                                                            r6 = 0;
                                                                        } catch (SQLiteException e10) {
                                                                            e = e10;
                                                                            str = str9;
                                                                            i3 = 0;
                                                                            if (sQLiteDatabase != null && sQLiteDatabase.inTransaction()) {
                                                                                sQLiteDatabase.endTransaction();
                                                                            }
                                                                            this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                                                            this.zzc = true;
                                                                            if (cursor2 != null) {
                                                                                cursor2.close();
                                                                            }
                                                                            if (sQLiteDatabase == null) {
                                                                                i11++;
                                                                                i9 = i3;
                                                                                str6 = str;
                                                                                str7 = str2;
                                                                                str8 = str3;
                                                                                i8 = i2;
                                                                                r6 = 0;
                                                                            }
                                                                            sQLiteDatabase.close();
                                                                            i11++;
                                                                            i9 = i3;
                                                                            str6 = str;
                                                                            str7 = str2;
                                                                            str8 = str3;
                                                                            i8 = i2;
                                                                            r6 = 0;
                                                                        }
                                                                    } catch (SafeParcelReader.ParseException unused6) {
                                                                        this.zzu.zzaV().zzb().zza("Failed to load event from local database");
                                                                        str = str9;
                                                                        i7 = 2;
                                                                        i6 = 3;
                                                                        i4 = i6;
                                                                        str6 = str;
                                                                        str7 = str2;
                                                                        str8 = str3;
                                                                        i9 = 0;
                                                                        i12 = 1;
                                                                        i13 = i7;
                                                                        zzfwVar = zzfwVar2;
                                                                    }
                                                                } catch (Throwable th5) {
                                                                    th = th5;
                                                                    throw th;
                                                                }
                                                            } catch (SafeParcelReader.ParseException unused7) {
                                                                str3 = str8;
                                                            } catch (Throwable th6) {
                                                                th = th6;
                                                            }
                                                        } catch (SQLiteDatabaseLockedException unused8) {
                                                            str3 = str8;
                                                        } catch (SQLiteFullException e11) {
                                                            e = e11;
                                                            str3 = str8;
                                                        } catch (SQLiteException e12) {
                                                            e = e12;
                                                            str3 = str8;
                                                        }
                                                    } else {
                                                        zzfwVar2 = zzfwVar;
                                                        str3 = str8;
                                                        if (i14 == 1) {
                                                            obtain = Parcel.obtain();
                                                            try {
                                                                try {
                                                                    obtain.unmarshall(blob, 0, blob.length);
                                                                    obtain.setDataPosition(0);
                                                                    zzpkVar = zzpk.CREATOR.createFromParcel(obtain);
                                                                } finally {
                                                                }
                                                            } catch (SafeParcelReader.ParseException unused9) {
                                                                this.zzu.zzaV().zzb().zza("Failed to load user property from local database");
                                                                obtain.recycle();
                                                                zzpkVar = null;
                                                            }
                                                            if (zzpkVar != null) {
                                                                arrayList.add(new zzgj(zzpkVar, str5, j4));
                                                            }
                                                        } else {
                                                            i7 = 2;
                                                            if (i14 == 2) {
                                                                obtain = Parcel.obtain();
                                                                try {
                                                                    str = str9;
                                                                    try {
                                                                        try {
                                                                            obtain.unmarshall(blob, 0, blob.length);
                                                                            obtain.setDataPosition(0);
                                                                            zzahVar = zzah.CREATOR.createFromParcel(obtain);
                                                                        } catch (SafeParcelReader.ParseException unused10) {
                                                                            this.zzu.zzaV().zzb().zza("Failed to load conditional user property from local database");
                                                                            obtain.recycle();
                                                                            zzahVar = null;
                                                                            if (zzahVar != null) {
                                                                            }
                                                                            i6 = 3;
                                                                            i4 = i6;
                                                                            str6 = str;
                                                                            str7 = str2;
                                                                            str8 = str3;
                                                                            i9 = 0;
                                                                            i12 = 1;
                                                                            i13 = i7;
                                                                            zzfwVar = zzfwVar2;
                                                                        }
                                                                    } catch (Throwable th7) {
                                                                        th = th7;
                                                                        throw th;
                                                                    }
                                                                } catch (SafeParcelReader.ParseException unused11) {
                                                                    str = str9;
                                                                } catch (Throwable th8) {
                                                                    th = th8;
                                                                }
                                                                try {
                                                                    if (zzahVar != null) {
                                                                        arrayList.add(new zzgj(zzahVar, str5, j4));
                                                                    }
                                                                } catch (SQLiteDatabaseLockedException unused12) {
                                                                    i3 = 0;
                                                                    SystemClock.sleep(i10);
                                                                    i10 += 20;
                                                                    if (cursor2 != null) {
                                                                    }
                                                                    if (sQLiteDatabase == null) {
                                                                    }
                                                                    sQLiteDatabase.close();
                                                                    i11++;
                                                                    i9 = i3;
                                                                    str6 = str;
                                                                    str7 = str2;
                                                                    str8 = str3;
                                                                    i8 = i2;
                                                                    r6 = 0;
                                                                } catch (SQLiteFullException e13) {
                                                                    e = e13;
                                                                    i3 = 0;
                                                                    this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                                                    this.zzc = true;
                                                                    if (cursor2 != null) {
                                                                    }
                                                                    if (sQLiteDatabase == null) {
                                                                    }
                                                                    sQLiteDatabase.close();
                                                                    i11++;
                                                                    i9 = i3;
                                                                    str6 = str;
                                                                    str7 = str2;
                                                                    str8 = str3;
                                                                    i8 = i2;
                                                                    r6 = 0;
                                                                } catch (SQLiteException e14) {
                                                                    e = e14;
                                                                    i3 = 0;
                                                                    if (sQLiteDatabase != null) {
                                                                    }
                                                                    this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                                                    this.zzc = true;
                                                                    if (cursor2 != null) {
                                                                    }
                                                                    if (sQLiteDatabase == null) {
                                                                    }
                                                                    sQLiteDatabase.close();
                                                                    i11++;
                                                                    i9 = i3;
                                                                    str6 = str;
                                                                    str7 = str2;
                                                                    str8 = str3;
                                                                    i8 = i2;
                                                                    r6 = 0;
                                                                }
                                                            } else {
                                                                str = str9;
                                                                if (i14 == 4) {
                                                                    obtain = Parcel.obtain();
                                                                    try {
                                                                        try {
                                                                            obtain.unmarshall(blob, 0, blob.length);
                                                                            obtain.setDataPosition(0);
                                                                            zzbeVar = zzbe.CREATOR.createFromParcel(obtain);
                                                                        } finally {
                                                                        }
                                                                    } catch (SafeParcelReader.ParseException unused13) {
                                                                        this.zzu.zzaV().zzb().zza("Failed to load default event parameters from local database");
                                                                        obtain.recycle();
                                                                        zzbeVar = null;
                                                                    }
                                                                    if (zzbeVar != null) {
                                                                        arrayList.add(new zzgj(zzbeVar, str5, j4));
                                                                    }
                                                                } else {
                                                                    i6 = 3;
                                                                    if (i14 == 3) {
                                                                        this.zzu.zzaV().zzk().zza("Skipping app launch break");
                                                                    } else {
                                                                        this.zzu.zzaV().zzb().zza("Unknown record type in local database");
                                                                    }
                                                                    i4 = i6;
                                                                    str6 = str;
                                                                    str7 = str2;
                                                                    str8 = str3;
                                                                    i9 = 0;
                                                                    i12 = 1;
                                                                    i13 = i7;
                                                                    zzfwVar = zzfwVar2;
                                                                }
                                                            }
                                                            i6 = 3;
                                                            i4 = i6;
                                                            str6 = str;
                                                            str7 = str2;
                                                            str8 = str3;
                                                            i9 = 0;
                                                            i12 = 1;
                                                            i13 = i7;
                                                            zzfwVar = zzfwVar2;
                                                        }
                                                    }
                                                    str = str9;
                                                    i7 = 2;
                                                    i6 = 3;
                                                    i4 = i6;
                                                    str6 = str;
                                                    str7 = str2;
                                                    str8 = str3;
                                                    i9 = 0;
                                                    i12 = 1;
                                                    i13 = i7;
                                                    zzfwVar = zzfwVar2;
                                                } catch (SQLiteDatabaseLockedException unused14) {
                                                    str = str6;
                                                    str2 = str7;
                                                    str3 = str8;
                                                }
                                            } catch (SQLiteFullException e15) {
                                                e = e15;
                                                str = str6;
                                                str2 = str7;
                                                str3 = str8;
                                            } catch (SQLiteException e16) {
                                                e = e16;
                                                str = str6;
                                                str2 = str7;
                                                str3 = str8;
                                            }
                                        } catch (SQLiteDatabaseLockedException unused15) {
                                            str = str6;
                                            str2 = str7;
                                            str3 = str8;
                                            i3 = i9;
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                        cursor = cursor2;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        throw th;
                                    }
                                } catch (SQLiteFullException e17) {
                                    e = e17;
                                    str = str6;
                                    str2 = str7;
                                    str3 = str8;
                                    i3 = i9;
                                } catch (SQLiteException e18) {
                                    e = e18;
                                    str = str6;
                                    str2 = str7;
                                    str3 = str8;
                                    i3 = i9;
                                }
                            }
                            str = str6;
                            str2 = str7;
                            str3 = str8;
                            String[] strArr6 = new String[1];
                            i3 = 0;
                            try {
                                strArr6[0] = Long.toString(j);
                                if (sQLiteDatabase.delete("messages", "rowid <= ?", strArr6) < arrayList.size()) {
                                    this.zzu.zzaV().zzb().zza("Fewer entries removed from local database than expected");
                                }
                                sQLiteDatabase.setTransactionSuccessful();
                                sQLiteDatabase.endTransaction();
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                sQLiteDatabase.close();
                                return arrayList;
                            } catch (SQLiteDatabaseLockedException unused16) {
                                SystemClock.sleep(i10);
                                i10 += 20;
                                if (cursor2 != null) {
                                }
                                if (sQLiteDatabase == null) {
                                }
                                sQLiteDatabase.close();
                                i11++;
                                i9 = i3;
                                str6 = str;
                                str7 = str2;
                                str8 = str3;
                                i8 = i2;
                                r6 = 0;
                            } catch (SQLiteFullException e19) {
                                e = e19;
                                this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                this.zzc = true;
                                if (cursor2 != null) {
                                }
                                if (sQLiteDatabase == null) {
                                }
                                sQLiteDatabase.close();
                                i11++;
                                i9 = i3;
                                str6 = str;
                                str7 = str2;
                                str8 = str3;
                                i8 = i2;
                                r6 = 0;
                            } catch (SQLiteException e20) {
                                e = e20;
                                if (sQLiteDatabase != null) {
                                }
                                this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                this.zzc = true;
                                if (cursor2 != null) {
                                }
                                if (sQLiteDatabase == null) {
                                }
                                sQLiteDatabase.close();
                                i11++;
                                i9 = i3;
                                str6 = str;
                                str7 = str2;
                                str8 = str3;
                                i8 = i2;
                                r6 = 0;
                            }
                        } catch (SQLiteDatabaseLockedException unused17) {
                            str = str6;
                            str2 = str7;
                            str3 = str8;
                            i3 = i9;
                            cursor2 = null;
                            SystemClock.sleep(i10);
                            i10 += 20;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase == null) {
                            }
                            sQLiteDatabase.close();
                            i11++;
                            i9 = i3;
                            str6 = str;
                            str7 = str2;
                            str8 = str3;
                            i8 = i2;
                            r6 = 0;
                        } catch (SQLiteFullException e21) {
                            e = e21;
                            str = str6;
                            str2 = str7;
                            str3 = str8;
                            i3 = i9;
                            cursor2 = null;
                            this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                            this.zzc = true;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase == null) {
                            }
                            sQLiteDatabase.close();
                            i11++;
                            i9 = i3;
                            str6 = str;
                            str7 = str2;
                            str8 = str3;
                            i8 = i2;
                            r6 = 0;
                        } catch (SQLiteException e22) {
                            e = e22;
                            str = str6;
                            str2 = str7;
                            str3 = str8;
                            i3 = i9;
                            cursor2 = null;
                            if (sQLiteDatabase != null) {
                            }
                            this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                            this.zzc = true;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase == null) {
                            }
                            sQLiteDatabase.close();
                            i11++;
                            i9 = i3;
                            str6 = str;
                            str7 = str2;
                            str8 = str3;
                            i8 = i2;
                            r6 = 0;
                        }
                    } catch (SQLiteDatabaseLockedException unused18) {
                        str = str6;
                        str3 = str8;
                        i3 = i9;
                        i2 = i5;
                        str2 = str7;
                        cursor2 = null;
                        SystemClock.sleep(i10);
                        i10 += 20;
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase == null) {
                        }
                        sQLiteDatabase.close();
                        i11++;
                        i9 = i3;
                        str6 = str;
                        str7 = str2;
                        str8 = str3;
                        i8 = i2;
                        r6 = 0;
                    } catch (SQLiteFullException e23) {
                        e = e23;
                        str = str6;
                        str3 = str8;
                        i3 = i9;
                        i2 = i5;
                        str2 = str7;
                        cursor2 = null;
                        this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                        this.zzc = true;
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase == null) {
                        }
                        sQLiteDatabase.close();
                        i11++;
                        i9 = i3;
                        str6 = str;
                        str7 = str2;
                        str8 = str3;
                        i8 = i2;
                        r6 = 0;
                    } catch (SQLiteException e24) {
                        e = e24;
                        str = str6;
                        str3 = str8;
                        i3 = i9;
                        i2 = i5;
                        str2 = str7;
                        cursor2 = null;
                        if (sQLiteDatabase != null) {
                        }
                        this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                        this.zzc = true;
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase == null) {
                        }
                        sQLiteDatabase.close();
                        i11++;
                        i9 = i3;
                        str6 = str;
                        str7 = str2;
                        str8 = str3;
                        i8 = i2;
                        r6 = 0;
                    }
                } catch (SQLiteDatabaseLockedException unused19) {
                    str = str6;
                    str2 = str7;
                    str3 = str8;
                    i2 = i8;
                    i3 = i9;
                    sQLiteDatabase = null;
                } catch (SQLiteFullException e25) {
                    e = e25;
                    str = str6;
                    str2 = str7;
                    str3 = str8;
                    i2 = i8;
                    i3 = i9;
                    sQLiteDatabase = null;
                } catch (SQLiteException e26) {
                    e = e26;
                    str = str6;
                    str2 = str7;
                    str3 = str8;
                    i2 = i8;
                    i3 = i9;
                    sQLiteDatabase = null;
                } catch (Throwable th10) {
                    th = th10;
                    cursor = null;
                    sQLiteDatabase = null;
                }
            }
            this.zzu.zzaV().zze().zza("Failed to read events from database in reasonable time");
            return null;
        }
        return arrayList;
    }

    public final boolean zzn() {
        return zzs(3, new byte[0]);
    }

    public final boolean zzo() {
        zzg();
        if (!this.zzc && zzq()) {
            int i = 5;
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    this.zzu.zzaV().zze().zza("Error deleting app launch break from local database in reasonable time");
                    break;
                }
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        try {
                            SQLiteDatabase zzp = zzp();
                            if (zzp != null) {
                                zzp.beginTransaction();
                                zzp.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                                zzp.setTransactionSuccessful();
                                zzp.endTransaction();
                                zzp.close();
                                return true;
                            }
                            this.zzc = true;
                        } catch (SQLiteFullException e) {
                            this.zzu.zzaV().zzb().zzb("Error deleting app launch break from local database", e);
                            this.zzc = true;
                            if (0 == 0) {
                            }
                            sQLiteDatabase.close();
                        }
                    } catch (SQLiteException e2) {
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
                        this.zzu.zzaV().zzb().zzb("Error deleting app launch break from local database", e2);
                        this.zzc = true;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(i);
                    i += 20;
                    if (0 == 0) {
                    }
                    sQLiteDatabase.close();
                }
                i2++;
            }
        }
        return false;
    }

    final SQLiteDatabase zzp() throws SQLiteException {
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

    final boolean zzq() {
        zzib zzibVar = this.zzu;
        Context zzaY = zzibVar.zzaY();
        zzibVar.zzc();
        return zzaY.getDatabasePath("google_app_measurement_local.db").exists();
    }
}
