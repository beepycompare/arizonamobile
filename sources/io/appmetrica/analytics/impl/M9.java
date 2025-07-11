package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class M9 extends MessageNano {
    public static volatile M9[] e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f533a;
    public int b;
    public int c;
    public int[] d;

    public M9() {
        a();
    }

    public static M9[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new M9[0];
                }
            }
        }
        return e;
    }

    public final M9 a() {
        this.f533a = false;
        this.b = 0;
        this.c = 0;
        this.d = WireFormatNano.EMPTY_INT_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeUInt32Size = CodedOutputByteBufferNano.computeUInt32Size(3, this.c) + CodedOutputByteBufferNano.computeUInt32Size(2, this.b) + CodedOutputByteBufferNano.computeBoolSize(1, this.f533a) + super.computeSerializedSize();
        int[] iArr = this.d;
        if (iArr == null || iArr.length <= 0) {
            return computeUInt32Size;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr2 = this.d;
            if (i < iArr2.length) {
                i2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i]);
                i++;
            } else {
                return computeUInt32Size + i2 + iArr2.length;
            }
        }
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeBool(1, this.f533a);
        codedOutputByteBufferNano.writeUInt32(2, this.b);
        codedOutputByteBufferNano.writeUInt32(3, this.c);
        int[] iArr = this.d;
        if (iArr != null && iArr.length > 0) {
            int i = 0;
            while (true) {
                int[] iArr2 = this.d;
                if (i >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(4, iArr2[i]);
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final M9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f533a = codedInputByteBufferNano.readBool();
            } else if (readTag == 16) {
                this.b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                int[] iArr = this.d;
                int length = iArr == null ? 0 : iArr.length;
                int i = repeatedFieldArrayLength + length;
                int[] iArr2 = new int[i];
                if (length != 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, length);
                }
                while (length < i - 1) {
                    iArr2[length] = codedInputByteBufferNano.readInt32();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                iArr2[length] = codedInputByteBufferNano.readInt32();
                this.d = iArr2;
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i2 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readInt32();
                    i2++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.d;
                int length2 = iArr3 == null ? 0 : iArr3.length;
                int i3 = i2 + length2;
                int[] iArr4 = new int[i3];
                if (length2 != 0) {
                    System.arraycopy(iArr3, 0, iArr4, 0, length2);
                }
                while (length2 < i3) {
                    iArr4[length2] = codedInputByteBufferNano.readInt32();
                    length2++;
                }
                this.d = iArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            }
        }
        return this;
    }

    public static M9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new M9().mergeFrom(codedInputByteBufferNano);
    }

    public static M9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (M9) MessageNano.mergeFrom(new M9(), bArr);
    }
}
