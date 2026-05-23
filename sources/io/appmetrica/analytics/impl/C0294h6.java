package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.h6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0294h6 extends MessageNano {
    public static volatile C0294h6[] d;

    /* renamed from: a  reason: collision with root package name */
    public C0527q6 f1007a;
    public C0527q6[] b;
    public String c;

    public C0294h6() {
        a();
    }

    public static C0294h6[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C0294h6[0];
                }
            }
        }
        return d;
    }

    public final C0294h6 a() {
        this.f1007a = null;
        this.b = C0527q6.b();
        this.c = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0527q6 c0527q6 = this.f1007a;
        if (c0527q6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0527q6);
        }
        C0527q6[] c0527q6Arr = this.b;
        if (c0527q6Arr != null && c0527q6Arr.length > 0) {
            int i = 0;
            while (true) {
                C0527q6[] c0527q6Arr2 = this.b;
                if (i >= c0527q6Arr2.length) {
                    break;
                }
                C0527q6 c0527q62 = c0527q6Arr2[i];
                if (c0527q62 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0527q62);
                }
                i++;
            }
        }
        return !this.c.equals("") ? CodedOutputByteBufferNano.computeStringSize(3, this.c) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0527q6 c0527q6 = this.f1007a;
        if (c0527q6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0527q6);
        }
        C0527q6[] c0527q6Arr = this.b;
        if (c0527q6Arr != null && c0527q6Arr.length > 0) {
            int i = 0;
            while (true) {
                C0527q6[] c0527q6Arr2 = this.b;
                if (i >= c0527q6Arr2.length) {
                    break;
                }
                C0527q6 c0527q62 = c0527q6Arr2[i];
                if (c0527q62 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0527q62);
                }
                i++;
            }
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0294h6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1007a == null) {
                    this.f1007a = new C0527q6();
                }
                codedInputByteBufferNano.readMessage(this.f1007a);
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0527q6[] c0527q6Arr = this.b;
                int length = c0527q6Arr == null ? 0 : c0527q6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0527q6[] c0527q6Arr2 = new C0527q6[i];
                if (length != 0) {
                    System.arraycopy(c0527q6Arr, 0, c0527q6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0527q6 c0527q6 = new C0527q6();
                    c0527q6Arr2[length] = c0527q6;
                    codedInputByteBufferNano.readMessage(c0527q6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0527q6 c0527q62 = new C0527q6();
                c0527q6Arr2[length] = c0527q62;
                codedInputByteBufferNano.readMessage(c0527q62);
                this.b = c0527q6Arr2;
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.c = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static C0294h6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0294h6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0294h6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0294h6) MessageNano.mergeFrom(new C0294h6(), bArr);
    }
}
