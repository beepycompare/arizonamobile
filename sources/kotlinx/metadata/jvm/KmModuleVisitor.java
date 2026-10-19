package kotlinx.metadata.jvm;

import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmAnnotation;
import kotlinx.metadata.KmClassVisitor;
/* compiled from: KotlinModuleMetadata.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@UnstableMetadataApi
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\b'\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J2\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0011H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/metadata/jvm/KmModuleVisitor;", "", "delegate", "(Lkotlinx/metadata/jvm/KmModuleVisitor;)V", "visitAnnotation", "", "annotation", "Lkotlinx/metadata/KmAnnotation;", "visitEnd", "visitOptionalAnnotationClass", "Lkotlinx/metadata/KmClassVisitor;", "visitPackageParts", "fqName", "", "fileFacades", "", "multiFileClassParts", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KmModuleVisitor {
    private final KmModuleVisitor delegate;

    public KmModuleVisitor() {
        this(null, 1, null);
    }

    public KmModuleVisitor(KmModuleVisitor kmModuleVisitor) {
        this.delegate = kmModuleVisitor;
    }

    public /* synthetic */ KmModuleVisitor(KmModuleVisitor kmModuleVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kmModuleVisitor);
    }

    public void visitPackageParts(String fqName, List<String> fileFacades, Map<String, String> multiFileClassParts) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(fileFacades, "fileFacades");
        Intrinsics.checkNotNullParameter(multiFileClassParts, "multiFileClassParts");
        KmModuleVisitor kmModuleVisitor = this.delegate;
        if (kmModuleVisitor != null) {
            kmModuleVisitor.visitPackageParts(fqName, fileFacades, multiFileClassParts);
        }
    }

    public void visitAnnotation(KmAnnotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        KmModuleVisitor kmModuleVisitor = this.delegate;
        if (kmModuleVisitor != null) {
            kmModuleVisitor.visitAnnotation(annotation);
        }
    }

    public KmClassVisitor visitOptionalAnnotationClass() {
        KmModuleVisitor kmModuleVisitor = this.delegate;
        if (kmModuleVisitor != null) {
            return kmModuleVisitor.visitOptionalAnnotationClass();
        }
        return null;
    }

    public void visitEnd() {
        KmModuleVisitor kmModuleVisitor = this.delegate;
        if (kmModuleVisitor != null) {
            kmModuleVisitor.visitEnd();
        }
    }
}
