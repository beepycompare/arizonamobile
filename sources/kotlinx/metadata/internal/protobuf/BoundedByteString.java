package kotlinx.metadata.internal.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlinx.metadata.internal.protobuf.ByteString;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class BoundedByteString extends LiteralByteString {
    private final int bytesLength;
    private final int bytesOffset;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundedByteString(byte[] bArr, int i, int i2) {
        super(bArr);
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(29).append("Offset too small: ").append(i).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(new StringBuilder(29).append("Length too small: ").append(i).toString());
        }
        if (i + i2 > bArr.length) {
            throw new IllegalArgumentException(new StringBuilder(48).append("Offset+Length too large: ").append(i).append("+").append(i2).toString());
        }
        this.bytesOffset = i;
        this.bytesLength = i2;
    }

    @Override // kotlinx.metadata.internal.protobuf.LiteralByteString, kotlinx.metadata.internal.protobuf.ByteString
    public byte byteAt(int i) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(28).append("Index too small: ").append(i).toString());
        }
        if (i >= size()) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(41).append("Index too large: ").append(i).append(", ").append(size()).toString());
        }
        return this.bytes[this.bytesOffset + i];
    }

    @Override // kotlinx.metadata.internal.protobuf.LiteralByteString, kotlinx.metadata.internal.protobuf.ByteString
    public int size() {
        return this.bytesLength;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.metadata.internal.protobuf.LiteralByteString
    public int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    @Override // kotlinx.metadata.internal.protobuf.LiteralByteString, kotlinx.metadata.internal.protobuf.ByteString
    protected void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, getOffsetIntoBytes() + i, bArr, i2, i3);
    }

    @Override // kotlinx.metadata.internal.protobuf.LiteralByteString, kotlinx.metadata.internal.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new BoundedByteIterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class BoundedByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;

        private BoundedByteIterator() {
            int offsetIntoBytes = BoundedByteString.this.getOffsetIntoBytes();
            this.position = offsetIntoBytes;
            this.limit = offsetIntoBytes + BoundedByteString.this.size();
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
            if (this.position >= this.limit) {
                throw new NoSuchElementException();
            }
            byte[] bArr = BoundedByteString.this.bytes;
            int i = this.position;
            this.position = i + 1;
            return bArr[i];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
