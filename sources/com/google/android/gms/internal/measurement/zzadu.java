package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzadp;
import com.google.android.gms.internal.measurement.zzadu;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzadu<MessageType extends zzadu<MessageType, BuilderType>, BuilderType extends zzadp<MessageType, BuilderType>> extends zzacb<MessageType, BuilderType> {
    public static final /* synthetic */ int zzd = 0;
    private static final Map zze = new ConcurrentHashMap();
    private int zzb = -1;
    protected zzaga zzc = zzaga.zza();

    private final int zzc(zzafp zzafpVar) {
        return zzafl.zza().zzb(getClass()).zze(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzadu zzcA(zzadu zzaduVar, byte[] bArr, zzadf zzadfVar) throws zzaeh {
        zzadu zze2 = zze(zzaduVar, bArr, 0, bArr.length, zzadfVar);
        zzf(zze2);
        return zze2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzadu zzcB(zzadu zzaduVar, InputStream inputStream, zzadf zzadfVar) throws zzaeh {
        zzacv zzM = zzacv.zzM(inputStream, 4096);
        zzadu zzck = zzaduVar.zzck();
        try {
            zzafp zzb = zzafl.zza().zzb(zzck.getClass());
            zzb.zzg(zzck, zzacw.zza(zzM), zzadfVar);
            zzb.zzk(zzck);
            zzf(zzck);
            return zzck;
        } catch (zzaeh e) {
            if (e.zzb()) {
                throw new zzaeh(e);
            }
            throw e;
        } catch (zzafy e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzaeh) {
                throw ((zzaeh) e3.getCause());
            }
            throw new zzaeh(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzaeh) {
                throw ((zzaeh) e4.getCause());
            }
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzadu zzcC(zzadu zzaduVar, zzacv zzacvVar, zzadf zzadfVar) throws zzaeh {
        zzadu zzck = zzaduVar.zzck();
        try {
            zzafp zzb = zzafl.zza().zzb(zzck.getClass());
            zzb.zzg(zzck, zzacw.zza(zzacvVar), zzadfVar);
            zzb.zzk(zzck);
            zzf(zzck);
            return zzck;
        } catch (zzaeh e) {
            if (e.zzb()) {
                throw new zzaeh(e);
            }
            throw e;
        } catch (zzafy e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzaeh) {
                throw ((zzaeh) e3.getCause());
            }
            throw new zzaeh(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzaeh) {
                throw ((zzaeh) e4.getCause());
            }
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzadu zzcr(Class cls) {
        Map map = zze;
        zzadu zzaduVar = (zzadu) map.get(cls);
        if (zzaduVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzaduVar = (zzadu) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzaduVar == null) {
            zzadu zzaduVar2 = (zzadu) ((zzadu) zzagg.zzb(cls)).zzg(6, null, null);
            if (zzaduVar2 == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzaduVar2);
            return zzaduVar2;
        }
        return zzaduVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzcs(Class cls, zzadu zzaduVar) {
        zzaduVar.zzci();
        zze.put(cls, zzaduVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzct(zzafc zzafcVar, String str, Object[] objArr) {
        return new zzafn(zzafcVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzcu(Method method, Object obj, Object... objArr) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzaeb zzcv() {
        return zzadv.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzaee zzcw() {
        return zzaeq.zze();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzaee zzcx(zzaee zzaeeVar) {
        int size = zzaeeVar.size();
        return zzaeeVar.zzg(size + size);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzaef zzcy() {
        return zzafm.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzaef zzcz(zzaef zzaefVar) {
        int size = zzaefVar.size();
        return zzaefVar.zzg(size + size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zzd(zzadu zzaduVar, boolean z) {
        byte byteValue = ((Byte) zzaduVar.zzg(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzl = zzafl.zza().zzb(zzaduVar.getClass()).zzl(zzaduVar);
        if (z) {
            zzaduVar.zzg(2, true != zzl ? null : zzaduVar, null);
        }
        return zzl;
    }

    private static zzadu zze(zzadu zzaduVar, byte[] bArr, int i, int i2, zzadf zzadfVar) throws zzaeh {
        if (i2 == 0) {
            return zzaduVar;
        }
        zzadu zzck = zzaduVar.zzck();
        try {
            zzafp zzb = zzafl.zza().zzb(zzck.getClass());
            zzb.zzj(zzck, bArr, 0, i2, new zzacg(zzadfVar));
            zzb.zzk(zzck);
            return zzck;
        } catch (zzaeh e) {
            if (e.zzb()) {
                throw new zzaeh(e);
            }
            throw e;
        } catch (zzafy e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzaeh) {
                throw ((zzaeh) e3.getCause());
            }
            throw new zzaeh(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private static zzadu zzf(zzadu zzaduVar) throws zzaeh {
        if (zzaduVar == null || zzd(zzaduVar, true)) {
            return zzaduVar;
        }
        throw new zzafy(zzaduVar).zza();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzafl.zza().zzb(getClass()).zzb(this, (zzadu) obj);
        }
        return false;
    }

    public final int hashCode() {
        if (zzch()) {
            return zzcl();
        }
        int i = this.zza;
        if (i == 0) {
            int zzcl = zzcl();
            this.zza = zzcl;
            return zzcl;
        }
        return i;
    }

    public final String toString() {
        return zzafe.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzafc
    public final void zzcH(zzada zzadaVar) throws IOException {
        zzafl.zza().zzb(getClass()).zzf(this, zzadb.zza(zzadaVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzafc
    public final /* synthetic */ zzafb zzcI() {
        return (zzadp) zzg(5, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzafd
    public final boolean zzcJ() {
        return zzd(this, true);
    }

    @Override // com.google.android.gms.internal.measurement.zzafd
    public final /* synthetic */ zzafc zzcK() {
        return (zzadu) zzg(6, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzacb
    final int zzcf(zzafp zzafpVar) {
        if (zzch()) {
            int zze2 = zzafpVar.zze(this);
            if (zze2 >= 0) {
                return zze2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(zze2).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(zze2);
            throw new IllegalStateException(sb.toString());
        }
        int i = this.zzb & Integer.MAX_VALUE;
        if (i == Integer.MAX_VALUE) {
            int zze3 = zzafpVar.zze(this);
            if (zze3 >= 0) {
                this.zzb = (this.zzb & Integer.MIN_VALUE) | zze3;
                return zze3;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(zze3).length() + 42);
            sb2.append("serialized size must be non-negative, was ");
            sb2.append(zze3);
            throw new IllegalStateException(sb2.toString());
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzch() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzci() {
        this.zzb &= Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzafc
    public final zzafj zzcj() {
        return (zzafj) zzg(7, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzadu zzck() {
        return (zzadu) zzg(4, null, null);
    }

    final int zzcl() {
        return zzafl.zza().zzb(getClass()).zzc(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzcm() {
        zzafl.zza().zzb(getClass()).zzk(this);
        zzci();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzadp zzcn() {
        return (zzadp) zzg(5, null, null);
    }

    public final zzadp zzco() {
        zzadp zzadpVar = (zzadp) zzg(5, null, null);
        zzadpVar.zzbe(this);
        return zzadpVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzcp(int i) {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzg(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.measurement.zzafc
    public final int zzcq() {
        if (zzch()) {
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
