package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zzmf;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzmf<MessageType extends zzmf<MessageType, BuilderType>, BuilderType extends zzmb<MessageType, BuilderType>> extends zzks<MessageType, BuilderType> {
    private static final Map zzd = new ConcurrentHashMap();
    private int zzb = -1;
    protected zzoj zzc = zzoj.zza();

    private final int zzc(zznx zznxVar) {
        return zznu.zza().zzb(getClass()).zze(this);
    }

    public static zzmf zzco(Class cls) {
        Map map = zzd;
        zzmf zzmfVar = (zzmf) map.get(cls);
        if (zzmfVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzmfVar = (zzmf) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzmfVar == null) {
            zzmf zzmfVar2 = (zzmf) ((zzmf) zzop.zzc(cls)).zzl(6, null, null);
            if (zzmfVar2 == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzmfVar2);
            return zzmfVar2;
        }
        return zzmfVar;
    }

    public static void zzcp(Class cls, zzmf zzmfVar) {
        zzmfVar.zzcg();
        zzd.put(cls, zzmfVar);
    }

    public static Object zzcq(zznm zznmVar, String str, Object[] objArr) {
        return new zznw(zznmVar, str, objArr);
    }

    public static Object zzcr(Method method, Object obj, Object... objArr) {
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

    public static zzmm zzcs() {
        return zzmg.zzd();
    }

    public static zzmn zzct() {
        return zzna.zze();
    }

    public static zzmn zzcu(zzmn zzmnVar) {
        int size = zzmnVar.size();
        return zzmnVar.zzg(size + size);
    }

    public static zzmo zzcv() {
        return zznv.zzd();
    }

    public static zzmo zzcw(zzmo zzmoVar) {
        int size = zzmoVar.size();
        return zzmoVar.zzg(size + size);
    }

    public static /* synthetic */ boolean zzcx(zzmf zzmfVar, boolean z) {
        return zzd(zzmfVar, false);
    }

    public static final boolean zzd(zzmf zzmfVar, boolean z) {
        byte byteValue = ((Byte) zzmfVar.zzl(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zznu.zza().zzb(zzmfVar.getClass()).zzk(zzmfVar);
        if (z) {
            zzmfVar.zzl(2, true != zzk ? null : zzmfVar, null);
        }
        return zzk;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zznu.zza().zzb(getClass()).zzb(this, (zzmf) obj);
        }
        return false;
    }

    public final int hashCode() {
        if (zzcf()) {
            return zzci();
        }
        int i = this.zza;
        if (i == 0) {
            int zzci = zzci();
            this.zza = zzci;
            return zzci;
        }
        return i;
    }

    public final String toString() {
        return zzno.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zznm
    public final void zzcB(zzlm zzlmVar) throws IOException {
        zznu.zza().zzb(getClass()).zzf(this, zzln.zza(zzlmVar));
    }

    @Override // com.google.android.gms.internal.measurement.zznm
    public final /* synthetic */ zznl zzcC() {
        return (zzmb) zzl(5, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final boolean zzcD() {
        return zzd(this, true);
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final /* synthetic */ zznm zzcE() {
        return (zzmf) zzl(6, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzks
    public final int zzcd(zznx zznxVar) {
        if (zzcf()) {
            int zze = zznxVar.zze(this);
            if (zze >= 0) {
                return zze;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(zze).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(zze);
            throw new IllegalStateException(sb.toString());
        }
        int i = this.zzb & Integer.MAX_VALUE;
        if (i == Integer.MAX_VALUE) {
            int zze2 = zznxVar.zze(this);
            if (zze2 >= 0) {
                this.zzb = (this.zzb & Integer.MIN_VALUE) | zze2;
                return zze2;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(zze2).length() + 42);
            sb2.append("serialized size must be non-negative, was ");
            sb2.append(zze2);
            throw new IllegalStateException(sb2.toString());
        }
        return i;
    }

    public final boolean zzcf() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final void zzcg() {
        this.zzb &= Integer.MAX_VALUE;
    }

    public final zzmf zzch() {
        return (zzmf) zzl(4, null, null);
    }

    final int zzci() {
        return zznu.zza().zzb(getClass()).zzc(this);
    }

    public final void zzcj() {
        zznu.zza().zzb(getClass()).zzj(this);
        zzcg();
    }

    public final zzmb zzck() {
        return (zzmb) zzl(5, null, null);
    }

    public final zzmb zzcl() {
        zzmb zzmbVar = (zzmb) zzl(5, null, null);
        zzmbVar.zzbd(this);
        return zzmbVar;
    }

    public final void zzcm(int i) {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public abstract Object zzl(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.measurement.zznm
    public final int zzcn() {
        if (zzcf()) {
            int zzc = zzc(null);
            if (zzc >= 0) {
                return zzc;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(zzc);
            throw new IllegalStateException(sb.toString());
        }
        int i = this.zzb & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zzc2 = zzc(null);
        if (zzc2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | zzc2;
            return zzc2;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzc2).length() + 42);
        sb2.append("serialized size must be non-negative, was ");
        sb2.append(zzc2);
        throw new IllegalStateException(sb2.toString());
    }
}
