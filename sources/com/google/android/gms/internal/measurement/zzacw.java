package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzacw implements zzafo {
    private final zzacv zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzacw(zzacv zzacvVar) {
        this.zza = zzacvVar;
        zzacvVar.zzd = this;
    }

    private final void zzQ(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw new zzaeg("Protocol message tag had invalid wire type.");
        }
    }

    private final void zzR(Object obj, zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        zzacv zzacvVar = this.zza;
        int zzp = zzacvVar.zzp();
        zzacvVar.zzO();
        int zzD = zzacvVar.zzD(zzp);
        zzacvVar.zza++;
        zzafpVar.zzg(obj, this, zzadfVar);
        zzacvVar.zzb(0);
        zzacvVar.zza--;
        zzacvVar.zzE(zzD);
    }

    private final Object zzS(zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        Object zza = zzafpVar.zza();
        zzR(zza, zzafpVar, zzadfVar);
        zzafpVar.zzk(zza);
        return zza;
    }

    private final void zzT(Object obj, zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzafpVar.zzg(obj, this, zzadfVar);
            if (this.zzb == this.zzc) {
                return;
            }
            throw new zzaeh("Failed to parse the message.");
        } finally {
            this.zzc = i;
        }
    }

    private final Object zzU(zzagm zzagmVar, Class cls, zzadf zzadfVar) throws IOException {
        zzagm zzagmVar2 = zzagm.DOUBLE;
        switch (zzagmVar.ordinal()) {
            case 0:
                return Double.valueOf(zze());
            case 1:
                return Float.valueOf(zzf());
            case 2:
                return Long.valueOf(zzh());
            case 3:
                return Long.valueOf(zzg());
            case 4:
                return Integer.valueOf(zzi());
            case 5:
                return Long.valueOf(zzj());
            case 6:
                return Integer.valueOf(zzk());
            case 7:
                return Boolean.valueOf(zzl());
            case 8:
                return zzn();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                zzQ(2);
                return zzS(zzafl.zza().zzb(cls), zzadfVar);
            case 11:
                return zzq();
            case 12:
                return Integer.valueOf(zzr());
            case 13:
                return Integer.valueOf(zzs());
            case 14:
                return Integer.valueOf(zzt());
            case 15:
                return Long.valueOf(zzu());
            case 16:
                return Integer.valueOf(zzv());
            case 17:
                return Long.valueOf(zzw());
        }
    }

    private final void zzV(int i) throws IOException {
        if (this.zza.zzH() != i) {
            throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private static final void zzW(int i) throws IOException {
        if ((i & 3) != 0) {
            throw new zzaeh("Failed to parse the message.");
        }
    }

    private static final void zzX(int i) throws IOException {
        if ((i & 7) != 0) {
            throw new zzaeh("Failed to parse the message.");
        }
    }

    public static zzacw zza(zzacv zzacvVar) {
        Object obj = zzacvVar.zzd;
        return obj != null ? (zzacw) obj : new zzacw(zzacvVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzA(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzaeq) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int zzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzaeqVar.zzf(zzacvVar.zzg());
                } while (zzacvVar.zzH() < zzH);
                zzV(zzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzg());
                if (zzacvVar2.zzG()) {
                    return;
                }
                i = zzacvVar2.zza();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int zzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Long.valueOf(zzacvVar3.zzg()));
                } while (zzacvVar3.zzH() < zzH2);
                zzV(zzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzg()));
                if (zzacvVar4.zzG()) {
                    return;
                }
                zza = zzacvVar4.zza();
            } while (zza == this.zzb);
            i = zza;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzB(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzadv) {
            zzadv zzadvVar = (zzadv) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int zzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzadvVar.zzh(zzacvVar.zzh());
                } while (zzacvVar.zzH() < zzH);
                zzV(zzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzh());
                if (zzacvVar2.zzG()) {
                    return;
                }
                i = zzacvVar2.zza();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int zzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzh()));
                } while (zzacvVar3.zzH() < zzH2);
                zzV(zzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzh()));
                if (zzacvVar4.zzG()) {
                    return;
                }
                zza = zzacvVar4.zza();
            } while (zza == this.zzb);
            i = zza;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzC(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzaeq) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int zzp = zzacvVar.zzp();
                zzX(zzp);
                int zzH = zzp + zzacvVar.zzH();
                do {
                    zzaeqVar.zzf(zzacvVar.zzi());
                } while (zzacvVar.zzH() < zzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzi());
                if (zzacvVar2.zzG()) {
                    return;
                }
                i = zzacvVar2.zza();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int zzp2 = zzacvVar3.zzp();
                zzX(zzp2);
                int zzH2 = zzp2 + zzacvVar3.zzH();
                do {
                    list.add(Long.valueOf(zzacvVar3.zzi()));
                } while (zzacvVar3.zzH() < zzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzi()));
                if (zzacvVar4.zzG()) {
                    return;
                }
                zza = zzacvVar4.zza();
            } while (zza == this.zzb);
            i = zza;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzD(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzadv) {
            zzadv zzadvVar = (zzadv) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzacv zzacvVar = this.zza;
                int zzp = zzacvVar.zzp();
                zzW(zzp);
                int zzH = zzacvVar.zzH() + zzp;
                do {
                    zzadvVar.zzh(zzacvVar.zzj());
                } while (zzacvVar.zzH() < zzH);
                return;
            } else if (i2 != 5) {
                throw new zzaeg("Protocol message tag had invalid wire type.");
            } else {
                do {
                    zzacv zzacvVar2 = this.zza;
                    zzadvVar.zzh(zzacvVar2.zzj());
                    if (zzacvVar2.zzG()) {
                        return;
                    }
                    i = zzacvVar2.zza();
                } while (i == this.zzb);
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                zzacv zzacvVar3 = this.zza;
                int zzp2 = zzacvVar3.zzp();
                zzW(zzp2);
                int zzH2 = zzacvVar3.zzH() + zzp2;
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzj()));
                } while (zzacvVar3.zzH() < zzH2);
                return;
            } else if (i3 != 5) {
                throw new zzaeg("Protocol message tag had invalid wire type.");
            } else {
                do {
                    zzacv zzacvVar4 = this.zza;
                    list.add(Integer.valueOf(zzacvVar4.zzj()));
                    if (zzacvVar4.zzG()) {
                        return;
                    }
                    zza = zzacvVar4.zza();
                } while (zza == this.zzb);
                i = zza;
            }
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzE(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzaci) {
            zzaci zzaciVar = (zzaci) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int zzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzaciVar.zzf(zzacvVar.zzk());
                } while (zzacvVar.zzH() < zzH);
                zzV(zzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaciVar.zzf(zzacvVar2.zzk());
                if (zzacvVar2.zzG()) {
                    return;
                }
                i = zzacvVar2.zza();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int zzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Boolean.valueOf(zzacvVar3.zzk()));
                } while (zzacvVar3.zzH() < zzH2);
                zzV(zzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Boolean.valueOf(zzacvVar4.zzk()));
                if (zzacvVar4.zzG()) {
                    return;
                }
                zza = zzacvVar4.zza();
            } while (zza == this.zzb);
            i = zza;
        }
        this.zzd = i;
    }

    public final void zzF(List list, boolean z) throws IOException {
        int zza;
        int i;
        if ((this.zzb & 7) == 2) {
            if ((list instanceof zzaen) && !z) {
                zzaen zzaenVar = (zzaen) list;
                do {
                    zzq();
                    zzaenVar.zzb();
                    zzacv zzacvVar = this.zza;
                    if (zzacvVar.zzG()) {
                        return;
                    }
                    i = zzacvVar.zza();
                } while (i == this.zzb);
            } else {
                do {
                    list.add(z ? zzn() : zzm());
                    zzacv zzacvVar2 = this.zza;
                    if (zzacvVar2.zzG()) {
                        return;
                    }
                    zza = zzacvVar2.zza();
                } while (zza == this.zzb);
                i = zza;
            }
            this.zzd = i;
            return;
        }
        throw new zzaeg("Protocol message tag had invalid wire type.");
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzG(List list, zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        int zza;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                list.add(zzS(zzafpVar, zzadfVar));
                zzacv zzacvVar = this.zza;
                if (zzacvVar.zzG() || this.zzd != 0) {
                    return;
                }
                zza = zzacvVar.zza();
            } while (zza == i);
            this.zzd = zza;
            return;
        }
        throw new zzaeg("Protocol message tag had invalid wire type.");
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    @Deprecated
    public final void zzH(List list, zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        int zza;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                Object zza2 = zzafpVar.zza();
                zzT(zza2, zzafpVar, zzadfVar);
                zzafpVar.zzk(zza2);
                list.add(zza2);
                zzacv zzacvVar = this.zza;
                if (zzacvVar.zzG() || this.zzd != 0) {
                    return;
                }
                zza = zzacvVar.zza();
            } while (zza == i);
            this.zzd = zza;
            return;
        }
        throw new zzaeg("Protocol message tag had invalid wire type.");
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzJ(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzadv) {
            zzadv zzadvVar = (zzadv) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int zzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzadvVar.zzh(zzacvVar.zzp());
                } while (zzacvVar.zzH() < zzH);
                zzV(zzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzp());
                if (zzacvVar2.zzG()) {
                    return;
                }
                i = zzacvVar2.zza();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int zzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzp()));
                } while (zzacvVar3.zzH() < zzH2);
                zzV(zzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzp()));
                if (zzacvVar4.zzG()) {
                    return;
                }
                zza = zzacvVar4.zza();
            } while (zza == this.zzb);
            i = zza;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzK(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzadv) {
            zzadv zzadvVar = (zzadv) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int zzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzadvVar.zzh(zzacvVar.zzq());
                } while (zzacvVar.zzH() < zzH);
                zzV(zzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzq());
                if (zzacvVar2.zzG()) {
                    return;
                }
                i = zzacvVar2.zza();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int zzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzq()));
                } while (zzacvVar3.zzH() < zzH2);
                zzV(zzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzq()));
                if (zzacvVar4.zzG()) {
                    return;
                }
                zza = zzacvVar4.zza();
            } while (zza == this.zzb);
            i = zza;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzL(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzadv) {
            zzadv zzadvVar = (zzadv) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzacv zzacvVar = this.zza;
                int zzp = zzacvVar.zzp();
                zzW(zzp);
                int zzH = zzacvVar.zzH() + zzp;
                do {
                    zzadvVar.zzh(zzacvVar.zzr());
                } while (zzacvVar.zzH() < zzH);
                return;
            } else if (i2 != 5) {
                throw new zzaeg("Protocol message tag had invalid wire type.");
            } else {
                do {
                    zzacv zzacvVar2 = this.zza;
                    zzadvVar.zzh(zzacvVar2.zzr());
                    if (zzacvVar2.zzG()) {
                        return;
                    }
                    i = zzacvVar2.zza();
                } while (i == this.zzb);
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                zzacv zzacvVar3 = this.zza;
                int zzp2 = zzacvVar3.zzp();
                zzW(zzp2);
                int zzH2 = zzacvVar3.zzH() + zzp2;
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzr()));
                } while (zzacvVar3.zzH() < zzH2);
                return;
            } else if (i3 != 5) {
                throw new zzaeg("Protocol message tag had invalid wire type.");
            } else {
                do {
                    zzacv zzacvVar4 = this.zza;
                    list.add(Integer.valueOf(zzacvVar4.zzr()));
                    if (zzacvVar4.zzG()) {
                        return;
                    }
                    zza = zzacvVar4.zza();
                } while (zza == this.zzb);
                i = zza;
            }
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzM(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzaeq) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int zzp = zzacvVar.zzp();
                zzX(zzp);
                int zzH = zzp + zzacvVar.zzH();
                do {
                    zzaeqVar.zzf(zzacvVar.zzs());
                } while (zzacvVar.zzH() < zzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzs());
                if (zzacvVar2.zzG()) {
                    return;
                }
                i = zzacvVar2.zza();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int zzp2 = zzacvVar3.zzp();
                zzX(zzp2);
                int zzH2 = zzp2 + zzacvVar3.zzH();
                do {
                    list.add(Long.valueOf(zzacvVar3.zzs()));
                } while (zzacvVar3.zzH() < zzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzs()));
                if (zzacvVar4.zzG()) {
                    return;
                }
                zza = zzacvVar4.zza();
            } while (zza == this.zzb);
            i = zza;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzN(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzadv) {
            zzadv zzadvVar = (zzadv) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int zzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzadvVar.zzh(zzacvVar.zzt());
                } while (zzacvVar.zzH() < zzH);
                zzV(zzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadvVar.zzh(zzacvVar2.zzt());
                if (zzacvVar2.zzG()) {
                    return;
                }
                i = zzacvVar2.zza();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int zzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzacvVar3.zzt()));
                } while (zzacvVar3.zzH() < zzH2);
                zzV(zzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Integer.valueOf(zzacvVar4.zzt()));
                if (zzacvVar4.zzG()) {
                    return;
                }
                zza = zzacvVar4.zza();
            } while (zza == this.zzb);
            i = zza;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzO(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzaeq) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int zzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzaeqVar.zzf(zzacvVar.zzu());
                } while (zzacvVar.zzH() < zzH);
                zzV(zzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzu());
                if (zzacvVar2.zzG()) {
                    return;
                }
                i = zzacvVar2.zza();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int zzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Long.valueOf(zzacvVar3.zzu()));
                } while (zzacvVar3.zzH() < zzH2);
                zzV(zzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzu()));
                if (zzacvVar4.zzG()) {
                    return;
                }
                zza = zzacvVar4.zza();
            } while (zza == this.zzb);
            i = zza;
        }
        this.zzd = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
        r10.put(r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
        return;
     */
    @Override // com.google.android.gms.internal.measurement.zzafo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzP(Map map, zzaeu zzaeuVar, zzadf zzadfVar) throws IOException {
        zzQ(2);
        zzacv zzacvVar = this.zza;
        int zzD = zzacvVar.zzD(zzacvVar.zzp());
        Object obj = zzaeuVar.zzd;
        Object obj2 = zzaeuVar.zzb;
        Object obj3 = obj;
        while (true) {
            try {
                int zzb = zzb();
                if (zzb == Integer.MAX_VALUE || zzacvVar.zzG()) {
                    break;
                } else if (zzb == 1) {
                    obj2 = zzU(zzaeuVar.zza, null, null);
                } else if (zzb == 2) {
                    obj3 = zzU(zzaeuVar.zzc, obj.getClass(), zzadfVar);
                } else {
                    try {
                        if (!zzd()) {
                            throw new zzaeh("Unable to parse map entry.");
                            break;
                        }
                    } catch (zzaeg e) {
                        if (!zzd()) {
                            throw new zzaeh("Unable to parse map entry.", e);
                        }
                    }
                }
            } finally {
                this.zza.zzE(zzD);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzb() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zza();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzc() {
        return this.zzb;
    }

    public final boolean zzd() throws IOException {
        int i;
        zzacv zzacvVar = this.zza;
        if (zzacvVar.zzG() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return zzacvVar.zzc(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final double zze() throws IOException {
        zzQ(1);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final float zzf() throws IOException {
        zzQ(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzg() throws IOException {
        zzQ(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzh() throws IOException {
        zzQ(0);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzi() throws IOException {
        zzQ(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzj() throws IOException {
        zzQ(1);
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzk() throws IOException {
        zzQ(5);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final boolean zzl() throws IOException {
        zzQ(0);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final String zzm() throws IOException {
        zzQ(2);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final String zzn() throws IOException {
        zzQ(2);
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzo(Object obj, zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        zzQ(2);
        zzR(obj, zzafpVar, zzadfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzp(Object obj, zzafp zzafpVar, zzadf zzadfVar) throws IOException {
        zzQ(3);
        zzT(obj, zzafpVar, zzadfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final zzacr zzq() throws IOException {
        zzQ(2);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzr() throws IOException {
        zzQ(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzs() throws IOException {
        zzQ(0);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzt() throws IOException {
        zzQ(5);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzu() throws IOException {
        zzQ(1);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final int zzv() throws IOException {
        zzQ(0);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final long zzw() throws IOException {
        zzQ(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzx(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzadc) {
            zzadc zzadcVar = (zzadc) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int zzp = zzacvVar.zzp();
                zzX(zzp);
                int zzH = zzp + zzacvVar.zzH();
                do {
                    zzadcVar.zzf(zzacvVar.zzd());
                } while (zzacvVar.zzH() < zzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzadcVar.zzf(zzacvVar2.zzd());
                if (zzacvVar2.zzG()) {
                    return;
                }
                i = zzacvVar2.zza();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int zzp2 = zzacvVar3.zzp();
                zzX(zzp2);
                int zzH2 = zzp2 + zzacvVar3.zzH();
                do {
                    list.add(Double.valueOf(zzacvVar3.zzd()));
                } while (zzacvVar3.zzH() < zzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Double.valueOf(zzacvVar4.zzd()));
                if (zzacvVar4.zzG()) {
                    return;
                }
                zza = zzacvVar4.zza();
            } while (zza == this.zzb);
            i = zza;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzy(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzadm) {
            zzadm zzadmVar = (zzadm) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzacv zzacvVar = this.zza;
                int zzp = zzacvVar.zzp();
                zzW(zzp);
                int zzH = zzacvVar.zzH() + zzp;
                do {
                    zzadmVar.zzf(zzacvVar.zze());
                } while (zzacvVar.zzH() < zzH);
                return;
            } else if (i2 != 5) {
                throw new zzaeg("Protocol message tag had invalid wire type.");
            } else {
                do {
                    zzacv zzacvVar2 = this.zza;
                    zzadmVar.zzf(zzacvVar2.zze());
                    if (zzacvVar2.zzG()) {
                        return;
                    }
                    i = zzacvVar2.zza();
                } while (i == this.zzb);
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                zzacv zzacvVar3 = this.zza;
                int zzp2 = zzacvVar3.zzp();
                zzW(zzp2);
                int zzH2 = zzacvVar3.zzH() + zzp2;
                do {
                    list.add(Float.valueOf(zzacvVar3.zze()));
                } while (zzacvVar3.zzH() < zzH2);
                return;
            } else if (i3 != 5) {
                throw new zzaeg("Protocol message tag had invalid wire type.");
            } else {
                do {
                    zzacv zzacvVar4 = this.zza;
                    list.add(Float.valueOf(zzacvVar4.zze()));
                    if (zzacvVar4.zzG()) {
                        return;
                    }
                    zza = zzacvVar4.zza();
                } while (zza == this.zzb);
                i = zza;
            }
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzz(List list) throws IOException {
        int zza;
        int i;
        if (list instanceof zzaeq) {
            zzaeq zzaeqVar = (zzaeq) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar = this.zza;
                int zzH = zzacvVar.zzH() + zzacvVar.zzp();
                do {
                    zzaeqVar.zzf(zzacvVar.zzf());
                } while (zzacvVar.zzH() < zzH);
                zzV(zzH);
                return;
            }
            do {
                zzacv zzacvVar2 = this.zza;
                zzaeqVar.zzf(zzacvVar2.zzf());
                if (zzacvVar2.zzG()) {
                    return;
                }
                i = zzacvVar2.zza();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzaeg("Protocol message tag had invalid wire type.");
                }
                zzacv zzacvVar3 = this.zza;
                int zzH2 = zzacvVar3.zzH() + zzacvVar3.zzp();
                do {
                    list.add(Long.valueOf(zzacvVar3.zzf()));
                } while (zzacvVar3.zzH() < zzH2);
                zzV(zzH2);
                return;
            }
            do {
                zzacv zzacvVar4 = this.zza;
                list.add(Long.valueOf(zzacvVar4.zzf()));
                if (zzacvVar4.zzG()) {
                    return;
                }
                zza = zzacvVar4.zza();
            } while (zza == this.zzb);
            i = zza;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzafo
    public final void zzI(List list) throws IOException {
        int zza;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzq());
                zzacv zzacvVar = this.zza;
                if (zzacvVar.zzG()) {
                    return;
                }
                zza = zzacvVar.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
            return;
        }
        throw new zzaeg("Protocol message tag had invalid wire type.");
    }
}
