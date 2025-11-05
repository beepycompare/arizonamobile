package io.appmetrica.analytics.idsync.impl;

import androidx.compose.material3.internal.CalendarModelKt;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes3.dex */
public final class m extends MessageNano {
    public static volatile m[] h;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f369a;
    public l b;
    public byte[] c;
    public k[] d;
    public long e;
    public long f;
    public int[] g;

    public m() {
        a();
    }

    public static m[] b() {
        if (h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (h == null) {
                    h = new m[0];
                }
            }
        }
        return h;
    }

    public final m a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f369a = bArr;
        this.b = null;
        this.c = bArr;
        this.d = k.b();
        this.e = CalendarModelKt.MillisecondsIn24Hours;
        this.f = 3600000L;
        this.g = WireFormatNano.EMPTY_INT_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f369a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f369a);
        }
        l lVar = this.b;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, lVar);
        }
        if (!Arrays.equals(this.c, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.c);
        }
        k[] kVarArr = this.d;
        int i = 0;
        if (kVarArr != null && kVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                k[] kVarArr2 = this.d;
                if (i2 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i2];
                if (kVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, kVar);
                }
                i2++;
            }
        }
        long j = this.e;
        if (j != CalendarModelKt.MillisecondsIn24Hours) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        long j2 = this.f;
        if (j2 != 3600000) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
        }
        int[] iArr = this.g;
        if (iArr == null || iArr.length <= 0) {
            return computeSerializedSize;
        }
        int i3 = 0;
        while (true) {
            int[] iArr2 = this.g;
            if (i < iArr2.length) {
                i3 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i]);
                i++;
            } else {
                return computeSerializedSize + i3 + iArr2.length;
            }
        }
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f369a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f369a);
        }
        l lVar = this.b;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(2, lVar);
        }
        if (!Arrays.equals(this.c, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.c);
        }
        k[] kVarArr = this.d;
        int i = 0;
        if (kVarArr != null && kVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                k[] kVarArr2 = this.d;
                if (i2 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i2];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, kVar);
                }
                i2++;
            }
        }
        long j = this.e;
        if (j != CalendarModelKt.MillisecondsIn24Hours) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        long j2 = this.f;
        if (j2 != 3600000) {
            codedOutputByteBufferNano.writeUInt64(6, j2);
        }
        int[] iArr = this.g;
        if (iArr != null && iArr.length > 0) {
            while (true) {
                int[] iArr2 = this.g;
                if (i >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(7, iArr2[i]);
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f369a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new l();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 26) {
                this.c = codedInputByteBufferNano.readBytes();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                k[] kVarArr = this.d;
                int length = kVarArr == null ? 0 : kVarArr.length;
                int i = repeatedFieldArrayLength + length;
                k[] kVarArr2 = new k[i];
                if (length != 0) {
                    System.arraycopy(kVarArr, 0, kVarArr2, 0, length);
                }
                while (length < i - 1) {
                    k kVar = new k();
                    kVarArr2[length] = kVar;
                    codedInputByteBufferNano.readMessage(kVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                k kVar2 = new k();
                kVarArr2[length] = kVar2;
                codedInputByteBufferNano.readMessage(kVar2);
                this.d = kVarArr2;
            } else if (readTag == 40) {
                this.e = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                this.f = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 56) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 56);
                int[] iArr = this.g;
                int length2 = iArr == null ? 0 : iArr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                int[] iArr2 = new int[i2];
                if (length2 != 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    iArr2[length2] = codedInputByteBufferNano.readUInt32();
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                iArr2[length2] = codedInputByteBufferNano.readUInt32();
                this.g = iArr2;
            } else if (readTag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i3 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i3++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.g;
                int length3 = iArr3 == null ? 0 : iArr3.length;
                int i4 = i3 + length3;
                int[] iArr4 = new int[i4];
                if (length3 != 0) {
                    System.arraycopy(iArr3, 0, iArr4, 0, length3);
                }
                while (length3 < i4) {
                    iArr4[length3] = codedInputByteBufferNano.readUInt32();
                    length3++;
                }
                this.g = iArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            }
        }
        return this;
    }

    public static m b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new m().mergeFrom(codedInputByteBufferNano);
    }

    public static m a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (m) MessageNano.mergeFrom(new m(), bArr);
    }
}
