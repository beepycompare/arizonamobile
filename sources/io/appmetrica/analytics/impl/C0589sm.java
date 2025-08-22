package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.sm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0589sm extends MessageNano {
    public static volatile C0589sm[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0564rm[] f1066a;

    public C0589sm() {
        a();
    }

    public static C0589sm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0589sm[0];
                }
            }
        }
        return b;
    }

    public final C0589sm a() {
        this.f1066a = C0564rm.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0564rm[] c0564rmArr = this.f1066a;
        if (c0564rmArr != null && c0564rmArr.length > 0) {
            int i = 0;
            while (true) {
                C0564rm[] c0564rmArr2 = this.f1066a;
                if (i >= c0564rmArr2.length) {
                    break;
                }
                C0564rm c0564rm = c0564rmArr2[i];
                if (c0564rm != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0564rm) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0564rm[] c0564rmArr = this.f1066a;
        if (c0564rmArr != null && c0564rmArr.length > 0) {
            int i = 0;
            while (true) {
                C0564rm[] c0564rmArr2 = this.f1066a;
                if (i >= c0564rmArr2.length) {
                    break;
                }
                C0564rm c0564rm = c0564rmArr2[i];
                if (c0564rm != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0564rm);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0589sm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0564rm[] c0564rmArr = this.f1066a;
                int length = c0564rmArr == null ? 0 : c0564rmArr.length;
                int i = repeatedFieldArrayLength + length;
                C0564rm[] c0564rmArr2 = new C0564rm[i];
                if (length != 0) {
                    System.arraycopy(c0564rmArr, 0, c0564rmArr2, 0, length);
                }
                while (length < i - 1) {
                    C0564rm c0564rm = new C0564rm();
                    c0564rmArr2[length] = c0564rm;
                    codedInputByteBufferNano.readMessage(c0564rm);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0564rm c0564rm2 = new C0564rm();
                c0564rmArr2[length] = c0564rm2;
                codedInputByteBufferNano.readMessage(c0564rm2);
                this.f1066a = c0564rmArr2;
            }
        }
        return this;
    }

    public static C0589sm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0589sm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0589sm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0589sm) MessageNano.mergeFrom(new C0589sm(), bArr);
    }
}
