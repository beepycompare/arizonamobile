package kotlinx.metadata.internal.common;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmClassVisitor;
import kotlinx.metadata.KmExtensionType;
import kotlinx.metadata.KmPackageVisitor;
/* compiled from: KotlinCommonMetadata.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/metadata/internal/common/KmModuleFragmentVisitor;", "", "delegate", "(Lkotlinx/metadata/internal/common/KmModuleFragmentVisitor;)V", "visitClass", "Lkotlinx/metadata/KmClassVisitor;", "visitEnd", "", "visitExtensions", "Lkotlinx/metadata/internal/common/KmModuleFragmentExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitPackage", "Lkotlinx/metadata/KmPackageVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KmModuleFragmentVisitor {
    private final KmModuleFragmentVisitor delegate;

    public KmModuleFragmentVisitor() {
        this(null, 1, null);
    }

    public KmModuleFragmentVisitor(KmModuleFragmentVisitor kmModuleFragmentVisitor) {
        this.delegate = kmModuleFragmentVisitor;
    }

    public /* synthetic */ KmModuleFragmentVisitor(KmModuleFragmentVisitor kmModuleFragmentVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kmModuleFragmentVisitor);
    }

    public KmPackageVisitor visitPackage() {
        KmModuleFragmentVisitor kmModuleFragmentVisitor = this.delegate;
        if (kmModuleFragmentVisitor != null) {
            return kmModuleFragmentVisitor.visitPackage();
        }
        return null;
    }

    public KmClassVisitor visitClass() {
        KmModuleFragmentVisitor kmModuleFragmentVisitor = this.delegate;
        if (kmModuleFragmentVisitor != null) {
            return kmModuleFragmentVisitor.visitClass();
        }
        return null;
    }

    public KmModuleFragmentExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KmModuleFragmentVisitor kmModuleFragmentVisitor = this.delegate;
        if (kmModuleFragmentVisitor != null) {
            return kmModuleFragmentVisitor.visitExtensions(type);
        }
        return null;
    }

    public void visitEnd() {
        KmModuleFragmentVisitor kmModuleFragmentVisitor = this.delegate;
        if (kmModuleFragmentVisitor != null) {
            kmModuleFragmentVisitor.visitEnd();
        }
    }
}
