package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
final class zzoo {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzon zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0154  */
    static {
        boolean z;
        zzon zzonVar;
        boolean z2;
        Field zzB;
        zzon zzonVar2;
        Unsafe zzq = zzq();
        zzc = zzq;
        int i = zzku.zza;
        zzd = Memory.class;
        boolean zzr = zzr(Long.TYPE);
        zze = zzr;
        boolean zzr2 = zzr(Integer.TYPE);
        zzon zzonVar3 = null;
        if (zzq != null) {
            if (zzr) {
                zzonVar3 = new zzom(zzq);
            } else if (zzr2) {
                zzonVar3 = new zzol(zzq);
            }
        }
        zzf = zzonVar3;
        if (zzonVar3 != null) {
            try {
                Class<?> cls = zzonVar3.zza.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
            } catch (Throwable th) {
                zzy(th);
            }
            if (zzB() != null) {
                z = true;
                zzg = z;
                zzonVar = zzf;
                if (zzonVar != null) {
                    try {
                        Class<?> cls2 = zzonVar.zza.getClass();
                        cls2.getMethod("objectFieldOffset", Field.class);
                        cls2.getMethod("arrayBaseOffset", Class.class);
                        cls2.getMethod("arrayIndexScale", Class.class);
                        cls2.getMethod("getInt", Object.class, Long.TYPE);
                        cls2.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
                        cls2.getMethod("getLong", Object.class, Long.TYPE);
                        cls2.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
                        cls2.getMethod("getObject", Object.class, Long.TYPE);
                        cls2.getMethod("putObject", Object.class, Long.TYPE, Object.class);
                        z2 = true;
                    } catch (Throwable th2) {
                        zzy(th2);
                    }
                    zzh = z2;
                    zza = zzz(byte[].class);
                    zzz(boolean[].class);
                    zzA(boolean[].class);
                    zzz(int[].class);
                    zzA(int[].class);
                    zzz(long[].class);
                    zzA(long[].class);
                    zzz(float[].class);
                    zzA(float[].class);
                    zzz(double[].class);
                    zzA(double[].class);
                    zzz(Object[].class);
                    zzA(Object[].class);
                    zzB = zzB();
                    if (zzB != null && (zzonVar2 = zzf) != null) {
                        zzonVar2.zza.objectFieldOffset(zzB);
                    }
                    zzb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
                }
                z2 = false;
                zzh = z2;
                zza = zzz(byte[].class);
                zzz(boolean[].class);
                zzA(boolean[].class);
                zzz(int[].class);
                zzA(int[].class);
                zzz(long[].class);
                zzA(long[].class);
                zzz(float[].class);
                zzA(float[].class);
                zzz(double[].class);
                zzA(double[].class);
                zzz(Object[].class);
                zzA(Object[].class);
                zzB = zzB();
                if (zzB != null) {
                    zzonVar2.zza.objectFieldOffset(zzB);
                }
                zzb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
            }
        }
        z = false;
        zzg = z;
        zzonVar = zzf;
        if (zzonVar != null) {
        }
        z2 = false;
        zzh = z2;
        zza = zzz(byte[].class);
        zzz(boolean[].class);
        zzA(boolean[].class);
        zzz(int[].class);
        zzA(int[].class);
        zzz(long[].class);
        zzA(long[].class);
        zzz(float[].class);
        zzA(float[].class);
        zzz(double[].class);
        zzA(double[].class);
        zzz(Object[].class);
        zzA(Object[].class);
        zzB = zzB();
        if (zzB != null) {
        }
        zzb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzoo() {
    }

    private static int zzA(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i = zzku.zza;
        Field zzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (zzC == null) {
            Field zzC2 = zzC(Buffer.class, "address");
            if (zzC2 == null || zzC2.getType() != Long.TYPE) {
                return null;
            }
            return zzC2;
        }
        return zzC;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzD(Object obj, long j, byte b) {
        Unsafe unsafe = zzf.zza;
        long j2 = (-4) & j;
        int i = unsafe.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b) << i2) | (i & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzE(Object obj, long j, byte b) {
        Unsafe unsafe = zzf.zza;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b) << i) | (unsafe.getInt(obj, j2) & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza() {
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb() {
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzc(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(Object obj, long j) {
        return zzf.zza.getInt(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zze(Object obj, long j, int i) {
        zzf.zza.putInt(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzf(Object obj, long j) {
        return zzf.zza.getLong(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzg(Object obj, long j, long j2) {
        zzf.zza.putLong(obj, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzh(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzi(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzj(Object obj, long j) {
        return zzf.zzd(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzk(Object obj, long j, float f) {
        zzf.zze(obj, j, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzl(Object obj, long j) {
        return zzf.zzf(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzm(Object obj, long j, double d) {
        zzf.zzg(obj, j, d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzn(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzo(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzp(byte[] bArr, long j, byte b) {
        zzf.zza(bArr, zza + j, b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzq() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzok());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean zzr(Class cls) {
        int i = zzku.zza;
        try {
            Class cls2 = zzd;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzu(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzv(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ void zzy(Throwable th) {
        Logger.getLogger(zzoo.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    private static int zzz(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }
}
