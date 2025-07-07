package com.google.android.gms.dynamite;

import android.os.Looper;
import android.util.Log;
/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public final class zzb {
    private static ClassLoader zza;
    private static Thread zzb;

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a1, code lost:
        if (r1 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized ClassLoader zza() {
        ClassLoader classLoader;
        SecurityException e;
        zza zzaVar;
        ThreadGroup threadGroup;
        zza zzaVar2;
        synchronized (zzb.class) {
            if (zza == null) {
                zza zzaVar3 = zzb;
                ClassLoader classLoader2 = null;
                if (zzaVar3 == null) {
                    ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
                    if (threadGroup2 == null) {
                        zzaVar3 = null;
                    } else {
                        synchronized (Void.class) {
                            try {
                                int activeGroupCount = threadGroup2.activeGroupCount();
                                ThreadGroup[] threadGroupArr = new ThreadGroup[activeGroupCount];
                                threadGroup2.enumerate(threadGroupArr);
                                int i = 0;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= activeGroupCount) {
                                        threadGroup = null;
                                        break;
                                    }
                                    threadGroup = threadGroupArr[i2];
                                    if ("dynamiteLoader".equals(threadGroup.getName())) {
                                        break;
                                    }
                                    i2++;
                                }
                                if (threadGroup == null) {
                                    threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                                }
                                int activeCount = threadGroup.activeCount();
                                Thread[] threadArr = new Thread[activeCount];
                                threadGroup.enumerate(threadArr);
                                while (true) {
                                    if (i >= activeCount) {
                                        zzaVar = null;
                                        break;
                                    }
                                    zzaVar = threadArr[i];
                                    if ("GmsDynamite".equals(zzaVar.getName())) {
                                        break;
                                    }
                                    i++;
                                }
                                if (zzaVar == null) {
                                    try {
                                        zzaVar2 = new zza(threadGroup, "GmsDynamite");
                                    } catch (SecurityException e2) {
                                        e = e2;
                                    }
                                    try {
                                        zzaVar2.setContextClassLoader(null);
                                        zzaVar2.start();
                                        zzaVar = zzaVar2;
                                    } catch (SecurityException e3) {
                                        e = e3;
                                        zzaVar = zzaVar2;
                                        Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e.getMessage());
                                        zzaVar3 = zzaVar;
                                        zzb = zzaVar3;
                                    }
                                }
                            } catch (SecurityException e4) {
                                e = e4;
                                zzaVar = null;
                            }
                        }
                        zzaVar3 = zzaVar;
                    }
                    zzb = zzaVar3;
                }
                synchronized (zzaVar3) {
                    try {
                        classLoader2 = zzb.getContextClassLoader();
                    } catch (SecurityException e5) {
                        Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + e5.getMessage());
                    }
                }
                zza = classLoader2;
            }
            classLoader = zza;
        }
        return classLoader;
    }
}
