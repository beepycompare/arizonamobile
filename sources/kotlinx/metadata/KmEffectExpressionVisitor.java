package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Visitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\tJ\n\u0010\n\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0000H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/metadata/KmEffectExpressionVisitor;", "", "delegate", "(Lkotlinx/metadata/KmEffectExpressionVisitor;)V", "visit", "", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "parameterIndex", "(ILjava/lang/Integer;)V", "visitAndArgument", "visitConstantValue", "value", "visitEnd", "visitIsInstanceType", "Lkotlinx/metadata/KmTypeVisitor;", "visitOrArgument", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KmEffectExpressionVisitor {
    private final KmEffectExpressionVisitor delegate;

    public KmEffectExpressionVisitor() {
        this(null, 1, null);
    }

    public KmEffectExpressionVisitor(KmEffectExpressionVisitor kmEffectExpressionVisitor) {
        this.delegate = kmEffectExpressionVisitor;
    }

    public /* synthetic */ KmEffectExpressionVisitor(KmEffectExpressionVisitor kmEffectExpressionVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kmEffectExpressionVisitor);
    }

    public void visit(int i, Integer num) {
        KmEffectExpressionVisitor kmEffectExpressionVisitor = this.delegate;
        if (kmEffectExpressionVisitor != null) {
            kmEffectExpressionVisitor.visit(i, num);
        }
    }

    public void visitConstantValue(Object obj) {
        KmEffectExpressionVisitor kmEffectExpressionVisitor = this.delegate;
        if (kmEffectExpressionVisitor != null) {
            kmEffectExpressionVisitor.visitConstantValue(obj);
        }
    }

    public KmTypeVisitor visitIsInstanceType(int i) {
        KmEffectExpressionVisitor kmEffectExpressionVisitor = this.delegate;
        if (kmEffectExpressionVisitor != null) {
            return kmEffectExpressionVisitor.visitIsInstanceType(i);
        }
        return null;
    }

    public KmEffectExpressionVisitor visitAndArgument() {
        KmEffectExpressionVisitor kmEffectExpressionVisitor = this.delegate;
        if (kmEffectExpressionVisitor != null) {
            return kmEffectExpressionVisitor.visitAndArgument();
        }
        return null;
    }

    public KmEffectExpressionVisitor visitOrArgument() {
        KmEffectExpressionVisitor kmEffectExpressionVisitor = this.delegate;
        if (kmEffectExpressionVisitor != null) {
            return kmEffectExpressionVisitor.visitOrArgument();
        }
        return null;
    }

    public void visitEnd() {
        KmEffectExpressionVisitor kmEffectExpressionVisitor = this.delegate;
        if (kmEffectExpressionVisitor != null) {
            kmEffectExpressionVisitor.visitEnd();
        }
    }
}
