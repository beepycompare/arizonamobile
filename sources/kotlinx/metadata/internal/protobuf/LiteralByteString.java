package kotlinx.metadata.internal.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlinx.metadata.internal.protobuf.ByteString;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class LiteralByteString extends ByteString {
    protected final byte[] bytes;
    private int hash = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public int getOffsetIntoBytes() {
        return 0;
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    protected int getTreeDepth() {
        return 0;
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    protected boolean isBalanced() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiteralByteString(byte[] bArr) {
        this.bytes = bArr;
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    public byte byteAt(int i) {
        return this.bytes[i];
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    public int size() {
        return this.bytes.length;
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    public ByteString substring(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(i).append(" < 0").toString());
        }
        if (i2 > size()) {
            throw new IndexOutOfBoundsException(new StringBuilder(36).append("End index: ").append(i2).append(" > ").append(size()).toString());
        }
        int i3 = i2 - i;
        if (i3 >= 0) {
            if (i3 == 0) {
                return ByteString.EMPTY;
            }
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + i, i3);
        }
        throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(i).append(", ").append(i2).toString());
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    protected void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, i, bArr, i2, i3);
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(asReadOnlyByteBuffer());
        return arrayList;
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.bytes, getOffsetIntoBytes() + i, i2);
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.bytes, getOffsetIntoBytes(), size(), str);
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    public boolean isValidUtf8() {
        int offsetIntoBytes = getOffsetIntoBytes();
        return Utf8.isValidUtf8(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    protected int partialIsValidUtf8(int i, int i2, int i3) {
        int offsetIntoBytes = getOffsetIntoBytes() + i2;
        return Utf8.partialIsValidUtf8(i, this.bytes, offsetIntoBytes, i3 + offsetIntoBytes);
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ByteString) && size() == ((ByteString) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (obj instanceof LiteralByteString) {
                return equalsRange((LiteralByteString) obj, 0, size());
            }
            if (obj instanceof RopeByteString) {
                return obj.equals(this);
            }
            String valueOf = String.valueOf(String.valueOf(obj.getClass()));
            throw new IllegalArgumentException(new StringBuilder(valueOf.length() + 49).append("Has a new type of ByteString been created? Found ").append(valueOf).toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean equalsRange(LiteralByteString literalByteString, int i, int i2) {
        if (i2 > literalByteString.size()) {
            throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(i2).append(size()).toString());
        } else if (i + i2 > literalByteString.size()) {
            throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: ").append(i).append(", ").append(i2).append(", ").append(literalByteString.size()).toString());
        } else {
            byte[] bArr = this.bytes;
            byte[] bArr2 = literalByteString.bytes;
            int offsetIntoBytes = getOffsetIntoBytes() + i2;
            int offsetIntoBytes2 = getOffsetIntoBytes();
            int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i;
            while (offsetIntoBytes2 < offsetIntoBytes) {
                if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                    return false;
                }
                offsetIntoBytes2++;
                offsetIntoBytes3++;
            }
            return true;
        }
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    public int hashCode() {
        int i = this.hash;
        if (i == 0) {
            int size = size();
            i = partialHash(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.hash = i;
        }
        return i;
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    protected int peekCachedHashCode() {
        return this.hash;
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    protected int partialHash(int i, int i2, int i3) {
        return hashCode(i, this.bytes, getOffsetIntoBytes() + i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCode(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCode(byte[] bArr) {
        int hashCode = hashCode(bArr.length, bArr, 0, bArr.length);
        if (hashCode == 0) {
            return 1;
        }
        return hashCode;
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    public InputStream newInput() {
        return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
    }

    @Override // kotlinx.metadata.internal.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.metadata.internal.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new LiteralByteIterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class LiteralByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;

        private LiteralByteIterator() {
            this.position = 0;
            this.limit = LiteralByteString.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < this.limit;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // kotlinx.metadata.internal.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            try {
                byte[] bArr = LiteralByteString.this.bytes;
                int i = this.position;
                this.position = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
