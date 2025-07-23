package io.appmetrica.analytics.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import okhttp3.internal.connection.RealConnection;
/* renamed from: io.appmetrica.analytics.impl.d5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0199d5 extends DatabaseScript {

    /* renamed from: a  reason: collision with root package name */
    public final int f812a = 2000;
    public final String b = "number";
    public final String c = "global_number";
    public final String d = "number_of_type";
    public final String e = "name";
    public final String f = "value";
    public final String g = "type";
    public final String h = "time";
    public final String i = "session_id";
    public final String j = "error_environment";
    public final String k = "session_type";
    public final String l = "app_environment";
    public final String m = "app_environment_revision";
    public final String n = "truncated";
    public final String o = "custom_type";
    public final String p = "encrypting_mode";
    public final String q = "profile_id";
    public final String r = "first_occurrence_status";
    public final String s = "source";
    public final String t = "attribution_id_changed";
    public final String u = "open_id";
    public final String v = "extras";
    public final String w = "reports";
    public final B7 x = new B7(null, 1, null);

    public static boolean a(A7 a7) {
        Long l;
        EnumC0680wb enumC0680wb;
        Long l2;
        Long l3;
        Long l4 = a7.f333a;
        if (l4 == null || l4.longValue() < RealConnection.IDLE_CONNECTION_HEALTHY_NS || a7.b == null || (l = a7.c) == null || l.longValue() < 0 || (enumC0680wb = a7.d) == null || enumC0680wb == EnumC0680wb.EVENT_TYPE_UNDEFINED || (l2 = a7.e) == null || l2.longValue() < 0 || (l3 = a7.f) == null || l3.longValue() < 0) {
            return false;
        }
        Long l5 = a7.g.d;
        if (l5 == null || l5.longValue() >= 0) {
            Integer num = a7.g.i;
            return num == null || num.intValue() >= 0;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor;
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY,session_id INTEGER,session_type INTEGER,number_in_session INTEGER,type INTEGER,global_number INTEGER,time INTEGER,event_description BLOB )");
        Cursor cursor2 = null;
        try {
            sQLiteDatabase2 = sQLiteDatabase;
            try {
                cursor = sQLiteDatabase2.query(this.w, null, null, null, null, null, null, String.valueOf(this.f812a));
                while (cursor.moveToNext()) {
                    try {
                        A7 a2 = a(cursor);
                        if (a2 != null && a(a2)) {
                            try {
                                sQLiteDatabase2.insertOrThrow("events", null, this.x.fromModel(a2));
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable unused2) {
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor = cursor2;
                            cursor.close();
                        }
                        sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS " + this.w);
                    }
                }
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
            sQLiteDatabase2 = sQLiteDatabase;
        }
        cursor.close();
        sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS " + this.w);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00eb, code lost:
        if (r3.intValue() == 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0165, code lost:
        if (r2.intValue() == 1) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0179, code lost:
        if (r32.getInt(r32.getColumnIndexOrThrow(r31.t)) != 1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002a, code lost:
        if (r3.intValue() != 0) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e7 A[Catch: all -> 0x01b4, TryCatch #5 {all -> 0x01b4, blocks: (B:3:0x0004, B:9:0x002e, B:16:0x003b, B:22:0x00f0, B:28:0x00fc, B:35:0x010a, B:72:0x017d, B:76:0x018d, B:80:0x01a2, B:79:0x019c, B:31:0x0101, B:25:0x00f5, B:19:0x00e7, B:12:0x0033, B:6:0x0026, B:53:0x0142, B:59:0x015c, B:62:0x0161, B:56:0x0155, B:36:0x0114, B:42:0x012e, B:48:0x013a, B:45:0x0133, B:39:0x0127), top: B:87:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0126 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0127 A[Catch: all -> 0x013d, TryCatch #5 {all -> 0x01b4, blocks: (B:3:0x0004, B:9:0x002e, B:16:0x003b, B:22:0x00f0, B:28:0x00fc, B:35:0x010a, B:72:0x017d, B:76:0x018d, B:80:0x01a2, B:79:0x019c, B:31:0x0101, B:25:0x00f5, B:19:0x00e7, B:12:0x0033, B:6:0x0026, B:53:0x0142, B:59:0x015c, B:62:0x0161, B:56:0x0155, B:36:0x0114, B:42:0x012e, B:48:0x013a, B:45:0x0133, B:39:0x0127), top: B:87:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0132 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0133 A[Catch: all -> 0x013d, TryCatch #5 {all -> 0x01b4, blocks: (B:3:0x0004, B:9:0x002e, B:16:0x003b, B:22:0x00f0, B:28:0x00fc, B:35:0x010a, B:72:0x017d, B:76:0x018d, B:80:0x01a2, B:79:0x019c, B:31:0x0101, B:25:0x00f5, B:19:0x00e7, B:12:0x0033, B:6:0x0026, B:53:0x0142, B:59:0x015c, B:62:0x0161, B:56:0x0155, B:36:0x0114, B:42:0x012e, B:48:0x013a, B:45:0x0133, B:39:0x0127), top: B:87:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0154 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0155 A[Catch: all -> 0x016b, TryCatch #5 {all -> 0x01b4, blocks: (B:3:0x0004, B:9:0x002e, B:16:0x003b, B:22:0x00f0, B:28:0x00fc, B:35:0x010a, B:72:0x017d, B:76:0x018d, B:80:0x01a2, B:79:0x019c, B:31:0x0101, B:25:0x00f5, B:19:0x00e7, B:12:0x0033, B:6:0x0026, B:53:0x0142, B:59:0x015c, B:62:0x0161, B:56:0x0155, B:36:0x0114, B:42:0x012e, B:48:0x013a, B:45:0x0133, B:39:0x0127), top: B:87:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0161 A[Catch: all -> 0x016b, TRY_LEAVE, TryCatch #5 {all -> 0x01b4, blocks: (B:3:0x0004, B:9:0x002e, B:16:0x003b, B:22:0x00f0, B:28:0x00fc, B:35:0x010a, B:72:0x017d, B:76:0x018d, B:80:0x01a2, B:79:0x019c, B:31:0x0101, B:25:0x00f5, B:19:0x00e7, B:12:0x0033, B:6:0x0026, B:53:0x0142, B:59:0x015c, B:62:0x0161, B:56:0x0155, B:36:0x0114, B:42:0x012e, B:48:0x013a, B:45:0x0133, B:39:0x0127), top: B:87:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019c A[Catch: all -> 0x01b4, TryCatch #5 {all -> 0x01b4, blocks: (B:3:0x0004, B:9:0x002e, B:16:0x003b, B:22:0x00f0, B:28:0x00fc, B:35:0x010a, B:72:0x017d, B:76:0x018d, B:80:0x01a2, B:79:0x019c, B:31:0x0101, B:25:0x00f5, B:19:0x00e7, B:12:0x0033, B:6:0x0026, B:53:0x0142, B:59:0x015c, B:62:0x0161, B:56:0x0155, B:36:0x0114, B:42:0x012e, B:48:0x013a, B:45:0x0133, B:39:0x0127), top: B:87:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final A7 a(Cursor cursor) {
        Wk wk;
        Integer valueOf;
        EnumC0151b9 enumC0151b9;
        EnumC0151b9 enumC0151b92;
        Integer valueOf2;
        Integer valueOf3;
        H9 h9;
        H9 h92;
        int i;
        try {
            Long valueOf4 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.i)));
            Integer valueOf5 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.k)));
            Wk wk2 = Wk.FOREGROUND;
            boolean z = true;
            if (valueOf5 != null) {
            }
            wk2 = Wk.BACKGROUND;
            try {
                if (valueOf5 != null && valueOf5.intValue() == 1) {
                    wk = wk2;
                    Long valueOf6 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.b)));
                    EnumC0680wb a2 = EnumC0680wb.a(cursor.getInt(cursor.getColumnIndexOrThrow(this.g)));
                    Long valueOf7 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.c)));
                    Long valueOf8 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.h)));
                    Integer valueOf9 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.o)));
                    String string = cursor.getString(cursor.getColumnIndexOrThrow(this.e));
                    String string2 = cursor.getString(cursor.getColumnIndexOrThrow(this.f));
                    Long valueOf10 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.d)));
                    String string3 = cursor.getString(cursor.getColumnIndexOrThrow(this.j));
                    String string4 = cursor.getString(cursor.getColumnIndexOrThrow(this.l));
                    Long valueOf11 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.m)));
                    Integer valueOf12 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.n)));
                    valueOf = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.p)));
                    enumC0151b9 = EnumC0151b9.NONE;
                    if (valueOf != null) {
                    }
                    enumC0151b9 = EnumC0151b9.AES_VALUE_ENCRYPTION;
                    if (valueOf != null && valueOf.intValue() == 2) {
                        enumC0151b92 = enumC0151b9;
                        String string5 = cursor.getString(cursor.getColumnIndexOrThrow(this.q));
                        valueOf2 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.r)));
                        EnumC0729ya enumC0729ya = EnumC0729ya.FIRST_OCCURRENCE;
                        if (valueOf2 != null && valueOf2.intValue() == 1) {
                            EnumC0729ya enumC0729ya2 = enumC0729ya;
                            valueOf3 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.s)));
                            h9 = H9.NATIVE;
                            if (valueOf3 != null && valueOf3.intValue() == 0) {
                                h92 = h9;
                            }
                            h9 = H9.JS;
                            if (valueOf3 != null) {
                            }
                            h92 = null;
                        }
                        enumC0729ya = EnumC0729ya.NON_FIRST_OCCURENCE;
                        if (valueOf2 != null && valueOf2.intValue() == 2) {
                            EnumC0729ya enumC0729ya22 = enumC0729ya;
                            valueOf3 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.s)));
                            h9 = H9.NATIVE;
                            if (valueOf3 != null) {
                                h92 = h9;
                            }
                            h9 = H9.JS;
                            if (valueOf3 != null) {
                            }
                            h92 = null;
                        }
                        enumC0729ya = EnumC0729ya.UNKNOWN;
                        EnumC0729ya enumC0729ya222 = enumC0729ya;
                        valueOf3 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.s)));
                        h9 = H9.NATIVE;
                        if (valueOf3 != null) {
                        }
                        h9 = H9.JS;
                        if (valueOf3 != null) {
                        }
                        h92 = null;
                    }
                    enumC0151b9 = EnumC0151b9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
                    if (valueOf != null && valueOf.intValue() == 1) {
                        enumC0151b92 = enumC0151b9;
                        String string52 = cursor.getString(cursor.getColumnIndexOrThrow(this.q));
                        valueOf2 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.r)));
                        EnumC0729ya enumC0729ya3 = EnumC0729ya.FIRST_OCCURRENCE;
                        if (valueOf2 != null) {
                            EnumC0729ya enumC0729ya2222 = enumC0729ya3;
                            valueOf3 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.s)));
                            h9 = H9.NATIVE;
                            if (valueOf3 != null) {
                            }
                            h9 = H9.JS;
                            if (valueOf3 != null) {
                            }
                            h92 = null;
                        }
                        enumC0729ya3 = EnumC0729ya.NON_FIRST_OCCURENCE;
                        if (valueOf2 != null) {
                            EnumC0729ya enumC0729ya22222 = enumC0729ya3;
                            valueOf3 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.s)));
                            h9 = H9.NATIVE;
                            if (valueOf3 != null) {
                            }
                            h9 = H9.JS;
                            if (valueOf3 != null) {
                            }
                            h92 = null;
                        }
                        enumC0729ya3 = EnumC0729ya.UNKNOWN;
                        EnumC0729ya enumC0729ya222222 = enumC0729ya3;
                        valueOf3 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.s)));
                        h9 = H9.NATIVE;
                        if (valueOf3 != null) {
                        }
                        h9 = H9.JS;
                        if (valueOf3 != null) {
                        }
                        h92 = null;
                    }
                    enumC0151b92 = null;
                    String string522 = cursor.getString(cursor.getColumnIndexOrThrow(this.q));
                    valueOf2 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.r)));
                    EnumC0729ya enumC0729ya32 = EnumC0729ya.FIRST_OCCURRENCE;
                    if (valueOf2 != null) {
                    }
                    enumC0729ya32 = EnumC0729ya.NON_FIRST_OCCURENCE;
                    if (valueOf2 != null) {
                    }
                    enumC0729ya32 = EnumC0729ya.UNKNOWN;
                    EnumC0729ya enumC0729ya2222222 = enumC0729ya32;
                    valueOf3 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.s)));
                    h9 = H9.NATIVE;
                    if (valueOf3 != null) {
                    }
                    h9 = H9.JS;
                    if (valueOf3 != null) {
                    }
                    h92 = null;
                }
                if (valueOf != null) {
                    enumC0151b92 = enumC0151b9;
                    String string5222 = cursor.getString(cursor.getColumnIndexOrThrow(this.q));
                    valueOf2 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.r)));
                    EnumC0729ya enumC0729ya322 = EnumC0729ya.FIRST_OCCURRENCE;
                    if (valueOf2 != null) {
                    }
                    enumC0729ya322 = EnumC0729ya.NON_FIRST_OCCURENCE;
                    if (valueOf2 != null) {
                    }
                    enumC0729ya322 = EnumC0729ya.UNKNOWN;
                    EnumC0729ya enumC0729ya22222222 = enumC0729ya322;
                    valueOf3 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.s)));
                    h9 = H9.NATIVE;
                    if (valueOf3 != null) {
                    }
                    h9 = H9.JS;
                    if (valueOf3 != null) {
                    }
                    h92 = null;
                }
                if (valueOf != null) {
                    enumC0151b92 = enumC0151b9;
                    String string52222 = cursor.getString(cursor.getColumnIndexOrThrow(this.q));
                    valueOf2 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.r)));
                    EnumC0729ya enumC0729ya3222 = EnumC0729ya.FIRST_OCCURRENCE;
                    if (valueOf2 != null) {
                    }
                    enumC0729ya3222 = EnumC0729ya.NON_FIRST_OCCURENCE;
                    if (valueOf2 != null) {
                    }
                    enumC0729ya3222 = EnumC0729ya.UNKNOWN;
                    EnumC0729ya enumC0729ya222222222 = enumC0729ya3222;
                    valueOf3 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.s)));
                    h9 = H9.NATIVE;
                    if (valueOf3 != null) {
                    }
                    h9 = H9.JS;
                    if (valueOf3 != null) {
                    }
                    h92 = null;
                }
            } catch (Throwable unused) {
            }
            wk = null;
            Long valueOf62 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.b)));
            EnumC0680wb a22 = EnumC0680wb.a(cursor.getInt(cursor.getColumnIndexOrThrow(this.g)));
            Long valueOf72 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.c)));
            Long valueOf82 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.h)));
            Integer valueOf92 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.o)));
            String string6 = cursor.getString(cursor.getColumnIndexOrThrow(this.e));
            String string22 = cursor.getString(cursor.getColumnIndexOrThrow(this.f));
            Long valueOf102 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.d)));
            String string32 = cursor.getString(cursor.getColumnIndexOrThrow(this.j));
            String string42 = cursor.getString(cursor.getColumnIndexOrThrow(this.l));
            Long valueOf112 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.m)));
            Integer valueOf122 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.n)));
            valueOf = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.p)));
            enumC0151b9 = EnumC0151b9.NONE;
            if (valueOf != null) {
            }
            enumC0151b9 = EnumC0151b9.AES_VALUE_ENCRYPTION;
            enumC0151b9 = EnumC0151b9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
            enumC0151b92 = null;
            String string522222 = cursor.getString(cursor.getColumnIndexOrThrow(this.q));
            valueOf2 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.r)));
            EnumC0729ya enumC0729ya32222 = EnumC0729ya.FIRST_OCCURRENCE;
            if (valueOf2 != null) {
            }
            enumC0729ya32222 = EnumC0729ya.NON_FIRST_OCCURENCE;
            if (valueOf2 != null) {
            }
            enumC0729ya32222 = EnumC0729ya.UNKNOWN;
            EnumC0729ya enumC0729ya2222222222 = enumC0729ya32222;
            valueOf3 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.s)));
            h9 = H9.NATIVE;
            if (valueOf3 != null) {
            }
            h9 = H9.JS;
            if (valueOf3 != null) {
            }
            h92 = null;
            z = false;
            Boolean valueOf13 = Boolean.valueOf(z);
            try {
                i = cursor.getInt(cursor.getColumnIndexOrThrow(this.u));
            } catch (Throwable unused2) {
                i = -1;
            }
            Integer valueOf14 = Integer.valueOf(i);
            int columnIndex = cursor.getColumnIndex(this.v);
            return new A7(valueOf4, wk, valueOf62, a22, valueOf72, valueOf82, new C0751z7(valueOf92, string6, string22, valueOf102, null, string32, string42, valueOf112, valueOf122, null, null, enumC0151b92, string522222, enumC0729ya2222222222, h92, valueOf13, valueOf14, columnIndex >= 0 ? null : cursor.getBlob(columnIndex)));
            Integer valueOf142 = Integer.valueOf(i);
            int columnIndex2 = cursor.getColumnIndex(this.v);
            return new A7(valueOf4, wk, valueOf62, a22, valueOf72, valueOf82, new C0751z7(valueOf92, string6, string22, valueOf102, null, string32, string42, valueOf112, valueOf122, null, null, enumC0151b92, string522222, enumC0729ya2222222222, h92, valueOf13, valueOf142, columnIndex2 >= 0 ? null : cursor.getBlob(columnIndex2)));
        } catch (Throwable unused3) {
            return null;
        }
    }
}
