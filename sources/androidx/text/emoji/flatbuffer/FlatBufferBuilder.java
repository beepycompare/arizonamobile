package androidx.text.emoji.flatbuffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Charset utf8charset = Charset.forName("UTF-8");
    ByteBuffer bb;
    ByteBufferFactory bb_factory;
    ByteBuffer dst;
    CharsetEncoder encoder;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    /* loaded from: classes3.dex */
    public interface ByteBufferFactory {
        ByteBuffer newByteBuffer(int i);
    }

    public FlatBufferBuilder(int i, ByteBufferFactory byteBufferFactory) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        this.encoder = utf8charset.newEncoder();
        i = i <= 0 ? 1 : i;
        this.space = i;
        this.bb_factory = byteBufferFactory;
        this.bb = byteBufferFactory.newByteBuffer(i);
    }

    public FlatBufferBuilder(int i) {
        this(i, new HeapByteBufferFactory());
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        this.encoder = utf8charset.newEncoder();
        init(byteBuffer, byteBufferFactory);
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        this.encoder = utf8charset.newEncoder();
        init(byteBuffer, new HeapByteBufferFactory());
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.bb_factory = byteBufferFactory;
        this.bb = byteBuffer;
        byteBuffer.clear();
        this.bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    /* loaded from: classes3.dex */
    public static final class HeapByteBufferFactory implements ByteBufferFactory {
        @Override // androidx.text.emoji.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public ByteBuffer newByteBuffer(int i) {
            return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public void clear() {
        this.space = this.bb.capacity();
        this.bb.clear();
        this.minalign = 1;
        while (true) {
            int i = this.vtable_in_use;
            if (i <= 0) {
                this.vtable_in_use = 0;
                this.nested = false;
                this.finished = false;
                this.object_start = 0;
                this.num_vtables = 0;
                this.vector_num_elems = 0;
                return;
            }
            int[] iArr = this.vtable;
            int i2 = i - 1;
            this.vtable_in_use = i2;
            iArr[i2] = 0;
        }
    }

    static ByteBuffer growByteBuffer(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        int capacity = byteBuffer.capacity();
        if (((-1073741824) & capacity) != 0) {
            throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
        }
        int i = capacity << 1;
        byteBuffer.position(0);
        ByteBuffer newByteBuffer = byteBufferFactory.newByteBuffer(i);
        newByteBuffer.position(i - capacity);
        newByteBuffer.put(byteBuffer);
        return newByteBuffer;
    }

    public int offset() {
        return this.bb.capacity() - this.space;
    }

    public void pad(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer byteBuffer = this.bb;
            int i3 = this.space - 1;
            this.space = i3;
            byteBuffer.put(i3, (byte) 0);
        }
    }

    public void prep(int i, int i2) {
        if (i > this.minalign) {
            this.minalign = i;
        }
        int i3 = ((~((this.bb.capacity() - this.space) + i2)) + 1) & (i - 1);
        while (this.space < i3 + i + i2) {
            int capacity = this.bb.capacity();
            ByteBuffer growByteBuffer = growByteBuffer(this.bb, this.bb_factory);
            this.bb = growByteBuffer;
            this.space += growByteBuffer.capacity() - capacity;
        }
        pad(i3);
    }

    public void putBoolean(boolean z) {
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - 1;
        this.space = i;
        byteBuffer.put(i, z ? (byte) 1 : (byte) 0);
    }

    public void putByte(byte b) {
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - 1;
        this.space = i;
        byteBuffer.put(i, b);
    }

    public void putShort(short s) {
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - 2;
        this.space = i;
        byteBuffer.putShort(i, s);
    }

    public void putInt(int i) {
        ByteBuffer byteBuffer = this.bb;
        int i2 = this.space - 4;
        this.space = i2;
        byteBuffer.putInt(i2, i);
    }

    public void putLong(long j) {
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - 8;
        this.space = i;
        byteBuffer.putLong(i, j);
    }

    public void putFloat(float f) {
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - 4;
        this.space = i;
        byteBuffer.putFloat(i, f);
    }

    public void putDouble(double d) {
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - 8;
        this.space = i;
        byteBuffer.putDouble(i, d);
    }

    public void addBoolean(boolean z) {
        prep(1, 0);
        putBoolean(z);
    }

    public void addByte(byte b) {
        prep(1, 0);
        putByte(b);
    }

    public void addShort(short s) {
        prep(2, 0);
        putShort(s);
    }

    public void addInt(int i) {
        prep(4, 0);
        putInt(i);
    }

    public void addLong(long j) {
        prep(8, 0);
        putLong(j);
    }

    public void addFloat(float f) {
        prep(4, 0);
        putFloat(f);
    }

    public void addDouble(double d) {
        prep(8, 0);
        putDouble(d);
    }

    public void addOffset(int i) {
        prep(4, 0);
        putInt((offset() - i) + 4);
    }

    public void startVector(int i, int i2, int i3) {
        notNested();
        this.vector_num_elems = i2;
        int i4 = i * i2;
        prep(4, i4);
        prep(i3, i4);
        this.nested = true;
    }

    public int endVector() {
        if (!this.nested) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.nested = false;
        putInt(this.vector_num_elems);
        return offset();
    }

    public ByteBuffer createUnintializedVector(int i, int i2, int i3) {
        int i4 = i * i2;
        startVector(i, i2, i3);
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - i4;
        this.space = i5;
        byteBuffer.position(i5);
        ByteBuffer order = this.bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        order.limit(i4);
        return order;
    }

    public int createVectorOfTables(int[] iArr) {
        notNested();
        startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            addOffset(iArr[length]);
        }
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T t, int[] iArr) {
        t.sortTables(iArr, this.bb);
        return createVectorOfTables(iArr);
    }

    public int createString(CharSequence charSequence) {
        int length = (int) (charSequence.length() * this.encoder.maxBytesPerChar());
        ByteBuffer byteBuffer = this.dst;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            this.dst = ByteBuffer.allocate(Math.max(128, length));
        }
        this.dst.clear();
        CoderResult encode = this.encoder.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), this.dst, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e) {
                throw new Error(e);
            }
        }
        this.dst.flip();
        return createString(this.dst);
    }

    public int createString(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        addByte((byte) 0);
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.bb;
        int i = this.space - remaining;
        this.space = i;
        byteBuffer2.position(i);
        this.bb.put(byteBuffer);
        return endVector();
    }

    public int createByteVector(byte[] bArr) {
        int length = bArr.length;
        startVector(1, length, 1);
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - length;
        this.space = i;
        byteBuffer.position(i);
        this.bb.put(bArr);
        return endVector();
    }

    public void finished() {
        if (!this.finished) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public void notNested() {
        if (this.nested) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public void Nested(int i) {
        if (i != offset()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void startObject(int i) {
        notNested();
        int[] iArr = this.vtable;
        if (iArr == null || iArr.length < i) {
            this.vtable = new int[i];
        }
        this.vtable_in_use = i;
        Arrays.fill(this.vtable, 0, i, 0);
        this.nested = true;
        this.object_start = offset();
    }

    public void addBoolean(int i, boolean z, boolean z2) {
        if (this.force_defaults || z != z2) {
            addBoolean(z);
            slot(i);
        }
    }

    public void addByte(int i, byte b, int i2) {
        if (this.force_defaults || b != i2) {
            addByte(b);
            slot(i);
        }
    }

    public void addShort(int i, short s, int i2) {
        if (this.force_defaults || s != i2) {
            addShort(s);
            slot(i);
        }
    }

    public void addInt(int i, int i2, int i3) {
        if (this.force_defaults || i2 != i3) {
            addInt(i2);
            slot(i);
        }
    }

    public void addLong(int i, long j, long j2) {
        if (this.force_defaults || j != j2) {
            addLong(j);
            slot(i);
        }
    }

    public void addFloat(int i, float f, double d) {
        if (this.force_defaults || f != d) {
            addFloat(f);
            slot(i);
        }
    }

    public void addDouble(int i, double d, double d2) {
        if (this.force_defaults || d != d2) {
            addDouble(d);
            slot(i);
        }
    }

    public void addOffset(int i, int i2, int i3) {
        if (this.force_defaults || i2 != i3) {
            addOffset(i2);
            slot(i);
        }
    }

    public void addStruct(int i, int i2, int i3) {
        if (i2 != i3) {
            Nested(i2);
            slot(i);
        }
    }

    public void slot(int i) {
        this.vtable[i] = offset();
    }

    public int endObject() {
        int i;
        if (this.vtable == null || !this.nested) {
            throw new AssertionError("FlatBuffers: endObject called without startObject");
        }
        addInt(0);
        int offset = offset();
        int i2 = this.vtable_in_use - 1;
        while (i2 >= 0 && this.vtable[i2] == 0) {
            i2--;
        }
        for (int i3 = i2; i3 >= 0; i3--) {
            int i4 = this.vtable[i3];
            addShort((short) (i4 != 0 ? offset - i4 : 0));
        }
        addShort((short) (offset - this.object_start));
        addShort((short) ((i2 + 3) * 2));
        int i5 = 0;
        loop2: while (true) {
            if (i5 >= this.num_vtables) {
                i = 0;
                break;
            }
            int capacity = this.bb.capacity() - this.vtables[i5];
            int i6 = this.space;
            short s = this.bb.getShort(capacity);
            if (s == this.bb.getShort(i6)) {
                for (int i7 = 2; i7 < s; i7 += 2) {
                    if (this.bb.getShort(capacity + i7) != this.bb.getShort(i6 + i7)) {
                        break;
                    }
                }
                i = this.vtables[i5];
                break loop2;
            }
            i5++;
        }
        if (i != 0) {
            int capacity2 = this.bb.capacity() - offset;
            this.space = capacity2;
            this.bb.putInt(capacity2, i - offset);
        } else {
            int i8 = this.num_vtables;
            int[] iArr = this.vtables;
            if (i8 == iArr.length) {
                this.vtables = Arrays.copyOf(iArr, i8 * 2);
            }
            int[] iArr2 = this.vtables;
            int i9 = this.num_vtables;
            this.num_vtables = i9 + 1;
            iArr2[i9] = offset();
            ByteBuffer byteBuffer = this.bb;
            byteBuffer.putInt(byteBuffer.capacity() - offset, offset() - offset);
        }
        this.nested = false;
        return offset;
    }

    public void required(int i, int i2) {
        int capacity = this.bb.capacity() - i;
        if (this.bb.getShort((capacity - this.bb.getInt(capacity)) + i2) == 0) {
            throw new AssertionError("FlatBuffers: field " + i2 + " must be set");
        }
    }

    public void finish(int i) {
        prep(this.minalign, 4);
        addOffset(i);
        this.bb.position(this.space);
        this.finished = true;
    }

    public void finish(int i, String str) {
        prep(this.minalign, 8);
        if (str.length() != 4) {
            throw new AssertionError("FlatBuffers: file identifier must be length 4");
        }
        for (int i2 = 3; i2 >= 0; i2--) {
            addByte((byte) str.charAt(i2));
        }
        finish(i);
    }

    public FlatBufferBuilder forceDefaults(boolean z) {
        this.force_defaults = z;
        return this;
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.bb;
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    public byte[] sizedByteArray(int i, int i2) {
        finished();
        byte[] bArr = new byte[i2];
        this.bb.position(i);
        this.bb.get(bArr);
        return bArr;
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, this.bb.capacity() - this.space);
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer duplicate = this.bb.duplicate();
        duplicate.position(this.space);
        duplicate.limit(this.bb.capacity());
        return new ByteBufferBackedInputStream(duplicate);
    }

    /* loaded from: classes3.dex */
    static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.buf.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }
}
