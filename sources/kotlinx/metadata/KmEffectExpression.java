package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0001H\u0007J\u001f\u0010$\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0017¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0001H\u0017J\u0012\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010)H\u0017J\u0010\u0010*\u001a\u00020+2\u0006\u0010\r\u001a\u00020\u000eH\u0017J\b\u0010,\u001a\u00020\u0001H\u0017R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Lkotlinx/metadata/KmEffectExpression;", "Lkotlinx/metadata/KmEffectExpressionVisitor;", "()V", "andArguments", "", "getAndArguments", "()Ljava/util/List;", "constantValue", "Lkotlinx/metadata/KmConstantValue;", "getConstantValue", "()Lkotlinx/metadata/KmConstantValue;", "setConstantValue", "(Lkotlinx/metadata/KmConstantValue;)V", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "getFlags$annotations", "getFlags", "()I", "setFlags", "(I)V", "isInstanceType", "Lkotlinx/metadata/KmType;", "()Lkotlinx/metadata/KmType;", "setInstanceType", "(Lkotlinx/metadata/KmType;)V", "orArguments", "getOrArguments", "parameterIndex", "getParameterIndex", "()Ljava/lang/Integer;", "setParameterIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "accept", "", "visitor", "visit", "(ILjava/lang/Integer;)V", "visitAndArgument", "visitConstantValue", "value", "", "visitIsInstanceType", "Lkotlinx/metadata/KmTypeVisitor;", "visitOrArgument", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmEffectExpression extends KmEffectExpressionVisitor {
    private final List<KmEffectExpression> andArguments;
    private KmConstantValue constantValue;
    private int flags;
    private KmType isInstanceType;
    private final List<KmEffectExpression> orArguments;
    private Integer parameterIndex;

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding member extensions on KmEffectExpression, such as KmEffectExpression.isNegated")
    public static /* synthetic */ void getFlags$annotations() {
    }

    public KmEffectExpression() {
        super(null, 1, null);
        this.flags = FlagsKt.flagsOf(new Flag[0]);
        this.andArguments = new ArrayList(0);
        this.orArguments = new ArrayList(0);
    }

    public final int getFlags() {
        return this.flags;
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final Integer getParameterIndex() {
        return this.parameterIndex;
    }

    public final void setParameterIndex(Integer num) {
        this.parameterIndex = num;
    }

    public final KmConstantValue getConstantValue() {
        return this.constantValue;
    }

    public final void setConstantValue(KmConstantValue kmConstantValue) {
        this.constantValue = kmConstantValue;
    }

    public final KmType isInstanceType() {
        return this.isInstanceType;
    }

    public final void setInstanceType(KmType kmType) {
        this.isInstanceType = kmType;
    }

    public final List<KmEffectExpression> getAndArguments() {
        return this.andArguments;
    }

    public final List<KmEffectExpression> getOrArguments() {
        return this.orArguments;
    }

    @Override // kotlinx.metadata.KmEffectExpressionVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visit(int i, Integer num) {
        this.flags = i;
        this.parameterIndex = num;
    }

    @Override // kotlinx.metadata.KmEffectExpressionVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visitConstantValue(Object obj) {
        this.constantValue = new KmConstantValue(obj);
    }

    @Override // kotlinx.metadata.KmEffectExpressionVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitIsInstanceType(int i) {
        KmType kmType = new KmType(i);
        this.isInstanceType = kmType;
        return kmType;
    }

    @Override // kotlinx.metadata.KmEffectExpressionVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmEffectExpressionVisitor visitAndArgument() {
        return (KmEffectExpressionVisitor) NodesKt.addTo(new KmEffectExpression(), this.andArguments);
    }

    @Override // kotlinx.metadata.KmEffectExpressionVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmEffectExpressionVisitor visitOrArgument() {
        return (KmEffectExpressionVisitor) NodesKt.addTo(new KmEffectExpression(), this.orArguments);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmEffectExpressionVisitor visitor) {
        KmTypeVisitor visitIsInstanceType;
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        visitor.visit(this.flags, this.parameterIndex);
        KmConstantValue kmConstantValue = this.constantValue;
        if (kmConstantValue != null) {
            visitor.visitConstantValue(kmConstantValue.getValue());
        }
        KmType kmType = this.isInstanceType;
        if (kmType != null && (visitIsInstanceType = visitor.visitIsInstanceType(kmType.getFlags())) != null) {
            kmType.accept(visitIsInstanceType);
        }
        for (KmEffectExpression kmEffectExpression : this.andArguments) {
            KmEffectExpressionVisitor visitAndArgument = visitor.visitAndArgument();
            if (visitAndArgument != null) {
                kmEffectExpression.accept(visitAndArgument);
            }
        }
        for (KmEffectExpression kmEffectExpression2 : this.orArguments) {
            KmEffectExpressionVisitor visitOrArgument = visitor.visitOrArgument();
            if (visitOrArgument != null) {
                kmEffectExpression2.accept(visitOrArgument);
            }
        }
        visitor.visitEnd();
    }
}
