package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
final class zzagg {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzagf zzf;
    private static final boolean zzg;

    /* JADX WARN: Removed duplicated region for block: B:32:0x014a  */
    static {
        boolean z;
        Field zzA;
        zzagf zzagfVar;
        Unsafe zzp = zzp();
        zzc = zzp;
        int i = zzacf.zza;
        zzd = Memory.class;
        boolean zzq = zzq(Long.TYPE);
        zze = zzq;
        boolean zzq2 = zzq(Integer.TYPE);
        zzagf zzagfVar2 = null;
        if (zzp != null) {
            if (zzq) {
                zzagfVar2 = new zzage(zzp);
            } else if (zzq2) {
                zzagfVar2 = new zzagd(zzp);
            }
        }
        zzf = zzagfVar2;
        if (zzagfVar2 != null) {
            try {
                Class<?> cls = zzagfVar2.zza.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                zzA();
            } catch (Throwable th) {
                zzx(th);
            }
        }
        zzagf zzagfVar3 = zzf;
        if (zzagfVar3 != null) {
            try {
                Class<?> cls2 = zzagfVar3.zza.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("arrayBaseOffset", Class.class);
                cls2.getMethod("arrayIndexScale", Class.class);
                cls2.getMethod("getInt", Object.class, Long.TYPE);
                cls2.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
                cls2.getMethod("getLong", Object.class, Long.TYPE);
                cls2.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
                cls2.getMethod("getObject", Object.class, Long.TYPE);
                cls2.getMethod("putObject", Object.class, Long.TYPE, Object.class);
                z = true;
            } catch (Throwable th2) {
                zzx(th2);
            }
            zzg = z;
            zza = zzy(byte[].class);
            zzy(boolean[].class);
            zzz(boolean[].class);
            zzy(int[].class);
            zzz(int[].class);
            zzy(long[].class);
            zzz(long[].class);
            zzy(float[].class);
            zzz(float[].class);
            zzy(double[].class);
            zzz(double[].class);
            zzy(Object[].class);
            zzz(Object[].class);
            zzA = zzA();
            if (zzA != null && (zzagfVar = zzf) != null) {
                zzagfVar.zza.objectFieldOffset(zzA);
            }
            zzb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
        }
        z = false;
        zzg = z;
        zza = zzy(byte[].class);
        zzy(boolean[].class);
        zzz(boolean[].class);
        zzy(int[].class);
        zzz(int[].class);
        zzy(long[].class);
        zzz(long[].class);
        zzy(float[].class);
        zzz(float[].class);
        zzy(double[].class);
        zzz(double[].class);
        zzy(Object[].class);
        zzz(Object[].class);
        zzA = zzA();
        if (zzA != null) {
            zzagfVar.zza.objectFieldOffset(zzA);
        }
        zzb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzagg() {
    }

    private static Field zzA() {
        int i = zzacf.zza;
        Field zzB = zzB(Buffer.class, "effectiveDirectAddress");
        if (zzB == null) {
            Field zzB2 = zzB(Buffer.class, "address");
            if (zzB2 == null || zzB2.getType() != Long.TYPE) {
                return null;
            }
            return zzB2;
        }
        return zzB;
    }

    private static Field zzB(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzC(Object obj, long j, byte b) {
        Unsafe unsafe = zzf.zza;
        long j2 = (-4) & j;
        int i = unsafe.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b) << i2) | (i & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzD(Object obj, long j, byte b) {
        Unsafe unsafe = zzf.zza;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b) << i) | (unsafe.getInt(obj, j2) & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza() {
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzb(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(Object obj, long j) {
        return zzf.zza.getInt(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzd(Object obj, long j, int i) {
        zzf.zza.putInt(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zze(Object obj, long j) {
        return zzf.zza.getLong(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzf(Object obj, long j, long j2) {
        zzf.zza.putLong(obj, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzg(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzh(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzi(Object obj, long j) {
        return zzf.zzd(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzj(Object obj, long j, float f) {
        zzf.zze(obj, j, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzk(Object obj, long j) {
        return zzf.zzf(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzl(Object obj, long j, double d) {
        zzf.zzg(obj, j, d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzm(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzn(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzo(byte[] bArr, long j, byte b) {
        zzf.zza(bArr, zza + j, b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzp() {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new zzagc());
        } catch (Throwable unused) {
            unsafe = null;
        }
        if (unsafe == null) {
            return null;
        }
        try {
            unsafe.arrayBaseOffset(byte[].class);
            return unsafe;
        } catch (Exception unused2) {
            Logger.getLogger(zzagg.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "getUnsafe", "As part of the planned removal, sun.misc.Unsafe is available in the current environment but configured to throw on use. Protobuf will continue without using it, but with slightly reduced performance. --sun-misc-unsafe-memory-access=allow is likely available to opt back in if desired. A later Protobuf version release will stop using sun.misc.Unsafe entirely.");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean zzq(Class cls) {
        int i = zzacf.zza;
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
    public static /* synthetic */ boolean zzt(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzu(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ void zzx(Throwable th) {
        Logger.getLogger(zzagg.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    private static int zzy(Class cls) {
        if (zzg) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzz(Class cls) {
        if (zzg) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }
}
