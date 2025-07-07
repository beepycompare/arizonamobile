package com.skydoves.cloudy;

import android.graphics.Bitmap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import com.skydoves.cloudy.CloudyState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: CloudyModifierNode.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\f\u0010\u0018\u001a\u00020\b*\u00020\u0019H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00108B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/skydoves/cloudy/CloudyModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "radius", "", "onStateChanged", "Lkotlin/Function1;", "Lcom/skydoves/cloudy/CloudyState;", "", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "getRadius", "()I", "setRadius", "(I)V", "<set-?>", "Landroid/graphics/Bitmap;", "cachedOutput", "getCachedOutput", "()Landroid/graphics/Bitmap;", "setCachedOutput", "(Landroid/graphics/Bitmap;)V", "cachedOutput$delegate", "Landroidx/compose/runtime/MutableState;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "cloudy_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class CloudyModifierNode extends Modifier.Node implements DrawModifierNode {
    private final MutableState cachedOutput$delegate;
    private final Function1<CloudyState, Unit> onStateChanged;
    private int radius;

    public CloudyModifierNode() {
        this(0, null, 3, null);
    }

    public final int getRadius() {
        return this.radius;
    }

    public final void setRadius(int i) {
        this.radius = i;
    }

    public /* synthetic */ CloudyModifierNode(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i, (i2 & 2) != 0 ? new Function1() { // from class: com.skydoves.cloudy.CloudyModifierNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = CloudyModifierNode._init_$lambda$0((CloudyState) obj);
                return _init_$lambda$0;
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(CloudyState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CloudyModifierNode(int i, Function1<? super CloudyState, Unit> onStateChanged) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        this.radius = i;
        this.onStateChanged = onStateChanged;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.cachedOutput$delegate = mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap getCachedOutput() {
        return (Bitmap) this.cachedOutput$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCachedOutput(Bitmap bitmap) {
        this.cachedOutput$delegate.setValue(bitmap);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(final ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        GraphicsLayer createGraphicsLayer = DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer();
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m4638recordJVtK1S4$default(contentDrawScope2, createGraphicsLayer, 0L, new Function1() { // from class: com.skydoves.cloudy.CloudyModifierNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit draw$lambda$1;
                draw$lambda$1 = CloudyModifierNode.draw$lambda$1(ContentDrawScope.this, (DrawScope) obj);
                return draw$lambda$1;
            }
        }, 1, null);
        GraphicsLayerKt.drawLayer(contentDrawScope2, createGraphicsLayer);
        this.onStateChanged.invoke(CloudyState.Loading.INSTANCE);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), Dispatchers.getMain().getImmediate(), null, new CloudyModifierNode$draw$2(createGraphicsLayer, this, contentDrawScope, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit draw$lambda$1(ContentDrawScope contentDrawScope, DrawScope record) {
        Intrinsics.checkNotNullParameter(record, "$this$record");
        contentDrawScope.drawContent();
        return Unit.INSTANCE;
    }
}
