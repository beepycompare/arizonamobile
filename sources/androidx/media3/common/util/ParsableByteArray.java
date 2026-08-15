package androidx.media3.common.util;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Chars;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.common.primitives.UnsignedInts;
import com.google.errorprone.annotations.CheckReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Utf8;
@CheckReturnValue
/* loaded from: classes3.dex */
public final class ParsableByteArray {
    public static final int INVALID_CODE_POINT = 1114112;
    private byte[] data;
    private int limit;
    private int position;
    private static final char[] CR_AND_LF = {'\r', '\n'};
    private static final char[] LF = {'\n'};
    private static final ImmutableSet<Charset> SUPPORTED_CHARSETS_FOR_READLINE = ImmutableSet.of(StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);
    private static final AtomicBoolean shouldEnforceLimitOnLegacyMethods = new AtomicBoolean();

    private static boolean isUtf8ContinuationByte(byte b) {
        return (b & 192) == 128;
    }

    public ParsableByteArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    public ParsableByteArray(int i) {
        this.data = new byte[i];
        this.limit = i;
    }

    public ParsableByteArray(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
    }

    public void reset(int i) {
        reset(capacity() < i ? new byte[i] : this.data, i);
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public void reset(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
        this.position = 0;
    }

    public void ensureCapacity(int i) {
        if (i > capacity()) {
            this.data = Arrays.copyOf(this.data, i);
        }
    }

    public int bytesLeft() {
        return Math.max(this.limit - this.position, 0);
    }

    public int limit() {
        return this.limit;
    }

    public void setLimit(int i) {
        Preconditions.checkArgument(i >= 0 && i <= this.data.length);
        this.limit = i;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        Preconditions.checkArgument(i >= 0 && i <= this.limit);
        this.position = i;
    }

    public byte[] getData() {
        return this.data;
    }

    public int capacity() {
        return this.data.length;
    }

    public void skipBytes(int i) {
        setPosition(this.position + i);
    }

    public void readBytes(ParsableBitArray parsableBitArray, int i) {
        readBytes(parsableBitArray.data, 0, i);
        parsableBitArray.setPosition(0);
    }

    public void readBytes(byte[] bArr, int i, int i2) {
        maybeAssertAtLeastBytesLeftForLegacyMethod(i2);
        System.arraycopy(this.data, this.position, bArr, i, i2);
        this.position += i2;
    }

    public void readBytes(ByteBuffer byteBuffer, int i) {
        maybeAssertAtLeastBytesLeftForLegacyMethod(i);
        byteBuffer.put(this.data, this.position, i);
        this.position += i;
    }

    public int peekUnsignedByte() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(1);
        return this.data[this.position] & 255;
    }

    public char peekChar() {
        return peekChar(ByteOrder.BIG_ENDIAN, 0);
    }

    @Deprecated
    public char peekChar(Charset charset) {
        int peekUnsignedByte;
        Preconditions.checkArgument(SUPPORTED_CHARSETS_FOR_READLINE.contains(charset), "Unsupported charset: %s", charset);
        if (bytesLeft() == 0) {
            return (char) 0;
        }
        if (charset.equals(StandardCharsets.US_ASCII)) {
            peekUnsignedByte = peekUnsignedByte();
        } else if (charset.equals(StandardCharsets.UTF_8)) {
            if ((this.data[this.position] & 128) != 0) {
                return (char) 0;
            }
            peekUnsignedByte = peekUnsignedByte();
        } else if (bytesLeft() < 2) {
            return (char) 0;
        } else {
            return peekChar(charset.equals(StandardCharsets.UTF_16LE) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN, 0);
        }
        return (char) peekUnsignedByte;
    }

    private char peekChar(ByteOrder byteOrder, int i) {
        maybeAssertAtLeastBytesLeftForLegacyMethod(2);
        ByteOrder byteOrder2 = ByteOrder.BIG_ENDIAN;
        byte[] bArr = this.data;
        if (byteOrder == byteOrder2) {
            int i2 = this.position;
            return Chars.fromBytes(bArr[i2 + i], bArr[i2 + i + 1]);
        }
        int i3 = this.position;
        return Chars.fromBytes(bArr[i3 + i + 1], bArr[i3 + i]);
    }

