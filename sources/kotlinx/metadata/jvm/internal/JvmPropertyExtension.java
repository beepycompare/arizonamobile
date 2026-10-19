package kotlinx.metadata.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmPropertyExtensionVisitor;
import kotlinx.metadata.internal.extensions.KmPropertyExtension;
import kotlinx.metadata.jvm.JvmFieldSignature;
import kotlinx.metadata.jvm.JvmMethodSignature;
import kotlinx.metadata.jvm.JvmPropertyExtensionVisitor;
/* compiled from: JvmExtensionNodes.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J.\u0010#\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010$\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010&\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f¨\u0006'"}, d2 = {"Lkotlinx/metadata/jvm/internal/JvmPropertyExtension;", "Lkotlinx/metadata/jvm/JvmPropertyExtensionVisitor;", "Lkotlinx/metadata/internal/extensions/KmPropertyExtension;", "()V", "fieldSignature", "Lkotlinx/metadata/jvm/JvmFieldSignature;", "getFieldSignature", "()Lkotlinx/metadata/jvm/JvmFieldSignature;", "setFieldSignature", "(Lkotlinx/metadata/jvm/JvmFieldSignature;)V", "getterSignature", "Lkotlinx/metadata/jvm/JvmMethodSignature;", "getGetterSignature", "()Lkotlinx/metadata/jvm/JvmMethodSignature;", "setGetterSignature", "(Lkotlinx/metadata/jvm/JvmMethodSignature;)V", "jvmFlags", "", "getJvmFlags", "()I", "setJvmFlags", "(I)V", "setterSignature", "getSetterSignature", "setSetterSignature", "syntheticMethodForAnnotations", "getSyntheticMethodForAnnotations", "setSyntheticMethodForAnnotations", "syntheticMethodForDelegate", "getSyntheticMethodForDelegate", "setSyntheticMethodForDelegate", "accept", "", "visitor", "Lkotlinx/metadata/KmPropertyExtensionVisitor;", "visit", "visitSyntheticMethodForAnnotations", "signature", "visitSyntheticMethodForDelegate", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmPropertyExtension extends JvmPropertyExtensionVisitor implements KmPropertyExtension {
    private JvmFieldSignature fieldSignature;
    private JvmMethodSignature getterSignature;
    private int jvmFlags;
    private JvmMethodSignature setterSignature;
    private JvmMethodSignature syntheticMethodForAnnotations;
    private JvmMethodSignature syntheticMethodForDelegate;

    public JvmPropertyExtension() {
        super(null, 1, null);
    }

    public final int getJvmFlags() {
        return this.jvmFlags;
    }

    public final void setJvmFlags(int i) {
        this.jvmFlags = i;
    }

    public final JvmFieldSignature getFieldSignature() {
        return this.fieldSignature;
    }

    public final void setFieldSignature(JvmFieldSignature jvmFieldSignature) {
        this.fieldSignature = jvmFieldSignature;
    }

    public final JvmMethodSignature getGetterSignature() {
        return this.getterSignature;
    }

    public final void setGetterSignature(JvmMethodSignature jvmMethodSignature) {
        this.getterSignature = jvmMethodSignature;
    }

    public final JvmMethodSignature getSetterSignature() {
        return this.setterSignature;
    }

    public final void setSetterSignature(JvmMethodSignature jvmMethodSignature) {
        this.setterSignature = jvmMethodSignature;
    }

    public final JvmMethodSignature getSyntheticMethodForAnnotations() {
        return this.syntheticMethodForAnnotations;
    }

    public final void setSyntheticMethodForAnnotations(JvmMethodSignature jvmMethodSignature) {
        this.syntheticMethodForAnnotations = jvmMethodSignature;
    }

    public final JvmMethodSignature getSyntheticMethodForDelegate() {
        return this.syntheticMethodForDelegate;
    }

    public final void setSyntheticMethodForDelegate(JvmMethodSignature jvmMethodSignature) {
        this.syntheticMethodForDelegate = jvmMethodSignature;
    }

    @Override // kotlinx.metadata.jvm.JvmPropertyExtensionVisitor
    public void visit(int i, JvmFieldSignature jvmFieldSignature, JvmMethodSignature jvmMethodSignature, JvmMethodSignature jvmMethodSignature2) {
        this.jvmFlags = i;
        this.fieldSignature = jvmFieldSignature;
        this.getterSignature = jvmMethodSignature;
        this.setterSignature = jvmMethodSignature2;
    }

    @Override // kotlinx.metadata.jvm.JvmPropertyExtensionVisitor
    public void visitSyntheticMethodForAnnotations(JvmMethodSignature jvmMethodSignature) {
        this.syntheticMethodForAnnotations = jvmMethodSignature;
    }

    @Override // kotlinx.metadata.jvm.JvmPropertyExtensionVisitor
    public void visitSyntheticMethodForDelegate(JvmMethodSignature jvmMethodSignature) {
        this.syntheticMethodForDelegate = jvmMethodSignature;
    }

    @Override // kotlinx.metadata.internal.extensions.KmExtension
    public void accept(KmPropertyExtensionVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (!(visitor instanceof JvmPropertyExtensionVisitor)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        JvmPropertyExtensionVisitor jvmPropertyExtensionVisitor = (JvmPropertyExtensionVisitor) visitor;
        jvmPropertyExtensionVisitor.visit(this.jvmFlags, this.fieldSignature, this.getterSignature, this.setterSignature);
        jvmPropertyExtensionVisitor.visitSyntheticMethodForAnnotations(this.syntheticMethodForAnnotations);
        jvmPropertyExtensionVisitor.visitSyntheticMethodForDelegate(this.syntheticMethodForDelegate);
        jvmPropertyExtensionVisitor.visitEnd();
    }
}
