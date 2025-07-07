package kotlinx.metadata.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmClassExtensionVisitor;
import kotlinx.metadata.KmConstructor;
import kotlinx.metadata.KmConstructorExtensionVisitor;
import kotlinx.metadata.KmFunction;
import kotlinx.metadata.KmFunctionExtensionVisitor;
import kotlinx.metadata.KmPackage;
import kotlinx.metadata.KmPackageExtensionVisitor;
import kotlinx.metadata.KmProperty;
import kotlinx.metadata.KmPropertyExtensionVisitor;
import kotlinx.metadata.KmType;
import kotlinx.metadata.KmTypeExtensionVisitor;
import kotlinx.metadata.KmTypeParameter;
import kotlinx.metadata.KmTypeParameterExtensionVisitor;
import kotlinx.metadata.jvm.JvmClassExtensionVisitor;
import kotlinx.metadata.jvm.JvmConstructorExtensionVisitor;
import kotlinx.metadata.jvm.JvmFunctionExtensionVisitor;
import kotlinx.metadata.jvm.JvmPackageExtensionVisitor;
import kotlinx.metadata.jvm.JvmPropertyExtensionVisitor;
import kotlinx.metadata.jvm.JvmTypeExtensionVisitor;
import kotlinx.metadata.jvm.JvmTypeParameterExtensionVisitor;
/* compiled from: JvmExtensionNodes.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0000\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0007\"\u0018\u0010\u0000\u001a\u00020\b*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\n\"\u0018\u0010\u0000\u001a\u00020\u000b*\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\r\"\u0018\u0010\u0000\u001a\u00020\u000e*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0010\"\u0018\u0010\u0000\u001a\u00020\u0011*\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0013\"\u0018\u0010\u0000\u001a\u00020\u0014*\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0016¨\u0006\u0017"}, d2 = {"jvm", "Lkotlinx/metadata/jvm/internal/JvmClassExtension;", "Lkotlinx/metadata/KmClass;", "getJvm", "(Lkotlinx/metadata/KmClass;)Lkotlinx/metadata/jvm/internal/JvmClassExtension;", "Lkotlinx/metadata/jvm/internal/JvmConstructorExtension;", "Lkotlinx/metadata/KmConstructor;", "(Lkotlinx/metadata/KmConstructor;)Lkotlinx/metadata/jvm/internal/JvmConstructorExtension;", "Lkotlinx/metadata/jvm/internal/JvmFunctionExtension;", "Lkotlinx/metadata/KmFunction;", "(Lkotlinx/metadata/KmFunction;)Lkotlinx/metadata/jvm/internal/JvmFunctionExtension;", "Lkotlinx/metadata/jvm/internal/JvmPackageExtension;", "Lkotlinx/metadata/KmPackage;", "(Lkotlinx/metadata/KmPackage;)Lkotlinx/metadata/jvm/internal/JvmPackageExtension;", "Lkotlinx/metadata/jvm/internal/JvmPropertyExtension;", "Lkotlinx/metadata/KmProperty;", "(Lkotlinx/metadata/KmProperty;)Lkotlinx/metadata/jvm/internal/JvmPropertyExtension;", "Lkotlinx/metadata/jvm/internal/JvmTypeExtension;", "Lkotlinx/metadata/KmType;", "(Lkotlinx/metadata/KmType;)Lkotlinx/metadata/jvm/internal/JvmTypeExtension;", "Lkotlinx/metadata/jvm/internal/JvmTypeParameterExtension;", "Lkotlinx/metadata/KmTypeParameter;", "(Lkotlinx/metadata/KmTypeParameter;)Lkotlinx/metadata/jvm/internal/JvmTypeParameterExtension;", "kotlinx-metadata-jvm"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmExtensionNodesKt {
    public static final JvmClassExtension getJvm(KmClass kmClass) {
        Intrinsics.checkNotNullParameter(kmClass, "<this>");
        KmClassExtensionVisitor visitExtensions = kmClass.visitExtensions(JvmClassExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(visitExtensions, "null cannot be cast to non-null type kotlinx.metadata.jvm.internal.JvmClassExtension");
        return (JvmClassExtension) visitExtensions;
    }

    public static final JvmPackageExtension getJvm(KmPackage kmPackage) {
        Intrinsics.checkNotNullParameter(kmPackage, "<this>");
        KmPackageExtensionVisitor visitExtensions = kmPackage.visitExtensions(JvmPackageExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(visitExtensions, "null cannot be cast to non-null type kotlinx.metadata.jvm.internal.JvmPackageExtension");
        return (JvmPackageExtension) visitExtensions;
    }

    public static final JvmFunctionExtension getJvm(KmFunction kmFunction) {
        Intrinsics.checkNotNullParameter(kmFunction, "<this>");
        KmFunctionExtensionVisitor visitExtensions = kmFunction.visitExtensions(JvmFunctionExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(visitExtensions, "null cannot be cast to non-null type kotlinx.metadata.jvm.internal.JvmFunctionExtension");
        return (JvmFunctionExtension) visitExtensions;
    }

    public static final JvmPropertyExtension getJvm(KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(kmProperty, "<this>");
        KmPropertyExtensionVisitor visitExtensions = kmProperty.visitExtensions(JvmPropertyExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(visitExtensions, "null cannot be cast to non-null type kotlinx.metadata.jvm.internal.JvmPropertyExtension");
        return (JvmPropertyExtension) visitExtensions;
    }

    public static final JvmConstructorExtension getJvm(KmConstructor kmConstructor) {
        Intrinsics.checkNotNullParameter(kmConstructor, "<this>");
        KmConstructorExtensionVisitor visitExtensions = kmConstructor.visitExtensions(JvmConstructorExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(visitExtensions, "null cannot be cast to non-null type kotlinx.metadata.jvm.internal.JvmConstructorExtension");
        return (JvmConstructorExtension) visitExtensions;
    }

    public static final JvmTypeParameterExtension getJvm(KmTypeParameter kmTypeParameter) {
        Intrinsics.checkNotNullParameter(kmTypeParameter, "<this>");
        KmTypeParameterExtensionVisitor visitExtensions = kmTypeParameter.visitExtensions(JvmTypeParameterExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(visitExtensions, "null cannot be cast to non-null type kotlinx.metadata.jvm.internal.JvmTypeParameterExtension");
        return (JvmTypeParameterExtension) visitExtensions;
    }

    public static final JvmTypeExtension getJvm(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<this>");
        KmTypeExtensionVisitor visitExtensions = kmType.visitExtensions(JvmTypeExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(visitExtensions, "null cannot be cast to non-null type kotlinx.metadata.jvm.internal.JvmTypeExtension");
        return (JvmTypeExtension) visitExtensions;
    }
}
