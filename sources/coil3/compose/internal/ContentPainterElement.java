package coil3.compose.internal;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.InspectorInfo;
import coil3.ImageLoader;
import coil3.compose.AsyncImageModelEqualityDelegate;
import coil3.compose.AsyncImagePainter;
import coil3.compose.AsyncImagePreviewHandler;
import coil3.compose.ConstraintsSizeResolver;
import coil3.request.ImageRequest;
import coil3.size.SizeResolver;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ContentPainterModifier.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0002H\u0016J\f\u0010$\u001a\u00020\r*\u00020%H\u0016J\t\u0010&\u001a\u00020\u0004HÂ\u0003J\t\u0010'\u001a\u00020\u0006HÂ\u0003J\t\u0010(\u001a\u00020\bHÂ\u0003J\u0015\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nHÂ\u0003J\u0017\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÂ\u0003J\u0010\u0010+\u001a\u00020\u000fHÂ\u0003¢\u0006\u0004\b,\u0010-J\t\u0010.\u001a\u00020\u0011HÂ\u0003J\t\u0010/\u001a\u00020\u0013HÂ\u0003J\t\u00100\u001a\u00020\u0015HÂ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0017HÂ\u0003J\t\u00102\u001a\u00020\u0019HÂ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u001bHÂ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u001dHÂ\u0003J²\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÆ\u0001¢\u0006\u0004\b6\u00107J\u0013\u00108\u001a\u00020\u00192\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\u001dHÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcoil3/compose/internal/ContentPainterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lcoil3/compose/internal/ContentPainterNode;", "request", "Lcoil3/request/ImageRequest;", "imageLoader", "Lcoil3/ImageLoader;", "modelEqualityDelegate", "Lcoil3/compose/AsyncImageModelEqualityDelegate;", "transform", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "onState", "", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clipToBounds", "", "previewHandler", "Lcoil3/compose/AsyncImagePreviewHandler;", "contentDescription", "", "<init>", "(Lcoil3/request/ImageRequest;Lcoil3/ImageLoader;Lcoil3/compose/AsyncImageModelEqualityDelegate;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ILandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLcoil3/compose/AsyncImagePreviewHandler;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component6-f-v9h1I", "()I", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "copy-3ECvelE", "(Lcoil3/request/ImageRequest;Lcoil3/ImageLoader;Lcoil3/compose/AsyncImageModelEqualityDelegate;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ILandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLcoil3/compose/AsyncImagePreviewHandler;Ljava/lang/String;)Lcoil3/compose/internal/ContentPainterElement;", "equals", "other", "", "hashCode", "", "toString", "coil-compose-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ContentPainterElement extends ModifierNodeElement<ContentPainterNode> {
    public static final int $stable = 0;
    private final Alignment alignment;
    private final float alpha;
    private final boolean clipToBounds;
    private final ColorFilter colorFilter;
    private final String contentDescription;
    private final ContentScale contentScale;
    private final int filterQuality;
    private final ImageLoader imageLoader;
    private final AsyncImageModelEqualityDelegate modelEqualityDelegate;
    private final Function1<AsyncImagePainter.State, Unit> onState;
    private final AsyncImagePreviewHandler previewHandler;
    private final ImageRequest request;
    private final Function1<AsyncImagePainter.State, AsyncImagePainter.State> transform;

    public /* synthetic */ ContentPainterElement(ImageRequest imageRequest, ImageLoader imageLoader, AsyncImageModelEqualityDelegate asyncImageModelEqualityDelegate, Function1 function1, Function1 function12, int i, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, AsyncImagePreviewHandler asyncImagePreviewHandler, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageRequest, imageLoader, asyncImageModelEqualityDelegate, function1, function12, i, alignment, contentScale, f, colorFilter, z, asyncImagePreviewHandler, str);
    }

    private final ImageRequest component1() {
        return this.request;
    }

    private final ColorFilter component10() {
        return this.colorFilter;
    }

    private final boolean component11() {
        return this.clipToBounds;
    }

    private final AsyncImagePreviewHandler component12() {
        return this.previewHandler;
    }

    private final String component13() {
        return this.contentDescription;
    }

    private final ImageLoader component2() {
        return this.imageLoader;
    }

    private final AsyncImageModelEqualityDelegate component3() {
        return this.modelEqualityDelegate;
    }

    private final Function1<AsyncImagePainter.State, AsyncImagePainter.State> component4() {
        return this.transform;
    }

    private final Function1<AsyncImagePainter.State, Unit> component5() {
        return this.onState;
    }

    /* renamed from: component6-f-v9h1I  reason: not valid java name */
    private final int m7762component6fv9h1I() {
        return this.filterQuality;
    }

    private final Alignment component7() {
        return this.alignment;
    }

    private final ContentScale component8() {
        return this.contentScale;
    }

    private final float component9() {
        return this.alpha;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-3ECvelE$default  reason: not valid java name */
    public static /* synthetic */ ContentPainterElement m7763copy3ECvelE$default(ContentPainterElement contentPainterElement, ImageRequest imageRequest, ImageLoader imageLoader, AsyncImageModelEqualityDelegate asyncImageModelEqualityDelegate, Function1 function1, Function1 function12, int i, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, AsyncImagePreviewHandler asyncImagePreviewHandler, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            imageRequest = contentPainterElement.request;
        }
        return contentPainterElement.m7764copy3ECvelE(imageRequest, (i2 & 2) != 0 ? contentPainterElement.imageLoader : imageLoader, (i2 & 4) != 0 ? contentPainterElement.modelEqualityDelegate : asyncImageModelEqualityDelegate, (i2 & 8) != 0 ? contentPainterElement.transform : function1, (i2 & 16) != 0 ? contentPainterElement.onState : function12, (i2 & 32) != 0 ? contentPainterElement.filterQuality : i, (i2 & 64) != 0 ? contentPainterElement.alignment : alignment, (i2 & 128) != 0 ? contentPainterElement.contentScale : contentScale, (i2 & 256) != 0 ? contentPainterElement.alpha : f, (i2 & 512) != 0 ? contentPainterElement.colorFilter : colorFilter, (i2 & 1024) != 0 ? contentPainterElement.clipToBounds : z, (i2 & 2048) != 0 ? contentPainterElement.previewHandler : asyncImagePreviewHandler, (i2 & 4096) != 0 ? contentPainterElement.contentDescription : str);
    }

    /* renamed from: copy-3ECvelE  reason: not valid java name */
    public final ContentPainterElement m7764copy3ECvelE(ImageRequest imageRequest, ImageLoader imageLoader, AsyncImageModelEqualityDelegate asyncImageModelEqualityDelegate, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, int i, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, AsyncImagePreviewHandler asyncImagePreviewHandler, String str) {
        return new ContentPainterElement(imageRequest, imageLoader, asyncImageModelEqualityDelegate, function1, function12, i, alignment, contentScale, f, colorFilter, z, asyncImagePreviewHandler, str, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContentPainterElement) {
            ContentPainterElement contentPainterElement = (ContentPainterElement) obj;
            return Intrinsics.areEqual(this.request, contentPainterElement.request) && Intrinsics.areEqual(this.imageLoader, contentPainterElement.imageLoader) && Intrinsics.areEqual(this.modelEqualityDelegate, contentPainterElement.modelEqualityDelegate) && Intrinsics.areEqual(this.transform, contentPainterElement.transform) && Intrinsics.areEqual(this.onState, contentPainterElement.onState) && FilterQuality.m4173equalsimpl0(this.filterQuality, contentPainterElement.filterQuality) && Intrinsics.areEqual(this.alignment, contentPainterElement.alignment) && Intrinsics.areEqual(this.contentScale, contentPainterElement.contentScale) && Float.compare(this.alpha, contentPainterElement.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, contentPainterElement.colorFilter) && this.clipToBounds == contentPainterElement.clipToBounds && Intrinsics.areEqual(this.previewHandler, contentPainterElement.previewHandler) && Intrinsics.areEqual(this.contentDescription, contentPainterElement.contentDescription);
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int hashCode = ((((((this.request.hashCode() * 31) + this.imageLoader.hashCode()) * 31) + this.modelEqualityDelegate.hashCode()) * 31) + this.transform.hashCode()) * 31;
        Function1<AsyncImagePainter.State, Unit> function1 = this.onState;
        int hashCode2 = (((((((((hashCode + (function1 == null ? 0 : function1.hashCode())) * 31) + FilterQuality.m4174hashCodeimpl(this.filterQuality)) * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        int hashCode3 = (((hashCode2 + (colorFilter == null ? 0 : colorFilter.hashCode())) * 31) + Boolean.hashCode(this.clipToBounds)) * 31;
        AsyncImagePreviewHandler asyncImagePreviewHandler = this.previewHandler;
        int hashCode4 = (hashCode3 + (asyncImagePreviewHandler == null ? 0 : asyncImagePreviewHandler.hashCode())) * 31;
        String str = this.contentDescription;
        return hashCode4 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        ImageRequest imageRequest = this.request;
        ImageLoader imageLoader = this.imageLoader;
        AsyncImageModelEqualityDelegate asyncImageModelEqualityDelegate = this.modelEqualityDelegate;
        Function1<AsyncImagePainter.State, AsyncImagePainter.State> function1 = this.transform;
        Function1<AsyncImagePainter.State, Unit> function12 = this.onState;
        String m4175toStringimpl = FilterQuality.m4175toStringimpl(this.filterQuality);
        Alignment alignment = this.alignment;
        ContentScale contentScale = this.contentScale;
        float f = this.alpha;
        ColorFilter colorFilter = this.colorFilter;
        boolean z = this.clipToBounds;
        AsyncImagePreviewHandler asyncImagePreviewHandler = this.previewHandler;
        return "ContentPainterElement(request=" + imageRequest + ", imageLoader=" + imageLoader + ", modelEqualityDelegate=" + asyncImageModelEqualityDelegate + ", transform=" + function1 + ", onState=" + function12 + ", filterQuality=" + m4175toStringimpl + ", alignment=" + alignment + ", contentScale=" + contentScale + ", alpha=" + f + ", colorFilter=" + colorFilter + ", clipToBounds=" + z + ", previewHandler=" + asyncImagePreviewHandler + ", contentDescription=" + this.contentDescription + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ContentPainterElement(ImageRequest imageRequest, ImageLoader imageLoader, AsyncImageModelEqualityDelegate asyncImageModelEqualityDelegate, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, int i, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, AsyncImagePreviewHandler asyncImagePreviewHandler, String str) {
        this.request = imageRequest;
        this.imageLoader = imageLoader;
        this.modelEqualityDelegate = asyncImageModelEqualityDelegate;
        this.transform = function1;
        this.onState = function12;
        this.filterQuality = i;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
        this.clipToBounds = z;
        this.previewHandler = asyncImagePreviewHandler;
        this.contentDescription = str;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public ContentPainterNode create() {
        AsyncImagePainter.Input input = new AsyncImagePainter.Input(this.imageLoader, this.request, this.modelEqualityDelegate);
        AsyncImagePainter asyncImagePainter = new AsyncImagePainter(input);
        asyncImagePainter.setTransform$coil_compose_core_release(this.transform);
        asyncImagePainter.setOnState$coil_compose_core_release(this.onState);
        asyncImagePainter.setContentScale$coil_compose_core_release(this.contentScale);
        asyncImagePainter.m7738setFilterQualityvDHp3xo$coil_compose_core_release(this.filterQuality);
        asyncImagePainter.setPreviewHandler$coil_compose_core_release(this.previewHandler);
        asyncImagePainter.set_input$coil_compose_core_release(input);
        SizeResolver sizeResolver = this.request.getSizeResolver();
        return new ContentPainterNode(asyncImagePainter, this.alignment, this.contentScale, this.alpha, this.colorFilter, this.clipToBounds, this.contentDescription, sizeResolver instanceof ConstraintsSizeResolver ? (ConstraintsSizeResolver) sizeResolver : null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(ContentPainterNode contentPainterNode) {
        long mo4761getIntrinsicSizeNHjbRc = contentPainterNode.getPainter().mo4761getIntrinsicSizeNHjbRc();
        ConstraintsSizeResolver constraintSizeResolver = contentPainterNode.getConstraintSizeResolver();
        AsyncImagePainter.Input input = new AsyncImagePainter.Input(this.imageLoader, this.request, this.modelEqualityDelegate);
        AsyncImagePainter painter = contentPainterNode.getPainter();
        painter.setTransform$coil_compose_core_release(this.transform);
        painter.setOnState$coil_compose_core_release(this.onState);
        painter.setContentScale$coil_compose_core_release(this.contentScale);
        painter.m7738setFilterQualityvDHp3xo$coil_compose_core_release(this.filterQuality);
        painter.setPreviewHandler$coil_compose_core_release(this.previewHandler);
        painter.set_input$coil_compose_core_release(input);
        boolean m3902equalsimpl0 = Size.m3902equalsimpl0(mo4761getIntrinsicSizeNHjbRc, painter.mo4761getIntrinsicSizeNHjbRc());
        contentPainterNode.setAlignment(this.alignment);
        SizeResolver sizeResolver = this.request.getSizeResolver();
        contentPainterNode.setConstraintSizeResolver(sizeResolver instanceof ConstraintsSizeResolver ? (ConstraintsSizeResolver) sizeResolver : null);
        contentPainterNode.setContentScale(this.contentScale);
        contentPainterNode.setAlpha(this.alpha);
        contentPainterNode.setColorFilter(this.colorFilter);
        contentPainterNode.setClipToBounds(this.clipToBounds);
        if (!Intrinsics.areEqual(contentPainterNode.getContentDescription(), this.contentDescription)) {
            contentPainterNode.setContentDescription(this.contentDescription);
            SemanticsModifierNodeKt.invalidateSemantics(contentPainterNode);
        }
        boolean areEqual = Intrinsics.areEqual(constraintSizeResolver, contentPainterNode.getConstraintSizeResolver());
        if (!m3902equalsimpl0 || !areEqual) {
            LayoutModifierNodeKt.invalidateMeasurement(contentPainterNode);
        }
        DrawModifierNodeKt.invalidateDraw(contentPainterNode);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName(FirebaseAnalytics.Param.CONTENT);
        inspectorInfo.getProperties().set("request", this.request);
        inspectorInfo.getProperties().set("imageLoader", this.imageLoader);
        inspectorInfo.getProperties().set("modelEqualityDelegate", this.modelEqualityDelegate);
        inspectorInfo.getProperties().set("transform", this.transform);
        inspectorInfo.getProperties().set("onState", this.onState);
        inspectorInfo.getProperties().set("filterQuality", FilterQuality.m4170boximpl(this.filterQuality));
        inspectorInfo.getProperties().set("alignment", this.alignment);
        inspectorInfo.getProperties().set("contentScale", this.contentScale);
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.alpha));
        inspectorInfo.getProperties().set("colorFilter", this.colorFilter);
        inspectorInfo.getProperties().set("clipToBounds", Boolean.valueOf(this.clipToBounds));
        inspectorInfo.getProperties().set("previewHandler", this.previewHandler);
        inspectorInfo.getProperties().set("contentDescription", this.contentDescription);
    }
}
