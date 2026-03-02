package com.google.android.gms.dynamite;

import android.os.Looper;
import android.util.Log;
/* compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
/* loaded from: classes4.dex */
public final class zzb {
    private static ClassLoader zza;
    private static Thread zzb;

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ad, code lost:
        if (r2 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized ClassLoader zza() {
        ClassLoader classLoader;
        SecurityException e;
        zza zzaVar;
        ThreadGroup threadGroup;
        synchronized (zzb.class) {
            if (zza == null) {
                zza zzaVar2 = zzb;
                ClassLoader classLoader2 = null;
                if (zzaVar2 == null) {
                    ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
                    if (threadGroup2 == null) {
                        zzaVar2 = null;
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
                                        zza zzaVar3 = new zza(threadGroup, "GmsDynamite");
                                        try {
                                            zzaVar3.setContextClassLoader(null);
                                            zzaVar3.start();
                                            zzaVar = zzaVar3;
                                        } catch (SecurityException e2) {
                                            e = e2;
                                            zzaVar = zzaVar3;
                                            String message = e.getMessage();
                                            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 39);
                                            sb.append("Failed to enumerate thread/threadgroup ");
                                            sb.append(message);
                                            Log.w("DynamiteLoaderV2CL", sb.toString());
                                            zzaVar2 = zzaVar;
                                            zzb = zzaVar2;
                                        }
                                    } catch (SecurityException e3) {
                                        e = e3;
                                    }
                                }
                            } catch (SecurityException e4) {
                                e = e4;
                                zzaVar = null;
                            }
                        }
                        zzaVar2 = zzaVar;
                    }
                    zzb = zzaVar2;
                }
                synchronized (zzaVar2) {
                    try {
                        classLoader2 = zzb.getContextClassLoader();
                    } catch (SecurityException e5) {
                        String message2 = e5.getMessage();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(message2).length() + 41);
                        sb2.append("Failed to get thread context classloader ");
                        sb2.append(message2);
                        Log.w("DynamiteLoaderV2CL", sb2.toString());
                    }
                }
                zza = classLoader2;
            }
            classLoader = zza;
        }
        return classLoader;
    }
}
