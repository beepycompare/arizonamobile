package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.jo  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0358jo extends MessageNano {
    public static volatile C0358jo[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0281go[] f963a;

    public C0358jo() {
        a();
    }

    public static C0358jo[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0358jo[0];
                }
            }
        }
        return b;
    }

    public final C0358jo a() {
        this.f963a = C0281go.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0281go[] c0281goArr = this.f963a;
        if (c0281goArr != null && c0281goArr.length > 0) {
            int i = 0;
            while (true) {
                C0281go[] c0281goArr2 = this.f963a;
                if (i >= c0281goArr2.length) {
                    break;
                }
                C0281go c0281go = c0281goArr2[i];
                if (c0281go != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0281go) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0281go[] c0281goArr = this.f963a;
        if (c0281goArr != null && c0281goArr.length > 0) {
            int i = 0;
            while (true) {
                C0281go[] c0281goArr2 = this.f963a;
                if (i >= c0281goArr2.length) {
                    break;
                }
                C0281go c0281go = c0281goArr2[i];
                if (c0281go != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0281go);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0358jo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                C0281go[] c0281goArr = this.f963a;
                int length = c0281goArr == null ? 0 : c0281goArr.length;
                int i = repeatedFieldArrayLength + length;
                C0281go[] c0281goArr2 = new C0281go[i];
                if (length != 0) {
                    System.arraycopy(c0281goArr, 0, c0281goArr2, 0, length);
                }
                while (length < i - 1) {
                    C0281go c0281go = new C0281go();
                    c0281goArr2[length] = c0281go;
                    codedInputByteBufferNano.readMessage(c0281go);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0281go c0281go2 = new C0281go();
                c0281goArr2[length] = c0281go2;
                codedInputByteBufferNano.readMessage(c0281go2);
                this.f963a = c0281goArr2;
            }
        }
        return this;
    }

    public static C0358jo b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0358jo().mergeFrom(codedInputByteBufferNano);
    }

    public static C0358jo a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0358jo) MessageNano.mergeFrom(new C0358jo(), bArr);
    }
}
