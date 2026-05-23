package com.google.android.gms.internal.measurement;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmw {
    private static final zzmw zza = new zzmw(ImmutableSortedSet.of());
    private final ImmutableSortedSet zzb;

    zzmw(ImmutableSortedSet immutableSortedSet) {
        this.zzb = immutableSortedSet;
    }

    public static zzmw zza(zzmw zzmwVar, ImmutableMap immutableMap) {
        long j;
        if (immutableMap.isEmpty()) {
            return zzmwVar;
        }
        HashMap newHashMap = Maps.newHashMap(immutableMap);
        ImmutableSortedSet immutableSortedSet = zzmwVar.zzb;
        ImmutableSortedSet.Builder naturalOrder = ImmutableSortedSet.naturalOrder();
        UnmodifiableIterator it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            zzmv zzmvVar = (zzmv) it.next();
            Object remove = newHashMap.remove(zzmvVar.zza());
            if (remove == null) {
                naturalOrder.add((ImmutableSortedSet.Builder) zzmvVar);
            } else if (remove instanceof String) {
                naturalOrder.add((ImmutableSortedSet.Builder) new zzmv(zzmvVar.zza, zzmvVar.zzb, 4, 0L, remove));
            } else if (remove instanceof byte[]) {
                naturalOrder.add((ImmutableSortedSet.Builder) new zzmv(zzmvVar.zza, zzmvVar.zzb, 5, 0L, remove));
            } else if (remove instanceof Boolean) {
                naturalOrder.add((ImmutableSortedSet.Builder) new zzmv(zzmvVar.zza, zzmvVar.zzb, ((Boolean) remove).booleanValue() ? 1 : 0, 0L, null));
            } else if (remove instanceof Long) {
                naturalOrder.add((ImmutableSortedSet.Builder) new zzmv(zzmvVar.zza, zzmvVar.zzb, 2, ((Long) remove).longValue(), null));
            } else if (remove instanceof Double) {
                naturalOrder.add((ImmutableSortedSet.Builder) new zzmv(zzmvVar.zza, zzmvVar.zzb, 3, Double.doubleToRawLongBits(((Double) remove).doubleValue()), null));
            } else {
                String zza2 = zzmvVar.zza();
                String obj = remove.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 46 + obj.length());
                sb.append("Cannot serialize override for existing flag ");
                sb.append(zza2);
                sb.append(": ");
                sb.append(obj);
                throw new IllegalStateException(sb.toString());
            }
        }
        for (String str : newHashMap.keySet()) {
            Object obj2 = newHashMap.get(str);
            int length = str.length();
            if (length <= 19 && length != 0) {
                boolean z = false;
                long charAt = str.charAt(0) - '0';
                if (charAt >= 1 && charAt <= 9) {
                    int i = 1;
                    while (true) {
                        if (i < length) {
                            int charAt2 = str.charAt(i) - '0';
                            if ((charAt2 > 9) || (charAt2 < 0 ? true : z)) {
                                break;
                            }
                            charAt = (charAt * 10) + charAt2;
                            i++;
                            z = false;
                        } else if (charAt >= 0 && charAt <= 2305843009213693951L) {
                            j = charAt;
                        }
                    }
                }
            }
            j = 0;
            String str2 = j == 0 ? str : null;
            if (obj2 instanceof String) {
                naturalOrder.add((ImmutableSortedSet.Builder) new zzmv(j, str2, 4, 0L, obj2));
            } else if (obj2 instanceof byte[]) {
                naturalOrder.add((ImmutableSortedSet.Builder) new zzmv(j, str2, 5, 0L, obj2));
            } else if (obj2 instanceof Boolean) {
                naturalOrder.add((ImmutableSortedSet.Builder) new zzmv(j, str2, ((Boolean) obj2).booleanValue() ? 1 : 0, 0L, null));
            } else if (obj2 instanceof Long) {
                naturalOrder.add((ImmutableSortedSet.Builder) new zzmv(j, str2, 2, ((Long) obj2).longValue(), null));
            } else if (obj2 instanceof Double) {
                naturalOrder.add((ImmutableSortedSet.Builder) new zzmv(j, str2, 3, Double.doubleToRawLongBits(((Double) obj2).doubleValue()), null));
            } else {
                String valueOf = String.valueOf(obj2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 28 + String.valueOf(valueOf).length());
                sb2.append("Cannot serialize override ");
                sb2.append(str);
                sb2.append(": ");
                sb2.append(valueOf);
                throw new IllegalStateException(sb2.toString());
            }
        }
        return new zzmw(naturalOrder.build());
    }

    public static zzmw zzb() {
        return zza;
    }

    public static zzmw zzd(zzacv zzacvVar) throws IOException {
        long j;
        String str;
        zzmv zzmvVar;
        int zzx = zzacvVar.zzx();
        if (zzx < 0) {
            throw new zzaeh("Negative number of flags");
        }
        ImmutableSortedSet.Builder naturalOrder = ImmutableSortedSet.naturalOrder();
        long j2 = 0;
        for (int i = 0; i < zzx; i++) {
            long zzz = zzacvVar.zzz();
            int i2 = (int) zzz;
            long j3 = zzz >>> 3;
            if (j3 == 0) {
                j = 0;
                str = zzacvVar.zzl();
            } else {
                long j4 = j3 + j2;
                if (j4 > 2305843009213693951L) {
                    throw new zzaeh("Flag name larger than max size");
                }
                j = j4;
                str = null;
            }
            int i3 = i2 & 7;
            if (i3 == 0 || i3 == 1) {
                zzmvVar = new zzmv(j, str, i3, 0L, null);
            } else if (i3 == 2) {
                zzmvVar = new zzmv(j, str, i3, zzacvVar.zzz(), null);
            } else if (i3 == 3) {
                zzmvVar = new zzmv(j, str, i3, Double.doubleToRawLongBits(zzacvVar.zzd()), null);
            } else if (i3 == 4) {
                zzmvVar = new zzmv(j, str, i3, 0L, zzacvVar.zzl());
            } else if (i3 == 5) {
                zzmvVar = new zzmv(j, str, i3, 0L, zzacvVar.zzo());
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 23);
                sb.append("Unrecognized flag type ");
                sb.append(i3);
                throw new zzaeh(sb.toString());
            }
            long j5 = zzmvVar.zza;
            if (j5 != 0) {
                j2 = j5;
            }
            naturalOrder.add((ImmutableSortedSet.Builder) zzmvVar);
        }
        return new zzmw(naturalOrder.build());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzmw) {
            return this.zzb.equals(((zzmw) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final void zzc(ImmutableMap.Builder builder) {
        UnmodifiableIterator it = this.zzb.iterator();
        while (it.hasNext()) {
            zzmv zzmvVar = (zzmv) it.next();
            builder.put(zzmvVar.zza(), zzmvVar.zzb());
        }
    }

    public final ImmutableSortedSet zze() {
        return this.zzb;
    }

    public final int zzf() {
        return this.zzb.size();
    }
}
