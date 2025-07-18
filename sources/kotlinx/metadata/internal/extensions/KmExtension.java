package kotlinx.metadata.internal.extensions;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.metadata.KmExtensionVisitor;
/* compiled from: ExtensionNodes.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lkotlinx/metadata/internal/extensions/KmExtension;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/metadata/KmExtensionVisitor;", "accept", "", "visitor", "(Lkotlinx/metadata/KmExtensionVisitor;)V", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface KmExtension<V extends KmExtensionVisitor> extends KmExtensionVisitor {
    void accept(V v);
}
