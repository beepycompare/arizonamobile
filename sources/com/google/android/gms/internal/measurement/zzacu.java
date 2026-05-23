package com.google.android.gms.internal.measurement;

import androidx.media3.common.C;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzacu extends zzacv {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzacu(InputStream inputStream, int i, byte[] bArr) {
        super(null);
        this.zzl = Integer.MAX_VALUE;
        this.zze = inputStream;
        this.zzf = new byte[i < 8 ? 8 : i];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final void zzB() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = this.zzk + i;
        int i3 = this.zzl;
        if (i2 <= i3) {
            this.zzh = 0;
            return;
        }
        int i4 = i2 - i3;
        this.zzh = i4;
        this.zzg = i - i4;
    }

    private final void zzC(int i) throws IOException {
        if (zzI(i)) {
            return;
        }
        if (i <= (Integer.MAX_VALUE - this.zzk) - this.zzi) {
            throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzaeh("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
    }

    private final boolean zzI(int i) throws IOException {
        int i2 = this.zzi;
        int i3 = i2 + i;
        int i4 = this.zzg;
        if (i3 <= i4) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 66);
            sb.append("refillBuffer() called when ");
            sb.append(i);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        int i5 = this.zzk;
        if (i <= (Integer.MAX_VALUE - i5) - i2 && i5 + i2 + i <= this.zzl) {
            if (i2 > 0) {
                if (i4 > i2) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                i5 = this.zzk + i2;
                this.zzk = i5;
                i4 = this.zzg - i2;
                this.zzg = i4;
                this.zzi = 0;
            }
            InputStream inputStream = this.zze;
            byte[] bArr2 = this.zzf;
            try {
                int read = inputStream.read(bArr2, i4, Math.min(bArr2.length - i4, (Integer.MAX_VALUE - i5) - i4));
                if (read != 0 && read >= -1 && read <= this.zzf.length) {
                    if (read > 0) {
                        this.zzg += read;
                        zzB();
                        return this.zzg >= i || zzI(i);
                    }
                    return false;
                }
                String valueOf = String.valueOf(this.zze.getClass());
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(read).length() + 41);
                sb2.append(valueOf);
                sb2.append("#read(byte[]) returned invalid result: ");
                sb2.append(read);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            } catch (zzaeh e) {
                e.zza();
                throw e;
            }
        }
        return false;
    }

    private final byte[] zzJ(int i, boolean z) throws IOException {
        byte[] zzU = zzU(i);
        if (zzU != null) {
            return zzU;
        }
        int i2 = this.zzi;
        int i3 = this.zzg;
        int i4 = i3 - i2;
        this.zzk += i3;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzV = zzV(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, i2, bArr, 0, i4);
        for (byte[] bArr2 : zzV) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    private final byte[] zzU(int i) throws IOException {
        if (i == 0) {
            return zzaed.zza;
        }
        int i2 = this.zzk;
        int i3 = this.zzi;
        int i4 = i2 + i3 + i;
        if (C.RATE_UNSET_INT + i4 <= 0) {
            int i5 = this.zzl;
            if (i4 > i5) {
                zzL((i5 - i2) - i3);
                throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            int i6 = this.zzg - i3;
            int i7 = i - i6;
            if (i7 >= 4096) {
                try {
                    if (i7 > this.zze.available()) {
                        return null;
                    }
                } catch (zzaeh e) {
                    e.zza();
                    throw e;
                }
            }
            byte[] bArr = new byte[i];
            System.arraycopy(this.zzf, this.zzi, bArr, 0, i6);
            this.zzk += this.zzg;
            this.zzi = 0;
            this.zzg = 0;
            while (i6 < i) {
                try {
                    int read = this.zze.read(bArr, i6, i - i6);
                    if (read != -1) {
                        this.zzk += read;
                        i6 += read;
                    } else {
                        throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                    }
                } catch (zzaeh e2) {
                    e2.zza();
                    throw e2;
                }
            }
            return bArr;
        }
        throw new zzaeh("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
    }

    private final List zzV(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                try {
                    int read = this.zze.read(bArr, i2, min - i2);
                    if (read != -1) {
                        this.zzk += read;
                        i2 += read;
                    } else {
                        throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                    }
                } catch (zzaeh e) {
                    e.zza();
                    throw e;
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final byte zzA() throws IOException {
        if (this.zzi == this.zzg) {
            zzC(1);
        }
        byte[] bArr = this.zzf;
        int i = this.zzi;
        this.zzi = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final void zzE(int i) {
        this.zzl = i;
        zzB();
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final int zzF() {
        int i = this.zzl;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.zzk + this.zzi);
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final boolean zzG() throws IOException {
        return this.zzi == this.zzg && !zzI(1);
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final int zzH() {
        return this.zzk + this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final int zzK(byte[] bArr, int i, int i2) throws IOException {
        zzacv.zzT(bArr, i, i2);
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzg;
        int i4 = this.zzi;
        int i5 = i3 - i4;
        if (i5 > 0) {
            int min = Math.min(i2, i5);
            System.arraycopy(this.zzf, this.zzi, bArr, i, min);
            this.zzi += min;
            return min;
        }
        int min2 = Math.min(i2, (this.zzl - this.zzk) - i4);
        if (min2 <= 0) {
            return -1;
        }
        try {
            int read = this.zze.read(bArr, i, min2);
            if (read != -1) {
                this.zzk += read;
            }
            return read;
        } catch (zzaeh e) {
            e.zza();
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final void zzL(int i) throws IOException {
        int i2 = this.zzg;
        int i3 = this.zzi;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.zzi = i3 + i;
        } else if (i >= 0) {
            int i5 = this.zzk;
            int i6 = i5 + i3;
            int i7 = this.zzl;
            if (i6 + i > i7) {
                zzL((i7 - i5) - i3);
                throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.zzk = i6;
            this.zzg = 0;
            this.zzi = 0;
            while (i4 < i) {
                try {
                    long j = i - i4;
                    try {
                        long skip = this.zze.skip(j);
                        int i8 = (skip > 0L ? 1 : (skip == 0L ? 0 : -1));
                        if (i8 < 0 || skip > j) {
                            String valueOf = String.valueOf(this.zze.getClass());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31 + String.valueOf(skip).length() + 41);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        } else if (i8 == 0) {
                            break;
                        } else {
                            i4 += (int) skip;
                        }
                    } catch (zzaeh e) {
                        e.zza();
                        throw e;
                    }
                } finally {
                    this.zzk += i4;
                    zzB();
                }
            }
            if (i4 >= i) {
                return;
            }
            int i9 = this.zzg;
            int i10 = i9 - this.zzi;
            this.zzi = i9;
            zzC(1);
            while (true) {
                int i11 = i - i10;
                int i12 = this.zzg;
                if (i11 <= i12) {
                    this.zzi = i11;
                    return;
                }
                i10 += i12;
                this.zzi = i12;
                zzC(1);
            }
        } else {
            throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final int zza() throws IOException {
        if (zzG()) {
            this.zzj = 0;
            return 0;
        }
        int zzx = zzx();
        this.zzj = zzx;
        if ((zzx >>> 3) != 0) {
            return zzx;
        }
        throw new zzaeh("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final void zzb(int i) throws zzaeh {
        if (this.zzj != i) {
            throw new zzaeh("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final double zzd() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final float zze() throws IOException {
        return Float.intBitsToFloat(zzw());
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final long zzf() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final long zzg() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final int zzh() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final long zzi() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final int zzj() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final boolean zzk() throws IOException {
        return zzz() != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final String zzl() throws IOException {
        int zzx = zzx();
        if (zzx > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (zzx <= i - i2) {
                String str = new String(this.zzf, i2, zzx, StandardCharsets.UTF_8);
                this.zzi += zzx;
                return str;
            }
        }
        if (zzx == 0) {
            return "";
        }
        if (zzx >= 0) {
            if (zzx <= this.zzg) {
                zzC(zzx);
                String str2 = new String(this.zzf, this.zzi, zzx, StandardCharsets.UTF_8);
                this.zzi += zzx;
                return str2;
            }
            return new String(zzJ(zzx, false), StandardCharsets.UTF_8);
        }
        throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final String zzm() throws IOException {
        byte[] zzJ;
        int zzx = zzx();
        int i = this.zzi;
        int i2 = this.zzg;
        if (zzx <= i2 - i && zzx > 0) {
            zzJ = this.zzf;
            this.zzi = i + zzx;
        } else if (zzx == 0) {
            return "";
        } else {
            if (zzx < 0) {
                throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            i = 0;
            if (zzx <= i2) {
                zzC(zzx);
                zzJ = this.zzf;
                this.zzi = zzx;
            } else {
                zzJ = zzJ(zzx, false);
            }
        }
        return zzagl.zzd(zzJ, i, zzx);
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final zzacr zzn() throws IOException {
        int zzx = zzx();
        int i = this.zzg;
        int i2 = this.zzi;
        if (zzx <= i - i2 && zzx > 0) {
            zzacr zzk = zzacr.zzk(this.zzf, i2, zzx, false);
            this.zzi += zzx;
            return zzk;
        } else if (zzx == 0) {
            return zzacr.zza;
        } else {
            if (zzx < 0) {
                throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            byte[] zzU = zzU(zzx);
            if (zzU != null) {
                return zzacr.zzk(zzU, 0, zzU.length, false);
            }
            int i3 = this.zzi;
            int i4 = this.zzg;
            int i5 = i4 - i3;
            this.zzk += i4;
            this.zzi = 0;
            this.zzg = 0;
            List<byte[]> zzV = zzV(zzx - i5);
            byte[] bArr = new byte[zzx];
            System.arraycopy(this.zzf, i3, bArr, 0, i5);
            for (byte[] bArr2 : zzV) {
                int length = bArr2.length;
                System.arraycopy(bArr2, 0, bArr, i5, length);
                i5 += length;
            }
            zzacr zzacrVar = zzacr.zza;
            try {
                return zzacr.zzl(bArr, false);
            } catch (zzaeh e) {
                throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final byte[] zzo() throws IOException {
        int zzx = zzx();
        int i = this.zzg;
        int i2 = this.zzi;
        if (zzx > i - i2 || zzx <= 0) {
            if (zzx < 0) {
                throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            return zzJ(zzx, false);
        }
        byte[] copyOfRange = Arrays.copyOfRange(this.zzf, i2, i2 + zzx);
        this.zzi += zzx;
        return copyOfRange;
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final int zzp() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final int zzq() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final int zzr() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final long zzs() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final int zzt() throws IOException {
        return zzR(zzx());
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final long zzu() throws IOException {
        return zzS(zzz());
    }

    final long zzv() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzA = zzA();
            j |= (zzA & Byte.MAX_VALUE) << i;
            if ((zzA & 128) == 0) {
                return j;
            }
        }
        throw new zzaeh("CodedInputStream encountered a malformed varint.");
    }

    public final int zzw() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            zzC(4);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }

    public final long zzy() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzC(8);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        long j = bArr[i];
        long j2 = bArr[i + 2];
        long j3 = bArr[i + 3];
        return ((bArr[i + 6] & 255) << 48) | (j & 255) | ((bArr[i + 1] & 255) << 8) | ((j2 & 255) << 16) | ((j3 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 7] & 255) << 56);
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final int zzD(int i) throws zzaeh {
        if (i >= 0) {
            int i2 = i + this.zzk + this.zzi;
            if (i2 >= 0) {
                int i3 = this.zzl;
                if (i2 <= i3) {
                    this.zzl = i2;
                    zzB();
                    return i3;
                }
                throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            throw new zzaeh("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final int zzx() throws IOException {
        int i;
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (i3 != i2) {
            byte[] bArr = this.zzf;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzi = i4;
                return b;
            } else if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << Ascii.SO) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << Ascii.FS)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.zzi = i5;
                return i;
            }
        }
        return (int) zzv();
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final boolean zzc(int i) throws IOException {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzg - this.zzi >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzf;
                    int i4 = this.zzi;
                    this.zzi = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw new zzaeh("CodedInputStream encountered a malformed varint.");
            }
            while (i3 < 10) {
                if (zzA() < 0) {
                    i3++;
                }
            }
            throw new zzaeh("CodedInputStream encountered a malformed varint.");
            return true;
        } else if (i2 == 1) {
            zzL(8);
            return true;
        } else if (i2 == 2) {
            zzL(zzx());
            return true;
        } else if (i2 == 3) {
            zzQ();
            zzb(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            zzP();
            return false;
        } else if (i2 != 5) {
            throw new zzaeg("Protocol message tag had invalid wire type.");
        } else {
            zzL(4);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzacv
    public final long zzz() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzi;
        int i2 = this.zzg;
        if (i2 != i) {
            byte[] bArr = this.zzf;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzi = i3;
                return b;
            } else if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << Ascii.SO) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << Ascii.NAK);
                        if (i9 < 0) {
                            i4 = i8;
                            j = (-2080896) ^ i9;
                        } else {
                            i6 = i + 5;
                            long j4 = (bArr[i8] << 28) ^ i9;
                            if (j4 >= 0) {
                                j = j4 ^ 266354560;
                            } else {
                                i4 = i + 6;
                                long j5 = (bArr[i6] << 35) ^ j4;
                                if (j5 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    int i10 = i + 7;
                                    long j6 = j5 ^ (bArr[i4] << 42);
                                    if (j6 >= 0) {
                                        j2 = 4363953127296L;
                                    } else {
                                        i4 = i + 8;
                                        j5 = j6 ^ (bArr[i10] << 49);
                                        if (j5 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i10 = i + 9;
                                            j6 = j5 ^ (bArr[i4] << 56);
                                            if (j6 >= 0) {
                                                j2 = 71499008037633920L;
                                            } else {
                                                i4 = i + 10;
                                                long j7 = j6 ^ (bArr[i10] << 63);
                                                if (j7 >= 0) {
                                                    j = j7 ^ (-9151873028817141888L);
                                                }
                                            }
                                        }
                                    }
                                    j = j6 ^ j2;
                                    i4 = i10;
                                }
                                j = j5 ^ j3;
                            }
                        }
                    }
                    i4 = i6;
                }
                this.zzi = i4;
                return j;
            }
        }
        return zzv();
    }
}
