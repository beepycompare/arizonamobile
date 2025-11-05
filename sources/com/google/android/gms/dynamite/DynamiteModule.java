package com.google.android.gms.dynamite;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import dalvik.system.DelegateLastClassLoader;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
/* loaded from: classes4.dex */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final int REMOTE = 1;
    private static Boolean zzc = null;
    private static String zzd = null;
    private static boolean zze = false;
    private static int zzf = -1;
    private static Boolean zzg;
    private static zzp zzl;
    private static zzq zzm;
    private final Context zzk;
    private static final ThreadLocal zzh = new ThreadLocal();
    private static final ThreadLocal zzi = new zze();
    private static final VersionPolicy.IVersions zzj = new zzf();
    public static final VersionPolicy PREFER_REMOTE = new zzg();
    public static final VersionPolicy PREFER_LOCAL = new zzh();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzk();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzl();
    public static final VersionPolicy zza = new zzm();
    public static final VersionPolicy zzb = new zzc();

    /* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
    /* loaded from: classes4.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
    /* loaded from: classes4.dex */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, Throwable th, byte[] bArr) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, byte[] bArr) {
            super(str);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
    /* loaded from: classes4.dex */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
        /* loaded from: classes4.dex */
        public interface IVersions {
            int zza(Context context, String str, boolean z) throws LoadingException;

            int zzb(Context context, String str);
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
        /* loaded from: classes4.dex */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzk = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!Objects.equal(declaredField.get(null), str)) {
                String valueOf = String.valueOf(declaredField.get(null));
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 50 + String.valueOf(str).length() + 1);
                sb2.append("Module descriptor id '");
                sb2.append(valueOf);
                sb2.append("' didn't match expected id '");
                sb2.append(str);
                sb2.append("'");
                Log.e("DynamiteModule", sb2.toString());
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            String message = e.getMessage();
            String.valueOf(message);
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(message)));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        DynamiteModule zze2;
        int i;
        Boolean bool;
        IObjectWrapper zze3;
        zzq zzqVar;
        Boolean valueOf;
        IObjectWrapper zze4;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            ThreadLocal threadLocal = zzh;
            zzn zznVar = (zzn) threadLocal.get();
            zzn zznVar2 = new zzn(null);
            threadLocal.set(zznVar2);
            ThreadLocal threadLocal2 = zzi;
            long longValue = ((Long) threadLocal2.get()).longValue();
            try {
                threadLocal2.set(Long.valueOf(SystemClock.uptimeMillis()));
                VersionPolicy.SelectionResult selectModule = versionPolicy.selectModule(context, str, zzj);
                int i2 = selectModule.localVersion;
                int i3 = selectModule.remoteVersion;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26 + String.valueOf(i2).length() + 19 + String.valueOf(str).length() + 1 + String.valueOf(i3).length());
                sb.append("Considering local module ");
                sb.append(str);
                sb.append(StringUtils.PROCESS_POSTFIX_DELIMITER);
                sb.append(i2);
                sb.append(" and remote module ");
                sb.append(str);
                sb.append(StringUtils.PROCESS_POSTFIX_DELIMITER);
                sb.append(i3);
                Log.i("DynamiteModule", sb.toString());
                int i4 = selectModule.selection;
                if (i4 != 0) {
                    if (i4 == -1) {
                        if (selectModule.localVersion != 0) {
                            i4 = -1;
                        }
                    }
                    if (i4 != 1 || selectModule.remoteVersion != 0) {
                        if (i4 == -1) {
                            DynamiteModule zze5 = zze(applicationContext, str);
                            if (longValue == 0) {
                                threadLocal2.remove();
                            } else {
                                threadLocal2.set(Long.valueOf(longValue));
                            }
                            Cursor cursor = zznVar2.zza;
                            if (cursor != null) {
                                cursor.close();
                            }
                            threadLocal.set(zznVar);
                            return zze5;
                        } else if (i4 != 1) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length() + 36);
                            sb2.append("VersionPolicy returned invalid code:");
                            sb2.append(i4);
                            throw new LoadingException(sb2.toString(), null);
                        } else {
                            try {
                                i = selectModule.remoteVersion;
                            } catch (LoadingException e) {
                                String message = e.getMessage();
                                StringBuilder sb3 = new StringBuilder(String.valueOf(message).length() + 30);
                                sb3.append("Failed to load remote module: ");
                                sb3.append(message);
                                Log.w("DynamiteModule", sb3.toString());
                                int i5 = selectModule.localVersion;
                                if (i5 == 0 || versionPolicy.selectModule(context, str, new zzo(i5, 0)).selection != -1) {
                                    throw new LoadingException("Remote load failed. No local fallback found.", e, null);
                                }
                                zze2 = zze(applicationContext, str);
                            }
                            try {
                                synchronized (DynamiteModule.class) {
                                    if (!zzb(context)) {
                                        throw new LoadingException("Remote loading disabled", null);
                                    }
                                    bool = zzc;
                                }
                                if (bool != null) {
                                    if (bool.booleanValue()) {
                                        StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(i).length());
                                        sb4.append("Selected remote version of ");
                                        sb4.append(str);
                                        sb4.append(", version >= ");
                                        sb4.append(i);
                                        Log.i("DynamiteModule", sb4.toString());
                                        synchronized (DynamiteModule.class) {
                                            zzqVar = zzm;
                                        }
                                        if (zzqVar == null) {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                        }
                                        zzn zznVar3 = (zzn) threadLocal.get();
                                        if (zznVar3 == null || zznVar3.zza == null) {
                                            throw new LoadingException("No result cursor", null);
                                        }
                                        Context applicationContext2 = context.getApplicationContext();
                                        Cursor cursor2 = zznVar3.zza;
                                        ObjectWrapper.wrap(null);
                                        synchronized (DynamiteModule.class) {
                                            valueOf = Boolean.valueOf(zzf >= 2);
                                        }
                                        if (valueOf.booleanValue()) {
                                            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                            zze4 = zzqVar.zzf(ObjectWrapper.wrap(applicationContext2), str, i, ObjectWrapper.wrap(cursor2));
                                        } else {
                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                            zze4 = zzqVar.zze(ObjectWrapper.wrap(applicationContext2), str, i, ObjectWrapper.wrap(cursor2));
                                        }
                                        Context context2 = (Context) ObjectWrapper.unwrap(zze4);
                                        if (context2 == null) {
                                            throw new LoadingException("Failed to get module context", null);
                                        }
                                        zze2 = new DynamiteModule(context2);
                                    } else {
                                        StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(i).length());
                                        sb5.append("Selected remote version of ");
                                        sb5.append(str);
                                        sb5.append(", version >= ");
                                        sb5.append(i);
                                        Log.i("DynamiteModule", sb5.toString());
                                        zzp zzg2 = zzg(context);
                                        if (zzg2 == null) {
                                            throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                        }
                                        int zzi2 = zzg2.zzi();
                                        if (zzi2 >= 3) {
                                            zzn zznVar4 = (zzn) threadLocal.get();
                                            if (zznVar4 == null) {
                                                throw new LoadingException("No cached result cursor holder", null);
                                            }
                                            zze3 = zzg2.zzk(ObjectWrapper.wrap(context), str, i, ObjectWrapper.wrap(zznVar4.zza));
                                        } else if (zzi2 == 2) {
                                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                                            zze3 = zzg2.zzg(ObjectWrapper.wrap(context), str, i);
                                        } else {
                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                            zze3 = zzg2.zze(ObjectWrapper.wrap(context), str, i);
                                        }
                                        Object unwrap = ObjectWrapper.unwrap(zze3);
                                        if (unwrap == null) {
                                            throw new LoadingException("Failed to load remote module.", null);
                                        }
                                        zze2 = new DynamiteModule((Context) unwrap);
                                    }
                                    return zze2;
                                }
                                throw new LoadingException("Failed to determine which loading route to use.", null);
                            } catch (RemoteException e2) {
                                throw new LoadingException("Failed to load remote module.", e2, null);
                            } catch (LoadingException e3) {
                                throw e3;
                            } catch (Throwable th) {
                                CrashUtils.addDynamiteErrorToDropBox(context, th);
                                throw new LoadingException("Failed to load remote module.", th, null);
                            }
                        }
                    }
                }
                int i6 = selectModule.localVersion;
                int i7 = selectModule.remoteVersion;
                StringBuilder sb6 = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(i6).length() + 23 + String.valueOf(i7).length() + 1);
                sb6.append("No acceptable module ");
                sb6.append(str);
                sb6.append(" found. Local version is ");
                sb6.append(i6);
                sb6.append(" and remote version is ");
                sb6.append(i7);
                sb6.append(".");
                throw new LoadingException(sb6.toString(), null);
            } finally {
                if (longValue == 0) {
                    zzi.remove();
                } else {
                    zzi.set(Long.valueOf(longValue));
                }
                Cursor cursor3 = zznVar2.zza;
                if (cursor3 != null) {
                    cursor3.close();
                }
                zzh.set(zznVar);
            }
        }
        throw new LoadingException("null application Context", null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x01da -> B:127:0x01df). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x01dc -> B:127:0x01df). Please submit an issue!!! */
    public static int zza(Context context, String str, boolean z) {
        Field declaredField;
        Throwable th;
        RemoteException remoteException;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = zzc;
                Cursor cursor2 = null;
                int i = 0;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
                        String obj = e.toString();
                        StringBuilder sb = new StringBuilder(obj.length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(obj);
                        Log.w("DynamiteModule", sb.toString());
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader == ClassLoader.getSystemClassLoader()) {
                            bool = Boolean.FALSE;
                        } else if (classLoader != null) {
                            try {
                                zzf(classLoader);
                            } catch (LoadingException unused) {
                            }
                            bool = Boolean.TRUE;
                        } else if (!zzb(context)) {
                            return 0;
                        } else {
                            if (zze || Boolean.TRUE.equals(null)) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    int zzc2 = zzc(context, str, z, true);
                                    String str2 = zzd;
                                    if (str2 != null && !str2.isEmpty()) {
                                        ClassLoader zza2 = zzb.zza();
                                        if (zza2 == null) {
                                            if (Build.VERSION.SDK_INT >= 29) {
                                                String str3 = zzd;
                                                Preconditions.checkNotNull(str3);
                                                String str4 = str3;
                                                zza2 = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                            } else {
                                                String str5 = zzd;
                                                Preconditions.checkNotNull(str5);
                                                String str6 = str5;
                                                zza2 = new zzd(str5, ClassLoader.getSystemClassLoader());
                                            }
                                        }
                                        zzf(zza2);
                                        declaredField.set(null, zza2);
                                        zzc = Boolean.TRUE;
                                        return zzc2;
                                    }
                                    return zzc2;
                                } catch (LoadingException unused2) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                }
                            }
                        }
                        zzc = bool;
                    }
                }
                if (!bool.booleanValue()) {
                    zzp zzg2 = zzg(context);
                    try {
                        if (zzg2 != null) {
                            try {
                                int zzi2 = zzg2.zzi();
                                if (zzi2 >= 3) {
                                    zzn zznVar = (zzn) zzh.get();
                                    if (zznVar == null || (cursor = zznVar.zza) == null) {
                                        Cursor cursor3 = (Cursor) ObjectWrapper.unwrap(zzg2.zzj(ObjectWrapper.wrap(context), str, z, ((Long) zzi.get()).longValue()));
                                        if (cursor3 != null) {
                                            try {
                                                if (cursor3.moveToFirst()) {
                                                    int i2 = cursor3.getInt(0);
                                                    if (i2 <= 0 || !zzd(cursor3)) {
                                                        cursor2 = cursor3;
                                                    }
                                                    if (cursor2 != null) {
                                                        cursor2.close();
                                                    }
                                                    i = i2;
                                                }
                                            } catch (RemoteException e2) {
                                                remoteException = e2;
                                                cursor2 = cursor3;
                                                String message = remoteException.getMessage();
                                                StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 42);
                                                sb2.append("Failed to retrieve remote module version: ");
                                                sb2.append(message);
                                                Log.w("DynamiteModule", sb2.toString());
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                return i;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                cursor2 = cursor3;
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                throw th;
                                            }
                                        }
                                        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                    } else {
                                        i = cursor.getInt(0);
                                    }
                                } else if (zzi2 == 2) {
                                    Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                    i = zzg2.zzh(ObjectWrapper.wrap(context), str, z);
                                } else {
                                    Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                    i = zzg2.zzf(ObjectWrapper.wrap(context), str, z);
                                }
                            } catch (RemoteException e3) {
                                remoteException = e3;
                            }
                        }
                        return i;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    try {
                        return zzc(context, str, z, false);
                    } catch (LoadingException e4) {
                        String message2 = e4.getMessage();
                        StringBuilder sb3 = new StringBuilder(String.valueOf(message2).length() + 42);
                        sb3.append("Failed to retrieve remote module version: ");
                        sb3.append(message2);
                        Log.w("DynamiteModule", sb3.toString());
                        return 0;
                    }
                }
            }
        } catch (Throwable th4) {
            CrashUtils.addDynamiteErrorToDropBox(context, th4);
            throw th4;
        }
    }

    private static boolean zzb(Context context) {
        if (Boolean.TRUE.equals(null) || Boolean.TRUE.equals(zzg)) {
            return true;
        }
        boolean z = false;
        if (zzg == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", true != PlatformVersion.isAtLeastQ() ? 0 : 268435456);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzg = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider.applicationInfo != null && (resolveContentProvider.applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zze = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x013a, code lost:
        r8.close();
     */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x017d: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:101:0x017c */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int zzc(Context context, String str, boolean z, boolean z2) throws LoadingException {
        Throwable th;
        Exception exc;
        Cursor cursor;
        Cursor query;
        MatrixCursor matrixCursor;
        Cursor cursor2 = null;
        try {
            try {
                boolean z3 = true;
                Uri build = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartUptime", String.valueOf(((Long) zzi.get()).longValue())).build();
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(build);
                boolean z4 = false;
                if (acquireUnstableContentProviderClient != null) {
                    try {
                        query = acquireUnstableContentProviderClient.query(build, null, null, null, null);
                    } catch (RemoteException unused) {
                    } catch (Throwable th2) {
                        acquireUnstableContentProviderClient.release();
                        throw th2;
                    }
                    if (query != null) {
                        int count = query.getCount();
                        int columnCount = query.getColumnCount();
                        matrixCursor = new MatrixCursor(query.getColumnNames(), count);
                        for (int i = 0; i < count; i++) {
                            if (!query.moveToPosition(i)) {
                                throw new RemoteException("Cursor read incomplete (ContentProvider dead?)");
                            }
                            Object[] objArr = new Object[columnCount];
                            for (int i2 = 0; i2 < columnCount; i2++) {
                                int type = query.getType(i2);
                                if (type == 0) {
                                    objArr[i2] = null;
                                } else if (type == 1) {
                                    objArr[i2] = Long.valueOf(query.getLong(i2));
                                } else if (type == 2) {
                                    objArr[i2] = Double.valueOf(query.getDouble(i2));
                                } else if (type == 3) {
                                    objArr[i2] = query.getString(i2);
                                } else if (type != 4) {
                                    throw new RemoteException("Unknown column type");
                                } else {
                                    objArr[i2] = query.getBlob(i2);
                                }
                            }
                            matrixCursor.addRow(objArr);
                        }
                        query.close();
                        acquireUnstableContentProviderClient.release();
                        if (matrixCursor != null) {
                            try {
                                if (matrixCursor.moveToFirst()) {
                                    int i3 = matrixCursor.getInt(0);
                                    if (i3 > 0) {
                                        synchronized (DynamiteModule.class) {
                                            zzd = matrixCursor.getString(2);
                                            int columnIndex = matrixCursor.getColumnIndex("loaderVersion");
                                            if (columnIndex >= 0) {
                                                zzf = matrixCursor.getInt(columnIndex);
                                            }
                                            int columnIndex2 = matrixCursor.getColumnIndex("disableStandaloneDynamiteLoader2");
                                            if (columnIndex2 >= 0) {
                                                if (matrixCursor.getInt(columnIndex2) == 0) {
                                                    z3 = false;
                                                }
                                                zze = z3;
                                                z4 = z3;
                                            }
                                        }
                                        if (zzd(matrixCursor)) {
                                            matrixCursor = null;
                                        }
                                    }
                                    if (z2 && z4) {
                                        throw new LoadingException("forcing fallback to container DynamiteLoader impl", null);
                                    }
                                    return i3;
                                }
                            } catch (Exception e) {
                                exc = e;
                                if (exc instanceof LoadingException) {
                                    throw exc;
                                }
                                String message = exc.getMessage();
                                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 25);
                                sb.append("V2 version check failed: ");
                                sb.append(message);
                                throw new LoadingException(sb.toString(), exc, null);
                            }
                        }
                        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                        throw new LoadingException("Failed to connect to dynamite module ContentResolver.", null);
                    }
                    acquireUnstableContentProviderClient.release();
                }
                matrixCursor = null;
                if (matrixCursor != null) {
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.", null);
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            exc = e2;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    private static boolean zzd(Cursor cursor) {
        zzn zznVar = (zzn) zzh.get();
        if (zznVar == null || zznVar.zza != null) {
            return false;
        }
        zznVar.zza = cursor;
        return true;
    }

    private static DynamiteModule zze(Context context, String str) {
        String.valueOf(str);
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void zzf(ClassLoader classLoader) throws LoadingException {
        zzq zzqVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzqVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzq) {
                    zzqVar = (zzq) queryLocalInterface;
                } else {
                    zzqVar = new zzq(iBinder);
                }
            }
            zzm = zzqVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, null);
        }
    }

    private static zzp zzg(Context context) {
        zzp zzpVar;
        synchronized (DynamiteModule.class) {
            zzp zzpVar2 = zzl;
            if (zzpVar2 != null) {
                return zzpVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzpVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzpVar = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzp(iBinder);
                }
                if (zzpVar != null) {
                    zzl = zzpVar;
                    return zzpVar;
                }
            } catch (Exception e) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 45);
                sb.append("Failed to load IDynamiteLoader from GmsCore: ");
                sb.append(message);
                Log.e("DynamiteModule", sb.toString());
            }
            return null;
        }
    }

    public Context getModuleContext() {
        return this.zzk;
    }

    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzk.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String.valueOf(str);
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e, null);
        }
    }
}
