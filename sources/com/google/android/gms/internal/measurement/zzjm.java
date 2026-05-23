package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzjm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        byte[] bArr = null;
        byte[][] bArr2 = null;
        byte[][] bArr3 = null;
        byte[][] bArr4 = null;
        byte[][] bArr5 = null;
        int[] iArr = null;
        byte[][] bArr6 = null;
        int[] iArr2 = null;
        byte[][] bArr7 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 4:
                    bArr2 = SafeParcelReader.createByteArrayArray(parcel, readHeader);
                    break;
                case 5:
                    bArr3 = SafeParcelReader.createByteArrayArray(parcel, readHeader);
                    break;
                case 6:
                    bArr4 = SafeParcelReader.createByteArrayArray(parcel, readHeader);
                    break;
                case 7:
                    bArr5 = SafeParcelReader.createByteArrayArray(parcel, readHeader);
                    break;
                case 8:
                    iArr = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 9:
                    bArr6 = SafeParcelReader.createByteArrayArray(parcel, readHeader);
                    break;
                case 10:
                    iArr2 = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 11:
                    bArr7 = SafeParcelReader.createByteArrayArray(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzjl(str, bArr, bArr2, bArr3, bArr4, bArr5, iArr, bArr6, iArr2, bArr7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzjl[i];
    }
}
