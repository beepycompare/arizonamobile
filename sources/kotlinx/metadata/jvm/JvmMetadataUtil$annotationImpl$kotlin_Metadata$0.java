package kotlinx.metadata.jvm;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: JvmMetadataUtil.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public /* synthetic */ class JvmMetadataUtil$annotationImpl$kotlin_Metadata$0 implements Metadata {
    private final /* synthetic */ int[] bytecodeVersion;
    private final /* synthetic */ String[] data1;
    private final /* synthetic */ String[] data2;
    private final /* synthetic */ int extraInt;
    private final /* synthetic */ String extraString;
    private final /* synthetic */ int kind;
    private final /* synthetic */ int[] metadataVersion;
    private final /* synthetic */ String packageName;

    public JvmMetadataUtil$annotationImpl$kotlin_Metadata$0(int[] bytecodeVersion, String[] data1, String[] data2, int i, String extraString, int i2, int[] metadataVersion, String packageName) {
        Intrinsics.checkNotNullParameter(bytecodeVersion, "bytecodeVersion");
        Intrinsics.checkNotNullParameter(data1, "data1");
        Intrinsics.checkNotNullParameter(data2, "data2");
        Intrinsics.checkNotNullParameter(extraString, "extraString");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.bytecodeVersion = bytecodeVersion;
        this.data1 = data1;
        this.data2 = data2;
        this.extraInt = i;
        this.extraString = extraString;
        this.kind = i2;
        this.metadataVersion = metadataVersion;
        this.packageName = packageName;
    }

    public /* synthetic */ JvmMetadataUtil$annotationImpl$kotlin_Metadata$0(int[] iArr, String[] strArr, String[] strArr2, int i, String str, int i2, int[] iArr2, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new int[]{1, 0, 3} : iArr, (i3 & 2) != 0 ? new String[0] : strArr, (i3 & 4) != 0 ? new String[0] : strArr2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? "" : str, (i3 & 32) == 0 ? i2 : 1, (i3 & 64) != 0 ? new int[0] : iArr2, (i3 & 128) != 0 ? "" : str2);
    }

    @Override // java.lang.annotation.Annotation
    public final /* synthetic */ Class annotationType() {
        return Metadata.class;
    }

    @Override // kotlin.Metadata
    /* renamed from: bytecodeVersion */
    public final /* synthetic */ int[] bv() {
        return this.bytecodeVersion;
    }

    @Override // kotlin.Metadata
    /* renamed from: data1 */
    public final /* synthetic */ String[] d1() {
        return this.data1;
    }

    @Override // kotlin.Metadata
    /* renamed from: data2 */
    public final /* synthetic */ String[] d2() {
        return this.data2;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (obj instanceof Metadata) {
            Metadata metadata = (Metadata) obj;
            return Arrays.equals(bv(), metadata.bv()) && Arrays.equals(d1(), metadata.d1()) && Arrays.equals(d2(), metadata.d2()) && xi() == metadata.xi() && Intrinsics.areEqual(xs(), metadata.xs()) && k() == metadata.k() && Arrays.equals(mv(), metadata.mv()) && Intrinsics.areEqual(pn(), metadata.pn());
        }
        return false;
    }

    @Override // kotlin.Metadata
    /* renamed from: extraInt */
    public final /* synthetic */ int xi() {
        return this.extraInt;
    }

    @Override // kotlin.Metadata
    /* renamed from: extraString */
    public final /* synthetic */ String xs() {
        return this.extraString;
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (("bytecodeVersion".hashCode() * 127) ^ Arrays.hashCode(this.bytecodeVersion)) + (("data1".hashCode() * 127) ^ Arrays.hashCode(this.data1)) + (("data2".hashCode() * 127) ^ Arrays.hashCode(this.data2)) + (("extraInt".hashCode() * 127) ^ Integer.hashCode(this.extraInt)) + (("extraString".hashCode() * 127) ^ this.extraString.hashCode()) + (("kind".hashCode() * 127) ^ Integer.hashCode(this.kind)) + (("metadataVersion".hashCode() * 127) ^ Arrays.hashCode(this.metadataVersion)) + ((RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME.hashCode() * 127) ^ this.packageName.hashCode());
    }

    @Override // kotlin.Metadata
    /* renamed from: kind */
    public final /* synthetic */ int k() {
        return this.kind;
    }

    @Override // kotlin.Metadata
    /* renamed from: metadataVersion */
    public final /* synthetic */ int[] mv() {
        return this.metadataVersion;
    }

    @Override // kotlin.Metadata
    /* renamed from: packageName */
    public final /* synthetic */ String pn() {
        return this.packageName;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@kotlin.Metadata(bytecodeVersion=" + Arrays.toString(this.bytecodeVersion) + ", data1=" + Arrays.toString(this.data1) + ", data2=" + Arrays.toString(this.data2) + ", extraInt=" + this.extraInt + ", extraString=" + this.extraString + ", kind=" + this.kind + ", metadataVersion=" + Arrays.toString(this.metadataVersion) + ", packageName=" + this.packageName + ')';
    }
}
