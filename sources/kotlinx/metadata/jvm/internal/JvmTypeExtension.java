package kotlinx.metadata.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmAnnotation;
import kotlinx.metadata.KmTypeExtensionVisitor;
import kotlinx.metadata.internal.extensions.KmTypeExtension;
import kotlinx.metadata.jvm.JvmTypeExtensionVisitor;
/* compiled from: JvmExtensionNodes.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lkotlinx/metadata/jvm/internal/JvmTypeExtension;", "Lkotlinx/metadata/jvm/JvmTypeExtensionVisitor;", "Lkotlinx/metadata/internal/extensions/KmTypeExtension;", "()V", "annotations", "", "Lkotlinx/metadata/KmAnnotation;", "getAnnotations", "()Ljava/util/List;", "isRaw", "", "()Z", "setRaw", "(Z)V", "accept", "", "visitor", "Lkotlinx/metadata/KmTypeExtensionVisitor;", "visit", "visitAnnotation", "annotation", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmTypeExtension extends JvmTypeExtensionVisitor implements KmTypeExtension {
    private final List<KmAnnotation> annotations;
    private boolean isRaw;

    public JvmTypeExtension() {
        super(null, 1, null);
        this.annotations = new ArrayList();
    }

    public final boolean isRaw() {
        return this.isRaw;
    }

    public final void setRaw(boolean z) {
        this.isRaw = z;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlinx.metadata.jvm.JvmTypeExtensionVisitor
    public void visit(boolean z) {
        this.isRaw = z;
    }

    @Override // kotlinx.metadata.jvm.JvmTypeExtensionVisitor
    public void visitAnnotation(KmAnnotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        this.annotations.add(annotation);
    }

    @Override // kotlinx.metadata.internal.extensions.KmExtension
    public void accept(KmTypeExtensionVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (!(visitor instanceof JvmTypeExtensionVisitor)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        JvmTypeExtensionVisitor jvmTypeExtensionVisitor = (JvmTypeExtensionVisitor) visitor;
        jvmTypeExtensionVisitor.visit(this.isRaw);
        for (KmAnnotation kmAnnotation : this.annotations) {
            jvmTypeExtensionVisitor.visitAnnotation(kmAnnotation);
        }
        jvmTypeExtensionVisitor.visitEnd();
    }
}
