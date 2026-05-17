package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzfq;
import com.google.android.gms.internal.play_billing.zzfu;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public abstract class zzfu<MessageType extends zzfu<MessageType, BuilderType>, BuilderType extends zzfq<MessageType, BuilderType>> extends zzeg<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzic zzc = zzic.zzc();

    public static void zzB(Class cls, zzfu zzfuVar) {
        zzfuVar.zzA();
        zzb.put(cls, zzfuVar);
    }

    public static /* bridge */ /* synthetic */ boolean zzE(zzfu zzfuVar, boolean z) {
        return zzc(zzfuVar, false);
    }

    private final int zza(zzhl zzhlVar) {
        return zzhi.zza().zzb(getClass()).zza(this);
    }

    private static zzfu zzb(zzfu zzfuVar, byte[] bArr, int i, int i2, zzfh zzfhVar) throws zzgc {
        if (i2 == 0) {
            return zzfuVar;
        }
        zzfu zzs = zzfuVar.zzs();
        try {
            zzhl zzb2 = zzhi.zza().zzb(zzs.getClass());
            zzb2.zzh(zzs, bArr, 0, i2, new zzej(zzfhVar));
            zzb2.zzf(zzs);
            return zzs;
        } catch (zzgc e) {
            throw e;
        } catch (zzia e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgc) {
                throw ((zzgc) e3.getCause());
            }
            throw new zzgc(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public static final boolean zzc(zzfu zzfuVar, boolean z) {
        byte byteValue = ((Byte) zzfuVar.zzd(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzhi.zza().zzb(zzfuVar.getClass()).zzk(zzfuVar);
        if (z) {
            zzfuVar.zzd(2, true != zzk ? null : zzfuVar, null);
        }
        return zzk;
    }

    public static zzfu zzr(Class cls) {
        Map map = zzb;
        zzfu zzfuVar = (zzfu) map.get(cls);
        if (zzfuVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzfuVar = (zzfu) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzfuVar == null) {
            zzfu zzfuVar2 = (zzfu) ((zzfu) zzii.zze(cls)).zzd(6, null, null);
            if (zzfuVar2 == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzfuVar2);
            return zzfuVar2;
        }
        return zzfuVar;
    }

    public static zzfu zzt(zzfu zzfuVar, byte[] bArr) throws zzgc {
        int length = bArr.length;
        int i = zzfh.zzb;
        int i2 = zzei.zza;
        zzfu zzb2 = zzb(zzfuVar, bArr, 0, length, zzfh.zza);
        if (zzb2 == null || zzc(zzb2, true)) {
            return zzb2;
        }
        throw new zzia(zzb2).zza();
    }

    public static zzfy zzu() {
        return zzfv.zzf();
    }

    public static zzfz zzv() {
        return zzhj.zze();
    }

    public static Object zzx(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object zzy(zzhb zzhbVar, String str, Object[] objArr) {
        return new zzhk(zzhbVar, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzhi.zza().zzb(getClass()).zzj(this, (zzfu) obj);
        }
        return false;
    }

    public final int hashCode() {
        if (zzF()) {
            return zzm();
        }
        int i = this.zza;
        if (i == 0) {
            int zzm = zzm();
            this.zza = zzm;
            return zzm;
        }
        return i;
    }

    public final String toString() {
        return zzhd.zza(this, super.toString());
    }

    public final void zzA() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzC(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhb
    public final void zzD(zzfc zzfcVar) throws IOException {
        zzhi.zza().zzb(getClass()).zzi(this, zzfd.zza(zzfcVar));
    }

    public final boolean zzF() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object zzd(int i, Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzeg
    public final int zzi(zzhl zzhlVar) {
        if (zzF()) {
            int zza = zzhlVar.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i == Integer.MAX_VALUE) {
            int zza2 = zzhlVar.zza(this);
            if (zza2 >= 0) {
                this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
                return zza2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhc
    public final /* synthetic */ zzhb zzl() {
        return (zzfu) zzd(6, null, null);
    }

    final int zzm() {
        return zzhi.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhc
    public final boolean zzo() {
        return zzc(this, true);
    }

    public final zzfq zzp() {
        return (zzfq) zzd(5, null, null);
    }

    public final zzfq zzq() {
        zzfq zzfqVar = (zzfq) zzd(5, null, null);
        zzfqVar.zzh(this);
        return zzfqVar;
    }

    public final zzfu zzs() {
        return (zzfu) zzd(4, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhb
    public final /* synthetic */ zzha zzw() {
        return (zzfq) zzd(5, null, null);
    }

    public final void zzz() {
        zzhi.zza().zzb(getClass()).zzf(this);
        zzA();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhb
    public final int zzn() {
        if (zzF()) {
            int zza = zza(null);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zza(null);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }
}
