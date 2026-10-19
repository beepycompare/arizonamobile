package kotlinx.metadata.jvm;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.metadata.ClassNameKt;
/* compiled from: JvmMetadataUtil.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\u001ak\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0013\u001a\u000e\u0010\u0014\u001a\u00020\u0001*\u00060\u0001j\u0002`\u0002\"\"\u0010\u0000\u001a\u00020\u0001*\u00060\u0001j\u0002`\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"jvmInternalName", "", "Lkotlinx/metadata/ClassName;", "getJvmInternalName$annotations", "(Ljava/lang/String;)V", "getJvmInternalName", "(Ljava/lang/String;)Ljava/lang/String;", "Metadata", "Lkotlin/Metadata;", "kind", "", "metadataVersion", "", "data1", "", "data2", "extraString", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "extraInt", "(Ljava/lang/Integer;[I[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lkotlin/Metadata;", "toJvmInternalName", "kotlinx-metadata-jvm"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmMetadataUtil {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Renamed to toJvmInternalName() to avoid confusion with String properties", replaceWith = @ReplaceWith(expression = "toJvmInternalName()", imports = {}))
    public static /* synthetic */ void getJvmInternalName$annotations(String str) {
    }

    public static final String toJvmInternalName(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (ClassNameKt.isLocalClassName(str)) {
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return StringsKt.replace$default(str, '.', (char) Typography.dollar, false, 4, (Object) null);
    }

    public static final String getJvmInternalName(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toJvmInternalName(str);
    }

    public static /* synthetic */ Metadata Metadata$default(Integer num, int[] iArr, String[] strArr, String[] strArr2, String str, String str2, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            iArr = null;
        }
        if ((i & 4) != 0) {
            strArr = null;
        }
        if ((i & 8) != 0) {
            strArr2 = null;
        }
        if ((i & 16) != 0) {
            str = null;
        }
        if ((i & 32) != 0) {
            str2 = null;
        }
        if ((i & 64) != 0) {
            num2 = null;
        }
        return Metadata(num, iArr, strArr, strArr2, str, str2, num2);
    }

    public static final Metadata Metadata(Integer num, int[] iArr, String[] strArr, String[] strArr2, String str, String str2, Integer num2) {
        int[] iArr2 = {1, 0, 3};
        if (strArr == null) {
            strArr = new String[0];
        }
        if (strArr2 == null) {
            strArr2 = new String[0];
        }
        int intValue = num2 != null ? num2.intValue() : 0;
        String str3 = str == null ? "" : str;
        int intValue2 = num != null ? num.intValue() : 1;
        if (iArr == null) {
            iArr = new int[0];
        }
        return new JvmMetadataUtil$annotationImpl$kotlin_Metadata$0(iArr2, strArr, strArr2, intValue, str3, intValue2, iArr, str2 == null ? "" : str2);
    }
}
