package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmv implements Comparable {
    final long zza;
    final String zzb;
    final int zzc;
    final long zzd;
    final Object zze;
    private final RuntimeException zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmv(long j, String str, int i, long j2, Object obj) {
        Preconditions.checkArgument(((j > 0L ? 1 : (j == 0L ? 0 : -1)) == 0) == (str != null));
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
        this.zzd = j2;
        this.zze = obj;
        if (i != 5) {
            this.zzf = null;
        } else if (obj == null) {
            this.zzf = new NullPointerException("Null stringOrBytes");
        } else if ((obj instanceof byte[]) || (obj instanceof zzacr)) {
            this.zzf = null;
        } else {
            String valueOf = String.valueOf(obj.getClass());
            String.valueOf(valueOf);
            this.zzf = new RuntimeException("Wrong stringOrBytes type: ".concat(String.valueOf(valueOf)));
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzmv zzmvVar = (zzmv) obj;
        long j = zzmvVar.zza;
        long j2 = this.zza;
        int compare = Long.compare(j2, j);
        if (compare == 0) {
            if (j2 != 0) {
                return 0;
            }
            return ((String) Preconditions.checkNotNull(this.zzb)).compareTo((String) Preconditions.checkNotNull(zzmvVar.zzb));
        }
        return compare;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzmv) {
            zzmv zzmvVar = (zzmv) obj;
            return this.zza == zzmvVar.zza && Objects.equals(this.zzb, zzmvVar.zzb);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        String zza = zza();
        String valueOf = String.valueOf(zzb());
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 1 + String.valueOf(valueOf).length());
        sb.append(zza);
        sb.append(StringUtils.PROCESS_POSTFIX_DELIMITER);
        sb.append(valueOf);
        return sb.toString();
    }

    public final String zza() {
        String str = this.zzb;
        return str != null ? str : Long.toString(this.zza);
    }

    public final Object zzb() {
        int i = this.zzc;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            Object obj = this.zze;
                            Preconditions.checkNotNull(obj);
                            return obj;
                        } else if (i == 5) {
                            Object obj2 = this.zze;
                            Preconditions.checkNotNull(obj2);
                            try {
                                if (!(obj2 instanceof byte[])) {
                                    return ((zzacr) obj2).zzm();
                                }
                                return (byte[]) obj2;
                            } catch (Throwable th) {
                                RuntimeException runtimeException = this.zzf;
                                if (runtimeException != null) {
                                    th.addSuppressed(runtimeException);
                                }
                                throw th;
                            }
                        } else {
                            throw new AssertionError("Impossible, this was validated when parsed or created");
                        }
                    }
                    return Double.valueOf(Double.longBitsToDouble(this.zzd));
                }
                return Long.valueOf(this.zzd);
            }
            return true;
        }
        return false;
    }
}
