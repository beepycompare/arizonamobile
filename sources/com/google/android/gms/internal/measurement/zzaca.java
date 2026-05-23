package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzaca;
import com.google.android.gms.internal.measurement.zzacb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzaca<MessageType extends zzacb<MessageType, BuilderType>, BuilderType extends zzaca<MessageType, BuilderType>> implements zzafb {
    private static void zza(List list, int i) {
        int size = list.size() - i;
        StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 26);
        sb.append("Element at index ");
        sb.append(size);
        sb.append(" is null.");
        String sb2 = sb.toString();
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 >= i) {
                list.remove(size2);
            } else {
                throw new NullPointerException(sb2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzaV(Iterable iterable, List list) {
        iterable.getClass();
        if (iterable instanceof zzaen) {
            List zza = ((zzaen) iterable).zza();
            zzaen zzaenVar = (zzaen) list;
            int size = list.size();
            for (Object obj : zza) {
                if (obj == null) {
                    int size2 = zzaenVar.size() - size;
                    StringBuilder sb = new StringBuilder(String.valueOf(size2).length() + 26);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    int size3 = zzaenVar.size();
                    while (true) {
                        size3--;
                        if (size3 < size) {
                            break;
                        }
                        zzaenVar.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                } else if (obj instanceof zzacr) {
                    zzacr zzacrVar = (zzacr) obj;
                    zzaenVar.zzb();
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    zzacr.zzj(bArr, 0, bArr.length);
                    zzaenVar.zzb();
                } else {
                    zzaenVar.add((String) obj);
                }
            }
        } else if (!(iterable instanceof zzafk)) {
            if (iterable instanceof Collection) {
                int size4 = ((Collection) iterable).size();
                if (list instanceof ArrayList) {
                    ((ArrayList) list).ensureCapacity(list.size() + size4);
                } else if (list instanceof zzafm) {
                    ((zzafm) list).zze(list.size() + size4);
                }
            }
            int size5 = list.size();
            if ((iterable instanceof List) && (iterable instanceof RandomAccess)) {
                List list2 = (List) iterable;
                int size6 = list2.size();
                for (int i = 0; i < size6; i++) {
                    Object obj2 = list2.get(i);
                    if (obj2 == null) {
                        zza(list, size5);
                    }
                    list.add(obj2);
                }
                return;
            }
            for (Object obj3 : iterable) {
                if (obj3 == null) {
                    zza(list, size5);
                }
                list.add(obj3);
            }
        } else {
            list.addAll((Collection) iterable);
        }
    }

    @Override // 
    /* renamed from: zzaS */
    public abstract zzaca clone();

    public zzaca zzaT(byte[] bArr, int i, int i2) throws zzaeh {
        throw null;
    }

    public zzaca zzaU(byte[] bArr, int i, int i2, zzadf zzadfVar) throws zzaeh {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzafb
    public final /* synthetic */ zzafb zzaW(byte[] bArr, zzadf zzadfVar) throws zzaeh {
        return zzaU(bArr, 0, bArr.length, zzadfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafb
    public final /* synthetic */ zzafb zzaX(byte[] bArr) throws zzaeh {
        return zzaT(bArr, 0, bArr.length);
    }
}
