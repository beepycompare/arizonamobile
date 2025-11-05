package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.h6  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0289h6 extends MessageNano {
    public static volatile C0289h6[] g;

    /* renamed from: a  reason: collision with root package name */
    public String f906a;
    public int b;
    public long c;
    public String d;
    public int e;
    public C0263g6[] f;

    public C0289h6() {
        a();
    }

    public static C0289h6[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0289h6[0];
                }
            }
        }
        return g;
    }

    public final C0289h6 a() {
        this.f906a = "";
        this.b = 0;
        this.c = 0L;
        this.d = "";
        this.e = 0;
        this.f = C0263g6.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSInt64Size = CodedOutputByteBufferNano.computeSInt64Size(3, this.c) + CodedOutputByteBufferNano.computeSInt32Size(2, this.b) + CodedOutputByteBufferNano.computeStringSize(1, this.f906a) + super.computeSerializedSize();
        if (!this.d.equals("")) {
            computeSInt64Size += CodedOutputByteBufferNano.computeStringSize(4, this.d);
        }
        int i = this.e;
        if (i != 0) {
            computeSInt64Size += CodedOutputByteBufferNano.computeUInt32Size(5, i);
        }
        C0263g6[] c0263g6Arr = this.f;
        if (c0263g6Arr != null && c0263g6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0263g6[] c0263g6Arr2 = this.f;
                if (i2 >= c0263g6Arr2.length) {
                    break;
                }
                C0263g6 c0263g6 = c0263g6Arr2[i2];
                if (c0263g6 != null) {
                    computeSInt64Size = CodedOutputByteBufferNano.computeMessageSize(6, c0263g6) + computeSInt64Size;
                }
                i2++;
            }
        }
        return computeSInt64Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f906a);
        codedOutputByteBufferNano.writeSInt32(2, this.b);
        codedOutputByteBufferNano.writeSInt64(3, this.c);
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.d);
        }
        int i = this.e;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i);
        }
        C0263g6[] c0263g6Arr = this.f;
        if (c0263g6Arr != null && c0263g6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0263g6[] c0263g6Arr2 = this.f;
                if (i2 >= c0263g6Arr2.length) {
                    break;
                }
                C0263g6 c0263g6 = c0263g6Arr2[i2];
                if (c0263g6 != null) {
                    codedOutputByteBufferNano.writeMessage(6, c0263g6);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0289h6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f906a = codedInputByteBufferNano.readString();
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
                C0263g6[] c0263g6Arr = this.f;
                int length = c0263g6Arr == null ? 0 : c0263g6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0263g6[] c0263g6Arr2 = new C0263g6[i];
                if (length != 0) {
                    System.arraycopy(c0263g6Arr, 0, c0263g6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0263g6 c0263g6 = new C0263g6();
                    c0263g6Arr2[length] = c0263g6;
                    codedInputByteBufferNano.readMessage(c0263g6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0263g6 c0263g62 = new C0263g6();
                c0263g6Arr2[length] = c0263g62;
                codedInputByteBufferNano.readMessage(c0263g62);
                this.f = c0263g6Arr2;
            }
        }
        return this;
    }

    public static C0289h6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0289h6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0289h6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0289h6) MessageNano.mergeFrom(new C0289h6(), bArr);
    }
}