    public int peekCodePoint(Charset charset) {
        int peekCodePointAndSize = peekCodePointAndSize(charset);
        return peekCodePointAndSize != 0 ? Ints.checkedCast(peekCodePointAndSize >>> 8) : INVALID_CODE_POINT;
    }

    public int peekUnsignedInt24() {
        if (bytesLeft() < 3) {
            throw new IndexOutOfBoundsException("position=" + this.position + ", limit=" + this.limit);
        }
        int readUnsignedInt24 = readUnsignedInt24();
        this.position -= 3;
        return readUnsignedInt24;
    }

    public int peekInt() {
        if (bytesLeft() < 4) {
            throw new IndexOutOfBoundsException("position=" + this.position + ", limit=" + this.limit);
        }
        int readInt = readInt();
        this.position -= 4;
        return readInt;
    }

    public int readUnsignedByte() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(1);
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] & 255;
    }

    public int readUnsignedShort() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(2);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        this.position = i + 2;
        return (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
    }

    public int readLittleEndianUnsignedShort() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(2);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        this.position = i + 2;
        return ((bArr[i2] & 255) << 8) | (bArr[i] & 255);
    }

    public short readShort() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(2);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        this.position = i + 2;
        return (short) ((bArr[i2] & 255) | ((bArr[i] & 255) << 8));
    }

    public short readLittleEndianShort() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(2);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        this.position = i + 2;
        return (short) (((bArr[i2] & 255) << 8) | (bArr[i] & 255));
    }

    public int readUnsignedInt24() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(3);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i + 2;
        this.position = i3;
        int i4 = (bArr[i2] & 255) << 8;
        this.position = i + 3;
        return (bArr[i3] & 255) | i4 | ((bArr[i] & 255) << 16);
    }

    public int readInt24() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(3);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i + 2;
        this.position = i3;
        int i4 = (bArr[i2] & 255) << 8;
        this.position = i + 3;
        return (bArr[i3] & 255) | i4 | (((bArr[i] & 255) << 24) >> 8);
    }

    public int readLittleEndianInt24() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(3);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i + 2;
        this.position = i3;
        int i4 = (bArr[i2] & 255) << 8;
        this.position = i + 3;
        return ((bArr[i3] & 255) << 16) | i4 | (bArr[i] & 255);
    }

    public int readLittleEndianUnsignedInt24() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(3);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i + 2;
        this.position = i3;
        int i4 = (bArr[i2] & 255) << 8;
        this.position = i + 3;
        return ((bArr[i3] & 255) << 16) | i4 | (bArr[i] & 255);
    }

    public long readUnsignedInt() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(4);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i + 2;
        this.position = i3;
        int i4 = i + 3;
        this.position = i4;
        this.position = i + 4;
        return (bArr[i4] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
    }

    public long readLittleEndianUnsignedInt() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(4);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i + 2;
        this.position = i3;
        int i4 = i + 3;
        this.position = i4;
        this.position = i + 4;
        return ((bArr[i4] & 255) << 24) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16);
    }

    public int readInt() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(4);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i + 2;
        this.position = i3;
        int i4 = ((bArr[i2] & 255) << 16) | ((bArr[i] & 255) << 24);
        int i5 = i + 3;
        this.position = i5;
        this.position = i + 4;
        return (bArr[i5] & 255) | i4 | ((bArr[i3] & 255) << 8);
    }

    public int readLittleEndianInt() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(4);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i + 2;
        this.position = i3;
        int i4 = ((bArr[i2] & 255) << 8) | (bArr[i] & 255);
        int i5 = i + 3;
        this.position = i5;
        this.position = i + 4;
        return ((bArr[i5] & 255) << 24) | i4 | ((bArr[i3] & 255) << 16);
    }

    public long readLong() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(8);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i + 2;
        this.position = i3;
        int i4 = i + 3;
        this.position = i4;
        long j = ((bArr[i] & 255) << 56) | ((bArr[i2] & 255) << 48) | ((bArr[i3] & 255) << 40);
        int i5 = i + 4;
        this.position = i5;
        int i6 = i + 5;
        this.position = i6;
        long j2 = j | ((bArr[i4] & 255) << 32) | ((bArr[i5] & 255) << 24);
        int i7 = i + 6;
        this.position = i7;
        int i8 = i + 7;
        this.position = i8;
        this.position = i + 8;
        return (bArr[i8] & 255) | j2 | ((bArr[i6] & 255) << 16) | ((bArr[i7] & 255) << 8);
    }

    public long readLittleEndianLong() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(8);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i + 2;
        this.position = i3;
        int i4 = i + 3;
        this.position = i4;
        long j = (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16);
        int i5 = i + 4;
        this.position = i5;
        int i6 = i + 5;
        this.position = i6;
        long j2 = j | ((bArr[i4] & 255) << 24) | ((bArr[i5] & 255) << 32);
        int i7 = i + 6;
        this.position = i7;
        int i8 = i + 7;
        this.position = i8;
        this.position = i + 8;
        return ((bArr[i8] & 255) << 56) | j2 | ((bArr[i6] & 255) << 40) | ((bArr[i7] & 255) << 48);
    }

    public int readUnsignedFixedPoint1616() {
        maybeAssertAtLeastBytesLeftForLegacyMethod(4);
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        this.position = i + 2;
        int i3 = (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
        this.position = i + 4;
        return i3;
    }

    public int readSynchSafeInt() {
        return readUnsignedByte() | (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7);
    }

    public int readUnsignedIntToInt() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        throw new IllegalStateException("Top bit not zero: " + readInt);
    }

    public int readLittleEndianUnsignedIntToInt() {
        int readLittleEndianInt = readLittleEndianInt();
        if (readLittleEndianInt >= 0) {
            return readLittleEndianInt;
        }
        throw new IllegalStateException("Top bit not zero: " + readLittleEndianInt);
    }

    public long readUnsignedLongToLong() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        throw new IllegalStateException("Top bit not zero: " + readLong);
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public String readString(int i) {
        return readString(i, StandardCharsets.UTF_8);
    }

    public String readString(int i, Charset charset) {
        maybeAssertAtLeastBytesLeftForLegacyMethod(i);
        String str = new String(this.data, this.position, i, charset);
        this.position += i;
        return str;
    }

    public String readNullTerminatedString(int i) {
        maybeAssertAtLeastBytesLeftForLegacyMethod(i);
        if (i == 0) {
            return "";
        }
        int i2 = this.position;
        int i3 = (i2 + i) - 1;
        String fromUtf8Bytes = Util.fromUtf8Bytes(this.data, i2, (i3 >= this.limit || this.data[i3] != 0) ? i : i - 1);
        this.position += i;
        return fromUtf8Bytes;
    }

    public String readNullTerminatedString() {
        return readDelimiterTerminatedString((char) 0);
    }

    public String readDelimiterTerminatedString(char c) {
        if (bytesLeft() == 0) {
            return null;
        }
        int i = this.position;
        while (i < this.limit && this.data[i] != c) {
            i++;
        }
        byte[] bArr = this.data;
        int i2 = this.position;
        String fromUtf8Bytes = Util.fromUtf8Bytes(bArr, i2, i - i2);
        this.position = i;
        if (i < this.limit) {
            this.position = i + 1;
        }
        return fromUtf8Bytes;
    }

    public String readLine() {
        return readLine(StandardCharsets.UTF_8);
    }

    public String readLine(Charset charset) {
        Preconditions.checkArgument(SUPPORTED_CHARSETS_FOR_READLINE.contains(charset), "Unsupported charset: %s", charset);
        if (bytesLeft() == 0) {
            return null;
        }
        if (!charset.equals(StandardCharsets.US_ASCII)) {
            readUtfCharsetFromBom();
        }
        String readString = readString(findNextLineTerminator(charset) - this.position, charset);
        if (this.position == this.limit) {
            return readString;
        }
        skipLineTerminator(charset);
        return readString;
    }

    public long readUtf8EncodedLong() {
        int i;
        byte b;
        int i2;
        maybeAssertAtLeastBytesLeftForLegacyMethod(1);
        long j = this.data[this.position];
        int i3 = 7;
        while (true) {
            if (i3 < 0) {
                break;
            }
            if (((1 << i3) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= i2 - 1;
                i = 7 - i3;
            } else if (i3 == 7) {
                i = 1;
            }
        }
        i = 0;
        if (i == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
        }
        maybeAssertAtLeastBytesLeftForLegacyMethod(i);
        for (int i4 = 1; i4 < i; i4++) {
            if ((this.data[this.position + i4] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
            }
            j = (j << 6) | (b & Utf8.REPLACEMENT_BYTE);
        }
        this.position += i;
        return j;
    }

    public long readUnsignedLeb128ToLong() {
        long j = 0;
        for (int i = 0; i < 9; i++) {
            if (this.position == this.limit) {
                throw new IllegalStateException("Attempting to read a byte over the limit.");
            }
            long readUnsignedByte = readUnsignedByte();
            j |= (127 & readUnsignedByte) << (i * 7);
            if ((readUnsignedByte & 128) == 0) {
                return j;
            }
        }
        return j;
    }

    public int readUnsignedLeb128ToInt() {
        return Ints.checkedCast(readUnsignedLeb128ToLong());
    }

    public void skipLeb128() {
        do {
        } while ((readUnsignedByte() & 128) != 0);
    }

    public Charset readUtfCharsetFromBom() {
        if (bytesLeft() >= 3) {
            byte[] bArr = this.data;
            int i = this.position;
            if (bArr[i] == -17 && bArr[i + 1] == -69 && bArr[i + 2] == -65) {
                this.position = i + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (bytesLeft() >= 2) {
            byte[] bArr2 = this.data;
            int i2 = this.position;
            byte b = bArr2[i2];
            if (b == -2 && bArr2[i2 + 1] == -1) {
                this.position = i2 + 2;
                return StandardCharsets.UTF_16BE;
            } else if (b == -1 && bArr2[i2 + 1] == -2) {
                this.position = i2 + 2;
                return StandardCharsets.UTF_16LE;
            } else {
                return null;
            }
        }
        return null;
    }

    public static void setShouldEnforceLimitOnLegacyMethods(boolean z) {
        shouldEnforceLimitOnLegacyMethods.set(z);
    }

    private int findNextLineTerminator(Charset charset) {
        int i;
        if (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) {
            i = 1;
        } else if (!charset.equals(StandardCharsets.UTF_16) && !charset.equals(StandardCharsets.UTF_16LE) && !charset.equals(StandardCharsets.UTF_16BE)) {
            throw new IllegalArgumentException("Unsupported charset: " + charset);
        } else {
            i = 2;
        }
        int i2 = this.position;
        while (true) {
            int i3 = this.limit;
            if (i2 >= i3 - (i - 1)) {
                return i3;
            }
            if ((charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) && Util.isLinebreak(this.data[i2])) {
                break;
            }
            if (charset.equals(StandardCharsets.UTF_16) || charset.equals(StandardCharsets.UTF_16BE)) {
                byte[] bArr = this.data;
                if (bArr[i2] == 0 && Util.isLinebreak(bArr[i2 + 1])) {
                    break;
                }
            }
            if (charset.equals(StandardCharsets.UTF_16LE)) {
                byte[] bArr2 = this.data;
                if (bArr2[i2 + 1] == 0 && Util.isLinebreak(bArr2[i2])) {
                    break;
                }
            }
            i2 += i;
        }
        return i2;
    }

    private void skipLineTerminator(Charset charset) {
        if (readCharacterIfInList(charset, CR_AND_LF) == '\r') {
            readCharacterIfInList(charset, LF);
        }
    }

    private char readCharacterIfInList(Charset charset, char[] cArr) {
        int peekCodePointAndSize;
        if (bytesLeft() >= getSmallestCodeUnitSize(charset) && (peekCodePointAndSize = peekCodePointAndSize(charset)) != 0) {
            int checkedCast = UnsignedInts.checkedCast(peekCodePointAndSize >>> 8);
            if (Character.isSupplementaryCodePoint(checkedCast)) {
                return (char) 0;
            }
            char checkedCast2 = Chars.checkedCast(checkedCast);
            if (Chars.contains(cArr, checkedCast2)) {
                this.position += Ints.checkedCast(peekCodePointAndSize & 255);
                return checkedCast2;
            }
            return (char) 0;
        }
        return (char) 0;
    }

    private int peekCodePointAndSize(Charset charset) {
        int i;
        Preconditions.checkArgument(SUPPORTED_CHARSETS_FOR_READLINE.contains(charset), "Unsupported charset: %s", charset);
        if (bytesLeft() < getSmallestCodeUnitSize(charset)) {
            throw new IndexOutOfBoundsException("position=" + this.position + ", limit=" + this.limit);
        }
        byte b = 1;
        if (charset.equals(StandardCharsets.US_ASCII)) {
            byte b2 = this.data[this.position];
            if ((b2 & 128) != 0) {
                return 0;
            }
            i = UnsignedBytes.toInt(b2);
        } else if (charset.equals(StandardCharsets.UTF_8)) {
            byte peekUtf8CodeUnitSize = peekUtf8CodeUnitSize();
            if (peekUtf8CodeUnitSize == 1) {
                i = UnsignedBytes.toInt(this.data[this.position]);
            } else if (peekUtf8CodeUnitSize == 2) {
                byte[] bArr = this.data;
                int i2 = this.position;
                i = decodeUtf8CodeUnit(0, 0, bArr[i2], bArr[i2 + 1]);
            } else if (peekUtf8CodeUnitSize == 3) {
                byte[] bArr2 = this.data;
                int i3 = this.position;
                i = decodeUtf8CodeUnit(0, bArr2[i3] & Ascii.SI, bArr2[i3 + 1], bArr2[i3 + 2]);
            } else if (peekUtf8CodeUnitSize != 4) {
                return 0;
            } else {
                byte[] bArr3 = this.data;
                int i4 = this.position;
                i = decodeUtf8CodeUnit(bArr3[i4], bArr3[i4 + 1], bArr3[i4 + 2], bArr3[i4 + 3]);
            }
            b = peekUtf8CodeUnitSize;
        } else {
            ByteOrder byteOrder = charset.equals(StandardCharsets.UTF_16LE) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
            char peekChar = peekChar(byteOrder, 0);
            if (!Character.isHighSurrogate(peekChar) || bytesLeft() < 4) {
                i = peekChar;
                b = 2;
            } else {
                i = Character.toCodePoint(peekChar, peekChar(byteOrder, 2));
                b = 4;
            }
        }
        return (i << 8) | b;
    }

    private static int getSmallestCodeUnitSize(Charset charset) {
        Preconditions.checkArgument(SUPPORTED_CHARSETS_FOR_READLINE.contains(charset), "Unsupported charset: %s", charset);
        return (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) ? 1 : 2;
    }

    private byte peekUtf8CodeUnitSize() {
        byte b = this.data[this.position];
        if ((b & 128) == 0) {
            return (byte) 1;
        }
        if ((b & 224) == 192 && bytesLeft() >= 2 && isUtf8ContinuationByte(this.data[this.position + 1])) {
            return (byte) 2;
        }
        if ((this.data[this.position] & 240) == 224 && bytesLeft() >= 3 && isUtf8ContinuationByte(this.data[this.position + 1]) && isUtf8ContinuationByte(this.data[this.position + 2])) {
            return (byte) 3;
        }
        return ((this.data[this.position] & 248) == 240 && bytesLeft() >= 4 && isUtf8ContinuationByte(this.data[this.position + 1]) && isUtf8ContinuationByte(this.data[this.position + 2]) && isUtf8ContinuationByte(this.data[this.position + 3])) ? (byte) 4 : (byte) 0;
    }

    private void maybeAssertAtLeastBytesLeftForLegacyMethod(int i) {
        if (shouldEnforceLimitOnLegacyMethods.get() && bytesLeft() < i) {
            throw new IndexOutOfBoundsException("bytesNeeded= " + i + ", bytesLeft=" + bytesLeft());
        }
    }

    private static int decodeUtf8CodeUnit(int i, int i2, int i3, int i4) {
        byte b = (byte) i3;
        return Ints.fromBytes((byte) 0, UnsignedBytes.checkedCast(((i & 7) << 2) | ((i2 & 48) >> 4)), UnsignedBytes.checkedCast(((((byte) i2) & Ascii.SI) << 4) | ((b & 60) >> 2)), UnsignedBytes.checkedCast(((b & 3) << 6) | (((byte) i4) & Utf8.REPLACEMENT_BYTE)));
    }
}
