package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Visitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J*\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/metadata/KmTypeAliasVisitor;", "", "delegate", "(Lkotlinx/metadata/KmTypeAliasVisitor;)V", "visitAnnotation", "", "annotation", "Lkotlinx/metadata/KmAnnotation;", "visitEnd", "visitExpandedType", "Lkotlinx/metadata/KmTypeVisitor;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "visitExtensions", "Lkotlinx/metadata/KmTypeAliasExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitTypeParameter", "Lkotlinx/metadata/KmTypeParameterVisitor;", "name", "", "id", "variance", "Lkotlinx/metadata/KmVariance;", "visitUnderlyingType", "visitVersionRequirement", "Lkotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KmTypeAliasVisitor {
    private final KmTypeAliasVisitor delegate;

    public KmTypeAliasVisitor() {
        this(null, 1, null);
    }

    public KmTypeAliasVisitor(KmTypeAliasVisitor kmTypeAliasVisitor) {
        this.delegate = kmTypeAliasVisitor;
    }

    public /* synthetic */ KmTypeAliasVisitor(KmTypeAliasVisitor kmTypeAliasVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kmTypeAliasVisitor);
    }

    public KmTypeParameterVisitor visitTypeParameter(int i, String name, int i2, KmVariance variance) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        KmTypeAliasVisitor kmTypeAliasVisitor = this.delegate;
        if (kmTypeAliasVisitor != null) {
            return kmTypeAliasVisitor.visitTypeParameter(i, name, i2, variance);
        }
        return null;
    }

    public KmTypeVisitor visitUnderlyingType(int i) {
        KmTypeAliasVisitor kmTypeAliasVisitor = this.delegate;
        if (kmTypeAliasVisitor != null) {
            return kmTypeAliasVisitor.visitUnderlyingType(i);
        }
        return null;
    }

    public KmTypeVisitor visitExpandedType(int i) {
        KmTypeAliasVisitor kmTypeAliasVisitor = this.delegate;
        if (kmTypeAliasVisitor != null) {
            return kmTypeAliasVisitor.visitExpandedType(i);
        }
        return null;
    }

    public void visitAnnotation(KmAnnotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        KmTypeAliasVisitor kmTypeAliasVisitor = this.delegate;
        if (kmTypeAliasVisitor != null) {
            kmTypeAliasVisitor.visitAnnotation(annotation);
        }
    }

    public KmVersionRequirementVisitor visitVersionRequirement() {
        KmTypeAliasVisitor kmTypeAliasVisitor = this.delegate;
        if (kmTypeAliasVisitor != null) {
            return kmTypeAliasVisitor.visitVersionRequirement();
        }
        return null;
    }

    public KmTypeAliasExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KmTypeAliasVisitor kmTypeAliasVisitor = this.delegate;
        if (kmTypeAliasVisitor != null) {
            return kmTypeAliasVisitor.visitExtensions(type);
        }
        return null;
    }

    public void visitEnd() {
        KmTypeAliasVisitor kmTypeAliasVisitor = this.delegate;
        if (kmTypeAliasVisitor != null) {
            kmTypeAliasVisitor.visitEnd();
        }
    }
}
