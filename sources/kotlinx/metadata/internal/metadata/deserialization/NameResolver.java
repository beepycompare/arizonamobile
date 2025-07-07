package kotlinx.metadata.internal.metadata.deserialization;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: NameResolver.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lkotlinx/metadata/internal/metadata/deserialization/NameResolver;", "", "getString", "", FirebaseAnalytics.Param.INDEX, "", "getQualifiedClassName", "isLocalClassName", "", TtmlNode.TAG_METADATA}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public interface NameResolver {
    String getQualifiedClassName(int i);

    String getString(int i);

    boolean isLocalClassName(int i);
}
