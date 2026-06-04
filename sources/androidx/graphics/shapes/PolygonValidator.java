package androidx.graphics.shapes;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PolygonValidation.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/graphics/shapes/PolygonValidator;", "", "<init>", "()V", "Companion", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PolygonValidator {
    public static final Companion Companion = new Companion(null);

    /* compiled from: PolygonValidation.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\n"}, d2 = {"Landroidx/graphics/shapes/PolygonValidator$Companion;", "", "<init>", "()V", "fix", "Landroidx/graphics/shapes/RoundedPolygon;", "polygon", "isCWOriented", "", "fixCWOrientation", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RoundedPolygon fix(RoundedPolygon polygon) {
            Intrinsics.checkNotNullParameter(polygon, "polygon");
            return isCWOriented(polygon) ? polygon : fixCWOrientation(polygon);
        }

        private final boolean isCWOriented(RoundedPolygon roundedPolygon) {
            int size = roundedPolygon.getCubics().size();
            float f = 0.0f;
            for (int i = 0; i < size; i++) {
                Cubic cubic = roundedPolygon.getCubics().get(i);
                f += (cubic.getAnchor1X() - cubic.getAnchor0X()) * (cubic.getAnchor1Y() + cubic.getAnchor0Y());
            }
            return f < 0.0f;
        }

        private final RoundedPolygon fixCWOrientation(RoundedPolygon roundedPolygon) {
            List createListBuilder = CollectionsKt.createListBuilder();
            createListBuilder.add(((Feature) CollectionsKt.first((List<? extends Object>) roundedPolygon.getFeatures())).reversed());
            for (int lastIndex = CollectionsKt.getLastIndex(roundedPolygon.getFeatures()); lastIndex > 0; lastIndex--) {
                createListBuilder.add(roundedPolygon.getFeatures().get(lastIndex).reversed());
            }
            return new RoundedPolygon(CollectionsKt.build(createListBuilder), roundedPolygon.m8782getCenter1ufDz9w$graphics_shapes(), null);
        }
    }
}
