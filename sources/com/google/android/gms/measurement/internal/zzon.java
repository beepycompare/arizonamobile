package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzon extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzon> CREATOR = new zzoo();
    public final List zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzon(List list) {
        this.zza = list;
    }

    public static zzon zza(zzlr... zzlrVarArr) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(zzlrVarArr[0].zza()));
        return new zzon(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        List list = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, list, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
