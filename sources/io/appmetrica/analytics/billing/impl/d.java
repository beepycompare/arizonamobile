package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class d extends MessageNano {
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static volatile d[] f;

    /* renamed from: a  reason: collision with root package name */
    public c[] f296a;
    public boolean b;

    public d() {
        a();
    }

    public static d[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new d[0];
                }
            }
        }
        return f;
    }

    public final d a() {
        this.f296a = c.b();
        this.b = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        c[] cVarArr = this.f296a;
        if (cVarArr != null && cVarArr.length > 0) {
            int i = 0;
            while (true) {
                c[] cVarArr2 = this.f296a;
                if (i >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
                }
                i++;
            }
        }
        return CodedOutputByteBufferNano.computeBoolSize(2, this.b) + computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        c[] cVarArr = this.f296a;
        if (cVarArr != null && cVarArr.length > 0) {
            int i = 0;
            while (true) {
                c[] cVarArr2 = this.f296a;
                if (i >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, cVar);
                }
                i++;
            }
        }
        codedOutputByteBufferNano.writeBool(2, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                c[] cVarArr = this.f296a;
                int length = cVarArr == null ? 0 : cVarArr.length;
                int i = repeatedFieldArrayLength + length;
                c[] cVarArr2 = new c[i];
                if (length != 0) {
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                }
                while (length < i - 1) {
                    c cVar = new c();
                    cVarArr2[length] = cVar;
                    codedInputByteBufferNano.readMessage(cVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                c cVar2 = new c();
                cVarArr2[length] = cVar2;
                codedInputByteBufferNano.readMessage(cVar2);
                this.f296a = cVarArr2;
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readBool();
            }
        }
        return this;
    }

    public static d b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new d().mergeFrom(codedInputByteBufferNano);
    }

    public static d a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }
}
