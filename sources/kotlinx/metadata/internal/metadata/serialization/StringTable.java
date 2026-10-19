package kotlinx.metadata.internal.metadata.serialization;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
/* compiled from: StringTable.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lkotlinx/metadata/internal/metadata/serialization/StringTable;", "", "getStringIndex", "", TypedValues.Custom.S_STRING, "", "getQualifiedClassNameIndex", "className", "isLocal", "", TtmlNode.TAG_METADATA}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public interface StringTable {
    int getQualifiedClassNameIndex(String str, boolean z);

    int getStringIndex(String str);
}
