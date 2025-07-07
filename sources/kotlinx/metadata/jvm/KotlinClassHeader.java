package kotlinx.metadata.jvm;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
@Deprecated(level = DeprecationLevel.ERROR, message = "Kotlin clients should instantiate Metadata annotation directly", replaceWith = @ReplaceWith(expression = "Metadata", imports = {}))
/* loaded from: classes5.dex */
public final class KotlinClassHeader implements Metadata {
    @Deprecated
    public static final int CLASS_KIND = 1;
    @Deprecated
    public static final int[] COMPATIBLE_METADATA_VERSION = Arrays.copyOf(kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMetadataVersion.INSTANCE.toArray(), 3);
    @Deprecated
    public static final int FILE_FACADE_KIND = 2;
    @Deprecated
    public static final int MULTI_FILE_CLASS_FACADE_KIND = 4;
    @Deprecated
    public static final int MULTI_FILE_CLASS_PART_KIND = 5;
    @Deprecated
    public static final int SYNTHETIC_CLASS_KIND = 3;
    private final String[] d1;
    private final String[] d2;
    private final int k;
    private final int[] mv;
    private final String pn;
    private final int xi;
    private final String xs;

    @Deprecated(level = DeprecationLevel.ERROR, message = "Kotlin clients should instantiate Metadata annotation directly", replaceWith = @ReplaceWith(expression = "kotlinx.metadata.jvm.Metadata(kind, metadataVersion, data1, data2, extraString, packageName, extraInt)", imports = {}))
    public KotlinClassHeader(Integer num, int[] iArr, String[] strArr, String[] strArr2, String str, String str2, Integer num2) {
        this.k = num != null ? num.intValue() : 1;
        if (iArr != null) {
            this.mv = iArr;
        } else {
            this.mv = new int[0];
        }
        if (strArr != null) {
            this.d1 = strArr;
        } else {
            this.d1 = new String[0];
        }
        if (strArr2 != null) {
            this.d2 = strArr2;
        } else {
            this.d2 = new String[0];
        }
        if (str != null) {
            this.xs = str;
        } else {
            this.xs = "";
        }
        if (str2 == null) {
            this.pn = "";
        } else {
            this.pn = str2;
        }
        if (num2 != null) {
            this.xi = num2.intValue();
        } else {
            this.xi = 0;
        }
    }

    @Override // kotlin.Metadata
    public int k() {
        return this.k;
    }

    @Override // kotlin.Metadata
    public int[] mv() {
        return this.mv;
    }

    @Override // kotlin.Metadata
    @Deprecated
    public int[] bv() {
        return new int[]{1, 0, 3};
    }

    @Override // kotlin.Metadata
    public String[] d1() {
        return this.d1;
    }

    @Override // kotlin.Metadata
    public String[] d2() {
        return this.d2;
    }

    @Override // kotlin.Metadata
    public String xs() {
        return this.xs;
    }

    @Override // kotlin.Metadata
    public String pn() {
        return this.pn;
    }

    @Override // kotlin.Metadata
    public int xi() {
        return this.xi;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return Metadata.class;
    }
}
