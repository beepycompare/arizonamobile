package androidx.media3.datasource;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public final class AesFlushingCipher {
    private final int blockSize;
    private final Cipher cipher;
    private final byte[] flushedBlock;
    private int pendingXorBytes;
    private final byte[] zerosBlock;

    public AesFlushingCipher(int i, byte[] bArr, String str, long j) {
        this(i, bArr, getFNV64Hash(str), j);
    }

    public AesFlushingCipher(int i, byte[] bArr, long j, long j2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            this.cipher = cipher;
            int blockSize = cipher.getBlockSize();
            this.blockSize = blockSize;
            this.zerosBlock = new byte[blockSize];
            this.flushedBlock = new byte[blockSize];
            long j3 = j2 / blockSize;
            int i2 = (int) (j2 % blockSize);
            cipher.init(i, new SecretKeySpec(bArr, Util.splitAtFirst(cipher.getAlgorithm(), RemoteSettings.FORWARD_SLASH_STRING)[0]), new IvParameterSpec(getInitializationVector(j, j3)));
            if (i2 != 0) {
                updateInPlace(new byte[i2], 0, i2);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateInPlace(byte[] bArr, int i, int i2) {
        update(bArr, i, i2, bArr, i);
    }

    public void update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        do {
            int i7 = this.pendingXorBytes;
            if (i7 > 0) {
                bArr2[i6] = (byte) (bArr[i4] ^ this.flushedBlock[this.blockSize - i7]);
                i6++;
                i4++;
                this.pendingXorBytes = i7 - 1;
                i5--;
            } else {
                int nonFlushingUpdate = nonFlushingUpdate(bArr, i4, i5, bArr2, i6);
                if (i5 == nonFlushingUpdate) {
                    return;
                }
                int i8 = i5 - nonFlushingUpdate;
                int i9 = 0;
                Assertions.checkState(i8 < this.blockSize);
                int i10 = i6 + nonFlushingUpdate;
                int i11 = this.blockSize - i8;
                this.pendingXorBytes = i11;
                Assertions.checkState(nonFlushingUpdate(this.zerosBlock, 0, i11, this.flushedBlock, 0) == this.blockSize);
                while (i9 < i8) {
                    bArr2[i10] = this.flushedBlock[i9];
                    i9++;
                    i10++;
                }
                return;
            }
        } while (i5 != 0);
    }

    private int nonFlushingUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        try {
            return this.cipher.update(bArr, i, i2, bArr2, i3);
        } catch (ShortBufferException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] getInitializationVector(long j, long j2) {
        return ByteBuffer.allocate(16).putLong(j).putLong(j2).array();
    }

    private static long getFNV64Hash(String str) {
        long j = 0;
        if (str == null) {
            return 0L;
        }
        for (int i = 0; i < str.length(); i++) {
            long charAt = j ^ str.charAt(i);
            j = charAt + (charAt << 1) + (charAt << 4) + (charAt << 5) + (charAt << 7) + (charAt << 8) + (charAt << 40);
        }
        return j;
    }
}
