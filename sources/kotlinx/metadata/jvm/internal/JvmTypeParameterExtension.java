package kotlinx.metadata.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmAnnotation;
import kotlinx.metadata.KmTypeParameterExtensionVisitor;
import kotlinx.metadata.internal.extensions.KmTypeParameterExtension;
import kotlinx.metadata.jvm.JvmTypeParameterExtensionVisitor;
/* compiled from: JvmExtensionNodes.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lkotlinx/metadata/jvm/internal/JvmTypeParameterExtension;", "Lkotlinx/metadata/jvm/JvmTypeParameterExtensionVisitor;", "Lkotlinx/metadata/internal/extensions/KmTypeParameterExtension;", "()V", "annotations", "", "Lkotlinx/metadata/KmAnnotation;", "getAnnotations", "()Ljava/util/List;", "accept", "", "visitor", "Lkotlinx/metadata/KmTypeParameterExtensionVisitor;", "visitAnnotation", "annotation", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmTypeParameterExtension extends JvmTypeParameterExtensionVisitor implements KmTypeParameterExtension {
    private final List<KmAnnotation> annotations;

    public JvmTypeParameterExtension() {
        super(null, 1, null);
        this.annotations = new ArrayList();
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlinx.metadata.jvm.JvmTypeParameterExtensionVisitor
    public void visitAnnotation(KmAnnotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        this.annotations.add(annotation);
    }

    @Override // kotlinx.metadata.internal.extensions.KmExtension
    public void accept(KmTypeParameterExtensionVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (!(visitor instanceof JvmTypeParameterExtensionVisitor)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        JvmTypeParameterExtensionVisitor jvmTypeParameterExtensionVisitor = (JvmTypeParameterExtensionVisitor) visitor;
        for (KmAnnotation kmAnnotation : this.annotations) {
            jvmTypeParameterExtensionVisitor.visitAnnotation(kmAnnotation);
        }
        jvmTypeParameterExtensionVisitor.visitEnd();
    }
}
