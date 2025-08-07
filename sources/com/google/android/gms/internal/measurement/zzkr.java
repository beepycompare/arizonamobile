package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkr;
import com.google.android.gms.internal.measurement.zzks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzkr<MessageType extends zzks<MessageType, BuilderType>, BuilderType extends zzkr<MessageType, BuilderType>> implements zznl {
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
    public static void zzaU(Iterable iterable, List list) {
        byte[] bArr = zzmp.zzb;
        iterable.getClass();
        if (iterable instanceof zzmx) {
            List zza = ((zzmx) iterable).zza();
            zzmx zzmxVar = (zzmx) list;
            int size = list.size();
            for (Object obj : zza) {
                if (obj == null) {
                    int size2 = zzmxVar.size() - size;
                    StringBuilder sb = new StringBuilder(String.valueOf(size2).length() + 26);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    int size3 = zzmxVar.size();
                    while (true) {
                        size3--;
                        if (size3 < size) {
                            break;
                        }
                        zzmxVar.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                } else if (obj instanceof zzlh) {
                    zzlh zzlhVar = (zzlh) obj;
                    zzmxVar.zzb();
                } else if (obj instanceof byte[]) {
                    byte[] bArr2 = (byte[]) obj;
                    zzlh.zzh(bArr2, 0, bArr2.length);
                    zzmxVar.zzb();
                } else {
                    zzmxVar.add((String) obj);
                }
            }
        } else if (!(iterable instanceof zznt)) {
            if (iterable instanceof Collection) {
                int size4 = ((Collection) iterable).size();
                if (list instanceof ArrayList) {
                    ((ArrayList) list).ensureCapacity(list.size() + size4);
                } else if (list instanceof zznv) {
                    ((zznv) list).zze(list.size() + size4);
                }
            }
            int size5 = list.size();
            if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
                for (Object obj2 : iterable) {
                    if (obj2 == null) {
                        zza(list, size5);
                    }
                    list.add(obj2);
                }
                return;
            }
            List list2 = (List) iterable;
            int size6 = list2.size();
            for (int i = 0; i < size6; i++) {
                Object obj3 = list2.get(i);
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
    /* renamed from: zzaR */
    public abstract zzkr clone();

    public zzkr zzaS(byte[] bArr, int i, int i2) throws zzmr {
        throw null;
    }

    public zzkr zzaT(byte[] bArr, int i, int i2, zzlr zzlrVar) throws zzmr {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final /* synthetic */ zznl zzaV(byte[] bArr, zzlr zzlrVar) throws zzmr {
        return zzaT(bArr, 0, bArr.length, zzlrVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final /* synthetic */ zznl zzaW(byte[] bArr) throws zzmr {
        return zzaS(bArr, 0, bArr.length);
    }
}
