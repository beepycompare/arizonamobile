package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Visitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0014\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0014\u0010\u0018\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/metadata/KmTypeVisitor;", "", "delegate", "(Lkotlinx/metadata/KmTypeVisitor;)V", "visitAbbreviatedType", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "visitArgument", "variance", "Lkotlinx/metadata/KmVariance;", "visitClass", "", "name", "", "Lkotlinx/metadata/ClassName;", "visitEnd", "visitExtensions", "Lkotlinx/metadata/KmTypeExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitFlexibleTypeUpperBound", "typeFlexibilityId", "visitOuterType", "visitStarProjection", "visitTypeAlias", "visitTypeParameter", "id", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KmTypeVisitor {
    private final KmTypeVisitor delegate;

    public KmTypeVisitor() {
        this(null, 1, null);
    }

    public KmTypeVisitor(KmTypeVisitor kmTypeVisitor) {
        this.delegate = kmTypeVisitor;
    }

    public /* synthetic */ KmTypeVisitor(KmTypeVisitor kmTypeVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kmTypeVisitor);
    }

    public void visitClass(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmTypeVisitor kmTypeVisitor = this.delegate;
        if (kmTypeVisitor != null) {
            kmTypeVisitor.visitClass(name);
        }
    }

    public void visitTypeAlias(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmTypeVisitor kmTypeVisitor = this.delegate;
        if (kmTypeVisitor != null) {
            kmTypeVisitor.visitTypeAlias(name);
        }
    }

    public void visitTypeParameter(int i) {
        KmTypeVisitor kmTypeVisitor = this.delegate;
        if (kmTypeVisitor != null) {
            kmTypeVisitor.visitTypeParameter(i);
        }
    }

    public KmTypeVisitor visitArgument(int i, KmVariance variance) {
        Intrinsics.checkNotNullParameter(variance, "variance");
        KmTypeVisitor kmTypeVisitor = this.delegate;
        if (kmTypeVisitor != null) {
            return kmTypeVisitor.visitArgument(i, variance);
        }
        return null;
    }

    public void visitStarProjection() {
        KmTypeVisitor kmTypeVisitor = this.delegate;
        if (kmTypeVisitor != null) {
            kmTypeVisitor.visitStarProjection();
        }
    }

    public KmTypeVisitor visitAbbreviatedType(int i) {
        KmTypeVisitor kmTypeVisitor = this.delegate;
        if (kmTypeVisitor != null) {
            return kmTypeVisitor.visitAbbreviatedType(i);
        }
        return null;
    }

    public KmTypeVisitor visitOuterType(int i) {
        KmTypeVisitor kmTypeVisitor = this.delegate;
        if (kmTypeVisitor != null) {
            return kmTypeVisitor.visitOuterType(i);
        }
        return null;
    }

    public KmTypeVisitor visitFlexibleTypeUpperBound(int i, String str) {
        KmTypeVisitor kmTypeVisitor = this.delegate;
        if (kmTypeVisitor != null) {
            return kmTypeVisitor.visitFlexibleTypeUpperBound(i, str);
        }
        return null;
    }

    public KmTypeExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KmTypeVisitor kmTypeVisitor = this.delegate;
        if (kmTypeVisitor != null) {
            return kmTypeVisitor.visitExtensions(type);
        }
        return null;
    }

    public void visitEnd() {
        KmTypeVisitor kmTypeVisitor = this.delegate;
        if (kmTypeVisitor != null) {
            kmTypeVisitor.visitEnd();
        }
    }
}
