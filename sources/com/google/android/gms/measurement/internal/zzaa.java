package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzpq;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzaa extends zzab {
    final /* synthetic */ zzad zza;
    private final com.google.android.gms.internal.measurement.zzff zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaa(zzad zzadVar, String str, int i, com.google.android.gms.internal.measurement.zzff zzffVar) {
        super(str, i);
        Objects.requireNonNull(zzadVar);
        this.zza = zzadVar;
        this.zzh = zzffVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final int zza() {
        return this.zzh.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean zzb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean zzc() {
        return this.zzh.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x036c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x036d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzd(Long l, Long l2, com.google.android.gms.internal.measurement.zzhs zzhsVar, long j, zzbc zzbcVar, boolean z) {
        Boolean zzi;
        zzpq.zza();
        zzad zzadVar = this.zza;
        zzib zzibVar = zzadVar.zzu;
        zzal zzc = zzibVar.zzc();
        String str = this.zzb;
        boolean zzp = zzc.zzp(str, zzfx.zzaF);
        com.google.android.gms.internal.measurement.zzff zzffVar = this.zzh;
        long j2 = zzffVar.zzm() ? zzbcVar.zze : j;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        Boolean bool = null;
        if (Log.isLoggable(zzibVar.zzaV().zzn(), 2)) {
            zzibVar.zzaV().zzk().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(this.zzc), zzffVar.zza() ? Integer.valueOf(zzffVar.zzb()) : null, zzibVar.zzl().zza(zzffVar.zzc()));
            zzibVar.zzaV().zzk().zzb("Filter definition", zzadVar.zzg.zzp().zzj(zzffVar));
        }
        if (!zzffVar.zza() || zzffVar.zzb() > 256) {
            zzibVar.zzaV().zze().zzc("Invalid event filter ID. appId, id", zzgt.zzl(str), String.valueOf(zzffVar.zza() ? Integer.valueOf(zzffVar.zzb()) : null));
            return false;
        }
        Object[] objArr = (zzffVar.zzi() || zzffVar.zzj() || zzffVar.zzm()) ? 1 : null;
        if (!z || objArr != null) {
            String zzd = zzhsVar.zzd();
            if (zzffVar.zzg()) {
                Boolean zzg = zzg(j2, zzffVar.zzh());
                if (zzg != null) {
                    if (!zzg.booleanValue()) {
                        bool = false;
                    }
                }
                zzibVar.zzaV().zzk().zzb("Event filter result", bool != null ? AbstractJsonLexerKt.NULL : bool);
                if (bool != null) {
                    return false;
                }
                this.zzd = true;
                if (bool.booleanValue()) {
                    this.zze = true;
                    if (objArr != null && zzhsVar.zze()) {
                        Long valueOf = Long.valueOf(zzhsVar.zzf());
                        if (zzffVar.zzj()) {
                            if (zzp && zzffVar.zzg()) {
                                valueOf = l;
                            }
                            this.zzg = valueOf;
                        } else {
                            if (zzp && zzffVar.zzg()) {
                                valueOf = l2;
                            }
                            this.zzf = valueOf;
                        }
                    }
                    return true;
                }
                return true;
            }
            HashSet hashSet = new HashSet();
            Iterator it = zzffVar.zzd().iterator();
            while (true) {
                if (it.hasNext()) {
                    com.google.android.gms.internal.measurement.zzfh zzfhVar = (com.google.android.gms.internal.measurement.zzfh) it.next();
                    if (!zzfhVar.zzh().isEmpty()) {
                        hashSet.add(zzfhVar.zzh());
                    } else {
                        zzibVar.zzaV().zze().zzb("null or empty param name in filter. event", zzibVar.zzl().zza(zzd));
                        break;
                    }
                } else {
                    ArrayMap arrayMap = new ArrayMap();
                    Iterator it2 = zzhsVar.zza().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it2.next();
                            if (hashSet.contains(zzhwVar.zzb())) {
                                if (zzhwVar.zze()) {
                                    arrayMap.put(zzhwVar.zzb(), zzhwVar.zze() ? Long.valueOf(zzhwVar.zzf()) : null);
                                } else if (zzhwVar.zzi()) {
                                    arrayMap.put(zzhwVar.zzb(), zzhwVar.zzi() ? Double.valueOf(zzhwVar.zzj()) : null);
                                } else if (zzhwVar.zzc()) {
                                    arrayMap.put(zzhwVar.zzb(), zzhwVar.zzd());
                                } else {
                                    zzibVar.zzaV().zze().zzc("Unknown value for param. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzhwVar.zzb()));
                                    break;
                                }
                            }
                        } else {
                            Iterator it3 = zzffVar.zzd().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    com.google.android.gms.internal.measurement.zzfh zzfhVar2 = (com.google.android.gms.internal.measurement.zzfh) it3.next();
                                    boolean z2 = zzfhVar2.zze() && zzfhVar2.zzf();
                                    String zzh = zzfhVar2.zzh();
                                    if (!zzh.isEmpty()) {
                                        V v = arrayMap.get(zzh);
                                        if (v instanceof Long) {
                                            if (zzfhVar2.zzc()) {
                                                Boolean zzg2 = zzg(((Long) v).longValue(), zzfhVar2.zzd());
                                                if (zzg2 == null) {
                                                    break;
                                                } else if (zzg2.booleanValue() == z2) {
                                                    bool = false;
                                                    break;
                                                }
                                            } else {
                                                zzibVar.zzaV().zze().zzc("No number filter for long param. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzh));
                                                break;
                                            }
                                        } else if (v instanceof Double) {
                                            if (zzfhVar2.zzc()) {
                                                Boolean zzh2 = zzh(((Double) v).doubleValue(), zzfhVar2.zzd());
                                                if (zzh2 == null) {
                                                    break;
                                                } else if (zzh2.booleanValue() == z2) {
                                                    bool = false;
                                                    break;
                                                }
                                            } else {
                                                zzibVar.zzaV().zze().zzc("No number filter for double param. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzh));
                                                break;
                                            }
                                        } else if (v instanceof String) {
                                            if (zzfhVar2.zza()) {
                                                zzi = zzf((String) v, zzfhVar2.zzb(), zzibVar.zzaV());
                                            } else if (zzfhVar2.zzc()) {
                                                String str2 = (String) v;
                                                if (zzpj.zzm(str2)) {
                                                    zzi = zzi(str2, zzfhVar2.zzd());
                                                } else {
                                                    zzibVar.zzaV().zze().zzc("Invalid param value for number filter. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzh));
                                                    break;
                                                }
                                            } else {
                                                zzibVar.zzaV().zze().zzc("No filter for String param. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzh));
                                                break;
                                            }
                                            if (zzi == null) {
                                                break;
                                            } else if (zzi.booleanValue() == z2) {
                                                bool = false;
                                                break;
                                            }
                                        } else if (v == 0) {
                                            zzibVar.zzaV().zzk().zzc("Missing param for filter. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzh));
                                            bool = false;
                                        } else {
                                            zzibVar.zzaV().zze().zzc("Unknown param type. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzh));
                                        }
                                    } else {
                                        zzibVar.zzaV().zze().zzb("Event has empty param name. event", zzibVar.zzl().zza(zzd));
                                        break;
                                    }
                                } else {
                                    bool = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            zzibVar.zzaV().zzk().zzb("Event filter result", bool != null ? AbstractJsonLexerKt.NULL : bool);
            if (bool != null) {
            }
        } else {
            zzibVar.zzaV().zzk().zzc("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzc), zzffVar.zza() ? Integer.valueOf(zzffVar.zzb()) : null);
            return true;
        }
    }
}
