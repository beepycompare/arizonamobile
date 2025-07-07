package kotlinx.metadata.internal.metadata.jvm.deserialization;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: utfEncoding.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t\u001a\u0019\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"MAX_UTF8_INFO_LENGTH", "", "UTF8_MODE_MARKER", "", "bytesToStrings", "", "", "bytes", "", "([B)[Ljava/lang/String;", "stringsToBytes", "strings", "([Ljava/lang/String;)[B", "metadata.jvm"}, k = 2, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public final class UtfEncodingKt {
    public static final int MAX_UTF8_INFO_LENGTH = 65535;
    public static final char UTF8_MODE_MARKER = 0;

    public static final String[] bytesToStrings(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        ArrayList arrayList = new ArrayList(1);
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        int length = bytes.length;
        int i = 2;
        for (int i2 = 0; i2 < length; i2++) {
            byte b = bytes[i2];
            sb.append((char) (b & 255));
            i = (1 > b || b >= 128) ? i + 2 : i + 1;
            if (i >= 65534) {
                arrayList.add(sb.toString());
                sb.setLength(0);
                i = 0;
            }
        }
        if (sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final byte[] stringsToBytes(String[] strings) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        int i = 0;
        for (String str : strings) {
            i += str.length();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (String str2 : strings) {
            int length = str2.length();
            int i3 = 0;
            while (i3 < length) {
                bArr[i2] = (byte) str2.charAt(i3);
                i3++;
                i2++;
            }
        }
        return bArr;
    }
}
