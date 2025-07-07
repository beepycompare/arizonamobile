package kotlinx.metadata.jvm;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.metadata.KmExtensionType;
import kotlinx.metadata.KmPropertyExtensionVisitor;
/* compiled from: JvmExtensionVisitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J.\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0017J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lkotlinx/metadata/jvm/JvmPropertyExtensionVisitor;", "Lkotlinx/metadata/KmPropertyExtensionVisitor;", "delegate", "(Lkotlinx/metadata/jvm/JvmPropertyExtensionVisitor;)V", "type", "Lkotlinx/metadata/KmExtensionType;", "getType", "()Lkotlinx/metadata/KmExtensionType;", "visit", "", "jvmFlags", "", "fieldSignature", "Lkotlinx/metadata/jvm/JvmFieldSignature;", "getterSignature", "Lkotlinx/metadata/jvm/JvmMethodSignature;", "setterSignature", "visitEnd", "visitSyntheticMethodForAnnotations", "signature", "visitSyntheticMethodForDelegate", "Companion", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class JvmPropertyExtensionVisitor implements KmPropertyExtensionVisitor {
    public static final Companion Companion = new Companion(null);
    public static final KmExtensionType TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmPropertyExtensionVisitor.class));
    private final JvmPropertyExtensionVisitor delegate;

    public JvmPropertyExtensionVisitor() {
        this(null, 1, null);
    }

    public JvmPropertyExtensionVisitor(JvmPropertyExtensionVisitor jvmPropertyExtensionVisitor) {
        this.delegate = jvmPropertyExtensionVisitor;
    }

    public /* synthetic */ JvmPropertyExtensionVisitor(JvmPropertyExtensionVisitor jvmPropertyExtensionVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jvmPropertyExtensionVisitor);
    }

    @Override // kotlinx.metadata.KmExtensionVisitor
    public final KmExtensionType getType() {
        return TYPE;
    }

    public void visit(int i, JvmFieldSignature jvmFieldSignature, JvmMethodSignature jvmMethodSignature, JvmMethodSignature jvmMethodSignature2) {
        JvmPropertyExtensionVisitor jvmPropertyExtensionVisitor = this.delegate;
        if (jvmPropertyExtensionVisitor != null) {
            jvmPropertyExtensionVisitor.visit(i, jvmFieldSignature, jvmMethodSignature, jvmMethodSignature2);
        }
        visit(jvmFieldSignature, jvmMethodSignature, jvmMethodSignature2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use visit(Flags, JvmFieldSignature?, JvmMethodSignature?, JvmMethodSignature?) instead.", replaceWith = @ReplaceWith(expression = "visit(flagsOf(), fieldSignature, getterSignature, setterSignature)", imports = {"kotlinx.metadata.flagsOf"}))
    public void visit(JvmFieldSignature jvmFieldSignature, JvmMethodSignature jvmMethodSignature, JvmMethodSignature jvmMethodSignature2) {
        JvmPropertyExtensionVisitor jvmPropertyExtensionVisitor = this.delegate;
        if (jvmPropertyExtensionVisitor != null) {
            jvmPropertyExtensionVisitor.visit(jvmFieldSignature, jvmMethodSignature, jvmMethodSignature2);
        }
    }

    public void visitSyntheticMethodForAnnotations(JvmMethodSignature jvmMethodSignature) {
        JvmPropertyExtensionVisitor jvmPropertyExtensionVisitor = this.delegate;
        if (jvmPropertyExtensionVisitor != null) {
            jvmPropertyExtensionVisitor.visitSyntheticMethodForAnnotations(jvmMethodSignature);
        }
    }

    public void visitSyntheticMethodForDelegate(JvmMethodSignature jvmMethodSignature) {
        JvmPropertyExtensionVisitor jvmPropertyExtensionVisitor = this.delegate;
        if (jvmPropertyExtensionVisitor != null) {
            jvmPropertyExtensionVisitor.visitSyntheticMethodForDelegate(jvmMethodSignature);
        }
    }

    public void visitEnd() {
        JvmPropertyExtensionVisitor jvmPropertyExtensionVisitor = this.delegate;
        if (jvmPropertyExtensionVisitor != null) {
            jvmPropertyExtensionVisitor.visitEnd();
        }
    }

    /* compiled from: JvmExtensionVisitors.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/metadata/jvm/JvmPropertyExtensionVisitor$Companion;", "", "()V", "TYPE", "Lkotlinx/metadata/KmExtensionType;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
