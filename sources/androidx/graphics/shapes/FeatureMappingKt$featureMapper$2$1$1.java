package androidx.graphics.shapes;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* compiled from: FeatureMapping.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class FeatureMappingKt$featureMapper$2$1$1 extends Lambda implements Function1<Integer, CharSequence> {
    final /* synthetic */ int $N;
    final /* synthetic */ DoubleMapper $dm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeatureMappingKt$featureMapper$2$1$1(DoubleMapper doubleMapper, int i) {
        super(1);
        this.$dm = doubleMapper;
        this.$N = i;
    }

    public final CharSequence invoke(int i) {
        return Format_jvmKt.toStringWithLessPrecision(this.$dm.map(i / this.$N));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
        return invoke(num.intValue());
    }
}
