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
/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final int REMOTE = 1;
    private static Boolean zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static Boolean zzf;
    private static zzp zzk;
    private static zzq zzl;
    private final Context zzj;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy zza = new zzl();

    /* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
    /* loaded from: classes3.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
    /* loaded from: classes3.dex */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzo zzoVar) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzo zzoVar) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
    /* loaded from: classes3.dex */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
        /* loaded from: classes3.dex */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
        /* loaded from: classes3.dex */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!Objects.equal(declaredField.get(null), str)) {
                String valueOf = String.valueOf(declaredField.get(null));
                Log.e("DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + str + "'");
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        long j;
        VersionPolicy.SelectionResult selectModule;
        int i;
        DynamiteModule zzc2;
        Boolean bool;
        IObjectWrapper zzh2;
        DynamiteModule dynamiteModule;
        zzq zzqVar;
        Boolean valueOf;
        IObjectWrapper zze2;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            ThreadLocal threadLocal = zzg;
            zzm zzmVar = (zzm) threadLocal.get();
            zzm zzmVar2 = new zzm(null);
            threadLocal.set(zzmVar2);
            ThreadLocal threadLocal2 = zzh;
            long longValue = ((Long) threadLocal2.get()).longValue();
            try {
                threadLocal2.set(Long.valueOf(SystemClock.uptimeMillis()));
                selectModule = versionPolicy.selectModule(context, str, zzi);
                i = selectModule.localVersion;
                j = longValue;
            } catch (Throwable th) {
                th = th;
                j = longValue;
            }
            try {
                Log.i("DynamiteModule", "Considering local module " + str + StringUtils.PROCESS_POSTFIX_DELIMITER + i + " and remote module " + str + StringUtils.PROCESS_POSTFIX_DELIMITER + selectModule.remoteVersion);
                int i2 = selectModule.selection;
                if (i2 != 0) {
                    if (i2 == -1) {
                        if (selectModule.localVersion != 0) {
                            i2 = -1;
                        }
                    }
                    if (i2 != 1 || selectModule.remoteVersion != 0) {
                        if (i2 == -1) {
                            zzc2 = zzc(applicationContext, str);
                        } else if (i2 != 1) {
                            throw new LoadingException("VersionPolicy returned invalid code:" + i2, null);
                        } else {
                            try {
                                int i3 = selectModule.remoteVersion;
                                try {
                                    synchronized (DynamiteModule.class) {
                                        if (!zzf(context)) {
                                            throw new LoadingException("Remote loading disabled", null);
                                        }
                                        bool = zzb;
                                    }
                                    if (bool == null) {
                                        throw new LoadingException("Failed to determine which loading route to use.", null);
                                    }
                                    if (bool.booleanValue()) {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i3);
                                        synchronized (DynamiteModule.class) {
                                            zzqVar = zzl;
                                        }
                                        if (zzqVar == null) {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                        }
                                        zzm zzmVar3 = (zzm) threadLocal.get();
                                        if (zzmVar3 == null || zzmVar3.zza == null) {
                                            throw new LoadingException("No result cursor", null);
                                        }
                                        Context applicationContext2 = context.getApplicationContext();
                                        Cursor cursor = zzmVar3.zza;
                                        ObjectWrapper.wrap(null);
                                        synchronized (DynamiteModule.class) {
                                            valueOf = Boolean.valueOf(zze >= 2);
                                        }
                                        if (valueOf.booleanValue()) {
                                            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                            zze2 = zzqVar.zzf(ObjectWrapper.wrap(applicationContext2), str, i3, ObjectWrapper.wrap(cursor));
                                        } else {
                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                            zze2 = zzqVar.zze(ObjectWrapper.wrap(applicationContext2), str, i3, ObjectWrapper.wrap(cursor));
                                        }
                                        Context context2 = (Context) ObjectWrapper.unwrap(zze2);
                                        if (context2 == null) {
                                            throw new LoadingException("Failed to get module context", null);
                                        }
                                        dynamiteModule = new DynamiteModule(context2);
                                    } else {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i3);
                                        zzp zzg2 = zzg(context);
                                        if (zzg2 == null) {
                                            throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                        }
                                        int zze3 = zzg2.zze();
                                        if (zze3 >= 3) {
                                            zzm zzmVar4 = (zzm) threadLocal.get();
                                            if (zzmVar4 == null) {
                                                throw new LoadingException("No cached result cursor holder", null);
                                            }
                                            zzh2 = zzg2.zzi(ObjectWrapper.wrap(context), str, i3, ObjectWrapper.wrap(zzmVar4.zza));
                                        } else if (zze3 == 2) {
                                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                                            zzh2 = zzg2.zzj(ObjectWrapper.wrap(context), str, i3);
                                        } else {
                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                            zzh2 = zzg2.zzh(ObjectWrapper.wrap(context), str, i3);
                                        }
                                        Object unwrap = ObjectWrapper.unwrap(zzh2);
                                        if (unwrap == null) {
                                            throw new LoadingException("Failed to load remote module.", null);
                                        }
                                        dynamiteModule = new DynamiteModule((Context) unwrap);
                                    }
                                    zzc2 = dynamiteModule;
                                } catch (RemoteException e) {
                                    throw new LoadingException("Failed to load remote module.", e, null);
                                } catch (LoadingException e2) {
                                    throw e2;
                                } catch (Throwable th2) {
                                    CrashUtils.addDynamiteErrorToDropBox(context, th2);
                                    throw new LoadingException("Failed to load remote module.", th2, null);
                                }
                            } catch (LoadingException e3) {
                                Log.w("DynamiteModule", "Failed to load remote module: " + e3.getMessage());
                                int i4 = selectModule.localVersion;
                                if (i4 == 0 || versionPolicy.selectModule(context, str, new zzn(i4, 0)).selection != -1) {
                                    throw new LoadingException("Remote load failed. No local fallback found.", e3, null);
                                }
                                zzc2 = zzc(applicationContext, str);
                            }
                        }
                        if (j == 0) {
                            zzh.remove();
                        } else {
                            zzh.set(Long.valueOf(j));
                        }
                        Cursor cursor2 = zzmVar2.zza;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        zzg.set(zzmVar);
                        return zzc2;
                    }
                }
                throw new LoadingException("No acceptable module " + str + " found. Local version is " + selectModule.localVersion + " and remote version is " + selectModule.remoteVersion + ".", null);
            } catch (Throwable th3) {
                th = th3;
                if (j == 0) {
                    zzh.remove();
                } else {
                    zzh.set(Long.valueOf(j));
                }
                Cursor cursor3 = zzmVar2.zza;
                if (cursor3 != null) {
                    cursor3.close();
                }
                zzg.set(zzmVar);
                throw th;
            }
        }
        throw new LoadingException("null application Context", null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x01c0 -> B:128:0x01c5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x01c2 -> B:128:0x01c5). Please submit an issue!!! */
    public static int zza(Context context, String str, boolean z) {
        Field declaredField;
        Throwable th;
        RemoteException remoteException;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = zzb;
                Cursor cursor2 = null;
                int i = 0;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
                        String obj = e.toString();
                        Log.w("DynamiteModule", "Failed to load module via V2: " + obj);
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader == ClassLoader.getSystemClassLoader()) {
                            bool = Boolean.FALSE;
                        } else if (classLoader != null) {
                            try {
                                zzd(classLoader);
                            } catch (LoadingException unused) {
                            }
                            bool = Boolean.TRUE;
                        } else if (!zzf(context)) {
                            return 0;
                        } else {
                            if (zzd || Boolean.TRUE.equals(null)) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    int zzb2 = zzb(context, str, z, true);
                                    String str2 = zzc;
                                    if (str2 != null && !str2.isEmpty()) {
                                        ClassLoader zza2 = zzb.zza();
                                        if (zza2 == null) {
                                            if (Build.VERSION.SDK_INT >= 29) {
                                                String str3 = zzc;
                                                Preconditions.checkNotNull(str3);
                                                String str4 = str3;
                                                zza2 = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                            } else {
                                                String str5 = zzc;
                                                Preconditions.checkNotNull(str5);
                                                String str6 = str5;
                                                zza2 = new zzc(str5, ClassLoader.getSystemClassLoader());
                                            }
                                        }
                                        zzd(zza2);
                                        declaredField.set(null, zza2);
                                        zzb = Boolean.TRUE;
                                        return zzb2;
                                    }
                                    return zzb2;
                                } catch (LoadingException unused2) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                }
                            }
                        }
                        zzb = bool;
                    }
                }
                if (!bool.booleanValue()) {
                    zzp zzg2 = zzg(context);
                    try {
                        if (zzg2 != null) {
                            try {
                                int zze2 = zzg2.zze();
                                if (zze2 >= 3) {
                                    zzm zzmVar = (zzm) zzg.get();
                                    if (zzmVar == null || (cursor = zzmVar.zza) == null) {
                                        Cursor cursor3 = (Cursor) ObjectWrapper.unwrap(zzg2.zzk(ObjectWrapper.wrap(context), str, z, ((Long) zzh.get()).longValue()));
                                        if (cursor3 != null) {
                                            try {
                                                if (cursor3.moveToFirst()) {
                                                    int i2 = cursor3.getInt(0);
                                                    if (i2 <= 0 || !zze(cursor3)) {
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
                                                Log.w("DynamiteModule", "Failed to retrieve remote module version: " + message);
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
                                } else if (zze2 == 2) {
                                    Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                    i = zzg2.zzg(ObjectWrapper.wrap(context), str, z);
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
                        return zzb(context, str, z, false);
                    } catch (LoadingException e4) {
                        String message2 = e4.getMessage();
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + message2);
                        return 0;
                    }
                }
            }
        } catch (Throwable th4) {
            CrashUtils.addDynamiteErrorToDropBox(context, th4);
            throw th4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0137, code lost:
        r3.close();
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0172: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:102:0x0171 */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int zzb(Context context, String str, boolean z, boolean z2) throws LoadingException {
        Throwable th;
        Exception exc;
        Cursor cursor;
        Cursor query;
        MatrixCursor matrixCursor;
        Cursor cursor2 = null;
        try {
            try {
                boolean z3 = true;
                Uri build = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartUptime", String.valueOf(((Long) zzh.get()).longValue())).build();
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
                        try {
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
                                                zzc = matrixCursor.getString(2);
                                                int columnIndex = matrixCursor.getColumnIndex("loaderVersion");
                                                if (columnIndex >= 0) {
                                                    zze = matrixCursor.getInt(columnIndex);
                                                }
                                                int columnIndex2 = matrixCursor.getColumnIndex("disableStandaloneDynamiteLoader2");
                                                if (columnIndex2 >= 0) {
                                                    if (matrixCursor.getInt(columnIndex2) == 0) {
                                                        z3 = false;
                                                    }
                                                    zzd = z3;
                                                    z4 = z3;
                                                }
                                            }
                                            if (zze(matrixCursor)) {
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
                                    throw new LoadingException("V2 version check failed: " + exc.getMessage(), exc, null);
                                }
                            }
                            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                            throw new LoadingException("Failed to connect to dynamite module ContentResolver.", null);
                        } catch (Throwable th3) {
                            try {
                                query.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                            throw th3;
                        }
                    }
                    acquireUnstableContentProviderClient.release();
                }
                matrixCursor = null;
                if (matrixCursor != null) {
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.", null);
            } catch (Throwable th5) {
                th = th5;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            exc = e2;
        } catch (Throwable th6) {
            th = th6;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
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
            zzl = zzqVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, null);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzm zzmVar = (zzm) zzg.get();
        if (zzmVar == null || zzmVar.zza != null) {
            return false;
        }
        zzmVar.zza = cursor;
        return true;
    }

    private static boolean zzf(Context context) {
        if (Boolean.TRUE.equals(null) || Boolean.TRUE.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", true != PlatformVersion.isAtLeastQ() ? 0 : 268435456);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzf = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider.applicationInfo != null && (resolveContentProvider.applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    private static zzp zzg(Context context) {
        zzp zzpVar;
        synchronized (DynamiteModule.class) {
            zzp zzpVar2 = zzk;
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
                    zzk = zzpVar;
                    return zzpVar;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
            return null;
        }
    }

    public Context getModuleContext() {
        return this.zzj;
    }

    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e, null);
        }
    }
}
