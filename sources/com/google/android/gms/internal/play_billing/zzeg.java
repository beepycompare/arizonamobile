package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzef;
import com.google.android.gms.internal.play_billing.zzeg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public abstract class zzeg<MessageType extends zzeg<MessageType, BuilderType>, BuilderType extends zzef<MessageType, BuilderType>> implements zzhb {
    protected transient int zza = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzk(Iterable iterable, List list) {
        byte[] bArr = zzga.zzb;
        int size = ((Collection) iterable).size();
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + size);
        } else if (list instanceof zzhj) {
            ((zzhj) list).zzf(list.size() + size);
        }
        int size2 = list.size();
        List list2 = (List) iterable;
        int size3 = list2.size();
        for (int i = 0; i < size3; i++) {
            Object obj = list2.get(i);
            if (obj != null) {
                list.add(obj);
            } else {
                String str = "Element at index " + (list.size() - size2) + " is null.";
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size2) {
                        break;
                    }
                    list.remove(size4);
                }
                throw new NullPointerException(str);
            }
        }
    }

    public final byte[] zzQ() {
        try {
            int zzn = zzn();
            byte[] bArr = new byte[zzn];
            int i = zzfc.zzb;
            zzez zzezVar = new zzez(bArr, 0, zzn);
            zzD(zzezVar);
            zzezVar.zzA();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzi(zzhl zzhlVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhb
    public final zzev zzj() {
        try {
            int zzn = zzn();
            zzev zzevVar = zzev.zza;
            byte[] bArr = new byte[zzn];
            int i = zzfc.zzb;
            zzez zzezVar = new zzez(bArr, 0, zzn);
            zzD(zzezVar);
            return zzer.zza(zzezVar, bArr);
        } catch (IOException e) {
            String name = this.getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e);
        }
    }
}
