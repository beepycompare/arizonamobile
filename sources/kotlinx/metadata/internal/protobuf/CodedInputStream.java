package kotlinx.metadata.internal.protobuf;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import kotlinx.metadata.internal.protobuf.MessageLite;
/* loaded from: classes5.dex */
public final class CodedInputStream {
    private static final int BUFFER_SIZE = 4096;
    private static final int DEFAULT_RECURSION_LIMIT = 64;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private final byte[] buffer;
    private final boolean bufferIsImmutable;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private boolean enableAliasing;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private RefillCallback refillCallback;
    private int sizeLimit;
    private int totalBytesRetired;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface RefillCallback {
        void onRefill();
    }

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i, int i2) {
        CodedInputStream codedInputStream = new CodedInputStream(bArr, i, i2);
        try {
            codedInputStream.pushLimit(i2);
            return codedInputStream;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return newInstance(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        byte[] bArr = new byte[duplicate.remaining()];
        duplicate.get(bArr);
        return newInstance(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream newInstance(LiteralByteString literalByteString) {
        CodedInputStream codedInputStream = new CodedInputStream(literalByteString);
        try {
            codedInputStream.pushLimit(literalByteString.size());
            return codedInputStream;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        int readRawVarint32 = readRawVarint32();
        this.lastTag = readRawVarint32;
        if (WireFormat.getTagFieldNumber(readRawVarint32) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        return this.lastTag;
    }

    public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
        if (this.lastTag != i) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int getLastTag() {
        return this.lastTag;
    }

    public boolean skipField(int i) throws IOException {
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            skipRawVarint();
            return true;
        } else if (tagWireType == 1) {
            skipRawBytes(8);
            return true;
        } else if (tagWireType == 2) {
            skipRawBytes(readRawVarint32());
            return true;
        } else if (tagWireType == 3) {
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4));
            return true;
        } else if (tagWireType != 4) {
            if (tagWireType == 5) {
                skipRawBytes(4);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        } else {
            return false;
        }
    }

    public boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException {
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            long readInt64 = readInt64();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeUInt64NoTag(readInt64);
            return true;
        } else if (tagWireType == 1) {
            long readRawLittleEndian64 = readRawLittleEndian64();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
            return true;
        } else if (tagWireType == 2) {
            ByteString readBytes = readBytes();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeBytesNoTag(readBytes);
            return true;
        } else if (tagWireType == 3) {
            codedOutputStream.writeRawVarint32(i);
            skipMessage(codedOutputStream);
            int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4);
            checkLastTagWas(makeTag);
            codedOutputStream.writeRawVarint32(makeTag);
            return true;
        } else if (tagWireType != 4) {
            if (tagWireType == 5) {
                int readRawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        } else {
            return false;
        }
    }

    public void skipMessage() throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (skipField(readTag));
    }

    public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (skipField(readTag, codedOutputStream));
    }

    /* loaded from: classes5.dex */
    private class SkippedDataSink implements RefillCallback {
        private ByteArrayOutputStream byteArrayStream;
        private int lastPos;

        private SkippedDataSink() {
            this.lastPos = CodedInputStream.this.bufferPos;
        }

        @Override // kotlinx.metadata.internal.protobuf.CodedInputStream.RefillCallback
        public void onRefill() {
            if (this.byteArrayStream == null) {
                this.byteArrayStream = new ByteArrayOutputStream();
            }
            this.byteArrayStream.write(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos - this.lastPos);
            this.lastPos = 0;
        }

        ByteBuffer getSkippedData() {
            ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
            if (byteArrayOutputStream == null) {
                return ByteBuffer.wrap(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos - this.lastPos);
            }
            byteArrayOutputStream.write(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos);
            return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
        }
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public boolean readBool() throws IOException {
        return readRawVarint64() != 0;
    }

    public String readString() throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (readRawVarint32 > this.bufferSize - this.bufferPos || readRawVarint32 <= 0) {
            if (readRawVarint32 == 0) {
                return "";
            }
            return new String(readRawBytesSlowPath(readRawVarint32), "UTF-8");
        }
        String str = new String(this.buffer, this.bufferPos, readRawVarint32, "UTF-8");
        this.bufferPos += readRawVarint32;
        return str;
    }

    public String readStringRequireUtf8() throws IOException {
        byte[] readRawBytesSlowPath;
        int readRawVarint32 = readRawVarint32();
        int i = this.bufferPos;
        if (readRawVarint32 <= this.bufferSize - i && readRawVarint32 > 0) {
            readRawBytesSlowPath = this.buffer;
            this.bufferPos = i + readRawVarint32;
        } else if (readRawVarint32 == 0) {
            return "";
        } else {
            readRawBytesSlowPath = readRawBytesSlowPath(readRawVarint32);
            i = 0;
        }
        if (!Utf8.isValidUtf8(readRawBytesSlowPath, i, i + readRawVarint32)) {
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        return new String(readRawBytesSlowPath, i, readRawVarint32, "UTF-8");
    }

    public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i2 = this.recursionDepth;
        if (i2 >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        this.recursionDepth = i2 + 1;
        builder.mergeFrom(this, extensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(i, 4));
        this.recursionDepth--;
    }

    public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i2 = this.recursionDepth;
        if (i2 >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        this.recursionDepth = i2 + 1;
        T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(i, 4));
        this.recursionDepth--;
        return parsePartialFrom;
    }

    @Deprecated
    public void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException {
        readGroup(i, builder, (ExtensionRegistryLite) null);
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int pushLimit = pushLimit(readRawVarint32);
        this.recursionDepth++;
        builder.mergeFrom(this, extensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(pushLimit);
    }

    public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int pushLimit = pushLimit(readRawVarint32);
        this.recursionDepth++;
        T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(pushLimit);
        return parsePartialFrom;
    }

    public ByteString readBytes() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i = this.bufferSize;
        int i2 = this.bufferPos;
        if (readRawVarint32 > i - i2 || readRawVarint32 <= 0) {
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            return new LiteralByteString(readRawBytesSlowPath(readRawVarint32));
        }
        ByteString boundedByteString = (this.bufferIsImmutable && this.enableAliasing) ? new BoundedByteString(this.buffer, this.bufferPos, readRawVarint32) : ByteString.copyFrom(this.buffer, i2, readRawVarint32);
        this.bufferPos += readRawVarint32;
        return boundedByteString;
    }

    public byte[] readByteArray() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i = this.bufferSize;
        int i2 = this.bufferPos;
        if (readRawVarint32 <= i - i2 && readRawVarint32 > 0) {
            byte[] copyOfRange = Arrays.copyOfRange(this.buffer, i2, i2 + readRawVarint32);
            this.bufferPos += readRawVarint32;
            return copyOfRange;
        }
        return readRawBytesSlowPath(readRawVarint32);
    }

    public ByteBuffer readByteBuffer() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i = this.bufferSize;
        int i2 = this.bufferPos;
        if (readRawVarint32 > i - i2 || readRawVarint32 <= 0) {
            if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            return ByteBuffer.wrap(readRawBytesSlowPath(readRawVarint32));
        }
        ByteBuffer slice = (this.input == null && !this.bufferIsImmutable && this.enableAliasing) ? ByteBuffer.wrap(this.buffer, i2, readRawVarint32).slice() : ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i2, i2 + readRawVarint32));
        this.bufferPos += readRawVarint32;
        return slice;
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public int readRawVarint32() throws IOException {
        int i;
        byte b;
        int i2;
        int i3 = this.bufferPos;
        int i4 = this.bufferSize;
        if (i4 != i3) {
            byte[] bArr = this.buffer;
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.bufferPos = i5;
                return b2;
            } else if (i4 - i5 >= 9) {
                int i6 = i3 + 2;
                int i7 = (bArr[i5] << 7) ^ b2;
                long j = i7;
                if (j < 0) {
                    i2 = (int) ((-128) ^ j);
                } else {
                    int i8 = i3 + 3;
                    int i9 = (bArr[i6] << Ascii.SO) ^ i7;
                    long j2 = i9;
                    if (j2 >= 0) {
                        i2 = (int) (16256 ^ j2);
                    } else {
                        int i10 = i3 + 4;
                        long j3 = i9 ^ (bArr[i8] << Ascii.NAK);
                        if (j3 < 0) {
                            i2 = (int) ((-2080896) ^ j3);
                        } else {
                            i8 = i3 + 5;
                            int i11 = (int) ((i ^ (b << Ascii.FS)) ^ 266354560);
                            if (bArr[i10] < 0) {
                                i10 = i3 + 6;
                                if (bArr[i8] < 0) {
                                    i8 = i3 + 7;
                                    if (bArr[i10] < 0) {
                                        i10 = i3 + 8;
                                        if (bArr[i8] < 0) {
                                            i8 = i3 + 9;
                                            if (bArr[i10] < 0) {
                                                int i12 = i3 + 10;
                                                if (bArr[i8] >= 0) {
                                                    i6 = i12;
                                                    i2 = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i2 = i11;
                            }
                            i2 = i11;
                        }
                        i6 = i10;
                    }
                    i6 = i8;
                }
                this.bufferPos = i6;
                return i2;
            }
        }
        return (int) readRawVarint64SlowPath();
    }

    private void skipRawVarint() throws IOException {
        int i = this.bufferSize;
        int i2 = this.bufferPos;
        if (i - i2 >= 10) {
            byte[] bArr = this.buffer;
            int i3 = 0;
            while (i3 < 10) {
                int i4 = i2 + 1;
                if (bArr[i2] >= 0) {
                    this.bufferPos = i4;
                    return;
                } else {
                    i3++;
                    i2 = i4;
                }
            }
        }
        skipRawVarintSlowPath();
    }

    private void skipRawVarintSlowPath() throws IOException {
        for (int i = 0; i < 10; i++) {
            if (readRawByte() >= 0) {
                return;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    static int readRawVarint32(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read == -1) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        return readRawVarint32(read, inputStream);
    }

    public static int readRawVarint32(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i2 |= (read & 127) << i3;
            if ((read & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public long readRawVarint64() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.bufferPos;
        int i2 = this.bufferSize;
        if (i2 != i) {
            byte[] bArr = this.buffer;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.bufferPos = i3;
                return b;
            } else if (i2 - i3 >= 9) {
                int i4 = i + 2;
                long j4 = (bArr[i3] << 7) ^ b;
                if (j4 >= 0) {
                    int i5 = i + 3;
                    long j5 = j4 ^ (bArr[i4] << Ascii.SO);
                    if (j5 >= 0) {
                        j3 = 16256;
                    } else {
                        i4 = i + 4;
                        j4 = j5 ^ (bArr[i5] << Ascii.NAK);
                        if (j4 < 0) {
                            j2 = -2080896;
                        } else {
                            i5 = i + 5;
                            j5 = j4 ^ (bArr[i4] << 28);
                            if (j5 >= 0) {
                                j3 = 266354560;
                            } else {
                                i4 = i + 6;
                                j4 = j5 ^ (bArr[i5] << 35);
                                if (j4 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i5 = i + 7;
                                    j5 = j4 ^ (bArr[i4] << 42);
                                    if (j5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i4 = i + 8;
                                        j4 = j5 ^ (bArr[i5] << 49);
                                        if (j4 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i5 = i + 9;
                                            long j6 = (j4 ^ (bArr[i4] << 56)) ^ 71499008037633920L;
                                            if (j6 < 0) {
                                                i4 = i + 10;
                                                if (bArr[i5] >= 0) {
                                                    j = j6;
                                                    this.bufferPos = i4;
                                                    return j;
                                                }
                                            } else {
                                                j = j6;
                                                i4 = i5;
                                                this.bufferPos = i4;
                                                return j;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    j = j5 ^ j3;
                    i4 = i5;
                    this.bufferPos = i4;
                    return j;
                }
                j2 = -128;
                j = j4 ^ j2;
                this.bufferPos = i4;
                return j;
            }
        }
        return readRawVarint64SlowPath();
    }

    long readRawVarint64SlowPath() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte readRawByte = readRawByte();
            j |= (readRawByte & Byte.MAX_VALUE) << i;
            if ((readRawByte & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int readRawLittleEndian32() throws IOException {
        int i = this.bufferPos;
        if (this.bufferSize - i < 4) {
            refillBuffer(4);
            i = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public long readRawLittleEndian64() throws IOException {
        int i = this.bufferPos;
        if (this.bufferSize - i < 8) {
            refillBuffer(8);
            i = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private CodedInputStream(byte[] bArr, int i, int i2) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = bArr;
        this.bufferSize = i2 + i;
        this.bufferPos = i;
        this.totalBytesRetired = -i;
        this.input = null;
        this.bufferIsImmutable = false;
    }

    private CodedInputStream(InputStream inputStream) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = inputStream;
        this.bufferIsImmutable = false;
    }

    private CodedInputStream(LiteralByteString literalByteString) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = literalByteString.bytes;
        int offsetIntoBytes = literalByteString.getOffsetIntoBytes();
        this.bufferPos = offsetIntoBytes;
        this.bufferSize = offsetIntoBytes + literalByteString.size();
        this.totalBytesRetired = -this.bufferPos;
        this.input = null;
        this.bufferIsImmutable = true;
    }

    public void enableAliasing(boolean z) {
        this.enableAliasing = z;
    }

    public int setRecursionLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(47).append("Recursion limit cannot be negative: ").append(i).toString());
        }
        int i2 = this.recursionLimit;
        this.recursionLimit = i;
        return i2;
    }

    public int setSizeLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(42).append("Size limit cannot be negative: ").append(i).toString());
        }
        int i2 = this.sizeLimit;
        this.sizeLimit = i;
        return i2;
    }

    public void resetSizeCounter() {
        this.totalBytesRetired = -this.bufferPos;
    }

    public int pushLimit(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i2 = i + this.totalBytesRetired + this.bufferPos;
        int i3 = this.currentLimit;
        if (i2 > i3) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.currentLimit = i2;
        recomputeBufferSizeAfterLimit();
        return i3;
    }

    private void recomputeBufferSizeAfterLimit() {
        int i = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = i;
        int i2 = this.totalBytesRetired + i;
        int i3 = this.currentLimit;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.bufferSizeAfterLimit = i4;
            this.bufferSize = i - i4;
            return;
        }
        this.bufferSizeAfterLimit = 0;
    }

    public void popLimit(int i) {
        this.currentLimit = i;
        recomputeBufferSizeAfterLimit();
    }

    public int getBytesUntilLimit() {
        int i = this.currentLimit;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.totalBytesRetired + this.bufferPos);
    }

    public boolean isAtEnd() throws IOException {
        return this.bufferPos == this.bufferSize && !tryRefillBuffer(1);
    }

    public int getTotalBytesRead() {
        return this.totalBytesRetired + this.bufferPos;
    }

    private void ensureAvailable(int i) throws IOException {
        if (this.bufferSize - this.bufferPos < i) {
            refillBuffer(i);
        }
    }

    private void refillBuffer(int i) throws IOException {
        if (!tryRefillBuffer(i)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private boolean tryRefillBuffer(int i) throws IOException {
        int i2 = this.bufferPos;
        if (i2 + i <= this.bufferSize) {
            throw new IllegalStateException(new StringBuilder(77).append("refillBuffer() called when ").append(i).append(" bytes were already available in buffer").toString());
        }
        if (this.totalBytesRetired + i2 + i > this.currentLimit) {
            return false;
        }
        RefillCallback refillCallback = this.refillCallback;
        if (refillCallback != null) {
            refillCallback.onRefill();
        }
        if (this.input != null) {
            int i3 = this.bufferPos;
            if (i3 > 0) {
                int i4 = this.bufferSize;
                if (i4 > i3) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i3, bArr, 0, i4 - i3);
                }
                this.totalBytesRetired += i3;
                this.bufferSize -= i3;
                this.bufferPos = 0;
            }
            InputStream inputStream = this.input;
            byte[] bArr2 = this.buffer;
            int i5 = this.bufferSize;
            int read = inputStream.read(bArr2, i5, bArr2.length - i5);
            if (read == 0 || read < -1 || read > this.buffer.length) {
                throw new IllegalStateException(new StringBuilder(102).append("InputStream#read(byte[]) returned invalid result: ").append(read).append("\nThe InputStream implementation is buggy.").toString());
            }
            if (read > 0) {
                this.bufferSize += read;
                if ((this.totalBytesRetired + i) - this.sizeLimit > 0) {
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
                recomputeBufferSizeAfterLimit();
                if (this.bufferSize >= i) {
                    return true;
                }
                return tryRefillBuffer(i);
            }
        }
        return false;
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos == this.bufferSize) {
            refillBuffer(1);
        }
        byte[] bArr = this.buffer;
        int i = this.bufferPos;
        this.bufferPos = i + 1;
        return bArr[i];
    }

    public byte[] readRawBytes(int i) throws IOException {
        int i2 = this.bufferPos;
        if (i <= this.bufferSize - i2 && i > 0) {
            int i3 = i + i2;
            this.bufferPos = i3;
            return Arrays.copyOfRange(this.buffer, i2, i3);
        }
        return readRawBytesSlowPath(i);
    }

    private byte[] readRawBytesSlowPath(int i) throws IOException {
        if (i <= 0) {
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i2 = this.totalBytesRetired;
        int i3 = this.bufferPos;
        int i4 = i2 + i3 + i;
        int i5 = this.currentLimit;
        if (i4 > i5) {
            skipRawBytes((i5 - i2) - i3);
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (i < 4096) {
            byte[] bArr = new byte[i];
            int i6 = this.bufferSize - i3;
            System.arraycopy(this.buffer, i3, bArr, 0, i6);
            this.bufferPos = this.bufferSize;
            int i7 = i - i6;
            ensureAvailable(i7);
            System.arraycopy(this.buffer, 0, bArr, i6, i7);
            this.bufferPos = i7;
            return bArr;
        } else {
            int i8 = this.bufferSize;
            this.totalBytesRetired = i2 + i8;
            this.bufferPos = 0;
            this.bufferSize = 0;
            int i9 = i8 - i3;
            int i10 = i - i9;
            ArrayList<byte[]> arrayList = new ArrayList();
            while (i10 > 0) {
                int min = Math.min(i10, 4096);
                byte[] bArr2 = new byte[min];
                int i11 = 0;
                while (i11 < min) {
                    InputStream inputStream = this.input;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i11, min - i11);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += read;
                    i11 += read;
                }
                i10 -= min;
                arrayList.add(bArr2);
            }
            byte[] bArr3 = new byte[i];
            System.arraycopy(this.buffer, i3, bArr3, 0, i9);
            for (byte[] bArr4 : arrayList) {
                System.arraycopy(bArr4, 0, bArr3, i9, bArr4.length);
                i9 += bArr4.length;
            }
            return bArr3;
        }
    }

    public void skipRawBytes(int i) throws IOException {
        int i2 = this.bufferSize;
        int i3 = this.bufferPos;
        if (i <= i2 - i3 && i >= 0) {
            this.bufferPos = i3 + i;
        } else {
            skipRawBytesSlowPath(i);
        }
    }

    private void skipRawBytesSlowPath(int i) throws IOException {
        if (i < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i2 = this.totalBytesRetired;
        int i3 = this.bufferPos;
        int i4 = i2 + i3 + i;
        int i5 = this.currentLimit;
        if (i4 > i5) {
            skipRawBytes((i5 - i2) - i3);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i6 = this.bufferSize;
        int i7 = i6 - i3;
        this.bufferPos = i6;
        refillBuffer(1);
        while (true) {
            int i8 = i - i7;
            int i9 = this.bufferSize;
            if (i8 > i9) {
                i7 += i9;
                this.bufferPos = i9;
                refillBuffer(1);
            } else {
                this.bufferPos = i8;
                return;
            }
        }
    }
}
