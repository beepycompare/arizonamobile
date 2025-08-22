package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.cj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0180cj extends MessageNano {
    public static volatile C0180cj[] d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f815a;
    public C0154bj b;
    public C0128aj c;

    public C0180cj() {
        a();
    }

    public static C0180cj[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C0180cj[0];
                }
            }
        }
        return d;
    }

    public final C0180cj a() {
        this.f815a = false;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f815a;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        C0154bj c0154bj = this.b;
        if (c0154bj != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0154bj);
        }
        C0128aj c0128aj = this.c;
        return c0128aj != null ? CodedOutputByteBufferNano.computeMessageSize(3, c0128aj) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f815a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        C0154bj c0154bj = this.b;
        if (c0154bj != null) {
            codedOutputByteBufferNano.writeMessage(2, c0154bj);
        }
        C0128aj c0128aj = this.c;
        if (c0128aj != null) {
            codedOutputByteBufferNano.writeMessage(3, c0128aj);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0180cj mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f815a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0154bj();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new C0128aj();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static C0180cj b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0180cj().mergeFrom(codedInputByteBufferNano);
    }

    public static C0180cj a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0180cj) MessageNano.mergeFrom(new C0180cj(), bArr);
    }
}
