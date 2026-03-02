package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.a6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0111a6 extends MessageNano {
    public static volatile C0111a6[] g;

    /* renamed from: a  reason: collision with root package name */
    public String f899a;
    public int b;
    public long c;
    public String d;
    public int e;
    public Z5[] f;

    public C0111a6() {
        a();
    }

    public static C0111a6[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0111a6[0];
                }
            }
        }
        return g;
    }

    public final C0111a6 a() {
        this.f899a = "";
        this.b = 0;
        this.c = 0L;
        this.d = "";
        this.e = 0;
        this.f = Z5.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSInt64Size = CodedOutputByteBufferNano.computeSInt64Size(3, this.c) + CodedOutputByteBufferNano.computeSInt32Size(2, this.b) + CodedOutputByteBufferNano.computeStringSize(1, this.f899a) + super.computeSerializedSize();
        if (!this.d.equals("")) {
            computeSInt64Size += CodedOutputByteBufferNano.computeStringSize(4, this.d);
        }
        int i = this.e;
        if (i != 0) {
            computeSInt64Size += CodedOutputByteBufferNano.computeUInt32Size(5, i);
        }
        Z5[] z5Arr = this.f;
        if (z5Arr != null && z5Arr.length > 0) {
            int i2 = 0;
            while (true) {
                Z5[] z5Arr2 = this.f;
                if (i2 >= z5Arr2.length) {
                    break;
                }
                Z5 z5 = z5Arr2[i2];
                if (z5 != null) {
                    computeSInt64Size = CodedOutputByteBufferNano.computeMessageSize(6, z5) + computeSInt64Size;
                }
                i2++;
            }
        }
        return computeSInt64Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f899a);
        codedOutputByteBufferNano.writeSInt32(2, this.b);
        codedOutputByteBufferNano.writeSInt64(3, this.c);
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.d);
        }
        int i = this.e;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i);
        }
        Z5[] z5Arr = this.f;
        if (z5Arr != null && z5Arr.length > 0) {
            int i2 = 0;
            while (true) {
                Z5[] z5Arr2 = this.f;
                if (i2 >= z5Arr2.length) {
                    break;
                }
                Z5 z5 = z5Arr2[i2];
                if (z5 != null) {
                    codedOutputByteBufferNano.writeMessage(6, z5);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0111a6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f899a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.b = codedInputByteBufferNano.readSInt32();
            } else if (readTag == 24) {
                this.c = codedInputByteBufferNano.readSInt64();
            } else if (readTag == 34) {
                this.d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.e = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                Z5[] z5Arr = this.f;
                int length = z5Arr == null ? 0 : z5Arr.length;
                int i = repeatedFieldArrayLength + length;
                Z5[] z5Arr2 = new Z5[i];
                if (length != 0) {
                    System.arraycopy(z5Arr, 0, z5Arr2, 0, length);
                }
                while (length < i - 1) {
                    Z5 z5 = new Z5();
                    z5Arr2[length] = z5;
                    codedInputByteBufferNano.readMessage(z5);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Z5 z52 = new Z5();
                z5Arr2[length] = z52;
                codedInputByteBufferNano.readMessage(z52);
                this.f = z5Arr2;
            }
        }
        return this;
    }

    public static C0111a6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0111a6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0111a6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0111a6) MessageNano.mergeFrom(new C0111a6(), bArr);
    }
}
