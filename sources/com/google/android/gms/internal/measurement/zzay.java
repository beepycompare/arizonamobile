package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzay extends zzav {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzay() {
        this.zza.add(zzbk.APPLY);
        this.zza.add(zzbk.BLOCK);
        this.zza.add(zzbk.BREAK);
        this.zza.add(zzbk.CASE);
        this.zza.add(zzbk.DEFAULT);
        this.zza.add(zzbk.CONTINUE);
        this.zza.add(zzbk.DEFINE_FUNCTION);
        this.zza.add(zzbk.FN);
        this.zza.add(zzbk.IF);
        this.zza.add(zzbk.QUOTE);
        this.zza.add(zzbk.RETURN);
        this.zza.add(zzbk.SWITCH);
        this.zza.add(zzbk.TERNARY);
    }

    private static zzao zzc(zzg zzgVar, List list) {
        zzh.zzb(zzbk.FN.name(), 2, list);
        zzao zza = zzgVar.zza((zzao) list.get(0));
        zzao zza2 = zzgVar.zza((zzao) list.get(1));
        if (!(zza2 instanceof zzae)) {
            throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", zza2.getClass().getCanonicalName()));
        }
        List zzb = ((zzae) zza2).zzb();
        List arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new zzan(zza.zzc(), zzb, arrayList, zzgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String str, zzg zzgVar, List list) {
        zzao zzb;
        zzbk zzbkVar = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 2) {
            zzh.zza(zzbk.APPLY.name(), 3, list);
            zzao zza = zzgVar.zza((zzao) list.get(0));
            String zzc = zzgVar.zza((zzao) list.get(1)).zzc();
            zzao zza2 = zzgVar.zza((zzao) list.get(2));
            if (!(zza2 instanceof zzae)) {
                throw new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", zza2.getClass().getCanonicalName()));
            }
            if (zzc.isEmpty()) {
                throw new IllegalArgumentException("Function name for apply is undefined");
            }
            return zza.zzcA(zzc, zzgVar, ((zzae) zza2).zzb());
        } else if (ordinal == 15) {
            zzh.zza(zzbk.BREAK.name(), 0, list);
            return zzao.zzh;
        } else if (ordinal != 25) {
            if (ordinal == 41) {
                zzh.zzb(zzbk.IF.name(), 2, list);
                zzao zza3 = zzgVar.zza((zzao) list.get(0));
                zzao zza4 = zzgVar.zza((zzao) list.get(1));
                zzao zza5 = list.size() > 2 ? zzgVar.zza((zzao) list.get(2)) : null;
                zzao zzaoVar = zzao.zzf;
                if (zza3.zze().booleanValue()) {
                    zzb = zzgVar.zzb((zzae) zza4);
                } else {
                    zzb = zza5 != null ? zzgVar.zzb((zzae) zza5) : zzaoVar;
                }
                return true != (zzb instanceof zzag) ? zzaoVar : zzb;
            } else if (ordinal != 54) {
                if (ordinal != 57) {
                    if (ordinal != 19) {
                        if (ordinal == 20) {
                            zzh.zzb(zzbk.DEFINE_FUNCTION.name(), 2, list);
                            zzan zzanVar = (zzan) zzc(zzgVar, list);
                            if (zzanVar.zzg() == null) {
                                zzgVar.zze("", zzanVar);
                                return zzanVar;
                            }
                            zzgVar.zze(zzanVar.zzg(), zzanVar);
                            return zzanVar;
                        } else if (ordinal == 60) {
                            zzh.zza(zzbk.SWITCH.name(), 3, list);
                            zzao zza6 = zzgVar.zza((zzao) list.get(0));
                            zzao zza7 = zzgVar.zza((zzao) list.get(1));
                            zzao zza8 = zzgVar.zza((zzao) list.get(2));
                            if (zza7 instanceof zzae) {
                                if (!(zza8 instanceof zzae)) {
                                    throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                                }
                                zzae zzaeVar = (zzae) zza7;
                                zzae zzaeVar2 = (zzae) zza8;
                                boolean z = false;
                                for (int i = 0; i < zzaeVar.zzh(); i++) {
                                    if (z || zza6.equals(zzgVar.zza(zzaeVar.zzl(i)))) {
                                        zzao zza9 = zzgVar.zza(zzaeVar2.zzl(i));
                                        if (zza9 instanceof zzag) {
                                            return ((zzag) zza9).zzg().equals("break") ? zzao.zzf : zza9;
                                        }
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                }
                                if (zzaeVar.zzh() + 1 == zzaeVar2.zzh()) {
                                    zzao zza10 = zzgVar.zza(zzaeVar2.zzl(zzaeVar.zzh()));
                                    if (zza10 instanceof zzag) {
                                        String zzg = ((zzag) zza10).zzg();
                                        if (zzg.equals("return") || zzg.equals("continue")) {
                                            return zza10;
                                        }
                                    }
                                }
                                return zzao.zzf;
                            }
                            throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                        } else if (ordinal != 61) {
                            switch (ordinal) {
                                case 11:
                                    return zzgVar.zzc().zzb(new zzae(list));
                                case 12:
                                    zzh.zza(zzbk.BREAK.name(), 0, list);
                                    return zzao.zzi;
                                case 13:
                                    break;
                                default:
                                    return super.zzb(str);
                            }
                        } else {
                            zzh.zza(zzbk.TERNARY.name(), 3, list);
                            if (zzgVar.zza((zzao) list.get(0)).zze().booleanValue()) {
                                return zzgVar.zza((zzao) list.get(1));
                            }
                            return zzgVar.zza((zzao) list.get(2));
                        }
                    }
                    if (list.isEmpty()) {
                        return zzao.zzf;
                    }
                    zzao zza11 = zzgVar.zza((zzao) list.get(0));
                    if (zza11 instanceof zzae) {
                        return zzgVar.zzb((zzae) zza11);
                    }
                    return zzao.zzf;
                } else if (list.isEmpty()) {
                    return zzao.zzj;
                } else {
                    zzh.zza(zzbk.RETURN.name(), 1, list);
                    return new zzag("return", zzgVar.zza((zzao) list.get(0)));
                }
            } else {
                return new zzae(list);
            }
        } else {
            return zzc(zzgVar, list);
        }
    }
}
