package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.gj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0283gj extends MessageNano {
    public static volatile C0283gj[] d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f899a;
    public C0257fj b;
    public C0231ej c;

    public C0283gj() {
        a();
    }

    public static C0283gj[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C0283gj[0];
                }
            }
        }
        return d;
    }

    public final C0283gj a() {
        this.f899a = false;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f899a;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        C0257fj c0257fj = this.b;
        if (c0257fj != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0257fj);
        }
        C0231ej c0231ej = this.c;
        return c0231ej != null ? CodedOutputByteBufferNano.computeMessageSize(3, c0231ej) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f899a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        C0257fj c0257fj = this.b;
        if (c0257fj != null) {
            codedOutputByteBufferNano.writeMessage(2, c0257fj);
        }
        C0231ej c0231ej = this.c;
        if (c0231ej != null) {
            codedOutputByteBufferNano.writeMessage(3, c0231ej);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0283gj mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f899a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0257fj();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new C0231ej();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static C0283gj b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0283gj().mergeFrom(codedInputByteBufferNano);
    }

    public static C0283gj a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0283gj) MessageNano.mergeFrom(new C0283gj(), bArr);
    }
}
